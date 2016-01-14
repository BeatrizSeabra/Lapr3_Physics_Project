/*
 * To change this license header, choose License Headers in Simulation Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Oracle;

import Data.SimulationData;
import Legacy.SimulationImportXML;
import Model.Project;
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
public class SimulationDataOracle implements SimulationData {

	private Connection connection;
	private TrafficDataOracle trafficDataOracle;

	/**
	 *
	 * @param connection
	 */
	public SimulationDataOracle(Connection connection) {
		this.connection = connection;
		this.trafficDataOracle = new TrafficDataOracle(connection);
	}

	/**
	 *
	 * @param project
	 * @return
	 */
	@Override
	public Integer size(Project project) {
		return this.all(project).size();
	}

	/**
	 *
	 * @param project
	 * @return
	 */
	@Override
	public List<Simulation> all(Project project) {
		try {
			CallableStatement callableStatement = connection.
				prepareCall("BEGIN ALLSIMULATIONS(?,?); END;");
			callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
			callableStatement.setInt(2, project.getId());
			callableStatement.execute();
			ResultSet rSet = (ResultSet) callableStatement.getObject(1);
			List<Simulation> simulations = new ArrayList();
			while (rSet.next()) {
				Simulation simulation = new Simulation();
				simulation.setId(rSet.getInt("IDSIMULATION"));
				simulation.setName(rSet.getString("NAME"));
				simulation.setDescription(rSet.getString("DESCRIPTION"));
				simulations.add(simulation);
			}
			return simulations;
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
	public Boolean save(Project project, Simulation simulation) {
		List<Simulation> simulations = new ArrayList();
		simulations.add(simulation);
		return this.save(project, simulations);
	}

	/**
	 *
	 * @param project
	 * @param simulations
	 * @return
	 */
	@Override
	public Boolean save(Project project, List<Simulation> simulations) {
		try {
			ArrayDescriptor oracleVarchar2Collection = ArrayDescriptor.
				createDescriptor("STRINGTABLE", this.connection);
			ArrayDescriptor oracleNumberCollection = ArrayDescriptor.
				createDescriptor("NUMBERTABLE", this.connection);
			CallableStatement callableStatement = connection.
				prepareCall("{ call saveSimulations(?,?,?,?) }");
			int size = simulations.size();
			double[] param01 = new double[size];
			double[] param02 = new double[size];
			String[] param03 = new String[size];
			String[] param04 = new String[size];
			for (int i = 0; i < size; i++) {
				param01[i] = simulations.get(i).getId();
				param02[i] = project.getId();
				param03[i] = simulations.get(i).getName();
				param04[i] = simulations.get(i).getDescription();
			}
			ARRAY param01O = new ARRAY(oracleNumberCollection, this.connection, param01);
			ARRAY param02O = new ARRAY(oracleNumberCollection, this.connection, param02);
			ARRAY param03O = new ARRAY(oracleVarchar2Collection, this.connection, param03);
			ARRAY param04O = new ARRAY(oracleVarchar2Collection, this.connection, param04);
			callableStatement.
				registerOutParameter(1, OracleTypes.ARRAY, "NUMBERTABLE");
			callableStatement.setObject(1, param01O, OracleTypes.ARRAY);
			callableStatement.setObject(2, param02O, OracleTypes.ARRAY);
			callableStatement.setObject(3, param03O, OracleTypes.ARRAY);
			callableStatement.setObject(4, param04O, OracleTypes.ARRAY);
			callableStatement.execute();
			ARRAY arrayIndex = ((OracleCallableStatement) callableStatement).
				getARRAY(1);
			int index[] = arrayIndex.getIntArray();
			callableStatement.close();
			for (int i = 0; i < size; i++) {
				System.out.println("SIULATION INDEX: " + index[i]);
				simulations.get(i).setId(index[i]);
				if (index[i] != 0 && !simulations.get(i).getTraffics().isEmpty()) {
					this.trafficDataOracle.save(simulations.get(i), simulations.
												get(i).getTraffics());
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
	 * @param project
	 * @param simulation
	 * @return
	 */
	@Override
	public Simulation get(Project project, Simulation simulation) {
		if (simulation.getId() != 0) {
			try {
				CallableStatement callableStatement = connection.
					prepareCall("{ call ? := exportXMLSimulations(?) }");
				callableStatement.
					registerOutParameter(1, OracleTypes.VARCHAR);
				callableStatement.setInt(2, simulation.getId());
				callableStatement.execute();
				SimulationImportXML importClass = new SimulationImportXML();
				List<Simulation> simulations = importClass.
					importData(callableStatement.getString(1));
				if (simulations != null && !simulations.isEmpty()) {
					return simulations.get(simulations.size() - 1);
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
	 * @param project
	 * @param simulation
	 * @return
	 */
	@Override
	public Boolean hasChanged(Project project, Simulation simulation) {
		Simulation oldSimulation = this.get(project, simulation);
		return !oldSimulation.equals(simulation);
	}

}
