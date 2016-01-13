/*
 * To change this license header, choose License Headers in Simulation Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Oracle;

import Model.Vehicle;
import Physics.Measure;
import System.Error;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class VelocityLimitDataOracle {

	private Connection connection;

	public VelocityLimitDataOracle(Connection connection) {
		this.connection = connection;
	}

	public Boolean save(Vehicle vehicle, Map<String, Measure> limits) {
		try {
			ArrayDescriptor oracleVarchar2Collection = ArrayDescriptor.
				createDescriptor("STRINGTABLE", this.connection);
			ArrayDescriptor oracleNumberCollection = ArrayDescriptor.
				createDescriptor("NUMBERTABLE", this.connection);
			CallableStatement callableStatement = connection.
				prepareCall("{ call saveVelocityLimits(?,?,?,?,?) }");
			int size = limits.size();
			double[] param01 = new double[size];
			double[] param02 = new double[size];
			String[] param03 = new String[size];
			double[] param04 = new double[size];
			String[] param05 = new String[size];
			Iterator<Entry<String, Measure>> iterator = limits.entrySet().
				iterator();
			for (int i = 0; i < size; i++) {
				Entry<String, Measure> entry = iterator.next();
				param01[i] = 0;
				param02[i] = vehicle.getId();
				param03[i] = entry.getKey();
				param04[i] = entry.getValue().getValue();
				param05[i] = entry.getValue().getUnit();
			}
			ARRAY param01O = new ARRAY(oracleNumberCollection, this.connection, param01);
			ARRAY param02O = new ARRAY(oracleNumberCollection, this.connection, param02);
			ARRAY param03O = new ARRAY(oracleVarchar2Collection, this.connection, param03);
			ARRAY param04O = new ARRAY(oracleNumberCollection, this.connection, param04);
			ARRAY param05O = new ARRAY(oracleVarchar2Collection, this.connection, param05);
			callableStatement.
				registerOutParameter(1, OracleTypes.ARRAY, "NUMBERTABLE");
			callableStatement.setObject(1, param01O, OracleTypes.ARRAY);
			callableStatement.setObject(2, param02O, OracleTypes.ARRAY);
			callableStatement.setObject(3, param03O, OracleTypes.ARRAY);
			callableStatement.setObject(4, param04O, OracleTypes.ARRAY);
			callableStatement.setObject(5, param05O, OracleTypes.ARRAY);
			callableStatement.execute();
			ARRAY arrayIndex = ((OracleCallableStatement) callableStatement).
				getARRAY(1);
			int index[] = arrayIndex.getIntArray();
			callableStatement.close();
			for (int i = 0; i < size; i++) {
				System.out.println("VELOCITYLIMIT INDEX: " + index[i]);
			}
			return true;
		} catch (Exception ex) {
			Error.
				setErrorMessage("Oracle database was not possible to execute the command: " + ex);
			return false;
		}
	}

}
