/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Physics.Measure;
import java.util.Map;
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
public class VehicleTest {

	private Vehicle vehicle;

	public VehicleTest() {
		this.vehicle = new Vehicle();
		this.vehicle.setId(1);
		this.vehicle.setName("Nissan Skyline 2001");
		this.vehicle.setDescription("2001 Nissan Skyline GT-R R34 V-spec II N1");
		this.vehicle.setType("car");
		this.vehicle.setMotorization("combustion");
		this.vehicle.setFuel("gasoline");
		this.vehicle.setMass(new Measure(1550.0, "kg"));
		this.vehicle.setLoad(new Measure(0.0, "kg"));
		this.vehicle.setDragCoefficient(new Measure(0.34, "ratio"));
		this.vehicle.setRollingRCoefficient(new Measure(0.01, "ratio"));
		this.vehicle.setWheelSize(new Measure(0.3266, "m"));
		this.vehicle.setTorque(new Measure(392.0, "Nm"));
		this.vehicle.setRPM(new Measure(8500.0, "rpm"));
		this.vehicle.setComsumption(new Measure(8.1, "km/l"));
		this.vehicle.setMinRPM(new Measure(8500.0, "rpm"));
		this.vehicle.setMaxRPM(new Measure(1000.0, "rpm"));
		this.vehicle.setFinalDriveRatio(new Measure(3.545, "ratio"));
		this.vehicle.setGear(1, new Measure(3.827, "ratio"));
		this.vehicle.setGear(2, new Measure(2.36, "ratio"));
		this.vehicle.setGear(3, new Measure(1.685, "ratio"));
		this.vehicle.setGear(4, new Measure(1.312, "ratio"));
		this.vehicle.setGear(5, new Measure(1.0, "ratio"));
		this.vehicle.setGear(6, new Measure(0.793, "ratio"));
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
	 * Test of hashCode method, of class Project.
	 */
	@Test
	public void testHashCode() {
		System.out.println("testHashCode");
		Integer expResult = 29 * this.vehicle.getClass().hashCode();
		expResult += 11 * this.vehicle.getId().hashCode();
		expResult += 11 * this.vehicle.getName().hashCode();
		expResult += 11 * this.vehicle.getDescription().hashCode();
		expResult += 11 * this.vehicle.getType().hashCode();
		expResult += 11 * this.vehicle.getMotorization().hashCode();
		expResult += 11 * this.vehicle.getFuel().hashCode();
		expResult += 11 * this.vehicle.getMass().hashCode();
		expResult += 11 * this.vehicle.getLoad().hashCode();
		expResult += 11 * this.vehicle.getDragCoefficient().hashCode();
		expResult += 11 * this.vehicle.getRollingRCoefficient().hashCode();
		expResult += 11 * this.vehicle.getWheelSize().hashCode();
		expResult += 11 * this.vehicle.getTorque().hashCode();
		expResult += 11 * this.vehicle.getRPM().hashCode();
		expResult += 11 * this.vehicle.getComsumption().hashCode();
		expResult += 11 * this.vehicle.getMinRPM().hashCode();
		expResult += 11 * this.vehicle.getMaxRPM().hashCode();
		expResult += 11 * this.vehicle.getFinalDriveRatio().hashCode();
		for (Map.Entry<String, Measure> entity : this.vehicle.
			getVelocityLimits().
			entrySet()) {
			expResult += 7 * entity.getKey().hashCode();
			expResult += 7 * entity.getValue().hashCode();
		}
		for (Map.Entry<Integer, Measure> entity : this.vehicle.getGears().
			entrySet()) {
			expResult += 7 * entity.getKey().hashCode();
			expResult += 7 * entity.getValue().hashCode();
		}
		Integer result = this.vehicle.hashCode();
		assertEquals(expResult, result);
	}

	/**
	 * Test of equals method, of class Project.
	 */
	@Test
	public void testEquals() {
		System.out.println("testEquals");
		Vehicle vehicle = this.vehicle.clone();
		assertEquals(this.vehicle.equals(vehicle), true);
	}

	/**
	 * Test of equals method, of class Project.
	 */
	@Test
	public void testEqualsFalseId() {
		System.out.println("testEqualsFalseId");
		Vehicle vehicle = this.vehicle.clone();
		vehicle.setId(2);
		assertEquals(this.vehicle.equals(vehicle), false);
	}

	/**
	 * Test of equals method, of class Project.
	 */
	@Test
	public void testEqualsFalseHash() {
		System.out.println("testEqualsFalseHash");
		Vehicle vehicle = this.vehicle.clone();
		vehicle.setName("Name");
		assertEquals(this.vehicle.equals(vehicle), false);
	}

	/**
	 * Test of equals method, of class Project.
	 */
	@Test
	public void testEqualsFalseNull() {
		System.out.println("testEqualsFalseNull");
		assertEquals(this.vehicle.equals(null), false);
	}

	/**
	 * Test of equals method, of class Project.
	 */
	@Test
	public void testEqualsFalseClass() {
		System.out.println("testEqualsFalseClass");
		assertEquals(this.vehicle.equals(new String()), false);
	}

	/**
	 * Test of getVelocity method, of class Vehicle.
	 */
	@Test
	public void testGetVelocity() {
		System.out.println("testGetVelocity");
		assertEquals(this.vehicle.getVelocity(1).getValue(), 77.14, 0.01);
		assertEquals(this.vehicle.getVelocity(2).getValue(), 125.09, 0.01);
		assertEquals(this.vehicle.getVelocity(3).getValue(), 175.21, 0.01);
		assertEquals(this.vehicle.getVelocity(4).getValue(), 225.02, 0.01);
		assertEquals(this.vehicle.getVelocity(5).getValue(), 295.22, 0.01);
		assertEquals(this.vehicle.getVelocity(6).getValue(), 372.29, 0.01);
	}

	/**
	 * Test of getMaxVelocity method, of class Vehicle.
	 */
	@Test
	public void testGetMaxVelocity() {
		System.out.println("testGetMaxVelocity");
		assertEquals(this.vehicle.getMaxVelocity().getValue(), 372.29, 0.01);
	}

}
