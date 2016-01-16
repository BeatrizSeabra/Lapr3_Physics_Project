package Graph;

import java.util.ArrayList;
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

	private boolean isDirected = true;
	private List<Vertex<V, E>> listVertex = new ArrayList();
	private List<Edge<V, E>> listEdges = new ArrayList();

	// Constructs an empty graph (either undirected or directed)
	/**
	 *
	 * @param directed
	 */
	public Graph(boolean directed) {
		this.isDirected = directed;
	}

	/**
	 *
	 * @return
	 */
	public int numVertices() {
		return this.listVertex.size();
	}

	/**
	 *
	 * @return
	 */
	public Iterable<Vertex<V, E>> vertices() {
		return this.listVertex;
	}

	/**
	 *
	 * @return
	 */
	public int numEdges() {
		return this.listEdges.size();
	}

	/**
	 *
	 * @return
	 */
	public Iterable<Edge<V, E>> getEdges() {
		return new ArrayList(this.listEdges);
	}

	/**
	 *
	 * @param elementOrigin
	 * @param elementDestination
	 * @return
	 */
	public Edge<V, E> getEdge(V elementOrigin, V elementDestination) {
		Vertex<V, E> vertexOrigin = getVertex(elementOrigin);
		Vertex<V, E> vertexDestination = getVertex(elementDestination);
		return this.getEdge(vertexOrigin, vertexDestination);
	}

	/**
	 *
	 * @param vorig
	 * @param vdest
	 * @return
	 */
	public Edge<V, E> getEdge(Vertex<V, E> vorig, Vertex<V, E> vdest) {
		if (this.listVertex.contains(vorig) && this.listVertex.contains(vdest)) {
			return vorig.getOutgoing().get(vdest);
		}
		return null;
	}

	/**
	 *
	 * @param element
	 * @return
	 */
	public V getFirstVertexElement(E element) {
		for (Vertex<V, E> vertex : this.listVertex) {
			for (Map.Entry<Vertex<V, E>, Edge<V, E>> entrySet : vertex.
				getOutgoing().entrySet()) {
				if (entrySet.getValue().getElement().equals(element)) {
					return entrySet.getValue().getVOrig().getElement();
				}
			}
		}
		return null;
	}

	/**
	 *
	 * @param element
	 * @return
	 */
	public V getLastVertexElement(E element) {
		for (Vertex<V, E> vertex : this.listVertex) {
			for (Map.Entry<Vertex<V, E>, Edge<V, E>> entrySet : vertex.
				getOutgoing().entrySet()) {
				if (entrySet.getValue().getElement().equals(element)) {
					return entrySet.getValue().getVDest().getElement();
				}
			}
		}
		return null;
	}

	/**
	 *
	 * @param e
	 * @return
	 */
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

	/**
	 *
	 * @param vert
	 * @param e
	 * @return
	 */
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
		if (this.listVertex.contains(v)) {
			return v.getOutgoing().size();
		} else {
			return -1;
		}
	}

	public int inDegree(Vertex<V, E> v) {
		if (this.listVertex.contains(v)) {
			Iterable<Edge<V, E>> listEdges = getEdges();
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

	/**
	 *
	 * @param v
	 * @return
	 */
	public Iterable<Edge<V, E>> outgoingEdges(Vertex<V, E> v) {
		if (!this.listVertex.contains(v)) {
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

	/**
	 *
	 * @param v
	 * @return
	 */
	public Iterable<Edge<V, E>> incomingEdges(Vertex<V, E> v) {
		if (this.listVertex.contains(v)) {
			Iterable<Edge<V, E>> listEdges = getEdges();
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

	/**
	 *
	 * @param vInf
	 * @return
	 */
	public Vertex<V, E> insertVertex(V vInf) {
		Vertex<V, E> vert = getVertex(vInf);
		if (vert == null) {
			Vertex<V, E> newvert = new Vertex(this.listVertex.size(), vInf);
			this.listVertex.add(newvert);
			return newvert;
		}
		return vert;
	}

	/**
	 *
	 * @param vOrig
	 * @param vDest
	 * @param eInf
	 * @param eWeight
	 * @return
	 */
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
			this.listEdges.add(newedge);
			if (!this.isDirected) {
				if (getEdge(vdest, vorig) == null) {
					Edge<V, E> otheredge = new Edge<>(eInf, eWeight, vdest, vorig);
					vdest.getOutgoing().put(vorig, otheredge);
					this.listEdges.add(otheredge);
				}
			}
			return newedge;
		}
		return null;
	}

	/**
	 *
	 * @param vInf
	 */
	@Override
	public void removeVertex(V vInf) {
		Vertex<V, E> vert = getVertex(vInf);
		if (vert != null) {
			for (Edge<V, E> e : getEdges()) {
				if (e.getVDest().equals(vert) || e.getVOrig().equals(vert)) {
					removeEdge(e);
				}
			}
			this.listVertex.remove(vert);
			int cont = 0;
			for (Vertex<V, E> v : vertices()) {
				v.setKey(cont);
				cont++;
			}
		}
	}

	/**
	 *
	 * @param edge
	 * @return
	 */
	@Override
	public boolean removeEdge(Edge<V, E> edge) {
		int numTemp = this.listEdges.size() - 1;
		Vertex<V, E>[] endpoints = endVertices(edge);
		Vertex<V, E> vorig = endpoints[0];
		Vertex<V, E> vdest = endpoints[1];
		if (vorig != null && vdest != null) {
			if (edge.equals(getEdge(vorig, vdest))) {
				vorig.getOutgoing().remove(vdest);
				this.listEdges.remove(edge);
			}
		}
		return numTemp == this.listEdges.size();
	}

	/**
	 *
	 * @param element
	 * @return
	 */
	public Vertex<V, E> getVertex(V element) {
		for (Vertex<V, E> vertex : this.listVertex) {
			if (element.equals(vertex.getElement())) {
				return vertex;
			}
		}
		return null;
	}

	/**
	 *
	 * @param index
	 * @return
	 */
	public Vertex<V, E> getVertex(int index) {
		if (index < this.listVertex.size()) {
			return this.listVertex.get(index);
		}
		return null;
	}

	/**
	 *
	 * @return
	 */
	public List<V> vertexElements() {
		List<V> elements = new ArrayList();
		for (Vertex<V, E> vertex : this.listVertex) {
			elements.add(vertex.getElement());
		}
		return elements;
	}

	/**
	 *
	 * @return
	 */
	public List<E> edgesElements() {
		List<E> elements = new ArrayList();
		for (Edge<V, E> edge : this.listEdges) {
			elements.add(edge.getElement());
		}
		return elements;
	}

	//Returns a clone of the graph
	public Graph<V, E> clone() {
		Graph<V, E> newObject = new Graph<>(this.isDirected);
		newObject.listVertex = new ArrayList<>();
		for (Vertex<V, E> v : this.listVertex) {
			newObject.listVertex.
				add(new Vertex<V, E>(v.getKey(), v.getElement()));
		}
		for (Vertex<V, E> v1 : this.listVertex) {
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
		if (this.listVertex.size() != other.listVertex.size() || listEdges.
			size() != other.listEdges.
			size()) {
			return false;
		}
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
		boolean eqedge;
		for (Edge<V, E> e1 : this.getEdges()) {
			eqedge = false;
			for (Edge<?, ?> e2 : other.getEdges()) {
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
		if (this.listVertex.size() == 0) {
			s = "\nGraph not defined!!";
		} else {
			s = "Graph: " + this.listVertex.size() + " vertices, " + listEdges.
				size() + " edges\n";
			for (Vertex<V, E> vert : this.listVertex) {
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
