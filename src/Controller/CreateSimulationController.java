/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Data.Data;
import Data.ProjectData;
import Data.SimulationData;
import Legacy.Legacy;
import Model.Project;
import Model.Simulation;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class CreateSimulationController {

	private ProjectData projectData = Data.getProjectData();
	private SimulationData simulationData = Data.getSimulationData();
	private Project project;
	private Simulation simulation;

	/**
	 *
	 * @return
	 */
	public boolean initiation() {
		this.project = ContextController.getOpenProject();
		this.simulation = null;
		return true;
	}

	/**
	 *
	 * @return
	 */
	public String getName() {
		if (this.hasSimulation()) {
			return this.simulation.getName();
		}
		return "";
	}

	/**
	 *
	 * @return
	 */
	public String getDescription() {
		if (this.hasSimulation()) {
			return this.simulation.getDescription();
		}
		return "";
	}

	/**
	 *
	 * @return
	 */
	public String getToString() {
		if (this.hasSimulation()) {
			return this.simulation.toString();
		}
		return "";
	}

	/**
	 *
	 * @param name
	 * @param description
	 * @return
	 */
	public Boolean saveSimulation(String name, String description) {
		if (this.hasSimulation()) {
			this.simulation.setName(name);
			this.simulation.setDescription(description);
			return this.simulationData.save(this.project, this.simulation);
		}
		return false;
	}

	/**
	 *
	 * @return
	 */
	public Boolean hasSimulation() {
		return this.simulation != null;
	}

	/**
	 *
	 * @param filePath
	 * @return
	 */
	public Boolean loadSimulation(String filePath) {
		List<Simulation> simulations = Legacy.importSimulation(filePath);
		if (simulations != null && !simulations.isEmpty()) {
			this.simulation = simulations.get(simulations.size() - 1);
			return true;
		}
		return false;
	}

}
