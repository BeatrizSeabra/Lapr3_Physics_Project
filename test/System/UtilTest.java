/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class UtilTest {

	public UtilTest() {
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
	 * Test of toString method, of class Util.
	 */
	@Test
	public void testToString() {
		System.out.println("toString");
		Date date = new Date(1999-1900,0,01);
		String expResult = "01/01/1999";
		String result = Util.toString(date);
		assertEquals(expResult, result);
	}

	/**
	 * Test of toDate method, of class Util.
	 */
	@Test
	public void testToDate() {
		System.out.println("toDate");
		String date = "01/01/1999";
		Date expResult = new Date(1999-1900,0,1);
		Date result = Util.toDate(date);
		assertEquals(expResult, result);
	}

	/**
	 * Test of toDouble method, of class Util.
	 */
	@Test
	public void testToDouble() {
		System.out.println("toDouble");
		String string = "5.6";
		Double expResult = 5.6;
		Double result = Util.toDouble(string);
		assertEquals(expResult, result);
	}

	/**
	 * Test of toInteger method, of class Util.
	 */
	@Test
	public void testToInteger() {
		System.out.println("toInteger");
		String string = "5";
		Integer expResult = 5;
		Integer result = Util.toInteger(string);
		assertEquals(expResult, result);
	}

	/**
	 * Test of toValue method, of class Util.
	 */
	@Test
	public void testToValue() {
		System.out.println("toValue");
		String string = "5.6";
		Double expResult = 5.6;
		Double result = Util.toValue(string);
		assertEquals(expResult, result);
	}

	/**
	 * Test of toUnit method, of class Util.
	 */
	@Test
	public void testToUnit() {
		System.out.println("toUnit");
		String string = "km/h";
		String result = Util.toUnit(string);
		assertEquals(string, result);
	}

}
