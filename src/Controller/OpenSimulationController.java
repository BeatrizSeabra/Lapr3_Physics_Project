/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Simulation;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class OpenSimulationController {

	private List<Simulation> simulations;

	public void initiation() {
		this.simulations = ContextController.getOpenProject().getSimulations();
	}

	public List<Simulation> getSimulations() {
		return this.simulations;
	}

	public Boolean openSimulation(Simulation simulation) {
		ContextController.setOpenSimulation(simulation);
		return ContextController.getOpenSimulation().equals(simulation);
	}
}
