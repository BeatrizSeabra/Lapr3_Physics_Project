/*
 * To change this license header, choose License Headers in Simulation Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Local;

import Data.SimulationData;
import Model.Project;
import Model.Simulation;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class SimulationDataLocal implements SimulationData {

	private List<Simulation> list = new ArrayList();

	/**
	 *
	 * @param project
	 * @return
	 */
	@Override
	public Integer size(Project project) {
		return this.all(project).size();
	}

	/**
	 *
	 * @param project
	 * @return
	 */
	@Override
	public List<Simulation> all(Project project) {
		return project.getSimulations();
	}

	/**
	 *
	 * @param project
	 * @param simulation
	 * @return
	 */
	public Boolean save(Project project, Simulation simulation) {
		for (Simulation oldSimulation : this.list) {
			if (oldSimulation.getId() == simulation.getId()) {
				this.list.remove(oldSimulation);
				break;
			}
		}
		return this.list.add(simulation) && project.addSimulation(simulation);
	}

	/**
	 *
	 * @param project
	 * @param simulation
	 * @return
	 */
	@Override
	public Simulation get(Project project, Simulation simulation) {
		for (Simulation simulationList : this.list) {
			if (simulationList.getId() == simulation.getId()) {
				return simulationList;
			}
		}
		return null;
	}

	/**
	 *
	 * @param project
	 * @param simulation
	 * @return
	 */
	@Override
	public Boolean hasChanged(Project project, Simulation simulation) {
		Simulation oldSimulation = this.get(project, simulation);
		return !oldSimulation.equals(simulation);
	}

	/**
	 *
	 * @param project
	 * @param simulations
	 * @return
	 */
	@Override
	public Boolean save(Project project, List<Simulation> simulations) {
		for (Simulation simulation : simulations) {
			this.save(project, simulation);
		}
		return true;
	}

}
