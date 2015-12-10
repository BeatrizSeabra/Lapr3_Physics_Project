/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Data.Data;
import Data.ProjectData;
import Model.Project;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class EditProjectController {

	private ProjectData projectData;
	private Project project;

	public EditProjectController() {
		this.projectData = Data.getProjectData();
	}

	public List<Project> getAllProjects() {
		return this.projectData.all();
	}

	public String setProject(Project project) {
		this.projectData.clone(project);
		return this.project.toString();
	}

	public Boolean defineProject(String name, String description) {
		this.project.setName(name);
		this.project.setDescription(description);
		return this.project.getName().equalsIgnoreCase(name) && this.project.
			getDescription().equalsIgnoreCase(description);
	}

	public Boolean registProject() {
		return this.projectData.save(this.project);
	}
}
