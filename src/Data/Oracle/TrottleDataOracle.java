/*
 * To change this license header, choose License Headers in Simulation Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Oracle;

import Model.Throttle;
import Model.Vehicle;
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
public class TrottleDataOracle {

	private Connection connection;
	private RegimeDataOracle regimeDataOracle;

	public TrottleDataOracle(Connection connection) {
		this.connection = connection;
		this.regimeDataOracle = new RegimeDataOracle(connection);
	}

	public Boolean save(Vehicle vehicle, List<Throttle> throttles) {
		try {
			ArrayDescriptor oracleVarchar2Collection = ArrayDescriptor.
				createDescriptor("STRINGTABLE", this.connection);
			ArrayDescriptor oracleNumberCollection = ArrayDescriptor.
				createDescriptor("NUMBERTABLE", this.connection);
			CallableStatement callableStatement = connection.
				prepareCall("{ call saveTrottles(?,?,?,?) }");
			int size = throttles.size();
			double[] param01 = new double[size];
			double[] param02 = new double[size];
			double[] param03 = new double[size];
			String[] param04 = new String[size];
			for (int i = 0; i < size; i++) {
				param01[i] = throttles.get(i).getId();
				param02[i] = vehicle.getId();
				param03[i] = throttles.get(i).getPercentage().getValue();
				param04[i] = throttles.get(i).getPercentage().getUnit();
			}
			ARRAY param01O = new ARRAY(oracleNumberCollection, this.connection, param01);
			ARRAY param02O = new ARRAY(oracleNumberCollection, this.connection, param02);
			ARRAY param03O = new ARRAY(oracleNumberCollection, this.connection, param03);
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
			callableStatement.close();
			int index[] = arrayIndex.getIntArray();
			for (int i = 0; i < size; i++) {
				System.out.println("THROTTLE INDEX: " + index[i]);
				throttles.get(i).setId(index[i]);
				if (index[i] != 0 && !throttles.get(i).getRegimes().isEmpty()) {
					this.regimeDataOracle.save(throttles.get(i), throttles.
											   get(i).getRegimes());
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
