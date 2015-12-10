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
 * @author ruben
 */
public class CreateProjectController {

	private Project p_project;
	private ProjectData projectData;

	/**
	 * Construtor com como parametro
	 *
	 */
	public CreateProjectController() {
		this.projectData = Data.getProjectData();
	}

	public Boolean newProject() {

		this.p_project = this.projectData.newInstance();

		return this.p_project != null;
	}

	public Boolean setDataProject(String name, String Description) {

		p_project.setName(name);
		p_project.setDescription(Description);

		return this.p_project.getName().equalsIgnoreCase(name) && this.p_project.
			getDescription().equalsIgnoreCase(Description);

	}

	public Boolean registProject() {
		return this.projectData.save(this.p_project);
	}
}
