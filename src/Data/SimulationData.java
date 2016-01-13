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

	Integer size(Project project);

	List<Simulation> all(Project project);

	Boolean save(Project project, Simulation simulation);

	Boolean save(Project project, List<Simulation> simulations);

	Simulation get(Project project, Simulation simulation);

	Boolean hasChanged(Project project, Simulation simulation);

}
