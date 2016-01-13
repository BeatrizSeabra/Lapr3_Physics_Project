/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Local;

import Data.ProjectData;
import Model.Project;
import Model.Simulation;
import Model.Vehicle;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class ProjectDataLocal implements ProjectData {

	private List<Project> list = new ArrayList();
	private Integer currentIndex = 0;

	private Integer getNextIndex() {
		currentIndex++;
		return this.currentIndex;
	}

	@Override
	public Integer size() {
		return this.list.size();
	}

	@Override
	public List<Project> all() {
		return new ArrayList(this.list);
	}

	@Override
	public Boolean save(Project project) {
		if (project.getId() == 0) {
			project.setId(this.getNextIndex());
			return this.list.add(project);
		}
		Project oldProject = this.get(project);
		project.setId(project.getId());
		project.setName(project.getName());
		project.setDescription(project.getDescription());
		project.setRoadNetwork(project.getRoadNetwork());
		oldProject.getVehicles().clear();
		oldProject.getSimulations().clear();
		for (Vehicle vehicle : project.getVehicles()) {
			oldProject.addVehicle(vehicle);
		}
		for (Simulation simulation : project.getSimulations()) {
			oldProject.addSimulation(simulation);
		}
		return oldProject.equals(project);
	}

	@Override
	public Boolean save(List<Project> projects) {
		for (Project project : projects) {
			this.save(project);
		}
		return true;
	}

	@Override
	public Project get(Project project) {
		for (Project projectList : this.list) {
			if (projectList.getId() == project.getId()) {
				return projectList;
			}
		}
		return null;
	}

	@Override
	public Boolean hasChanged(Project project) {
		Project oldProject = this.get(project);
		return !oldProject.equals(project);
	}

}
