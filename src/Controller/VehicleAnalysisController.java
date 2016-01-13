/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Node;
import Model.RoadNetwork;
import Model.Vehicle;
import Simulation.VehicleAnalysis;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class VehicleAnalysisController {

	private VehicleAnalysis vehicleAnalysis;
	private RoadNetwork roadNetwork;
	private Node startNode;
	private List<Node> endNodes;
	private List<Vehicle> vehicles;

	/**
	 *
	 */
	public void initiation() {
		this.roadNetwork = ContextController.getOpenProject().getRoadNetwork();
	}

	/**
	 *
	 * @param vehicleAnalysis
	 */
	public void setVehicleAnalysis(VehicleAnalysis vehicleAnalysis) {
		this.vehicleAnalysis = vehicleAnalysis;
	}

	/**
	 *
	 * @param startNode
	 * @param endsNodes
	 * @param vehicles
	 * @return
	 */
	public Boolean setNodes(Node startNode, List<Node> endsNodes,
							List<Vehicle> vehicles) {
		this.startNode = startNode;
		this.endNodes = endsNodes;
		this.vehicles = vehicles;
		return this.startNode.equals(startNode);
	}

	/**
	 *
	 * @return
	 */
	public List<Node> getNodes() {
		return this.roadNetwork.getNodes();
	}

	/**
	 *
	 * @return
	 */
	public List<List<String[]>> analyze() {
		List<List<String[]>> results = new ArrayList();
		for (Node endNode : this.endNodes) {
			for (Vehicle vehicle : this.vehicles) {
				List<String[]> result = this.vehicleAnalysis.
					analyze(vehicle, this.roadNetwork, this.startNode, endNode);
				if (result != null && !result.isEmpty()) {
					results.add(result);
				}
			}
		}
		return results;
	}

}
