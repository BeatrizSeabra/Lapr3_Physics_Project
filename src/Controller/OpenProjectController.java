/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Data.Data;
import Model.Project;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class OpenProjectController {

	private List<Project> projects;

	public void initiation() {
		this.projects = Data.getProjectData().all();
	}

	public List<Project> getProjects() {
		return this.projects;
	}

	public Boolean openProject(Project project) {
		ContextController.setOpenProject(project);
		return ContextController.getOpenProject().equals(project);
	}
}
