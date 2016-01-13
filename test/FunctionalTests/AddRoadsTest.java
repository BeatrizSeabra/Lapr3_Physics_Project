/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionalTests;

import Controller.AddRoadsController;
import Controller.AddVehiclesController;
import Controller.ContextController;
import Data.Data;
import Model.Node;
import Model.Project;
import Model.Section;
import Model.Vehicle;
import System.Settings;
import java.util.Deque;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class AddRoadsTest {

	private AddRoadsController addRoadsController;
	private Project project;
	private String filePathRoads;

	public AddRoadsTest() {
		Settings.setSettingsFilePath("test/Files/settingsTest.properties");
		this.filePathRoads = Settings.getOption("RoadNetworkFilePath");
		this.project = new Project();
		this.project.setName("Project Name");
		this.project.setDescription("Project Description");
		ContextController.setOpenProject(this.project);
		this.addRoadsController = new AddRoadsController();
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
	public void testAddRoadsFunctional() {
		System.out.println("testAddRoadsFunctional");
		this.addRoadsController.initiation();
		this.addRoadsController.loadRoads(this.filePathRoads);
		List<Project> roads = this.addRoadsController.getRoads();
		assertEquals(roads.size(), 1);
		this.addRoadsController.loadRoads(this.filePathRoads);
		this.addRoadsController.loadRoads(this.filePathRoads);
		roads = this.addRoadsController.getRoads();
		assertEquals(roads.size(), 3);
		Boolean save = this.addRoadsController.saveProjectRoads();
		assertEquals(save, true);
		for (Project road : roads) {
                    for(Section section : road.getRoadNetwork().getSections()){
                        if(!this.project.getRoadNetwork().getSections().contains(section)){
                            Assert.fail();
                        }
                    }
		}
	}

}
