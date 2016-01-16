/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Physics.Measure;
import Simulation.AnalysisMethod;
import Simulation.FastestPathAnalysis;
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
public class SimulationTest {

	private Simulation simulation;
	private Run run;

	public SimulationTest() {
		this.simulation = new Simulation();
		this.simulation.setId(1);
		this.simulation.setDescription("test");
		this.simulation.setName("test2");
		this.run = new Run();

		this.simulation.addRun(run);
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
	 * Test of getId method, of class Simulation.
	 */
	@Test
	public void testSetGetId() {
		System.out.println("testSetGetId");

		Integer expResult = 2;
		this.simulation.setId(expResult);

		Integer result = this.simulation.getId();
		assertEquals(expResult, result);

	}

	/**
	 * Test of getName method, of class Simulation.
	 */
	@Test
	public void testSetGetName() {
		System.out.println("testSetGetName");

		String expResult = "test4";
		this.simulation.setName(expResult);
		String result = this.simulation.getName();
		assertEquals(expResult, result);

	}

	/**
	 * Test of getDescription method, of class Simulation.
	 */
	@Test
	public void testSetGetDescription() {
		System.out.println("SetGetDescription");

		String expResult = "test5";
		this.simulation.setDescription(expResult);
		String result = this.simulation.getDescription();
		assertEquals(expResult, result);

	}

	/**
	 * Test of equals method, of class Simulation.
	 */
	@Test
	public void testEquals() {
		System.out.println("equals");

		this.simulation.setDescription("test");
		this.simulation.setName("test2");
		this.simulation.setId(1);
		assertEquals(true, this.simulation.equals(simulation));

	}

	/**
	 * Test of hashCode method, of class Simulation.
	 */
	@Test
	public void testHashCode() {
		System.out.println("hashCode");
		Integer expResult = 29 * this.simulation.getClass().hashCode();
		expResult += 11 * this.simulation.getDescription().hashCode();
		expResult += 11 * this.simulation.getName().hashCode();
		expResult += 11 * this.simulation.getId().hashCode();

		Integer result = this.simulation.hashCode();
		assertEquals(expResult, result);
	}

	/**
	 * Test of clone method, of class Simulation.
	 */
	@Test
	public void testClone() {
		System.out.println("clone");
		Simulation instance = new Simulation();
		instance.setDescription("test");
		instance.setId(1);
		instance.setName("test2");
		Traffic traffic = new Traffic();
		Vehicle vec = new Vehicle();
		traffic.setId(1);
		vec.setId(1);
		vec.setName("Tommy");
		vec.setDescription("Audi");
		vec.setType("Sub");
		vec.setMotorization("VEC");
		vec.setFuel("Gasoline");
		Measure rmpLow = new Measure(1.2, "MeasureTorque");
		vec.setMass(rmpLow);
		vec.setLoad(rmpLow);
		vec.setDragCoefficient(rmpLow);
		vec.setFrontalArea(rmpLow);
		vec.setRollingRCoefficient(rmpLow);
		vec.setWheelSize(rmpLow);
		vec.setMinRPM(rmpLow);
		vec.setMaxRPM(rmpLow);
		vec.setFinalDriveRatio(rmpLow);
		traffic.setVehicle(vec);
		Node nodeEnd = new Node("Anta");
		Node nodeStart = new Node("Espinho");
		traffic.setNodeEnd(nodeEnd);
		traffic.setNodeStart(nodeStart);
		traffic.setArrivalRate(rmpLow);
		instance.addTraffic(traffic);
		Run runs = new Run();
		runs.setId(1);
		runs.setName("Simulation");
		Measure measure = new Measure(22.2, "km");
		runs.setTime(measure);
		runs.setTimeStep(measure);
		ArrayList<Step> steps = new ArrayList<>();
		List<Drop> drops = new ArrayList<>();
		Drop drop = new Drop();
		AnalysisMethod analy = new FastestPathAnalysis();
		runs.setMethod(analy);
		Vehicle vehicle = new Vehicle();
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
		vehicle.setId(1);
		vehicle.setName("Nissan Skyline 2001");
		vehicle.setDescription("2001 Nissan Skyline GT-R R34 V-spec II N1");
		vehicle.setType("car");
		vehicle.setMotorization("combustion");
		vehicle.setFuel("gasoline");
		vehicle.setMass(new Measure(1550.0, "kg"));
		vehicle.setLoad(new Measure(0.0, "kg"));
		vehicle.setDragCoefficient(new Measure(0.34, "ratio"));
		vehicle.setFrontalArea(new Measure(1.8, "m2"));
		vehicle.setRollingRCoefficient(new Measure(0.01, "ratio"));
		vehicle.setWheelSize(new Measure(0.3266, "m"));
		vehicle.setMinRPM(new Measure(8500.0, "rpm"));
		vehicle.setMaxRPM(new Measure(1000.0, "rpm"));
		vehicle.setFinalDriveRatio(new Measure(3.545, "ratio"));
		vehicle.setEnergyRegeneration(new Measure(22.0, "rpm"));
		vehicle.setGear(1, new Measure(3.827, "ratio"));
		vehicle.setGear(2, new Measure(2.36, "ratio"));
		vehicle.setGear(3, new Measure(1.685, "ratio"));
		vehicle.setGear(4, new Measure(1.312, "ratio"));
		vehicle.setGear(5, new Measure(1.0, "ratio"));
		vehicle.setGear(6, new Measure(0.793, "ratio"));
		vehicle.addThrottle(throttle1);
		vehicle.addThrottle(throttle2);
		vehicle.addThrottle(throttle3);
		vehicle.setVelocityLimits("road", new Measure(60.0, "km/h"));
		Step instancestep = new Step();
		instancestep.setAirForce(measure);
		instancestep.setCarForce(measure);
		instancestep.setCarPower(measure);
		instancestep.setCarSpeed(measure);
		instancestep.setGravityForce(measure);
		instancestep.setNodeEnd("n0");
		instancestep.setNodeStart("n1");
		instancestep.setRoad("highway");
		instancestep.setRollingForce(measure);
		instancestep.setSegment("n1");
		instancestep.setSpeedRelative(measure);
		instancestep.setTimeOut(measure);
		instancestep.setVehicle("Dummy");
		instancestep.setTimeEntry(measure);
		instancestep.setTimeOut(measure);
		drop.setNodeEnd("n1");
		drop.setNodeStart("n2");
		drop.setTime(measure);
		drop.setVehicle("Dummy");
		drops.add(drop);
		steps.add(instancestep);
		runs.setDrops(drops);
		runs.setSteps(steps);
		instance.addRun(runs);
		Simulation result = instance.clone();
		assertEquals(this.simulation, result);

	}

	/**
	 * Test of toString method, of class Simulation.
	 */
	@Test
	public void testToString() {
		System.out.println("testToString");
		String expResult = "Simulation - test2 - test\n";
		String result = this.simulation.toString();
		assertEquals(expResult, result);

	}

	/**
	 * Test of equals method, of class Section.
	 */
	@Test
	public void testEqualsFalseNull() {
		System.out.println("testEqualsFalseNull");
		Boolean result = this.simulation.equals(null);
		Boolean expResult = false;
		assertEquals(expResult, result);
	}

	/**
	 * Test of equals method, of class Section.
	 */
	@Test
	public void testEqualsFalseClass() {
		System.out.println("testEqualsFalseClass");
		Boolean result = this.simulation.equals(new String());
		Boolean expResult = false;
		assertEquals(expResult, result);
	}

	/**
	 * Test of addTraffic method, of class Simulation.
	 */
	@Test
	public void testAddTraffic() {
		System.out.println("addTraffic");
		Traffic traffic = new Traffic();
		Simulation instance = new Simulation();
		Boolean expResult = true;
		Boolean result = instance.addTraffic(traffic);
		assertEquals(expResult, result);
	}

	/**
	 * Test of getTraffic method, of class Simulation.
	 */
	@Test
	public void testGetTraffic() {
		System.out.println("getTraffic");
		int index = 0;
		Simulation instance = new Simulation();
		Traffic obj = new Traffic();
		Vehicle vec = new Vehicle();
		ArrayList<Traffic> traf = new ArrayList<>();
		obj.setId(0);
		vec.setId(1);
		vec.setName("Tommy");
		vec.setDescription("Audi");
		vec.setType("Sub");
		vec.setMotorization("VEC");
		vec.setFuel("Gasoline");
		Measure rmpLow = new Measure(1.2, "MeasureTorque");
		vec.setMass(rmpLow);
		vec.setLoad(rmpLow);
		vec.setDragCoefficient(rmpLow);
		vec.setFrontalArea(rmpLow);
		vec.setRollingRCoefficient(rmpLow);
		vec.setWheelSize(rmpLow);
		vec.setMinRPM(rmpLow);
		vec.setMaxRPM(rmpLow);
		vec.setFinalDriveRatio(rmpLow);
		obj.setVehicle(vec);
		Node nodeEnd = new Node("Anta");
		nodeEnd.setId(0);
		nodeEnd.setName("Anta");
		Node nodeStart = new Node("Espinho");
		nodeStart.setId(1);
		nodeEnd.setName("Espinho");
		obj.setNodeEnd(nodeEnd);
		obj.setNodeStart(nodeStart);
		obj.setArrivalRate(rmpLow);
		instance.addTraffic(obj);
		traf.add(obj);
		Traffic expResult = traf.get(0);
		Traffic result = instance.getTraffic(index);
		assertEquals(expResult, result);
	}

	/**
	 * Test of getId method, of class Simulation.
	 */
	@Test
	public void testGetId() {
		System.out.println("getId");
		Simulation instance = new Simulation();
		instance.setId(1);
		Integer expResult = 1;
		Integer result = instance.getId();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setId method, of class Simulation.
	 */
	@Test
	public void testSetId() {
		System.out.println("setId");
		Integer id = null;
		Simulation instance = new Simulation();
		instance.setId(id);
	}

	/**
	 * Test of getName method, of class Simulation.
	 */
	@Test
	public void testGetName() {
		System.out.println("getName");
		Simulation instance = new Simulation();
		String expResult = "";
		String result = instance.getName();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setName method, of class Simulation.
	 */
	@Test
	public void testSetName() {
		System.out.println("setName");
		String name = "";
		Simulation instance = new Simulation();
		instance.setName(name);
	}

	/**
	 * Test of getDescription method, of class Simulation.
	 */
	@Test
	public void testGetDescription() {
		System.out.println("getDescription");
		this.simulation.setDescription("Descript");
		String expResult = "Descript";
		String result = this.simulation.getDescription();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setDescription method, of class Simulation.
	 */
	@Test
	public void testSetDescription() {
		System.out.println("setDescription");
		String description = "Descript";
		this.simulation.setDescription(description);
		assertEquals(description, this.simulation.getDescription());
	}

	/**
	 * Test of addRun method, of class Simulation.
	 */
	@Test
	public void testAddRun() {
		System.out.println("addRun");
		Run run = new Run();
		Simulation instance = new Simulation();
		Boolean expResult = true;
		Boolean result = instance.addRun(run);
		assertEquals(expResult, result);
	}

	/**
	 * Test of getRun method, of class Simulation.
	 */
	@Test
	public void testGetRun() {
		System.out.println("getRun");
		int index = 0;
		Simulation instance = new Simulation();
		Run runs = new Run();
		runs.setId(1);
		runs.setName("Simulation");
		Measure measure = new Measure(22.2, "km");
		runs.setTime(measure);
		runs.setTimeStep(measure);
		ArrayList<Step> steps = new ArrayList<>();
		List<Drop> drops = new ArrayList<>();
		Drop drop = new Drop();
		AnalysisMethod analy = new FastestPathAnalysis();
		runs.setMethod(analy);
		Vehicle vehicle = new Vehicle();
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
		vehicle.setId(1);
		vehicle.setName("Nissan Skyline 2001");
		vehicle.setDescription("2001 Nissan Skyline GT-R R34 V-spec II N1");
		vehicle.setType("car");
		vehicle.setMotorization("combustion");
		vehicle.setFuel("gasoline");
		vehicle.setMass(new Measure(1550.0, "kg"));
		vehicle.setLoad(new Measure(0.0, "kg"));
		vehicle.setDragCoefficient(new Measure(0.34, "ratio"));
		vehicle.setFrontalArea(new Measure(1.8, "m2"));
		vehicle.setRollingRCoefficient(new Measure(0.01, "ratio"));
		vehicle.setWheelSize(new Measure(0.3266, "m"));
		vehicle.setMinRPM(new Measure(8500.0, "rpm"));
		vehicle.setMaxRPM(new Measure(1000.0, "rpm"));
		vehicle.setFinalDriveRatio(new Measure(3.545, "ratio"));
		vehicle.setEnergyRegeneration(new Measure(22.0, "rpm"));
		vehicle.setGear(1, new Measure(3.827, "ratio"));
		vehicle.setGear(2, new Measure(2.36, "ratio"));
		vehicle.setGear(3, new Measure(1.685, "ratio"));
		vehicle.setGear(4, new Measure(1.312, "ratio"));
		vehicle.setGear(5, new Measure(1.0, "ratio"));
		vehicle.setGear(6, new Measure(0.793, "ratio"));
		vehicle.addThrottle(throttle1);
		vehicle.addThrottle(throttle2);
		vehicle.addThrottle(throttle3);
		vehicle.setVelocityLimits("road", new Measure(60.0, "km/h"));
		Step instancestep = new Step();
		instancestep.setAirForce(measure);
		instancestep.setCarForce(measure);
		instancestep.setCarPower(measure);
		instancestep.setCarSpeed(measure);
		instancestep.setGravityForce(measure);
		instancestep.setNodeEnd("n0");
		instancestep.setNodeStart("n1");
		instancestep.setRoad("highway");
		instancestep.setRollingForce(measure);
		instancestep.setSegment("n1");
		instancestep.setSpeedRelative(measure);
		instancestep.setTimeOut(measure);
		instancestep.setVehicle("Dummy");
		instancestep.setTimeEntry(measure);
		instancestep.setTimeOut(measure);
		drop.setNodeEnd("n1");
		drop.setNodeStart("n2");
		drop.setTime(measure);
		drop.setVehicle("Dummy");
		drops.add(drop);
		steps.add(instancestep);
		runs.setDrops(drops);
		runs.setSteps(steps);
		instance.addRun(runs);
		Run result = instance.getRun(index);
		assertEquals(runs, result);
	}

	/**
	 * Test of getTraffics method, of class Simulation.
	 */
	@Test
	public void testGetTraffics() {
		System.out.println("getTraffics");
		Simulation instance = new Simulation();
		Traffic obj = new Traffic();
		Vehicle vec = new Vehicle();
		ArrayList<Traffic> traf = new ArrayList<>();
		obj.setId(0);
		vec.setId(1);
		vec.setName("Tommy");
		vec.setDescription("Audi");
		vec.setType("Sub");
		vec.setMotorization("VEC");
		vec.setFuel("Gasoline");
		Measure rmpLow = new Measure(1.2, "MeasureTorque");
		vec.setMass(rmpLow);
		vec.setLoad(rmpLow);
		vec.setDragCoefficient(rmpLow);
		vec.setFrontalArea(rmpLow);
		vec.setRollingRCoefficient(rmpLow);
		vec.setWheelSize(rmpLow);
		vec.setMinRPM(rmpLow);
		vec.setMaxRPM(rmpLow);
		vec.setFinalDriveRatio(rmpLow);
		obj.setVehicle(vec);
		Node nodeEnd = new Node("Anta");
		nodeEnd.setId(0);
		nodeEnd.setName("Anta");
		Node nodeStart = new Node("Espinho");
		nodeStart.setId(1);
		nodeEnd.setName("Espinho");
		obj.setNodeEnd(nodeEnd);
		obj.setNodeStart(nodeStart);
		obj.setArrivalRate(rmpLow);
		instance.addTraffic(obj);
		traf.add(obj);
		List<Traffic> expResult = traf;
		List<Traffic> result = instance.getTraffics();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getRuns method, of class Simulation.
	 */
	@Test
	public void testGetRuns() {
		System.out.println("getRuns");
		Simulation instance = new Simulation();
		Run runs = new Run();
		runs.setId(1);
		runs.setName("Simulation");
		Measure measure = new Measure(22.2, "km");
		runs.setTime(measure);
		runs.setTimeStep(measure);
		ArrayList<Step> steps = new ArrayList<>();
		List<Drop> drops = new ArrayList<>();
		Drop drop = new Drop();
		AnalysisMethod analy = new FastestPathAnalysis();
		runs.setMethod(analy);
		Vehicle vehicle = new Vehicle();
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
		vehicle.setId(1);
		vehicle.setName("Nissan Skyline 2001");
		vehicle.setDescription("2001 Nissan Skyline GT-R R34 V-spec II N1");
		vehicle.setType("car");
		vehicle.setMotorization("combustion");
		vehicle.setFuel("gasoline");
		vehicle.setMass(new Measure(1550.0, "kg"));
		vehicle.setLoad(new Measure(0.0, "kg"));
		vehicle.setDragCoefficient(new Measure(0.34, "ratio"));
		vehicle.setFrontalArea(new Measure(1.8, "m2"));
		vehicle.setRollingRCoefficient(new Measure(0.01, "ratio"));
		vehicle.setWheelSize(new Measure(0.3266, "m"));
		vehicle.setMinRPM(new Measure(8500.0, "rpm"));
		vehicle.setMaxRPM(new Measure(1000.0, "rpm"));
		vehicle.setFinalDriveRatio(new Measure(3.545, "ratio"));
		vehicle.setEnergyRegeneration(new Measure(22.0, "rpm"));
		vehicle.setGear(1, new Measure(3.827, "ratio"));
		vehicle.setGear(2, new Measure(2.36, "ratio"));
		vehicle.setGear(3, new Measure(1.685, "ratio"));
		vehicle.setGear(4, new Measure(1.312, "ratio"));
		vehicle.setGear(5, new Measure(1.0, "ratio"));
		vehicle.setGear(6, new Measure(0.793, "ratio"));
		vehicle.addThrottle(throttle1);
		vehicle.addThrottle(throttle2);
		vehicle.addThrottle(throttle3);
		vehicle.setVelocityLimits("road", new Measure(60.0, "km/h"));
		Step instancestep = new Step();
		instancestep.setAirForce(measure);
		instancestep.setCarForce(measure);
		instancestep.setCarPower(measure);
		instancestep.setCarSpeed(measure);
		instancestep.setGravityForce(measure);
		instancestep.setNodeEnd("n0");
		instancestep.setNodeStart("n1");
		instancestep.setRoad("highway");
		instancestep.setRollingForce(measure);
		instancestep.setSegment("n1");
		instancestep.setSpeedRelative(measure);
		instancestep.setTimeOut(measure);
		instancestep.setVehicle("Dummy");
		instancestep.setTimeEntry(measure);
		instancestep.setTimeOut(measure);
		drop.setNodeEnd("n1");
		drop.setNodeStart("n2");
		drop.setTime(measure);
		drop.setVehicle("Dummy");
		drops.add(drop);
		steps.add(instancestep);
		runs.setDrops(drops);
		runs.setSteps(steps);
		instance.addRun(runs);
		List<Run> expResult = new ArrayList<>();
		expResult.add(runs);
		List<Run> result = instance.getRuns();
		assertEquals(expResult, result);
	}

	/**
	 * Test of removeRun method, of class Simulation.
	 */
	@Test
	public void testRemoveRun() {
		System.out.println("removeRun");
		Simulation instance = new Simulation();
		Run runs = new Run();
		runs.setId(1);
		runs.setName("Simulation");
		Measure measure = new Measure(22.2, "km");
		runs.setTime(measure);
		runs.setTimeStep(measure);
		ArrayList<Step> steps = new ArrayList<>();
		List<Drop> drops = new ArrayList<>();
		Drop drop = new Drop();
		AnalysisMethod analy = new FastestPathAnalysis();
		runs.setMethod(analy);
		Vehicle vehicle = new Vehicle();
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
		vehicle.setId(1);
		vehicle.setName("Nissan Skyline 2001");
		vehicle.setDescription("2001 Nissan Skyline GT-R R34 V-spec II N1");
		vehicle.setType("car");
		vehicle.setMotorization("combustion");
		vehicle.setFuel("gasoline");
		vehicle.setMass(new Measure(1550.0, "kg"));
		vehicle.setLoad(new Measure(0.0, "kg"));
		vehicle.setDragCoefficient(new Measure(0.34, "ratio"));
		vehicle.setFrontalArea(new Measure(1.8, "m2"));
		vehicle.setRollingRCoefficient(new Measure(0.01, "ratio"));
		vehicle.setWheelSize(new Measure(0.3266, "m"));
		vehicle.setMinRPM(new Measure(8500.0, "rpm"));
		vehicle.setMaxRPM(new Measure(1000.0, "rpm"));
		vehicle.setFinalDriveRatio(new Measure(3.545, "ratio"));
		vehicle.setEnergyRegeneration(new Measure(22.0, "rpm"));
		vehicle.setGear(1, new Measure(3.827, "ratio"));
		vehicle.setGear(2, new Measure(2.36, "ratio"));
		vehicle.setGear(3, new Measure(1.685, "ratio"));
		vehicle.setGear(4, new Measure(1.312, "ratio"));
		vehicle.setGear(5, new Measure(1.0, "ratio"));
		vehicle.setGear(6, new Measure(0.793, "ratio"));
		vehicle.addThrottle(throttle1);
		vehicle.addThrottle(throttle2);
		vehicle.addThrottle(throttle3);
		vehicle.setVelocityLimits("road", new Measure(60.0, "km/h"));
		Step instancestep = new Step();
		instancestep.setAirForce(measure);
		instancestep.setCarForce(measure);
		instancestep.setCarPower(measure);
		instancestep.setCarSpeed(measure);
		instancestep.setGravityForce(measure);
		instancestep.setNodeEnd("n0");
		instancestep.setNodeStart("n1");
		instancestep.setRoad("highway");
		instancestep.setRollingForce(measure);
		instancestep.setSegment("n1");
		instancestep.setSpeedRelative(measure);
		instancestep.setTimeOut(measure);
		instancestep.setVehicle("Dummy");
		instancestep.setTimeEntry(measure);
		instancestep.setTimeOut(measure);
		drop.setNodeEnd("n1");
		drop.setNodeStart("n2");
		drop.setTime(measure);
		drop.setVehicle("Dummy");
		drops.add(drop);
		steps.add(instancestep);
		runs.setDrops(drops);
		runs.setSteps(steps);
		instance.addRun(runs);
		Boolean expResult = true;
		Boolean result = instance.removeRun(runs);
		assertEquals(expResult, result);
	}

}
