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
		String expResult = "name";
		instance.setVehicle(expResult);
		String result = instance.getVehicle();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setVehicle method, of class Step.
	 */
	@Test
	public void testSetVehicle() {
		System.out.println("setVehicle");
		String vehicle = "vec";
		Step instance = new Step();
		instance.setVehicle(vehicle);
		assertEquals(vehicle, instance.getVehicle());
	}

	/**
	 * Test of getNodeStart method, of class Step.
	 */
	@Test
	public void testGetNodeStart() {
		System.out.println("getNodeStart");
		Step instance = new Step();
		String expResult = "n0";
		instance.setNodeStart(expResult);
		String result = instance.getNodeStart();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setNodeStart method, of class Step.
	 */
	@Test
	public void testSetNodeStart() {
		System.out.println("setNodeStart");
		String nodeStart = "n1";
		Step instance = new Step();
		instance.setNodeStart(nodeStart);
		assertEquals(nodeStart, instance.getNodeStart());
	}

	/**
	 * Test of getNodeEnd method, of class Step.
	 */
	@Test
	public void testGetNodeEnd() {
		System.out.println("getNodeEnd");
		Step instance = new Step();
		String expResult = "n2";
		instance.setNodeEnd(expResult);
		String result = instance.getNodeEnd();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setNodeEnd method, of class Step.
	 */
	@Test
	public void testSetNodeEnd() {
		System.out.println("setNodeEnd");
		String nodeEnd = "n2";
		Step instance = new Step();
		instance.setNodeEnd(nodeEnd);
		assertEquals(nodeEnd, instance.getNodeEnd());
	}

	/**
	 * Test of getRoad method, of class Step.
	 */
	@Test
	public void testGetRoad() {
		System.out.println("getRoad");
		Step instance = new Step();
		String expResult = "n1";
		instance.setRoad(expResult);
		String result = instance.getRoad();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setRoad method, of class Step.
	 */
	@Test
	public void testSetRoad() {
		System.out.println("setRoad");
		String road = "road";
		Step instance = new Step();
		instance.setRoad(road);
		assertEquals(road, instance.getRoad());
	}

	/**
	 * Test of getSegment method, of class Step.
	 */
	@Test
	public void testGetSegment() {
		System.out.println("getSegment");
		Step instance = new Step();
		String expResult = "segment";
		instance.setSegment(expResult);
		String result = instance.getSegment();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setSegment method, of class Step.
	 */
	@Test
	public void testSetSegment() {
		System.out.println("setSegment");
		String segment = "segment";
		Step instance = new Step();
		instance.setSegment(segment);
		assertEquals(segment, instance.getSegment());
	}

	/**
	 * Test of getTimeEntry method, of class Step.
	 */
	@Test
	public void testGetTimeEntry() {
		System.out.println("getTimeEntry");
		Step instance = new Step();
		Measure expResult = new Measure(22.2, "km");
		instance.setTimeEntry(expResult);
		Measure result = instance.getTimeEntry();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setTimeEntry method, of class Step.
	 */
	@Test
	public void testSetTimeEntry() {
		System.out.println("setTimeEntry");
		Measure timeEntry = new Measure(22.2, "km");
		Step instance = new Step();
		instance.setTimeEntry(timeEntry);
		assertEquals(timeEntry, instance.getTimeEntry());
	}

	/**
	 * Test of getTimeOut method, of class Step.
	 */
	@Test
	public void testGetTimeOut() {
		System.out.println("getTimeOut");
		Step instance = new Step();
		Measure expResult = new Measure(22.2, "km");
		instance.setTimeOut(expResult);
		Measure result = instance.getTimeOut();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setTimeOut method, of class Step.
	 */
	@Test
	public void testSetTimeOut() {
		System.out.println("setTimeOut");
		Measure timeOut = new Measure(22.0, "km");
		Step instance = new Step();
		instance.setTimeOut(timeOut);
		assertEquals(timeOut, instance.getTimeOut());
	}

	/**
	 * Test of getCarPower method, of class Step.
	 */
	@Test
	public void testGetCarPower() {
		System.out.println("getCarPower");
		Step instance = new Step();
		Measure expResult = new Measure(22.2, "km/h");
		instance.setCarPower(expResult);
		Measure result = instance.getCarPower();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setCarPower method, of class Step.
	 */
	@Test
	public void testSetCarPower() {
		System.out.println("setCarPower");
		Measure carPower = new Measure(22.0, "km/s");
		Step instance = new Step();
		instance.setCarPower(carPower);
		assertEquals(carPower, instance.getCarPower());
	}

	/**
	 * Test of getCarSpeed method, of class Step.
	 */
	@Test
	public void testGetCarSpeed() {
		System.out.println("getCarSpeed");
		Step instance = new Step();
		Measure expResult = new Measure(22.0, "Km/s");
		instance.setCarSpeed(expResult);
		Measure result = instance.getCarSpeed();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setCarSpeed method, of class Step.
	 */
	@Test
	public void testSetCarSpeed() {
		System.out.println("setCarSpeed");
		Measure carSpeed = new Measure(89.0, "km");
		Step instance = new Step();
		instance.setCarSpeed(carSpeed);
		assertEquals(carSpeed, instance.getCarSpeed());
	}

	/**
	 * Test of getSpeedRelative method, of class Step.
	 */
	@Test
	public void testGetSpeedRelative() {
		System.out.println("getSpeedRelative");
		Step instance = new Step();
		Measure expResult = new Measure(80.0, "km");
		instance.setSpeedRelative(expResult);
		Measure result = instance.getSpeedRelative();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setSpeedRelative method, of class Step.
	 */
	@Test
	public void testSetSpeedRelative() {
		System.out.println("setSpeedRelative");
		Measure speedRelative = new Measure(9.0, "km");
		Step instance = new Step();
		instance.setSpeedRelative(speedRelative);
		assertEquals(speedRelative, instance.getSpeedRelative());
	}

	/**
	 * Test of getCarForce method, of class Step.
	 */
	@Test
	public void testGetCarForce() {
		System.out.println("getCarForce");
		Step instance = new Step();
		Measure expResult = new Measure(0.9, "km");
		instance.setCarForce(expResult);
		Measure result = instance.getCarForce();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setCarForce method, of class Step.
	 */
	@Test
	public void testSetCarForce() {
		System.out.println("setCarForce");
		Measure carForce = new Measure(0.8, "km");
		Step instance = new Step();
		instance.setCarForce(carForce);
		assertEquals(carForce, instance.getCarForce());
	}

	/**
	 * Test of getRollingForce method, of class Step.
	 */
	@Test
	public void testGetRollingForce() {
		System.out.println("getRollingForce");
		Step instance = new Step();
		Measure expResult = new Measure(0.09, "km");
		instance.setRollingForce(expResult);
		Measure result = instance.getRollingForce();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setRollingForce method, of class Step.
	 */
	@Test
	public void testSetRollingForce() {
		System.out.println("setRollingForce");
		Measure rollingForce = new Measure(0.08, "km");
		Step instance = new Step();
		instance.setRollingForce(rollingForce);
		assertEquals(rollingForce, instance.getRollingForce());
	}

	/**
	 * Test of getAirForce method, of class Step.
	 */
	@Test
	public void testGetAirForce() {
		System.out.println("getAirForce");
		Step instance = new Step();
		Measure expResult = new Measure(22.0, "km");
		instance.setAirForce(expResult);
		Measure result = instance.getAirForce();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setAirForce method, of class Step.
	 */
	@Test
	public void testSetAirForce() {
		System.out.println("setAirForce");
		Measure airForce = new Measure(2.2, "km");
		Step instance = new Step();
		instance.setAirForce(airForce);
		assertEquals(airForce, instance.getAirForce());
	}

	/**
	 * Test of getGravityForce method, of class Step.
	 */
	@Test
	public void testGetGravityForce() {
		System.out.println("getGravityForce");
		Step instance = new Step();
		Measure expResult = new Measure(9.8, "km");
		instance.setGravityForce(expResult);
		Measure result = instance.getGravityForce();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setGravityForce method, of class Step.
	 */
	@Test
	public void testSetGravityForce() {
		System.out.println("setGravityForce");
		Measure gravityForce = new Measure(9.8, "km");
		Step instance = new Step();
		instance.setGravityForce(gravityForce);
		assertEquals(gravityForce, instance.getGravityForce());
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
		//fail("The test case is a prototype.");
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
		//fail("The test case is a prototype.");
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
		//	fail("The test case is a prototype.");
	}

}
