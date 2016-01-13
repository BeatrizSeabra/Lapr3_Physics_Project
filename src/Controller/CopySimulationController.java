/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Data.Data;
import Model.Project;
import Model.Simulation;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class CopySimulationController {

	private Project project;
	private Simulation simulation;
	private Simulation simulationCopy;

	/**
	 *
	 * @return
	 */
	public Boolean initiation() {
		this.project = ContextController.getOpenProject();
		this.simulation = ContextController.getOpenSimulation();
		return this.simulation != null;
	}

	/**
	 *
	 * @param name
	 * @param description
	 * @return
	 */
	public Boolean copySimulation(String name, String description) {
		if (name.equalsIgnoreCase(this.simulation.getName())) {
			name += " (copy)";
		}
		this.simulationCopy = this.simulation.clone();
		this.simulationCopy.setId(0);
		this.simulationCopy.setName(name);
		this.simulationCopy.setDescription(description);
                
                return Data.getSimulationData().save(this.project, this.simulationCopy);
	}

}
