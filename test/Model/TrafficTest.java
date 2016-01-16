/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Physics.Measure;
import Simulation.VehicleBot;
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
public class TrafficTest {
    
        private Traffic traffic;
        private Vehicle vehicle;
        private Node nStart;
        private Node nEnd;
        private Segment segment;
        private VehicleBot vehicleBot;
        
	public TrafficTest() {
            this.traffic = new Traffic();
            this.vehicle = new Vehicle();
            this.vehicle.setId(1);
            this.vehicle.setName("Tommy");
            this.vehicle.setDescription("Audi");
            this.vehicle.setType("Sub");
            this.vehicle.setMotorization("VEC");
            this.vehicle.setFuel("Gasoline");
            Measure rmpLow = new Measure(1.2, "MeasureTorque");
            this.vehicle.setMass(rmpLow);
            this.vehicle.setLoad(rmpLow);
            this.vehicle.setDragCoefficient(rmpLow);
            this.vehicle.setFrontalArea(rmpLow);
            this.vehicle.setRollingRCoefficient(rmpLow);
            this.vehicle.setWheelSize(rmpLow);
            this.vehicle.setMinRPM(rmpLow);
            this.vehicle.setMaxRPM(rmpLow);
            this.vehicle.setFinalDriveRatio(rmpLow);
            this.traffic.setVehicle(this.vehicle);
            this.nStart = new Node("Espinho");
            this.traffic.setNodeStart(this.nStart);
            this.nEnd = new Node("Anta");
            this.traffic.setNodeEnd(this.nEnd);
            this.segment = new Segment();
            this.segment.setName("Segment name");
            this.segment.setHeight(new Measure(1.0, "km"));
            this.segment.setLength(new Measure(3.0, "km"));
            this.segment.setMaxVelocity(new Measure(4.0, "km"));
            this.segment.setMinVelocity(new Measure(5.0, "km"));
            this.segment.setSlope(new Measure(6.0, "°"));
            this.segment.setNumberVehicles(8);
            this.traffic.setSegment(this.segment);
            this.vehicleBot = new VehicleBot();
            this.traffic.setVehicleBot(this.vehicleBot);
            Measure arrivalRate = new Measure(1.2, "MeasureTorque");
            this.traffic.setArrivalRate(arrivalRate);
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
                Integer expResult = 10;
		this.traffic.setId(expResult);
		assertEquals(this.traffic.getId(), expResult);
	}

	/**
	 * Test of setId method, of class Traffic.
	 */
	@Test
	public void testSetId() {
		System.out.println("setId");
                Integer expResult = 12;
		this.traffic.setId(expResult);
		assertEquals(this.traffic.getId(), expResult);
	}

	/**
	 * Test of getVehicle method, of class Traffic.
	 */
	@Test
	public void testGetVehicle() {
		System.out.println("getVehicle");
		assertEquals(this.traffic.getVehicle(), this.vehicle);
	}

	/**
	 * Test of getNodeStart method, of class Traffic.
	 */
	@Test
	public void testGetNodeStart() {
		System.out.println("getNodeStart");
		assertEquals(this.traffic.getNodeStart(), this.nStart);
	}

	/**
	 * Test of getNodeEnd method, of class Traffic.
	 */
	@Test
	public void testGetNodeEnd() {
		System.out.println("getNodeEnd");
		assertEquals(this.traffic.getNodeEnd(), this.nEnd);
	}

	/**
	 * Test of setNodeStart method, of class Traffic.
	 */
	@Test
	public void testSetNodeStart() {
		System.out.println("setNodeStart");
		Node nodeStart = new Node("Aveiro");
		this.traffic.setNodeStart(nodeStart);
		assertEquals(this.traffic.getNodeStart(), nodeStart);
	}

	/**
	 * Test of setNodeEnd method, of class Traffic.
	 */
	@Test
	public void testSetNodeEnd() {
		System.out.println("setNodeEnd");
		Node nodeEnd = new Node("Curia");
		this.traffic.setNodeEnd(nodeEnd);
		assertEquals(this.traffic.getNodeEnd(), nodeEnd);
	}

	/**
	 * Test of setVehicle method, of class Traffic.
	 */
	@Test
	public void testSetVehicle() {
		System.out.println("setVehicle");
		Vehicle vec = new Vehicle();
		vec.setId(2);
		vec.setName("Tom");
		vec.setDescription("Nissan");
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
		this.traffic.setVehicle(vec);
		assertEquals(this.traffic.getVehicle(), vec);
	}

