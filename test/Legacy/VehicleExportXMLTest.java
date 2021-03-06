/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Legacy;

import Model.Regime;
import Model.Throttle;
import Model.Vehicle;
import Physics.Measure;
import System.Settings;
import java.util.ArrayList;
import java.util.List;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class VehicleExportXMLTest {

	private VehicleExportXML vehicleExportXML;
	private String filePathVehicles;
	private String dataXML;
	private List<Vehicle> vehicles;
	private Vehicle vehicle;

	public VehicleExportXMLTest() {

		Settings.setSettingsFilePath("test/Files/settingsTest.properties");
		this.vehicleExportXML = new VehicleExportXML();
		this.filePathVehicles = Settings.getOption("VehiclesFilePath");
		this.dataXML = Legacy.readFile(this.filePathVehicles);

		Throttle throttle1 = new Throttle();
		throttle1.setPercentage(new Measure(25.0, "%"));
		throttle1.
			addRegime(new Regime(new Measure(85.0, "Nm"), new Measure(1000.0, "rpm"), new Measure(2499.0, "rpm"), new Measure(8.2, "g/KWh")));
		throttle1.
			addRegime(new Regime(new Measure(95.0, "Nm"), new Measure(2500.0, "rpm"), new Measure(3999.0, "rpm"), new Measure(6.2, "g/KWh")));
		throttle1.
			addRegime(new Regime(new Measure(80.0, "Nm"), new Measure(4000.0, "rpm"), new Measure(5500.0, "rpm"), new Measure(10.2, "g/KWh")));
		Throttle throttle2 = new Throttle();
		throttle2.setPercentage(new Measure(50.0, "%"));
		throttle2.
			addRegime(new Regime(new Measure(135.0, "Nm"), new Measure(1000.0, "rpm"), new Measure(2499.0, "rpm"), new Measure(5.2, "g/KWh")));
		throttle2.
			addRegime(new Regime(new Measure(150.0, "Nm"), new Measure(2500.0, "rpm"), new Measure(3999.0, "rpm"), new Measure(3.2, "g/KWh")));
		throttle2.
			addRegime(new Regime(new Measure(140.0, "Nm"), new Measure(4000.0, "rpm"), new Measure(5500.0, "rpm"), new Measure(8.2, "g/KWh")));
		Throttle throttle3 = new Throttle();
		throttle3.setPercentage(new Measure(100.0, "%"));
		throttle3.
			addRegime(new Regime(new Measure(200.0, "Nm"), new Measure(1000.0, "rpm"), new Measure(2499.0, "rpm"), new Measure(2.2, "g/KWh")));
		throttle3.
			addRegime(new Regime(new Measure(240.0, "Nm"), new Measure(2500.0, "rpm"), new Measure(3999.0, "rpm"), new Measure(1.2, "g/KWh")));
		throttle3.
			addRegime(new Regime(new Measure(190.0, "Nm"), new Measure(4000.0, "rpm"), new Measure(5500.0, "rpm"), new Measure(4.2, "g/KWh")));
		this.vehicle = new Vehicle();
		this.vehicle.setId(1);
		this.vehicle.setName("Dummy01");
		this.vehicle.setDescription("Dummy teste vehicle");
		this.vehicle.setType("car");
		this.vehicle.setMotorization("combustion");
		this.vehicle.setFuel("gasoline");
		this.vehicle.setMass(new Measure(1400.0, "Kg"));
		this.vehicle.setLoad(new Measure(120.0, "kg"));
		this.vehicle.setDragCoefficient(new Measure(0.35, "ratio"));
		this.vehicle.setFrontalArea(new Measure(1.8, "m2"));
		this.vehicle.setRollingRCoefficient(new Measure(0.01, "ratio"));
		this.vehicle.setWheelSize(new Measure(0.5, "m"));
		this.vehicle.getVelocityLimits().
			put("Highway", new Measure(100.0, "km/h"));
		this.vehicle.setMinRPM(new Measure(1000.0, "rpm"));
		this.vehicle.setMaxRPM(new Measure(5500.0, "rpm"));
		this.vehicle.setFinalDriveRatio(new Measure(2.6, "ratio"));
		this.vehicle.getGears().put(01, new Measure(3.5, "ratio"));
		this.vehicle.getGears().put(02, new Measure(2.5, "ratio"));
		this.vehicle.getGears().put(03, new Measure(1.25, "ratio"));
		this.vehicle.getGears().put(04, new Measure(0.9, "ratio"));
		this.vehicle.getGears().put(04, new Measure(0.9, "ratio"));
		this.vehicle.addThrottle(throttle1);
		this.vehicle.addThrottle(throttle2);
		this.vehicle.addThrottle(throttle3);
		this.vehicles = new ArrayList();
		this.vehicles.add(vehicle);
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
	 * Test of getExtension method, of class SimulationExportXML.
	 */
	@Test
	public void testGetExtension() {
		System.out.println("testGetExtension");
		assertEquals(this.vehicleExportXML.getExtension(), "xml");
	}

	/**
	 * Test of getExtensionDescription method, of class SimulationExportXML.
	 */
	@Test
	public void testGetExtensionDescription() {
		System.out.println("testGetExtensionDescription");
		assertEquals(this.vehicleExportXML.getExtensionDescription(), "XML Documents (*.xml)");
	}

	/**
	 * Test of getExtensionFilter method, of class SimulationExportXML.
	 */
	@Test
	public void testGetExtensionFilter() {
		System.out.println("testGetExtensionFilter");
		FileNameExtensionFilter result = this.vehicleExportXML.
			getExtensionFilter();
		FileNameExtensionFilter expResult = new FileNameExtensionFilter("XML Documents (*.xml)", "xml");
		assertEquals(result.getDescription(), expResult.getDescription());
		assertArrayEquals(result.getExtensions(), expResult.getExtensions());
	}

	/**
	 * Test of export method, of class SimulationExportXML.
	 */
	@Test
	public void testExport() {
		System.out.println("testExport");
		String result = this.vehicleExportXML.export(this.vehicle).
			replaceAll("\\s+", "");
		assertEquals((result.length()>0), true);
	}

}
