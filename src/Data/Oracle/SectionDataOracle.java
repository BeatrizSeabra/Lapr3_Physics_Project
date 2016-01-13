/*
 * To change this license header, choose License Headers in Simulation Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Oracle;

import Model.Node;
import Model.Project;
import Model.Section;
import System.Error;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Deque;
import java.util.List;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class SectionDataOracle {

	private Connection connection;
	private SegmentDataOracle segmentDataOracle;

	/**
	 *
	 * @param connection
	 */
	public SectionDataOracle(Connection connection) {
		this.connection = connection;
		this.segmentDataOracle = new SegmentDataOracle(connection);
	}

	/**
	 *
	 * @param project
	 * @param sections
	 * @return
	 */
	public Boolean save(Project project, List<Section> sections) {
		try {
			ArrayDescriptor oracleVarchar2Collection = ArrayDescriptor.
				createDescriptor("STRINGTABLE", this.connection);
			ArrayDescriptor oracleNumberCollection = ArrayDescriptor.
				createDescriptor("NUMBERTABLE", this.connection);
			CallableStatement callableStatement = connection.
				prepareCall("{ call saveSections(?,?,?,?,?,?,?,?,?,?,?,?,?) }");
			int size = sections.size();
			double[] param01 = new double[size];
			double[] param02 = new double[size];
			double[] param03 = new double[size];
			double[] param04 = new double[size];
			String[] param05 = new String[size];
			String[] param06 = new String[size];
			String[] param07 = new String[size];
			double[] param08 = new double[size];
			String[] param09 = new String[size];
			double[] param10 = new double[size];
			String[] param11 = new String[size];
			double[] param12 = new double[size];
			String[] param13 = new String[size];
			for (int i = 0; i < size; i++) {
				Deque<Node> nodes = project.getRoadNetwork().
					getExtremeNodes(sections.get(i));
				param01[i] = sections.get(i).getId();
				param02[i] = project.getId();
				param03[i] = nodes.getFirst().getId();
				param04[i] = nodes.getLast().getId();
				param05[i] = sections.get(i).getRoad();
				param06[i] = sections.get(i).getTypology();
				param07[i] = sections.get(i).getDirection();
				param08[i] = sections.get(i).getToll().getValue();
				param09[i] = sections.get(i).getToll().getUnit();
				param10[i] = sections.get(i).getWindDirection().getValue();
				param11[i] = sections.get(i).getWindDirection().getUnit();
				param12[i] = sections.get(i).getWindSpeed().getValue();
				param13[i] = sections.get(i).getWindSpeed().getUnit();
			}
			ARRAY param01O = new ARRAY(oracleNumberCollection, this.connection, param01);
			ARRAY param02O = new ARRAY(oracleNumberCollection, this.connection, param02);
			ARRAY param03O = new ARRAY(oracleNumberCollection, this.connection, param03);
			ARRAY param04O = new ARRAY(oracleNumberCollection, this.connection, param04);
			ARRAY param05O = new ARRAY(oracleVarchar2Collection, this.connection, param05);
			ARRAY param06O = new ARRAY(oracleVarchar2Collection, this.connection, param06);
			ARRAY param07O = new ARRAY(oracleVarchar2Collection, this.connection, param07);
			ARRAY param08O = new ARRAY(oracleNumberCollection, this.connection, param08);
			ARRAY param09O = new ARRAY(oracleVarchar2Collection, this.connection, param09);
			ARRAY param10O = new ARRAY(oracleNumberCollection, this.connection, param10);
			ARRAY param11O = new ARRAY(oracleVarchar2Collection, this.connection, param11);
			ARRAY param12O = new ARRAY(oracleNumberCollection, this.connection, param12);
			ARRAY param13O = new ARRAY(oracleVarchar2Collection, this.connection, param13);
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
			callableStatement.execute();
			ARRAY arrayIndex = ((OracleCallableStatement) callableStatement).
				getARRAY(1);
			int index[] = arrayIndex.getIntArray();
			callableStatement.close();
			for (int i = 0; i < size; i++) {
				System.out.println("SECTION INDEX: " + index[i]);
				sections.get(i).setId(index[i]);
				if (index[i] != 0 && !sections.get(i).getSegments().isEmpty()) {
					this.segmentDataOracle.
						save(sections.get(i), sections.get(i).getSegments());
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
