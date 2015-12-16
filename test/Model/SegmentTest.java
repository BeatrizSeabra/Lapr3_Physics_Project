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
public class SegmentTest {

	private Segment segment;

	public SegmentTest() {
		this.segment = new Segment();
		this.segment.setName("Segment name");
		this.segment.setHeight(1.0);
		this.segment.setLength(new Measure(3.0, "km"));
		this.segment.setMaxVelocity(new Measure(4.0, "km"));
		this.segment.setMinVelocity(new Measure(5.0, "km"));
		this.segment.setSlope(6.0);
		this.segment.setNumberVehicles(8.0);
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
	 * Test of getName and setName method, of class Segment.
	 */
	@Test
	public void testSetGetName() {
		System.out.println("testSetGetName");
		String expResult = "Segment 1";
		this.segment.setName(expResult);
		assertEquals(expResult, this.segment.getName());
	}

	/**
	 * Test of getHeight and setHeight method, of class Segment.
	 */
	@Test
	public void testSetGetHeight() {
		System.out.println("testSetGetHeight");
		Double expResult = 12.4;
		this.segment.setHeight(expResult);
		assertEquals(expResult, this.segment.getHeight());
	}

	/**
	 * Test of getLength and setLength method, of class Segment.
	 */
	@Test
	public void testSetGetLength() {
		System.out.println("testSetGetLength");
		Measure expResult = new Measure(20.4, "km");
		this.segment.setLength(expResult);
		assertEquals(expResult, this.segment.getLength());
	}

	/**
	 * Test of getMaxVelocity and setMaxVelocity method, of class Segment.
	 */
	@Test
	public void testSetGetMaxVelocity() {
		System.out.println("testSetGetMaxVelocity");
		Measure expResult = new Measure(120.0, "km");
		this.segment.setMaxVelocity(expResult);
		assertEquals(expResult, this.segment.getMaxVelocity());
	}

	/**
	 * Test of getMinVelocity and setMinVelocity method, of class Segment.
	 */
	@Test
	public void testSetGetMinVelocity() {
		System.out.println("testSetGetMinVelocity");
		Measure expResult = new Measure(50.0, "km");
		this.segment.setMinVelocity(expResult);
		assertEquals(expResult, this.segment.getMinVelocity());
	}

	/**
	 * Test of getSlope and setSlope method, of class Segment.
	 */
	@Test
	public void testSetGetSlope() {
		System.out.println("testSetGetSlope");
		Double expResult = 15.0;
		this.segment.setSlope(expResult);
		assertEquals(expResult, this.segment.getSlope());
	}

	/**
	 * Test of getNumberVehicles and setNumberVehicles method, of class Segment.
	 */
	@Test
	public void testSetGetNumberVehicles() {
		System.out.println("testSetGetNumberVehicles");
		Double expResult = 15.0;
		this.segment.setNumberVehicles(expResult);
		assertEquals(expResult, this.segment.getNumberVehicles());
	}

	/**
	 * Test of hashCode method, of class Segment.
	 */
	@Test
	public void testHashCode() {
		System.out.println("testHashCode");
		Integer expResult = 29 * this.segment.getClass().hashCode();
		expResult += 11 * this.segment.getName().hashCode();
		expResult += 11 * this.segment.getHeight().hashCode();
		expResult += 11 * this.segment.getLength().hashCode();
		expResult += 11 * this.segment.getMaxVelocity().hashCode();
		expResult += 11 * this.segment.getMinVelocity().hashCode();
		expResult += 11 * this.segment.getSlope().hashCode();
		expResult += 11 * this.segment.getNumberVehicles().hashCode();
		Integer result = this.segment.hashCode();
		assertEquals(expResult, result);
	}

	/**
	 * Test of equals method, of class Segment.
	 */
	@Test
	public void testEquals() {
		System.out.println("testEquals");
		Segment segment = new Segment();
		segment.setName("Segment name");
		segment.setHeight(1.0);
		segment.setLength(new Measure(3.0, "km"));
		segment.setMaxVelocity(new Measure(4.0, "km"));
		segment.setMinVelocity(new Measure(5.0, "km"));
		segment.setSlope(6.0);
		segment.setNumberVehicles(8.0);
		assertEquals(true, this.segment.equals(segment));
	}

	/**
	 * Test of equals method, of class Section.
	 */
	@Test
	public void testEqualsFalseHash() {
		System.out.println("testEqualsFalseHash");
		Segment segment = new Segment();
		segment.setName("name");
		segment.setHeight(1.0);
		segment.setLength(new Measure(3.0, "km"));
		segment.setMaxVelocity(new Measure(4.0, "km"));
		segment.setMinVelocity(new Measure(5.0, "km"));
		segment.setSlope(6.0);
		segment.setNumberVehicles(8.0);
		assertEquals(false, this.segment.equals(segment));
	}

	/**
	 * Test of equals method, of class Section.
	 */
	@Test
	public void testEqualsFalseNull() {
		System.out.println("testEqualsFalseNull");
		Boolean result = this.segment.equals(null);
		Boolean expResult = false;
		assertEquals(expResult, result);
	}

	/**
	 * Test of equals method, of class Section.
	 */
	@Test
	public void testEqualsFalseClass() {
		System.out.println("testEqualsFalseClass");
		Boolean result = this.segment.equals(new String());
		Boolean expResult = false;
		assertEquals(expResult, result);
	}

}
