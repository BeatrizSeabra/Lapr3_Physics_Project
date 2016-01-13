/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Physics.Measure;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author ruben
 */
public class SimulationTest {

	private Simulation simulation;

	public SimulationTest() {
		this.simulation = new Simulation();
		this.simulation.setId(1);
		this.simulation.setDescription("test");
		this.simulation.setName("test2");

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
	 * Test of getId method, of class Simulation.
	 */
	@Test
	public void testSetGetId() {
		System.out.println("testSetGetId");

		Integer expResult = 2;
		this.simulation.setId(expResult);

		Integer result = this.simulation.getId();
		assertEquals(expResult, result);

	}

	/**
	 * Test of getName method, of class Simulation.
	 */
	@Test
	public void testSetGetName() {
		System.out.println("testSetGetName");

		String expResult = "test4";
		this.simulation.setName(expResult);
		String result = this.simulation.getName();
		assertEquals(expResult, result);

	}

	/**
	 * Test of getDescription method, of class Simulation.
	 */
	@Test
	public void testSetGetDescription() {
		System.out.println("SetGetDescription");

		String expResult = "test5";
		this.simulation.setDescription(expResult);
		String result = this.simulation.getDescription();
		assertEquals(expResult, result);

	}

	/**
	 * Test of getTraffics method, of class Simulation.
	 */
	@Test
	public void testGetTraffics() {
		System.out.println("getTraffics");
		Traffic traffic = new Traffic();
		traffic.setId(1);
		traffic.setNodeStart(new Node("test"));
		traffic.setNodeEnd(new Node("test2"));
		traffic.setVehicle(new Vehicle());
		traffic.setArrivalRate(new Measure(2.0, "test3"));
		List<Traffic> traf = new ArrayList<Traffic>();
		traf.add(traffic);
		this.simulation.setTraffics(traf);
		List<Traffic> expResult = traf;
		List<Traffic> result = this.simulation.getTraffics();
		assertEquals(expResult, result);

	}

	/**
	 * Test of setTraffics method, of class Simulation.
	 */
	@Test
	public void testSetTraffics() {
		System.out.println("setTraffics");
		Traffic traffic = new Traffic();
		traffic.setId(1);
		traffic.setNodeStart(new Node("test1"));
		traffic.setNodeEnd(new Node("test22"));
		traffic.setVehicle(new Vehicle());
		traffic.setArrivalRate(new Measure(6.0, "test33"));
		List<Traffic> traf = new ArrayList<Traffic>();
		traf.add(traffic);
		this.simulation.setTraffics(traf);
		List<Traffic> expResult = traf;
		List<Traffic> result = this.simulation.getTraffics();
		assertEquals(expResult, result);
	}

	/**
	 * Test of equals method, of class Simulation.
	 */
	@Test
	public void testEquals() {
		System.out.println("equals");

		this.simulation.setDescription("test");
		this.simulation.setName("test2");
		this.simulation.setId(1);
		assertEquals(true, this.simulation.equals(simulation));

	}

	/**
	 * Test of hashCode method, of class Simulation.
	 */
	@Test
	public void testHashCode() {
		System.out.println("hashCode");
		Integer expResult = 29 * this.simulation.getClass().hashCode();
		expResult += 11 * this.simulation.getDescription().hashCode();
		expResult += 11 * this.simulation.getName().hashCode();
		expResult += 11 * this.simulation.getId().hashCode();

		Integer result = this.simulation.hashCode();
		assertEquals(expResult, result);
	}

	/**
	 * Test of clone method, of class Simulation.
	 */
	@Test
	public void testClone() {
		System.out.println("clone");
		Simulation instance = new Simulation();

		instance.setDescription("test");
		instance.setId(1);
		instance.setName("test2");

		Simulation result = instance.clone();
		assertEquals(this.simulation, result);

	}

	/**
	 * Test of toString method, of class Simulation.
	 */
	@Test
	public void testToString() {
		System.out.println("testToString");
		String expResult = "Simulation - test2 - test\n";
		String result = this.simulation.toString();
		assertEquals(expResult, result);

	}

	/**
	 * Test of equals method, of class Section.
	 */
	@Test
	public void testEqualsFalseNull() {
		System.out.println("testEqualsFalseNull");
		Boolean result = this.simulation.equals(null);
		Boolean expResult = false;
		assertEquals(expResult, result);
	}

	/**
	 * Test of equals method, of class Section.
	 */
	@Test
	public void testEqualsFalseClass() {
		System.out.println("testEqualsFalseClass");
		Boolean result = this.simulation.equals(new String());
		Boolean expResult = false;
		assertEquals(expResult, result);
	}

	/**
	 * Test of addTraffic method, of class Simulation.
	 */
	@Test
	public void testAddTraffic() {
		System.out.println("addTraffic");
		Traffic traffic = new Traffic();
		Simulation instance = new Simulation();
		Boolean expResult = true;
		Boolean result = instance.addTraffic(traffic);
		assertEquals(expResult, result);
	}

	/**
	 * Test of getTraffic method, of class Simulation.
	 */
	@Test
	public void testGetTraffic() {
		System.out.println("getTraffic");
		int index = 0;
		Simulation instance = new Simulation();
		Traffic obj = new Traffic();
		Vehicle vec = new Vehicle();
		ArrayList<Traffic> traf = new ArrayList<>();
		obj.setId(0);
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
		obj.setVehicle(vec);
		Node nodeEnd = new Node("Anta");
		nodeEnd.setId(0);
		nodeEnd.setName("Anta");
		Node nodeStart = new Node("Espinho");
		nodeStart.setId(1);
		nodeEnd.setName("Espinho");
		obj.setNodeEnd(nodeEnd);
		obj.setNodeStart(nodeStart);
		obj.setArrivalRate(rmpLow);
		instance.addTraffic(obj);
		traf.add(obj);
		Traffic expResult = traf.get(0);
		instance.setTraffics(traf);
		Traffic result = instance.getTraffic(index);
		assertEquals(expResult, result);
	}

	/**
	 * Test of getId method, of class Simulation.
	 */
	@Test
	public void testGetId() {
		System.out.println("getId");
		Simulation instance = new Simulation();
		instance.setId(1);
		Integer expResult = 1;
		Integer result = instance.getId();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setId method, of class Simulation.
	 */
	@Test
	public void testSetId() {
		System.out.println("setId");
		Integer id = null;
		Simulation instance = new Simulation();
		instance.setId(id);
	}

	/**
	 * Test of getName method, of class Simulation.
	 */
	@Test
	public void testGetName() {
		System.out.println("getName");
		Simulation instance = new Simulation();
		String expResult = "";
		String result = instance.getName();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setName method, of class Simulation.
	 */
	@Test
	public void testSetName() {
		System.out.println("setName");
		String name = "";
		Simulation instance = new Simulation();
		instance.setName(name);
	}

	/**
	 * Test of getDescription method, of class Simulation.
	 */
	@Test
	public void testGetDescription() {
		System.out.println("getDescription");
		this.simulation.setDescription("Descript");
		String expResult = "Descript";
		String result = this.simulation.getDescription();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setDescription method, of class Simulation.
	 */
	@Test
	public void testSetDescription() {
		System.out.println("setDescription");
		String description = "Descript";
		this.simulation.setDescription(description);
		assertEquals(description, this.simulation.getDescription());
	}

}
