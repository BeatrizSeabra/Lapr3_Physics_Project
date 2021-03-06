/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Node;
import Model.RoadNetwork;
import Simulation.PathAnalysis;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class PathAnalysisController {

	private PathAnalysis pathAnalysis;
	private RoadNetwork roadNetwork;
	private Node startNode;
	private List<Node> endNodes;

	/**
	 *
	 */
	public void initiation() {
		this.roadNetwork = ContextController.getOpenProject().getRoadNetwork();
	}

	/**
	 *
	 * @param pathAnalysis
	 */
	public void setPathAnalysis(PathAnalysis pathAnalysis) {
		this.pathAnalysis = pathAnalysis;
	}

	/**
	 *
	 * @param startNode
	 * @param endNodes
	 * @return
	 */
	public Boolean setNodes(Node startNode, List<Node> endNodes) {
		this.startNode = startNode;
		this.endNodes = endNodes;
		return this.startNode.equals(startNode) && this.endNodes.
			equals(endNodes);
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
			List<String[]> result = this.pathAnalysis.
				analyze(this.roadNetwork, this.startNode, endNode);
			if (result != null && !result.isEmpty()) {
				results.add(result);
			}
		}
		return results;
	}

}
