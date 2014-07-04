package amazon;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test code for ProductsOfArray class.
 * 
 * @author Watsh Rajneesh
 * 
 */
public class ProductsOfArrayTest {

	/**
	 * Test for null input array.
	 */
	@Test
	public void testProduceProductsArrayWithNull() {
		int[] inArray = null;
		ProductsOfArray.produceProductsArray(inArray);
		Assert.assertEquals(null, inArray);
	}

	/**
	 * Test for empty input array.
	 */
	@Test
	public void testProduceProductsArrayWithEmpty() {
		int[] inArray = new int[0];
		ProductsOfArray.produceProductsArray(inArray);
		Assert.assertEquals(0, inArray.length);
	}

	/**
	 * Test for non-empty input array.
	 */
	@Test
	public void testProduceProductsArray() {
		int[] inArray = { 4, 3, 2, 8 };
		ProductsOfArray.produceProductsArray(inArray);
		int[] expectedArray = { 48, 64, 96, 24 };
		Assert.assertEquals(true, Arrays.equals(expectedArray, inArray));
	}

}
