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
public class TrafficTest {

	public TrafficTest() {

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
	 * Test of getId method, of class Traffic.
	 */
	@Test
	public void testGetId() {
		System.out.println("getId");
		Traffic instance = new Traffic();
		instance.setId(10);
		Integer expResult = 10;
		Integer result = instance.getId();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setId method, of class Traffic.
	 */
	@Test
	public void testSetId() {
		System.out.println("setId");
		Integer result = 12;
		Traffic instance = new Traffic();
		instance.setId(result);
		Integer expResult = instance.getId();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getVehicle method, of class Traffic.
	 */
	@Test
	public void testGetVehicle() {
		System.out.println("getVehicle");
		Traffic instance = new Traffic();
		Vehicle vec = new Vehicle();
		vec.setId(1);
		vec.setName("Tommy");
		vec.setDescription("Audi");
		vec.setType("Sub");
		vec.setMotorization("VEC");
		vec.setFuel("Gasoline");
		Measure rmpLow = new Measure(1.2, "MeasureTorque");
		vec.setMass(rmpLow);
		vec.setLoad(rmpLow);
		vec.setDragCoefficient(rmpLow);
		vec.setFrontalArea(rmpLow);
		vec.setRollingRCoefficient(rmpLow);
		vec.setWheelSize(rmpLow);
		vec.setMinRPM(rmpLow);
		vec.setMaxRPM(rmpLow);
		vec.setFinalDriveRatio(rmpLow);
		instance.setVehicle(vec);
		Vehicle expResult = vec;
		Vehicle result = instance.getVehicle();
		assertEquals(expResult, result);

	}

	/**
	 * Test of getNodeStart method, of class Traffic.
	 */
	@Test
	public void testGetNodeStart() {
		System.out.println("getNodeStart");
		Traffic instance = new Traffic();
		Node nStart = new Node("Espinho");
		instance.setNodeStart(nStart);
		Node expResult = nStart;
		Node result = instance.getNodeStart();
		assertEquals(expResult, result);

	}

	/**
	 * Test of getNodeEnd method, of class Traffic.
	 */
	@Test
	public void testGetNodeEnd() {
		System.out.println("getNodeEnd");
		Traffic instance = new Traffic();
		Node expResult = new Node("Anta");
		instance.setNodeEnd(expResult);
		Node result = instance.getNodeEnd();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setNodeStart method, of class Traffic.
	 */
	@Test
	public void testSetNodeStart() {
		System.out.println("setNodeStart");
		Node nodeStart = new Node("Espinho");
		Traffic instance = new Traffic();
		instance.setNodeStart(nodeStart);
		Node expResult = instance.getNodeStart();
		assertEquals(expResult, nodeStart);
	}

	/**
	 * Test of setNodeEnd method, of class Traffic.
	 */
	@Test
	public void testSetNodeEnd() {
		System.out.println("setNodeEnd");
		Node nodeEnd = new Node("Anta");
		Traffic instance = new Traffic();
		instance.setNodeEnd(nodeEnd);
		Node expResult = instance.getNodeEnd();
		assertEquals(expResult, nodeEnd);
	}

	/**
	 * Test of setVehicle method, of class Traffic.
	 */
	@Test
	public void testSetVehicle() {
		System.out.println("setVehicle");
		Traffic instance = new Traffic();
		Vehicle vec = new Vehicle();
		vec.setId(1);
		vec.setName("Tommy");
		vec.setDescription("Audi");
		vec.setType("Sub");
		vec.setMotorization("VEC");
		vec.setFuel("Gasoline");
		Measure rmpLow = new Measure(1.2, "MeasureTorque");
		vec.setMass(rmpLow);
		vec.setLoad(rmpLow);
		vec.setDragCoefficient(rmpLow);
		vec.setFrontalArea(rmpLow);
		vec.setRollingRCoefficient(rmpLow);
		vec.setWheelSize(rmpLow);
		vec.setMinRPM(rmpLow);
		vec.setMaxRPM(rmpLow);
		vec.setFinalDriveRatio(rmpLow);
		instance.setVehicle(vec);
		Vehicle vac = instance.getVehicle();
		assertEquals(vec, vac);

	}

	/**
	 * Test of getArrivalRate method, of class Traffic.
	 */
	@Test
	public void testGetArrivalRate() {
		System.out.println("getArrivalRate");
		Traffic instance = new Traffic();
		Measure rmpLow = new Measure(1.2, "MeasureTorque");
		Measure expResult = rmpLow;
		instance.setArrivalRate(expResult);
		Measure result = instance.getArrivalRate();
		assertEquals(expResult, result);

	}

	/**
	 * Test of setArrivalRate method, of class Traffic.
	 */
	@Test
	public void testSetArrivalRate() {
		System.out.println("setArrivalRate");
		Measure rmpLow = new Measure(1.2, "MeasureTorque");
		Measure expResult = rmpLow;
		Traffic instance = new Traffic();
		instance.setArrivalRate(rmpLow);
		assertEquals(instance.getArrivalRate(), expResult);

	}

	/**
	 * Test of equals method, of class Traffic.
	 */
	@Test
	public void testEquals() {
		System.out.println("equals");
		Traffic instance = new Traffic();
		Traffic obj = new Traffic();
		Vehicle vec = new Vehicle();
		instance.setId(1);
		instance.setId(2);
		vec.setId(1);
		vec.setName("Tommy");
		vec.setDescription("Audi");
		vec.setType("Sub");
		vec.setMotorization("VEC");
		vec.setFuel("Gasoline");
		Measure rmpLow = new Measure(1.2, "MeasureTorque");
		vec.setMass(rmpLow);
		vec.setLoad(rmpLow);
		vec.setDragCoefficient(rmpLow);
		vec.setFrontalArea(rmpLow);
		vec.setRollingRCoefficient(rmpLow);
		vec.setWheelSize(rmpLow);
		vec.setMinRPM(rmpLow);
		vec.setMaxRPM(rmpLow);
		vec.setFinalDriveRatio(rmpLow);
		instance.setVehicle(vec);
		obj.setVehicle(vec);
		Node nodeEnd = new Node("Anta");
		Node nodeStart = new Node("Espinho");
		instance.setNodeEnd(nodeEnd);
		obj.setNodeEnd(nodeEnd);
		obj.setNodeStart(nodeStart);
		instance.setNodeStart(nodeStart);
		instance.setArrivalRate(rmpLow);
		obj.setArrivalRate(rmpLow);
		boolean expResult = false;
		assertEquals(expResult, instance.equals(obj));
	}

	/**
	 * Test of hashCode method, of class Traffic.
	 */
	@Test
	public void testHashCode() {
		System.out.println("hashCode");
		Traffic instance = new Traffic();
		Vehicle vec = new Vehicle();
		instance.setId(1);
		vec.setId(1);
		vec.setName("Tommy");
		vec.setDescription("Audi");
		vec.setType("Sub");
		vec.setMotorization("VEC");
		vec.setFuel("Gasoline");
		Measure rmpLow = new Measure(1.2, "MeasureTorque");
		vec.setMass(rmpLow);
		vec.setLoad(rmpLow);
		vec.setDragCoefficient(rmpLow);
		vec.setFrontalArea(rmpLow);
		vec.setRollingRCoefficient(rmpLow);
		vec.setWheelSize(rmpLow);
		vec.setMinRPM(rmpLow);
		vec.setMaxRPM(rmpLow);
		vec.setFinalDriveRatio(rmpLow);
		instance.setVehicle(vec);
		Node nodeEnd = new Node("Anta");
		Node nodeStart = new Node("Espinho");
		instance.setNodeEnd(nodeEnd);
		instance.setNodeStart(nodeStart);
		instance.setArrivalRate(rmpLow);
		int expResult = 29 * instance.getClass().hashCode();
		expResult += 11 * instance.getId().hashCode();
		expResult += 11 * instance.getArrivalRate().hashCode();
		expResult += 11 * instance.getNodeEnd().hashCode();
		expResult += 11 * instance.getNodeStart().hashCode();
		expResult += 11 * instance.getVehicle().hashCode();
		int result = instance.hashCode();
		assertEquals(expResult, result);

	}

	/**
	 * Test of clone method, of class Traffic.
	 */
	@Test
	public void testClone() {
		System.out.println("clone");
		Traffic instance = new Traffic();
		Vehicle vec = new Vehicle();
		instance.setId(1);
		vec.setId(1);
		vec.setName("Tommy");
		vec.setDescription("Audi");
		vec.setType("Sub");
		vec.setMotorization("VEC");
		vec.setFuel("Gasoline");
		Measure rmpLow = new Measure(1.2, "MeasureTorque");
		vec.setMass(rmpLow);
		vec.setLoad(rmpLow);
		vec.setDragCoefficient(rmpLow);
		vec.setFrontalArea(rmpLow);
		vec.setRollingRCoefficient(rmpLow);
		vec.setWheelSize(rmpLow);
		vec.setMinRPM(rmpLow);
		vec.setMaxRPM(rmpLow);
		vec.setFinalDriveRatio(rmpLow);
		instance.setVehicle(vec);
		Node nodeEnd = new Node("Anta");
		Node nodeStart = new Node("Espinho");
		instance.setNodeEnd(nodeEnd);
		instance.setNodeStart(nodeStart);
		instance.setArrivalRate(rmpLow);
		Traffic expResult = instance;
		Traffic result = instance.clone();
		assertEquals(expResult, result);
	}

	/**
	 * Test of toString method, of class Traffic.
	 */
	@Test
	public void testToString() {
		System.out.println("toString");
		Traffic instance = new Traffic();
		String expResult = "test";
		String result = instance.toString();
		assertEquals(expResult.getClass(), result.getClass());

	}

}
