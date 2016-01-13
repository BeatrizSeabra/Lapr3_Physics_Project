/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Oracle;

import Data.ProjectData;
import Legacy.Import;
import Legacy.RoadNetworkImportXML;
import Legacy.SimulationImportXML;
import Legacy.VehicleImportXML;
import Model.Project;
import Model.Simulation;
import Model.Vehicle;
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
public class ProjectDataOracle implements ProjectData {

	private Connection connection;
	private NodeDataOracle nodeDataOracle;
	private SectionDataOracle sectionDataOracle;

	/**
	 *
	 * @param connection
	 */
	public ProjectDataOracle(Connection connection) {
		this.connection = connection;
		this.nodeDataOracle = new NodeDataOracle(connection);
		this.sectionDataOracle = new SectionDataOracle(connection);
	}

	/**
	 *
	 * @return
	 */
	@Override
	public Integer size() {
		return this.all().size();
	}

	/**
	 *
	 * @return
	 */
	@Override
	public List<Project> all() {
		try {
			CallableStatement callableStatement = connection.
				prepareCall("BEGIN ALLPROJECTS(?); END;");
			callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
			callableStatement.execute();
			ResultSet resultSet = (ResultSet) callableStatement.getObject(1);
			List<Project> projects = new ArrayList();
			while (resultSet.next()) {
				Project project = new Project();
				project.setId(resultSet.getInt("IDPROJECT"));
				project.setName(resultSet.getString("NAME"));
				project.setDescription(resultSet.getString("DESCRIPTION"));
				projects.add(project);
			}
			return projects;
		} catch (Exception ex) {
			Error.
				setErrorMessage("Oracle database was not possible to execute the command: " + ex);
			return null;
		}
	}

	/**
	 *
	 * @param project
	 * @return
	 */
	@Override
	public Boolean save(Project project) {
		List<Project> projects = new ArrayList();
		projects.add(project);
		return this.save(projects);
	}

	/**
	 *
	 * @param projects
	 * @return
	 */
	@Override
	public Boolean save(List<Project> projects) {
		try {
			ArrayDescriptor oracleVarchar2Collection = ArrayDescriptor.
				createDescriptor("STRINGTABLE", this.connection);
			ArrayDescriptor oracleNumberCollection = ArrayDescriptor.
				createDescriptor("NUMBERTABLE", this.connection);
			CallableStatement callableStatement = connection.
				prepareCall("{ call saveProjects(?,?,?) }");
			int size = projects.size();
			int[] param01 = new int[size];
			String[] param02 = new String[size];
			String[] param03 = new String[size];
			for (int i = 0; i < size; i++) {
				param01[i] = projects.get(i).getId();
				param02[i] = projects.get(i).getName();
				param03[i] = projects.get(i).getDescription();
			}
			ARRAY param01O = new ARRAY(oracleNumberCollection, this.connection, param01);
			ARRAY param02O = new ARRAY(oracleVarchar2Collection, this.connection, param02);
			ARRAY param03O = new ARRAY(oracleVarchar2Collection, this.connection, param03);
			callableStatement.
				registerOutParameter(1, OracleTypes.ARRAY, "NUMBERTABLE");
			callableStatement.setObject(1, param01O, OracleTypes.ARRAY);
			callableStatement.setObject(2, param02O, OracleTypes.ARRAY);
			callableStatement.setObject(3, param03O, OracleTypes.ARRAY);
			callableStatement.execute();
			ARRAY arrayIndex = ((OracleCallableStatement) callableStatement).
				getARRAY(1);
			int index[] = arrayIndex.getIntArray();
			callableStatement.close();
			for (int i = 0; i < size; i++) {
				System.out.println("PROJECT INDEX: " + index[i]);
				projects.get(i).setId(index[i]);
				if (index[i] != 0 && !projects.get(i).getRoadNetwork().
					getNodes().isEmpty()) {
					this.nodeDataOracle.save(projects.get(i), projects.get(i).
											 getRoadNetwork().getNodes());
				}
				if (index[i] != 0 && !projects.get(i).getRoadNetwork().
					getSections().isEmpty()) {
					this.sectionDataOracle.
						save(projects.get(i), projects.get(i).getRoadNetwork().
							 getSections());
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
	 * @return
	 */
	@Override
	public Project get(Project project) {
		if (project.getId() != 0) {
			try {
				CallableStatement callableStatement = connection.
					prepareCall("BEGIN EXPORTXMLPROJECTS(?,?); END;");
				callableStatement.
					registerOutParameter(1, OracleTypes.VARCHAR);
				callableStatement.setInt(2, project.getId());
				callableStatement.execute();
				String result = callableStatement.getString(1);
				System.out.println("PROJECT:\"" + result + "\"");
				Import importClass = new RoadNetworkImportXML();
				List<Project> projects = importClass.importData(result);
				if (projects != null && !projects.isEmpty()) {
					Project newProject = projects.get(projects.size() - 1);
					callableStatement = connection.
						prepareCall("BEGIN EXPORTXMLVEHICLES(?,?); END;");
					callableStatement.
						registerOutParameter(1, OracleTypes.VARCHAR);
					callableStatement.setInt(2, newProject.getId());
					callableStatement.execute();
					result = callableStatement.getString(1);
					System.out.println("VEHICLES:\"" + result + "\"");
					if (result != null && !result.isEmpty()) {
						importClass = new VehicleImportXML();
						System.out.
							println("\"" + callableStatement.getString(1) + "\"");
						List<Vehicle> vehicles = importClass.
							importData(callableStatement.getString(1));
						for (Vehicle vehicle : vehicles) {
							newProject.addVehicle(vehicle);
						}
					}
					callableStatement = connection.
						prepareCall("BEGIN EXPORTXMLSIMULATIONS(?,?); END;");
					callableStatement.
						registerOutParameter(1, OracleTypes.VARCHAR);
					callableStatement.setInt(2, newProject.getId());
					callableStatement.execute();
					result = callableStatement.getString(1);
					System.out.println("SIMULATINS:\"" + result + "\"");
					if (result != null && !result.isEmpty()) {
						importClass = new SimulationImportXML();
						List<Simulation> simulations = importClass.
							importData(result);
						for (Simulation simulation : simulations) {
							newProject.addSimulation(simulation);
						}
					}
					return newProject;
				}
			} catch (Exception ex) {
				Error.setErrorMessage(ex.toString());
				return null;
			}
		}
		Error.
			setErrorMessage("Oracle database was not possible to execute the command: get " + project);
		return null;
	}

	/**
	 *
	 * @param project
	 * @return
	 */
	@Override
	public Boolean hasChanged(Project project
	) {
		Project oldProject = this.get(project);
		return !oldProject.equals(project);
	}

}
