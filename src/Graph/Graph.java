package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author DEI-ESINF
 * @param <V>
 * @param <E>
 */
public class Graph<V, E> implements GraphInterface<V, E> {

	private int numVert;
	private int numEdge;
	private boolean isDirected;
	private ArrayList<Vertex<V, E>> listVert;  //Vertice list

	// Constructs an empty graph (either undirected or directed)
	public Graph(boolean directed) {
		numVert = 0;
		numEdge = 0;
		isDirected = directed;
		listVert = new ArrayList<>();
	}

	public int numVertices() {
		return numVert;
	}

	public Iterable<Vertex<V, E>> vertices() {
		return listVert;
	}

	public int numEdges() {
		return numEdge;
	}

	public boolean containsVertex(V element) {
		return this.getVertex(element) != null;
	}

	public boolean containsVertex(Vertex<V, E> vertex) {
		return this.getVertex(vertex) != null;
	}

	public boolean containsEdge(V elementOrigin, V elementDestination) {
		return this.getEdge(elementOrigin, elementDestination) != null;
	}

	public boolean containsEdge(Vertex<V, E> vertexOrigin,
								Vertex<V, E> elementDestination) {
		return this.getEdge(vertexOrigin, elementDestination) != null;
	}

	public Iterable<Edge<V, E>> edges() {

		ArrayList<Edge<V, E>> listEdge = new ArrayList<>();
		for (Vertex<V, E> vert : this.listVert) {
			for (Edge<V, E> edge : vert.getOutgoing().values()) {
				if (edge != null) {
					listEdge.add(edge);
				}
			}
		}

		return listEdge;
	}

	public Edge<V, E> getEdge(V elementOrigin, V elementDestination) {
		Vertex<V, E> vertexOrigin = getVertex(elementOrigin);
		Vertex<V, E> vertexDestination = getVertex(elementDestination);
		return this.getEdge(vertexOrigin, vertexDestination);
	}

	public Edge<V, E> getEdge(Vertex<V, E> vorig, Vertex<V, E> vdest) {

		if (listVert.contains(vorig) && listVert.contains(vdest)) {
			return vorig.getOutgoing().get(vdest);
		}

		return null;
	}

	public Deque<V> getExtremeVertexElements(E element) {
		Deque<V> nodes = new ArrayDeque();
		for (Vertex<V, E> vertex : listVert) {
			for (Map.Entry<Vertex<V, E>, Edge<V, E>> entrySet : vertex.
				getOutgoing().entrySet()) {
				if (entrySet.getValue().getElement().equals(element)) {
					nodes.add(vertex.getElement());
					nodes.add(entrySet.getKey().getElement());
				}
			}
		}
		return nodes;
	}

	public Vertex<V, E>[] endVertices(Edge<V, E> e) {

		if (e != null) {
			Vertex<V, E> vorig = e.getVOrig();
			Vertex<V, E> vdest = e.getVDest();
			if (vorig != null & vdest != null) {
				if (e.equals(vorig.getOutgoing().get(vdest))) {
					return e.getEndpoints();
				}
			}
		}

		return null;
	}

	public Vertex<V, E> opposite(Vertex<V, E> vert, Edge<V, E> e) {

		Vertex<V, E> vOrig = e.getVOrig();
		Vertex<V, E> vDest = e.getVDest();
		if (vert.equals(vOrig)) {
			return vDest;
		} else if (vert.equals(vDest)) {
			return vOrig;
		} else {
			return null;
		}
	}

	public int outDegree(Vertex<V, E> v) {

		if (listVert.contains(v)) {
			return v.getOutgoing().size();
		} else {
			return -1;
		}
	}

	public int inDegree(Vertex<V, E> v) {

		if (listVert.contains(v)) {
			Iterable<Edge<V, E>> listEdges = edges();
			int inDegree = 0;
			for (Edge e : listEdges) {
				if (e.getVDest().equals(v)) {
					inDegree++;
				}
			}
			return inDegree;
		} else {
			return -1;
		}
	}

	public Iterable<Edge<V, E>> outgoingEdges(Vertex<V, E> v) {

		if (!listVert.contains(v)) {
			return null;
		}

		ArrayList<Edge<V, E>> edges = new ArrayList<>();

		Map<Vertex<V, E>, Edge<V, E>> map = v.getOutgoing();
		Iterator<Map.Entry<Vertex<V, E>, Edge<V, E>>> it = map.entrySet().
			iterator();
		while (it.hasNext()) {
			edges.add(it.next().getValue());
		}

		return edges;
	}

