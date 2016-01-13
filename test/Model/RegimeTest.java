/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Physics.Measure;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author ruben
 */
public class RegimeTest {

	private Regime regime;

	public RegimeTest() {

		this.regime = new Regime();
		this.regime.setFuelConsumption(new Measure(2.0, "teste"));
		this.regime.setRpmHigh(new Measure(3.0, "teste2"));
		this.regime.setRpmLow(new Measure(4.0, "teste3"));
		this.regime.setTorque(new Measure(6.0, "teste4"));

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
	 * Test of getTorque method, of class Regime.
	 */
	@Test
	public void testSetGetTorque() {
		System.out.println("testSetGetTorque");
		Measure expResult = new Measure(12.0, "teste1");
		this.regime.setTorque(expResult);
		assertEquals(expResult, this.regime.getTorque());
	}

	/**
	 * Test of getRpmLow method, of class Regime.
	 */
	@Test
	public void testSetGetRpmLow() {
		System.out.println("testSetGetRpmLow");
		Measure expResult = new Measure(26.0, "teste2");
		this.regime.setRpmLow(expResult);

		assertEquals(expResult, this.regime.getRpmLow());

	}

	/**
	 * Test of getRpmHigh method, of class Regime.
	 */
	@Test
	public void testSetGetRpmHigh() {
		System.out.println("testSetGetRpmHigh");

		Measure expResult = new Measure(28.1, "teste3");
		this.regime.setRpmHigh(expResult);
		assertEquals(expResult, this.regime.getRpmHigh());

	}

	/**
	 * Test of getFuelConsumption method, of class Regime.
	 */
	@Test
	public void testSetGetFuelConsumption() {
		System.out.println("testSetGetFuelConsumption");
		Measure expResult = new Measure(30.1, "teste4");
		this.regime.setFuelConsumption(expResult);

		assertEquals(expResult, this.regime.getFuelConsumption());

	}

	/**
	 * Test of equals method, of class Regime.
	 */
	@Test
	public void testEquals() {
		System.out.println("testEquals");

		this.regime.setFuelConsumption(new Measure(2.0, "teste"));
		this.regime.setRpmHigh(new Measure(3.0, "teste2"));
		this.regime.setRpmLow(new Measure(4.0, "teste3"));
		this.regime.setTorque(new Measure(6.0, "teste4"));
		assertEquals(true, this.regime.equals(regime));

	}

	/**
	 * Test of hashCode method, of class Regime.
	 */
	@Test
	public void testHashCode() {
		System.out.println("testHashCode");
		Integer expResult = 29 * this.regime.getClass().hashCode();
		expResult += 11 * this.regime.getFuelConsumption().hashCode();
		expResult += 11 * this.regime.getRpmHigh().hashCode();
		expResult += 11 * this.regime.getRpmLow().hashCode();
		expResult += 11 * this.regime.getTorque().hashCode();
		Integer result = this.regime.hashCode();
		assertEquals(expResult, result);
	}

	/**
	 * Test of clone method, of class Regime.
	 */
	@Test
	public void testClone() {
		System.out.println("clone");

		Measure mesureTorque = new Measure(2.0, "teste");
		Measure rmpLow = new Measure(4.0, "teste3");
		Measure rmpHigh = new Measure(3.0, "teste2");
		Measure fuel = new Measure(6.0, "teste4");
		Regime regime = new Regime(mesureTorque, rmpLow, rmpHigh, fuel);

		Regime expResult = this.regime.clone();

		assertEquals(expResult, this.regime);

	}

	/**
	 * Test of compareTo method, of class Regime.
	 */
	@Test
	public void testCompareTo() {
		System.out.println("compareTo");

		Measure mesureTorque = new Measure(2.0, "teste");
		Measure rmpLow = new Measure(4.0, "teste3");
		Measure rmpHigh = new Measure(3.0, "teste2");
		Measure fuel = new Measure(6.0, "teste4");
		Regime regime = new Regime(mesureTorque, rmpLow, rmpHigh, fuel);

		int result = this.regime.compareTo(regime);
		int expResult = 0;

		assertEquals(expResult, result);

	}

	/**
	 * Test of equals method, of class Section.
	 */
	@Test
	public void testEqualsFalseNull() {
		System.out.println("testEqualsFalseNull");
		Boolean result = this.regime.equals(null);
		Boolean expResult = false;
		assertEquals(expResult, result);
	}

	/**
	 * Test of equals method, of class Section.
	 */
	@Test
	public void testEqualsFalseClass() {
		System.out.println("testEqualsFalseClass");
		Boolean result = this.regime.equals(new String());
		Boolean expResult = false;
		assertEquals(expResult, result);
	}

	/**
	 * Test of getTorque method, of class Regime.
	 */
	@Test
	public void testGetTorque() {
		System.out.println("getTorque");
		Regime instance = new Regime();
		Measure expResult = null;
		Measure result = instance.getTorque();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setTorque method, of class Regime.
	 */
	@Test
	public void testSetTorque() {
		System.out.println("setTorque");
		Measure torque = null;
		Regime instance = new Regime();
		instance.setTorque(torque);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getRpmLow method, of class Regime.
	 */
	@Test
	public void testGetRpmLow() {
		System.out.println("getRpmLow");
		Regime instance = new Regime();
		Measure expResult = null;
		Measure result = instance.getRpmLow();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setRpmLow method, of class Regime.
	 */
	@Test
	public void testSetRpmLow() {
		System.out.println("setRpmLow");
		Measure rpmLow = null;
		Regime instance = new Regime();
		instance.setRpmLow(rpmLow);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getRpmHigh method, of class Regime.
	 */
	@Test
	public void testGetRpmHigh() {
		System.out.println("getRpmHigh");
		Regime instance = new Regime();
		Measure expResult = null;
		Measure result = instance.getRpmHigh();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setRpmHigh method, of class Regime.
	 */
	@Test
	public void testSetRpmHigh() {
		System.out.println("setRpmHigh");
		Measure rpmHigh = null;
		Regime instance = new Regime();
		instance.setRpmHigh(rpmHigh);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getFuelConsumption method, of class Regime.
	 */
	@Test
	public void testGetFuelConsumption() {
		System.out.println("getFuelConsumption");
		Regime instance = new Regime();
		Measure expResult = null;
		Measure result = instance.getFuelConsumption();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setFuelConsumption method, of class Regime.
	 */
	@Test
	public void testSetFuelConsumption() {
		System.out.println("setFuelConsumption");
		Measure espFuelConsumption = null;
		Regime instance = new Regime();
		instance.setFuelConsumption(espFuelConsumption);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

}
