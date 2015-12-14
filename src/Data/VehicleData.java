/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Model.Vehicle;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public interface VehicleData {

	Vehicle newInstance();

	Integer size();

	List<Vehicle> all();

	Boolean save(Vehicle vehicle);

	Vehicle copy(Vehicle vehicle);

	Vehicle clone(Vehicle vehicle);

	Vehicle get(Integer id);

	Boolean hasChanged(Vehicle vehicle);

}