	public Iterable<Edge<V, E>> incomingEdges(Vertex<V, E> v) {

		if (listVert.contains(v)) {
			Iterable<Edge<V, E>> listEdges = edges();
			ArrayList<Edge<V, E>> listIncomingEdges = new ArrayList<>();
			for (Edge e : listEdges) {
				if (e.getVDest().equals(v)) {
					listIncomingEdges.add(e);
				}
			}
			return listIncomingEdges;
		} else {
			return null;
		}
	}

	public Vertex<V, E> insertVertex(V vInf) {

		Vertex<V, E> vert = getVertex(vInf);
		if (vert == null) {
			Vertex<V, E> newvert = new Vertex<>(numVert, vInf);
			listVert.add(newvert);
			numVert++;
			return newvert;
		}
		return vert;
	}

	public Edge<V, E> insertEdge(V vOrig, V vDest, E eInf, double eWeight) {

		Vertex<V, E> vorig = getVertex(vOrig);
		if (vorig == null) {
			vorig = insertVertex(vOrig);
		}

		Vertex<V, E> vdest = getVertex(vDest);
		if (vdest == null) {
			vdest = insertVertex(vDest);
		}

		if (getEdge(vorig, vdest) == null) {
			Edge<V, E> newedge = new Edge<>(eInf, eWeight, vorig, vdest);
			vorig.getOutgoing().put(vdest, newedge);
			numEdge++;

			//if graph is not direct insert other edge in the opposite direction
			if (!isDirected) {
				if (getEdge(vdest, vorig) == null) {
					Edge<V, E> otheredge = new Edge<>(eInf, eWeight, vdest, vorig);
					vdest.getOutgoing().put(vorig, otheredge);
					numEdge++;
				}
			}

			return newedge;
		}
		return null;
	}

	public void removeVertex(V vInf) {

		Vertex<V, E> vert = getVertex(vInf);
		if (vert != null) {

			for (Edge<V, E> e : edges()) {
				if (e.getVDest().equals(vert) || e.getVOrig().equals(vert)) {
					removeEdge(e);
				}
			}
			listVert.remove(vert);
			numVert--;

			int cont = 0;
			for (Vertex<V, E> v : vertices()) {
				v.setKey(cont);
				cont++;
			}
		}
	}

	public boolean removeEdge(Edge<V, E> edge) {
		int numEdgeTemp = numEdge - 1;
		Vertex<V, E>[] endpoints = endVertices(edge);
		Vertex<V, E> vorig = endpoints[0];
		Vertex<V, E> vdest = endpoints[1];
		if (vorig != null && vdest != null) {
			if (edge.equals(getEdge(vorig, vdest))) {
				vorig.getOutgoing().remove(vdest);
				numEdge--;
			}
		}
		return numEdgeTemp == numEdge;
	}

	public boolean removeEdge(V elementOrigin, V elementDestination) {
		Vertex<V, E> vertexOrig = getVertex(elementOrigin);
		Vertex<V, E> vertexDest = getVertex(elementDestination);
		Edge<V, E> edge = getEdge(vertexOrig, vertexDest);
		if (edge != null) {
			return removeEdge(edge);
		}
		return false;
	}

	public Vertex<V, E> getVertex(V element) {
		for (Vertex<V, E> vertex : this.listVert) {
			if (element.equals(vertex.getElement())) {
				return vertex;
			}
		}
		return null;
	}

	public Vertex<V, E> getVertex(Vertex<V, E> element) {
		for (Vertex<V, E> vertex : this.listVert) {
			if (element.equals(vertex)) {
				return vertex;
			}
		}
		return null;
	}

	public Vertex<V, E> getVertex(int index) {
		if (index < listVert.size()) {
			return listVert.get(index);
		}
		return null;
	}

	public List<V> elements() {
		List<V> elements = new ArrayList();
		for (Vertex<V, E> vertex : this.listVert) {
			elements.add(vertex.getElement());
		}
		return elements;
	}

	public List<V> beginsElements() {
		List<V> elements = new ArrayList();
		for (Vertex<V, E> vertex : this.listVert) {
			if (this.inDegree(vertex) == 0) {
				elements.add(vertex.getElement());
			}
		}
		return elements;
	}

