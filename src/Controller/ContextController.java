/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Data.Data;
import Model.Project;

/**
 *
 * @author LAPR3_20152016_G27
 */
public abstract class ContextController {

	static private Project currentProject;

	static public Project getOpenProject() {
		if (ContextController.currentProject == null) {
			return null;
		}
		ContextController.currentProject = Data.getProjectData().
			get(ContextController.currentProject.getId());
		return ContextController.currentProject;
	}

	static public void setOpenProject(Project project) {
		ContextController.currentProject = project;
	}
}
