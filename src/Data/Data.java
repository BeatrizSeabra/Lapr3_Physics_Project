/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import System.Settings;

/**
 *
 * @author LAPR3_20152016_G27
 */
public abstract class Data {

	static private Repository repository = (Repository) Settings.
		loadClass(Settings.getOption("Repository"));

	static public ProjectData getProjectData() {
		return Data.repository.getProjectData();
	}

	static public VehicleData getVehicleData() {
		return Data.repository.getVehicleData();
	}

	public static SimulationData getSimulationData() {
		return Data.repository.getSimulationData();
	}

}
