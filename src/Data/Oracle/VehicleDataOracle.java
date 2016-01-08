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
import oracle.jdbc.OracleTypes;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class VehicleDataOracle implements VehicleData {

	private Connection connection;

	public VehicleDataOracle(Connection connection) {
		this.connection = connection;
	}

	@Override
	public Integer size(Project project) {
		return this.all(project).size();
	}

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

	@Override
	public Boolean save(Project project, Vehicle vehicle) {
		return false;
	}

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

	@Override
	public Boolean hasChanged(Project project, Vehicle vehicle) {
		Vehicle oldVehicle = this.get(project, vehicle);
		return !oldVehicle.equals(vehicle);
	}

}
