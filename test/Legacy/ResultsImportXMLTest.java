/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Legacy;

import Model.Drop;
import Model.Run;
import Model.Step;
import Physics.Measure;
import Simulation.FastestPathAnalysis;
import System.Settings;
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
public class ResultsImportXMLTest {

	private ResultsImportXML resultsImportXML;
	private String filePathResults;
	private String dataXML;
	private List<Run> runs;
	private Run run;
	private Step step1;
	private Step step2;
	private Step step3;
	private Drop drop1;
	private Drop drop2;

	public ResultsImportXMLTest() {
		Settings.setSettingsFilePath("test/Files/settingsTest.properties");
		this.resultsImportXML = new ResultsImportXML();
		this.filePathResults = Settings.getOption("ResultsFilePath");
		this.dataXML = Legacy.readFile(this.filePathResults);

		this.step1 = new Step();
		this.step1.setVehicle("Dummy01");
		this.step1.setNodeStart("N2");
		this.step1.setNodeEnd("N4");
		this.step1.setRoad("A1");
		this.step1.setSegment("01");
		this.step1.setTimeEntry(new Measure(3.0, "s"));
		this.step1.setTimeOut(new Measure(3.0, "s"));
		this.step1.setCarPower(new Measure(9.0, "J/s"));
		this.step1.setCarSpeed(new Measure(9.0, "km/h"));
		this.step1.setSpeedRelative(new Measure(9.0, "km/h"));
		this.step1.setCarForce(new Measure(9.0, "N"));
		this.step1.setRollingForce(new Measure(9.0, "N"));
		this.step1.setAirForce(new Measure(9.0, "N"));
		this.step1.setGravityForce(new Measure(9.0, "N"));

		this.step2 = new Step();
		this.step2.setVehicle("Dummy01");
		this.step2.setNodeStart("N2");
		this.step2.setNodeEnd("N4");
		this.step2.setRoad("A1");
		this.step2.setSegment("02");
		this.step2.setTimeEntry(new Measure(3.0, "s"));
		this.step2.setTimeOut(new Measure(3.0, "s"));
		this.step2.setCarPower(new Measure(9.0, "J/s"));
		this.step2.setCarSpeed(new Measure(9.0, "km/h"));
		this.step2.setSpeedRelative(new Measure(9.0, "km/h"));
		this.step2.setCarForce(new Measure(9.0, "N"));
		this.step2.setRollingForce(new Measure(9.0, "N"));
		this.step2.setAirForce(new Measure(9.0, "N"));
		this.step2.setGravityForce(new Measure(9.0, "N"));

		this.step3 = new Step();
		this.step3.setVehicle("Dummy02");
		this.step3.setNodeStart("N1");
		this.step3.setNodeEnd("N2");
		this.step3.setRoad("A2");
		this.step3.setSegment("01");
		this.step3.setTimeEntry(new Measure(3.0, "s"));
		this.step3.setTimeOut(new Measure(3.0, "s"));
		this.step3.setCarPower(new Measure(9.0, "J/s"));
		this.step3.setCarSpeed(new Measure(9.0, "km/h"));
		this.step3.setSpeedRelative(new Measure(9.0, "km/h"));
		this.step3.setCarForce(new Measure(9.0, "N"));
		this.step3.setRollingForce(new Measure(9.0, "N"));
		this.step3.setAirForce(new Measure(9.0, "N"));
		this.step3.setGravityForce(new Measure(9.0, "N"));

		this.drop1 = new Drop();
		this.drop1.setVehicle("Dummy01");
		this.drop1.setNodeStart("N2");
		this.drop1.setNodeEnd("N4");
		this.drop1.setTime(new Measure(40.0, "s"));

		this.drop2 = new Drop();
		this.drop2.setVehicle("Dummy02");
		this.drop2.setNodeStart("N1");
		this.drop2.setNodeEnd("N2");
		this.drop2.setTime(new Measure(30.0, "s"));

		this.run = new Run();

		this.run.setName("Run01");
		this.run.setTime(new Measure(10.0, "s"));
		this.run.setTimeStep(new Measure(1.0, "s"));
		this.run.setMethod(new FastestPathAnalysis());
		this.run.setId(1);

		this.run.getSteps().add(this.step1);
		this.run.getSteps().add(this.step2);
		this.run.getSteps().add(this.step3);
		this.run.getDrops().add(this.drop1);
		this.run.getDrops().add(this.drop2);

		this.runs = new ArrayList();
		this.runs.add(this.run);

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
	 * Test of getExtension method, of class ResultsImportXML.
	 */
	@Test
	public void testGetExtension() {
		System.out.println("testGetExtension");
		ResultsImportXML instance = new ResultsImportXML();
		String expResult = "xml";
		String result = instance.getExtension();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getExtensionDescription method, of class ResultsImportXML.
	 */
	@Test
	public void testGetExtensionDescription() {
		System.out.println("testGetExtensionDescription");
		assertEquals(this.resultsImportXML.getExtensionDescription(), "XML Documents (*.xml)");
	}

	/**
	 * Test of importData method, of class ResultsImportXML.
	 */
	@Test
	public void testImportData() {
		System.out.println("testImportData");
		List<Run> expResult = this.runs;
		System.out.println("esperado: ");
		for (Run run : expResult) {
			System.out.println(run);
			List<Step> steps = run.getSteps();
			for (Step step : steps) {
				System.out.println(step);
			}
			List<Drop> drops = run.getDrops();
			for (Drop drop : drops) {
				System.out.println(drop);
			}
		}
		List<Run> result = this.resultsImportXML.importData(this.dataXML);
		result.get(0).setId(1);
		result.get(0).setName("Run01");
		result.get(0).setTime(new Measure(10.0, "s"));
		result.get(0).setTimeStep(new Measure(1.0, "s"));
		result.get(0).setMethod(new FastestPathAnalysis());
		System.out.println("Obtido: ");
		for (Run run : result) {
			System.out.println(run);
			List<Step> steps = run.getSteps();
			for (Step step : steps) {
				System.out.println(step);
			}
			List<Drop> drops = run.getDrops();
			for (Drop drop : drops) {
				System.out.println(drop);
			}
		}
		System.out.println(expResult.hashCode());
		System.out.println(result.hashCode());
		assertEquals(expResult, result);
	}

}
