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

	private Project p_project;
	private ProjectData projectData;
	private List<Vehicle> vehicles;
	private List<RoadNetwork> roadNetworks;

	/**
	 * Construtor com como parametro
	 *
	 */
	public CreateProjectController() {
		this.projectData = Data.getProjectData();
	}

	public List<Vehicle> loadVehicles(String filePath) {
		this.vehicles = Legacy.importVehicles(filePath);
		return this.vehicles;
	}

	public List<RoadNetwork> loadRoadNetwork(String filePath) {
		this.roadNetworks = Legacy.importRoadNetwork(filePath);
		return this.roadNetworks;
	}

	public Boolean newProject() {

		this.p_project = this.projectData.newInstance();
		this.vehicles = new ArrayList();
		this.roadNetworks = new ArrayList();
		return this.p_project != null;
	}

	public Boolean setDataProject(String name, String description) {

		p_project.setName(name);
		p_project.setDescription(description);

		return this.p_project.getName().equalsIgnoreCase(name) && this.p_project.
			getDescription().equalsIgnoreCase(description);

	}

	public List<RoadNetwork> getAllRoadNetwork() {
		return new ArrayList(this.roadNetworks);

	}

	public List<Vehicle> getAllVehicle() {
		return new ArrayList(this.vehicles);
	}

	public Boolean registProject() {
		return this.projectData.save(this.p_project);
	}
}
