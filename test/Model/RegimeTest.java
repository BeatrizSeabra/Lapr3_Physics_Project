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
		Regime instance = new Regime();
		Regime expResult = this.regime.clone();
		Regime result = instance.clone();
		assertEquals(expResult, result);

	}

	/**
	 * Test of compareTo method, of class Regime.
	 */
	@Test
	public void testCompareTo() {
		System.out.println("compareTo");

		Regime o = new Regime();

		Measure mea = new Measure(30.1, "teste4");
		this.regime.setRpmHigh(mea);

		int result = this.regime.compareTo(o);
		int expResult = 1;

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

}
