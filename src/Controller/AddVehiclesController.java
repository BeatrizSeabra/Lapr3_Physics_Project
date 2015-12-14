/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Data.Data;
import Legacy.Legacy;
import Model.Project;
import Model.Vehicle;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class AddVehiclesController {

	private Project project;
	private List<Vehicle> vehicles;

	public void initiation() {
		this.project = ContextController.getOpenProject();
		this.vehicles = this.project.getVehicles();
	}

	public List<Vehicle> getVehicles() {
		return this.vehicles;
	}

	public Boolean loadVehicles(String filePath) {
		List<Vehicle> vehicles = Legacy.importVehicles(filePath);
		if (vehicles != null) {
			for (Vehicle newVehicle : vehicles) {
				Integer number = 1;
				for (Vehicle vehicle : this.vehicles) {
					if (newVehicle.getName().equals(vehicle.getName())) {
						if (number == 1) {
							newVehicle.
								setName(newVehicle.getName() + " " + number);
						} else {
							newVehicle.setName(newVehicle.getName().
								replaceAll(" [0-9]+$", " " + number));
						}
						number++;
					}
				}
				this.vehicles.add(newVehicle);
			}
			return true;
		}
		return false;
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
