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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class CreateProjectController {

	private ProjectData projectData = Data.getProjectData();
	private Project project;
	private List<Vehicle> vehicles;
	private AddVehiclesController addVehiclesController = new AddVehiclesController();

	/**
	 *
	 * @return
	 */
	public Boolean initiation() {
		this.project = null;
		this.vehicles = new ArrayList();
		return true;
	}

	/**
	 *
	 * @param filePath
	 * @return
	 */
	public Boolean loadVehicles(String filePath) {
		List<Vehicle> newVehicles = Legacy.importVehicles(filePath);
		if (newVehicles != null && !newVehicles.isEmpty()) {
			this.addVehiclesController.
				concatenateVehicles(this.vehicles, newVehicles);
			return true;
		}
		return false;
	}

	/**
	 *
	 * @param filePath
	 * @return
	 */
	public Boolean loadRoadNetwork(String filePath) {
		List<Project> projects = Legacy.importRoadNetwork(filePath);
		if (projects != null && !projects.isEmpty()) {
			this.project = projects.get(projects.size() - 1);
			return true;
		}
		return false;
	}

	/**
	 *
	 * @return
	 */
	public String getName() {
		if (this.hasProject()) {
			return this.project.getName();
		}
		return "";
	}

	/**
	 *
	 * @return
	 */
	public String getDescription() {
		if (this.hasProject()) {
			return this.project.getDescription();
		}
		return "";
	}

	/**
	 *
	 * @return
	 */
	public String getToString() {
		if (this.hasProject()) {
			return this.project.getRoadNetwork().toString();
		}
		return "";
	}

	/**
	 *
	 * @return
	 */
	public Boolean hasProject() {
		return this.project != null;
	}

	/**
	 *
	 * @return
	 */
	public List<Vehicle> getProjectVehicles() {
		return this.vehicles;
	}

	/**
	 *
	 * @param name
	 * @param description
	 * @return
	 */
	public Boolean saveProject(String name, String description) {
		if (this.hasProject()) {
			this.project.setName(name);
			this.project.setDescription(description);
			Boolean idProject = this.projectData.save(this.project);
			Data.getVehicleData().save(this.project, this.vehicles);
			if (idProject == true) {
				for (Vehicle vehicle : this.vehicles) {
					if (!this.project.addVehicle(vehicle)) {
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}

}
