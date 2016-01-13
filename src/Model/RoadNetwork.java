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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class RoadNetwork {

	private Integer id = 0;
	private Graph<Node, Section> origin = new Graph(true);
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
	 *
	 * @param node
	 * @return
	 */
	public Boolean addNode(Node node) {
		this.origin.insertVertex(node);
		return this.graph.insertVertex(node) != null;
	}

	/**
	 *
	 * @param startNode
	 * @param endNode
	 * @param section
	 * @return
	 */
	public Boolean addSection(Node startNode, Node endNode, Section section) {
		Double totalLength = section.getTotalLength().getValue();
		this.origin.insertEdge(startNode, endNode, section, totalLength);
		if (section.getDirection().equalsIgnoreCase("bidirectional")) {
			this.graph.
				insertEdge(endNode, startNode, section.reverse(), totalLength);
		}
		return this.graph.insertEdge(startNode, endNode, section, totalLength) != null;
	}

	/**
	 *
	 * @param name
	 * @return
	 */
	public Node getNode(String name) {
		for (Node node : this.getNodes()) {
			if (node.getName().equalsIgnoreCase(name)) {
				return node;
			}
		}
		return null;
	}

	/**
	 *
	 * @return
	 */
	public List<Node> getNodes() {
		return this.graph.vertexElements();
	}

	/**
	 *
	 * @return
	 */
	public Graph<Node, Section> getGraph() {
		return this.graph;
	}

	/**
	 *
	 * @param graph
	 */
	public void setGraph(Graph<Node, Section> graph) {
		this.graph = graph;
	}

	/**
	 *
	 * @return
	 */
	public RoadNetwork getOrigin() {
		RoadNetwork roadNetwork = new RoadNetwork();
		roadNetwork.setId(this.id);
		roadNetwork.setGraph(this.origin);
		return roadNetwork;
	}

	/**
	 *
	 * @return
	 */
	public List<Section> getSections() {
		Comparator<Section> comparator = new Comparator<Section>() {
			@Override
			public int compare(Section sec1, Section sec2) {
				if (!sec1.getRoad().equalsIgnoreCase(sec2.getRoad())) {
					return sec1.getRoad().compareTo(sec2.getRoad());
				}
				Deque<Node> nodes1 = getExtremeNodes(sec1);
				Deque<Node> nodes2 = getExtremeNodes(sec2);
				if (!nodes1.getFirst().getName().equalsIgnoreCase(nodes2.
					getFirst().getName())) {
					return nodes1.getFirst().getName().compareTo(nodes2.
						getFirst().getName());
				}
				return nodes1.getLast().getName().compareTo(nodes2.getLast().
					getName());
			}
		};
		List<Section> sections = this.graph.edgesElements();
		Collections.sort(sections, comparator);
		return sections;
	}

	/**
	 *
	 * @param startNode
	 * @param endNode
	 * @return
	 */
	public Section getSection(Node startNode, Node endNode) {
		return this.getGraph().getEdge(startNode, endNode).getElement();
	}

	/**
	 *
	 * @param nodes
	 * @return
	 */
	public List<Section> getSections(List<Node> nodes) {
		Deque<Node> nodesDeque = new ArrayDeque(nodes);
		List<Section> sections = new ArrayList();
		if (nodesDeque.size() <= 1) {
			return sections;
		}
		Section section;
		for (int i = 0; i < nodesDeque.size() - 1; i++) {
			Node startNode = nodesDeque.removeFirst();
			Node endNode = nodesDeque.removeFirst();
			section = this.getSection(startNode, endNode);
			sections.add(section);
		}
		return sections;
	}

	/**
	 *
	 * @param section
	 * @return
	 */
	public Deque<Node> getExtremeNodes(Section section) {
		return this.graph.getExtremeVertexElements(section);
	}

	/**
	 *
	 * @param starNode
	 * @param endNode
	 * @param sectionPaths
	 * @return
	 */
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
		hash += 11 * this.id.hashCode();
		for (Node node : this.getNodes()) {
			hash += 11 * node.hashCode();
		}
		for (Section section : this.getSections()) {
			hash += 11 * section.hashCode();
		}
		return hash;
	}

	@Override
	protected RoadNetwork clone() {
		RoadNetwork roadNetwork = new RoadNetwork();
		roadNetwork.setId(this.id);
		for (Node node : this.graph.vertexElements()) {
			roadNetwork.addNode(node);
		}
		for (Edge<Node, Section> edge : this.graph.getEdges()) {
			roadNetwork.
				addSection(edge.getVOrig().getElement(), edge.getVDest().
						   getElement(), edge.getElement());
		}
		return roadNetwork;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Edge<Node, Section> edge : this.graph.getEdges()) {
			Section section = edge.getElement();
			stringBuilder.append("Start ").append(edge.getVOrig().getElement()).
				append("\n");
			stringBuilder.append("End ").append(edge.getVDest().getElement()).
				append("\n");
			stringBuilder.append(section).append("\n");
			for (Segment segment : edge.getElement().getSegments()) {
				stringBuilder.append(segment).append("\n");
			}
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}

}
