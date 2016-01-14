/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionalTests;

import Controller.ContextController;
import Controller.EditSimulationController;
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
public class EditSimulationTest {

	private Project project;
	private EditSimulationController editController;
	private Simulation simulation;

	public EditSimulationTest() {
		Settings.setSettingsFilePath("test/Files/settingsTest.properties");
		this.project = new Project();
                this.project.setName("Project Name");
                this.project.setDescription("Project Description");
                ContextController.setOpenProject(this.project);
                Data.getProjectData().save(this.project);
                this.simulation = new Simulation();
		this.simulation.setId(1);
		this.simulation.setName("Simulation Name");
		this.simulation.setDescription("Simulation Description");
		ContextController.setOpenSimulation(this.simulation);
                Data.getSimulationData().save(this.project, this.simulation);
		this.editController = new EditSimulationController();
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
	public void testEditSimulationFunctional() {
		System.out.println("testEditSimulationFunctional");
		this.editController.initiation();
		this.editController.editSimulation("Name X", "Description X");
		this.editController.saveSimulation();
		List<Simulation> simulations = Data.getSimulationData().
			all(this.project);
		assertEquals(simulations.size(), 1);
		assertEquals(simulations.get(0).getName(), "Name X");
		assertEquals(simulations.get(0).getDescription(), "Description X");
	}
}
