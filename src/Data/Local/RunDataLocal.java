/*
 * To change this license header, choose License Headers in Simulation Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Local;

import Data.RunData;
import Model.Run;
import Model.Simulation;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class RunDataLocal implements RunData {

	private List<Run> list = new ArrayList();
	private Integer currentIndex = 0;

	private Integer getNextIndex() {
		currentIndex++;
		return this.currentIndex;
	}

	/**
	 *
	 * @param project
	 * @return
	 */
	@Override
	public Integer size(Simulation simulation) {
		return this.all(simulation).size();
	}

	/**
	 *
	 * @param simulation
	 * @return
	 */
	@Override
	public List<Run> all(Simulation simulation) {
		return simulation.getRuns();
	}

	/**
	 *
	 * @param project
	 * @param simulation
	 * @return
	 */
	public Boolean save(Simulation simulation, Run run) {
		if (run.getId() == 0) {
			run.setId(this.getNextIndex());
			return this.list.add(run) && simulation.addRun(run);
		}
		Run oldSimulation = this.get(simulation, run);
		oldSimulation.setId(simulation.getId());
		oldSimulation.setName(simulation.getName());
		return oldSimulation.equals(simulation);
	}

	/**
	 *
	 * @param project
	 * @param simulation
	 * @return
	 */
	@Override
	public Run get(Simulation simulation, Run run) {
		for (Run runList : this.list) {
			if (runList.getId() == run.getId()) {
				return runList;
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
	public Boolean hasChanged(Simulation simulation, Run run) {
		Run oldRun = this.get(simulation, run);
		return !oldRun.equals(run);
	}

	/**
	 *
	 * @param project
	 * @param simulations
	 * @return
	 */
	@Override
	public Boolean save(Simulation simulation, List<Run> runs) {
		for (Run run : runs) {
			this.save(simulation, run);
		}
		return true;
	}

	@Override
	public Boolean remove(Simulation simulation, Run run) {
		return simulation.removeRun(run) && this.list.remove(run);
	}

}
