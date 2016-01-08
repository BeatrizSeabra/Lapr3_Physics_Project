/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Legacy;

import Model.Node;
import Model.Project;
import Model.RoadNetwork;
import Model.Section;
import Model.Segment;
import Physics.Measure;
import System.Settings;
import java.util.ArrayList;
import java.util.List;
import javax.swing.filechooser.FileNameExtensionFilter;
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
public class RoadNetworkExportXMLTest {

	private RoadNetworkExportXML roadNetworkExportXML;
	private String filePathRoadNetwork;
	private String dataXML;
	private List<Project> projects;
	private Project project;
	private RoadNetwork roadNetwork;
	private Node node0;
	private Node node1;
	private Node node2;
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

	public RoadNetworkExportXMLTest() {
		Settings.setSettingsFilePath("test/Files/settingsTest.properties");
		this.roadNetworkExportXML = new RoadNetworkExportXML();
		this.filePathRoadNetwork = Settings.getOption("RoadNetworkFilePath");
		this.dataXML = Legacy.readFile(this.filePathRoadNetwork);

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

		this.roadNetwork = new RoadNetwork();
		this.roadNetwork.addNode(this.node0);
		this.roadNetwork.addNode(this.node1);
		this.roadNetwork.addNode(this.node2);
		this.roadNetwork.addSection(this.node0, this.node1, this.section0);
		this.roadNetwork.addSection(this.node1, this.node2, this.section1);
		this.roadNetwork.addSection(this.node0, this.node2, this.section2);
		this.roadNetwork.addSection(this.node1, this.node2, this.section3);

		this.project = new Project();
		this.project.setName("TestSet01");
		this.project.setDescription("Simple test set to begin development");
		this.project.setRoadNetwork(roadNetwork);

		this.projects = new ArrayList();
		this.projects.add(this.project);
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
	 * Test of getExtension method, of class RoadNetworkExportXML.
	 */
	@Test
	public void testGetExtension() {
		System.out.println("testGetExtension");
		assertEquals(this.roadNetworkExportXML.getExtension(), "xml");
	}

	/**
	 * Test of getExtensionDescription method, of class RoadNetworkExportXML.
	 */
	@Test
	public void testGetExtensionDescription() {
		System.out.println("testGetExtensionDescription");
		assertEquals(this.roadNetworkExportXML.getExtensionDescription(), "XML Documents (*.xml)");
	}

	/**
	 * Test of getExtensionFilter method, of class RoadNetworkExportXML.
	 */
	@Test
	public void testGetExtensionFilter() {
		System.out.println("testGetExtensionFilter");
		FileNameExtensionFilter result = this.roadNetworkExportXML.
			getExtensionFilter();
		FileNameExtensionFilter expResult = new FileNameExtensionFilter("xml", "XML Documents (*.xml)");

	}

	/**
	 * Test of export method, of class RoadNetworkExportXML.
	 */
	@Test
	public void testExport() {
		System.out.println("testExport");
		String result = this.roadNetworkExportXML.export(this.project).
			replaceAll("\\s+", "");
		String expResult = dataXML.replaceAll("\\s+", "");
		System.out.println(result);
		System.out.println(expResult);
		assertEquals(result, expResult);
	}

}
