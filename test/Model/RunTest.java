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
 * @author Eduardo
 */
public class RunTest {

	public RunTest() {
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
	 * Test of getId method, of class Run.
	 */
	@Test
	public void testGetId() {
		System.out.println("getId");
		Run instance = new Run();
		Integer expResult = 1;
		instance.setId(expResult);
		Integer result = instance.getId();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setId method, of class Run.
	 */
	@Test
	public void testSetId() {
		System.out.println("setId");
		Integer id = 1;
		Run instance = new Run();
		instance.setId(id);
		assertEquals(id, instance.getId());
	}

	/**
	 * Test of getName method, of class Run.
	 */
	@Test
	public void testGetName() {
		System.out.println("getName");
		Run instance = new Run();
		String expResult = "Espinho";
		instance.setName(expResult);
		String result = instance.getName();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setName method, of class Run.
	 */
	@Test
	public void testSetName() {
		System.out.println("setName");
		String name = "Espinho";
		Run instance = new Run();
		instance.setName(name);
		String result = instance.getName();
		assertEquals(name, result);
	}

	/**
	 * Test of getTime method, of class Run.
	 */
	@Test
	public void testGetTime() {
		System.out.println("getTime");
		Run instance = new Run();
		Measure expResult = new Measure(22.0, "km");
		instance.setTime(expResult);
		Measure result = instance.getTime();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setTime method, of class Run.
	 */
	@Test
	public void testSetTime() {
		System.out.println("setTime");
		Measure time = new Measure(22.0, "km");
		Run instance = new Run();
		instance.setTime(time);
		assertEquals(time, instance.getTime());
	}

	/**
	 * Test of getTimeStep method, of class Run.
	 */
	@Test
	public void testGetTimeStep() {
		System.out.println("getTimeStep");
		Run instance = new Run();
		Measure expResult = new Measure(22.2, "km");
		instance.setTimeStep(expResult);
		Measure result = instance.getTimeStep();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setTimeStep method, of class Run.
	 */
	@Test
	public void testSetTimeStep() {
		System.out.println("setTimeStep");
		Measure timeStep = new Measure(22.2, "km");
		Run instance = new Run();
		instance.setTimeStep(timeStep);
		assertEquals(timeStep, instance.getTimeStep());
	}

	/**
	 * Test of getMethod method, of class Run.
	 */
	@Test
	public void testGetMethod() {
		System.out.println("getMethod");
		Run instance = new Run();
		AnalysisMethod expResult = new FastestPathAnalysis();
		instance.setMethod(expResult);
		AnalysisMethod result = instance.getMethod();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setMethod method, of class Run.
	 */
	@Test
	public void testSetMethod() {
		System.out.println("setMethod");
		AnalysisMethod method = new FastestPathAnalysis();
		Run instance = new Run();
		instance.setMethod(method);
		assertEquals(method, instance.getMethod());
	}

	/**
	 * Test of getSteps method, of class Run.
	 */
	@Test
	public void testGetSteps() {
		System.out.println("getSteps");
		Run instance = new Run();
		List<Step> expResult = new ArrayList<Step>();
		Step steps = new Step();
		expResult.add(steps);
		instance.setSteps(expResult);
		List<Step> result = instance.getSteps();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setSteps method, of class Run.
	 */
	@Test
	public void testSetSteps() {
		System.out.println("setSteps");
		List<Step> step = new ArrayList<>();
		Run instance = new Run();
		Step steps = new Step();
		step.add(steps);
		instance.setSteps(step);
		assertEquals(step, instance.getSteps());
	}

	/**
	 * Test of getDrops method, of class Run.
	 */
	@Test
	public void testGetDrops() {
		System.out.println("getDrops");
		Run instance = new Run();
		List<Drop> expResult = new ArrayList<Drop>();
		Drop drop = new Drop();
		expResult.add(drop);
		instance.setDrops(expResult);
		List<Drop> result = instance.getDrops();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setDrops method, of class Run.
	 */
	@Test
	public void testSetDrops() {
		System.out.println("setDrops");
		List<Drop> drops = new ArrayList<>();
		Run instance = new Run();
		Drop drop = new Drop();
		drops.add(drop);
		instance.setDrops(drops);
		assertEquals(drops, instance.getDrops());
	}

	/**
	 * Test of addDrop method, of class Run.
	 */
	@Test
	public void testAddDrop() {
		System.out.println("addDrop");
		Drop drop = new Drop();
		Run instance = new Run();
		Boolean expResult = true;
		Boolean result = instance.addDrop(drop);
		assertEquals(expResult, result);
	}

	/**
	 * Test of toString method, of class Run.
	 */
	@Test
	public void testToString() {
		System.out.println("toString");
		Run instance = new Run();
		instance.setId(1);
		instance.setName("Simulation");
		Measure measure = new Measure(22.2, "km");
		instance.setTime(measure);
		instance.setTimeStep(measure);
		Step step = new Step();
		ArrayList<Step> steps = new ArrayList<>();
		steps.add(step);
		List<Drop> drops = new ArrayList<>();
		Drop drop = new Drop();
		drops.add(drop);
		instance.setDrops(drops);
		instance.setSteps(steps);
		AnalysisMethod analy = new FastestPathAnalysis();
		instance.setMethod(analy);
		String expResult = "Run | id: 1 | name: Simulation | time: 22,20 km | time step: 22,20 km";
		System.out.println(instance.toString());
		String result = instance.toString();
		assertEquals(expResult, result);
	}

	/**
	 * Test of hashCode method, of class Run.
	 */
	@Test
	public void testHashCode() {
		System.out.println("hashCode");
		Run instance = new Run();
		instance.setId(1);
		instance.setName("Simulation");
		Measure measure = new Measure(22.2, "km");
		instance.setTime(measure);
		instance.setTimeStep(measure);
		ArrayList<Step> steps = new ArrayList<>();
		List<Drop> drops = new ArrayList<>();
		Drop drop = new Drop();
		AnalysisMethod analy = new FastestPathAnalysis();
		instance.setMethod(analy);
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
		instance.setDrops(drops);
		instance.setSteps(steps);
		int expResult = 29 * instance.getClass().hashCode();
		expResult += 11 * instance.getId().hashCode();
		expResult += 11 * instance.getName().hashCode();
		expResult += 11 * instance.getTime().hashCode();
		expResult += 11 * instance.getTimeStep().hashCode();
		expResult += 11 * instance.getMethod().hashCode();
		for (Step stepz : instance.getSteps()) {
			expResult += 11 * stepz.hashCode();
		}
		for (Drop dropz : instance.getDrops()) {
			expResult += 11 * dropz.hashCode();
		}
		int result = instance.hashCode();
		assertEquals(expResult, result);
	}

	/**
	 * Test of equals method, of class Run.
	 */
	@Test
	public void testEquals() {
		System.out.println("equals");
		Object obj = null;
		Run instance = new Run();
		boolean expResult = false;
		boolean result = instance.equals(obj);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
//		fail("The test case is a prototype.");
	}

}
