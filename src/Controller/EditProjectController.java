/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Data.Data;
import Data.ProjectData;
import Model.Project;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class EditProjectController {

	private ProjectData projectData;
	private Project project;
	private Project editProject;

	/**
	 *
	 */
	public void initiation() {
		this.projectData = Data.getProjectData();
		this.project = ContextController.getOpenProject();
		this.editProject = this.project.clone();
	}

	/**
	 *
	 * @return
	 */
	public Project getProject() {
		return this.editProject;
	}

	/**
	 *
	 * @param name
	 * @param description
	 * @return
	 */
	public Boolean editProject(String name, String description) {
		this.editProject.setName(name);
		this.editProject.setDescription(description);
		return this.editProject.getName().equalsIgnoreCase(name) && this.editProject.
			getDescription().equalsIgnoreCase(description);
	}

	/**
	 *
	 * @return
	 */
	public Boolean hasChanges() {
		return !this.editProject.getName().equals(this.project.getName()) || !this.editProject.
			getDescription().equals(this.project.getDescription());
	}

	/**
	 *
	 * @return
	 */
	public Boolean saveProject() {
		return this.projectData.save(this.editProject);
	}
}
