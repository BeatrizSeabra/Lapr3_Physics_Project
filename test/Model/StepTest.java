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
        
        private Step step;
        private Measure measure;
        private String toString;
        
	public StepTest() {
            this.step = new Step();
            this.step.setVehicle("Dummy");
            this.step.setNodeStart("n01");
            this.step.setNodeEnd("n03");
            this.step.setRoad("road");
            this.step.setSegment("segment");
            this.measure = new Measure(1.0, "s");
            this.step.setTimeEntry(this.measure);
            this.step.setTimeOut(this.measure);
            this.step.setCarPower(this.measure);
            this.step.setCarSpeed(this.measure);
            this.step.setSpeedRelative(this.measure);
            this.step.setCarForce(this.measure);
            this.step.setRollingForce(this.measure);
            this.step.setAirForce(this.measure);
            this.step.setGravityForce(this.measure);
            toString = "Step | vehicle: " + this.step.getVehicle() + " | node start: " + this.step.getNodeStart() + 
                    " | node end: " + this.step.getNodeEnd() + " | road: " + this.step.getRoad() + " | segment: " + 
                    this.step.getSegment() + " | time entry: " + this.step.getTimeEntry() + " | time out: " + 
                    this.step.getTimeOut() + " | car power: " + this.step.getCarPower() + " | car speed: " + 
                    this.step.getCarSpeed() + " | speed relative: " + this.step.getSpeedRelative() + " | car force: " + 
                    this.step.getCarForce() + " | rolling force: " + this.step.getRollingForce() + " | air force: " + 
                    this.step.getAirForce() + " | gravity force: " + this.step.getGravityForce();
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
                String result = "vehicle";
                this.step.setVehicle(result);
		assertEquals(this.step.getVehicle(), result);
	}

	/**
	 * Test of setVehicle method, of class Step.
	 */
	@Test
	public void testSetVehicle() {
		System.out.println("setVehicle");
		String result = "vehicle";
                this.step.setVehicle(result);
		assertEquals(this.step.getVehicle(), result);
	}

	/**
	 * Test of getNodeStart method, of class Step.
	 */
	@Test
	public void testGetNodeStart() {
		System.out.println("getNodeStart");
		String result = "nodeStart";
                this.step.setNodeStart(result);
		assertEquals(this.step.getNodeStart(), result);
	}

	/**
	 * Test of setNodeStart method, of class Step.
	 */
	@Test
	public void testSetNodeStart() {
		System.out.println("setNodeStart");
		String result = "nodeStart";
                this.step.setNodeStart(result);
		assertEquals(this.step.getNodeStart(), result);
	}

	/**
	 * Test of getNodeEnd method, of class Step.
	 */
	@Test
	public void testGetNodeEnd() {
		System.out.println("getNodeEnd");
		String result = "nodeEnd";
                this.step.setNodeEnd(result);
		assertEquals(this.step.getNodeEnd(), result);
	}

	/**
	 * Test of setNodeEnd method, of class Step.
	 */
	@Test
	public void testSetNodeEnd() {
		System.out.println("setNodeEnd");
		String result = "nodeEnd";
                this.step.setNodeEnd(result);
		assertEquals(this.step.getNodeEnd(), result);
	}

	/**
	 * Test of getRoad method, of class Step.
	 */
	@Test
	public void testGetRoad() {
		System.out.println("getRoad");
		String result = "road1";
                this.step.setRoad(result);
		assertEquals(this.step.getRoad(), result);
	}

	/**
	 * Test of setRoad method, of class Step.
	 */
	@Test
	public void testSetRoad() {
		System.out.println("setRoad");
		String result = "road1";
                this.step.setRoad(result);
		assertEquals(this.step.getRoad(), result);
	}

	/**
	 * Test of getSegment method, of class Step.
	 */
	@Test
	public void testGetSegment() {
		System.out.println("getSegment");
		String result = "segment1";
                this.step.setSegment(result);
		assertEquals(this.step.getSegment(), result);
	}

	/**
	 * Test of setSegment method, of class Step.
	 */
	@Test
	public void testSetSegment() {
		System.out.println("setSegment");
		String result = "segment1";
                this.step.setSegment(result);
		assertEquals(this.step.getSegment(), result);
	}

	/**
	 * Test of getTimeEntry method, of class Step.
	 */
	@Test
	public void testGetTimeEntry() {
		System.out.println("getTimeEntry");
		Measure expResult = new Measure(22.2, "km");
		this.step.setTimeEntry(expResult);
		assertEquals(expResult, this.step.getTimeEntry());
	}

	/**
	 * Test of setTimeEntry method, of class Step.
	 */
	@Test
	public void testSetTimeEntry() {
		System.out.println("setTimeEntry");
		Measure expResult = new Measure(22.2, "km");
		this.step.setTimeEntry(expResult);
		assertEquals(expResult, this.step.getTimeEntry());
	}

	/**
	 * Test of getTimeOut method, of class Step.
	 */
	@Test
	public void testGetTimeOut() {
		System.out.println("getTimeOut");
                Measure expResult = new Measure(22.2, "km");
		this.step.setTimeOut(expResult);
		assertEquals(expResult, this.step.getTimeOut());
	}

	/**
	 * Test of setTimeOut method, of class Step.
	 */
	@Test
	public void testSetTimeOut() {
		System.out.println("setTimeOut");
		Measure expResult = new Measure(22.2, "km");
		this.step.setTimeOut(expResult);
		assertEquals(expResult, this.step.getTimeOut());
	}

	/**
	 * Test of getCarPower method, of class Step.
	 */
	@Test
	public void testGetCarPower() {
		System.out.println("getCarPower");
		Measure expResult = new Measure(22.2, "km");
		this.step.setCarPower(expResult);
		assertEquals(expResult, this.step.getCarPower());
	}

	/**
	 * Test of setCarPower method, of class Step.
	 */
	@Test
	public void testSetCarPower() {
		System.out.println("setCarPower");
		Measure expResult = new Measure(22.2, "km");
		this.step.setCarPower(expResult);
		assertEquals(expResult, this.step.getCarPower());
	}

	/**
	 * Test of getCarSpeed method, of class Step.
	 */
	@Test
	public void testGetCarSpeed() {
		System.out.println("getCarSpeed");
		Measure expResult = new Measure(22.2, "km");
		this.step.setCarSpeed(expResult);
		assertEquals(expResult, this.step.getCarSpeed());
	}

	/**
	 * Test of setCarSpeed method, of class Step.
	 */
	@Test
	public void testSetCarSpeed() {
		System.out.println("setCarSpeed");
		Measure expResult = new Measure(22.2, "km");
		this.step.setCarSpeed(expResult);
		assertEquals(expResult, this.step.getCarSpeed());
	}

	/**
	 * Test of getSpeedRelative method, of class Step.
	 */
	@Test
	public void testGetSpeedRelative() {
		System.out.println("getSpeedRelative");
		Measure expResult = new Measure(22.2, "km");
		this.step.setSpeedRelative(expResult);
		assertEquals(expResult, this.step.getSpeedRelative());
	}

	/**
	 * Test of setSpeedRelative method, of class Step.
	 */
	@Test
	public void testSetSpeedRelative() {
		System.out.println("setSpeedRelative");
		Measure expResult = new Measure(22.2, "km");
		this.step.setSpeedRelative(expResult);
		assertEquals(expResult, this.step.getSpeedRelative());
	}

	/**
	 * Test of getCarForce method, of class Step.
	 */
	@Test
	public void testGetCarForce() {
		System.out.println("getCarForce");
		Measure expResult = new Measure(22.2, "km");
		this.step.setCarForce(expResult);
		assertEquals(expResult, this.step.getCarForce());
	}

	/**
	 * Test of setCarForce method, of class Step.
	 */
	@Test
	public void testSetCarForce() {
		System.out.println("setCarForce");
		Measure expResult = new Measure(22.2, "km");
		this.step.setCarForce(expResult);
		assertEquals(expResult, this.step.getCarForce());
	}

	/**
	 * Test of getRollingForce method, of class Step.
	 */
	@Test
	public void testGetRollingForce() {
		System.out.println("getRollingForce");
		Measure expResult = new Measure(22.2, "km");
		this.step.setRollingForce(expResult);
		assertEquals(expResult, this.step.getRollingForce());
	}

	/**
	 * Test of setRollingForce method, of class Step.
	 */
	@Test
	public void testSetRollingForce() {
		System.out.println("setRollingForce");
		Measure expResult = new Measure(22.2, "km");
		this.step.setRollingForce(expResult);
		assertEquals(expResult, this.step.getRollingForce());
	}

	/**
	 * Test of getAirForce method, of class Step.
	 */
	@Test
	public void testGetAirForce() {
		System.out.println("getAirForce");
		Measure expResult = new Measure(22.2, "km");
		this.step.setAirForce(expResult);
		assertEquals(expResult, this.step.getAirForce());
	}

	/**
	 * Test of setAirForce method, of class Step.
	 */
	@Test
	public void testSetAirForce() {
		System.out.println("setAirForce");
		Measure expResult = new Measure(22.2, "km");
		this.step.setAirForce(expResult);
		assertEquals(expResult, this.step.getAirForce());
	}

	/**
	 * Test of getGravityForce method, of class Step.
	 */
	@Test
	public void testGetGravityForce() {
		System.out.println("getGravityForce");
		Measure expResult = new Measure(22.2, "km");
		this.step.setGravityForce(expResult);
		assertEquals(expResult, this.step.getGravityForce());
	}

	/**
	 * Test of setGravityForce method, of class Step.
	 */
	@Test
	public void testSetGravityForce() {
		System.out.println("setGravityForce");
		Measure expResult = new Measure(22.2, "km");
		this.step.setGravityForce(expResult);
		assertEquals(expResult, this.step.getGravityForce());
	}

	/**
	 * Test of toString method, of class Step.
	 */
	@Test
	public void testToString() {
		System.out.println("toString");
		assertEquals(this.step.toString(), this.toString);
	}

	/**
	 * Test of hashCode method, of class Step.
	 */
	@Test
	public void testHashCode() {
		System.out.println("hashCode");
		int hash = 29 * this.step.getClass().hashCode();
		hash += 11 * this.step.getVehicle().hashCode();
		hash += 11 * this.step.getNodeStart().hashCode();
		hash += 11 * this.step.getNodeEnd().hashCode();
		hash += 11 * this.step.getRoad().hashCode();
		hash += 11 * this.step.getSegment().hashCode();
		hash += 11 * this.step.getTimeEntry().hashCode();
		hash += 11 * this.step.getTimeOut().hashCode();
		hash += 11 * this.step.getCarPower().hashCode();
		hash += 11 * this.step.getCarSpeed().hashCode();
		hash += 11 * this.step.getSpeedRelative().hashCode();
		hash += 11 * this.step.getCarForce().hashCode();
		hash += 11 * this.step.getRollingForce().hashCode();
		hash += 11 * this.step.getAirForce().hashCode();
		hash += 11 * this.step.getGravityForce().hashCode();
		assertEquals(this.step.hashCode(), hash);
	}

	/**
	 * Test of equals method, of class Step.
	 */
	@Test
	public void testEquals() {
		System.out.println("equals");
		Step instance = new Step();
                instance.setVehicle("Dummy");
                instance.setNodeStart("n01");
                instance.setNodeEnd("n03");
                instance.setRoad("road");
                instance.setSegment("segment");
                instance.setTimeEntry(this.measure);
                instance.setTimeOut(this.measure);
                instance.setCarPower(this.measure);
                instance.setCarSpeed(this.measure);
                instance.setSpeedRelative(this.measure);
                instance.setCarForce(this.measure);
                instance.setRollingForce(this.measure);
                instance.setAirForce(this.measure);
                instance.setGravityForce(this.measure);
		assertEquals(this.step.equals(instance), true);
                instance.setVehicle("vehicle");
                assertEquals(this.step.equals(instance), false);
	}

}
