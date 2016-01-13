/*
 * To change this license header, choose License Headers in Simulation Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Oracle;

import Model.Section;
import Model.Segment;
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
public class SegmentDataOracle {

	private Connection connection;

	public SegmentDataOracle(Connection connection) {
		this.connection = connection;
	}

	public Boolean save(Section section, List<Segment> segments) {
		try {
			ArrayDescriptor oracleVarchar2Collection = ArrayDescriptor.
				createDescriptor("STRINGTABLE", this.connection);
			ArrayDescriptor oracleNumberCollection = ArrayDescriptor.
				createDescriptor("NUMBERTABLE", this.connection);
			CallableStatement callableStatement = connection.
				prepareCall("{ call saveSegments(?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
			int size = segments.size();
			double[] param01 = new double[size];
			double[] param02 = new double[size];
			String[] param03 = new String[size];
			double[] param04 = new double[size];
			String[] param05 = new String[size];
			double[] param06 = new double[size];
			String[] param07 = new String[size];
			double[] param08 = new double[size];
			String[] param09 = new String[size];
			double[] param10 = new double[size];
			String[] param11 = new String[size];
			double[] param12 = new double[size];
			String[] param13 = new String[size];
			double[] param14 = new double[size];
			for (int i = 0; i < size; i++) {
				param01[i] = 0;
				param02[i] = section.getId();
				param03[i] = segments.get(i).getName();
				param04[i] = segments.get(i).getHeight().getValue();
				param05[i] = segments.get(i).getHeight().getUnit();
				param06[i] = segments.get(i).getSlope().getValue();
				param07[i] = segments.get(i).getSlope().getUnit();
				param08[i] = segments.get(i).getLength().getValue();
				param09[i] = segments.get(i).getLength().getUnit();
				param10[i] = segments.get(i).getMaxVelocity().getValue();
				param11[i] = segments.get(i).getMaxVelocity().getUnit();
				param12[i] = segments.get(i).getMinVelocity().getValue();
				param13[i] = segments.get(i).getMinVelocity().getUnit();
				param14[i] = segments.get(i).getNumberVehicles();
			}
			ARRAY param01O = new ARRAY(oracleNumberCollection, this.connection, param01);
			ARRAY param02O = new ARRAY(oracleNumberCollection, this.connection, param02);
			ARRAY param03O = new ARRAY(oracleVarchar2Collection, this.connection, param03);
			ARRAY param04O = new ARRAY(oracleNumberCollection, this.connection, param04);
			ARRAY param05O = new ARRAY(oracleVarchar2Collection, this.connection, param05);
			ARRAY param06O = new ARRAY(oracleNumberCollection, this.connection, param06);
			ARRAY param07O = new ARRAY(oracleVarchar2Collection, this.connection, param07);
			ARRAY param08O = new ARRAY(oracleNumberCollection, this.connection, param08);
			ARRAY param09O = new ARRAY(oracleVarchar2Collection, this.connection, param09);
			ARRAY param10O = new ARRAY(oracleNumberCollection, this.connection, param10);
			ARRAY param11O = new ARRAY(oracleVarchar2Collection, this.connection, param11);
			ARRAY param12O = new ARRAY(oracleNumberCollection, this.connection, param12);
			ARRAY param13O = new ARRAY(oracleVarchar2Collection, this.connection, param13);
			ARRAY param14O = new ARRAY(oracleNumberCollection, this.connection, param14);
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
			callableStatement.setObject(11, param11O, OracleTypes.ARRAY);
			callableStatement.setObject(12, param12O, OracleTypes.ARRAY);
			callableStatement.setObject(13, param13O, OracleTypes.ARRAY);
			callableStatement.setObject(14, param14O, OracleTypes.ARRAY);
			callableStatement.execute();
			ARRAY arrayIndex = ((OracleCallableStatement) callableStatement).
				getARRAY(1);
			int index[] = arrayIndex.getIntArray();
			callableStatement.close();
			for (int i = 0; i < size; i++) {
				System.out.println("SEGMENT INDEX: " + index[i]);
			}
			return true;
		} catch (Exception ex) {
			Error.
				setErrorMessage("Oracle database was not possible to execute the command: " + ex);
			return false;
		}
	}

}
