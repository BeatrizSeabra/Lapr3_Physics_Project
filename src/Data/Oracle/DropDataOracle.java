/*
 * To change this license header, choose License Headers in Simulation Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Oracle;

import Legacy.ResultsImportXML;
import Model.Drop;
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
public class DropDataOracle {

	private Connection connection;
	private TrafficDataOracle trafficDataOracle;

	/**
	 *
	 * @param connection
	 */
	public DropDataOracle(Connection connection) {
		this.connection = connection;
		this.trafficDataOracle = new TrafficDataOracle(connection);
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
	public Boolean save(Run run, Drop drop) {
		List<Drop> drops = new ArrayList();
		drops.add(drop);
		return this.save(run, drops);
	}

	/**
	 *
	 * @return
	 */
	public Boolean save(Run run, List<Drop> drops) {
		try {
			ArrayDescriptor oracleVarchar2Collection = ArrayDescriptor.
				createDescriptor("STRINGTABLE", this.connection);
			ArrayDescriptor oracleNumberCollection = ArrayDescriptor.
				createDescriptor("NUMBERTABLE", this.connection);
			CallableStatement callableStatement = connection.
				prepareCall("{ call saveDrops(?,?,?,?,?,?) }");
			int size = drops.size();
			double[] param01 = new double[size];
			double[] param02 = new double[size];
			String[] param03 = new String[size];
			String[] param04 = new String[size];
			String[] param05 = new String[size];
			String[] param06 = new String[size];
			for (int i = 0; i < size; i++) {
				param01[i] = 0;
				param02[i] = run.getId();
				param03[i] = drops.get(i).getVehicle();
				param04[i] = drops.get(i).getTime().toString();
				param05[i] = drops.get(i).getNodeStart();
				param06[i] = drops.get(i).getNodeEnd();
			}
			ARRAY param01O = new ARRAY(oracleNumberCollection, this.connection, param01);
			ARRAY param02O = new ARRAY(oracleNumberCollection, this.connection, param02);
			ARRAY param03O = new ARRAY(oracleVarchar2Collection, this.connection, param03);
			ARRAY param04O = new ARRAY(oracleVarchar2Collection, this.connection, param04);
			ARRAY param05O = new ARRAY(oracleVarchar2Collection, this.connection, param05);
			ARRAY param06O = new ARRAY(oracleVarchar2Collection, this.connection, param06);
			callableStatement.
				registerOutParameter(1, OracleTypes.ARRAY, "NUMBERTABLE");
			callableStatement.setObject(1, param01O, OracleTypes.ARRAY);
			callableStatement.setObject(2, param02O, OracleTypes.ARRAY);
			callableStatement.setObject(3, param03O, OracleTypes.ARRAY);
			callableStatement.setObject(4, param04O, OracleTypes.ARRAY);
			callableStatement.setObject(5, param05O, OracleTypes.ARRAY);
			callableStatement.setObject(6, param06O, OracleTypes.ARRAY);
			callableStatement.execute();
			ARRAY arrayIndex = ((OracleCallableStatement) callableStatement).
				getARRAY(1);
			int index[] = arrayIndex.getIntArray();
			callableStatement.close();
			for (int i = 0; i < size; i++) {
				System.out.println("DROP INDEX: " + index[i]);
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
	public Boolean hasChanged(Simulation simulation, Run run) {
		Run oldRun = this.get(simulation, run);
		return !oldRun.equals(run);
	}

}
