/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import System.Error;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class Main {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		/*
		 String url = "jdbc:oracle:thin:LAPR3_27/umasenhaimportante@gandalf.dei.isep.ipp.pt:1521/pdborcl";
		 OracleDataSource oracleDataSource = new OracleDataSource();
		 oracleDataSource.setURL(url);
		 System.out.println("\nEstabelecer a ligação à BD...");
		 Connection connection = oracleDataSource.getConnection();
		 System.out.println("\t... Ligação obtida.");
		 CallableStatement callStmt = connection.
		 prepareCall("BEGIN teste(?); END;");
		 callStmt.registerOutParameter(1, OracleTypes.VARCHAR);
		 callStmt.execute();
		 System.out.println(callStmt.getString(1));
		 callStmt = connection.prepareCall("BEGIN GETNEXTINDEX(?); END;");
		 callStmt.registerOutParameter(1, OracleTypes.NUMBER);
		 callStmt.execute();
		 System.out.println(callStmt.getInt(1));
		 callStmt = connection.prepareCall("BEGIN ALLPROJECTS(?,?); END;");
		 callStmt.registerOutParameter(1, OracleTypes.CURSOR);
		 callStmt.setInt(2, 1);
		 callStmt.execute();
		 ResultSet rSet = (ResultSet) callStmt.getObject(1);
		 List<Project> projects = new ArrayList();
		 while (rSet.next()) {
		 Project project = new Project();
		 project.setId(rSet.getInt("IDPROJECT"));
		 project.setName(rSet.getString("NAME"));
		 project.setDescription(rSet.getString("DESCRIPTION"));
		 projects.add(project);
		 }
		 for (Project project : projects) {
		 System.out.
		 println(project.getId() + " " + project.getName() + " " + project.
		 getDescription());
		 }
		 connection.close();
		 oracleDataSource = null;
		 */
		try {
			Error.clearLog();
			new ApplicationGUI();
			Data.Data.getProjectData().get(1);
		} catch (Exception ex) {
			Error.setErrorMessage("ERROR: " + ex);
		}

	}
}
