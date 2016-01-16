/*
 * To change this license header, choose License Headers in Vehicle Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Oracle;

import Legacy.VehicleImportXML;
import Model.Project;
import Model.Run;
import Model.Step;
import Model.Vehicle;
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
public class StepDataOracle {

	private Connection connection;
	private VelocityLimitDataOracle velocityLimitDataOracle;
	private GearDataOracle gearDataOracle;
	private ThrottleDataOracle trottleDataOracle;

	/**
	 *
	 * @param connection
	 */
	public StepDataOracle(Connection connection) {
		this.connection = connection;
		this.velocityLimitDataOracle = new VelocityLimitDataOracle(connection);
		this.gearDataOracle = new GearDataOracle(connection);
		this.trottleDataOracle = new ThrottleDataOracle(connection);
	}

	/**
	 *
	 * @param project
	 * @return
	 */
	public Integer size(Project project) {
		return this.all(project).size();
	}

	/**
	 *
	 * @param project
	 * @return
	 */
	public List<Vehicle> all(Project project) {
		try {
			CallableStatement callableStatement = connection.
				prepareCall("BEGIN ALLVEHICLES(?,?); END;");
			callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
			callableStatement.setInt(2, project.getId());
			callableStatement.execute();
			ResultSet rSet = (ResultSet) callableStatement.getObject(1);
			List<Vehicle> steps = new ArrayList();
			while (rSet.next()) {
				Vehicle vehicle = new Vehicle();
				vehicle.setId(rSet.getInt("IDVEHICLE"));
				vehicle.setName(rSet.getString("NAME"));
				vehicle.setDescription(rSet.getString("DESCRIPTION"));
				steps.add(vehicle);
			}
			return steps;
		} catch (Exception ex) {
			Error.
				setErrorMessage("Oracle database was not possible to execute the command: " + ex);
			return null;
		}
	}

	/**
	 *
	 * @param project
	 * @param vehicle
	 * @return
	 */
	public Boolean save(Run run, Step step) {
		List<Step> steps = new ArrayList();
		steps.add(step);
		return this.save(run, steps);
	}

	/**
	 *
	 * @param project
	 * @param steps
	 * @return
	 */
	public Boolean save(Run run, List<Step> steps) {
		try {
			ArrayDescriptor oracleVarchar2Collection = ArrayDescriptor.
				createDescriptor("STRINGTABLE", this.connection);
			ArrayDescriptor oracleNumberCollection = ArrayDescriptor.
				createDescriptor("NUMBERTABLE", this.connection);
			CallableStatement callableStatement = connection.
				prepareCall("{ call saveVehicles(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
			int size = steps.size();
			double[] param01 = new double[size];
			double[] param02 = new double[size];
			String[] param03 = new String[size];
			String[] param04 = new String[size];
			String[] param05 = new String[size];
			String[] param06 = new String[size];
			String[] param07 = new String[size];
			String[] param08 = new String[size];
			String[] param09 = new String[size];
			String[] param10 = new String[size];
			String[] param11 = new String[size];
			String[] param12 = new String[size];
			String[] param13 = new String[size];
			String[] param14 = new String[size];
			String[] param15 = new String[size];
			String[] param16 = new String[size];
			for (int i = 0; i < size; i++) {
				param01[i] = 0;
				param02[i] = run.getId();
				param03[i] = steps.get(i).getVehicle();
				param04[i] = steps.get(i).getNodeStart();
				param05[i] = steps.get(i).getNodeEnd();
				param06[i] = steps.get(i).getRoad();
				param07[i] = steps.get(i).getSegment();
				param08[i] = steps.get(i).getTimeEntry().toString();
				param09[i] = steps.get(i).getTimeOut().toString();
				param10[i] = steps.get(i).getCarPower().toString();
				param11[i] = steps.get(i).getCarSpeed().toString();
				param12[i] = steps.get(i).getSpeedRelative().toString();
				param13[i] = steps.get(i).getCarForce().toString();
				param14[i] = steps.get(i).getRollingForce().toString();
				param15[i] = steps.get(i).getAirForce().toString();
				param16[i] = steps.get(i).getGravityForce().toString();
			}
			ARRAY param01O = new ARRAY(oracleNumberCollection, this.connection, param01);
			ARRAY param02O = new ARRAY(oracleNumberCollection, this.connection, param02);
			ARRAY param03O = new ARRAY(oracleVarchar2Collection, this.connection, param03);
			ARRAY param04O = new ARRAY(oracleVarchar2Collection, this.connection, param04);
			ARRAY param05O = new ARRAY(oracleVarchar2Collection, this.connection, param05);
			ARRAY param06O = new ARRAY(oracleVarchar2Collection, this.connection, param06);
			ARRAY param07O = new ARRAY(oracleVarchar2Collection, this.connection, param07);
			ARRAY param08O = new ARRAY(oracleVarchar2Collection, this.connection, param08);
			ARRAY param09O = new ARRAY(oracleVarchar2Collection, this.connection, param09);
			ARRAY param10O = new ARRAY(oracleVarchar2Collection, this.connection, param10);
			ARRAY param11O = new ARRAY(oracleVarchar2Collection, this.connection, param11);
			ARRAY param12O = new ARRAY(oracleVarchar2Collection, this.connection, param12);
			ARRAY param13O = new ARRAY(oracleVarchar2Collection, this.connection, param13);
			ARRAY param14O = new ARRAY(oracleVarchar2Collection, this.connection, param14);
			ARRAY param15O = new ARRAY(oracleVarchar2Collection, this.connection, param15);
			ARRAY param16O = new ARRAY(oracleVarchar2Collection, this.connection, param16);
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
			callableStatement.setObject(15, param15O, OracleTypes.ARRAY);
			callableStatement.setObject(16, param16O, OracleTypes.ARRAY);
			callableStatement.execute();
			ARRAY arrayIndex = ((OracleCallableStatement) callableStatement).
				getARRAY(1);
			int index[] = arrayIndex.getIntArray();
			callableStatement.close();
			for (int i = 0; i < size; i++) {
				System.out.println("STEP INDEX: " + index[i]);
			}
			return true;
		} catch (Exception ex) {
			Error.
				setErrorMessage("Oracle database was not possible to execute the command: " + ex);
			return false;
		}
	}

	/**
	 *
	 * @param project
	 * @param vehicle
	 * @return
	 */
	public Vehicle get(Project project, Vehicle vehicle) {
		for (Vehicle vehicleList : this.all(project)) {
			if (vehicleList.getId() == vehicle.getId()) {
				try {
					CallableStatement callableStatement = connection.
						prepareCall("BEGIN EXPORTXMLVEHICLES(?,?); END;");
					callableStatement.
						registerOutParameter(1, OracleTypes.VARCHAR);
					callableStatement.setInt(2, vehicle.getId());
					callableStatement.execute();
					VehicleImportXML importClass = new VehicleImportXML();
					List<Vehicle> steps = importClass.
						importData(callableStatement.getString(1));
					if (steps != null && !steps.isEmpty()) {
						return steps.get(steps.size() - 1);
					}
				} catch (Exception ex) {
					Error.setErrorMessage(ex.toString());
					return null;
				}
				break;
			}
		}
		Error.
			setErrorMessage("Oracle database was not possible to execute the command: get: " + vehicle);
		return null;
	}

	/**
	 *
	 * @param project
	 * @param vehicle
	 * @return
	 */
	public Boolean hasChanged(Project project, Vehicle vehicle) {
		Vehicle oldVehicle = this.get(project, vehicle);
		return !oldVehicle.equals(vehicle);
	}

}
