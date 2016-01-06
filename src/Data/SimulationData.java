/*
 * To change this license header, choose License Headers in Simulation Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Model.Simulation;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public interface SimulationData {

	Simulation newInstance();

	Integer size();

	List<Simulation> all();

	Boolean save(Simulation simulation);

	Simulation copy(Simulation simulation);

	Simulation clone(Simulation simulation);

	Simulation get(Integer id);

	Boolean hasChanged(Simulation simulation);

}
