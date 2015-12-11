/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Legacy;

import Model.Vehicle;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author LAPR3_20152016_G27
 */
public abstract class Legacy {

	public static String stringFile(String filePath) {
		try {
			return new Scanner(new FileReader(filePath)).useDelimiter("\\Z").
				next();
		} catch (Exception ex) {
			return null;
		}
	}

	public static List<Vehicle> importVehicles(String filePath) {
		String data = Legacy.stringFile(filePath);
		return new VehicleImportXML().importData(data);
	}

}
