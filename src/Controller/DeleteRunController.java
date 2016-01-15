package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Model.Project;
import Model.Run;
import Model.Simulation;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class DeleteRunController {

	private Project project;
	private Simulation simulation;
	private Run run;

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
	public List<Run> getRuns() {
		return this.simulation.getRuns();
	}

	public Boolean DeleteRunSimulation(String name, String description) {

	}

}
