/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
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
public class ProjectTest {

	private Project project;

	public ProjectTest() {
		this.project = new Project();
		this.project.setId(1);
		this.project.setName("Project Name");
		this.project.setDescription("Project Description");
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
	 * Test of getId and setId method, of class Project.
	 */
	@Test
	public void testSetGetId() {
		System.out.println("testSetGetId");
		Integer expResult = 11;
		this.project.setId(expResult);
		Integer result = this.project.getId();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getName and setName method, of class Project.
	 */
	@Test
	public void testSetGetName() {
		System.out.println("testSetGetName");
		String expResult = "New Name";
		this.project.setName(expResult);
		String result = this.project.getName();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getDescription and setDescription method, of class Project.
	 */
	@Test
	public void testSetGetDescription() {
		System.out.println("testSetGetDescription");
		String expResult = "New Description";
		this.project.setDescription(expResult);
		String result = this.project.getDescription();
		assertEquals(expResult, result);
	}

	/**
	 * Test of hashCode method, of class Project.
	 */
	@Test
	public void testHashCode() {
		System.out.println("testHashCode");
		Integer expResult = 29 * this.project.getClass().hashCode();
		expResult += 11 * this.project.getId().hashCode();
		expResult += 11 * this.project.getName().hashCode();
		expResult += 11 * this.project.getDescription().hashCode();
		expResult += 11 * this.project.getRoadNetwork().hashCode();
		for (Vehicle vehicle : this.project.getVehicles()) {
			expResult += 7 * vehicle.hashCode();
		}
		for (Simulation simulation : this.project.getSimulations()) {
			expResult += 7 * simulation.hashCode();
		}
		Integer result = this.project.hashCode();
		assertEquals(expResult, result);
	}

	/**
	 * Test of equals method, of class Project.
	 */
	@Test
	public void testEquals() {
		System.out.println("testEquals");
		Project project = new Project();
		project.setId(1);
		project.setName("Project Name");
		project.setDescription("Project Description");
		Boolean result = this.project.equals(project);
		Boolean expResult = true;
		assertEquals(expResult, result);
	}

	/**
	 * Test of equals method, of class Project.
	 */
	@Test
	public void testEqualsFalseHash() {
		System.out.println("testEqualsFalseHash");
		Project project = new Project();
		project.setId(11);
		project.setName("Project Name");
		project.setDescription("Project Description");
		Boolean result = this.project.equals(project);
		Boolean expResult = false;
		assertEquals(expResult, result);
	}

	/**
	 * Test of equals method, of class Project.
	 */
	@Test
	public void testEqualsFalseNull() {
		System.out.println("testEqualsFalseNull");
		Boolean result = this.project.equals(null);
		Boolean expResult = false;
		assertEquals(expResult, result);
	}

	/**
	 * Test of equals method, of class Project.
	 */
	@Test
	public void testEqualsFalseClass() {
		System.out.println("testEqualsFalseClass");
		Boolean result = this.project.equals(new String());
		Boolean expResult = false;
		assertEquals(expResult, result);
	}

	/**
	 * Test of getId method, of class Project.
	 */
	@Test
	public void testGetId() {
		System.out.println("getId");
		Project instance = new Project();
		Integer expResult = null;
		Integer result = instance.getId();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setId method, of class Project.
	 */
	@Test
	public void testSetId() {
		System.out.println("setId");
		Integer id = null;
		Project instance = new Project();
		instance.setId(id);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getName method, of class Project.
	 */
	@Test
	public void testGetName() {
		System.out.println("getName");
		Project instance = new Project();
		String expResult = "";
		String result = instance.getName();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setName method, of class Project.
	 */
	@Test
	public void testSetName() {
		System.out.println("setName");
		String name = "";
		Project instance = new Project();
		instance.setName(name);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getDescription method, of class Project.
	 */
	@Test
	public void testGetDescription() {
		System.out.println("getDescription");
		Project instance = new Project();
		String expResult = "";
		String result = instance.getDescription();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setDescription method, of class Project.
	 */
	@Test
	public void testSetDescription() {
		System.out.println("setDescription");
		String description = "";
		Project instance = new Project();
		instance.setDescription(description);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getRoadNetwork method, of class Project.
	 */
	@Test
	public void testGetRoadNetwork() {
		System.out.println("getRoadNetwork");
		Project instance = new Project();
		RoadNetwork expResult = null;
		RoadNetwork result = instance.getRoadNetwork();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setRoadNetwork method, of class Project.
	 */
	@Test
	public void testSetRoadNetwork() {
		System.out.println("setRoadNetwork");
		RoadNetwork roadNetwork = null;
		Project instance = new Project();
		instance.setRoadNetwork(roadNetwork);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of addVehicle method, of class Project.
	 */
	@Test
	public void testAddVehicle() {
		System.out.println("addVehicle");
		Vehicle vehicle = null;
		Project instance = new Project();
		Boolean expResult = null;
		Boolean result = instance.addVehicle(vehicle);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getVehicles method, of class Project.
	 */
	@Test
	public void testGetVehicles() {
		System.out.println("getVehicles");
		Project instance = new Project();
		List<Vehicle> expResult = null;
		List<Vehicle> result = instance.getVehicles();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getVehicle method, of class Project.
	 */
	@Test
	public void testGetVehicle() {
		System.out.println("getVehicle");
		String name = "";
		Project instance = new Project();
		Vehicle expResult = null;
		Vehicle result = instance.getVehicle(name);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of addSimulation method, of class Project.
	 */
	@Test
	public void testAddSimulation() {
		System.out.println("addSimulation");
		Simulation simulation = null;
		Project instance = new Project();
		Boolean expResult = null;
		Boolean result = instance.addSimulation(simulation);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getSimulations method, of class Project.
	 */
	@Test
	public void testGetSimulations() {
		System.out.println("getSimulations");
		Project instance = new Project();
		List<Simulation> expResult = null;
		List<Simulation> result = instance.getSimulations();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of toString method, of class Project.
	 */
	@Test
	public void testToString() {
		System.out.println("toString");
		Project instance = new Project();
		String expResult = "";
		String result = instance.toString();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of clone method, of class Project.
	 */
	@Test
	public void testClone() {
		System.out.println("clone");
		Project instance = new Project();
		Project expResult = null;
		Project result = instance.clone();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

}
