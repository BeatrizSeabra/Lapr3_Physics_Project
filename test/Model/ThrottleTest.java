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
        private Throttle throttle;
        private Regime regime;
        
	public ThrottleTest() {
            this.throttle = new Throttle();
            this.throttle.setId(12);
            Measure mesureTorque = new Measure(12.2, "MeasureTorque");
            Measure rmpLow = new Measure(1.2, "MeasureTorque");
            Measure rmpHigh = new Measure(12.2, "MeasureTorque");
            Measure fuel = new Measure(12.2, "MeasureTorque");
            this.regime = new Regime(mesureTorque, rmpLow, rmpHigh, fuel);
            this.throttle.addRegime(this.regime);
            Measure result = new Measure(12.2, "X");
            this.throttle.setPercentage(result);
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
		Boolean expResult = true;
		assertEquals(this.throttle.addRegime(this.regime), expResult);
	}

	/**
	 * Test of getId method, of class Throttle.
	 */
	@Test
	public void testGetId() {
		System.out.println("getId");
		Integer expResult = 12;
                this.throttle.setId(expResult);
		assertEquals(this.throttle.getId(),expResult);
	}

	/**
	 * Test of setId method, of class Throttle.
	 */
	@Test
	public void testSetId() {
		System.out.println("setId");
		Integer result = 12;
		this.throttle.setId(result);
		assertEquals(this.throttle.getId(), result);
	}

	/**
	 * Test of getPercentage method, of class Throttle.
	 */
	@Test
	public void testGetPercentage() {
		System.out.println("getPercentage");
		Measure expResult = new Measure(12.2, "X");
		this.throttle.setPercentage(expResult);
		assertEquals(this.throttle.getPercentage(),expResult);
	}

	/**
	 * Test of setPercentage method, of class Throttle.
	 */
	@Test
	public void testSetPercentage() {
		System.out.println("setPercentage");
		Measure result = new Measure(12.2, "X");
		this.throttle.setPercentage(result);
		assertEquals(this.throttle.getPercentage(), result);
	}

	/**
	 * Test of getRegimes method, of class Throttle.
	 */
	@Test
	public void testGetRegimes() {
                System.out.println("getRegimes");
                assertEquals(this.throttle.getRegimes().size(),1);
		Measure mesureTorque = new Measure(12.2, "MeasureTorque");
		Measure rmpLow = new Measure(1.2, "MeasureTorque");
		Measure rmpHigh = new Measure(12.2, "MeasureTorque");
		Measure fuel = new Measure(12.2, "MeasureTorque");
		Regime regimeB = new Regime(mesureTorque, rmpLow, rmpHigh, fuel);
		this.throttle.addRegime(regime);
                assertEquals(this.throttle.getRegimes().size(),2);
	}

	/**
	 * Test of setRegimes method, of class Throttle.
	 */
	@Test
	public void testSetRegimes() {
                System.out.println("setRegimes");
		Measure mesureTorque = new Measure(12.2, "MeasureTorque");
		Measure rmpLow = new Measure(1.2, "MeasureTorque");
		Measure rmpHigh = new Measure(12.2, "MeasureTorque");
		Measure fuel = new Measure(12.2, "MeasureTorque");
		Regime regime1 = new Regime(mesureTorque, rmpLow, rmpHigh, fuel);
		List<Regime> regimes = new ArrayList<Regime>();
		regimes.add(regime1);
		this.throttle.setRegimes(regimes);
		assertEquals(regimes, this.throttle.getRegimes());
	}

	/**
	 * Test of equals method, of class Throttle.
	 */
	@Test
	public void testEquals() {
		System.out.println("equals");
		Throttle instance1 = new Throttle();
		Throttle instance2 = this.throttle.clone();
		instance1.setId(20);
		Measure mesureTorque = new Measure(1.2, "MeasureTorque");
		Measure rmpLow = new Measure(1.2, "MeasureTorque");
		Measure rmpHigh = new Measure(1.2, "MeasureTorque");
		Measure fuel = new Measure(1.2, "MeasureTorque");
		instance1.setPercentage(mesureTorque);
		Regime regime1 = new Regime(mesureTorque, rmpLow, rmpHigh, fuel);
		instance1.addRegime(regime1);
		boolean expResult = true;
                assertEquals(this.throttle.equals(instance2),expResult);
                expResult = false;
                assertEquals(this.throttle.equals(instance1),expResult);
                this.throttle.addRegime(regime1);
                assertEquals(this.throttle.equals(instance2),expResult);
                
	}

	/**
	 * Test of hashCode method, of class Throttle.
	 */
	@Test
	public void testHashCode() {
		System.out.println("hashCode");
		int expResult = 29 * this.throttle.getClass().hashCode();
		expResult += 11 * this.throttle.getId().hashCode();
		expResult += 11 * this.throttle.getPercentage().hashCode();
		for (Regime regime1 : this.throttle.getRegimes()) {
			expResult += 11 * regime1.hashCode();
		}
		assertEquals(expResult, this.throttle.hashCode());
	}

	/**
	 * Test of clone method, of class Throttle.
	 */
	@Test
	public void testClone() {
		System.out.println("clone");
		Throttle result = this.throttle.clone();
		assertEquals(this.throttle, result);
	}

	/**
	 * Test of compareTo method, of class Throttle.
	 */
	@Test
	public void testCompareTo() {
		System.out.println("compareTo");
		Throttle instance = new Throttle();
		Measure mesureTorque = new Measure(20.0, "MeasureTorque");
		Measure rmpLow = new Measure(21.2, "MeasureTorque");
		Measure rmpHigh = new Measure(30.2, "MeasureTorque");
		Measure fuel = new Measure(20.2, "MeasureTorque");
		Regime reg = new Regime(mesureTorque, rmpLow, rmpHigh, fuel);
		instance.setId(9);
		instance.setPercentage(this.throttle.getPercentage());
		int expResult = 0;
		assertEquals(expResult, this.throttle.compareTo(instance));
	}

}
