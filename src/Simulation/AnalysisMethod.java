/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simulation;

import Model.Node;
import Model.RoadNetwork;
import Model.Section;
import Model.Vehicle;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public abstract class AnalysisMethod {

	protected String name;
	protected List<Vehicle> vehicles = new ArrayList();
	protected List<RoadNetwork> roadNetworks = new ArrayList();
	protected List<Node> startNodes = new ArrayList();
	protected List<Node> endNodes = new ArrayList();
	protected List<Deque<Section>> bestPaths = new ArrayList();
	protected List<List<String[]>> results = new ArrayList();

	public List<String[]> result(Vehicle vehicle, RoadNetwork roadNetwork,
								 Node startNode, Node endNode) {
		int size = this.results.size();
		for (int i = 0; i < size; i++) {
			if (this.vehicles.get(i).equals(vehicle) && this.roadNetworks.get(i).
				equals(roadNetwork) && this.startNodes.get(i).equals(startNode) && this.endNodes.
				get(i).equals(endNodes)) {
				return this.results.get(i);
			}
		}
		this.analyze(vehicle, roadNetwork, startNode, endNode);
		return this.results.get(size);
	}

	public Deque<Section> path(Vehicle vehicle, RoadNetwork roadNetwork,
							   Node startNode, Node endNode) {
		int size = this.bestPaths.size();
		for (int i = 0; i < size; i++) {
			if (this.vehicles.get(i).equals(vehicle) && this.roadNetworks.get(i).
				equals(roadNetwork) && this.startNodes.get(i).equals(startNode) && this.endNodes.
				get(i).equals(endNodes)) {
				return this.bestPaths.get(i);
			}
		}
		this.analyze(vehicle, roadNetwork, startNode, endNode);
		return this.bestPaths.get(size);
	}

	abstract void analyze(Vehicle vehicle, RoadNetwork roadNetwork,
						  Node startNode, Node endNode);

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.getName();
	}

}
