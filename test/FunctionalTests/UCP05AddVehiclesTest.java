/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionalTests;

import Controller.AddVehiclesController;
import Controller.ContextController;
import Model.Project;
import Model.Vehicle;
import System.Settings;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class UCP05AddVehiclesTest {

	private AddVehiclesController addVehiclesController;
	private Project project;
	private String filePathVehicles;
	private String filePathVehiclesSimple;

	public UCP05AddVehiclesTest() {
		Settings.setSettingsFilePath("test/Files/settingsTest.properties");
		this.filePathVehicles = Settings.getOption("VehiclesFilePath");
		this.filePathVehiclesSimple = Settings.
			getOption("VehiclesFilePathSimple");
		this.project = new Project();
		this.project.setId(1);
		this.project.setName("Project Name");
		this.project.setDescription("Project Description");
		ContextController.setOpenProject(this.project);
		this.addVehiclesController = new AddVehiclesController();
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
	 * Test functional of functionality, of class AddVehiclesController.
	 */
	@Test
	public void testUCP05Functional() {
		System.out.println("testUCP05Functional");
		this.addVehiclesController.initiation();
		this.addVehiclesController.loadVehicles(this.filePathVehicles);
		List<Vehicle> vehicles = this.addVehiclesController.getVehicles();
		assertEquals(vehicles.size(), 3);
		this.addVehiclesController.loadVehicles(this.filePathVehiclesSimple);
		this.addVehiclesController.loadVehicles(this.filePathVehiclesSimple);
		vehicles = this.addVehiclesController.getVehicles();
		assertEquals(vehicles.size(), 5);
		assertEquals(vehicles.get(3).getName(), "v01 1");
		assertEquals(vehicles.get(4).getName(), "v01 2");
		Boolean save = this.addVehiclesController.saveProjectVehicles();
		assertEquals(save, true);
		for (Vehicle vehicle : vehicles) {
			if (!this.project.getVehicles().contains(vehicle)) {
				Assert.fail();
			}
		}
	}

}