	public List<V> endsElements() {
		List<V> elements = new ArrayList();
		for (Vertex<V, E> vertex : this.listVert) {
			if (this.outDegree(vertex) == 0) {
				elements.add(vertex.getElement());
			}
		}
		return elements;
	}

	public List<Vertex<V, E>> incomingVertices(Vertex<V, E> vertex) {
		if (vertex != null && this.containsVertex(vertex)) {
			List<Vertex<V, E>> vertices = new ArrayList();
			for (Edge<V, E> edge : this.incomingEdges(vertex)) {
				vertices.add(edge.getVOrig());
			}
			return vertices;
		}
		return null;
	}

	public List<Vertex<V, E>> outgoingVertices(Vertex<V, E> vertex) {
		if (vertex != null && this.containsVertex(vertex)) {
			List<Vertex<V, E>> vertices = new ArrayList();
			for (Edge<V, E> edge : this.outgoingEdges(vertex)) {
				vertices.add(edge.getVDest());
			}
			return vertices;
		}
		return null;
	}

	public List<V> incomingElements(V element) {
		Vertex<V, E> elementVertex = this.getVertex(element);
		List<Vertex<V, E>> vertices = this.incomingVertices(elementVertex);
		return this.verticesToElement(vertices);
	}

	public List<V> outgoingElements(V element) {
		Vertex<V, E> elementVertex = this.getVertex(element);
		List<Vertex<V, E>> vertices = this.outgoingVertices(elementVertex);
		return this.verticesToElement(vertices);
	}

	public List<V> verticesToElement(List<Vertex<V, E>> vertices) {
		if (vertices != null) {
			List<V> elements = new ArrayList();
			for (Vertex<V, E> vertex : vertices) {
				elements.add(vertex.getElement());
			}
			return elements;
		}
		return null;
	}

	//Returns a clone of the graph
	public Graph<V, E> clone() {

		Graph<V, E> newObject = new Graph<>(this.isDirected);

		newObject.numVert = this.numVert;

		newObject.listVert = new ArrayList<>();
		for (Vertex<V, E> v : this.listVert) {
			newObject.listVert.add(new Vertex<V, E>(v.getKey(), v.getElement()));
		}

		for (Vertex<V, E> v1 : this.listVert) {
			for (Edge<V, E> e : this.outgoingEdges(v1)) {
				if (e != null) {
					Vertex<V, E> v2 = this.opposite(v1, e);
					newObject.insertEdge(v1.getElement(), v2.getElement(),
										 e.getElement(), e.getWeight());
				}
			}
		}
		return newObject;
	}

	/* equals implementation
	 * @param the other graph to test for equality
	 * @return true if both objects represent the same graph
	 */
	public boolean equals(Object oth) {

		if (oth == null) {
			return false;
		}

		if (this == oth) {
			return true;
		}

		if (!(oth instanceof Graph<?, ?>)) {
			return false;
		}

		Graph<?, ?> other = (Graph<?, ?>) oth;

		if (numVert != other.numVert || numEdge != other.numEdge) {
			return false;
		}

		//graph must have same vertices
		boolean eqvertex;
		for (Vertex<V, E> v1 : this.vertices()) {
			eqvertex = false;
			for (Vertex<?, ?> v2 : other.vertices()) {
				if (v1.equals(v2)) {
					eqvertex = true;
				}
			}

			if (!eqvertex) {
				return false;
			}
		}

		//graph must have same edges
		boolean eqedge;
		for (Edge<V, E> e1 : this.edges()) {
			eqedge = false;
			for (Edge<?, ?> e2 : other.edges()) {
				if (e1.equals(e2)) {
					eqedge = true;
				}
			}

			if (!eqedge) {
				return false;
			}
		}

		return true;
	}

	//string representation
	@Override
	public String toString() {
		String s = "";
		if (numVert == 0) {
			s = "\nGraph not defined!!";
		} else {
			s = "Graph: " + numVert + " vertices, " + numEdge + " edges\n";
			for (Vertex<V, E> vert : listVert) {
				s += vert + "\n";
				if (!vert.getOutgoing().isEmpty()) {
					for (Map.Entry<Vertex<V, E>, Edge<V, E>> entry : vert.
						getOutgoing().entrySet()) {
						s += entry.getValue() + "\n";
					}
				} else {
					s += "\n";
				}
			}
		}
		return s;
	}

}
