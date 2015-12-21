/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Physics.Measure;
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
}
