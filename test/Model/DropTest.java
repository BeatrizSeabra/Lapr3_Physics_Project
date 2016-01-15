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
}
