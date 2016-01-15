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
public class VehicleImportXMLTest {

	private VehicleImportXML vehicleImportXML;
	private String filePathVehicles;
	private String dataXML;
	private List<Vehicle> vehicles;
	private Vehicle vehicle;
	private Vehicle vehicle2;
	private Vehicle vehicle3;

	public VehicleImportXMLTest() {
		Settings.setSettingsFilePath("test/Files/settingsTest.properties");
		this.vehicleImportXML = new VehicleImportXML();
		this.filePathVehicles = Settings.getOption("VehiclesFilePath");
		this.dataXML = Legacy.readFile(this.filePathVehicles);

		Throttle throttle1 = new Throttle();
		throttle1.setPercentage(new Measure(25.0, "%"));
		throttle1.
			addRegime(new Regime(new Measure(105.0, "Nm"), new Measure(1000.0, "rpm"), new Measure(2499.0, "rpm"), new Measure(580.2, "g/KWh")));
		throttle1.
			addRegime(new Regime(new Measure(115.0, "Nm"), new Measure(2500.0, "rpm"), new Measure(3999.0, "rpm"), new Measure(520.2, "g/KWh")));
		throttle1.
			addRegime(new Regime(new Measure(100.0, "Nm"), new Measure(4000.0, "rpm"), new Measure(5500.0, "rpm"), new Measure(640.2, "g/KWh")));
		Throttle throttle2 = new Throttle();
		throttle2.setPercentage(new Measure(50.0, "%"));
		throttle2.
			addRegime(new Regime(new Measure(135.0, "Nm"), new Measure(1000.0, "rpm"), new Measure(2499.0, "rpm"), new Measure(400.2, "g/KWh")));
		throttle2.
			addRegime(new Regime(new Measure(150.0, "Nm"), new Measure(2500.0, "rpm"), new Measure(3999.0, "rpm"), new Measure(350.2, "g/KWh")));
		throttle2.
			addRegime(new Regime(new Measure(130.0, "Nm"), new Measure(4000.0, "rpm"), new Measure(5500.0, "rpm"), new Measure(521.8, "g/KWh")));
		Throttle throttle3 = new Throttle();
		throttle3.setPercentage(new Measure(100.0, "%"));
		throttle3.
			addRegime(new Regime(new Measure(220.0, "Nm"), new Measure(1000.0, "rpm"), new Measure(2499.0, "rpm"), new Measure(290.2, "g/KWh")));
		throttle3.
			addRegime(new Regime(new Measure(250.0, "Nm"), new Measure(2500.0, "rpm"), new Measure(3999.0, "rpm"), new Measure(250.7, "g/KWh")));
		throttle3.
			addRegime(new Regime(new Measure(190.0, "Nm"), new Measure(4000.0, "rpm"), new Measure(5500.0, "rpm"), new Measure(370.1, "g/KWh")));
		this.vehicle = new Vehicle();
		this.vehicle.setId(1);
		this.vehicle.setName("Dummy01");
		this.vehicle.setDescription("Dummy teste vehicle 01");
		this.vehicle.setType("car");
		this.vehicle.setMotorization("combustion");
		this.vehicle.setFuel("gasoline");
		this.vehicle.setMass(new Measure(2400.0, "Kg"));
		this.vehicle.setLoad(new Measure(820.0, "kg"));
		this.vehicle.setDragCoefficient(new Measure(0.38, "ratio"));
		this.vehicle.setFrontalArea(new Measure(2.4, "m2"));
		this.vehicle.setRollingRCoefficient(new Measure(0.015, "ratio"));
		this.vehicle.setWheelSize(new Measure(0.7, "m"));
		this.vehicle.getVelocityLimits().
			put("Highway", new Measure(100.0, "km/h"));
		this.vehicle.setMinRPM(new Measure(1000.0, "rpm"));
		this.vehicle.setMaxRPM(new Measure(5500.0, "rpm"));
		this.vehicle.setFinalDriveRatio(new Measure(2.6, "ratio"));
		this.vehicle.getGears().put(01, new Measure(3.5, "ratio"));
		this.vehicle.getGears().put(02, new Measure(2.5, "ratio"));
		this.vehicle.getGears().put(03, new Measure(1.9, "ratio"));
		this.vehicle.getGears().put(04, new Measure(1.2, "ratio"));
		this.vehicle.getGears().put(05, new Measure(0.8, "ratio"));
		this.vehicle.addThrottle(throttle1);
		this.vehicle.addThrottle(throttle2);
		this.vehicle.addThrottle(throttle3);

		Throttle throttle4 = new Throttle();
		throttle4.setPercentage(new Measure(25.0, "%"));
		throttle4.
			addRegime(new Regime(new Measure(85.0, "Nm"), new Measure(1000.0, "rpm"), new Measure(2499.0, "rpm"), new Measure(481.5, "g/KWh")));
		throttle4.
			addRegime(new Regime(new Measure(95.0, "Nm"), new Measure(2500.0, "rpm"), new Measure(3999.0, "rpm"), new Measure(450.2, "g/KWh")));
		throttle4.
			addRegime(new Regime(new Measure(80.0, "Nm"), new Measure(4000.0, "rpm"), new Measure(5500.0, "rpm"), new Measure(510.2, "g/KWh")));
		Throttle throttle5 = new Throttle();
		throttle5.setPercentage(new Measure(50.0, "%"));
		throttle5.
			addRegime(new Regime(new Measure(135.0, "Nm"), new Measure(1000.0, "rpm"), new Measure(2499.0, "rpm"), new Measure(380.0, "g/KWh")));
		throttle5.
			addRegime(new Regime(new Measure(150.0, "Nm"), new Measure(2500.0, "rpm"), new Measure(3999.0, "rpm"), new Measure(320.0, "g/KWh")));
		throttle5.
			addRegime(new Regime(new Measure(140.0, "Nm"), new Measure(4000.0, "rpm"), new Measure(5500.0, "rpm"), new Measure(420.8, "g/KWh")));
		Throttle throttle6 = new Throttle();
		throttle6.setPercentage(new Measure(100.0, "%"));
		throttle6.
			addRegime(new Regime(new Measure(180.0, "Nm"), new Measure(1000.0, "rpm"), new Measure(2499.0, "rpm"), new Measure(260.0, "g/KWh")));
		throttle6.
			addRegime(new Regime(new Measure(200.0, "Nm"), new Measure(2500.0, "rpm"), new Measure(3999.0, "rpm"), new Measure(220.0, "g/KWh")));
		throttle6.
			addRegime(new Regime(new Measure(180.0, "Nm"), new Measure(4000.0, "rpm"), new Measure(5500.0, "rpm"), new Measure(350.0, "g/KWh")));
		this.vehicle2 = new Vehicle();
		this.vehicle2.setId(2);
		this.vehicle2.setName("Dummy02");
		this.vehicle2.setDescription("Dummy teste vehicle 02");
		this.vehicle2.setType("car");
		this.vehicle2.setMotorization("combustion");
		this.vehicle2.setFuel("gasoline");
		this.vehicle2.setMass(new Measure(1400.0, "Kg"));
		this.vehicle2.setLoad(new Measure(320.0, "kg"));
		this.vehicle2.setDragCoefficient(new Measure(0.30, "ratio"));
		this.vehicle2.setFrontalArea(new Measure(1.8, "m2"));
		this.vehicle2.setRollingRCoefficient(new Measure(0.01, "ratio"));
		this.vehicle2.setWheelSize(new Measure(0.5, "m"));
		this.vehicle2.setMinRPM(new Measure(1000.0, "rpm"));
		this.vehicle2.setMaxRPM(new Measure(5500.0, "rpm"));
		this.vehicle2.setFinalDriveRatio(new Measure(2.6, "ratio"));
		this.vehicle2.getGears().put(01, new Measure(3.5, "ratio"));
		this.vehicle2.getGears().put(02, new Measure(2.7, "ratio"));
		this.vehicle2.getGears().put(03, new Measure(1.9, "ratio"));
		this.vehicle2.getGears().put(04, new Measure(1.3, "ratio"));
		this.vehicle2.getGears().put(05, new Measure(0.7, "ratio"));
		this.vehicle2.addThrottle(throttle4);
		this.vehicle2.addThrottle(throttle5);
		this.vehicle2.addThrottle(throttle6);

		Throttle throttle7 = new Throttle();
		throttle7.setPercentage(new Measure(25.0, "%"));
		throttle7.
			addRegime(new Regime(new Measure(85.0, "Nm"), new Measure(0.0, "rpm"), new Measure(3499.0, "rpm"), new Measure(0.0, "g/KWh")));
		throttle7.
			addRegime(new Regime(new Measure(80.0, "Nm"), new Measure(3500.0, "rpm"), new Measure(4499.0, "rpm"), new Measure(0.0, "g/KWh")));
		throttle7.
			addRegime(new Regime(new Measure(75.0, "Nm"), new Measure(4500.0, "rpm"), new Measure(5499.0, "rpm"), new Measure(0.0, "g/KWh")));
		throttle7.
			addRegime(new Regime(new Measure(70.0, "Nm"), new Measure(5500.0, "rpm"), new Measure(6499.0, "rpm"), new Measure(0.0, "g/KWh")));
		throttle7.
			addRegime(new Regime(new Measure(65.0, "Nm"), new Measure(6500.0, "rpm"), new Measure(7499.0, "rpm"), new Measure(0.0, "g/KWh")));
		throttle7.
			addRegime(new Regime(new Measure(55.0, "Nm"), new Measure(7500.0, "rpm"), new Measure(8499.0, "rpm"), new Measure(0.0, "g/KWh")));
		throttle7.
			addRegime(new Regime(new Measure(45.0, "Nm"), new Measure(8500.0, "rpm"), new Measure(9499.0, "rpm"), new Measure(0.0, "g/KWh")));
		throttle7.
			addRegime(new Regime(new Measure(30.0, "Nm"), new Measure(9500.0, "rpm"), new Measure(10500.0, "rpm"), new Measure(0.0, "g/KWh")));
		Throttle throttle8 = new Throttle();
		throttle8.setPercentage(new Measure(50.0, "%"));
		throttle8.
			addRegime(new Regime(new Measure(150.0, "Nm"), new Measure(0.0, "rpm"), new Measure(3499.0, "rpm"), new Measure(0.0, "g/KWh")));
		throttle8.
			addRegime(new Regime(new Measure(145.0, "Nm"), new Measure(3500.0, "rpm"), new Measure(4499.0, "rpm"), new Measure(0.0, "g/KWh")));
		throttle8.
			addRegime(new Regime(new Measure(140.0, "Nm"), new Measure(4500.0, "rpm"), new Measure(5499.0, "rpm"), new Measure(0.0, "g/KWh")));
		throttle8.
			addRegime(new Regime(new Measure(130.0, "Nm"), new Measure(5500.0, "rpm"), new Measure(6499.0, "rpm"), new Measure(0.0, "g/KWh")));
		throttle8.
			addRegime(new Regime(new Measure(120.0, "Nm"), new Measure(6500.0, "rpm"), new Measure(7499.0, "rpm"), new Measure(0.0, "g/KWh")));
		throttle8.
			addRegime(new Regime(new Measure(105.0, "Nm"), new Measure(7500.0, "rpm"), new Measure(8499.0, "rpm"), new Measure(0.0, "g/KWh")));
		throttle8.
			addRegime(new Regime(new Measure(80.0, "Nm"), new Measure(8500.0, "rpm"), new Measure(9499.0, "rpm"), new Measure(0.0, "g/KWh")));
		throttle8.
			addRegime(new Regime(new Measure(60.0, "Nm"), new Measure(9500.0, "rpm"), new Measure(10500.0, "rpm"), new Measure(0.0, "g/KWh")));
		Throttle throttle9 = new Throttle();
		throttle9.setPercentage(new Measure(100.0, "%"));
		throttle9.
			addRegime(new Regime(new Measure(250.0, "Nm"), new Measure(0.0, "rpm"), new Measure(3499.0, "rpm"), new Measure(0.0, "g/KWh")));
		throttle9.
			addRegime(new Regime(new Measure(240.0, "Nm"), new Measure(3500.0, "rpm"), new Measure(4499.0, "rpm"), new Measure(0.0, "g/KWh")));
		throttle9.
			addRegime(new Regime(new Measure(230.0, "Nm"), new Measure(4500.0, "rpm"), new Measure(5499.0, "rpm"), new Measure(0.0, "g/KWh")));
		throttle9.
			addRegime(new Regime(new Measure(215.0, "Nm"), new Measure(5500.0, "rpm"), new Measure(6499.0, "rpm"), new Measure(0.0, "g/KWh")));
		throttle9.
			addRegime(new Regime(new Measure(180.0, "Nm"), new Measure(6500.0, "rpm"), new Measure(7499.0, "rpm"), new Measure(0.0, "g/KWh")));
		throttle9.
			addRegime(new Regime(new Measure(140.0, "Nm"), new Measure(7500.0, "rpm"), new Measure(8499.0, "rpm"), new Measure(0.0, "g/KWh")));
		throttle9.
			addRegime(new Regime(new Measure(110.0, "Nm"), new Measure(8500.0, "rpm"), new Measure(9499.0, "rpm"), new Measure(0.0, "g/KWh")));
		throttle9.
			addRegime(new Regime(new Measure(80.0, "Nm"), new Measure(9500.0, "rpm"), new Measure(10500.0, "rpm"), new Measure(0.0, "g/KWh")));
		this.vehicle3 = new Vehicle();
		this.vehicle3.setId(2);
		this.vehicle3.setName("ElectricDummy");
		this.vehicle3.setDescription("Electric Dummy teste vehicle");
		this.vehicle3.setType("car");
		this.vehicle3.setMotorization("electric");
		this.vehicle3.setFuel("electric");
		this.vehicle3.setMass(new Measure(1500.0, "Kg"));
		this.vehicle3.setLoad(new Measure(320.0, "kg"));
		this.vehicle3.setDragCoefficient(new Measure(0.32, "ratio"));
		this.vehicle3.setFrontalArea(new Measure(1.8, "m2"));
		this.vehicle3.setRollingRCoefficient(new Measure(0.01, "ratio"));
		this.vehicle3.setWheelSize(new Measure(0.5, "m"));
		this.vehicle3.setMinRPM(new Measure(0.0, "rpm"));
		this.vehicle3.setMaxRPM(new Measure(10500.0, "rpm"));
		this.vehicle3.setFinalDriveRatio(new Measure(2.6, "ratio"));
		this.vehicle3.setEnergyRegeneration(new Measure(0.8, "ratio"));
		this.vehicle3.getGears().put(01, new Measure(1.0, "ratio"));
		this.vehicle3.addThrottle(throttle7);
		this.vehicle3.addThrottle(throttle8);
		this.vehicle3.addThrottle(throttle9);

		this.vehicles = new ArrayList();
		this.vehicles.add(vehicle);
		this.vehicles.add(vehicle2);
		this.vehicles.add(vehicle3);
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
		System.out.println("esperado: ");
		System.out.println(expResult);
		List<Vehicle> result = this.vehicleImportXML.importData(this.dataXML);
		System.out.println("Obtido: ");
		System.out.println(result);
		assertEquals(expResult, result);
	}

	/**
	 * Test of getExtensionDescription method, of class VehicleImportXML.
	 */
	@Test
	public void testGetExtensionDescription() {
		System.out.println("getExtensionDescription");
		VehicleImportXML instance = new VehicleImportXML();
		String expResult = "XML Documents (*.xml)";
		String result = instance.getExtensionDescription();
		assertEquals(expResult, result);
	}

}
