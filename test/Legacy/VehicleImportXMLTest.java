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
		this.vehicle1.setName("v01");
		this.vehicle1.setType("truck");
		this.vehicle1.setMotorization("combustion");
		this.vehicle1.setMass(new Measure(500.0, "kg"));
		this.vehicle1.setLoad(new Measure(1.0, "kg"));
		this.vehicle1.setDragCoefficient(4.0);
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
