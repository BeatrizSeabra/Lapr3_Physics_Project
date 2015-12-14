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

	static private ProjectData projectData = (ProjectData) Settings.
		loadClass(Settings.getOption("ProjectData"));

	static private VehicleData vehicleData = (VehicleData) Settings.
		loadClass(Settings.getOption("VehicleData"));

	static public ProjectData getProjectData() {
		return Data.projectData;
	}

	static public VehicleData getVehicleData() {
		return Data.vehicleData;
	}

}
