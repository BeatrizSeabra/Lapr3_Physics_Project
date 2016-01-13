/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Physics;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author valhalla
 */
public class PhysicsMathTest {

	public PhysicsMathTest() {
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
	 * Test of exponentialDistributionRandom method, of class PhysicsMath.
	 */
	@Test
	public void testExponentialDistributionRandom() {
		System.out.println("exponentialDistributionRandom");
		int averagePerPeriod = 0;
		Double expResult = null;
		Double result = PhysicsMath.exponentialDistributionRandom(averagePerPeriod);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of fuelConsumptionTime method, of class PhysicsMath.
	 */
	@Test
	public void testFuelConsumptionTime() {
		System.out.println("fuelConsumptionTime");
		Measure power = null;
		Measure time = null;
		String fuel = "";
		Measure expResult = null;
		Measure result = PhysicsMath.fuelConsumptionTime(power, time, fuel);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of fuelConsumptionLenght method, of class PhysicsMath.
	 */
	@Test
	public void testFuelConsumptionLenght() {
		System.out.println("fuelConsumptionLenght");
		Measure force = null;
		Measure lenght = null;
		String fuel = "";
		Measure expResult = null;
		Measure result = PhysicsMath.fuelConsumptionLenght(force, lenght, fuel);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of engineCarPower method, of class PhysicsMath.
	 */
	@Test
	public void testEngineCarPower() {
		System.out.println("engineCarPower");
		Measure torque = null;
		Measure rotations = null;
		Measure gearRatio = null;
		Measure expResult = null;
		Measure result = PhysicsMath.engineCarPower(torque, rotations, gearRatio);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of gravityForce method, of class PhysicsMath.
	 */
	@Test
	public void testGravityForce() {
		System.out.println("gravityForce");
		Measure mass = null;
		Measure slope = null;
		Measure expResult = null;
		Measure result = PhysicsMath.gravityForce(mass, slope);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of engineCarForce method, of class PhysicsMath.
	 */
	@Test
	public void testEngineCarForce() {
		System.out.println("engineCarForce");
		Measure torque = null;
		Measure finalDrive = null;
		Measure rotations = null;
		Measure gearRatio = null;
		Measure radiusTire = null;
		Measure expResult = null;
		Measure result = PhysicsMath.engineCarForce(torque, finalDrive, rotations, gearRatio, radiusTire);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of torqueEngineSpeed method, of class PhysicsMath.
	 */
	@Test
	public void testTorqueEngineSpeed() {
		System.out.println("torqueEngineSpeed");
		Measure torque = null;
		Measure rotations = null;
		Measure gearRatio = null;
		Measure expResult = null;
		Measure result = PhysicsMath.torqueEngineSpeed(torque, rotations, gearRatio);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of rollingResistanceForce method, of class PhysicsMath.
	 */
	@Test
	public void testRollingResistanceForce() {
		System.out.println("rollingResistanceForce");
		Measure rollingResistance = null;
		Measure mass = null;
		Measure slope = null;
		Measure expResult = null;
		Measure result = PhysicsMath.rollingResistanceForce(rollingResistance, mass, slope);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of airResistanceForce method, of class PhysicsMath.
	 */
	@Test
	public void testAirResistanceForce() {
		System.out.println("airResistanceForce");
		Measure dragCoefficient = null;
		Measure frontalArea = null;
		Measure relativeSpeed = null;
		Measure expResult = null;
		Measure result = PhysicsMath.airResistanceForce(dragCoefficient, frontalArea, relativeSpeed);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of inertiaResistanceForce method, of class PhysicsMath.
	 */
	@Test
	public void testInertiaResistanceForce() {
		System.out.println("inertiaResistanceForce");
		Measure acceleration = null;
		Measure mass = null;
		Measure coefficientInertial = null;
		Measure expResult = null;
		Measure result = PhysicsMath.inertiaResistanceForce(acceleration, mass, coefficientInertial);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of relativeSpeed method, of class PhysicsMath.
	 */
	@Test
	public void testRelativeSpeed() {
		System.out.println("relativeSpeed");
		Measure carSpeed = null;
		Measure windSpeed = null;
		Measure windDirection = null;
		Measure expResult = null;
		Measure result = PhysicsMath.relativeSpeed(carSpeed, windSpeed, windDirection);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of carSpeed method, of class PhysicsMath.
	 */
	@Test
	public void testCarSpeed() {
		System.out.println("carSpeed");
		Measure radiusTire = null;
		Measure rotations = null;
		Measure finalDrive = null;
		Measure gearRatio = null;
		Measure expResult = null;
		Measure result = PhysicsMath.carSpeed(radiusTire, rotations, finalDrive, gearRatio);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of angle method, of class PhysicsMath.
	 */
	@Test
	public void testAngle() {
		System.out.println("angle");
		Measure slope = null;
		Measure expResult = null;
		Measure result = PhysicsMath.angle(slope);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

}
