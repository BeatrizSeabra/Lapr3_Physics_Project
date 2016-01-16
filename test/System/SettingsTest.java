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
 * @author LAPR3_20152016_G27
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
		String expResult = "settings.properties";
		String result = Settings.getSettingsFilePath();
		assertEquals(expResult, result);

	}

	/**
	 * Test of setSettingsFilePath method, of class Settings.
	 */
	@Test
	public void testSetSettingsFilePath() {
		System.out.println("setSettingsFilePath");
		String expResult = "settings.properties";
		Settings.setSettingsFilePath(expResult);
		assertEquals(expResult, Settings.getSettingsFilePath());
	}

	/**
	 * Test of getOption method, of class Settings.
	 */
	@Test
	public void testGetOption() {
		System.out.println("getOption");
		String key = "RoadNetworkImportClass";
		String expResult = "Legacy.RoadNetworkImportXML";
		String result = Settings.getOption(key);
		assertEquals(expResult, result);

	}

	/**
	 * Test of getOptions method, of class Settings.
	 */
	@Test
	public void testGetOptions() {
		System.out.println("getOptions");
		String key = "ExportClass";
		String[] expResult = {"Legacy.ExportHTML","Legacy.ExportCSV"};
		String[] result = Settings.getOptions(key);
		assertArrayEquals(expResult, result);
	}

	/**
	 * Test of loadClass method, of class Settings.
	 */
	@Test
	public void testLoadClass() {
		System.out.println("loadClass");
		String name = "Legacy.ExportHTML";
		Object result = Settings.loadClass(name);
		assertEquals(result!=null, true);
	}

	/**
	 * Test of loadAllClass method, of class Settings.
	 */
	@Test
	public void testLoadAllClass() {
		System.out.println("loadAllClass");
		String[] names = {"Legacy.ExportHTML", "Legacy.ExportCSV"};
		List result = Settings.loadAllClass(names);
		assertEquals(result.size(), 2);
	}

}
