/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Physics.Measure;
import Physics.Measurement;
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
		this.segment.setHeight(new Measure(1.0, "km"));
		this.segment.setLength(new Measure(3.0, "km"));
		this.segment.setMaxVelocity(new Measure(4.0, "km"));
		this.segment.setMinVelocity(new Measure(5.0, "km"));
		this.segment.setSlope(new Measure(6.0, "°"));
		this.segment.setNumberVehicles(8);
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
		Measure expResult = new Measure(12.4, "km");
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
		Measure expResult = new Measure(15.0, "°");
		this.segment.setSlope(expResult);
		assertEquals(expResult, this.segment.getSlope());
	}

	/**
	 * Test of getNumberVehicles and setNumberVehicles method, of class Segment.
	 */
	@Test
	public void testSetGetNumberVehicles() {
		System.out.println("testSetGetNumberVehicles");
		Integer expResult = 15;
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
		segment.setHeight(new Measure(1.0, "km"));
		segment.setLength(new Measure(3.0, "km"));
		segment.setMaxVelocity(new Measure(4.0, "km"));
		segment.setMinVelocity(new Measure(5.0, "km"));
		segment.setSlope(new Measure(6.0, "°"));
		segment.setNumberVehicles(8);
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
		segment.setHeight(new Measure(1.0, "km"));
		segment.setLength(new Measure(3.0, "km"));
		segment.setMaxVelocity(new Measure(4.0, "km"));
		segment.setMinVelocity(new Measure(5.0, "km"));
		segment.setSlope(new Measure(6.0, "°"));
		segment.setNumberVehicles(8);
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

	/**
	 * Test of getName method, of class Segment.
	 */
	@Test
	public void testGetName() {
		System.out.println("getName");
		String expResult = "Segment name";
		String result = this.segment.getName();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setName method, of class Segment.
	 */
	@Test
	public void testSetName() {
		System.out.println("setName");
		String name = "Segment";
		this.segment.setName(name);
		assertEquals(this.segment.getName(), name);
	}

	/**
	 * Test of getHeight method, of class Segment.
	 */
	@Test
	public void testGetHeight() {
		System.out.println("getHeight");
		Measure measure = new Measure(22.2, "GetHeight");
		this.segment.setHeight(measure);
		Measure expResult = measure;
		Measure result = this.segment.getHeight();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setHeight method, of class Segment.
	 */
	@Test
	public void testSetHeight() {
		System.out.println("setHeight");
		Measure height = new Measure(22.2, "TestCase");
		this.segment.setHeight(height);
		assertEquals(height, this.segment.getHeight());
	}

	/**
	 * Test of getSlope method, of class Segment.
	 */
	@Test
	public void testGetSlope() {
		System.out.println("getSlope");
		Measure expResult = new Measure(22.2, "TestCase");
		this.segment.setSlope(expResult);
		Measure result = this.segment.getSlope();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setSlope method, of class Segment.
	 */
	@Test
	public void testSetSlope() {
		System.out.println("setSlope");
		Measure slope = new Measure(22.2, "TestCase");
		this.segment.setSlope(slope);
		assertEquals(slope, this.segment.getSlope());
	}

	/**
	 * Test of getLength method, of class Segment.
	 */
	@Test
	public void testGetLength() {
		System.out.println("getLength");
		Measure result = this.segment.getLength();
		assertEquals(this.segment.getLength(), result);
	}

	/**
	 * Test of setLength method, of class Segment.
	 */
	@Test
	public void testSetLength() {
		System.out.println("setLength");
		Measure length = new Measure(22.2, "Unit test");
		this.segment.setLength(length);
		assertEquals(length, this.segment.getLength());
	}

	/**
	 * Test of getMaxVelocity method, of class Segment.
	 */
	@Test
	public void testGetMaxVelocity() {
		System.out.println("getMaxVelocity");
		Measure expResult = new Measure(22.2, "km");
		this.segment.setMaxVelocity(expResult);
		Measure result = this.segment.getMaxVelocity();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setMaxVelocity method, of class Segment.
	 */
	@Test
	public void testSetMaxVelocity() {
		System.out.println("setMaxVelocity");
		Measure maxVelocity = new Measure(22.2, "km");
		this.segment.setMaxVelocity(maxVelocity);
		assertEquals(maxVelocity, this.segment.getMaxVelocity());
	}

	/**
	 * Test of getMinVelocity method, of class Segment.
	 */
	@Test
	public void testGetMinVelocity() {
		System.out.println("getMinVelocity");
		Measure expResult = new Measure(40.0, "km");
		this.segment.setMinVelocity(expResult);
		Measure result = this.segment.getMinVelocity();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setMinVelocity method, of class Segment.
	 */
	@Test
	public void testSetMinVelocity() {
		System.out.println("setMinVelocity");
		Measure minVelocity = new Measure(44.0, "km");
		this.segment.setMinVelocity(minVelocity);
		assertEquals(minVelocity, this.segment.getMinVelocity());
	}

	/**
	 * Test of getNumberVehicles method, of class Segment.
	 */
	@Test
	public void testGetNumberVehicles() {
		System.out.println("getNumberVehicles");
		Integer expResult = 8;
		Integer result = this.segment.getNumberVehicles();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setNumberVehicles method, of class Segment.
	 */
	@Test
	public void testSetNumberVehicles() {
		System.out.println("setNumberVehicles");
		Integer numberVehicles = 5;
		this.segment.setNumberVehicles(numberVehicles);
		assertEquals(numberVehicles, this.segment.getNumberVehicles());
	}

	/**
	 * Test of toString method, of class Segment.
	 */
	@Test
	public void testToString() {
		System.out.println("toString");
		System.out.println(this.segment.toString());
		String expResult = "Segment | name: Segment name | height: 1,00 km | slope: 6,00 ° | length: 3,00 km | maxVelocity: 4,00 km | minVelocity: 5,00 km | numberVehicles: 8";
		String result = this.segment.toString();
		assertEquals(expResult, result);
	}

	/**
	 * Test of reverse method, of class Segment.
	 */
	@Test
	public void testReverse() {
		System.out.println("reverse");
		Measure slope = this.segment.getSlope();
		Segment result = this.segment.reverse();
		Measure slope2 = Measurement.neg(slope);
		this.segment.setSlope(slope2);
		Segment expResult = this.segment;
		assertEquals(expResult, result);
	}

}
