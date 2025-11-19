
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class represents GFA test cases for a TwoDimRaggedArrayUtility object.
 * 
 * @author Farnaz Eivazi
 * @version 7/13/2022
 * 
 */
public class TwoDimRaggedArrayUtilityGFATest {
	private double[][] dataSet1 = {{1,2,3},{4,5},{6,7,8,9}};
	private double[][] dataSet2 = {{7, 2, 9, 4}, {5},{8, 1, 3}, {11, 6, 7, 2}};
	private double[][] dataSet3 = {{7.2, 2.5, 9.3, 4.8}, {5.9}, {8.1, 1.7, 3.3}, {11.6, 6.9, 7.3, 2.7}};
	private double[][] dataSet4 = {{-2.5, -5.3, 6.1}, {-4.4, 8.2}, {2.3, -7.5}, {-4.2, 7.3, -5.9, 2.6}};
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test getRowTotal method
	 * Returns the total of all the elements of row 1.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotal() {
		System.out.println("testGetRowTotal");
		assertEquals(9.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet1,1),.001);
		System.out.println(TwoDimRaggedArrayUtility.getRowTotal(dataSet1,1));
		assertEquals(0.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet1,4),.001);
		System.out.println(TwoDimRaggedArrayUtility.getRowTotal(dataSet1,4));
		assertEquals(0.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet1,-1),.001);
		System.out.println(TwoDimRaggedArrayUtility.getRowTotal(dataSet1,-1));
	}
	
	@Test
	public void testGetColumnTotal() {
		System.out.println("testGetColumnTotal");
		assertEquals(11.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSet1,2),.001);
		System.out.println(TwoDimRaggedArrayUtility.getColumnTotal(dataSet1,2));
		assertEquals(0.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSet1,-1),.001);
		System.out.println(TwoDimRaggedArrayUtility.getColumnTotal(dataSet1,-1));
		assertEquals(0.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSet1,6),.001);
		System.out.println(TwoDimRaggedArrayUtility.getColumnTotal(dataSet1,6));
	}
	
	@Test
	public void testGetTotal() {
		System.out.println("testGetTotal");
		assertEquals(45.0,TwoDimRaggedArrayUtility.getTotal(dataSet1),.001);
		System.out.println(TwoDimRaggedArrayUtility.getTotal(dataSet1));
	}
	
	@Test
	public void testGetAverage() {
		System.out.println("testGetAverage");
		assertEquals(5.0,TwoDimRaggedArrayUtility.getAverage(dataSet1),.001);
		System.out.println(TwoDimRaggedArrayUtility.getAverage(dataSet1));
	}
	
	@Test 
	public void testGetHighestInRow() {
		System.out.println("testGetHighestInRow");
		assertEquals(9.0, TwoDimRaggedArrayUtility.getHighestInRow(dataSet2, 0), .001);
		System.out.println(TwoDimRaggedArrayUtility.getHighestInRow(dataSet2, 0));
	}
	
	@Test 
	public void testGetLowestInRow() {
		System.out.println("testGetLowestInRow");
		assertEquals(2.0, TwoDimRaggedArrayUtility.getLowestInRow(dataSet2, 0), .001);
		System.out.println(TwoDimRaggedArrayUtility.getLowestInRow(dataSet2, 0));
	}
	
	@Test 
	public void testGetHighestInColumn() {
		System.out.println("testGetHighestInColumn");
		assertEquals(4.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet2, 3), .001);
		System.out.println(TwoDimRaggedArrayUtility.getHighestInColumn(dataSet2, 3));
	}
	
	@Test 
	public void testGetLowestInColumn() {
		System.out.println("testGetLowestInColumn");
		assertEquals(2.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet2, 3), .001);
		System.out.println(TwoDimRaggedArrayUtility.getLowestInColumn(dataSet2, 3));
	}
	
	@Test 
	public void testGetHighestInArray() {
		System.out.println("testGetHighestInArray");
		assertEquals(11.0, TwoDimRaggedArrayUtility.getHighestInArray(dataSet2), .001);
		System.out.println(TwoDimRaggedArrayUtility.getHighestInArray(dataSet2));
	}
	
	@Test 
	public void testGetLowestInArray() {
		System.out.println("testGetLowestInArray");
		assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInArray(dataSet2), .001);
		System.out.println(TwoDimRaggedArrayUtility.getLowestInArray(dataSet2));
	}
}
