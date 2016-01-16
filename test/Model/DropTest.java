/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Physics.Measure;
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
public class DropTest {

	private Drop drop;

	public DropTest() {
		this.drop = new Drop();
		this.drop.setVehicle("Dummy01");
		this.drop.setNodeStart("N1");
		this.drop.setNodeEnd("N2");
		this.drop.setTime(new Measure(10.0, "s"));
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
	 * Test of getVehicle method, of class Drop.
	 */
	@Test
	public void testGetSetVehicle() {
		System.out.println("testGetSetVehicle");
		String expResult = "Dummy02";
		this.drop.setVehicle(expResult);
		assertEquals(expResult, this.drop.getVehicle());
	}

	/**
	 * Test of getNodeStart method, of class Drop.
	 */
	@Test
	public void testGetSetNodeStart() {
		System.out.println("testGetSetNodeStart");
		String expResult = "N5";
		this.drop.setNodeStart(expResult);
		assertEquals(expResult, this.drop.getNodeStart());
	}

	/**
	 * Test of getNodeEnd method, of class Drop.
	 */
	@Test
	public void testGetSetNodeEnd() {
		System.out.println("testGetSetNodeEnd");
		String expResult = "N10";
		this.drop.setNodeEnd(expResult);
		assertEquals(expResult, this.drop.getNodeEnd());
	}

	/**
	 * Test of getTime method, of class Drop.
	 */
	@Test
	public void testGetSetTime() {
		System.out.println("testGetSetTime");
		Measure expResult = new Measure(5.0, "s");
		this.drop.setTime(expResult);
		assertEquals(expResult, this.drop.getTime());
	}

	/**
	 * Test of getVehicle method, of class Drop.
	 */
	@Test
	public void testGetVehicle() {
		System.out.println("getVehicle");
		String expResult = "Dummie2";
		this.drop.setVehicle(expResult);
		String result = this.drop.getVehicle();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setVehicle method, of class Drop.
	 */
	@Test
	public void testSetVehicle() {
		System.out.println("setVehicle");
		String vehicle = "Dummy 06";
		this.drop.setVehicle(vehicle);
                String result = this.drop.getVehicle();
		assertEquals(vehicle, result);
	}

	/**
	 * Test of getNodeStart method, of class Drop.
	 */
	@Test
	public void testGetNodeStart() {
		System.out.println("getNodeStart");
		String expResult = "n01";
		this.drop.setNodeStart(expResult);
		String result = this.drop.getNodeStart();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setNodeStart method, of class Drop.
	 */
	@Test
	public void testSetNodeStart() {
		System.out.println("setNodeStart");
		String expResult = "n02";
		this.drop.setNodeStart(expResult);
		String result = this.drop.getNodeStart();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getNodeEnd method, of class Drop.
	 */
	@Test
	public void testGetNodeEnd() {
		System.out.println("getNodeEnd");
		String expResult = "n05";
		this.drop.setNodeEnd(expResult);
		String result = this.drop.getNodeEnd();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setNodeEnd method, of class Drop.
	 */
	@Test
	public void testSetNodeEnd() {
		System.out.println("setNodeEnd");
		String expResult = "n06";
		this.drop.setNodeEnd(expResult);
		String result = this.drop.getNodeEnd();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getTime method, of class Drop.
	 */
	@Test
	public void testGetTime() {
		System.out.println("getTime");
		Measure expResult = new Measure(5.0, "s");
                this.drop.setTime(expResult);
		Measure result = this.drop.getTime();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setTime method, of class Drop.
	 */
	@Test
	public void testSetTime() {
		System.out.println("setTime");
		Measure expResult = new Measure(5.0, "s");
                this.drop.setTime(expResult);
		Measure result = this.drop.getTime();
		assertEquals(expResult, result);
	}

	/**
	 * Test of equals method, of class Drop.
	 */
	@Test
	public void testEquals() {
		System.out.println("equals");
		Object obj = null;
		Drop instance = new Drop();
		boolean expResult = false;
		boolean result = instance.equals(obj);
		assertEquals(expResult, result);
	}

	/**
	 * Test of hashCode method, of class Drop.
	 */
	@Test
	public void testHashCode() {
		System.out.println("hashCode");
		Integer expResult = 29 * this.drop.getClass().hashCode();
		expResult += 11 * this.drop.getNodeEnd().hashCode();
		expResult += 11 * this.drop.getNodeStart().hashCode();
		expResult += 11 * this.drop.getVehicle().hashCode();
		expResult += 11 * this.drop.getTime().hashCode();
		int result = this.drop.hashCode();
		assertEquals(expResult, result, 0.01);
	}

	/**
	 * Test of toString method, of class Drop.
	 */
	@Test
	public void testToString() {
		System.out.println("toString");
		String expResult = "Drop | vehicle: Dummy01 | node start: N1 | node end: N2 | time: 10,00 s";
		String result = this.drop.toString();
		assertEquals(expResult, result);
	}
}
