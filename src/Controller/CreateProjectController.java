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
import Model.RoadNetwork;
import Model.Vehicle;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class CreateProjectController {

	private ProjectData projectData;
	private Project project;
	private List<RoadNetwork> roadNetworks;
	private List<Vehicle> vehicles;
	private AddVehiclesController addVehiclesController;

	public Boolean initiation() {
		this.projectData = Data.getProjectData();
		this.project = this.projectData.newInstance();
		this.roadNetworks = new ArrayList();
		this.vehicles = new ArrayList();
		this.addVehiclesController = new AddVehiclesController();
		return this.project != null;
	}

	public Boolean setDataProject(String name, String description) {
		project.setName(name);
		project.setDescription(description);
		return this.project.getName().equalsIgnoreCase(name) && this.project.
			getDescription().equalsIgnoreCase(description);
	}

	public Boolean loadVehicles(String filePath) {
		List<Vehicle> newVehicles = Legacy.importVehicles(filePath);
		if (newVehicles != null) {
			this.addVehiclesController.
				concatenateVehicles(this.vehicles, newVehicles);
			return true;
		}
		return false;
	}

	public void loadRoadNetwork(String filePath) {
		for (RoadNetwork roadNetwork : Legacy.importRoadNetwork(filePath)) {
			this.roadNetworks.add(roadNetwork);
		}
	}

	public List<RoadNetwork> getProjectRoadNetworks() {
		return this.roadNetworks;
	}

	public List<Vehicle> getProjectVehicles() {
		return this.vehicles;
	}

	public Boolean saveProject() {
		for (RoadNetwork roadNetwork : this.roadNetworks) {
			this.project.addRoadNetwork(roadNetwork);
		}
		for (Vehicle vehicle : this.vehicles) {
			this.project.addVehicle(vehicle);
		}
		return this.projectData.save(this.project);
	}

}
