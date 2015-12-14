/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
public class NodeTest {

	private Node node;

	public NodeTest() {
		this.node = new Node("Node name");
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
	 * Test of getName and setName method, of class Node.
	 */
	@Test
	public void testSetGetName() {
		System.out.println("testSetGetName");
		String expresult = "Node 1";
		this.node.setName(expresult);
		assertEquals(expresult, this.node.getName());
	}

	/**
	 * Test of hashCode method, of class Node.
	 */
	@Test
	public void testHashCode() {
		System.out.println("testHashCode");
		Integer expResult = 29 * this.node.getClass().hashCode();
		expResult += 11 * this.node.getName().hashCode();
		Integer result = this.node.hashCode();
		assertEquals(expResult, result);
	}

	/**
	 * Test of equals method, of class Node.
	 */
	@Test
	public void testEquals() {
		System.out.println("testEquals");
		Node node = new Node("Node name");
		assertEquals(true, this.node.equals(node));
	}

	/**
	 * Test of equals method, of class Node.
	 */
	@Test
	public void testEqualsFalseHash() {
		System.out.println("testEqualsFalseHash");
		Node node = new Node("Node 1");
		assertEquals(false, this.node.equals(node));
	}

	/**
	 * Test of equals method, of class Node.
	 */
	@Test
	public void testEqualsFalseNull() {
		System.out.println("testEqualsFalseNull");
		assertEquals(false, this.node.equals(null));
	}

	/**
	 * Test of equals method, of class Node.
	 */
	@Test
	public void testEqualsFalseClass() {
		System.out.println("testEqualsFalseClass");
		assertEquals(false, this.node.equals(new String()));
	}
}
