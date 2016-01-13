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

	/**
	 * Test of getId method, of class Node.
	 */
	@Test
	public void testGetId() {
		System.out.println("getId");
		Node instance = null;
		Integer expResult = null;
		Integer result = instance.getId();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setId method, of class Node.
	 */
	@Test
	public void testSetId() {
		System.out.println("setId");
		Integer id = null;
		Node instance = null;
		instance.setId(id);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getName method, of class Node.
	 */
	@Test
	public void testGetName() {
		System.out.println("getName");
		Node instance = null;
		String expResult = "";
		String result = instance.getName();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setName method, of class Node.
	 */
	@Test
	public void testSetName() {
		System.out.println("setName");
		String name = "";
		Node instance = null;
		instance.setName(name);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of clone method, of class Node.
	 */
	@Test
	public void testClone() {
		System.out.println("clone");
		Node instance = null;
		Node expResult = null;
		Node result = instance.clone();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of toString method, of class Node.
	 */
	@Test
	public void testToString() {
		System.out.println("toString");
		Node instance = null;
		String expResult = "";
		String result = instance.toString();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
}
