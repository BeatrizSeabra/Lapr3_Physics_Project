/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Physics.Measure;
import Simulation.VehicleBot;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
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
public class NodeTest {

	private Node node;
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
	private Vehicle vehicle;

	public NodeTest() {

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

		this.node = new Node("Node name");
		this.node.setId(1);
		this.node.setName("Simulation");

		Throttle throttle1 = new Throttle();
		throttle1.setPercentage(new Measure(25.0, "%"));
		throttle1.
			addRegime(new Regime(new Measure(85.0, "Nm"), new Measure(1000.0, "rpm"), new Measure(2499.0, "rpm"), new Measure(8.2, "g/KWh")));
		throttle1.
			addRegime(new Regime(new Measure(95.0, "Nm"), new Measure(2500.0, "rpm"), new Measure(3999.0, "rpm"), new Measure(6.2, "g/KWh")));
		throttle1.
			addRegime(new Regime(new Measure(80.0, "Nm"), new Measure(4000.0, "rpm"), new Measure(5500.0, "rpm"), new Measure(10.2, "g/KWh")));
		Throttle throttle2 = new Throttle();
		throttle2.setPercentage(new Measure(50.0, "%"));
		throttle2.
			addRegime(new Regime(new Measure(135.0, "Nm"), new Measure(1000.0, "rpm"), new Measure(2499.0, "rpm"), new Measure(5.2, "g/KWh")));
		throttle2.
			addRegime(new Regime(new Measure(150.0, "Nm"), new Measure(2500.0, "rpm"), new Measure(3999.0, "rpm"), new Measure(3.2, "g/KWh")));
		throttle2.
			addRegime(new Regime(new Measure(140.0, "Nm"), new Measure(4000.0, "rpm"), new Measure(5500.0, "rpm"), new Measure(8.2, "g/KWh")));
		Throttle throttle3 = new Throttle();
		throttle3.setPercentage(new Measure(100.0, "%"));
		throttle3.
			addRegime(new Regime(new Measure(200.0, "Nm"), new Measure(1000.0, "rpm"), new Measure(2499.0, "rpm"), new Measure(2.2, "g/KWh")));
		throttle3.
			addRegime(new Regime(new Measure(240.0, "Nm"), new Measure(2500.0, "rpm"), new Measure(3999.0, "rpm"), new Measure(1.2, "g/KWh")));
		throttle3.
			addRegime(new Regime(new Measure(190.0, "Nm"), new Measure(4000.0, "rpm"), new Measure(5500.0, "rpm"), new Measure(4.2, "g/KWh")));
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
		this.vehicle.setFrontalArea(new Measure(1.8, "m2"));
		this.vehicle.setRollingRCoefficient(new Measure(0.01, "ratio"));
		this.vehicle.setWheelSize(new Measure(0.3266, "m"));
		this.vehicle.setMinRPM(new Measure(8500.0, "rpm"));
		this.vehicle.setMaxRPM(new Measure(1000.0, "rpm"));
		this.vehicle.setFinalDriveRatio(new Measure(3.545, "ratio"));
		this.vehicle.setEnergyRegeneration(new Measure(22.0, "rpm"));
		this.vehicle.setGear(1, new Measure(3.827, "ratio"));
		this.vehicle.setGear(2, new Measure(2.36, "ratio"));
		this.vehicle.setGear(3, new Measure(1.685, "ratio"));
		this.vehicle.setGear(4, new Measure(1.312, "ratio"));
		this.vehicle.setGear(5, new Measure(1.0, "ratio"));
		this.vehicle.setGear(6, new Measure(0.793, "ratio"));
		this.vehicle.addThrottle(throttle1);
		this.vehicle.addThrottle(throttle2);
		this.vehicle.addThrottle(throttle3);
		this.vehicle.setVelocityLimits("road", new Measure(60.0, "km/h"));
		Map<Section, VehicleBot> bots = new HashMap();
		Deque<Section> section = new ArrayDeque<>();
		section.add(section0);
		section.add(section1);
		section.add(section2);
		section.add(section3);
		section.add(section4);
		section.add(section5);
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
	 * Test of getName and setName method, of class Node.
	 */
	@Test
	public void testSetGetName() {
		System.out.println("testSetGetName");
		String expresult = "Node 1";
		this.node.setName(expresult);
		assertEquals(expresult, this.node.getName());
	}

	/**
	 * Test of hashCode method, of class Node.
	 */
	@Test
	public void testHashCode() {
		System.out.println("testHashCode");
		Integer expResult = 29 * this.node.getClass().hashCode();
		expResult += 11 * this.node.getId().hashCode();
		expResult += 11 * this.node.getName().hashCode();

		Integer result = this.node.hashCode();
		assertEquals(expResult, result);
	}

	/**
	 * Test of equals method, of class Node.
	 */
	@Test
	public void testEquals() {
		System.out.println("testEquals");
		Node node = this.node.clone();
		assertEquals(true, this.node.equals(node));
	}

	/**
	 * Test of equals method, of class Node.
	 */
	@Test
	public void testEqualsFalseHash() {
		System.out.println("testEqualsFalseHash");
		Node node = new Node("Node 1");
		assertEquals(false, this.node.equals(node));
	}

	/**
	 * Test of equals method, of class Node.
	 */
	@Test
	public void testEqualsFalseNull() {
		System.out.println("testEqualsFalseNull");
		assertEquals(false, this.node.equals(null));
	}

	/**
	 * Test of equals method, of class Node.
	 */
	@Test
	public void testEqualsFalseClass() {
		System.out.println("testEqualsFalseClass");
		assertEquals(false, this.node.equals(new String()));
	}

	/**
	 * Test of getId method, of class Node.
	 */
	@Test
	public void testGetId() {
		System.out.println("getId");
		Node instance = new Node("node");
		Integer expResult = 0;
		Integer result = instance.getId();
		assertEquals(expResult, result);

	}

	/**
	 * Test of setId method, of class Node.
	 */
	@Test
	public void testSetId() {
		System.out.println("setId");
		Integer id = null;
		Node instance = new Node("node1");
		Integer expResult = 0;
		instance.setId(0);
		assertEquals(expResult, instance.getId());

	}

	/**
	 * Test of getName method, of class Node.
	 */
	@Test
	public void testGetName() {
		System.out.println("getName");
		Node instance = new Node("test");
		String expResult = "test";
		String result = instance.getName();
		assertEquals(expResult, result);

	}

	/**
	 * Test of setName method, of class Node.
	 */
	@Test
	public void testSetName() {
		System.out.println("setName");
		String name = "";
		Node instance = new Node("test");
		String expResult = "test2";

		instance.setName("test2");
		assertEquals(expResult, instance.getName());
	}

	/**
	 * Test of clone method, of class Node.
	 */
	@Test
	public void testClone() {
		System.out.println("clone");
		Node instance = new Node("test");

		String expResult = instance.toString();
		String result = instance.clone().toString();
		assertEquals(expResult, result);
	}

	/**
	 * Test of toString method, of class Node.
	 */
	@Test
	public void testToString() {
		System.out.println("toString");
		Node instance = new Node("test");
		String expResult = "test";
		String result = instance.toString();
		assertEquals(expResult.getClass(), result.getClass());

	}
}
