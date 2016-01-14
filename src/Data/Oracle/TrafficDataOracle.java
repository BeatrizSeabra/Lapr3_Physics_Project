/*
 * To change this license header, choose License Headers in Simulation Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Oracle;

import Model.Simulation;
import Model.Traffic;
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
public class TrafficDataOracle {

	private Connection connection;

	/**
	 *
	 * @param connection
	 */
	public TrafficDataOracle(Connection connection) {
		this.connection = connection;
	}

	/**
	 *
	 * @param simulation
	 * @param traffics
	 * @return
	 */
	public Boolean save(Simulation simulation, List<Traffic> traffics) {
		try {
			ArrayDescriptor oracleVarchar2Collection = ArrayDescriptor.
				createDescriptor("STRINGTABLE", this.connection);
			ArrayDescriptor oracleNumberCollection = ArrayDescriptor.
				createDescriptor("NUMBERTABLE", this.connection);
			CallableStatement callableStatement = connection.
				prepareCall("{ call saveTraffics(?,?,?,?,?,?,?) }");
			int size = traffics.size();
			double[] param01 = new double[size];
			double[] param02 = new double[size];
			double[] param03 = new double[size];
			double[] param04 = new double[size];
			double[] param05 = new double[size];
			double[] param06 = new double[size];
			String[] param07 = new String[size];
			for (int i = 0; i < size; i++) {
				param01[i] = 0;
				param02[i] = simulation.getId();
				param03[i] = traffics.get(i).getNodeStart().getId();
				param04[i] = traffics.get(i).getNodeEnd().getId();
				param05[i] = traffics.get(i).getVehicle().getId();
				param06[i] = traffics.get(i).getArrivalRate().getValue();
				param07[i] = traffics.get(i).getArrivalRate().getUnit();
			}
			ARRAY param01O = new ARRAY(oracleNumberCollection, this.connection, param01);
			ARRAY param02O = new ARRAY(oracleNumberCollection, this.connection, param02);
			ARRAY param03O = new ARRAY(oracleNumberCollection, this.connection, param03);
			ARRAY param04O = new ARRAY(oracleNumberCollection, this.connection, param04);
			ARRAY param05O = new ARRAY(oracleNumberCollection, this.connection, param05);
			ARRAY param06O = new ARRAY(oracleNumberCollection, this.connection, param06);
			ARRAY param07O = new ARRAY(oracleVarchar2Collection, this.connection, param07);
			callableStatement.
				registerOutParameter(1, OracleTypes.ARRAY, "NUMBERTABLE");
			callableStatement.setObject(1, param01O, OracleTypes.ARRAY);
			callableStatement.setObject(2, param02O, OracleTypes.ARRAY);
			callableStatement.setObject(3, param03O, OracleTypes.ARRAY);
			callableStatement.setObject(4, param04O, OracleTypes.ARRAY);
			callableStatement.setObject(5, param05O, OracleTypes.ARRAY);
			callableStatement.setObject(6, param06O, OracleTypes.ARRAY);
			callableStatement.setObject(7, param07O, OracleTypes.ARRAY);
			callableStatement.execute();
			ARRAY arrayIndex = ((OracleCallableStatement) callableStatement).
				getARRAY(1);
			int index[] = arrayIndex.getIntArray();
			for (int i = 0; i < size; i++) {
				System.out.println("TRAFFIC INDEX: " + index[i]);
			}
			return true;
		} catch (Exception ex) {
			Error.
				setErrorMessage("Oracle database was not possible to execute the command: " + ex);
			return false;
		}
	}

}
