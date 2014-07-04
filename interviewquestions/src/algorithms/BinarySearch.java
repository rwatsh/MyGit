package algorithms;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class BinarySearch {
	/**
	 * Searches for the integer key in the sorted array a[].
	 * 
	 * @param key
	 *            the search key
	 * @param a
	 *            the array of integers, must be sorted in ascending order
	 * @return index of key in array a[] if present; -1 if not present
	 */
	public static boolean contains(int[] a, int b) {
		if (a.length == 0) {
			return false;
		}
		int low = 0;
		int high = a.length - 1;

		while (low <= high) {
			int middle = (low + high) / 2;
			if (b > a[middle]) {
				low = middle + 1;
			} else if (b < a[middle]) {
				high = middle - 1;
			} else { // The element has been found
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 34, 6, 3, 56, 7, 3 };
		Arrays.sort(arr);
		System.out.println("Sorted array: " + Arrays.toString(arr));
		System.out.println(contains(arr, 6));
	}

	@Test
	public void testContains() {
		int[] a = { 1, 2, 3, 4, 5, 7, 17, 19 };
		// assertTrue(BinarySearch.contains(a, 17));
		assertTrue(BinarySearch.contains(a, 1));
		assertTrue(BinarySearch.contains(a, 2));
		assertTrue(BinarySearch.contains(a, 3));
		assertTrue(BinarySearch.contains(a, 4));
		assertFalse(BinarySearch.contains(a, 10));
	}
}
