/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simulation;

import Legacy.RoadNetworkImportXML;
import Model.Node;
import Model.RoadNetwork;
import Model.Section;
import Model.Segment;
import Physics.Measure;
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
public class CheapestPathAnalysisTest {

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

	public CheapestPathAnalysisTest() {

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
		this.segment4.setSlope(new Measure(0.125, "%"));
		this.segment4.setLength(new Measure(20.0, "km"));
		this.segment4.setMaxVelocity(new Measure(120.0, "km/h"));
		this.segment4.setMinVelocity(new Measure(50.0, "km/h"));
		this.segment4.setNumberVehicles(100);
		this.section2 = new Section();
		this.section2.setRoad("E01");
		this.section2.setTypology("regular road");
		this.section2.setDirection("bidirectional");
		this.section2.setToll(new Measure(12.0, "€"));
		this.section2.setWindDirection(new Measure(-5.0, "°"));
		this.section2.setWindSpeed(new Measure(3.0, "m/s"));
		this.section2.addSegment(this.segment4);

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
	 * Test of getName method, of class CheapestPathAnalysis.
	 */
	@Test
	public void testGetName() {
		System.out.println("getName");
		CheapestPathAnalysis instance = new CheapestPathAnalysis();
		String expResult = "Cheapest Path Analysis";
		String result = instance.getName();
		assertEquals(expResult, result);

	}

	/**
	 * Test of analyze method, of class CheapestPathAnalysis.
	 */
	@Test
	public void testAnalyze() {
		System.out.println("testanalyze");

		System.out.println("testAnalyze");

		CheapestPathAnalysis instance = new CheapestPathAnalysis();
		List<String[]> data = new CheapestPathAnalysis().
			analyze(this.roadNetwork, this.node0, this.node2);

		List result = instance.analyze(this.roadNetwork, this.node0, this.node2);
		StringBuilder stringBuilder = new StringBuilder();
		for (String[] line : data) {
			for (String column : line) {
				stringBuilder.append(column);
			}
		}
		String expResult = "NameCostTotalNoden00,00 €SectionE010,00 €0,00 €Noden10,00 €SectionE010,00 €0,00 €Noden20,00 €";

		assertEquals(expResult, stringBuilder.toString());

	}

}
