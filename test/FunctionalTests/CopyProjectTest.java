/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionalTests;

import Controller.ContextController;
import Controller.CopyProjectController;
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
public class CopyProjectTest {

	private CopyProjectController copyProjectController;
	private Project project;

	public CopyProjectTest() {
		Settings.setSettingsFilePath("test/Files/settingsTest.properties");
		this.project = Data.getProjectData().newInstance();
		this.project.setName("Project Name");
		this.project.setDescription("Project Description");
		Data.getProjectData().save(project);
		ContextController.setOpenProject(this.project);
		this.copyProjectController = new CopyProjectController();
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
	public void testCopyProjectFunctional() {
		System.out.println("testCopyProjectFunctional");
		this.copyProjectController.initiation();
		List<Project> projects = Data.getProjectData().all();
		assertEquals(projects.size(), 1);
		this.copyProjectController.copyProject();
		this.copyProjectController.saveProject();
		projects = Data.getProjectData().all();
		String newName = new StringBuilder(projects.get(0).getName()).
			append(" (copy)").toString();
		assertEquals(projects.get(1).getName(), newName);
		assertEquals(projects.get(0).getId() != projects.get(1).getId(), true);
		assertEquals(projects.get(0).getDescription(), projects.get(1).
					 getDescription());
		assertEquals(projects.get(0).getRoadNetwork(), projects.get(1).
					 getRoadNetwork());
	}
}
