/*
 * To change this license header, choose License Headers in Simulation Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Oracle;

import Data.RunData;
import Legacy.ResultsImportXML;
import Model.Run;
import Model.Simulation;
import System.Error;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class RunDataOracle implements RunData {

	private Connection connection;
	private DropDataOracle dropDataOracle;
	private StepDataOracle stepDataOracle;

	/**
	 *
	 * @param connection
	 */
	public RunDataOracle(Connection connection) {
		this.connection = connection;
		this.dropDataOracle = new DropDataOracle(connection);
		this.stepDataOracle = new StepDataOracle(connection);
	}

	/**
	 *
	 * @param project
	 * @return
	 */
	public Integer size(Simulation simulation) {
		return this.all(simulation).size();
	}

	/**
	 *
	 * @param project
	 * @return
	 */
	@Override
	public List<Run> all(Simulation simulation) {
		try {
			CallableStatement callableStatement = connection.
				prepareCall("BEGIN ALLRUNS(?,?); END;");
			callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
			callableStatement.setInt(2, simulation.getId());
			callableStatement.execute();
			ResultSet rSet = (ResultSet) callableStatement.getObject(1);
			List<Run> runs = new ArrayList();
			while (rSet.next()) {
				Run run = new Run();
				run.setId(rSet.getInt("IDRUN"));
				run.setName(rSet.getString("NAME"));
				runs.add(run);
			}
			return runs;
		} catch (Exception ex) {
			Error.
				setErrorMessage("Oracle database was not possible to execute the command: " + ex);
			return null;
		}
	}

	/**
	 *
	 * @param project
	 * @param simulation
	 * @return
	 */
	@Override
	public Boolean save(Simulation simulation, Run run) {
		List<Run> runs = new ArrayList();
		runs.add(run);
		return this.save(simulation, runs);
	}

	/**
	 *
	 * @return
	 */
	@Override
	public Boolean save(Simulation simulation, List<Run> runs) {
		try {
			ArrayDescriptor oracleVarchar2Collection = ArrayDescriptor.
				createDescriptor("STRINGTABLE", this.connection);
			ArrayDescriptor oracleNumberCollection = ArrayDescriptor.
				createDescriptor("NUMBERTABLE", this.connection);
			CallableStatement callableStatement = connection.
				prepareCall("{ call saveRuns(?,?,?,?,?,?,?,?) }");
			int size = runs.size();
			double[] param01 = new double[size];
			double[] param02 = new double[size];
			String[] param03 = new String[size];
			String[] param04 = new String[size];
			double[] param05 = new double[size];
			String[] param06 = new String[size];
			double[] param07 = new double[size];
			String[] param08 = new String[size];
			for (int i = 0; i < size; i++) {
				param01[i] = runs.get(i).getId();
				param02[i] = simulation.getId();
				param03[i] = runs.get(i).getName();
				param04[i] = runs.get(i).getMethod().getName();
				param05[i] = runs.get(i).getTime().getValue();
				param06[i] = runs.get(i).getTime().getUnit();
				param07[i] = runs.get(i).getTimeStep().getValue();
				param08[i] = runs.get(i).getTimeStep().getUnit();
			}
			ARRAY param01O = new ARRAY(oracleNumberCollection, this.connection, param01);
			ARRAY param02O = new ARRAY(oracleNumberCollection, this.connection, param02);
			ARRAY param03O = new ARRAY(oracleVarchar2Collection, this.connection, param03);
			ARRAY param04O = new ARRAY(oracleVarchar2Collection, this.connection, param04);
			ARRAY param05O = new ARRAY(oracleNumberCollection, this.connection, param05);
			ARRAY param06O = new ARRAY(oracleVarchar2Collection, this.connection, param06);
			ARRAY param07O = new ARRAY(oracleNumberCollection, this.connection, param07);
			ARRAY param08O = new ARRAY(oracleVarchar2Collection, this.connection, param08);
			callableStatement.
				registerOutParameter(1, OracleTypes.ARRAY, "NUMBERTABLE");
			callableStatement.setObject(1, param01O, OracleTypes.ARRAY);
			callableStatement.setObject(2, param02O, OracleTypes.ARRAY);
			callableStatement.setObject(3, param03O, OracleTypes.ARRAY);
			callableStatement.setObject(4, param04O, OracleTypes.ARRAY);
			callableStatement.setObject(5, param05O, OracleTypes.ARRAY);
			callableStatement.setObject(6, param06O, OracleTypes.ARRAY);
			callableStatement.setObject(7, param07O, OracleTypes.ARRAY);
			callableStatement.setObject(8, param08O, OracleTypes.ARRAY);
			callableStatement.execute();
			ARRAY arrayIndex = ((OracleCallableStatement) callableStatement).
				getARRAY(1);
			int index[] = arrayIndex.getIntArray();
			callableStatement.close();
			for (int i = 0; i < size; i++) {
				System.out.println("RUN INDEX: " + index[i]);
				runs.get(i).setId(index[i]);
				if (index[i] != 0) {
					if (!runs.get(i).getDrops().isEmpty()) {
						this.dropDataOracle.
							save(runs.get(i), runs.get(i).getDrops());
					}
					if (!runs.get(i).getSteps().isEmpty()) {
						this.stepDataOracle.
							save(runs.get(i), runs.get(i).getSteps());
					}
				}
			}
			return true;
		} catch (Exception ex) {
			Error.
				setErrorMessage("Oracle database was not possible to execute the command: " + ex);
			return false;
		}
	}

	/**
	 *
	 * @param simulation
	 * @return
	 */
	@Override
	public Run get(Simulation simulation, Run run) {
		if (run.getId() != 0) {
			try {
				CallableStatement callableStatement = connection.
					prepareCall("{ call ? := exportXMLRuns(?) }");
				callableStatement.
					registerOutParameter(1, OracleTypes.VARCHAR);
				callableStatement.setInt(2, simulation.getId());
				callableStatement.execute();
				ResultsImportXML importClass = new ResultsImportXML();
				List<Run> runs = importClass.
					importData(callableStatement.getString(1));
				if (runs != null && !runs.isEmpty()) {
					return runs.get(runs.size() - 1);
				}
			} catch (Exception ex) {
				Error.setErrorMessage(ex.toString());
				return null;
			}
		}
		Error.
			setErrorMessage("Oracle database was not possible to execute the command: get:" + simulation);
		return null;
	}

	/**
	 *
	 * @param simulation
	 * @return
	 */
	@Override
	public Boolean hasChanged(Simulation simulation, Run run) {
		Run oldRun = this.get(simulation, run);
		return !oldRun.equals(run);
	}

	@Override
	public Boolean remove(Simulation simulation, Run run) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
