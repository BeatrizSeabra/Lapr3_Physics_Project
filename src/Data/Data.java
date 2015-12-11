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
		loadClass(Settings.getConfiguration("ProjectData").get(0));

	static public ProjectData getProjectData() {
		return Data.projectData;
	}

}
