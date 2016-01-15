/*
 * To change this license header, choose License Headers in Simulation Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Model.Run;
import Model.Simulation;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public interface RunData {

	/**
	 *
	 * @param simulation
	 * @return
	 */
	Integer size(Simulation simulation);

	/**
	 *
	 * @param simulation
	 * @return
	 */
	List<Run> all(Simulation simulation);

	/**
	 *
	 * @param simulation
	 * @param run
	 * @return
	 */
	Boolean save(Simulation simulation, Run run);

	/**
	 *
	 * @param simulation
	 * @param runs
	 * @return
	 */
	Boolean save(Simulation simulation, List<Run> runs);

	/**
	 *
	 * @param simulation
	 * @param run
	 * @return
	 */
	Run get(Simulation simulation, Run run);

	/**
	 *
	 * @param simulation
	 * @param run
	 * @return
	 */
	Boolean hasChanged(Simulation simulation, Run run);

	Boolean remove(Simulation simulation, Run run);

}
