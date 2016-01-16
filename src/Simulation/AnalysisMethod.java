/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simulation;

import Model.Node;
import Model.RoadNetwork;
import Model.Section;
import Model.Segment;
import Model.Step;
import Model.Vehicle;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public abstract class AnalysisMethod {

	protected List<Vehicle> vehicles = new ArrayList();
	protected List<RoadNetwork> roadNetworks = new ArrayList();
	protected List<Node> startNodes = new ArrayList();
	protected List<Node> endNodes = new ArrayList();
	protected List<Deque<Section>> bestPaths = new ArrayList();
	protected List<List<String[]>> results = new ArrayList();

	public List<String[]> result(Vehicle vehicle, Node startNode, Node endNode,
								 RoadNetwork roadNetwork) {
		int size = this.results.size();
		for (int i = 0; i < size; i++) {
			if (this.vehicles.get(i).equals(vehicle) && this.roadNetworks.get(i).
				equals(roadNetwork) && this.startNodes.get(i).equals(startNode) && this.endNodes.
				get(i).equals(endNodes)) {
				return this.results.get(i);
			}
		}
		this.analyze(vehicle, startNode, endNode, roadNetwork);
		return this.results.get(size);
	}

	public Deque<Section> path(Vehicle vehicle, Node startNode, Node endNode,
							   RoadNetwork roadNetwork) {
		int size = this.bestPaths.size();
		for (int i = 0; i < size; i++) {
			if (this.vehicles.get(i).equals(vehicle) && this.roadNetworks.get(i).
				equals(roadNetwork) && this.startNodes.get(i).equals(startNode) && this.endNodes.
				get(i).equals(endNodes)) {
				return this.bestPaths.get(i);
			}
		}
		this.analyze(vehicle, startNode, endNode, roadNetwork);
		return this.bestPaths.get(size);
	}

	public abstract List<Section> analyze(Vehicle vehicle, Node startNode,
										  Node endNode, RoadNetwork roadNetwork);

	public abstract List<Step> analyze(Vehicle vehicle, Node startNode,
									   Node endNode, List<Section> sections);

	public abstract Step analyze(Vehicle vehicle, Section section,
								 Segment segment);

	/**
	 * @return the name
	 */
	public abstract String getName();

	@Override
	public String toString() {
		return this.getName();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		AnalysisMethod other = (AnalysisMethod) obj;
		if (other == null) {
			return false;
		}
		return this.hashCode() == other.hashCode();
	}

	@Override
	public int hashCode() {
		int hash = 29 * this.getClass().hashCode();
		hash += 11 * this.getName().hashCode();
		return hash;
	}

}
