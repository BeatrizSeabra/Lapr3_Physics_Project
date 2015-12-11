/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
public class ProjectTest {

	private Project project;

	public ProjectTest() {
		this.project = new Project();
		this.project.setId(1);
		this.project.setName("Project Name");
		this.project.setDescription("Project Description");
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
	 * Test of getId and setId method, of class Project.
	 */
	@Test
	public void testSetGetId() {
		System.out.println("testSetGetId");
		Integer expResult = 11;
		this.project.setId(expResult);
		Integer result = this.project.getId();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getName and setName method, of class Project.
	 */
	@Test
	public void testSetGetName() {
		System.out.println("testSetGetName");
		String expResult = "New Name";
		this.project.setName(expResult);
		String result = this.project.getName();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getDescription and setDescription method, of class Project.
	 */
	@Test
	public void testSetGetDescription() {
		System.out.println("testSetGetDescription");
		String expResult = "New Description";
		this.project.setDescription(expResult);
		String result = this.project.getDescription();
		assertEquals(expResult, result);
	}

	/**
	 * Test of hashCode method, of class Project.
	 */
	@Test
	public void testHashCode() {
		System.out.println("testHashCode");
		Integer result = this.project.hashCode();
		Integer expResult = 11 * this.project.getId() + 29 * Project.class.
			hashCode();
		assertEquals(expResult, result);
	}

	/**
	 * Test of equals method, of class Project.
	 */
	@Test
	public void testEquals() {
		System.out.println("testEquals");
		Project project = new Project();
		project.setId(1);
		project.setName("Project Name");
		project.setDescription("Project Description");
		Boolean result = this.project.equals(project);
		Boolean expResult = true;
		assertEquals(expResult, result);
	}

	/**
	 * Test of equals method, of class Project.
	 */
	@Test
	public void testEqualsFalseHash() {
		System.out.println("testEqualsFalseHash");
		Project project = new Project();
		project.setId(11);
		project.setName("Project Name");
		project.setDescription("Project Description");
		Boolean result = this.project.equals(project);
		Boolean expResult = false;
		assertEquals(expResult, result);
	}

	/**
	 * Test of equals method, of class Project.
	 */
	@Test
	public void testEqualsFalseNull() {
		System.out.println("testEqualsFalseNull");
		Boolean result = this.project.equals(null);
		Boolean expResult = false;
		assertEquals(expResult, result);
	}

	/**
	 * Test of equals method, of class Project.
	 */
	@Test
	public void testEqualsFalseClass() {
		System.out.println("testEqualsFalseClass");
		Boolean result = this.project.equals(new String());
		Boolean expResult = false;
		assertEquals(expResult, result);
	}

}
