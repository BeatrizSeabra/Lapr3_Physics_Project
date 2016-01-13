/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Project;
import Model.Simulation;

/**
 *
 * @author LAPR3_20152016_G27
 */
public abstract class ContextController {

	static private Project currentProject;
	static private Simulation currentSimulation;

	/**
	 *
	 * @return
	 */
	static public Project getOpenProject() {
		return ContextController.currentProject;
	}

	/**
	 *
	 * @return
	 */
	static public Simulation getOpenSimulation() {
		return ContextController.currentSimulation;
	}

	/**
	 *
	 * @param project
	 */
	static public void setOpenProject(Project project) {
		ContextController.currentProject = project;
	}

	/**
	 *
	 * @param simulation
	 */
	static public void setOpenSimulation(Simulation simulation) {
		ContextController.currentSimulation = simulation;
	}
}
