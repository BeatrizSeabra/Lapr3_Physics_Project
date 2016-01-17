package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Data.Data;
import Model.Run;
import Model.Simulation;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class ViewRunController {

	private Simulation simulation;
	private List<Run> runs;

	/**
	 *
	 * @return
	 */
	public Boolean initiation() {
		this.simulation = ContextController.getOpenSimulation();
		this.runs = Data.getRunData().all(simulation);
		return true;

	}

	/**
	 *
	 * @return
	 */
	public List<Run> getRuns() {
		return this.runs;
	}

	/**
	 *
	 * @return
	 */
	public Run getRun(int index) {
		return this.runs.get(index);
	}

}
