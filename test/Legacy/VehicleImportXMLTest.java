/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Legacy;

import Model.Vehicle;
import Physics.Measure;
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
 * @author valhalla
 */
public class VehicleImportXMLTest {

	private VehicleImportXML vehicleImportXML;
	private String filePathVehicles;
	private String dataXML;
	private List<Vehicle> vehicles;
	private Vehicle vehicle;

	public VehicleImportXMLTest() {
		Settings.setSettingsFilePath("test/Files/settingsTest.properties");
		this.vehicleImportXML = new VehicleImportXML();
		this.filePathVehicles = Settings.getOption("VehiclesFilePath");
		this.dataXML = Legacy.readFile(this.filePathVehicles);
		this.vehicle = new Vehicle();
		this.vehicle.setId(1);
		this.vehicle.setName("Dummy01");
		this.vehicle.setDescription("Dummy teste vehicle");
		this.vehicle.setType("car");
		this.vehicle.setMotorization("combustion");
		this.vehicle.setFuel("gasoline");
		this.vehicle.setMass(new Measure(1400.0, "Kg"));
		this.vehicle.setLoad(new Measure(120.0, "kg"));
		this.vehicle.setDragCoefficient(0.35);
		this.vehicle.setRollingRCoefficient(0.01);
		this.vehicle.setWheelSize(0.5);
		this.vehicle.getVelocityLimits().put("Highway", 100.0);
		this.vehicle.setTorque(250.0);
		this.vehicle.setRPM(2500.0);
		this.vehicle.setComsumption(8.2);
		this.vehicle.setMinRPM(1000.0);
		this.vehicle.setMaxRPM(5500.0);
		this.vehicle.setFinalDriveRatio(2.6);
		this.vehicle.getGears().put(01, 3.5);
		this.vehicle.getGears().put(02, 2.5);
		this.vehicle.getGears().put(03, 1.25);
		this.vehicle.getGears().put(04, 0.9);
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
	 * Test of getExtension method, of class VehicleImportXML.
	 */
	@Test
	public void testGetExtension() {
		System.out.println("testGetExtension");
		assertEquals(this.vehicleImportXML.getExtension(), "xml");
	}

	/**
	 * Test of importData method, of class VehicleImportXML.
	 */
	@Test
	public void testImportData() {
		System.out.println("testImportData");
		List<Vehicle> expResult = this.vehicles;
		List<Vehicle> result = this.vehicleImportXML.importData(this.dataXML);
		assertEquals(expResult, result);
	}

}
