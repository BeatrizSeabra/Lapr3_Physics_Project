/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Graph.Edge;
import Graph.Graph;
import Graph.GraphAlgorithms;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class RoadNetwork {

	private String name;
	private String description;
	private Graph<Node, Section> graph = new Graph(true);

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

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean addNode(Node node) {
		return this.graph.insertVertex(node) != null;
	}

	public Boolean addSection(Node startNode, Node endNode, Section section) {
		return this.graph.insertEdge(startNode, endNode, section, section.
									 getTotalLength().getValue()) != null;
	}

	public List<Node> getNodes() {
		return this.graph.elements();
	}

	public Graph<Node, Section> getGraph() {
		return this.graph;
	}

	public Section getSection(Node startNode, Node endNode) {
		return this.getGraph().getEdge(startNode, endNode).getElement();
	}

	public Deque<Node> shortestPath(Node startNode, Node endNode) {
		Deque<Node> shortestPath = new ArrayDeque();
		GraphAlgorithms.
			shortestPath(this.graph, startNode, endNode, shortestPath);
		return shortestPath;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		RoadNetwork other = (RoadNetwork) obj;
		if (other == null) {
			return false;
		}
		return this.hashCode() == other.hashCode();
	}

	@Override
	public int hashCode() {
		int hash = 29 * this.getClass().hashCode();
		for (Node node : this.graph.elements()) {
			hash += 11 * node.hashCode();
		}
		for (Edge<Node, Section> edge : this.graph.edges()) {
			hash += 11 * edge.getElement().hashCode();
		}
		return hash;
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder("Road Network: \n");
		for (Node node : this.getNodes()) {
			string.append("\tNode: " + node + "\n");
		}
		for (Edge<Node, Section> edge : this.graph.edges()) {
			Section section = edge.getElement();
			string.append("\tSection: '" + edge.getVOrig().
				getElement().getName() + "' '" + edge.getVDest().
				getElement().getName() + "' '" + section.getRoad() + "' '" + section.
				getTypology() + "' '" + section.getDirection() + "' '" + section.
				getToll() + "' '" + section.getWindDirection() + "' '" + section.
				getWindSpeed() + "'\n");
			for (Segment segment : edge.getElement().getSegments()) {
				string.
					append("\t\tSegment: '" + segment.getName() + "' '" + segment.
						getHeight() + "' '" + segment.getSlope() + "' '" + segment.
						getLength() + "' '" + segment.getRrc() + "' '" + segment.
						getMaxVelocity() + "' '" + segment.
						getMinVelocity() + "' '" + segment.
						getNumberVehicles() + "'\n");
			}
		}
		return string.toString();
	}

}
