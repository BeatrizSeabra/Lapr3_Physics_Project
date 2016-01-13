/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Physics;

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
public class MeasureTest {

	private Measure measure;

	public MeasureTest() {
		this.measure = new Measure(15.0, "test5");
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
	 * Test of getValue method, of class Measure.
	 */
	@Test
	public void testGetValue() {

		System.out.println("GetValue");
		Measure instance = new Measure(12.0, "teste1");
		double expResult = 12.0;
		double result = instance.getValue();

		assertEquals(expResult, result, 0.0);

	}

	/**
	 * Test of setValue method, of class Measure.
	 */
	@Test
	public void testSetValue() {
		System.out.println("setValue");
		Measure instance = new Measure(12.0, "teste1");

		double expResult = 13.0;
		instance.setValue(13.0);

		assertEquals(expResult, instance.getValue(), 0.0);

	}

	/**
	 * Test of getUnit method, of class Measure.
	 */
	@Test
	public void testGetUnit() {
		System.out.println("getUnit");
		Measure instance = new Measure(12.0, "teste1");
		String expResult = "teste1";
		String result = instance.getUnit();
		assertEquals(expResult, result);

	}

	/**
	 * Test of setUnit method, of class Measure.
	 */
	@Test
	public void testSetUnit() {
		System.out.println("setUnit");

		Measure instance = new Measure(12.0, "teste1");
		String expResult = "teste2";
		instance.setUnit("teste2");

		assertEquals(expResult, instance.getUnit());

	}

	/**
	 * Test of equals method, of class Measure.
	 */
	@Test
	public void testEquals() {
		System.out.println("equals");

		this.measure.setUnit("teste5");
		this.measure.setValue(15.0);
		assertEquals(true, this.measure.equals(measure));
	}

	/**
	 * Test of hashCode method, of class Measure.
	 */
	@Test
	public void testHashCode() {
		System.out.println("hashCode");

		Integer expResult = 29 * this.measure.getClass().hashCode();
		expResult += 11 * this.measure.getValue().hashCode();
		expResult += 11 * this.measure.getUnit().hashCode();

		Integer result = this.measure.hashCode();
		assertEquals(expResult, result);
	}

	/**
	 * Test of toString method, of class Measure.
	 */
	@Test
	public void testToString() {
		System.out.println("toString");
		Measure instance = new Measure(12.0, "teste2");
		String expResult = "";
		String result = instance.toString();
		assertEquals(expResult.getClass(), result.getClass());

	}

	/**
	 * Test of compareTo method, of class Measure.
	 */
	@Test
	public void testCompareTo() {
		System.out.println("compareTo");
		Measure measure = null;
		Measure instance = null;
		int expResult = 0;
		int result = instance.compareTo(measure);
		assertEquals(expResult, result);

	}

	/**
	 * Test of clone method, of class Measure.
	 */
	@Test
	public void testClone() {
		System.out.println("clone");
		Measure instance = new Measure(12.0, "teste");
		String expResult = instance.toString();
		String result = instance.clone().toString();
		assertEquals(expResult, result);

	}

}
