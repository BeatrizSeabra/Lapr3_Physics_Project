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

	Integer size(Project project);

	List<Vehicle> all(Project project);

	Boolean save(Project project, Vehicle vehicle);

	Vehicle get(Project project, Vehicle vehicle);

	Boolean hasChanged(Project project, Vehicle vehicle);

}
