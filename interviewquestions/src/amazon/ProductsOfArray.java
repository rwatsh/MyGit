package amazon;

import java.util.Arrays;

/**
 * Given an array of integers, produce an array whose values are the product of
 * every other integer excluding the current index.
 * 
 * @author Watsh Rajneesh
 * 
 */
public class ProductsOfArray {
	/**
	 * Produces the products array.
	 * 
	 * Assumption: It is ok to perform in-place substitution in the original
	 * array as that will be most efficient in terms of least space complexity.
	 * 
	 * @param inArray
	 *            Array that needs to be processed.
	 * @return an integer products array.
	 * 
	 *         Notes on complexity: Time: O(N) - 2 iterations will be made, one
	 *         to compute the total product and one more to create the products
	 *         array.
	 * 
	 *         Space: same as the memory required by the original array.
	 */
	public static void produceProductsArray(int[] inArray) {
		if (inArray != null) {
			int totalProduct = 1;

			for (int elem : inArray) {
				totalProduct *= elem;
			}

			for (int i = 0; i < inArray.length; i++) {
				inArray[i] = totalProduct / inArray[i];
			}
		}
		System.out.println(Arrays.toString(inArray));
	}
}
