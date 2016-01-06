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
public class CopySimulationController {

	private SimulationData simulationData;
	private Simulation simulation;
	private Simulation simulationCopy;

	public Boolean initiation() {
		this.simulationData = Data.getSimulationData();
		this.simulation = ContextController.getOpenSimulation();
		return this.simulation != null;
	}

	public Boolean copySimulation(String simulationName, String simulationDescription) {
		this.simulationCopy = this.simulationData.clone(this.simulation);
		this.simulationCopy.setName(simulationName);
                this.simulationCopy.setDescription(simulationDescription);
		return this.simulationCopy != null;
	}

	public Boolean saveSimulation() {
		return this.simulationData.save(this.simulationCopy);
	}
}
