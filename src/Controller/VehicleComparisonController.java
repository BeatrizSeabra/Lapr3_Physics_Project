/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.EfficientAnalysis;
import Model.Node;
import Model.Project;
import Model.Vehicle;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class VehicleComparisonController {

	private Project project;
	private Node startNode;
	private List<Node> endsNodes;
	private List<Vehicle> vehicles;

	public void initiation() {
		this.project = ContextController.getOpenProject();
	}

	public Boolean setNodes(Node startNode, List<Node> endsNodes,
							List<Vehicle> vehicles) {
		this.startNode = startNode;
		this.endsNodes = endsNodes;
		this.vehicles = vehicles;
		return this.startNode.equals(startNode);
	}

	public List<Node> getNodes() {
		return this.project.getRoadNetwork().getNodes();
	}

	public String[] result() {
		EfficientAnalysis efficientAnalysis = new EfficientAnalysis();
		StringBuilder stringBuilder = new StringBuilder();
		for (Node endNode : this.endsNodes) {
			for (Vehicle vehicle : this.vehicles) {
				efficientAnalysis.setVehicle(vehicle);
				stringBuilder.append(";");
				stringBuilder.append(efficientAnalysis.analyze(this.project.
					getRoadNetwork(), this.startNode, endNode));
			}
		}
		return stringBuilder.substring(1).split(";");
	}

	public Boolean save(String filePath) {
		return true;
	}

}
