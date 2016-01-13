/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Legacy;

import java.util.ArrayList;
import java.util.List;
import javax.swing.filechooser.FileNameExtensionFilter;
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
public class ExportHTMLTest {

	public ExportHTMLTest() {
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
	 * Test of export method, of class ExportHTML.
	 */
	@Test
	public void testExport() {
		System.out.println("testExport");
		List<String[]> text = new ArrayList();
		text.add("1;2;3".split(";"));
		text.add("4;5;6".split(";"));
		text.add("7;8;9".split(";"));
		String expResult = "<!DOCTYPE html><html>    <head>        <title>            Export File HTML        </title>\n"
			+ "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">        <link rel=\"icon\" type=\"image/ico\" href=\"http://www.isep.ipp.pt/favicon.ico\">    </head>    <body>        <div>            <img src=\"http://www.dei.isep.ipp.pt/images/topo_index.png\" alt=\"Logotipo ISEP\">        </div>        <hr>        <div>            <TABLE>                <TR>                    <TD align='center'>&nbsp;1&nbsp;</TD>                    <TD align='center'>&nbsp;2&nbsp;</TD>                    <TD align='center'>&nbsp;3&nbsp;</TD>                </TR>                <TR>                    <TD align='center'>&nbsp;4&nbsp;</TD>                    <TD align='center'>&nbsp;5&nbsp;</TD>                    <TD align='center'>&nbsp;6&nbsp;</TD>                </TR>                <TR>                    <TD align='center'>&nbsp;7&nbsp;</TD>                    <TD align='center'>&nbsp;8&nbsp;</TD>                    <TD align='center'>&nbsp;9&nbsp;</TD>                </TR>            </TABLE>            <br>        </div>        <hr>    </body></html>";
		ExportHTML instance = new ExportHTML();
		String result = instance.export(text);
		assertEquals(expResult, result);

	}

	/**
	 * Test of getExtension method, of class ExportHTML.
	 */
	@Test
	public void testGetExtension() {
		System.out.println("getExtension");
		ExportHTML instance = new ExportHTML();
		String expResult = "";
		String result = instance.getExtension();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getExtensionDescription method, of class ExportHTML.
	 */
	@Test
	public void testGetExtensionDescription() {
		System.out.println("getExtensionDescription");
		ExportHTML instance = new ExportHTML();
		String expResult = "";
		String result = instance.getExtensionDescription();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getExtensionFilter method, of class ExportHTML.
	 */
	@Test
	public void testGetExtensionFilter() {
		System.out.println("getExtensionFilter");
		ExportHTML instance = new ExportHTML();
		FileNameExtensionFilter expResult = null;
		FileNameExtensionFilter result = instance.getExtensionFilter();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

}
