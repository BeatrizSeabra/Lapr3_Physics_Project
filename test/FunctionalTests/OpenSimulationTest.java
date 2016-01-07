/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionalTests;

import Controller.ContextController;
import Controller.OpenSimulationController;
import Data.Data;
import Model.Project;
import Model.Simulation;
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
 * @author LAPR3_20152016_G27
 */
public class OpenSimulationTest {

	private OpenSimulationController openController;
	private Simulation simulation;
	private Project project;

	public OpenSimulationTest() {
		this.project = new Project();
		Settings.setSettingsFilePath("test/Files/settingsTest.properties");
		this.simulation = new Simulation();
		this.simulation.setId(1);
		this.simulation.setName("Project Name");
		this.simulation.setDescription("Project Description");
		Data.getSimulationData().save(simulation);
		this.project.addSimulation(simulation);
		ContextController.setOpenProject(project);
		this.openController = new OpenSimulationController();
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
	public void testOpenProjectFunctional() {
		System.out.println("testOpenProjectFunctional");
		assertEquals(ContextController.getOpenSimulation(), null);
		this.openController.initiation();
		List<Simulation> simulations = this.openController.getSimulations();
		assertEquals(simulations.size(), 1);
		this.openController.openSimulation(simulations.get(0));
		assertEquals(ContextController.getOpenSimulation(), simulations.get(0));
	}
}
