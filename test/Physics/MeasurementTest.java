/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Physics;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
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
		String expResult = "files/scalesMeasures.csv";
		String result = Measurement.getScalesMeasuresFilePath();
		assertEquals(expResult, result);

	}

	/**
	 * Test of convert method, of class Measurement.
	 */
	@Test
	public void testConvert() {
		System.out.println("convert");
		Measure measure = new Measure(22.2, "ratio");
		String unit = "ratio";
		Measure expResult = new Measure(22.2, "ratio");
		Measure result = Measurement.convert(measure, unit);
		assertEquals(expResult, result);
	}

	/**
	 * Test of sum method, of class Measurement.
	 */
	@Test
	public void testSum() {
		System.out.println("sum");
		Measure measureA = new Measure(22.1, "ratio");
		Measure measureB = new Measure(11.1, "ratio");
		Measure expResult = new Measure(33.20, "ratio");
		Measure result = Measurement.sum(measureA, measureB);
		assertEquals(expResult, result);
	}

	/**
	 * Test of minus method, of class Measurement.
	 */
	@Test
	public void testMinus() {
		System.out.println("minus");
		Measure measureA = new Measure(11.1, "ratio");
		Measure measureB = new Measure(8.09, "ratio");
		Measure expResult = new Measure(3.01, "ratio");
		Measure result = Measurement.minus(measureA, measureB);
		assertEquals(expResult, result);
	}

	/**
	 * Test of neg method, of class Measurement.
	 */
	@Test
	public void testNeg() {
		System.out.println("neg");
		Measure measure = new Measure(2.2, "ratio");
		Measure expResult = new Measure(-2.20, "ratio");
		Measure result = Measurement.neg(measure);
		assertEquals(expResult, result);
	}

	/**
	 * Test of module method, of class Measurement.
	 */
	@Test
	public void testModule() {
		System.out.println("module");
		Measure measure = new Measure(12.2, "ratio");
		Measure expResult = new Measure(12.20, "ratio");
		Measure result = Measurement.module(measure);
		System.out.println(result.toString());
		assertEquals(expResult, result);
	}

}
