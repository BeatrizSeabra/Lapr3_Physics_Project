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

	public ProjectDataOracle(Connection connection) {
		this.connection = connection;
		this.nodeDataOracle = new NodeDataOracle(connection);
		this.sectionDataOracle = new SectionDataOracle(connection);
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
		List<Project> projects = new ArrayList();
		projects.add(project);
		return this.save(projects);
	}

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

	@Override
	public Project get(Project project
	) {
		for (Project projectList : this.all()) {
			if (projectList.getId() == project.getId()) {
				try {
					CallableStatement callableStatement = connection.
						prepareCall("BEGIN EXPORTXMLPROJECT(?,?); END;");
					callableStatement.
						registerOutParameter(1, OracleTypes.VARCHAR);
					callableStatement.setInt(2, project.getId());
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
			setErrorMessage("Oracle database was not possible to execute the command: get " + project);
		return null;
	}

	@Override
	public Boolean hasChanged(Project project
	) {
		Project oldProject = this.get(project);
		return !oldProject.equals(project);
	}

}
