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
	private RoadNetwork roadNetwork;
	private List<Vehicle> vehicles;
	private AddVehiclesController addVehiclesController;

	public Boolean initiation() {
		this.projectData = Data.getProjectData();
		this.project = this.projectData.newInstance();
		this.roadNetwork = new RoadNetwork();
		this.vehicles = new ArrayList();
		this.addVehiclesController = new AddVehiclesController();
		return this.project != null;
	}

	public Boolean setDataProject(String name, String description) {
		this.roadNetwork.setName(name);
		this.roadNetwork.setDescription(description);
		return this.roadNetwork.getName().equalsIgnoreCase(name) && this.roadNetwork.
			getDescription().equalsIgnoreCase(description);
	}

	public Boolean loadVehicles(String filePath) {
		List<Vehicle> newVehicles = Legacy.importVehicles(filePath);
		if (newVehicles != null && !newVehicles.isEmpty()) {
			this.addVehiclesController.
				concatenateVehicles(this.vehicles, newVehicles);
			return true;
		}
		return false;
	}

	public void loadRoadNetwork(String filePath) {
		List<RoadNetwork> roadNetworks = Legacy.importRoadNetwork(filePath);
		if (roadNetworks != null && !roadNetworks.isEmpty()) {
			this.roadNetwork = roadNetworks.get(roadNetworks.size() - 1);
		}
	}

	public RoadNetwork getProjectRoadNetwork() {
		return this.roadNetwork;
	}

	public List<Vehicle> getProjectVehicles() {
		return this.vehicles;
	}

	public Boolean saveProject() {
		this.project.setRoadNetwork(this.roadNetwork);
		for (Vehicle vehicle : this.vehicles) {
			this.project.addVehicle(vehicle);
		}
		return this.projectData.save(this.project);
	}

}
