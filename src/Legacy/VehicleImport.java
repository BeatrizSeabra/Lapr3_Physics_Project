/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Legacy;

import Model.Vehicle;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public interface VehicleImport {

	List<Vehicle> importData(String data);

}