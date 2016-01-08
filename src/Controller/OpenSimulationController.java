/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Data.Data;
import Data.SimulationData;
import Model.Project;
import Model.Simulation;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class OpenSimulationController {

	private Project project;
	private SimulationData simulationData;
	private List<Simulation> simulations;

	public void initiation() {
		this.project = ContextController.getOpenProject();
		this.simulationData = Data.getSimulationData();
		this.simulations = this.simulationData.all(this.project);
	}

	public List<Simulation> getSimulations() {
		return this.simulations;
	}

	public Boolean openSimulation(Simulation simulation) {
		simulation = this.simulationData.get(this.project, simulation);
		ContextController.setOpenSimulation(simulation);
		return simulation != null;
	}
}
