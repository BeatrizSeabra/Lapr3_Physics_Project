/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Legacy;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author ruben
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
		System.out.println("export");
		String text = "PROJECT";
		ExportHTML instance = new ExportHTML();
		String expResult = "<!DOCTYPE> <html>   <head>       <title>Project LAPR3</title>       <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">       <link rel=\"icon\" type=\"image/ico\" href=\"http://www.isep.ipp.pt/favicon.ico\">   </head>   <body>       <div align=\"center\">       <img src=\"http://www.dei.isep.ipp.pt/images/topo_index.png\" alt=\"Logotipo ISEP\" >       </div>" + " <div align=\"center\">  " + text + "   </div>" + "</body></html>";
		String result = instance.export(text);
		assertEquals(expResult, result);

	}

}
