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
public class RoadTest {

	private Road road;

	public RoadTest() {
		this.road = new Road();
		this.road.setName("Road name");
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
	 * Test of getName and setName method, of class Road.
	 */
	@Test
	public void testSetGetName() {
		System.out.println("testGetName");
		String expResult = "Rua do Porto";
		this.road.setName(expResult);
		String result = this.road.getName();
		assertEquals(expResult, result);
	}

	/**
	 * Test of hashCode method, of class Road.
	 */
	@Test
	public void testHashCode() {
		System.out.println("testHashCode");
		Integer expResult = 29 * this.road.getClass().hashCode();
		expResult += 11 * this.road.getName().hashCode();
		Integer result = this.road.hashCode();
		assertEquals(expResult, result);
	}

	/**
	 * Test of equals method, of class Road.
	 */
	@Test
	public void testEquals() {
		System.out.println("testEquals");
		Road road = new Road();
		road.setName("Road name");
		assertEquals(true, this.road.equals(road));
	}

	/**
	 * Test of equals method, of class Road.
	 */
	@Test
	public void testEqualsFalseHash() {
		System.out.println("testEqualsFalseHash");
		Road road = new Road();
		road.setName("Name");
		assertEquals(false, this.road.equals(road));
	}

	/**
	 * Test of equals method, of class Road.
	 */
	@Test
	public void testEqualsFalseNull() {
		System.out.println("testEqualsFalseNull");
		assertEquals(false, this.road.equals(null));
	}

	/**
	 * Test of equals method, of class Road.
	 */
	@Test
	public void testEqualsFalseClass() {
		System.out.println("testEqualsFalseClass");
		assertEquals(false, this.road.equals(new String()));
	}
}
