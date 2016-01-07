/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Data.Data;
import Data.SimulationData;
import Model.Simulation;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class EditSimulationController {

	private SimulationData simulationData;
	private Simulation simulation;
	private Simulation editSimulation;

	public void initiation() {
		this.simulationData = Data.getSimulationData();
		this.simulation = ContextController.getOpenSimulation();
		this.editSimulation = this.simulation.clone();
	}

	public Simulation getSimulation() {
		return this.editSimulation;
	}

	public Boolean editSimulation(String name, String description) {
		this.editSimulation.setName(name);
		this.editSimulation.setDescription(description);
		return this.editSimulation.getName().equalsIgnoreCase(name) && this.editSimulation.
			getDescription().equalsIgnoreCase(description);
	}

	public Boolean hasChanges() {
		return !this.editSimulation.getName().equals(this.simulation.getName()) || !this.editSimulation.
			getDescription().equals(this.simulation.getDescription());
	}

	public Boolean saveSimulation() {
		return this.simulationData.save(this.editSimulation);
	}
}
