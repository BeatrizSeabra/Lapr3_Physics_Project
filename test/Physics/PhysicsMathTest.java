/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Physics;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
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
	 * Test of engineCarPower method, of class PhysicsMath.
	 */
	@Test
	public void testEngineCarPower() {
		System.out.println("engineCarPower");
		Measure torque = new Measure(12.0, "Nm");
		Measure rotations = new Measure(10.0, "rps");
		Measure gearRatio = new Measure(12.0, "ratio");
		Measure expResult = new Measure(904.78, "J/s");
		Measure result = PhysicsMath.
			engineCarPower(torque, rotations, gearRatio);
		System.out.println(result.toString());
		assertEquals(expResult.getValue(), result.getValue(), 0.01);
	}

	/**
	 * Test of gravityForce method, of class PhysicsMath.
	 */
	@Test
	public void testGravityForce() {
		System.out.println("gravityForce");
		Measure mass = new Measure(12.0, "kg");
		Measure slope = new Measure(8.0, "%");
		Measure expResult = new Measure(-116.55, "°");
		Measure result = PhysicsMath.gravityForce(mass, slope);
		System.out.println(result.toString());
		assertEquals(expResult.getValue(), result.getValue(), 0.01);
	}

	/**
	 * Test of engineCarForce method, of class PhysicsMath.
	 */
	@Test
	public void testEngineCarForce() {
		System.out.println("engineCarForce");
		Measure torque = new Measure(12.0, "Nm");
		Measure finalDrive = new Measure(11.0, "ratio");
		Measure rotations = new Measure(2.500, "rps");
		Measure gearRatio = new Measure(12.0, "ratio");
		Measure radiusTire = new Measure(0.7, "m");
		Measure expResult = new Measure(10861.71, "Nm");
		Measure result = PhysicsMath.
			engineCarForce(torque, finalDrive, rotations, gearRatio, radiusTire);
		assertEquals(expResult.getValue(), result.getValue(), 0.01);
	}

	/**
	 * Test of torqueEngineSpeed method, of class PhysicsMath.
	 */
	@Test
	public void testTorqueEngineSpeed() {
		System.out.println("torqueEngineSpeed");
		Measure torque = new Measure(12.0, "Nm");
		Measure rotations = new Measure(2.500, "rps");
		Measure gearRatio = new Measure(12.0, "ratio");
		Measure expResult = new Measure(57.60, "Nm");
		Measure result = PhysicsMath.
			torqueEngineSpeed(torque, rotations, gearRatio);
		System.out.println(result.toString());
		assertEquals(expResult.getValue(), result.getValue(), 0.01);
	}

	/**
	 * Test of rollingResistanceForce method, of class PhysicsMath.
	 */
	@Test
	public void testRollingResistanceForce() {
		System.out.println("rollingResistanceForce");
		Measure rollingResistance = new Measure(18.0, "ratio");
		Measure mass = new Measure(12.0, "kg");
		Measure slope = new Measure(8.0, "%");
		Measure expResult = new Measure(-292.37, "N");
		Measure result = PhysicsMath.
			rollingResistanceForce(rollingResistance, mass, slope);
		assertEquals(expResult.getValue(), result.getValue(), 0.01);
	}

	/**
	 * Test of airResistanceForce method, of class PhysicsMath.
	 */
	@Test
	public void testAirResistanceForce() {
		System.out.println("airResistanceForce");
		Measure dragCoefficient = new Measure(22.0, "ratio");
		Measure frontalArea = new Measure(23.2, "m2");
		Measure relativeSpeed = new Measure(89.0, "m/s");
		Measure expResult = new Measure(2476263.02, "N");
		Measure result = PhysicsMath.
			airResistanceForce(dragCoefficient, frontalArea, relativeSpeed);
		assertEquals(expResult, result);
	}

	/**
	 * Test of inertiaResistanceForce method, of class PhysicsMath.
	 */
	@Test
	public void testInertiaResistanceForce() {
		System.out.println("inertiaResistanceForce");
		Measure acceleration = new Measure(12.2, "m/s2");
		Measure mass = new Measure(12.0, "kg");
		Measure coefficientInertial = new Measure(15.0, "ratio");
		Measure expResult = new Measure(2196.00, "N");
		Measure result = PhysicsMath.
			inertiaResistanceForce(acceleration, mass, coefficientInertial);
		assertEquals(expResult.getValue(), result.getValue(), 0.01);
	}

	/**
	 * Test of relativeSpeed method, of class PhysicsMath.
	 */
	@Test
	public void testRelativeSpeed() {
		System.out.println("relativeSpeed");
		Measure carSpeed = new Measure(120.00, "m/s");
		Measure windSpeed = new Measure(113.00, "m/s");
		Measure windDirection = new Measure(33.2, "°");
		Measure expResult = new Measure(96.08, "m/s");
		Measure result = PhysicsMath.
			relativeSpeed(carSpeed, windSpeed, windDirection);
		assertEquals(expResult.getValue(), result.getValue(), 0.01);
	}

	/**
	 * Test of carSpeed method, of class PhysicsMath.
	 */
	@Test
	public void testCarSpeed() {
		System.out.println("carSpeed");
		Measure radiusTire = new Measure(7.6, "m");
		Measure rotations = new Measure(10.0, "rps");
		Measure finalDrive = new Measure(11.0, "ratio");
		Measure gearRatio = new Measure(12.0, "ratio");
		Measure expResult = new Measure(3.62, "m/s");
		Measure result = PhysicsMath.
			carSpeed(radiusTire, rotations, finalDrive, gearRatio);
		assertEquals(expResult.getValue(), result.getValue(), 0.01);
	}

	/**
	 * Test of angle method, of class PhysicsMath.
	 */
	@Test
	public void testAngle() {
		System.out.println("angle");
		Measure slope = new Measure(8.0, "%");
		Measure expResult = new Measure(4.57, "°");
		Measure result = PhysicsMath.angle(slope);
		assertEquals(expResult.getValue(), result.getValue(), 0.01);
	}

	/**
	 * Test of realPowerGasoline method, of class PhysicsMath.
	 */
	@Test
	public void testRealPowerGasoline() {
		System.out.println("realPowerGasoline");
		Measure power = new Measure(12.1, "J/s");
		Measure fuelConsumption = new Measure(11.0, "g/J");
		Measure expResult = new Measure(5909640.00, "J/s");
		Measure result = PhysicsMath.realPowerGasoline(power, fuelConsumption);
		assertEquals(expResult.getValue(), result.getValue(), 0.01);
	}

	/**
	 * Test of realPowerDiesel method, of class PhysicsMath.
	 */
	@Test
	public void testRealPowerDiesel() {
		System.out.println("realPowerDiesel");
		Measure power = new Measure(12.1, "J/s");
		Measure fuelConsumption = new Measure(11.0, "g/J");
		Measure expResult = new Measure(6388800.00, "J/s");
		Measure result = PhysicsMath.realPowerDiesel(power, fuelConsumption);
		assertEquals(expResult.getValue(), result.getValue(), 0.01);
	}
}