	/**
	 * Test of getArrivalRate method, of class Traffic.
	 */
	@Test
	public void testGetArrivalRate() {
		System.out.println("getArrivalRate");
                Measure arrivalRate = new Measure(1.2, "MeasureTorque");
                this.traffic.setArrivalRate(arrivalRate);
		assertEquals(this.traffic.getArrivalRate(), arrivalRate);
	}

	/**
	 * Test of setArrivalRate method, of class Traffic.
	 */
	@Test
	public void testSetArrivalRate() {
		System.out.println("setArrivalRate");
		Measure arrivalRate = new Measure(1.5, "MeasureTorque");
		this.traffic.setArrivalRate(arrivalRate);
		assertEquals(this.traffic.getArrivalRate(), arrivalRate);
	}

	/**
	 * Test of equals method, of class Traffic.
	 */
	@Test
	public void testEquals() {
		System.out.println("equals");
                Traffic instance = this.traffic.clone();
		Traffic obj = new Traffic();
		Vehicle vec = new Vehicle();
		obj.setId(2);
		vec.setId(3);
		vec.setName("Tommy");
		vec.setDescription("Audi");
		vec.setType("Sub");
		vec.setMotorization("VEC");
		vec.setFuel("Gasoline");
		Measure rmpLow = new Measure(1.4, "MeasureTorque");
		vec.setMass(rmpLow);
		vec.setLoad(rmpLow);
		vec.setDragCoefficient(rmpLow);
		vec.setFrontalArea(rmpLow);
		vec.setRollingRCoefficient(rmpLow);
		vec.setWheelSize(rmpLow);
		vec.setMinRPM(rmpLow);
		vec.setMaxRPM(rmpLow);
		vec.setFinalDriveRatio(rmpLow);
		obj.setVehicle(vec);
		Node nodeEnd = new Node("Lisboa");
		Node nodeStart = new Node("Setubal");
		obj.setNodeEnd(nodeEnd);
		obj.setNodeStart(nodeStart);
		obj.setArrivalRate(rmpLow);
		boolean expResult = false;
		assertEquals(this.traffic.equals(obj), expResult);
                expResult = true;
                assertEquals(this.traffic.equals(instance), expResult);
	}

	/**
	 * Test of hashCode method, of class Traffic.
	 */
	@Test
	public void testHashCode() {
		System.out.println("hashCode");
		int expResult = 29 * this.traffic.getClass().hashCode();
		expResult += 11 * this.traffic.getId().hashCode();
		expResult += 11 * this.traffic.getArrivalRate().hashCode();
		expResult += 11 * this.traffic.getNodeEnd().hashCode();
		expResult += 11 * this.traffic.getNodeStart().hashCode();
		expResult += 11 * this.traffic.getVehicle().hashCode();
		int result = this.traffic.hashCode();
		assertEquals(expResult, result);

	}

	/**
	 * Test of clone method, of class Traffic.
	 */
	@Test
	public void testClone() {
		System.out.println("clone");
		Traffic result = this.traffic.clone();
		assertEquals(this.traffic, result);
	}

	/**
	 * Test of toString method, of class Traffic.
	 */
	@Test
	public void testToString() {
		String result = this.traffic.toString();
		assertEquals(result.length()>0, true);
	}

	/**
	 * Test of getSegment method, of class Traffic.
	 */
	@Test
	public void testGetSegment() {
		System.out.println("getSegment");
		assertEquals(this.traffic.getSegment(), this.segment);
	}

	/**
	 * Test of setSegment method, of class Traffic.
	 */
	@Test
	public void testSetSegment() {
		System.out.println("setSegment");
		Segment nSegment = new Segment();
                nSegment.setName("Segment 2");
		nSegment.setHeight(new Measure(2.0, "km"));
		nSegment.setLength(new Measure(5.0, "km"));
		nSegment.setMaxVelocity(new Measure(6.0, "km"));
		nSegment.setMinVelocity(new Measure(4.0, "km"));
		nSegment.setSlope(new Measure(7.0, "°"));
		nSegment.setNumberVehicles(5);
		this.traffic.setSegment(nSegment);
		assertEquals(this.traffic.getSegment(), nSegment);
	}

	/**
	 * Test of getVehicleBot method, of class Traffic.
	 */
	@Test
	public void testGetVehicleBot() {
            System.out.println("getVehicleBot");
            assertEquals(this.traffic.getVehicleBot(), this.vehicleBot);
		
	}

	/**
	 * Test of setVehicleBot method, of class Traffic.
	 */
	@Test
	public void testSetVehicleBot() {
		System.out.println("setVehicleBot");
		VehicleBot vehicleB = new VehicleBot();
		this.traffic.setVehicleBot(vehicleB);
                assertEquals(this.traffic.getVehicleBot(), vehicleB);
	}

}
