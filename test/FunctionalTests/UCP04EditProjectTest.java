/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionalTests;

import Controller.ContextController;
import Controller.EditProjectController;
import Model.Project;
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
public class UCP04EditProjectTest {

	private EditProjectController editController;
	private Project project;

	public UCP04EditProjectTest() {
		this.project = new Project();
		this.project.setId(1);
		this.project.setName("Project Name");
		this.project.setDescription("Project Description");
		ContextController.setOpenProject(this.project);
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
	public void testUCP04Functional() {
		System.out.println("testUCP04Functional");
		this.editController.defineProject("Name X", "Description X");
		this.editController.registProject();
		assertEquals(this.project.getDescription(), "Description X");
		assertEquals(this.project.getName(), "Name X");
	}
}
