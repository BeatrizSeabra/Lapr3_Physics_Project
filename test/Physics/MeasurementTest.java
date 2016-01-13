/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Physics;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author valhalla
 */
public class MeasurementTest {

	public MeasurementTest() {
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
	 * Test of getScalesMeasuresFilePath method, of class Measurement.
	 */
	@Test
	public void testGetScalesMeasuresFilePath() {
		System.out.println("getScalesMeasuresFilePath");
		String expResult = "";
		String result = Measurement.getScalesMeasuresFilePath();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of convert method, of class Measurement.
	 */
	@Test
	public void testConvert() {
		System.out.println("convert");
		Measure measure = null;
		String unit = "";
		Measure expResult = null;
		Measure result = Measurement.convert(measure, unit);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of sum method, of class Measurement.
	 */
	@Test
	public void testSum() {
		System.out.println("sum");
		Measure measureA = null;
		Measure measureB = null;
		Measure expResult = null;
		Measure result = Measurement.sum(measureA, measureB);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of minus method, of class Measurement.
	 */
	@Test
	public void testMinus() {
		System.out.println("minus");
		Measure measureA = null;
		Measure measureB = null;
		Measure expResult = null;
		Measure result = Measurement.minus(measureA, measureB);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of neg method, of class Measurement.
	 */
	@Test
	public void testNeg() {
		System.out.println("neg");
		Measure measure = null;
		Measure expResult = null;
		Measure result = Measurement.neg(measure);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of module method, of class Measurement.
	 */
	@Test
	public void testModule() {
		System.out.println("module");
		Measure measure = null;
		Measure expResult = null;
		Measure result = Measurement.module(measure);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

}
