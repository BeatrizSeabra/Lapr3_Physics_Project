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

	private Integer id;
	private String name;
	private String description;
	private Graph<Node, Section> graph = new Graph(true);

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

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

	private double calculateEficienty(Deque<Node> path, Vehicle vehicle) {
		Deque<Section> sections = this.getSections(path);
		double result = 0;
		for (Section section : sections) {
			result += section.getTotalForce(vehicle);
		}
		return result;
	}

	public Deque<Section> getSections(Deque<Node> nodes) {
		Deque<Section> sections = new ArrayDeque();
		if (nodes.size() <= 1) {
			return sections;
		}
		Section section;
		for (int i = 0; i < nodes.size() - 1; i++) {
			Node startNode = nodes.removeFirst();
			Node endNode = nodes.removeFirst();
			section = this.getSection(startNode, endNode);
			sections.add(section);
		}
		return sections;
	}

	public List<Deque<Node>> getAllPaths(Node starNode, Node endNode,
										 List<Deque<Section>> sectionPaths) {
		return GraphAlgorithms.
			allPaths(this.graph, starNode, endNode, sectionPaths);
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
	protected RoadNetwork clone() {
		RoadNetwork roadNetwork = new RoadNetwork();
		roadNetwork.setId(this.id);
		roadNetwork.setName(this.name);
		roadNetwork.setDescription(this.description);
		for (Node node : this.graph.elements()) {
			roadNetwork.addNode(node);
		}
		for (Edge<Node, Section> edge : this.graph.edges()) {
			roadNetwork.
				addSection(edge.getVOrig().getElement(), edge.getVDest().
						   getElement(), edge.getElement());
		}
		return roadNetwork;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Node node : this.getNodes()) {
			stringBuilder.append("Node: " + node + "\n");
		}
		for (Edge<Node, Section> edge : this.graph.edges()) {
			Section section = edge.getElement();
			stringBuilder.append("Section: '" + edge.getVOrig().
				getElement().getName() + "' '" + edge.getVDest().
				getElement().getName() + "' '" + section.getRoad() + "' '" + section.
				getTypology() + "' '" + section.getDirection() + "' '" + section.
				getToll() + "' '" + section.getWindDirection() + "' '" + section.
				getWindSpeed() + "'\n");
			for (Segment segment : edge.getElement().getSegments()) {
				stringBuilder.
					append("\tSegment: '" + segment.getName() + "' '" + segment.
						getHeight() + "' '" + segment.getSlope() + "' '" + segment.
						getLength() + "' '" + segment.
						getMaxVelocity() + "' '" + segment.
						getMinVelocity() + "' '" + segment.
						getNumberVehicles() + "'\n");
			}
		}
		return stringBuilder.toString();
	}

}
