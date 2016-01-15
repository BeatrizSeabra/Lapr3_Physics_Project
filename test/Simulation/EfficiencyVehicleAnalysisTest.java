/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simulation;

import Model.Node;
import Model.Regime;
import Model.RoadNetwork;
import Model.Section;
import Model.Segment;
import Model.Throttle;
import Model.Vehicle;
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
public class EfficiencyVehicleAnalysisTest {

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
	private Vehicle vehicle;

	public EfficiencyVehicleAnalysisTest() {

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
		this.roadNetwork.addSection(this.node1, this.node0, this.section0.
									reverse());
		this.roadNetwork.addSection(this.node2, this.node1, this.section1.
									reverse());
		this.roadNetwork.addSection(this.node2, this.node0, this.section2.
									reverse());
		this.roadNetwork.addSection(this.node2, this.node1, this.section3.
									reverse());

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
	 * Test of getName method, of class EfficiencyVehicleAnalysis.
	 */
	@Test
	public void testGetName() {
		System.out.println("getName");
		EfficiencyVehicleAnalysis instance = new EfficiencyVehicleAnalysis();
		String expResult = "Efficiency Vehicle Analysis";
		String result = instance.getName();
		assertEquals(expResult, result);

	}

	/**
	 * Test of analyze method, of class EfficiencyVehicleAnalysis.
	 */
	@Test
	public void testAnalyze() {
		System.out.println("analyze");

		List<String[]> data = new EfficiencyVehicleAnalysis().
			analyze(this.vehicle, this.roadNetwork, this.node0, this.node2);
		StringBuilder stringBuilder = new StringBuilder();
		for (String[] line : data) {
			for (String column : line) {
				stringBuilder.append(column);
			}
		}
		String expResult = "NameLengthTotalNoden00,00 kmSegment0120,00 km0,00 kmNoden220,00 km";
		System.out.println(stringBuilder.toString());
		assertEquals(expResult, stringBuilder.toString());
	}
}
