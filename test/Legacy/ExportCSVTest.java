/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Legacy;

import javax.swing.filechooser.FileNameExtensionFilter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author valhalla
 */
public class ExportCSVTest {

	public ExportCSVTest() {
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
	 * Test of getExtension method, of class ExportCSV.
	 */
	@Test
	public void testGetExtension() {
		System.out.println("getExtension");
		ExportCSV instance = new ExportCSV();
		String expResult = "";
		String result = instance.getExtension();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getExtensionDescription method, of class ExportCSV.
	 */
	@Test
	public void testGetExtensionDescription() {
		System.out.println("getExtensionDescription");
		ExportCSV instance = new ExportCSV();
		String expResult = "";
		String result = instance.getExtensionDescription();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getExtensionFilter method, of class ExportCSV.
	 */
	@Test
	public void testGetExtensionFilter() {
		System.out.println("getExtensionFilter");
		ExportCSV instance = new ExportCSV();
		FileNameExtensionFilter expResult = null;
		FileNameExtensionFilter result = instance.getExtensionFilter();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of export method, of class ExportCSV.
	 */
	@Test
	public void testExport() {
		System.out.println("export");
		Object data = null;
		ExportCSV instance = new ExportCSV();
		String expResult = "";
		String result = instance.export(data);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

}
