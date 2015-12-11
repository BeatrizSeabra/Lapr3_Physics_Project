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
public class UCP05AddVehiclesTest {

	private AddVehiclesController avController;
	private Project project;
	private String filePathVehicles;

	public UCP05AddVehiclesTest() {
		this.project = new Project();
		this.project.setId(1);
		this.project.setName("Project Name");
		this.project.setDescription("Project Description");
		ContextController.setOpenProject(this.project);
		this.avController = new AddVehiclesController();
		this.filePathVehicles = "test/Files/VehiclesXMLTest.xml";
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
		List<Vehicle> vehicles = this.avController.
			loadVehicles(this.filePathVehicles);
		assertEquals(vehicles.size(), 0);
		Boolean save = this.avController.saveProjectVehicles();
		assertEquals(save, true);
		for (Vehicle vehicle : vehicles) {
			if (!this.project.getVehicles().contains(vehicle)) {
				assertEquals(true, false);
			}
		}
	}

}
