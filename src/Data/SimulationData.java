/*
 * To change this license header, choose License Headers in Simulation Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Model.Project;
import Model.Simulation;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public interface SimulationData {

	/**
	 *
	 * @param project
	 * @return
	 */
	Integer size(Project project);

	/**
	 *
	 * @param project
	 * @return
	 */
	List<Simulation> all(Project project);

	/**
	 *
	 * @param project
	 * @param simulation
	 * @return
	 */
	Boolean save(Project project, Simulation simulation);

	/**
	 *
	 * @param project
	 * @param simulations
	 * @return
	 */
	Boolean save(Project project, List<Simulation> simulations);

	/**
	 *
	 * @param project
	 * @param simulation
	 * @return
	 */
	Simulation get(Project project, Simulation simulation);

	/**
	 *
	 * @param project
	 * @param simulation
	 * @return
	 */
	Boolean hasChanged(Project project, Simulation simulation);

}
