/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author LAPR3_20152016_G27
 */
public abstract class Data {

	static private ProjectData projectData = new ProjectDataLocal();

	static public ProjectData getProjectData() {
		return Data.projectData;
	}

}
