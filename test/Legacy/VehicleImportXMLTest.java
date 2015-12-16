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
	private Vehicle vehicle1;
	private Vehicle vehicle2;
	private Vehicle vehicle3;

	public VehicleImportXMLTest() {
		Settings.setSettingsFilePath("test/Files/settingsTest.properties");
		this.vehicleImportXML = new VehicleImportXML();
		this.filePathVehicles = Settings.getOption("VehiclesFilePath");
		this.dataXML = Legacy.readFile(this.filePathVehicles);
		this.vehicle1 = new Vehicle();
		this.vehicle1.setId(1);
		this.vehicle1.setName("Dummy01");
		this.vehicle1.setDescription("Dummy teste vehicle");
		this.vehicle1.setType("car");
		this.vehicle1.setMotorization("combustion");
		this.vehicle1.setFuel("gasoline");
		this.vehicle1.setMass(new Measure(1400.0, "kg"));
		this.vehicle1.setLoad(new Measure(120.0, "kg"));
		this.vehicle1.setDragCoefficient(0.35);
		this.vehicle1.setRollingCcoefficient(0.01);
		this.vehicle1.setWheelSize(0.5);
		this.vehicle1.getVelocityLimits().put("Highway", 100.0);
		this.vehicle1.setTorque(250.0);
		this.vehicle1.setRPM(2500.0);
		this.vehicle1.setComsumption(8.2);
		this.vehicle1.setMinRPM(1000.0);
		this.vehicle1.setMaxRPM(5500.0);
		this.vehicle1.setFinalDriveRatio(2.6);
		this.vehicle1.getGears().put(01, 3.5);
		this.vehicle1.getGears().put(02, 2.5);
		this.vehicle1.getGears().put(03, 1.25);
		this.vehicle1.getGears().put(04, 0.9);
		this.vehicles = new ArrayList();
		this.vehicles.add(vehicle1);

		/*
		this.vehicle2 = new Vehicle();
		this.vehicle2.setId(2);
		this.vehicle2.setName("v02");
		this.vehicle2.setType("motorcycle");
		this.vehicle2.setMotorization("electric");
		this.vehicle2.setMass(new Measure(100.0, "kg"));
		this.vehicle2.setLoad(new Measure(3.0, "kg"));
		this.vehicle2.setDragCoefficient(1.0);
		this.vehicle3 = new Vehicle();
		this.vehicle3.setId(3);
		this.vehicle3.setName("v03");
		this.vehicle3.setType("car");
		this.vehicle3.setMotorization("hybrid");
		this.vehicle3.setMass(new Measure(300.0, "kg"));
		this.vehicle3.setLoad(new Measure(2.0, "kg"));
		this.vehicle3.setDragCoefficient(3.0);
		this.vehicles = new ArrayList();
		this.vehicles.add(this.vehicle1);
		this.vehicles.add(this.vehicle2);
		this.vehicles.add(this.vehicle3);
		 */
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
