/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Oracle;

import Data.ProjectData;
import Legacy.RoadNetworkImportXML;
import Model.Project;
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
public class ProjectDataOracle implements ProjectData {

	private Connection connection;

	public ProjectDataOracle(Connection connection) {
		this.connection = connection;
	}

	@Override
	public Integer size() {
		return this.all().size();
	}

	@Override
	public List<Project> all() {
		try {
			CallableStatement callableStatement = connection.
				prepareCall("BEGIN ALLPROJECTS(?); END;");
			callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
			callableStatement.execute();
			ResultSet rSet = (ResultSet) callableStatement.getObject(1);
			List<Project> projects = new ArrayList();
			while (rSet.next()) {
				Project project = new Project();
				project.setId(rSet.getInt("IDPROJECT"));
				project.setName(rSet.getString("NAME"));
				project.setDescription(rSet.getString("DESCRIPTION"));
				projects.add(project);
			}
			return projects;
		} catch (Exception ex) {
			Error.
				setErrorMessage("Oracle database was not possible to execute the command: " + ex);
			return null;
		}
	}

	@Override
	public Boolean save(Project project) {
		return false;
	}

	@Override
	public Project get(Integer id) {
		for (Project project : this.all()) {
			if (project.getId() == id) {
				try {
					CallableStatement callableStatement = connection.
						prepareCall("BEGIN EXPORTXMLPROJECT(?,?); END;");
					callableStatement.
						registerOutParameter(1, OracleTypes.VARCHAR);
					callableStatement.setInt(2, id);
					callableStatement.execute();
					RoadNetworkImportXML importClass = new RoadNetworkImportXML();
					List<Project> projects = importClass.
						importData(callableStatement.getString(1));
					if (projects != null && !projects.isEmpty()) {
						return projects.get(projects.size() - 1);
					}
				} catch (Exception ex) {
					Error.setErrorMessage(ex.toString());
					return null;
				}
				break;
			}
		}
		Error.
			setErrorMessage("Oracle database was not possible to execute the command: get(" + id);
		return null;
	}

	@Override
	public Boolean hasChanged(Project project) {
		Project oldProject = this.get(project.getId());
		return !oldProject.equals(project);
	}

}
