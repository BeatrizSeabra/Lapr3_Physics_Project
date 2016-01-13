/*
 * To change this license header, choose License Headers in Simulation Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Oracle;

import Model.Regime;
import Model.Throttle;
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
public class RegimeDataOracle {

	private Connection connection;

	/**
	 *
	 * @param connection
	 */
	public RegimeDataOracle(Connection connection) {
		this.connection = connection;
	}

	/**
	 *
	 * @param throttle
	 * @param regimes
	 * @return
	 */
	public Boolean save(Throttle throttle, List<Regime> regimes) {
		try {
			ArrayDescriptor oracleVarchar2Collection = ArrayDescriptor.
				createDescriptor("STRINGTABLE", this.connection);
			ArrayDescriptor oracleNumberCollection = ArrayDescriptor.
				createDescriptor("NUMBERTABLE", this.connection);
			CallableStatement callableStatement = connection.
				prepareCall("{ call saveRegimes(?,?,?,?,?,?,?,?,?,?) }");
			int size = regimes.size();
			double[] param01 = new double[size];
			double[] param02 = new double[size];
			double[] param03 = new double[size];
			String[] param04 = new String[size];
			double[] param05 = new double[size];
			String[] param06 = new String[size];
			double[] param07 = new double[size];
			String[] param08 = new String[size];
			double[] param09 = new double[size];
			String[] param10 = new String[size];
			for (int i = 0; i < size; i++) {
				param01[i] = 0;
				param02[i] = throttle.getId();
				param03[i] = regimes.get(i).getTorque().getValue();
				param04[i] = regimes.get(i).getTorque().getUnit();
				param05[i] = regimes.get(i).getRpmLow().getValue();
				param06[i] = regimes.get(i).getRpmLow().getUnit();
				param07[i] = regimes.get(i).getRpmHigh().getValue();
				param08[i] = regimes.get(i).getRpmHigh().getUnit();
				param09[i] = regimes.get(i).getFuelConsumption().getValue();
				param10[i] = regimes.get(i).getFuelConsumption().getUnit();
			}
			ARRAY param01O = new ARRAY(oracleNumberCollection, this.connection, param01);
			ARRAY param02O = new ARRAY(oracleNumberCollection, this.connection, param02);
			ARRAY param03O = new ARRAY(oracleNumberCollection, this.connection, param03);
			ARRAY param04O = new ARRAY(oracleVarchar2Collection, this.connection, param04);
			ARRAY param05O = new ARRAY(oracleNumberCollection, this.connection, param05);
			ARRAY param06O = new ARRAY(oracleVarchar2Collection, this.connection, param06);
			ARRAY param07O = new ARRAY(oracleNumberCollection, this.connection, param07);
			ARRAY param08O = new ARRAY(oracleVarchar2Collection, this.connection, param08);
			ARRAY param09O = new ARRAY(oracleNumberCollection, this.connection, param09);
			ARRAY param10O = new ARRAY(oracleVarchar2Collection, this.connection, param10);
			callableStatement.
				registerOutParameter(1, OracleTypes.ARRAY, "NUMBERTABLE");
			callableStatement.setObject(1, param01O, OracleTypes.ARRAY);
			callableStatement.setObject(2, param02O, OracleTypes.ARRAY);
			callableStatement.setObject(3, param03O, OracleTypes.ARRAY);
			callableStatement.setObject(4, param04O, OracleTypes.ARRAY);
			callableStatement.setObject(5, param05O, OracleTypes.ARRAY);
			callableStatement.setObject(6, param06O, OracleTypes.ARRAY);
			callableStatement.setObject(7, param07O, OracleTypes.ARRAY);
			callableStatement.setObject(8, param08O, OracleTypes.ARRAY);
			callableStatement.setObject(9, param09O, OracleTypes.ARRAY);
			callableStatement.setObject(10, param10O, OracleTypes.ARRAY);
			callableStatement.execute();
			ARRAY arrayIndex = ((OracleCallableStatement) callableStatement).
				getARRAY(1);
			int index[] = arrayIndex.getIntArray();
			callableStatement.close();
			for (int i = 0; i < size; i++) {
				System.out.println("REGIME INDEX: " + index[i]);
			}
			return true;
		} catch (Exception ex) {
			Error.
				setErrorMessage("Oracle database was not possible to execute the command: " + ex);
			return false;
		}
	}

}
