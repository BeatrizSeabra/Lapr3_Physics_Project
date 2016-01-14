/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Physics.Measure;
import Physics.Measurement;
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
		this.vehicle.setEnergyRegeneration(new Measure(22.0, "rpm"));
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
		expResult += 11 * this.vehicle.getEnergyRegeneration().hashCode();
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
		String segmentType = "testCase1";
		Measure velocityLimit = new Measure(22.2, "km");
		Boolean expResult = false;
		Boolean result = this.vehicle.
			setVelocityLimits(segmentType, velocityLimit);
		assertEquals(expResult, result);
	}

	/**
	 * Test of getVelocityLimits method, of class Vehicle.
	 */
	@Test
	public void testGetVelocityLimits_String() {
		System.out.println("getVelocityLimits");
		String segmentType = "km";
		Measure expResult = new Measure(22.2, "km");
		this.vehicle.setVelocityLimits(segmentType, expResult);
		Measure result = this.vehicle.getVelocityLimits(segmentType);
		assertEquals(expResult, result);
	}

	/**
	 * Test of setGear method, of class Vehicle.
	 */
	@Test
	public void testSetGear() {
		System.out.println("setGear");
		Integer number = 22;
		Measure ratio = new Measure(22.2, "km");
		Boolean expResult = false;
		Boolean result = this.vehicle.setGear(number, ratio);
		assertEquals(expResult, result);
	}

	/**
	 * Test of getGear method, of class Vehicle.
	 */
	@Test
	public void testGetGear() {
		System.out.println("getGear");
		Integer number = 12;
		Measure expResult = new Measure(19.0, "km");
		this.vehicle.setGear(number, expResult);
		Measure result = this.vehicle.getGear(number);
		assertEquals(expResult, result);
	}

	/**
	 * Test of addThrottle method, of class Vehicle.
	 */
	@Test
	public void testAddThrottle() {
		System.out.println("addThrottle");
		Throttle throttle1 = new Throttle();
		throttle1.setPercentage(new Measure(25.0, "%"));
		throttle1.
			addRegime(new Regime(new Measure(85.0, "Nm"), new Measure(1000.0, "rpm"), new Measure(2499.0, "rpm"), new Measure(8.2, "g/KWh")));
		throttle1.
			addRegime(new Regime(new Measure(95.0, "Nm"), new Measure(2500.0, "rpm"), new Measure(3999.0, "rpm"), new Measure(6.2, "g/KWh")));
		throttle1.
			addRegime(new Regime(new Measure(80.0, "Nm"), new Measure(4000.0, "rpm"), new Measure(5500.0, "rpm"), new Measure(10.2, "g/KWh")));
		Boolean expResult = true;
		Boolean result = this.vehicle.addThrottle(throttle1);
		assertEquals(expResult, result);
	}

	/**
	 * Test of getThrottle method, of class Vehicle.
	 */
	@Test
	public void testGetThrottle() {
		System.out.println("getThrottle");
		Integer index = 0;
		Throttle throttle1 = new Throttle();
		throttle1.setPercentage(new Measure(25.0, "%"));
		throttle1.
			addRegime(new Regime(new Measure(85.0, "Nm"), new Measure(1000.0, "rpm"), new Measure(2499.0, "rpm"), new Measure(8.2, "g/KWh")));
		throttle1.
			addRegime(new Regime(new Measure(95.0, "Nm"), new Measure(2500.0, "rpm"), new Measure(3999.0, "rpm"), new Measure(6.2, "g/KWh")));
		throttle1.
			addRegime(new Regime(new Measure(80.0, "Nm"), new Measure(4000.0, "rpm"), new Measure(5500.0, "rpm"), new Measure(10.2, "g/KWh")));
		ArrayList<Throttle> trot = new ArrayList<>();
		trot.add(throttle1);
		this.vehicle.setThrottles(trot);
		Throttle result = this.vehicle.getThrottle(index);
		assertEquals(trot.get(index), result);
	}

	/**
	 * Test of getId method, of class Vehicle.
	 */
	@Test
	public void testGetId() {
		System.out.println("getId");
		Integer expResult = 1;
		Integer result = this.vehicle.getId();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setId method, of class Vehicle.
	 */
	@Test
	public void testSetId() {
		System.out.println("setId");
		Integer id = 2;
		this.vehicle.setId(id);
		assertEquals(id, this.vehicle.getId());
	}

	/**
	 * Test of getName method, of class Vehicle.
	 */
	@Test
	public void testGetName() {
		System.out.println("getName");
		String expResult = "Nissan Skyline 2001";
		String result = this.vehicle.getName();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setName method, of class Vehicle.
	 */
	@Test
	public void testSetName() {
		System.out.println("setName");
		String name = "Nissan Almera";
		this.vehicle.setName(name);
		assertEquals(name, this.vehicle.getName());
	}

	/**
	 * Test of getDescription method, of class Vehicle.
	 */
	@Test
	public void testGetDescription() {
		System.out.println("getDescription");
		String expResult = "2001 Nissan Skyline GT-R R34 V-spec II N1";
		String result = this.vehicle.getDescription();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setDescription method, of class Vehicle.
	 */
	@Test
	public void testSetDescription() {
		System.out.println("setDescription");
		String description = "TestCar";
		this.vehicle.setDescription(description);
		assertEquals(description, this.vehicle.getDescription());
	}

	/**
	 * Test of getType method, of class Vehicle.
	 */
	@Test
	public void testGetType() {
		System.out.println("getType");
		String expResult = "car";
		String result = this.vehicle.getType();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setType method, of class Vehicle.
	 */
	@Test
	public void testSetType() {
		System.out.println("setType");
		String type = "sub";
		this.vehicle.setType(type);
		assertEquals(type, this.vehicle.getType());
	}

	/**
	 * Test of getMotorization method, of class Vehicle.
	 */
	@Test
	public void testGetMotorization() {
		System.out.println("getMotorization");
		String expResult = "combustion";
		String result = this.vehicle.getMotorization();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setMotorization method, of class Vehicle.
	 */
	@Test
	public void testSetMotorization() {
		System.out.println("setMotorization");
		String motorization = "Gasoline";
		this.vehicle.setMotorization(motorization);
		assertEquals(motorization, this.vehicle.getMotorization());
	}

	/**
	 * Test of getFuel method, of class Vehicle.
	 */
	@Test
	public void testGetFuel() {
		System.out.println("getFuel");
		String expResult = "Prototype";
		this.vehicle.setFuel(expResult);
		String result = this.vehicle.getFuel();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setFuel method, of class Vehicle.
	 */
	@Test
	public void testSetFuel() {
		System.out.println("setFuel");
		String fuel = "Prototype";
		this.vehicle.setFuel(fuel);
		assertEquals(fuel, this.vehicle.getFuel());
	}

	/**
	 * Test of getMass method, of class Vehicle.
	 */
	@Test
	public void testGetMass() {
		System.out.println("getMass");
		Measure expResult = new Measure(22.2, "sub");
		this.vehicle.setMass(expResult);
		Measure result = this.vehicle.getMass();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setMass method, of class Vehicle.
	 */
	@Test
	public void testSetMass() {
		System.out.println("setMass");
		Measure mass = new Measure(20.0, "sub");
		this.vehicle.setMass(mass);
		assertEquals(mass, this.vehicle.getMass());
	}

	/**
	 * Test of getLoad method, of class Vehicle.
	 */
	@Test
	public void testGetLoad() {
		System.out.println("getLoad");
		Measure expResult = new Measure(33.0, "subway");
		this.vehicle.setLoad(expResult);
		Measure result = this.vehicle.getLoad();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setLoad method, of class Vehicle.
	 */
	@Test
	public void testSetLoad() {
		System.out.println("setLoad");
		Measure load = new Measure(59.0, "unit");
		this.vehicle.setLoad(load);
		assertEquals(load, this.vehicle.getLoad());
	}

	/**
	 * Test of getDragCoefficient method, of class Vehicle.
	 */
	@Test
	public void testGetDragCoefficient() {
		System.out.println("getDragCoefficient");
		Measure expResult = new Measure(49.0, "testCase");
		this.vehicle.setDragCoefficient(expResult);
		Measure result = this.vehicle.getDragCoefficient();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setDragCoefficient method, of class Vehicle.
	 */
	@Test
	public void testSetDragCoefficient() {
		System.out.println("setDragCoefficient");
		Measure dragCoefficient = new Measure(48.0, "test");
		this.vehicle.setDragCoefficient(dragCoefficient);
		assertEquals(dragCoefficient, this.vehicle.getDragCoefficient());
	}

	/**
	 * Test of getFrontalArea method, of class Vehicle.
	 */
	@Test
	public void testGetFrontalArea() {
		System.out.println("getFrontalArea");
		Measure expResult = new Measure(30.0, "high");
		this.vehicle.setFrontalArea(expResult);
		Measure result = this.vehicle.getFrontalArea();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setFrontalArea method, of class Vehicle.
	 */
	@Test
	public void testSetFrontalArea() {
		System.out.println("setFrontalArea");
		Measure frontalArea = new Measure(22.0, "km");
		this.vehicle.setFrontalArea(frontalArea);
		assertEquals(frontalArea, this.vehicle.getFrontalArea());
	}

	/**
	 * Test of getRollingRCoefficient method, of class Vehicle.
	 */
	@Test
	public void testGetRollingRCoefficient() {
		System.out.println("getRollingRCoefficient");
		Measure expResult = new Measure(25.0, "high");
		this.vehicle.setRollingRCoefficient(expResult);
		Measure result = this.vehicle.getRollingRCoefficient();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setRollingRCoefficient method, of class Vehicle.
	 */
	@Test
	public void testSetRollingRCoefficient() {
		System.out.println("setRollingRCoefficient");
		Measure rollingRcoefficient = new Measure(0.01, "ratio");
		this.vehicle.setRollingRCoefficient(rollingRcoefficient);
		assertEquals(rollingRcoefficient, this.vehicle.getRollingRCoefficient());
	}

	/**
	 * Test of getWheelSize method, of class Vehicle.
	 */
	@Test
	public void testGetWheelSize() {
		System.out.println("getWheelSize");
		Measure expResult = new Measure(0.05, "Michelin");
		this.vehicle.setWheelSize(expResult);
		Measure result = this.vehicle.getWheelSize();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setWheelSize method, of class Vehicle.
	 */
	@Test
	public void testSetWheelSize() {
		System.out.println("setWheelSize");
		Measure wheelSize = new Measure(0.07, "Prindelli");
		this.vehicle.setWheelSize(wheelSize);
		assertEquals(wheelSize, this.vehicle.getWheelSize());
	}

	/**
	 * Test of getMinRPM method, of class Vehicle.
	 */
	@Test
	public void testGetMinRPM() {
		System.out.println("getMinRPM");
		Measure expResult = new Measure(3.5, "km");
		this.vehicle.setMinRPM(expResult);
		Measure result = this.vehicle.getMinRPM();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setMinRPM method, of class Vehicle.
	 */
	@Test
	public void testSetMinRPM() {
		System.out.println("setMinRPM");
		Measure minRPM = new Measure(30.5, "km");
		this.vehicle.setMinRPM(minRPM);
		assertEquals(minRPM, this.vehicle.getMinRPM());
	}

	/**
	 * Test of getMaxRPM method, of class Vehicle.
	 */
	@Test
	public void testGetMaxRPM() {
		System.out.println("getMaxRPM");
		Measure expResult = new Measure(12.2, "km");
		this.vehicle.setMaxRPM(expResult);
		Measure result = this.vehicle.getMaxRPM();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setMaxRPM method, of class Vehicle.
	 */
	@Test
	public void testSetMaxRPM() {
		System.out.println("setMaxRPM");
		Measure maxRPM = new Measure(10.0, "km");
		this.vehicle.setMaxRPM(maxRPM);
		assertEquals(maxRPM, this.vehicle.getMaxRPM());
	}

	/**
	 * Test of getFinalDriveRatio method, of class Vehicle.
	 */
	@Test
	public void testGetFinalDriveRatio() {
		System.out.println("getFinalDriveRatio");
		Measure expResult = new Measure(15.2, "km");
		this.vehicle.setFinalDriveRatio(expResult);
		Measure result = this.vehicle.getFinalDriveRatio();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setFinalDriveRatio method, of class Vehicle.
	 */
	@Test
	public void testSetFinalDriveRatio() {
		System.out.println("setFinalDriveRatio");
		Measure finalDriveRatio = new Measure(12.0, "km");
		this.vehicle.setFinalDriveRatio(finalDriveRatio);
		assertEquals(finalDriveRatio, this.vehicle.getFinalDriveRatio());
	}

	/**
	 * Test of getEnergyRegeneration method, of class Vehicle.
	 */
	@Test
	public void testGetEnergyRegeneration() {
		System.out.println("getEnergyRegeneration");
		Measure expResult = new Measure(15.0, "km");
		this.vehicle.setEnergyRegeneration(expResult);
		Measure result = this.vehicle.getEnergyRegeneration();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setEnergyRegeneration method, of class Vehicle.
	 */
	@Test
	public void testSetEnergyRegeneration() {
		System.out.println("setEnergyRegeneration");
		Measure energyRegeneration = new Measure(12.0, "km");
		this.vehicle.setEnergyRegeneration(energyRegeneration);
		assertEquals(energyRegeneration, this.vehicle.getEnergyRegeneration());
	}

	/**
	 * Test of getVelocityLimits method, of class Vehicle.
	 */
	@Test
	public void testGetVelocityLimits_0args() {
		System.out.println("getVelocityLimits");
		Measure measure = new Measure(20.2, "km");
		this.vehicle.setVelocityLimits("Highway12", measure);
		Map<String, Measure> expResult = new HashMap<>();
		expResult.put("Highway12", measure);
		Map<String, Measure> result = this.vehicle.getVelocityLimits();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getGears method, of class Vehicle.
	 */
	@Test
	public void testGetGears() {
		System.out.println("getGears");
		Measure measure = new Measure(3.827, "ratio");
		Measure measure1 = new Measure(2.36, "ratio");
		Measure measure2 = new Measure(1.685, "ratio");
		Measure measure3 = new Measure(1.312, "ratio");
		Measure measure4 = new Measure(1.0, "ratio");
		Measure measure5 = new Measure(0.793, "ratio");

		Map<Integer, Measure> expResult = new HashMap<>();
		expResult.put(1, measure);
		expResult.put(2, measure1);
		expResult.put(3, measure2);
		expResult.put(4, measure3);
		expResult.put(5, measure4);
		expResult.put(6, measure5);

		Map<Integer, Measure> result = this.vehicle.getGears();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getThrottles method, of class Vehicle.
	 */
	@Test
	public void testGetThrottles() {
		System.out.println("getThrottles");
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
		List<Throttle> expResult = new ArrayList<>();
		expResult.add(throttle1);
		expResult.add(throttle2);
		expResult.add(throttle3);
		List<Throttle> result = this.vehicle.getThrottles();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setThrottles method, of class Vehicle.
	 */
	@Test
	public void testSetThrottles() {
		System.out.println("setThrottles");
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
		List<Throttle> throttles = new ArrayList<>();
		throttles.add(throttle1);
		throttles.add(throttle2);
		throttles.add(throttle3);
		this.vehicle.setThrottles(throttles);
		assertEquals(throttles, this.vehicle.getThrottles());
	}

	/**
	 * Test of clone method, of class Vehicle.
	 */
	@Test
	public void testClone() {
		System.out.println("clone");
		Vehicle expResult = this.vehicle;
		Vehicle result = this.vehicle.clone();
		assertEquals(expResult, result);
	}

	/**
	 * Test of toString method, of class Vehicle.
	 */
	@Test
	public void testToString() {
		System.out.println("toString");
		String expResult = "Vehicle | name: Nissan Skyline 2001 | description: 2001 Nissan Skyline GT-R R34 V-spec II N1 | type: car | motorization: combustion | fuel: gasoline | mass: 1550,00 kg | load: 0,00 kg | drag: 0,34 ratio | rrc: 0,01 ratio | wheelSize: 0,33 m | minRPM: 8500,00 rpm | maxRPM: 1000,00 rpm | finalDrive: 3,55 ratio | energyRegeneration: 22,00 rpm | gear1: 3,83 ratio | gear2: 2,36 ratio | gear3: 1,69 ratio | gear4: 1,31 ratio | gear5: 1,00 ratio | gear6: 0,79 ratio | throttleModel.Throttle@c6aed28a | throttleModel.Throttle@9212bc77 | throttleModel.Throttle@a3c51c77";
		String result = this.vehicle.toString();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getCurrentGear method, of class Vehicle.
	 */
	@Test
	public void testGetCurrentGear() {
		System.out.println("getCurrentGear");
		Integer expResult = 1;
		Integer result = this.vehicle.getCurrentGear();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getCurrentVelocity method, of class Vehicle.
	 */
	@Test
	public void testGetCurrentVelocity() {
		System.out.println("getCurrentVelocity");
		Measure expResult = new Measure(44.2, "km");
		expResult = Measurement.convert(new Measure(60.0, "km/h"), "m/s");
		this.vehicle.setVelocityLimits("testCase", expResult);
		Measure result = this.vehicle.getCurrentVelocity();
		assertEquals(expResult, result);
	}

}
