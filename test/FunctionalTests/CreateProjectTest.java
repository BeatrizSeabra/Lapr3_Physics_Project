/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionalTests;

import Controller.ContextController;
import Controller.CreateProjectController;
import Data.Data;
import Model.Project;
import Model.RoadNetwork;
import Model.Vehicle;
import System.Settings;
import java.util.List;
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
/**
 *
 * @author LAPR3_20152016_G27
 */
public class CreateProjectTest {

	private CreateProjectController createProjectController;
	private Project project;
	private String filePathRoadNetwork;
	private String filePathVehicles;

	public CreateProjectTest() {
		Settings.setSettingsFilePath("test/Files/settingsTest.properties");
		ContextController.setOpenProject(null);
		this.createProjectController = new CreateProjectController();
		this.filePathRoadNetwork = "test/Files/RoadNetworkXMLTest.xml";
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
	public void testCreateProjectFunctional() {
		System.out.println("testCreateProjectFunctional");
		this.createProjectController.initiation();
		List<Project> projects = Data.getProjectData().all();
		assertEquals(projects.size(), 0);
		this.createProjectController.setDataProject("Name X", "Description X");
		List<Vehicle> vehicles = this.createProjectController.
			getProjectVehicles();
		assertEquals(vehicles.size(), 0);
		this.createProjectController.loadRoadNetwork(this.filePathRoadNetwork);
		RoadNetwork roadNetwork = this.createProjectController.
			getProjectRoadNetwork();
		assertEquals(roadNetwork.getName(), "TestSet01");
		assertEquals(roadNetwork.getDescription(), "Simple test set to begin development");
		this.createProjectController.loadVehicles(this.filePathVehicles);
		vehicles = this.createProjectController.getProjectVehicles();
		assertEquals(vehicles.size(), 3);
		this.createProjectController.saveProject();
		projects = Data.getProjectData().all();
		assertEquals(projects.size(), 1);
		assertEquals(projects.get(0).getName(), "TestSet01");
		assertEquals(projects.get(0).getDescription(), "Simple test set to begin development");
	}
}
