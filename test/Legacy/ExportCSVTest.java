/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Legacy;

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
		System.out.println("testGetExtension");
		ExportCSV instance = new ExportCSV();
		String expResult = "csv";
		String result = instance.getExtension();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getExtensionDescription method, of class ExportCSV.
	 */
	@Test
	public void testGetExtensionDescription() {
		System.out.println("testGetExtensionDescription");
		ExportCSV instance = new ExportCSV();
		String expResult = "CSV Documents (*.csv)";
		String result = instance.getExtensionDescription();
		assertEquals(expResult, result);
	}

	/**
	 * Test of export method, of class ExportCSV.
	 */
	@Test
	public void testExport() {
		System.out.println("testExport");
		System.out.println("testExport");
		List<String[]> text = new ArrayList();
		text.add("1;2;3".split(";"));
		text.add("4;5;6".split(";"));
		text.add("7;8;9".split(";"));
		String expResult = "1;2;3\n"
			+ "4;5;6\n"
			+ "7;8;9\n";
		ExportCSV instance = new ExportCSV();
		String result = instance.export(text);
		assertEquals(expResult, result);
	}

}
