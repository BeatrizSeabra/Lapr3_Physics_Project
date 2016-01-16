/*
 * To change this license header, choose License Headers in Simulation Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Oracle;

import Model.Node;
import Model.Project;
import System.Error;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.List;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class NodeDataOracle {

	private Connection connection;

	/**
	 *
	 * @param connection
	 */
	public NodeDataOracle(Connection connection) {
		this.connection = connection;
	}

	/**
	 *
	 * @param project
	 * @param nodes
	 * @return
	 */
	public Boolean save(Project project, List<Node> nodes) {
		try {
			ArrayDescriptor oracleVarchar2Collection = ArrayDescriptor.
				createDescriptor("STRINGTABLE", this.connection);
			ArrayDescriptor oracleNumberCollection = ArrayDescriptor.
				createDescriptor("NUMBERTABLE", this.connection);
			CallableStatement callableStatement = connection.
				prepareCall("{ call saveNodes(?,?,?) }");
			int size = nodes.size();
			System.out.println("AQUIIIII SIZE = " + size);
			double[] param01 = new double[size];
			double[] param02 = new double[size];
			String[] param03 = new String[size];
			for (int i = 0; i < size; i++) {
				param01[i] = nodes.get(i).getId();
				param02[i] = project.getId();
				param03[i] = nodes.get(i).getName();
			}
			ARRAY param01O = new ARRAY(oracleNumberCollection, this.connection, param01);
			ARRAY param02O = new ARRAY(oracleNumberCollection, this.connection, param02);
			ARRAY param03O = new ARRAY(oracleVarchar2Collection, this.connection, param03);
			callableStatement.
				registerOutParameter(1, OracleTypes.ARRAY, "NUMBERTABLE");
			callableStatement.setObject(1, param01O, OracleTypes.ARRAY);
			callableStatement.setObject(2, param02O, OracleTypes.ARRAY);
			callableStatement.setObject(3, param03O, OracleTypes.ARRAY);
			callableStatement.execute();
			ARRAY arrayIndex = ((OracleCallableStatement) callableStatement).
				getARRAY(1);
			callableStatement.close();
			int index[] = arrayIndex.getIntArray();
			for (int i = 0; i < size; i++) {
				System.out.println("NODE INDEX: " + index[i]);
				nodes.get(i).setId(index[i]);
				for (Node node : project.getRoadNetwork().getNodes()) {
					if (node.getName().equalsIgnoreCase(nodes.get(i).getName())) {
						node.setId(index[i]);
						System.out.
							println("INDEX NODE " + node.getName() + " = " + node.
								getId());
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

}
