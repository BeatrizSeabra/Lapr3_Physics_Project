/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class RoadNetworkTest {

	private RoadNetwork roadNetwork;
	private Node node1;
	private Node node2;

	public RoadNetworkTest() {
		this.roadNetwork = new RoadNetwork();
		this.node1 = new Node("Node 1");
		this.node2 = new Node("Node 2");
		this.roadNetwork.addNode(node1);
		this.roadNetwork.addNode(node2);
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	/**
	 * Test of addNode method, of class RoadNetwork.
	 */
	@Test
	public void testAddNode() {
		System.out.println("testAddNode");
		Node node = new Node("Node 3");
		this.roadNetwork.addNode(node);
		assertEquals(true, this.roadNetwork.getNodes().contains(node));
	}

	/**
	 * Test of addSection method, of class RoadNetwork.
	 */
	@Test
	public void testAddSection() {
		System.out.println("testAddSection");
		Node startNode = new Node("Node 1");
		Node endNode = new Node("Node 2");
		Section section = new Section();
		this.roadNetwork.addSection(startNode, endNode, section);
		assertEquals(true, this.roadNetwork.getGraph().
					 containsEdge(startNode, endNode));
	}

	/**
	 * Test of getNodes method, of class RoadNetwork.
	 */
	@Test
	public void testGetNodes() {
		System.out.println("testGetNodes");
		List<Node> expResult = new ArrayList();
		expResult.add(node1);
		expResult.add(node2);
		List<Node> result = this.roadNetwork.getNodes();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getGraph method, of class RoadNetwork.
	 */
	@Test
	public void testGetGraph() {
		System.out.println("testGetGraph");
		RoadNetwork roadNetwork = new RoadNetwork();
		roadNetwork.addNode(new Node("Node 1"));
		roadNetwork.addNode(new Node("Node 2"));
		assertEquals(2, this.roadNetwork.getGraph().elements().size());
	}

	/**
	 * Test of hashCode method, of class RoadNetwork.
	 */
	@Test
	public void testHashCode() {
		System.out.println("testHashCode");
		Integer expResult = 29 * this.roadNetwork.getClass().hashCode();
		for (Node node : this.roadNetwork.getNodes()) {
			expResult += 11 * node.hashCode();
		}
		Integer result = this.roadNetwork.hashCode();
		assertEquals(expResult, result);
	}

	/**
	 * Test of equals method, of class RoadNetwork.
	 */
	@Test
	public void testEquals() {
		System.out.println("testEquals");
		RoadNetwork roadNetwork = new RoadNetwork();
		roadNetwork.addNode(new Node("Node 1"));
		roadNetwork.addNode(new Node("Node 2"));
		assertEquals(true, this.roadNetwork.equals(roadNetwork));
	}

	/**
	 * Test of equals method, of class RoadNetwork.
	 */
	@Test
	public void testEqualsFalseHash() {
		System.out.println("testEqualsFalseHash");
		RoadNetwork roadNetwork = new RoadNetwork();
		roadNetwork.addNode(new Node("Node 1"));
		roadNetwork.addNode(new Node("Node 3"));
		assertEquals(false, this.roadNetwork.equals(roadNetwork));
	}

	/**
	 * Test of equals method, of class RoadNetwork.
	 */
	@Test
	public void testEqualsFalseNull() {
		System.out.println("testEqualsFalseNull");
		Boolean result = this.roadNetwork.equals(null);
		Boolean expResult = false;
		assertEquals(expResult, result);
	}

	/**
	 * Test of equals method, of class RoadNetwork.
	 */
	@Test
	public void testEqualsFalseClass() {
		System.out.println("testEqualsFalseClass");
		Boolean result = this.roadNetwork.equals(new String());
		Boolean expResult = false;
		assertEquals(expResult, result);
	}
}
