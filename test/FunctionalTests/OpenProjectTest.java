/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionalTests;

import Controller.ContextController;
import Controller.OpenProjectController;
import Data.Data;
import Model.Project;
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
public class OpenProjectTest {

	private OpenProjectController openController;
	private Project project;

	public OpenProjectTest() {
		Settings.setSettingsFilePath("test/Files/settingsTest.properties");
		this.project = new Project();
		this.project.setId(1);
		this.project.setName("Project Name");
		this.project.setDescription("Project Description");
		Data.getProjectData().save(project);
		this.openController = new OpenProjectController();
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
		assertEquals(ContextController.getOpenProject(), null);
		this.openController.initiation();
		List<Project> projects = this.openController.getProjects();
		assertEquals(projects.size(), 1);
		this.openController.openProject(projects.get(0));
		assertEquals(ContextController.getOpenProject(), projects.get(0));
	}
}
