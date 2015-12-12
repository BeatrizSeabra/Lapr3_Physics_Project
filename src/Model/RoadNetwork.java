/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Graph.Graph;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class RoadNetwork {

	private Graph<Node, Section> graph = new Graph(true);

	public Boolean addNode(Node node) {
		return this.graph.insertVertex(node) != null;
	}

	public Boolean addSection(Node startNode, Node endNode, Section section) {
		return this.graph.insertEdge(startNode, endNode, section, section.
									 getTotalLength().getValue()) != null;
	}

	@Override
	public String toString() {
		return this.graph.toString();
	}

}
