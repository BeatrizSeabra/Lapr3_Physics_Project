/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Legacy;

import java.util.List;
import javax.swing.filechooser.FileFilter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author valhalla
 */
public class ImportTest {

	public ImportTest() {
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
	 * Test of getExtension method, of class Import.
	 */
	@Test
	public void testGetExtension() {
		System.out.println("getExtension");
		Import instance = new ImportImpl();
		String expResult = "";
		String result = instance.getExtension();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getExtensionDescription method, of class Import.
	 */
	@Test
	public void testGetExtensionDescription() {
		System.out.println("getExtensionDescription");
		Import instance = new ImportImpl();
		String expResult = "";
		String result = instance.getExtensionDescription();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getExtensionFilter method, of class Import.
	 */
	@Test
	public void testGetExtensionFilter() {
		System.out.println("getExtensionFilter");
		Import instance = new ImportImpl();
		FileFilter expResult = null;
		FileFilter result = instance.getExtensionFilter();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of importData method, of class Import.
	 */
	@Test
	public void testImportData() {
		System.out.println("importData");
		String data = "";
		Import instance = new ImportImpl();
		List expResult = null;
		List result = instance.importData(data);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	public class ImportImpl implements Import {

		public String getExtension() {
			return "";
		}

		public String getExtensionDescription() {
			return "";
		}

		public FileFilter getExtensionFilter() {
			return null;
		}

		public List<T> importData(String data) {
			return null;
		}
	}

	public class ImportImpl implements Import {

		public String getExtension() {
			return "";
		}

		public String getExtensionDescription() {
			return "";
		}

		public FileFilter getExtensionFilter() {
			return null;
		}

		public List<T> importData(String data) {
			return null;
		}
	}

}
