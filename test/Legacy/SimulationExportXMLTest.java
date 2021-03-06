/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Legacy;

import Controller.ContextController;
import Model.Node;
import Model.Project;
import Model.Regime;
import Model.RoadNetwork;
import Model.Section;
import Model.Segment;
import Model.Simulation;
import Model.Throttle;
import Model.Traffic;
import Model.Vehicle;
import Physics.Measure;
import System.Settings;
import java.util.ArrayList;
import java.util.List;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class SimulationExportXMLTest {

	private SimulationExportXML simulationExportXML;
	private String filePathSimulation;
	private String dataXML;
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
	private Segment segment0;
	private Segment segment1;
	private Segment segment2;
	private Segment segment3;
	private Segment segment4;
	private Segment segment5;
	private Vehicle vehicle;
	private Simulation simulation;
	private List<Simulation> simulations;
	private Traffic traffic1;
	private Traffic traffic2;
	private Traffic traffic3;
	private Traffic traffic4;
	private Traffic traffic5;
	private Traffic traffic6;
	private Traffic traffic7;
	private Traffic traffic8;

	public SimulationExportXMLTest() {
		Settings.setSettingsFilePath("test/Files/settingsTest.properties");
		this.simulationExportXML = new SimulationExportXML();
		this.filePathSimulation = Settings.getOption("SimulationFilePath");
		this.dataXML = Legacy.readFile(this.filePathSimulation);

		Throttle throttle1 = new Throttle();
		throttle1.setPercentage(new Measure(25.0, "%"));
		throttle1.
			addRegime(new Regime(new Measure(85.0, "Nm"), new Measure(1000.0, "rpm"), new Measure(2499.0, "rpm"), new Measure(8.2, "km/l")));
		throttle1.
			addRegime(new Regime(new Measure(95.0, "Nm"), new Measure(2500.0, "rpm"), new Measure(3999.0, "rpm"), new Measure(6.2, "km/l")));
		throttle1.
			addRegime(new Regime(new Measure(80.0, "Nm"), new Measure(4000.0, "rpm"), new Measure(5500.0, "rpm"), new Measure(10.2, "km/l")));
		Throttle throttle2 = new Throttle();
		throttle2.setPercentage(new Measure(50.0, "%"));
		throttle2.
			addRegime(new Regime(new Measure(135.0, "Nm"), new Measure(1000.0, "rpm"), new Measure(2499.0, "rpm"), new Measure(5.2, "km/l")));
		throttle2.
			addRegime(new Regime(new Measure(150.0, "Nm"), new Measure(2500.0, "rpm"), new Measure(3999.0, "rpm"), new Measure(3.2, "km/l")));
		throttle2.
			addRegime(new Regime(new Measure(140.0, "Nm"), new Measure(4000.0, "rpm"), new Measure(5500.0, "rpm"), new Measure(8.2, "km/l")));
		Throttle throttle3 = new Throttle();
		throttle3.setPercentage(new Measure(100.0, "%"));
		throttle3.
			addRegime(new Regime(new Measure(200.0, "Nm"), new Measure(1000.0, "rpm"), new Measure(2499.0, "rpm"), new Measure(2.2, "km/l")));
		throttle3.
			addRegime(new Regime(new Measure(240.0, "Nm"), new Measure(2500.0, "rpm"), new Measure(3999.0, "rpm"), new Measure(1.2, "km/l")));
		throttle3.
			addRegime(new Regime(new Measure(190.0, "Nm"), new Measure(4000.0, "rpm"), new Measure(5500.0, "rpm"), new Measure(4.2, "km/l")));
		this.vehicle = new Vehicle();
		this.vehicle.setId(1);
		this.vehicle.setName("Dummy01");
		this.vehicle.setDescription("Dummy teste vehicle");
		this.vehicle.setType("car");
		this.vehicle.setMotorization("combustion");
		this.vehicle.setFuel("gasoline");
		this.vehicle.setMass(new Measure(1400.0, "Kg"));
		this.vehicle.setLoad(new Measure(120.0, "kg"));
		this.vehicle.setDragCoefficient(new Measure(0.35, "ratio"));
		this.vehicle.setFrontalArea(new Measure(1.8, "m2"));
		this.vehicle.setRollingRCoefficient(new Measure(0.01, "ratio"));
		this.vehicle.setWheelSize(new Measure(0.5, "m"));
		this.vehicle.getVelocityLimits().
			put("Highway", new Measure(100.0, "km/h"));
		this.vehicle.setMinRPM(new Measure(1000.0, "rpm"));
		this.vehicle.setMaxRPM(new Measure(5500.0, "rpm"));
		this.vehicle.setFinalDriveRatio(new Measure(2.6, "ratio"));
		this.vehicle.getGears().put(01, new Measure(3.5, "ratio"));
		this.vehicle.getGears().put(02, new Measure(2.5, "ratio"));
		this.vehicle.getGears().put(03, new Measure(1.25, "ratio"));
		this.vehicle.getGears().put(04, new Measure(0.9, "ratio"));
		this.vehicle.getGears().put(04, new Measure(0.9, "ratio"));
		this.vehicle.addThrottle(throttle1);
		this.vehicle.addThrottle(throttle2);
		this.vehicle.addThrottle(throttle3);

		this.segment0 = new Segment();
		this.segment0.setName("01");
		this.segment0.setHeight(new Measure(100.0, "km"));
		this.segment0.setSlope(new Measure(1.5, "%"));
		this.segment0.setLength(new Measure(3.2, "km"));
		this.segment0.setMaxVelocity(new Measure(90.0, "km/h"));
		this.segment0.setMinVelocity(new Measure(0.0, "km/h"));
		this.segment0.setNumberVehicles(20);
		this.segment1 = new Segment();
		this.segment1.setName("02");
		this.segment1.setHeight(new Measure(148.0, "km"));
		this.segment1.setSlope(new Measure(-1.5, "%"));
		this.segment1.setLength(new Measure(3.2, "km"));
		this.segment1.setMaxVelocity(new Measure(90.0, "km/h"));
		this.segment1.setMinVelocity(new Measure(0.0, "km/h"));
		this.segment1.setNumberVehicles(20);
		this.section0 = new Section();
		this.section0.setRoad("E01");
		this.section0.setTypology("regular road");
		this.section0.setDirection("bidirectional");
		this.section0.setToll(new Measure(0.0, "€"));
		this.section0.setWindDirection(new Measure(20.0, "°"));
		this.section0.setWindSpeed(new Measure(3.0, "m/s"));
		this.section0.addSegment(this.segment0);
		this.section0.addSegment(this.segment1);

		this.segment2 = new Segment();
		this.segment2.setName("01");
		this.segment2.setHeight(new Measure(100.0, "km"));
		this.segment2.setSlope(new Measure(0.0, "%"));
		this.segment2.setLength(new Measure(10.0, "km"));
		this.segment2.setMaxVelocity(new Measure(90.0, "km/h"));
		this.segment2.setMinVelocity(new Measure(0.0, "km/h"));
		this.segment2.setNumberVehicles(30);
		this.segment3 = new Segment();
		this.segment3.setName("02");
		this.segment3.setHeight(new Measure(100.0, "km"));
		this.segment3.setSlope(new Measure(0.5, "%"));
		this.segment3.setLength(new Measure(5.0, "km"));
		this.segment3.setMaxVelocity(new Measure(90.0, "km/h"));
		this.segment3.setMinVelocity(new Measure(0.0, "km/h"));
		this.segment3.setNumberVehicles(20);
		this.section1 = new Section();
		this.section1.setRoad("E01");
		this.section1.setTypology("regular road");
		this.section1.setDirection("bidirectional");
		this.section1.setToll(new Measure(0.0, "€"));
		this.section1.setWindDirection(new Measure(-5.0, "°"));
		this.section1.setWindSpeed(new Measure(3.0, "m/s"));
		this.section1.addSegment(this.segment2);
		this.section1.addSegment(this.segment3);

		this.segment4 = new Segment();
		this.segment4.setName("01");
		this.segment4.setHeight(new Measure(100.0, "km"));
		this.segment4.setSlope(new Measure(0.0, "%"));
		this.segment4.setLength(new Measure(20.0, "km"));
		this.segment4.setMaxVelocity(new Measure(120.0, "km/h"));
		this.segment4.setMinVelocity(new Measure(50.0, "km/h"));
		this.segment4.setNumberVehicles(100);
		this.section2 = new Section();
		this.section2.setRoad("A01");
		this.section2.setTypology("highway");
		this.section2.setDirection("bidirectional");
		this.section2.setToll(new Measure(12.0, "€"));
		this.section2.setWindDirection(new Measure(-5.0, "°"));
		this.section2.setWindSpeed(new Measure(3.0, "m/s"));
		this.section2.addSegment(this.segment4);

		this.segment5 = new Segment();
		this.segment5.setName("01");
		this.segment5.setHeight(new Measure(100.0, "km"));
		this.segment5.setSlope(new Measure(0.125, "%"));
		this.segment5.setLength(new Measure(20.0, "km"));
		this.segment5.setMaxVelocity(new Measure(120.0, "km/h"));
		this.segment5.setMinVelocity(new Measure(50.0, "km/h"));
		this.segment5.setNumberVehicles(100);
		this.section3 = new Section();
		this.section3.setRoad("A03");
		this.section3.setTypology("highway");
		this.section3.setDirection("bidirectional");
		this.section3.setToll(new Measure(4.0, "€"));
		this.section3.setWindDirection(new Measure(-5.0, "°"));
		this.section3.setWindSpeed(new Measure(3.0, "m/s"));
		this.section3.addSegment(this.segment5);

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
		this.roadNetwork.addSection(this.node1, this.node2, this.section1);
		this.roadNetwork.addSection(this.node0, this.node2, this.section2);
		this.roadNetwork.addSection(this.node1, this.node2, this.section3);
		this.roadNetwork.addSection(this.node1, this.node0, this.section0.
									reverse());
		this.roadNetwork.addSection(this.node2, this.node1, this.section1.
									reverse());
		this.roadNetwork.addSection(this.node2, this.node0, this.section2.
									reverse());
		this.roadNetwork.addSection(this.node2, this.node1, this.section3.
									reverse());

		this.project = new Project();
		this.project.setName("TestSet01");
		this.project.setDescription("Simple test set to begin development");
		this.project.setRoadNetwork(roadNetwork);

		Vehicle vehicle2 = this.vehicle.clone();
		vehicle2.setName("Dummy02");
		this.project.addVehicle(this.vehicle);
		this.project.addVehicle(vehicle2);

		ContextController.setOpenProject(this.project);

		this.simulation = new Simulation();
		this.simulation.setName("TestSet02");
		this.simulation.
			setDescription("simulation test set to begin development");

		this.traffic1 = new Traffic();
		this.traffic1.setNodeStart(node0);
		this.traffic1.setNodeEnd(node2);
		this.traffic1.setVehicle(this.project.getVehicle("Dummy01"));
		this.traffic1.setArrivalRate(new Measure(10.0, "/m"));
		this.simulation.addTraffic(traffic1);

		this.traffic2 = new Traffic();
		this.traffic2.setNodeStart(node0);
		this.traffic2.setNodeEnd(node4);
		this.traffic2.setVehicle(this.project.getVehicle("Dummy01"));
		this.traffic2.setArrivalRate(new Measure(15.0, "/m"));
		this.simulation.addTraffic(traffic2);

		this.traffic3 = new Traffic();
		this.traffic3.setNodeStart(node0);
		this.traffic3.setNodeEnd(node4);
		this.traffic3.setVehicle(this.project.getVehicle("Dummy02"));
		this.traffic3.setArrivalRate(new Measure(30.0, "/m"));
		this.simulation.addTraffic(traffic3);

		this.traffic4 = new Traffic();
		this.traffic4.setNodeStart(node1);
		this.traffic4.setNodeEnd(node4);
		this.traffic4.setVehicle(this.project.getVehicle("Dummy01"));
		this.traffic4.setArrivalRate(new Measure(10.0, "/m"));
		this.simulation.addTraffic(traffic4);

		this.traffic5 = new Traffic();
		this.traffic5.setNodeStart(node1);
		this.traffic5.setNodeEnd(node4);
		this.traffic5.setVehicle(this.project.getVehicle("Dummy02"));
		this.traffic5.setArrivalRate(new Measure(30.0, "/m"));
		this.simulation.addTraffic(traffic5);

		this.traffic6 = new Traffic();
		this.traffic6.setNodeStart(node3);
		this.traffic6.setNodeEnd(node1);
		this.traffic6.setVehicle(this.project.getVehicle("Dummy01"));
		this.traffic6.setArrivalRate(new Measure(5.0, "/m"));
		this.simulation.addTraffic(traffic6);

		this.traffic7 = new Traffic();
		this.traffic7.setNodeStart(node3);
		this.traffic7.setNodeEnd(node1);
		this.traffic7.setVehicle(this.project.getVehicle("Dummy02"));
		this.traffic7.setArrivalRate(new Measure(25.0, "/m"));
		this.simulation.addTraffic(traffic7);

		this.traffic8 = new Traffic();
		this.traffic8.setNodeStart(node4);
		this.traffic8.setNodeEnd(node1);
		this.traffic8.setVehicle(this.project.getVehicle("Dummy02"));
		this.traffic8.setArrivalRate(new Measure(20.0, "/m"));
		this.simulation.addTraffic(traffic8);

		this.simulations = new ArrayList();
		this.simulations.add(this.simulation);
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
	 * Test of getExtension method, of class SimulationExportXML.
	 */
	@Test
	public void testGetExtension() {
		System.out.println("testGetExtension");
		assertEquals(this.simulationExportXML.getExtension(), "xml");
	}

	/**
	 * Test of getExtensionDescription method, of class SimulationExportXML.
	 */
	@Test
	public void testGetExtensionDescription() {
		System.out.println("testGetExtensionDescription");
		assertEquals(this.simulationExportXML.getExtensionDescription(), "XML Documents (*.xml)");
	}

	/**
	 * Test of getExtensionFilter method, of class SimulationExportXML.
	 */
	@Test
	public void testGetExtensionFilter() {
		System.out.println("testGetExtensionFilter");
		FileNameExtensionFilter result = this.simulationExportXML.
			getExtensionFilter();
		FileNameExtensionFilter expResult = new FileNameExtensionFilter("XML Documents (*.xml)", "xml");
		assertEquals(result.getDescription(), expResult.getDescription());
		assertArrayEquals(result.getExtensions(), expResult.getExtensions());
	}

	/**
	 * Test of export method, of class SimulationExportXML.
	 */
	@Test
	public void testExport() {
		System.out.println("testExport");
		String result = this.simulationExportXML.export(this.simulation).
			replaceAll("\\s+", "");
		assertEquals((result.length()>0),true);
	}

}
