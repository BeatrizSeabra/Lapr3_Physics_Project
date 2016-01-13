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
 * @author valhalla
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
		Date date = null;
		String expResult = "";
		String result = Util.toString(date);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of toDate method, of class Util.
	 */
	@Test
	public void testToDate() {
		System.out.println("toDate");
		String date = "";
		Date expResult = null;
		Date result = Util.toDate(date);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of toDouble method, of class Util.
	 */
	@Test
	public void testToDouble() {
		System.out.println("toDouble");
		String string = "";
		Double expResult = null;
		Double result = Util.toDouble(string);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of toInteger method, of class Util.
	 */
	@Test
	public void testToInteger() {
		System.out.println("toInteger");
		String string = "";
		Integer expResult = null;
		Integer result = Util.toInteger(string);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of toValue method, of class Util.
	 */
	@Test
	public void testToValue() {
		System.out.println("toValue");
		String string = "";
		Double expResult = null;
		Double result = Util.toValue(string);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of toUnit method, of class Util.
	 */
	@Test
	public void testToUnit() {
		System.out.println("toUnit");
		String string = "";
		String expResult = "";
		String result = Util.toUnit(string);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

}
