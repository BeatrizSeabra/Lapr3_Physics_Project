/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Legacy;

import javax.swing.filechooser.FileFilter;
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
public class ExportTest {

	public ExportTest() {
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
	 * Test of getExtension method, of class Export.
	 */
	@Test
	public void testGetExtension() {
		System.out.println("getExtension");
		Export instance = new ExportImpl();
		String expResult = "";
		String result = instance.getExtension();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getExtensionDescription method, of class Export.
	 */
	@Test
	public void testGetExtensionDescription() {
		System.out.println("getExtensionDescription");
		Export instance = new ExportImpl();
		String expResult = "";
		String result = instance.getExtensionDescription();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getExtensionFilter method, of class Export.
	 */
	@Test
	public void testGetExtensionFilter() {
		System.out.println("getExtensionFilter");
		Export instance = new ExportImpl();
		FileFilter expResult = null;
		FileFilter result = instance.getExtensionFilter();
		assertEquals(expResult, result);
	}

	/**
	 * Test of export method, of class Export.
	 */
	@Test
	public void testExport() {
		System.out.println("export");
		Object data = null;
		Export instance = new ExportImpl();
		String expResult = "";
		String result = instance.export(data);
		assertEquals(expResult, result);
	}

	public class ExportImpl implements Export {

		public String getExtension() {
			return "";
		}

		public String getExtensionDescription() {
			return "";
		}

		public FileFilter getExtensionFilter() {
			return null;
		}

		public String export(Object data) {
			return "";
		}
	}
}