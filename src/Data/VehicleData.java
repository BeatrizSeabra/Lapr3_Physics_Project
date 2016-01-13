/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Model.Project;
import Model.Vehicle;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public interface VehicleData {

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
	List<Vehicle> all(Project project);

	/**
	 *
	 * @param project
	 * @param vehicle
	 * @return
	 */
	Boolean save(Project project, Vehicle vehicle);

	/**
	 *
	 * @param project
	 * @param vehicles
	 * @return
	 */
	Boolean save(Project project, List<Vehicle> vehicles);

	/**
	 *
	 * @param project
	 * @param vehicle
	 * @return
	 */
	Vehicle get(Project project, Vehicle vehicle);

	/**
	 *
	 * @param project
	 * @param vehicle
	 * @return
	 */
	Boolean hasChanged(Project project, Vehicle vehicle);

}
