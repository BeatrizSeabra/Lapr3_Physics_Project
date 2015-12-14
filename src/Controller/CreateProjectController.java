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
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class CreateProjectController {

	private ProjectData projectData;
	private Project project;

	public Boolean initiation() {
		this.projectData = Data.getProjectData();
		this.project = this.projectData.newInstance();
		return this.project != null;
	}

	public Boolean setDataProject(String name, String description) {
		project.setName(name);
		project.setDescription(description);
		return this.project.getName().equalsIgnoreCase(name) && this.project.
			getDescription().equalsIgnoreCase(description);
	}

	public void loadVehicles(String filePath) {
		for (Vehicle vehicle : Legacy.importVehicles(filePath)) {
			this.project.addVehicle(vehicle);
		}
	}

	public void loadRoadNetwork(String filePath) {
		for (RoadNetwork roadNetwork : Legacy.importRoadNetwork(filePath)) {
			this.project.addRoadNetwork(roadNetwork);
		}
	}

	public List<RoadNetwork> getProjectRoadNetworks() {
		return this.project.getRoadNetworks();

	}

	public List<Vehicle> getProjectVehicles() {
		return this.project.getVehicles();
	}

	public Boolean registProject() {
		return this.projectData.save(this.project);
	}

}
