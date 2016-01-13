/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author valhalla
 */
public class SettingsTest {

	public SettingsTest() {
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
	 * Test of getSettingsFilePath method, of class Settings.
	 */
	@Test
	public void testGetSettingsFilePath() {
		System.out.println("getSettingsFilePath");
		String expResult = "";
		String result = Settings.getSettingsFilePath();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setSettingsFilePath method, of class Settings.
	 */
	@Test
	public void testSetSettingsFilePath() {
		System.out.println("setSettingsFilePath");
		String filePath = "";
		Settings.setSettingsFilePath(filePath);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getOption method, of class Settings.
	 */
	@Test
	public void testGetOption() {
		System.out.println("getOption");
		String key = "";
		String expResult = "";
		String result = Settings.getOption(key);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getOptions method, of class Settings.
	 */
	@Test
	public void testGetOptions() {
		System.out.println("getOptions");
		String key = "";
		String[] expResult = null;
		String[] result = Settings.getOptions(key);
		assertArrayEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of loadClass method, of class Settings.
	 */
	@Test
	public void testLoadClass() {
		System.out.println("loadClass");
		String name = "";
		Object expResult = null;
		Object result = Settings.loadClass(name);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of loadAllClass method, of class Settings.
	 */
	@Test
	public void testLoadAllClass() {
		System.out.println("loadAllClass");
		String[] names = null;
		List expResult = null;
		List result = Settings.loadAllClass(names);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

}
