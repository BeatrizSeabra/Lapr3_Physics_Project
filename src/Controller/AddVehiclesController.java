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
		return this.vehicles.addAll(Legacy.importVehicles(filePath));
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
