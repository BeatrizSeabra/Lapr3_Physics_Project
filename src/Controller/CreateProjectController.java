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

	private ProjectData projectData = Data.getProjectData();
	private Project project;
	private RoadNetwork roadNetwork;
	private List<Vehicle> vehicles;
	private AddVehiclesController addVehiclesController = new AddVehiclesController();
	private String name;
	private String description;

	public Boolean initiation() {
		this.roadNetwork = null;
		this.vehicles = new ArrayList();
		return true;
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

	public RoadNetwork getRoadNetwork() {
		return this.roadNetwork;
	}

	public List<Vehicle> getProjectVehicles() {
		return this.vehicles;
	}

	public Boolean saveProject(String name, String description) {
		this.project = this.projectData.newInstance();
		this.project.setRoadNetwork(this.roadNetwork);
		this.roadNetwork.setName(name);
		this.roadNetwork.setDescription(description);
		for (Vehicle vehicle : this.vehicles) {
			this.project.addVehicle(vehicle);
		}
		return this.projectData.save(this.project);
	}

}
