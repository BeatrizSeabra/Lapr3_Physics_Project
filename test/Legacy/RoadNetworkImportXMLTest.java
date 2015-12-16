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
import Physics.Measure;
import System.Settings;
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
 * @author valhalla
 */
public class RoadNetworkImportXMLTest {

	private RoadNetworkImportXML roadNetworkImportXML;
	private String filePathRoadNetwork;
	private String dataXML;
	private List<RoadNetwork> roadNetworks;
	private RoadNetwork roadNetwork;
	private Node node0;
	private Node node1;
	private Node node2;
	private Section section0;
	private Section section1;
	private Section section2;
	private Segment segment0;
	private Segment segment1;
	private Segment segment2;
	private Segment segment3;
	private Segment segment4;

	public RoadNetworkImportXMLTest() {
		Settings.setSettingsFilePath("test/Files/settingsTest.properties");
		this.roadNetworkImportXML = new RoadNetworkImportXML();
		this.filePathRoadNetwork = Settings.getOption("RoadNetworkFilePath");
		this.dataXML = Legacy.readFile(this.filePathRoadNetwork);

		this.segment0 = new Segment();
		this.segment0.setName("01");
		this.segment0.setHeight(100.0);
		this.segment0.setSlope(1.5);
		this.segment0.setLength(new Measure(3.2, "Km"));
		this.segment0.setMaxVelocity(new Measure(90.0, "Km/h"));
		this.segment0.setMinVelocity(new Measure(0.0, "Km/h"));
		this.segment0.setNumberVehicles(20.0);
		this.segment1 = new Segment();
		this.segment1.setName("02");
		this.segment1.setHeight(148.0);
		this.segment1.setSlope(-1.5);
		this.segment1.setLength(new Measure(3.2, "Km"));
		this.segment1.setMaxVelocity(new Measure(90.0, "Km/h"));
		this.segment1.setMinVelocity(new Measure(0.0, "Km/h"));
		this.segment1.setNumberVehicles(20.0);
		this.section0 = new Section();
		this.section0.setRoad("E01");
		this.section0.setTypology("regular road");
		this.section0.setDirection("bidirectional");
		this.section0.setToll(0.0);
		this.section0.setWindDirection(20.0);
		this.section0.setWindSpeed(new Measure(3.0, "m/s"));
		this.section0.addSegment(segment0);
		this.section0.addSegment(segment1);

		this.segment2 = new Segment();
		this.segment2.setName("01");
		this.segment2.setHeight(100.0);
		this.segment2.setSlope(0.0);
		this.segment2.setLength(new Measure(10.0, "Km"));
		this.segment2.setMaxVelocity(new Measure(90.0, "Km/h"));
		this.segment2.setMinVelocity(new Measure(0.0, "Km/h"));
		this.segment2.setNumberVehicles(30.0);
		this.segment3 = new Segment();
		this.segment3.setName("02");
		this.segment3.setHeight(100.0);
		this.segment3.setSlope(0.5);
		this.segment3.setLength(new Measure(5.0, "Km"));
		this.segment3.setMaxVelocity(new Measure(90.0, "Km/h"));
		this.segment3.setMinVelocity(new Measure(0.0, "Km/h"));
		this.segment3.setNumberVehicles(20.0);
		this.section1 = new Section();
		this.section1.setRoad("E01");
		this.section1.setTypology("regular road");
		this.section1.setDirection("bidirectional");
		this.section1.setToll(0.0);
		this.section1.setWindDirection(-5.0);
		this.section1.setWindSpeed(new Measure(3.0, "m/s"));
		this.section1.addSegment(segment2);
		this.section1.addSegment(segment3);

		this.segment4 = new Segment();
		this.segment4.setName("01");
		this.segment4.setHeight(100.0);
		this.segment4.setSlope(0.125);
		this.segment4.setLength(new Measure(20.0, "Km"));
		this.segment4.setMaxVelocity(new Measure(120.0, "Km/h"));
		this.segment4.setMinVelocity(new Measure(50.0, "Km/h"));
		this.segment4.setNumberVehicles(100.0);
		this.section2 = new Section();
		this.section2.setRoad("E01");
		this.section2.setTypology("regular road");
		this.section2.setDirection("bidirectional");
		this.section2.setToll(12.0);
		this.section2.setWindDirection(-5.0);
		this.section2.setWindSpeed(new Measure(3.0, "m/s"));
		this.section2.addSegment(segment4);

		this.node0 = new Node("n0");
		this.node1 = new Node("n1");
		this.node2 = new Node("n2");

		this.roadNetwork = new RoadNetwork();
		this.roadNetwork.addNode(this.node0);
		this.roadNetwork.addNode(this.node1);
		this.roadNetwork.addNode(this.node2);
		this.roadNetwork.addSection(this.node0, this.node1, this.section0);
		this.roadNetwork.addSection(this.node1, this.node2, this.section1);
		this.roadNetwork.addSection(this.node0, this.node2, this.section2);

		this.roadNetworks = new ArrayList();
		this.roadNetworks.add(this.roadNetwork);
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
	 * Test of getExtension method, of class RoadNetworkImportXML.
	 */
	@Test
	public void testGetExtension() {
		System.out.println("testGetExtension");
		assertEquals(this.roadNetworkImportXML.getExtension(), "xml");
	}

	/**
	 * Test of importData method, of class RoadNetworkImportXML.
	 */
	@Test
	public void testImportData() {
		System.out.println("testImportData");
		List<RoadNetwork> expResult = this.roadNetworks;
		List<RoadNetwork> result = this.roadNetworkImportXML.
			importData(this.dataXML);
		assertEquals(expResult, result);
	}

}
