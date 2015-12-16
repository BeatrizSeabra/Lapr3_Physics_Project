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
		this.vehicle.setName("Vehicle Name");
		this.vehicle.setDescription("Vehicle Description");
		this.vehicle.setType("Vehicle Type");
		this.vehicle.setMotorization("Vehicle Motorization");
		this.vehicle.setFuel("Vehicle Fuel");
		this.vehicle.setMass(new Measure(100.0, "kg"));
		this.vehicle.setLoad(new Measure(100.0, "kg"));
		this.vehicle.setDragCoefficient(100.0);
		this.vehicle.setRollingCcoefficient(100.0);
		this.vehicle.setWheelSize(100.0);
		this.vehicle.setTorque(100.0);
		this.vehicle.setRPM(100.0);
		this.vehicle.setComsumption(100.0);
		this.vehicle.setMinRPM(100.0);
		this.vehicle.setMaxRPM(100.0);
		this.vehicle.setFinalDriveRatio(100.0);
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
		expResult += 11 * this.vehicle.getRollingCcoefficient().hashCode();
		expResult += 11 * this.vehicle.getWheelSize().hashCode();
		expResult += 11 * this.vehicle.getTorque().hashCode();
		expResult += 11 * this.vehicle.getRPM().hashCode();
		expResult += 11 * this.vehicle.getComsumption().hashCode();
		expResult += 11 * this.vehicle.getMinRPM().hashCode();
		expResult += 11 * this.vehicle.getMaxRPM().hashCode();
		expResult += 11 * this.vehicle.getFinalDriveRatio().hashCode();
		for (Map.Entry<String, Double> entity : this.vehicle.getVelocityLimits().
			entrySet()) {
			expResult += 7 * entity.getKey().hashCode();
			expResult += 7 * entity.getValue().hashCode();
		}
		for (Map.Entry<Integer, Double> entity : this.vehicle.getGears().
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

}
