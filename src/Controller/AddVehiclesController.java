/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Data.Data;
import Data.ProjectData;
import Legacy.Legacy;
import Model.Project;
import Model.Vehicle;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class AddVehiclesController {

	private ProjectData projectData;
	private Project project;
	private List<Vehicle> vehicles;

	public AddVehiclesController() {
		this.projectData = Data.getProjectData();
		this.project = ContextController.getOpenProject();
	}

	public List<Vehicle> loadVehicles(String filePath) {
		this.vehicles = Legacy.importVehicles(filePath);
		return this.vehicles;
	}

	public Boolean saveProjectVehicles() {
		for (Vehicle vehicle : this.vehicles) {
			this.project.addVehicle(vehicle);
		}
		return this.projectData.save(this.project);
	}

}
