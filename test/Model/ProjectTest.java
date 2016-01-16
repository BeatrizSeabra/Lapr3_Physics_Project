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
 * @author LAPR3_20152016_G27
 */
public class ProjectTest {

	private Project project;
	private RoadNetwork roadNetwork;
	private Node node0;
	private Node node1;
	private Node node2;
	private Node node3;
	private Node node4;
	private Section section0;
	private Section section1;
	private Section section2;
	private Section section3;
	private Section section4;
	private Section section5;
	private Segment segment0;
	private Segment segment1;
	private Segment segment2;
	private Segment segment3;
	private Segment segment4;
	private Segment segment5;
	private Segment segment6;
	private Segment segment7;
	private Segment segment8;
	private Segment segment9;

	public ProjectTest() {
		this.project = new Project();
		this.project.setId(1);
		this.project.setName("Project Name");
		this.project.setDescription("Project Description");
		this.segment0 = new Segment();
		this.segment0.setName("01");
		this.segment0.setHeight(new Measure(100.0, "km"));
		this.segment0.setSlope(new Measure(0.0, "%"));
		this.segment0.setLength(new Measure(25.0, "km"));
		this.segment0.setMaxVelocity(new Measure(120.0, "km/h"));
		this.segment0.setMinVelocity(new Measure(50.0, "km/h"));
		this.segment0.setNumberVehicles(200);
		this.section0 = new Section();
		this.section0.setRoad("A01");
		this.section0.setTypology("highway");
		this.section0.setDirection("bidirectional");
		this.section0.setToll(new Measure(12.0, "€"));
		this.section0.setWindDirection(new Measure(-5.0, "°"));
		this.section0.setWindSpeed(new Measure(3.0, "m/s"));
		this.section0.addSegment(this.segment0);

		this.segment1 = new Segment();
		this.segment1.setName("01");
		this.segment1.setHeight(new Measure(100.0, "km"));
		this.segment1.setSlope(new Measure(0.5, "%"));
		this.segment1.setLength(new Measure(20.0, "km"));
		this.segment1.setMaxVelocity(new Measure(120.0, "km/h"));
		this.segment1.setMinVelocity(new Measure(50.0, "km/h"));
		this.segment1.setNumberVehicles(1500);
		this.section1 = new Section();
		this.section1.setRoad("A01");
		this.section1.setTypology("highway");
		this.section1.setDirection("bidirectional");
		this.section1.setToll(new Measure(4.0, "€"));
		this.section1.setWindDirection(new Measure(-5.0, "°"));
		this.section1.setWindSpeed(new Measure(3.0, "m/s"));
		this.section1.addSegment(this.segment1);

		this.segment2 = new Segment();
		this.segment2.setName("01");
		this.segment2.setHeight(new Measure(100.0, "km"));
		this.segment2.setSlope(new Measure(3.0, "%"));
		this.segment2.setLength(new Measure(3.2, "km"));
		this.segment2.setMaxVelocity(new Measure(90.0, "km/h"));
		this.segment2.setMinVelocity(new Measure(0.0, "km/h"));
		this.segment2.setNumberVehicles(250);
		this.segment3 = new Segment();
		this.segment3.setName("02");
		this.segment3.setHeight(new Measure(196.0, "km"));
		this.segment3.setSlope(new Measure(-1.5, "%"));
		this.segment3.setLength(new Measure(6.4, "km"));
		this.segment3.setMaxVelocity(new Measure(90.0, "km/h"));
		this.segment3.setMinVelocity(new Measure(0.0, "km/h"));
		this.segment3.setNumberVehicles(200);
		this.section2 = new Section();
		this.section2.setRoad("E01");
		this.section2.setTypology("regular road");
		this.section2.setDirection("bidirectional");
		this.section2.setToll(new Measure(0.0, "€"));
		this.section2.setWindDirection(new Measure(20.0, "°"));
		this.section2.setWindSpeed(new Measure(5.0, "m/s"));
		this.section2.addSegment(this.segment2);
		this.section2.addSegment(this.segment3);

		this.segment4 = new Segment();
		this.segment4.setName("01");
		this.segment4.setHeight(new Measure(100.0, "km"));
		this.segment4.setSlope(new Measure(1.5, "%"));
		this.segment4.setLength(new Measure(10.0, "km"));
		this.segment4.setMaxVelocity(new Measure(90.0, "km/h"));
		this.segment4.setMinVelocity(new Measure(0.0, "km/h"));
		this.segment4.setNumberVehicles(350);
		this.segment5 = new Segment();
		this.segment5.setName("02");
		this.segment5.setHeight(new Measure(150.0, "km"));
		this.segment5.setSlope(new Measure(1.0, "%"));
		this.segment5.setLength(new Measure(5.0, "km"));
		this.segment5.setMaxVelocity(new Measure(90.0, "km/h"));
		this.segment5.setMinVelocity(new Measure(0.0, "km/h"));
		this.segment5.setNumberVehicles(20);
		this.section3 = new Section();
		this.section3.setRoad("E01");
		this.section3.setTypology("regular road");
		this.section3.setDirection("bidirectional");
		this.section3.setToll(new Measure(0.0, "€"));
		this.section3.setWindDirection(new Measure(-5.0, "°"));
		this.section3.setWindSpeed(new Measure(3.0, "m/s"));
		this.section3.addSegment(this.segment4);
		this.section3.addSegment(this.segment5);

		this.segment6 = new Segment();
		this.segment6.setName("01");
		this.segment6.setHeight(new Measure(200.0, "km"));
		this.segment6.setSlope(new Measure(2.0, "%"));
		this.segment6.setLength(new Measure(10.0, "km"));
		this.segment6.setMaxVelocity(new Measure(90.0, "km/h"));
		this.segment6.setMinVelocity(new Measure(0.0, "km/h"));
		this.segment6.setNumberVehicles(300);
		this.segment7 = new Segment();
		this.segment7.setName("02");
		this.segment7.setHeight(new Measure(400.0, "km"));
		this.segment7.setSlope(new Measure(-2.5, "%"));
		this.segment7.setLength(new Measure(10.0, "km"));
		this.segment7.setMaxVelocity(new Measure(90.0, "km/h"));
		this.segment7.setMinVelocity(new Measure(0.0, "km/h"));
		this.segment7.setNumberVehicles(250);
		this.section4 = new Section();
		this.section4.setRoad("E01");
		this.section4.setTypology("regular road");
		this.section4.setDirection("bidirectional");
		this.section4.setToll(new Measure(0.0, "€"));
		this.section4.setWindDirection(new Measure(-5.0, "°"));
		this.section4.setWindSpeed(new Measure(5.0, "m/s"));
		this.section4.addSegment(this.segment6);
		this.section4.addSegment(this.segment7);

		this.segment8 = new Segment();
		this.segment8.setName("01");
		this.segment8.setHeight(new Measure(100.0, "km"));
		this.segment8.setSlope(new Measure(2.5, "%"));
		this.segment8.setLength(new Measure(10.0, "km"));
		this.segment8.setMaxVelocity(new Measure(90.0, "km/h"));
		this.segment8.setMinVelocity(new Measure(0.0, "km/h"));
		this.segment8.setNumberVehicles(150);
		this.segment9 = new Segment();
		this.segment9.setName("02");
		this.segment9.setHeight(new Measure(350.0, "km"));
		this.segment9.setSlope(new Measure(-4.0, "%"));
		this.segment9.setLength(new Measure(5.0, "km"));
		this.segment9.setMaxVelocity(new Measure(90.0, "km/h"));
		this.segment9.setMinVelocity(new Measure(0.0, "km/h"));
		this.segment9.setNumberVehicles(100);
		this.section5 = new Section();
		this.section5.setRoad("E06");
		this.section5.setTypology("regular road");
		this.section5.setDirection("bidirectional");
		this.section5.setToll(new Measure(0.0, "€"));
		this.section5.setWindDirection(new Measure(-15.0, "°"));
		this.section5.setWindSpeed(new Measure(10.0, "m/s"));
		this.section5.addSegment(this.segment8);
		this.section5.addSegment(this.segment9);

		this.node0 = new Node("n0");
		this.node1 = new Node("n1");
		this.node2 = new Node("n2");
		this.node3 = new Node("n3");
		this.node4 = new Node("n4");

		this.roadNetwork = new RoadNetwork();
		this.roadNetwork.addNode(this.node0);
		this.roadNetwork.addNode(this.node1);
		this.roadNetwork.addNode(this.node2);
		this.roadNetwork.addNode(this.node3);
		this.roadNetwork.addNode(this.node4);
		this.roadNetwork.addSection(this.node0, this.node1, this.section0);
		this.roadNetwork.addSection(this.node1, this.node3, this.section1);
		this.roadNetwork.addSection(this.node0, this.node2, this.section2);
		this.roadNetwork.addSection(this.node2, this.node3, this.section3);
		this.roadNetwork.addSection(this.node3, this.node4, this.section4);
		this.roadNetwork.addSection(this.node2, this.node4, this.section5);

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
	 * Test of getRoadNetwork method, of class Project.
	 */
	@Test
	public void testGetRoadNetwork() {
		System.out.println("getRoadNetwork");
		RoadNetwork expResult = roadNetwork;
		this.project.setRoadNetwork(roadNetwork);
		RoadNetwork result = this.project.getRoadNetwork();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setRoadNetwork method, of class Project.
	 */
	@Test
	public void testSetRoadNetwork() {
		System.out.println("setRoadNetwork");
		this.project.setRoadNetwork(roadNetwork);
		assertEquals(this.project.getRoadNetwork(), this.roadNetwork);
	}

	/**
	 * Test of addVehicle method, of class Project.
	 */
	@Test
	public void testAddVehicle() {
		System.out.println("addVehicle");
		Vehicle vehicle = new Vehicle();

		Boolean expResult = true;
		Boolean result = this.project.addVehicle(vehicle);
		assertEquals(expResult, result);

	}

	/**
	 * Test of getVehicles method, of class Project.
	 */
	@Test
	public void testGetVehicles() {
		System.out.println("getVehicles");
		List<Vehicle> list = new ArrayList<>();
		Vehicle expResult = new Vehicle();
		String name = "Nissan";
		expResult.setDescription("Teste");
		Measure measure = new Measure(22.0, "TesteCase");
		expResult.setDragCoefficient(measure);
		expResult.setEnergyRegeneration(measure);
		expResult.setEnergyRegeneration(measure);
		expResult.setFinalDriveRatio(measure);
		expResult.setFrontalArea(measure);
		expResult.setFuel("Diesel");
		expResult.setGear(12, measure);
		expResult.setId(0);
		expResult.setLoad(measure);
		expResult.setMass(measure);
		expResult.setMaxRPM(measure);
		expResult.setMinRPM(measure);
		expResult.setMotorization("FJAKJF");
		expResult.setName(name);
		expResult.setRollingRCoefficient(measure);
		expResult.setType("fajfa");
		Throttle instance = new Throttle();
		instance.setId(12);
		Measure mesureTorque = new Measure(12.2, "MeasureTorque");
		Measure rmpLow = new Measure(1.2, "MeasureTorque");
		Measure rmpHigh = new Measure(12.2, "MeasureTorque");
		Measure fuel = new Measure(12.2, "MeasureTorque");
		instance.setPercentage(mesureTorque);
		Regime regime = new Regime(mesureTorque, rmpLow, rmpHigh, fuel);
		List<Regime> regimes = new ArrayList<Regime>();
		regimes.add(regime);
		instance.setRegimes(regimes);
		ArrayList<Throttle> troti = new ArrayList<>();
		expResult.setThrottles(troti);
		expResult.setVelocityLimits("Highway", measure);
		expResult.setWheelSize(measure);
		this.project.addVehicle(expResult);
		list.add(expResult);
		List<Vehicle> result = this.project.getVehicles();
		assertEquals(list, result);
	}

	/**
	 * Test of getVehicle method, of class Project.
	 */
	@Test
	public void testGetVehicle() {
		System.out.println("getVehicle");
		String name = "Nissan";
		Vehicle expResult = new Vehicle();
		expResult.setDescription("Teste");
		Measure measure = new Measure(22.0, "TesteCase");
		expResult.setDragCoefficient(measure);
		expResult.setEnergyRegeneration(measure);
		expResult.setEnergyRegeneration(measure);
		expResult.setFinalDriveRatio(measure);
		expResult.setFrontalArea(measure);
		expResult.setFuel("Diesel");
		expResult.setGear(12, measure);
		expResult.setId(0);
		expResult.setLoad(measure);
		expResult.setMass(measure);
		expResult.setMaxRPM(measure);
		expResult.setMinRPM(measure);
		expResult.setMotorization("FJAKJF");
		expResult.setName(name);
		expResult.setRollingRCoefficient(measure);
		expResult.setType("fajfa");
		Throttle instance = new Throttle();
		instance.setId(12);
		Measure mesureTorque = new Measure(12.2, "MeasureTorque");
		Measure rmpLow = new Measure(1.2, "MeasureTorque");
		Measure rmpHigh = new Measure(12.2, "MeasureTorque");
		Measure fuel = new Measure(12.2, "MeasureTorque");
		instance.setPercentage(mesureTorque);
		Regime regime = new Regime(mesureTorque, rmpLow, rmpHigh, fuel);
		List<Regime> regimes = new ArrayList<Regime>();
		regimes.add(regime);
		instance.setRegimes(regimes);
		ArrayList<Throttle> troti = new ArrayList<>();
		expResult.setThrottles(troti);
		expResult.setVelocityLimits("Highway", measure);
		expResult.setWheelSize(measure);
		this.project.addVehicle(expResult);
		Vehicle result = this.project.getVehicle(name);
		assertEquals(expResult, result);
	}

	/**
	 * Test of addSimulation method, of class Project.
	 */
	@Test
	public void testAddSimulation() {
		System.out.println("addSimulation");
		Simulation simulation = new Simulation();
		Boolean expResult = true;
		Boolean result = project.addSimulation(simulation);
		assertEquals(expResult, result);
	}

	/**
	 * Test of getSimulations method, of class Project.
	 */
	@Test
	public void testGetSimulations() {
		System.out.println("getSimulations");
		List<Simulation> expResult = new ArrayList<>();
		Simulation simulation = new Simulation();
		this.project.addSimulation(simulation);
		expResult.add(simulation);
		List<Simulation> result = this.project.getSimulations();
		assertEquals(expResult, result);
	}

	/**
	 * Test of toString method, of class Project.
	 */
	@Test
	public void testToString() {
		System.out.println("toString");
		System.out.println(project.toString());
		String expResult = "Project | name: Project Name | description: Project Description";
		String result = this.project.toString();
		assertEquals(expResult, result);
	}

	/**
	 * Test of clone method, of class Project.
	 */
	@Test
	public void testClone() {
		System.out.println("clone");
		Project expResult = this.project;
		Project result = this.project.clone();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getId method, of class Project.
	 */
	@Test
	public void testGetId() {
		System.out.println("getId");
		Integer expResult = 1;
		Integer result = this.project.getId();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setId method, of class Project.
	 */
	@Test
	public void testSetId() {
		System.out.println("setId");
		Integer id = 1;
		this.project.setId(id);
		assertEquals(id, this.project.getId());
	}

	/**
	 * Test of getName method, of class Project.
	 */
	@Test
	public void testGetName() {
		System.out.println("getName");
		String expResult = "Espinho";
		this.project.setName(expResult);
		String result = this.project.getName();
		assertEquals(expResult, result);
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
		//	fail("The test case is a prototype.");
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
		//	fail("The test case is a prototype.");
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
		//	fail("The test case is a prototype.");
	}

}
