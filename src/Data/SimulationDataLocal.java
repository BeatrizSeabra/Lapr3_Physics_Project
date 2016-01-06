/*
 * To change this license header, choose License Headers in Simulation Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Model.Simulation;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class SimulationDataLocal implements SimulationData {

	private List<Simulation> list = new ArrayList();
	private Integer currentIndex = 0;

	private Integer getNextIndex() {
		this.currentIndex++;
		return this.currentIndex;
	}

	@Override
	public Simulation newInstance() {
		Simulation simulation = new Simulation();
		simulation.setId(this.getNextIndex());
		return simulation;
	}

	@Override
	public Integer size() {
		return this.list.size();
	}

	@Override
	public List<Simulation> all() {
		return new ArrayList(this.list);
	}

	@Override
	public Boolean save(Simulation simulation) {
		for (Simulation oldSimulation : this.list) {
			if (oldSimulation.getId() == simulation.getId()) {
				this.list.remove(oldSimulation);
				return this.list.add(simulation);
			}
		}
		return this.list.add(simulation);
	}

	@Override
	public Simulation copy(Simulation simulation) {
		return simulation.clone();
	}

	@Override
	public Simulation clone(Simulation simulation) {
		Simulation newSimulation = this.copy(simulation);
		newSimulation.setId(this.getNextIndex());
		return newSimulation;
	}

	@Override
	public Simulation get(Integer id) {
		for (Simulation simulation : this.list) {
			if (simulation.getId() == id) {
				return this.copy(simulation);
			}
		}
		return null;
	}

	@Override
	public Boolean hasChanged(Simulation simulation) {
		Simulation oldSimulation = this.get(simulation.getId());
		return !oldSimulation.equals(simulation);
	}

}
