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
public class OpenProjectController {

	private ProjectData projectData;
	private List<Project> projects;

	public void initiation() {
		this.projectData = Data.getProjectData();
		this.projects = this.projectData.all();
	}

	public List<Project> getProjects() {
		return this.projects;
	}

	public Boolean openProject(Project project) {
		project = this.projectData.get(project);
		ContextController.setOpenProject(project);
		return project != null;
	}
}
