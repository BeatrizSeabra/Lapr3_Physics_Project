/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Legacy;

import Model.Node;
import Model.RoadNetwork;
import Model.Section;
import Model.Segment;
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
 * @author valhalla
 */
public class LegacyTest {

	private String scalesMeasuresFilePath;
	private String writeReadFilePath;
	private String filePathRoadNetwork;
	private String filePathVehicles;

	private List<RoadNetwork> roadNetworks;
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
		this.segment.setHeight(100.0);
		this.segment.setSlope(1.5);
		this.segment.setLength(new Measure(3.2, "Km"));
		this.segment.setMaxVelocity(new Measure(90.0, "Km/h"));
		this.segment.setMinVelocity(new Measure(0.0, "Km/h"));
		this.segment.setNumberVehicles(20.0);
		this.section = new Section();
		this.section.setRoad("E01");
		this.section.setTypology("regular road");
		this.section.setDirection("bidirectional");
		this.section.setToll(0.0);
		this.section.setWindDirection(20.0);
		this.section.setWindSpeed(new Measure(3.0, "m/s"));
		this.section.addSegment(segment);

		this.node0 = new Node("n0");
		this.node1 = new Node("n1");

		this.roadNetwork = new RoadNetwork();
		this.roadNetwork.addNode(this.node0);
		this.roadNetwork.addNode(this.node1);
		this.roadNetwork.addSection(this.node0, this.node1, this.section);

		this.roadNetworks = new ArrayList();
		this.roadNetworks.add(this.roadNetwork);

		this.vehicle = new Vehicle();
		this.vehicle.setId(1);
		this.vehicle.setName("Dummy01");
		this.vehicle.setDescription("Dummy teste vehicle");
		this.vehicle.setType("car");
		this.vehicle.setMotorization("combustion");
		this.vehicle.setFuel("gasoline");
		this.vehicle.setMass(new Measure(1400.0, "Kg"));
		this.vehicle.setLoad(new Measure(120.0, "kg"));
		this.vehicle.setDragCoefficient(0.35);
		this.vehicle.setRollingRcoefficient(0.01);
		this.vehicle.setWheelSize(0.5);
		this.vehicle.getVelocityLimits().put("Highway", 100.0);
		this.vehicle.setTorque(250.0);
		this.vehicle.setRPM(2500.0);
		this.vehicle.setComsumption(8.2);
		this.vehicle.setMinRPM(1000.0);
		this.vehicle.setMaxRPM(5500.0);
		this.vehicle.setFinalDriveRatio(2.6);
		this.vehicle.getGears().put(01, 3.5);
		this.vehicle.getGears().put(02, 2.5);
		this.vehicle.getGears().put(03, 1.25);
		this.vehicle.getGears().put(04, 0.9);
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
		List<RoadNetwork> expResult = this.roadNetworks;
		List<RoadNetwork> result = Legacy.
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
