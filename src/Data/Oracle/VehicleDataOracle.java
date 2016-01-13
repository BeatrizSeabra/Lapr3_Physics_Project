/*
 * To change this license header, choose License Headers in Vehicle Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Oracle;

import Data.VehicleData;
import Legacy.VehicleImportXML;
import Model.Project;
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
public class VehicleDataOracle implements VehicleData {

	private Connection connection;
	private VelocityLimitDataOracle velocityLimitDataOracle;
	private GearDataOracle gearDataOracle;
	private ThrottleDataOracle trottleDataOracle;

	/**
	 *
	 * @param connection
	 */
	public VehicleDataOracle(Connection connection) {
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
	@Override
	public Integer size(Project project) {
		return this.all(project).size();
	}

	/**
	 *
	 * @param project
	 * @return
	 */
	@Override
	public List<Vehicle> all(Project project) {
		try {
			CallableStatement callableStatement = connection.
				prepareCall("BEGIN ALLVEHICLES(?,?); END;");
			callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
			callableStatement.setInt(2, project.getId());
			callableStatement.execute();
			ResultSet rSet = (ResultSet) callableStatement.getObject(1);
			List<Vehicle> vehicles = new ArrayList();
			while (rSet.next()) {
				Vehicle vehicle = new Vehicle();
				vehicle.setId(rSet.getInt("IDVEHICLE"));
				vehicle.setName(rSet.getString("NAME"));
				vehicle.setDescription(rSet.getString("DESCRIPTION"));
				vehicles.add(vehicle);
			}
			return vehicles;
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
	@Override
	public Boolean save(Project project, Vehicle vehicle) {
		List<Vehicle> vehicles = new ArrayList();
		vehicles.add(vehicle);
		return this.save(project, vehicles);
	}

	/**
	 *
	 * @param project
	 * @param vehicles
	 * @return
	 */
	@Override
	public Boolean save(Project project, List<Vehicle> vehicles) {
		try {
			ArrayDescriptor oracleVarchar2Collection = ArrayDescriptor.
				createDescriptor("STRINGTABLE", this.connection);
			ArrayDescriptor oracleNumberCollection = ArrayDescriptor.
				createDescriptor("NUMBERTABLE", this.connection);
			CallableStatement callableStatement = connection.
				prepareCall("{ call saveVehicles(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
			int size = vehicles.size();
			double[] param01 = new double[size];
			double[] param02 = new double[size];
			String[] param03 = new String[size];
			String[] param04 = new String[size];
			String[] param05 = new String[size];
			String[] param06 = new String[size];
			String[] param07 = new String[size];
			double[] param08 = new double[size];
			String[] param09 = new String[size];
			double[] param10 = new double[size];
			String[] param11 = new String[size];
			double[] param12 = new double[size];
			String[] param13 = new String[size];
			double[] param14 = new double[size];
			String[] param15 = new String[size];
			double[] param16 = new double[size];
			String[] param17 = new String[size];
			double[] param18 = new double[size];
			String[] param19 = new String[size];
			double[] param20 = new double[size];
			String[] param21 = new String[size];
			double[] param22 = new double[size];
			String[] param23 = new String[size];
			double[] param24 = new double[size];
			String[] param25 = new String[size];
			double[] param26 = new double[size];
			String[] param27 = new String[size];
			for (int i = 0; i < size; i++) {
				param01[i] = vehicles.get(i).getId();
				param02[i] = project.getId();
				param03[i] = vehicles.get(i).getName();
				param04[i] = vehicles.get(i).getDescription();
				param05[i] = vehicles.get(i).getType();
				param06[i] = vehicles.get(i).getMotorization();
				param07[i] = vehicles.get(i).getFuel();
				param08[i] = vehicles.get(i).getMass().getValue();
				param09[i] = vehicles.get(i).getMass().getUnit();
				param10[i] = vehicles.get(i).getLoad().getValue();
				param11[i] = vehicles.get(i).getLoad().getUnit();
				param12[i] = vehicles.get(i).getDragCoefficient().getValue();
				param13[i] = vehicles.get(i).getDragCoefficient().getUnit();
				param14[i] = vehicles.get(i).getFrontalArea().getValue();
				param15[i] = vehicles.get(i).getFrontalArea().getUnit();
				param16[i] = vehicles.get(i).getRollingRCoefficient().getValue();
				param17[i] = vehicles.get(i).getRollingRCoefficient().getUnit();
				param18[i] = vehicles.get(i).getWheelSize().getValue();
				param19[i] = vehicles.get(i).getWheelSize().getUnit();
				param20[i] = vehicles.get(i).getMinRPM().getValue();
				param21[i] = vehicles.get(i).getMinRPM().getUnit();
				param22[i] = vehicles.get(i).getMaxRPM().getValue();
				param23[i] = vehicles.get(i).getMaxRPM().getUnit();
				param24[i] = vehicles.get(i).getFinalDriveRatio().getValue();
				param25[i] = vehicles.get(i).getFinalDriveRatio().getUnit();
				param26[i] = vehicles.get(i).getEnergyRegeneration().getValue();
				param27[i] = vehicles.get(i).getEnergyRegeneration().getUnit();
			}
			ARRAY param01O = new ARRAY(oracleNumberCollection, this.connection, param01);
			ARRAY param02O = new ARRAY(oracleNumberCollection, this.connection, param02);
			ARRAY param03O = new ARRAY(oracleVarchar2Collection, this.connection, param03);
			ARRAY param04O = new ARRAY(oracleVarchar2Collection, this.connection, param04);
			ARRAY param05O = new ARRAY(oracleVarchar2Collection, this.connection, param05);
			ARRAY param06O = new ARRAY(oracleVarchar2Collection, this.connection, param06);
			ARRAY param07O = new ARRAY(oracleVarchar2Collection, this.connection, param07);
			ARRAY param08O = new ARRAY(oracleNumberCollection, this.connection, param08);
			ARRAY param09O = new ARRAY(oracleVarchar2Collection, this.connection, param09);
			ARRAY param10O = new ARRAY(oracleNumberCollection, this.connection, param10);
			ARRAY param11O = new ARRAY(oracleVarchar2Collection, this.connection, param11);
			ARRAY param12O = new ARRAY(oracleNumberCollection, this.connection, param12);
			ARRAY param13O = new ARRAY(oracleVarchar2Collection, this.connection, param13);
			ARRAY param14O = new ARRAY(oracleNumberCollection, this.connection, param14);
			ARRAY param15O = new ARRAY(oracleVarchar2Collection, this.connection, param15);
			ARRAY param16O = new ARRAY(oracleNumberCollection, this.connection, param16);
			ARRAY param17O = new ARRAY(oracleVarchar2Collection, this.connection, param17);
			ARRAY param18O = new ARRAY(oracleNumberCollection, this.connection, param18);
			ARRAY param19O = new ARRAY(oracleVarchar2Collection, this.connection, param19);
			ARRAY param20O = new ARRAY(oracleNumberCollection, this.connection, param20);
			ARRAY param21O = new ARRAY(oracleVarchar2Collection, this.connection, param21);
			ARRAY param22O = new ARRAY(oracleNumberCollection, this.connection, param22);
			ARRAY param23O = new ARRAY(oracleVarchar2Collection, this.connection, param23);
			ARRAY param24O = new ARRAY(oracleNumberCollection, this.connection, param24);
			ARRAY param25O = new ARRAY(oracleVarchar2Collection, this.connection, param25);
			ARRAY param26O = new ARRAY(oracleNumberCollection, this.connection, param26);
			ARRAY param27O = new ARRAY(oracleVarchar2Collection, this.connection, param27);
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
			callableStatement.setObject(17, param17O, OracleTypes.ARRAY);
			callableStatement.setObject(18, param18O, OracleTypes.ARRAY);
			callableStatement.setObject(19, param19O, OracleTypes.ARRAY);
			callableStatement.setObject(20, param20O, OracleTypes.ARRAY);
			callableStatement.setObject(21, param21O, OracleTypes.ARRAY);
			callableStatement.setObject(22, param22O, OracleTypes.ARRAY);
			callableStatement.setObject(23, param23O, OracleTypes.ARRAY);
			callableStatement.setObject(24, param24O, OracleTypes.ARRAY);
			callableStatement.setObject(25, param25O, OracleTypes.ARRAY);
			callableStatement.setObject(26, param26O, OracleTypes.ARRAY);
			callableStatement.setObject(27, param27O, OracleTypes.ARRAY);
			callableStatement.execute();
			ARRAY arrayIndex = ((OracleCallableStatement) callableStatement).
				getARRAY(1);
			int index[] = arrayIndex.getIntArray();
			callableStatement.close();
			for (int i = 0; i < size; i++) {
				vehicles.get(i).setId(index[i]);
				System.out.println("VEHICLE INDEX: " + index[i]);
				if (index[i] != 0) {
					if (!vehicles.get(i).getVelocityLimits().isEmpty()) {
						this.velocityLimitDataOracle.
							save(vehicles.get(i), vehicles.get(i).
								 getVelocityLimits());
					}
					if (!vehicles.get(i).getGears().isEmpty()) {
						this.gearDataOracle.save(vehicles.get(i), vehicles.
												 get(i).getGears());
					}
					if (!vehicles.get(i).getThrottles().isEmpty()) {
						this.trottleDataOracle.save(vehicles.get(i), vehicles.
													get(i).getThrottles());
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

	/**
	 *
	 * @param project
	 * @param vehicle
	 * @return
	 */
	@Override
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
					List<Vehicle> vehicles = importClass.
						importData(callableStatement.getString(1));
					if (vehicles != null && !vehicles.isEmpty()) {
						return vehicles.get(vehicles.size() - 1);
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
	@Override
	public Boolean hasChanged(Project project, Vehicle vehicle) {
		Vehicle oldVehicle = this.get(project, vehicle);
		return !oldVehicle.equals(vehicle);
	}

}
