/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Physics.Measure;
import Physics.Measurement;
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
public class VehicleTest {

	private Vehicle vehicle;

	public VehicleTest() {
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
		this.vehicle.setGear(1, new Measure(3.827, "ratio"));
		this.vehicle.setGear(2, new Measure(2.36, "ratio"));
		this.vehicle.setGear(3, new Measure(1.685, "ratio"));
		this.vehicle.setGear(4, new Measure(1.312, "ratio"));
		this.vehicle.setGear(5, new Measure(1.0, "ratio"));
		this.vehicle.setGear(6, new Measure(0.793, "ratio"));
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
	 * Test of hashCode method, of class Project.
	 */
	@Test
	public void testHashCode() {
		System.out.println("testHashCode");
		Integer expResult = 29 * this.vehicle.getClass().hashCode();
		expResult += 11 * this.vehicle.getId().hashCode();
		expResult += 11 * this.vehicle.getName().hashCode();
		expResult += 11 * this.vehicle.getDescription().hashCode();
		expResult += 11 * this.vehicle.getType().hashCode();
		expResult += 11 * this.vehicle.getMotorization().hashCode();
		expResult += 11 * this.vehicle.getFuel().hashCode();
		expResult += 11 * this.vehicle.getMass().hashCode();
		expResult += 11 * this.vehicle.getLoad().hashCode();
		expResult += 11 * this.vehicle.getDragCoefficient().hashCode();
		expResult += 11 * this.vehicle.getFrontalArea().hashCode();
		expResult += 11 * this.vehicle.getRollingRCoefficient().hashCode();
		expResult += 11 * this.vehicle.getWheelSize().hashCode();
		expResult += 11 * this.vehicle.getMinRPM().hashCode();
		expResult += 11 * this.vehicle.getMaxRPM().hashCode();
		expResult += 11 * this.vehicle.getFinalDriveRatio().hashCode();
		for (Map.Entry<String, Measure> entity : this.vehicle.
			getVelocityLimits().
			entrySet()) {
			expResult += 7 * entity.getKey().hashCode();
			expResult += 7 * entity.getValue().hashCode();
		}
		for (Map.Entry<Integer, Measure> entity : this.vehicle.getGears().
			entrySet()) {
			expResult += 7 * entity.getKey().hashCode();
			expResult += 7 * entity.getValue().hashCode();
		}
		for (Throttle throttle : this.vehicle.getThrottles()) {
			expResult += 7 * throttle.hashCode();
		}
		Integer result = this.vehicle.hashCode();
		assertEquals(expResult, result);
	}

	/**
	 * Test of equals method, of class Project.
	 */
	@Test
	public void testEquals() {
		System.out.println("testEquals");
		Vehicle vehicle = this.vehicle.clone();
		assertEquals(this.vehicle.equals(vehicle), true);
	}

	/**
	 * Test of equals method, of class Project.
	 */
	@Test
	public void testEqualsFalseId() {
		System.out.println("testEqualsFalseId");
		Vehicle vehicle = this.vehicle.clone();
		vehicle.setId(2);
		assertEquals(this.vehicle.equals(vehicle), false);
	}

	/**
	 * Test of equals method, of class Project.
	 */
	@Test
	public void testEqualsFalseHash() {
		System.out.println("testEqualsFalseHash");
		Vehicle vehicle = this.vehicle.clone();
		vehicle.setName("Name");
		assertEquals(this.vehicle.equals(vehicle), false);
	}

	/**
	 * Test of equals method, of class Project.
	 */
	@Test
	public void testEqualsFalseNull() {
		System.out.println("testEqualsFalseNull");
		assertEquals(this.vehicle.equals(null), false);
	}

	/**
	 * Test of equals method, of class Project.
	 */
	@Test
	public void testEqualsFalseClass() {
		System.out.println("testEqualsFalseClass");
		assertEquals(this.vehicle.equals(new String()), false);
	}

	/**
	 * Test of getVelocity method, of class Vehicle.
	 */
	@Test
	public void testGetVelocity() {
		System.out.println("testGetVelocity");
		/*
		 assertEquals(this.vehicle.getVelocity(1).getValue(), 77.14, 0.01);
		 assertEquals(this.vehicle.getVelocity(2).getValue(), 125.09, 0.01);
		 assertEquals(this.vehicle.getVelocity(3).getValue(), 175.21, 0.01);
		 assertEquals(this.vehicle.getVelocity(4).getValue(), 225.02, 0.01);
		 assertEquals(this.vehicle.getVelocity(5).getValue(), 295.22, 0.01);
		 assertEquals(this.vehicle.getVelocity(6).getValue(), 372.29, 0.01);
		 */
	}

	/**
	 * Test of getMaxVelocity method, of class Vehicle.
	 */
	@Test
	public void testGetMaxVelocity() {
		System.out.println("testGetMaxVelocity");
		/*
		 assertEquals(this.vehicle.getMaxVelocity().getValue(), 372.29, 0.01);
		 */
		for (Map.Entry<Integer, Measure> entry : this.vehicle.getGears().
			entrySet()) {
			System.out.println("Gear " + entry.getKey() + ": " + entry.
				getValue());
			for (Throttle throttle : this.vehicle.getThrottles()) {
				System.out.println("\tThrottle: " + throttle.getPercentage());
				for (Regime regime : throttle.getRegimes()) {
					System.out.
						println("\t\tRegime: torque: " + regime.getTorque() + " - high: " + regime.
							getRpmHigh() + " - fuel: " + regime.
							getFuelConsumption());
					System.out.println("\t\t\tminSpeed: " + Measurement.
						convert(Physics.PhysicsMath.
							carSpeed(vehicle.getWheelSize(), regime.getRpmLow(), vehicle.
									 getFinalDriveRatio(), entry.getValue()), "km/h"));
					System.out.println("\t\t\tmaxSpeed: " + Measurement.
						convert(Physics.PhysicsMath.
							carSpeed(vehicle.getWheelSize(), regime.getRpmHigh(), vehicle.
									 getFinalDriveRatio(), entry.getValue()), "km/h"));
					System.out.println("\t\t\tminForce: " + Physics.PhysicsMath.
						engineCarForce(regime.getTorque(), vehicle.
									   getFinalDriveRatio(), regime.getRpmLow(), entry.
									   getValue(), vehicle.getWheelSize()));
					System.out.println("\t\t\tmaxForce: " + Physics.PhysicsMath.
						engineCarForce(regime.getTorque(), vehicle.
									   getFinalDriveRatio(), regime.getRpmHigh(), entry.
									   getValue(), vehicle.getWheelSize()));
					System.out.println("\t\t\tminPower: " + Physics.PhysicsMath.
						engineCarPower(regime.getTorque(), regime.getRpmLow(), entry.
									   getValue()));
					System.out.println("\t\t\tmaxPower: " + Physics.PhysicsMath.
						engineCarPower(regime.getTorque(), regime.getRpmHigh(), entry.
									   getValue()));
				}
			}
		}

		Measure radiusTire = vehicle.getWheelSize();
		Measure rotations = vehicle.getThrottles().get(0).getRegimes().get(0).
			getRpmLow();
		Measure finalDrive = vehicle.getFinalDriveRatio();
		Measure gearRatio = vehicle.getGear(1);
		Measure carSpeed = Physics.PhysicsMath.
			carSpeed(radiusTire, rotations, finalDrive, gearRatio);
		Measure windSpeed = new Measure(5.0, "m/s");
		Measure windDirection = new Measure(20.0, "°");
		Measure relativeSpeed = Physics.PhysicsMath.
			relativeSpeed(carSpeed, windSpeed, windDirection);
		Measure torque = vehicle.getThrottles().get(0).getRegimes().get(0).
			getTorque();
		Measure force = Physics.PhysicsMath.
			engineCarForce(torque, finalDrive, rotations, gearRatio, radiusTire);
		Measure power = Physics.PhysicsMath.
			engineCarPower(torque, rotations, gearRatio);
		Measure lenght = new Measure(1.0, "m");
		Measure time = new Measure(1.0, "s");
		Measure fuelConsumptionTime = Physics.PhysicsMath.
			fuelConsumptionTime(power, time, vehicle.getFuel());
		Measure fuelConsumptionLenght = Physics.PhysicsMath.
			fuelConsumptionLenght(force, lenght, vehicle.getFuel());

		System.out.println(radiusTire);
		System.out.println(rotations);
		System.out.println(finalDrive);
		System.out.println(gearRatio);
		System.out.println(carSpeed);
		System.out.println(windSpeed);
		System.out.println(windDirection);
		System.out.println("aqui -> " + relativeSpeed);
		System.out.println(torque);
		System.out.println(force);
		System.out.println(power);
		System.out.println(lenght);
		System.out.println(time);
		System.out.println(fuelConsumptionTime);
		System.out.println(fuelConsumptionLenght);

		System.out.println("fuelConsumptionTime: " + fuelConsumptionTime);
		System.out.println("fuelConsumptionLenght: " + fuelConsumptionLenght);
	}

	/**
	 * Test of setVelocityLimits method, of class Vehicle.
	 */
	@Test
	public void testSetVelocityLimits() {
		System.out.println("setVelocityLimits");
		String segmentType = "";
		Measure velocityLimit = null;
		Vehicle instance = new Vehicle();
		Boolean expResult = null;
		Boolean result = instance.setVelocityLimits(segmentType, velocityLimit);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getVelocityLimits method, of class Vehicle.
	 */
	@Test
	public void testGetVelocityLimits_String() {
		System.out.println("getVelocityLimits");
		String segmentType = "";
		Vehicle instance = new Vehicle();
		Measure expResult = null;
		Measure result = instance.getVelocityLimits(segmentType);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setGear method, of class Vehicle.
	 */
	@Test
	public void testSetGear() {
		System.out.println("setGear");
		Integer number = null;
		Measure ratio = null;
		Vehicle instance = new Vehicle();
		Boolean expResult = null;
		Boolean result = instance.setGear(number, ratio);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getGear method, of class Vehicle.
	 */
	@Test
	public void testGetGear() {
		System.out.println("getGear");
		Integer number = null;
		Vehicle instance = new Vehicle();
		Measure expResult = null;
		Measure result = instance.getGear(number);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of addThrottle method, of class Vehicle.
	 */
	@Test
	public void testAddThrottle() {
		System.out.println("addThrottle");
		Throttle throttle = null;
		Vehicle instance = new Vehicle();
		Boolean expResult = null;
		Boolean result = instance.addThrottle(throttle);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getThrottle method, of class Vehicle.
	 */
	@Test
	public void testGetThrottle() {
		System.out.println("getThrottle");
		Integer index = null;
		Vehicle instance = new Vehicle();
		Throttle expResult = null;
		Throttle result = instance.getThrottle(index);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getId method, of class Vehicle.
	 */
	@Test
	public void testGetId() {
		System.out.println("getId");
		Vehicle instance = new Vehicle();
		Integer expResult = null;
		Integer result = instance.getId();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setId method, of class Vehicle.
	 */
	@Test
	public void testSetId() {
		System.out.println("setId");
		Integer id = null;
		Vehicle instance = new Vehicle();
		instance.setId(id);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getName method, of class Vehicle.
	 */
	@Test
	public void testGetName() {
		System.out.println("getName");
		Vehicle instance = new Vehicle();
		String expResult = "";
		String result = instance.getName();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setName method, of class Vehicle.
	 */
	@Test
	public void testSetName() {
		System.out.println("setName");
		String name = "";
		Vehicle instance = new Vehicle();
		instance.setName(name);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getDescription method, of class Vehicle.
	 */
	@Test
	public void testGetDescription() {
		System.out.println("getDescription");
		Vehicle instance = new Vehicle();
		String expResult = "";
		String result = instance.getDescription();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setDescription method, of class Vehicle.
	 */
	@Test
	public void testSetDescription() {
		System.out.println("setDescription");
		String description = "";
		Vehicle instance = new Vehicle();
		instance.setDescription(description);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getType method, of class Vehicle.
	 */
	@Test
	public void testGetType() {
		System.out.println("getType");
		Vehicle instance = new Vehicle();
		String expResult = "";
		String result = instance.getType();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setType method, of class Vehicle.
	 */
	@Test
	public void testSetType() {
		System.out.println("setType");
		String type = "";
		Vehicle instance = new Vehicle();
		instance.setType(type);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getMotorization method, of class Vehicle.
	 */
	@Test
	public void testGetMotorization() {
		System.out.println("getMotorization");
		Vehicle instance = new Vehicle();
		String expResult = "";
		String result = instance.getMotorization();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setMotorization method, of class Vehicle.
	 */
	@Test
	public void testSetMotorization() {
		System.out.println("setMotorization");
		String motorization = "";
		Vehicle instance = new Vehicle();
		instance.setMotorization(motorization);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getFuel method, of class Vehicle.
	 */
	@Test
	public void testGetFuel() {
		System.out.println("getFuel");
		Vehicle instance = new Vehicle();
		String expResult = "";
		String result = instance.getFuel();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setFuel method, of class Vehicle.
	 */
	@Test
	public void testSetFuel() {
		System.out.println("setFuel");
		String fuel = "";
		Vehicle instance = new Vehicle();
		instance.setFuel(fuel);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getMass method, of class Vehicle.
	 */
	@Test
	public void testGetMass() {
		System.out.println("getMass");
		Vehicle instance = new Vehicle();
		Measure expResult = null;
		Measure result = instance.getMass();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setMass method, of class Vehicle.
	 */
	@Test
	public void testSetMass() {
		System.out.println("setMass");
		Measure mass = null;
		Vehicle instance = new Vehicle();
		instance.setMass(mass);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getLoad method, of class Vehicle.
	 */
	@Test
	public void testGetLoad() {
		System.out.println("getLoad");
		Vehicle instance = new Vehicle();
		Measure expResult = null;
		Measure result = instance.getLoad();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setLoad method, of class Vehicle.
	 */
	@Test
	public void testSetLoad() {
		System.out.println("setLoad");
		Measure load = null;
		Vehicle instance = new Vehicle();
		instance.setLoad(load);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getDragCoefficient method, of class Vehicle.
	 */
	@Test
	public void testGetDragCoefficient() {
		System.out.println("getDragCoefficient");
		Vehicle instance = new Vehicle();
		Measure expResult = null;
		Measure result = instance.getDragCoefficient();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setDragCoefficient method, of class Vehicle.
	 */
	@Test
	public void testSetDragCoefficient() {
		System.out.println("setDragCoefficient");
		Measure dragCoefficient = null;
		Vehicle instance = new Vehicle();
		instance.setDragCoefficient(dragCoefficient);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getFrontalArea method, of class Vehicle.
	 */
	@Test
	public void testGetFrontalArea() {
		System.out.println("getFrontalArea");
		Vehicle instance = new Vehicle();
		Measure expResult = null;
		Measure result = instance.getFrontalArea();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setFrontalArea method, of class Vehicle.
	 */
	@Test
	public void testSetFrontalArea() {
		System.out.println("setFrontalArea");
		Measure frontalArea = null;
		Vehicle instance = new Vehicle();
		instance.setFrontalArea(frontalArea);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getRollingRCoefficient method, of class Vehicle.
	 */
	@Test
	public void testGetRollingRCoefficient() {
		System.out.println("getRollingRCoefficient");
		Vehicle instance = new Vehicle();
		Measure expResult = null;
		Measure result = instance.getRollingRCoefficient();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setRollingRCoefficient method, of class Vehicle.
	 */
	@Test
	public void testSetRollingRCoefficient() {
		System.out.println("setRollingRCoefficient");
		Measure rollingRcoefficient = null;
		Vehicle instance = new Vehicle();
		instance.setRollingRCoefficient(rollingRcoefficient);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getWheelSize method, of class Vehicle.
	 */
	@Test
	public void testGetWheelSize() {
		System.out.println("getWheelSize");
		Vehicle instance = new Vehicle();
		Measure expResult = null;
		Measure result = instance.getWheelSize();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setWheelSize method, of class Vehicle.
	 */
	@Test
	public void testSetWheelSize() {
		System.out.println("setWheelSize");
		Measure wheelSize = null;
		Vehicle instance = new Vehicle();
		instance.setWheelSize(wheelSize);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getMinRPM method, of class Vehicle.
	 */
	@Test
	public void testGetMinRPM() {
		System.out.println("getMinRPM");
		Vehicle instance = new Vehicle();
		Measure expResult = null;
		Measure result = instance.getMinRPM();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setMinRPM method, of class Vehicle.
	 */
	@Test
	public void testSetMinRPM() {
		System.out.println("setMinRPM");
		Measure minRPM = null;
		Vehicle instance = new Vehicle();
		instance.setMinRPM(minRPM);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getMaxRPM method, of class Vehicle.
	 */
	@Test
	public void testGetMaxRPM() {
		System.out.println("getMaxRPM");
		Vehicle instance = new Vehicle();
		Measure expResult = null;
		Measure result = instance.getMaxRPM();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setMaxRPM method, of class Vehicle.
	 */
	@Test
	public void testSetMaxRPM() {
		System.out.println("setMaxRPM");
		Measure maxRPM = null;
		Vehicle instance = new Vehicle();
		instance.setMaxRPM(maxRPM);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getFinalDriveRatio method, of class Vehicle.
	 */
	@Test
	public void testGetFinalDriveRatio() {
		System.out.println("getFinalDriveRatio");
		Vehicle instance = new Vehicle();
		Measure expResult = null;
		Measure result = instance.getFinalDriveRatio();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setFinalDriveRatio method, of class Vehicle.
	 */
	@Test
	public void testSetFinalDriveRatio() {
		System.out.println("setFinalDriveRatio");
		Measure finalDriveRatio = null;
		Vehicle instance = new Vehicle();
		instance.setFinalDriveRatio(finalDriveRatio);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getEnergyRegeneration method, of class Vehicle.
	 */
	@Test
	public void testGetEnergyRegeneration() {
		System.out.println("getEnergyRegeneration");
		Vehicle instance = new Vehicle();
		Measure expResult = null;
		Measure result = instance.getEnergyRegeneration();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setEnergyRegeneration method, of class Vehicle.
	 */
	@Test
	public void testSetEnergyRegeneration() {
		System.out.println("setEnergyRegeneration");
		Measure energyRegeneration = null;
		Vehicle instance = new Vehicle();
		instance.setEnergyRegeneration(energyRegeneration);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getVelocityLimits method, of class Vehicle.
	 */
	@Test
	public void testGetVelocityLimits_0args() {
		System.out.println("getVelocityLimits");
		Vehicle instance = new Vehicle();
		Map<String, Measure> expResult = null;
		Map<String, Measure> result = instance.getVelocityLimits();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getGears method, of class Vehicle.
	 */
	@Test
	public void testGetGears() {
		System.out.println("getGears");
		Vehicle instance = new Vehicle();
		Map<Integer, Measure> expResult = null;
		Map<Integer, Measure> result = instance.getGears();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getThrottles method, of class Vehicle.
	 */
	@Test
	public void testGetThrottles() {
		System.out.println("getThrottles");
		Vehicle instance = new Vehicle();
		List<Throttle> expResult = null;
		List<Throttle> result = instance.getThrottles();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setThrottles method, of class Vehicle.
	 */
	@Test
	public void testSetThrottles() {
		System.out.println("setThrottles");
		List<Throttle> throttles = null;
		Vehicle instance = new Vehicle();
		instance.setThrottles(throttles);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of clone method, of class Vehicle.
	 */
	@Test
	public void testClone() {
		System.out.println("clone");
		Vehicle instance = new Vehicle();
		Vehicle expResult = null;
		Vehicle result = instance.clone();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of toString method, of class Vehicle.
	 */
	@Test
	public void testToString() {
		System.out.println("toString");
		Vehicle instance = new Vehicle();
		String expResult = "";
		String result = instance.toString();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getCurrentGear method, of class Vehicle.
	 */
	@Test
	public void testGetCurrentGear() {
		System.out.println("getCurrentGear");
		Vehicle instance = new Vehicle();
		Integer expResult = null;
		Integer result = instance.getCurrentGear();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getCurrentVelocity method, of class Vehicle.
	 */
	@Test
	public void testGetCurrentVelocity() {
		System.out.println("getCurrentVelocity");
		Vehicle instance = new Vehicle();
		Measure expResult = null;
		Measure result = instance.getCurrentVelocity();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

}
