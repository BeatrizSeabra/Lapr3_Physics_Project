/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Physics.Measure;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Eduardo
 */
public class StepTest {

	public StepTest() {
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
	 * Test of getVehicle method, of class Step.
	 */
	@Test
	public void testGetVehicle() {
		System.out.println("getVehicle");
		Step instance = new Step();
		String expResult = "";
		String result = instance.getVehicle();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setVehicle method, of class Step.
	 */
	@Test
	public void testSetVehicle() {
		System.out.println("setVehicle");
		String vehicle = "";
		Step instance = new Step();
		instance.setVehicle(vehicle);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getNodeStart method, of class Step.
	 */
	@Test
	public void testGetNodeStart() {
		System.out.println("getNodeStart");
		Step instance = new Step();
		String expResult = "";
		String result = instance.getNodeStart();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setNodeStart method, of class Step.
	 */
	@Test
	public void testSetNodeStart() {
		System.out.println("setNodeStart");
		String nodeStart = "";
		Step instance = new Step();
		instance.setNodeStart(nodeStart);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getNodeEnd method, of class Step.
	 */
	@Test
	public void testGetNodeEnd() {
		System.out.println("getNodeEnd");
		Step instance = new Step();
		String expResult = "";
		String result = instance.getNodeEnd();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setNodeEnd method, of class Step.
	 */
	@Test
	public void testSetNodeEnd() {
		System.out.println("setNodeEnd");
		String nodeEnd = "";
		Step instance = new Step();
		instance.setNodeEnd(nodeEnd);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getRoad method, of class Step.
	 */
	@Test
	public void testGetRoad() {
		System.out.println("getRoad");
		Step instance = new Step();
		String expResult = "";
		String result = instance.getRoad();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setRoad method, of class Step.
	 */
	@Test
	public void testSetRoad() {
		System.out.println("setRoad");
		String road = "";
		Step instance = new Step();
		instance.setRoad(road);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getSegment method, of class Step.
	 */
	@Test
	public void testGetSegment() {
		System.out.println("getSegment");
		Step instance = new Step();
		String expResult = "";
		String result = instance.getSegment();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setSegment method, of class Step.
	 */
	@Test
	public void testSetSegment() {
		System.out.println("setSegment");
		String segment = "";
		Step instance = new Step();
		instance.setSegment(segment);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getTimeEntry method, of class Step.
	 */
	@Test
	public void testGetTimeEntry() {
		System.out.println("getTimeEntry");
		Step instance = new Step();
		Measure expResult = null;
		Measure result = instance.getTimeEntry();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setTimeEntry method, of class Step.
	 */
	@Test
	public void testSetTimeEntry() {
		System.out.println("setTimeEntry");
		Measure timeEntry = null;
		Step instance = new Step();
		instance.setTimeEntry(timeEntry);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getTimeOut method, of class Step.
	 */
	@Test
	public void testGetTimeOut() {
		System.out.println("getTimeOut");
		Step instance = new Step();
		Measure expResult = null;
		Measure result = instance.getTimeOut();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setTimeOut method, of class Step.
	 */
	@Test
	public void testSetTimeOut() {
		System.out.println("setTimeOut");
		Measure timeOut = null;
		Step instance = new Step();
		instance.setTimeOut(timeOut);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getCarPower method, of class Step.
	 */
	@Test
	public void testGetCarPower() {
		System.out.println("getCarPower");
		Step instance = new Step();
		Measure expResult = null;
		Measure result = instance.getCarPower();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setCarPower method, of class Step.
	 */
	@Test
	public void testSetCarPower() {
		System.out.println("setCarPower");
		Measure carPower = null;
		Step instance = new Step();
		instance.setCarPower(carPower);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getCarSpeed method, of class Step.
	 */
	@Test
	public void testGetCarSpeed() {
		System.out.println("getCarSpeed");
		Step instance = new Step();
		Measure expResult = null;
		Measure result = instance.getCarSpeed();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setCarSpeed method, of class Step.
	 */
	@Test
	public void testSetCarSpeed() {
		System.out.println("setCarSpeed");
		Measure carSpeed = null;
		Step instance = new Step();
		instance.setCarSpeed(carSpeed);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getSpeedRelative method, of class Step.
	 */
	@Test
	public void testGetSpeedRelative() {
		System.out.println("getSpeedRelative");
		Step instance = new Step();
		Measure expResult = null;
		Measure result = instance.getSpeedRelative();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setSpeedRelative method, of class Step.
	 */
	@Test
	public void testSetSpeedRelative() {
		System.out.println("setSpeedRelative");
		Measure speedRelative = null;
		Step instance = new Step();
		instance.setSpeedRelative(speedRelative);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getCarForce method, of class Step.
	 */
	@Test
	public void testGetCarForce() {
		System.out.println("getCarForce");
		Step instance = new Step();
		Measure expResult = null;
		Measure result = instance.getCarForce();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setCarForce method, of class Step.
	 */
	@Test
	public void testSetCarForce() {
		System.out.println("setCarForce");
		Measure carForce = null;
		Step instance = new Step();
		instance.setCarForce(carForce);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getRollingForce method, of class Step.
	 */
	@Test
	public void testGetRollingForce() {
		System.out.println("getRollingForce");
		Step instance = new Step();
		Measure expResult = null;
		Measure result = instance.getRollingForce();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setRollingForce method, of class Step.
	 */
	@Test
	public void testSetRollingForce() {
		System.out.println("setRollingForce");
		Measure rollingForce = null;
		Step instance = new Step();
		instance.setRollingForce(rollingForce);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getAirForce method, of class Step.
	 */
	@Test
	public void testGetAirForce() {
		System.out.println("getAirForce");
		Step instance = new Step();
		Measure expResult = null;
		Measure result = instance.getAirForce();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setAirForce method, of class Step.
	 */
	@Test
	public void testSetAirForce() {
		System.out.println("setAirForce");
		Measure airForce = null;
		Step instance = new Step();
		instance.setAirForce(airForce);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getGravityForce method, of class Step.
	 */
	@Test
	public void testGetGravityForce() {
		System.out.println("getGravityForce");
		Step instance = new Step();
		Measure expResult = null;
		Measure result = instance.getGravityForce();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setGravityForce method, of class Step.
	 */
	@Test
	public void testSetGravityForce() {
		System.out.println("setGravityForce");
		Measure gravityForce = null;
		Step instance = new Step();
		instance.setGravityForce(gravityForce);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of toString method, of class Step.
	 */
	@Test
	public void testToString() {
		System.out.println("toString");
		Step instance = new Step();
		String expResult = "";
		String result = instance.toString();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of hashCode method, of class Step.
	 */
	@Test
	public void testHashCode() {
		System.out.println("hashCode");
		Step instance = new Step();
		int expResult = 0;
		int result = instance.hashCode();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of equals method, of class Step.
	 */
	@Test
	public void testEquals() {
		System.out.println("equals");
		Object obj = null;
		Step instance = new Step();
		boolean expResult = false;
		boolean result = instance.equals(obj);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

}
