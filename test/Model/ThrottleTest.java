/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Physics.Measure;
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
public class ThrottleTest {

	public ThrottleTest() {
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
	 * Test of addRegime method, of class Throttle.
	 */
	@Test
	public void testAddRegime() {
		System.out.println("addRegime");
		Measure mesureTorque = new Measure(12.2, "MeasureTorque");
		Measure rmpLow = new Measure(1.2, "MeasureTorque");
		Measure rmpHigh = new Measure(12.2, "MeasureTorque");
		Measure fuel = new Measure(12.2, "MeasureTorque");
		Regime regime = new Regime(mesureTorque, rmpLow, rmpHigh, fuel);
		Throttle instance = new Throttle();
		Boolean expResult = true;
		Boolean result = instance.addRegime(regime);
		assertEquals(expResult, result);
	}

	/**
	 * Test of getId method, of class Throttle.
	 */
	@Test
	public void testGetId() {
		System.out.println("getId");
		Throttle instance = new Throttle();
		instance.setId(12);
		Integer expResult = 12;
		Integer result = instance.getId();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.

	}

	/**
	 * Test of setId method, of class Throttle.
	 */
	@Test
	public void testSetId() {
		System.out.println("setId");
		Integer result = 12;
		Throttle instance = new Throttle();
		instance.setId(result);
		Integer expResult = instance.getId();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.

	}

	/**
	 * Test of getPercentage method, of class Throttle.
	 */
	@Test
	public void testGetPercentage() {
		System.out.println("getPercentage");
		Throttle instance = new Throttle();
		Measure expResult = new Measure(12.2, "X");
		instance.setPercentage(expResult);
		Measure result = instance.getPercentage();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.

	}

	/**
	 * Test of setPercentage method, of class Throttle.
	 */
	@Test
	public void testSetPercentage() {
		System.out.println("setPercentage");
		Measure result = new Measure(12.2, "X");
		Throttle instance = new Throttle();
		instance.setPercentage(result);
		Measure expResult = instance.getPercentage();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.

	}

	/**
	 * Test of getRegimes method, of class Throttle.
	 */
	@Test
	public void testGetRegimes() {
		Measure mesureTorque = new Measure(12.2, "MeasureTorque");
		Measure rmpLow = new Measure(1.2, "MeasureTorque");
		Measure rmpHigh = new Measure(12.2, "MeasureTorque");
		Measure fuel = new Measure(12.2, "MeasureTorque");
		Regime regime = new Regime(mesureTorque, rmpLow, rmpHigh, fuel);
		System.out.println("getRegimes");
		Throttle instance = new Throttle();
		instance.addRegime(regime);
		List<Regime> reg = new ArrayList<Regime>();
		reg.add(regime);
		List<Regime> expResult = reg;
		List<Regime> result = instance.getRegimes();
		assertEquals(expResult, result);

	}

	/**
	 * Test of setRegimes method, of class Throttle.
	 */
	@Test
	public void testSetRegimes() {
		Measure mesureTorque = new Measure(12.2, "MeasureTorque");
		Measure rmpLow = new Measure(1.2, "MeasureTorque");
		Measure rmpHigh = new Measure(12.2, "MeasureTorque");
		Measure fuel = new Measure(12.2, "MeasureTorque");
		Regime regime = new Regime(mesureTorque, rmpLow, rmpHigh, fuel);
		System.out.println("setRegimes");
		List<Regime> regimes = new ArrayList<Regime>();
		regimes.add(regime);
		Throttle instance = new Throttle();
		instance.setRegimes(regimes);
		List<Regime> reg = instance.getRegimes();
		assertEquals(regimes, reg);
		// TODO review the generated test code and remove the default call to fail.

	}

	/**
	 * Test of equals method, of class Throttle.
	 */
	@Test
	public void testEquals() {
		System.out.println("equals");
		Throttle instance2 = new Throttle();
		Throttle instance = new Throttle();
		instance.setId(12);
		Measure mesureTorque = new Measure(12.2, "MeasureTorque");
		Measure rmpLow = new Measure(1.2, "MeasureTorque");
		Measure rmpHigh = new Measure(12.2, "MeasureTorque");
		Measure fuel = new Measure(12.2, "MeasureTorque");
		instance.setPercentage(mesureTorque);
		Regime regime = new Regime(mesureTorque, rmpLow, rmpHigh, fuel);
		List<Regime> regimes = new ArrayList<Regime>();
		regimes.add(regime);
		instance2.setId(11);
		instance2.setPercentage(rmpHigh);
		instance2.setRegimes(regimes);
		instance.setRegimes(regimes);
		boolean expResult = false;
		assertEquals(expResult, instance.equals(instance2));
		// TODO review the generated test code and remove the default call to fail.

	}

	/**
	 * Test of hashCode method, of class Throttle.
	 */
	@Test
	public void testHashCode() {
		System.out.println("hashCode");
		Throttle instance = new Throttle();
		Measure mesureTorque = new Measure(12.2, "MeasureTorque");
		Measure rmpLow = new Measure(1.2, "MeasureTorque");
		Measure rmpHigh = new Measure(12.2, "MeasureTorque");
		Measure fuel = new Measure(12.2, "MeasureTorque");
		Regime regime = new Regime(mesureTorque, rmpLow, rmpHigh, fuel);
		instance.setId(12);
		instance.setPercentage(rmpHigh);
		List<Regime> regimes = new ArrayList<Regime>();
		regimes.add(regime);
		instance.setRegimes(regimes);
		int expResult = 29 * instance.getClass().hashCode();
		expResult += 11 * instance.getId().hashCode();
		expResult += 11 * instance.getPercentage().hashCode();
		for (Regime regime1 : regimes) {
			expResult += 7 * regime1.hashCode();
		}
		int result = instance.hashCode();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.

	}

	/**
	 * Test of clone method, of class Throttle.
	 */
	@Test
	public void testClone() {
		System.out.println("clone");
		Measure mesureTorque = new Measure(12.2, "MeasureTorque");
		Measure rmpLow = new Measure(1.2, "MeasureTorque");
		Measure rmpHigh = new Measure(12.2, "MeasureTorque");
		Measure fuel = new Measure(12.2, "MeasureTorque");
		Regime regime = new Regime(mesureTorque, rmpLow, rmpHigh, fuel);
		Throttle instance = new Throttle();
		instance.setId(12);
		instance.setPercentage(rmpHigh);
		List<Regime> regimes = new ArrayList<Regime>();
		regimes.add(regime);
		instance.setRegimes(regimes);
		Throttle expResult = instance;
		Throttle result = instance.clone();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.

	}

	/**
	 * Test of compareTo method, of class Throttle.
	 */
	@Test
	public void testCompareTo() {
		System.out.println("compareTo");
		Throttle Throttle = new Throttle();
		Measure mesureTorque = new Measure(12.2, "MeasureTorque");
		Measure rmpLow = new Measure(1.2, "MeasureTorque");
		Measure rmpHigh = new Measure(12.2, "MeasureTorque");
		Measure fuel = new Measure(12.2, "MeasureTorque");
		Regime regime = new Regime(mesureTorque, rmpLow, rmpHigh, fuel);
		Throttle instance = new Throttle();
		instance.setId(12);
		Throttle.setId(12);
		Throttle.setPercentage(rmpHigh);

		instance.setPercentage(rmpHigh);
		List<Regime> regimes = new ArrayList<Regime>();
		regimes.add(regime);
		instance.setRegimes(regimes);
		Throttle.setRegimes(regimes);
		int expResult = 0;
		int result = instance.compareTo(Throttle);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.

	}

}
