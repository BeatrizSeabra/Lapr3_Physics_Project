/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Data.Data;
import Legacy.Legacy;
import Model.Project;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class AddRoadsController {

	private Project project;
	private List<Project> roads = new ArrayList<Project>();

	/**
	 *
	 */
	public void initiation() {
		this.project = ContextController.getOpenProject();

	}

	/**
	 *
	 * @return
	 */
	public List<Project> getRoads() {
		return this.roads;
	}

	/**
	 *
	 * @param filePath
	 * @return
	 */
	public Boolean loadRoads(String filePath) {
		List<Project> roads = Legacy.importRoadNetwork(filePath);
		if (roads != null) {
			this.concatenateRoads(roads);
			return true;
		}
		return false;
	}

	/**
	 *
	 * @param newRoads
	 */
	public void concatenateRoads(List<Project> newRoads) {
            if(newRoads.isEmpty()!=true){
		for (Project newRoad : newRoads) {
                    this.roads.add(newRoad);
		}
            }
	}

	/**
	 *
	 * @return
	 */
	public Boolean hasChanges(){
		return !this.roads.equals(this.project.getRoadNetwork());
	}

	/**
	 *
	 * @return
	 */
	public Boolean saveProjectRoads() {
		for (Project road : this.roads) {
                    this.project.getRoadNetwork().addRoadNetwork(road.getRoadNetwork());
		}
		return Data.getProjectData().save(this.project);
	}

}
