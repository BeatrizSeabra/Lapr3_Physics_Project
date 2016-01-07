/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Data.Data;
import Legacy.Legacy;
import Model.Project;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class AddRoadsController {

	private Project project;
	private List<Project> roads;

	public void initiation() {
		this.project = ContextController.getOpenProject();

	}

	public List<Project> getRoads() {
		return this.roads;
	}

	public Boolean loadRoads(String filePath) {
		List<Project> roads = Legacy.importRoadNetwork(filePath);
		if (roads != null) {
			this.concatenateRoads(this.roads, roads);
			return true;
		}
		return false;
	}

	public void concatenateRoads(List<Project> roads,
								 List<Project> newRoads) {
		for (Project newRoad : newRoads) {
			Integer number = 1;
			while (this.quantityName(roads, newRoad.getName()) != 0) {
				if (number == 1) {
					newRoad.setName(newRoad.getName() + " " + number);
				} else {
					newRoad.setName(newRoad.getName().
						replaceAll(" [0-9]+$", " " + number));
				}
				number++;
			}
			roads.add(newRoad);
		}
	}

	public Integer quantityName(List<Project> roads, String name) {
		Integer amount = 0;
		for (Project road : roads) {
			if (road.getName().equals(name)) {
				amount++;
			}
		}
		return amount;
	}

	public Boolean hasChanges() {
		return !this.roads.equals(this.project.getRoadNetwork());
	}

	public Boolean saveProjectRoads() {
		for (Project road : this.roads) {

		}
		return Data.getProjectData().save(this.project);
	}

}
