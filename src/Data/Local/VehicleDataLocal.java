/*
 * To change this license header, choose License Headers in Vehicle Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Local;

import Data.VehicleData;
import Model.Project;
import Model.Vehicle;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class VehicleDataLocal implements VehicleData {

	private List<Vehicle> list = new ArrayList();

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
		return project.getVehicles();
	}

	/**
	 *
	 * @param project
	 * @param vehicle
	 * @return
	 */
	@Override
	public Boolean save(Project project, Vehicle vehicle) {
		project.addVehicle(vehicle);
		return this.list.add(vehicle);
	}

	/**
	 *
	 * @param project
	 * @param vehicles
	 * @return
	 */
	@Override
	public Boolean save(Project project, List<Vehicle> vehicles) {
		for (Vehicle vehicle : vehicles) {
			this.save(project, vehicle);
		}
		return true;
	}

	/**
	 *
	 * @param project
	 * @param vehicle
	 * @return
	 */
	@Override
	public Vehicle get(Project project, Vehicle vehicle) {
		for (Vehicle vehicleList : this.list) {
			if (vehicleList.getId() == vehicle.getId()) {
				return vehicleList;
			}
		}
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
