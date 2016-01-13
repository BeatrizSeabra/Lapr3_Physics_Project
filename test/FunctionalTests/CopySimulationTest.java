/*
 * To change this license header, choose License Headers in Simulation Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionalTests;

import Controller.ContextController;
import Controller.CopySimulationController;
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
public class CopySimulationTest {

	private CopySimulationController copySimulationController;
	private Simulation simulation;
	private Project project;

	public CopySimulationTest() {
		Settings.setSettingsFilePath("test/Files/settingsTest.properties");
		this.project = new Project();
		this.project.setName("Project Name");
		this.project.setDescription("Project Description");
                this.simulation = new Simulation();
		this.simulation.setName("Simulation Name");
		this.simulation.setDescription("Simulation Description");
                Data.getProjectData().save(this.project);
                Data.getSimulationData().save(this.project, this.simulation);
		ContextController.setOpenProject(this.project);
		ContextController.setOpenSimulation(this.simulation);
		this.copySimulationController = new CopySimulationController();
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
	public void testCopySimulationFunctional() {
		System.out.println("testCopySimulationFunctional");
                List<Simulation> simulations = Data.getSimulationData().all(ContextController.getOpenProject());
                assertEquals(simulations.size(), 1);
                this.copySimulationController.initiation();
		this.copySimulationController.
			copySimulation("Simulation Name", "Simulation Description");
                
		List<Simulation> newSimulations = Data.getSimulationData().all(ContextController.getOpenProject());
                assertEquals(newSimulations.size(), 2);
	}
}
