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
import oracle.jdbc.OracleTypes;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class SimulationDataOracle implements SimulationData {

	private Connection connection;

	public SimulationDataOracle(Connection connection) {
		this.connection = connection;
	}

	@Override
	public Integer size(Project project) {
		return this.all(project).size();
	}

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

	@Override
	public Boolean save(Project project, Simulation simulation) {
		return false;
	}

	@Override
	public Simulation get(Project project, Simulation simulation) {
		for (Simulation simulationList : this.all(project)) {
			if (simulationList.getId() == simulation.getId()) {
				try {
					CallableStatement callableStatement = connection.
						prepareCall("BEGIN EXPORTXMLSIMULATION(?,?); END;");
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
				break;
			}
		}
		Error.
			setErrorMessage("Oracle database was not possible to execute the command: get:" + simulation);
		return null;
	}

	@Override
	public Boolean hasChanged(Project project, Simulation simulation) {
		Simulation oldSimulation = this.get(project, simulation);
		return !oldSimulation.equals(simulation);
	}

}
