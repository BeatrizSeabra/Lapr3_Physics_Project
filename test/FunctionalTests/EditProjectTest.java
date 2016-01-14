/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionalTests;

import Controller.ContextController;
import Controller.EditProjectController;
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
public class EditProjectTest {

	private EditProjectController editController;
	private Project project;

	public EditProjectTest() {
		Settings.setSettingsFilePath("test/Files/settingsTest.properties");
		this.project = new Project();
		this.project.setName("Project Name");
		this.project.setDescription("Project Description");
		ContextController.setOpenProject(this.project);
                Data.getProjectData().save(this.project);
		this.editController = new EditProjectController();
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
	public void testEditProjectFunctional() {
		System.out.println("testEditProjectFunctional");
		this.editController.initiation();
		this.editController.editProject("Name X", "Description X");
		this.editController.saveProject();
		Project OpenPoject = ContextController.getOpenProject();
		assertEquals(OpenPoject.getName(), "Name X");
		assertEquals(OpenPoject.getDescription(), "Description X");
	}
}
