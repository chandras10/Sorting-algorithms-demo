package nayuki.sortdemo;

import org.junit.Before;
import org.junit.Test;


// Common superclass containing test cases appropriate for all sort algorithms.
public abstract class SortAlgorithmTest {
	
	// For subclasses to implement
	public abstract SortAlgorithm getInstance();
	
	// Actual algorithm under test
	protected SortAlgorithm algo;
	
	@Before
	public void setUp() {
		algo = getInstance();
	}
	
	
	/* Test cases */
	
	@Test
	public void testRandom10() {
		testRandom(10);
	}
	
	@Test
	public void testRandom30() {
		testRandom(30);
	}
	
	@Test
	public void testRandom100() {
		testRandom(100);
	}
	
	@Test
	public void testRandomSizes() {
		for (int i = 0; i < 100; i++)
			testRandom(Utils.random.nextInt(100) + 1);
	}
	
	protected void testRandom(int size) {
		TestSortArray arr = new TestSortArray(size);
		arr.shuffle();
		algo.sort(arr);
		arr.assertSorted();
	}
	
	
	@Test
	public void testForward100() {
		TestSortArray arr = new TestSortArray(100);
		algo.sort(arr);
		arr.assertSorted();
	}
	
	
	@Test
	public void testReverse100() {
		TestSortArray arr = new TestSortArray(100);
		arr.reverse();
		algo.sort(arr);
		arr.assertSorted();
	}
	
}
