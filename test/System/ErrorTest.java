/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

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
public class ErrorTest {

	public ErrorTest() {
		Settings.setSettingsFilePath("test/Files/settingsTest.properties");
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
	 * Test of getLogFilePath method, of class Error.
	 */
	@Test
	public void testGetLogFilePath() {
		System.out.println("testGetLogFilePath");
		String expResult = "test/Files/logTest.txt";
		String result = Error.getLogFilePath();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setErrorMessage and getErrorMessage method, of class Error.
	 */
	@Test
	public void testSetGetErrorMessage() {
		System.out.println("testSetGetErrorMessage");
		Error.clearLog();
		String errorMessage = "testSetGetErrorMessage";
		Error.setErrorMessage(errorMessage);
		assertEquals(Error.getErrorMessage(), errorMessage);
	}

	/**
	 * Test of log method, of class Error.
	 */
	@Test
	public void testLog_String() {
		System.out.println("testLog_String");
		String menssege = "test";
		Error.clearLog();
		Error.log(menssege);
		assertEquals(Error.log().contains(menssege), true);
	}

	/**
	 * Test of clearLog method, of class Error.
	 */
	@Test
	public void testClearLog() {
		System.out.println("testClearLog");
		Error.log("test");
		Error.clearLog();
		assertEquals(Error.log(), " ");
	}

	/**
	 * Test of setErrorMessage method, of class Error.
	 */
	@Test
	public void testSetErrorMessage() {
		System.out.println("setErrorMessage");
		String expResult = "Error";

		Error.setErrorMessage(expResult);
		assertEquals(expResult, Error.getErrorMessage());
	}

	/**
	 * Test of getErrorMessage method, of class Error.
	 */
	@Test
	public void testGetErrorMessage() {
		System.out.println("getErrorMessage");
		String expResult = "Error";
		String result = Error.getErrorMessage();
		assertEquals(expResult, result);

	}

	/**
	 * Test of log method, of class Error.
	 */
	@Test
	public void testLog_0args() {
		System.out.println("log");
		String menssege = "test";

		Error.clearLog();
		Error.log(menssege);
		assertEquals(Error.log().contains(menssege), true);

	}

}
