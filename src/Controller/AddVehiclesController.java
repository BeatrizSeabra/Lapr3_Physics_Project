/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Data.Data;
import Data.VehicleData;
import Legacy.Legacy;
import Model.Project;
import Model.Vehicle;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class AddVehiclesController {

	private Project project;
	private VehicleData vehicleData;
	private List<Vehicle> vehicles;

	public void initiation() {
		this.project = ContextController.getOpenProject();
		this.vehicleData = Data.getVehicleData();
		this.vehicles = new ArrayList(this.vehicleData.all(this.project));
	}

	public List<Vehicle> getVehicles() {
		return this.vehicles;
	}

	public Boolean loadVehicles(String filePath) {
		List<Vehicle> vehicles = Legacy.importVehicles(filePath);
		if (vehicles != null) {
			this.concatenateVehicles(this.vehicles, vehicles);
			return true;
		}
		return false;
	}

	public void concatenateVehicles(List<Vehicle> vehicles,
									List<Vehicle> newVehicles) {
		for (Vehicle newVehicle : newVehicles) {
			Integer number = 1;
			while (this.quantityName(vehicles, newVehicle.getName()) != 0) {
				if (number == 1) {
					newVehicle.setName(newVehicle.getName() + " " + number);
				} else {
					newVehicle.setName(newVehicle.getName().
						replaceAll(" [0-9]+$", " " + number));
				}
				number++;
			}
			vehicles.add(newVehicle);
		}
	}

	public Integer quantityName(List<Vehicle> vehicles, String name) {
		Integer amount = 0;
		for (Vehicle vehicle : vehicles) {
			if (vehicle.getName().equals(name)) {
				amount++;
			}
		}
		return amount;
	}

	public Boolean hasChanges() {
		return this.vehicles.size() != this.vehicleData.size(this.project);
	}

	public Boolean saveProjectVehicles() {
		for (Vehicle vehicle : this.vehicles) {
			if (!this.project.getVehicles().contains(vehicle)) {
				this.project.addVehicle(vehicle);
			}
		}
		return Data.getProjectData().save(this.project);
	}

}
