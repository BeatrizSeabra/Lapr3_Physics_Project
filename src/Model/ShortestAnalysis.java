/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Deque;

/**
 *
 * @author ruben
 */
public class ShortestAnalysis {

	private Project project;

	public String analyze(RoadNetwork roadNetwork, Node startNode, Node endNode) {
		Deque<Node> nodes = project.getRoadNetwork().
			shortestPath(startNode, endNode);
		StringBuilder string = new StringBuilder();
		for (Node node : nodes) {
			string.append(node.toString());
			string.append(" ");
		}
		return string.toString();
	}
}
