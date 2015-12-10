/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Project;

/**
 *
 * @author LAPR3_20152016_G27
 */
public abstract class ContextController {

	static private Project currentProject;

	static public Project getOpenProject() {
		return ContextController.currentProject;
	}

	static public void setOpenProject(Project project) {
		ContextController.currentProject = project;
	}
}
