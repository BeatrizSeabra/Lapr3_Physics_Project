/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionalTests;

import Controller.ContextController;
import Controller.CreateProjectController;
import Model.Project;
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
public class UCP02CreateProjectTest {

	private CreateProjectController cpController;
	private Project project;

	public UCP02CreateProjectTest() {
		this.project = new Project();
		this.project.setId(1);
		this.project.setName("Project Name");
		this.project.setDescription("Project Description");
		ContextController.setOpenProject(this.project);
		this.cpController = new CreateProjectController();
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
	public void testUCP02Functional() {
		System.out.println("testUCP02Functional");
		this.cpController.setDataProject("Name X", "Description X");
		this.cpController.registProject();
		assertEquals(this.project.getDescription(), "Description X");
		assertEquals(this.project.getName(), "Name X");
	}
}
