/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Physics.Measure;
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
public class SectionTest {

	private Section section;

	public SectionTest() {
		this.section = new Section();
		this.section.setDirection("Section Diretion");
		this.section.setRoad("Section road");
		this.section.setToll(new Measure(1.0, "€"));
		this.section.setTypology("Section typology");
		this.section.setWindDirection(new Measure(2.0, "°"));
		this.section.setWindSpeed(new Measure(3.0, "km"));
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
	 * Test of getRoad and setRoad method, of class Section.
	 */
	@Test
	public void testSetGetRoad() {
		System.out.println("testSetGetRoad");
		String expResult = "Road 1";
		this.section.setRoad(expResult);
		assertEquals(expResult, this.section.getRoad());
	}

	/**
	 * Test of getTypology and setTypology method, of class Section.
	 */
	@Test
	public void testSetGetTypology() {
		System.out.println("testSetGetTypology");
		String expResult = "Typology 1";
		this.section.setTypology(expResult);
		assertEquals(expResult, this.section.getTypology());
	}

	/**
	 * Test of getDiretion and setDiretion method, of class Section.
	 */
	@Test
	public void testSetGetDiretion() {
		System.out.println("testSetGetDiretion");
		String expResult = "Diretion 1";
		this.section.setDirection(expResult);
		assertEquals(expResult, this.section.getDirection());
	}

	/**
	 * Test of getToll and setToll method, of class Section.
	 */
	@Test
	public void testSetGetToll() {
		System.out.println("testSetGetToll");
		Measure expResult = new Measure(2.0, "€");
		this.section.setToll(expResult);
		assertEquals(expResult, this.section.getToll());
	}

	/**
	 * Test of getWindDirection and setWindDirection method, of class Section.
	 */
	@Test
	public void testSetGetWindDirection() {
		System.out.println("testSetGetWindDirection");
		Measure expResult = new Measure(19.5, "°");
		this.section.setWindDirection(expResult);
		assertEquals(expResult, this.section.getWindDirection());
	}

	/**
	 * Test of getWindSpeed and setWindSpeed method, of class Section.
	 */
	@Test
	public void testSetGetWindSpeed() {
		System.out.println("testSetGetWindSpeed");
		Measure expResult = new Measure(12.4, "km");
		this.section.setWindSpeed(expResult);
		assertEquals(expResult, this.section.getWindSpeed());
	}

	/**
	 * Test of hashCode method, of class Section.
	 */
	@Test
	public void testHashCode() {
		System.out.println("testHashCode");
		Integer expResult = 29 * this.section.getClass().hashCode();
		expResult += 11 * this.section.getRoad().hashCode();
		expResult += 11 * this.section.getTypology().hashCode();
		expResult += 11 * this.section.getDirection().hashCode();
		expResult += 11 * this.section.getToll().hashCode();
		expResult += 11 * this.section.getWindDirection().hashCode();
		expResult += 11 * this.section.getWindSpeed().hashCode();
		for (Segment Segment : this.section.getSegments()) {
			expResult += 7 * Segment.hashCode();
		}
		Integer result = this.section.hashCode();
		assertEquals(expResult, result);
	}

	/**
	 * Test of equals method, of class Section.
	 */
	@Test
	public void testEquals() {
		System.out.println("testEquals");
		Section section = new Section();
		section.setDirection("Section Diretion");
		section.setRoad("Section road");
		section.setToll(new Measure(1.0, "€"));
		section.setTypology("Section typology");
		section.setWindDirection(new Measure(2.0, "°"));
		section.setWindSpeed(new Measure(3.0, "km"));
		assertEquals(true, this.section.equals(section));
	}

	/**
	 * Test of equals method, of class Section.
	 */
	@Test
	public void testEqualsFalseHash() {
		System.out.println("testEqualsFalseHash");
		Section section = new Section();
		section.setDirection("Section");
		section.setRoad("Section road");
		section.setToll(new Measure(1.0, "€"));
		section.setTypology("Section typology");
		section.setWindDirection(new Measure(2.0, "°"));
		section.setWindSpeed(new Measure(3.0, "km"));
		assertEquals(false, this.section.equals(section));
	}

	/**
	 * Test of equals method, of class Section.
	 */
	@Test
	public void testEqualsFalseNull() {
		System.out.println("testEqualsFalseNull");
		Boolean result = this.section.equals(null);
		Boolean expResult = false;
		assertEquals(expResult, result);
	}

	/**
	 * Test of equals method, of class Section.
	 */
	@Test
	public void testEqualsFalseClass() {
		System.out.println("testEqualsFalseClass");
		Boolean result = this.section.equals(new String());
		Boolean expResult = false;
		assertEquals(expResult, result);
	}

	/**
	 * Test of getId method, of class Section.
	 */
	@Test
	public void testGetId() {
		System.out.println("getId");
		Section instance = new Section();
		Integer expResult = null;
		Integer result = instance.getId();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setId method, of class Section.
	 */
	@Test
	public void testSetId() {
		System.out.println("setId");
		Integer id = null;
		Section instance = new Section();
		instance.setId(id);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getRoad method, of class Section.
	 */
	@Test
	public void testGetRoad() {
		System.out.println("getRoad");
		Section instance = new Section();
		String expResult = "";
		String result = instance.getRoad();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setRoad method, of class Section.
	 */
	@Test
	public void testSetRoad() {
		System.out.println("setRoad");
		String road = "";
		Section instance = new Section();
		instance.setRoad(road);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getTypology method, of class Section.
	 */
	@Test
	public void testGetTypology() {
		System.out.println("getTypology");
		Section instance = new Section();
		String expResult = "";
		String result = instance.getTypology();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setTypology method, of class Section.
	 */
	@Test
	public void testSetTypology() {
		System.out.println("setTypology");
		String typology = "";
		Section instance = new Section();
		instance.setTypology(typology);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getDirection method, of class Section.
	 */
	@Test
	public void testGetDirection() {
		System.out.println("getDirection");
		Section instance = new Section();
		String expResult = "";
		String result = instance.getDirection();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setDirection method, of class Section.
	 */
	@Test
	public void testSetDirection() {
		System.out.println("setDirection");
		String direction = "";
		Section instance = new Section();
		instance.setDirection(direction);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getToll method, of class Section.
	 */
	@Test
	public void testGetToll() {
		System.out.println("getToll");
		Section instance = new Section();
		Measure expResult = null;
		Measure result = instance.getToll();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setToll method, of class Section.
	 */
	@Test
	public void testSetToll() {
		System.out.println("setToll");
		Measure toll = null;
		Section instance = new Section();
		instance.setToll(toll);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getWindDirection method, of class Section.
	 */
	@Test
	public void testGetWindDirection() {
		System.out.println("getWindDirection");
		Section instance = new Section();
		Measure expResult = null;
		Measure result = instance.getWindDirection();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setWindDirection method, of class Section.
	 */
	@Test
	public void testSetWindDirection() {
		System.out.println("setWindDirection");
		Measure windDirection = null;
		Section instance = new Section();
		instance.setWindDirection(windDirection);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getWindSpeed method, of class Section.
	 */
	@Test
	public void testGetWindSpeed() {
		System.out.println("getWindSpeed");
		Section instance = new Section();
		Measure expResult = null;
		Measure result = instance.getWindSpeed();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setWindSpeed method, of class Section.
	 */
	@Test
	public void testSetWindSpeed() {
		System.out.println("setWindSpeed");
		Measure windSpeed = null;
		Section instance = new Section();
		instance.setWindSpeed(windSpeed);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getSegments method, of class Section.
	 */
	@Test
	public void testGetSegments() {
		System.out.println("getSegments");
		Section instance = new Section();
		List<Segment> expResult = null;
		List<Segment> result = instance.getSegments();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of addSegment method, of class Section.
	 */
	@Test
	public void testAddSegment() {
		System.out.println("addSegment");
		Segment segment = null;
		Section instance = new Section();
		Boolean expResult = null;
		Boolean result = instance.addSegment(segment);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getTotalLength method, of class Section.
	 */
	@Test
	public void testGetTotalLength() {
		System.out.println("getTotalLength");
		Section instance = new Section();
		Measure expResult = null;
		Measure result = instance.getTotalLength();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of toString method, of class Section.
	 */
	@Test
	public void testToString() {
		System.out.println("toString");
		Section instance = new Section();
		String expResult = "";
		String result = instance.toString();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of clone method, of class Section.
	 */
	@Test
	public void testClone() {
		System.out.println("clone");
		Section instance = new Section();
		Section expResult = null;
		Section result = instance.clone();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of reverse method, of class Section.
	 */
	@Test
	public void testReverse() {
		System.out.println("reverse");
		Section instance = new Section();
		Section expResult = null;
		Section result = instance.reverse();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
}
