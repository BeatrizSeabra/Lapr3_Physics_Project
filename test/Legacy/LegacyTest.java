/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Legacy;

import Model.Node;
import Model.Project;
import Model.Regime;
import Model.RoadNetwork;
import Model.Section;
import Model.Segment;
import Model.Throttle;
import Model.Vehicle;
import Physics.Measure;
import System.Settings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
public class LegacyTest {

	private String scalesMeasuresFilePath;
	private String writeReadFilePath;
	private String filePathRoadNetwork;
	private String filePathVehicles;

	private List<Project> projects;
	private Project project;
	private RoadNetwork roadNetwork;
	private Node node0;
	private Node node1;
	private Section section;
	private Segment segment;

	private List<Vehicle> vehicles;
	private Vehicle vehicle;

	public LegacyTest() {
		Settings.setSettingsFilePath("test/Files/settingsTest.properties");
		this.scalesMeasuresFilePath = Settings.
			getOption("ScalesMeasuresFilePath");
		this.writeReadFilePath = Settings.getOption("WriteReadFilePath");
		this.filePathRoadNetwork = Settings.
			getOption("RoadNetworkFilePathSimple");
		this.filePathVehicles = Settings.getOption("VehiclesFilePath");

		this.segment = new Segment();
		this.segment.setName("01");
		this.segment.setHeight(new Measure(100.0, "km"));
		this.segment.setSlope(new Measure(1.5, "%"));
		this.segment.setLength(new Measure(3.2, "km"));
		this.segment.setMaxVelocity(new Measure(90.0, "km/h"));
		this.segment.setMinVelocity(new Measure(0.0, "km/h"));
		this.segment.setNumberVehicles(20);
		this.section = new Section();
		this.section.setRoad("E01");
		this.section.setTypology("regular road");
		this.section.setDirection("bidirectional");
		this.section.setToll(new Measure(0.0, "€"));
		this.section.setWindDirection(new Measure(20.0, "°"));
		this.section.setWindSpeed(new Measure(3.0, "m/s"));
		this.section.addSegment(segment);

		this.node0 = new Node("n0");
		this.node1 = new Node("n1");

		this.roadNetwork = new RoadNetwork();
		this.roadNetwork.addNode(this.node0);
		this.roadNetwork.addNode(this.node1);
		this.roadNetwork.addSection(this.node0, this.node1, this.section);
		this.roadNetwork.addSection(this.node1, this.node0, this.section.
									reverse());

		this.project = new Project();
		this.project.setName("TestSet01");
		this.project.setDescription("Simple test set to begin development");
		this.project.setRoadNetwork(roadNetwork);

		this.projects = new ArrayList();
		this.projects.add(this.project);

		Throttle throttle1 = new Throttle();
		throttle1.
			addRegime(new Regime(new Measure(85.0, "Nm"), new Measure(1000.0, "rpm"), new Measure(2499.0, "rpm"), new Measure(8.2, "km/l")));
		throttle1.
			addRegime(new Regime(new Measure(95.0, "Nm"), new Measure(2500.0, "rpm"), new Measure(3999.0, "rpm"), new Measure(6.2, "km/l")));
		throttle1.
			addRegime(new Regime(new Measure(80.0, "Nm"), new Measure(4000.0, "rpm"), new Measure(5500.0, "rpm"), new Measure(10.2, "km/l")));
		Throttle throttle2 = new Throttle();
		throttle2.
			addRegime(new Regime(new Measure(135.0, "Nm"), new Measure(1000.0, "rpm"), new Measure(2499.0, "rpm"), new Measure(5.2, "km/l")));
		throttle2.
			addRegime(new Regime(new Measure(150.0, "Nm"), new Measure(2500.0, "rpm"), new Measure(3999.0, "rpm"), new Measure(3.2, "km/l")));
		throttle2.
			addRegime(new Regime(new Measure(140.0, "Nm"), new Measure(4000.0, "rpm"), new Measure(5500.0, "rpm"), new Measure(8.2, "km/l")));
		Throttle throttle3 = new Throttle();
		throttle2.
			addRegime(new Regime(new Measure(200.0, "Nm"), new Measure(1000.0, "rpm"), new Measure(2499.0, "rpm"), new Measure(2.2, "km/l")));
		throttle2.
			addRegime(new Regime(new Measure(240.0, "Nm"), new Measure(2500.0, "rpm"), new Measure(3999.0, "rpm"), new Measure(1.2, "km/l")));
		throttle2.
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
		this.vehicle.setThrottle(25, throttle1);
		this.vehicle.setThrottle(50, throttle2);
		this.vehicle.setThrottle(100, throttle3);

		this.vehicles = new ArrayList();
		this.vehicles.add(vehicle);
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
	 * Test of writeFile and readFile method, of class Legacy.
	 */
	@Test
	public void testWriteReadFile() {
		System.out.println("testWriteReadFile");
		String expResult = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";
		Legacy.writeFile(this.writeReadFilePath, expResult, false);
		String result = Legacy.readFile(this.writeReadFilePath);
		assertEquals(expResult, result);
	}

	/**
	 * Test of importScalesMeasures method, of class Legacy.
	 */
	@Test
	public void testImportScalesMeasures() {
		System.out.println("testImportScalesMeasures");
		Map<String, Double> expResult = new HashMap();
		expResult.put("hmin", 60.0);
		expResult.put("hs", 3600.0);
		expResult.put("kmm", 1000.0);
		expResult.put("kmcm", 100000.0);
		expResult.put("kgg", 1000.0);
		expResult.put("kgmg", 1000000.0);
		Map<String, Double> result = Legacy.
			importScalesMeasures(this.scalesMeasuresFilePath);
		assertEquals(expResult, result);
	}

	/**
	 * Test of importRoadNetwork method, of class Legacy.
	 */
	@Test
	public void testImportRoadNetwork() {
		System.out.println("testImportRoadNetwork");
		List<Project> expResult = this.projects;
		List<Project> result = Legacy.
			importRoadNetwork(this.filePathRoadNetwork);
		assertEquals(expResult, result);
	}

	/**
	 * Test of importVehicles method, of class Legacy.
	 */
	@Test
	public void testImportVehicles() {
		System.out.println("testImportVehicles");
		List<Vehicle> expResult = new ArrayList();
		expResult.add(this.vehicle);
		List<Vehicle> result = Legacy.importVehicles(this.filePathVehicles);
		assertEquals(expResult, result);
	}

}
