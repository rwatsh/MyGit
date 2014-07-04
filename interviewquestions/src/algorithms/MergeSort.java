package algorithms;

import java.util.Arrays;

/**
 * Mergesort sorts in worst case in O(n log n) time. Due to the required copying
 * of the collection Mergesort is in the average case slower then
 * 
 * @author Watsh
 * 
 */
public class MergeSort {
	private int[] numbers;
	private int[] helper;

	private int number;

	public void sort(int[] values) {
		this.numbers = values;
		number = values.length;
		this.helper = new int[number];
		mergesort(0, number - 1);
	}

	private void mergesort(int low, int high) {
		// check if low is smaller then high, if not then the array is sorted
		if (low < high) {
			// Get the index of the element which is in the middle
			int middle = low + (high - low) / 2;
			// Sort the left side of the array
			mergesort(low, middle);
			// Sort the right side of the array
			mergesort(middle + 1, high);
			// Combine them both
			merge(low, middle, high);
		}
	}

	private void merge(int low, int middle, int high) {

		// Copy both parts into the helper array
		for (int i = low; i <= high; i++) {
			helper[i] = numbers[i];
		}

		int i = low;
		int j = middle + 1;
		int k = low;
		// Copy the smallest values from either the left or the right side back
		// to the original array
		while (i <= middle && j <= high) {
			if (helper[i] <= helper[j]) {
				numbers[k] = helper[i];
				i++;
			} else {
				numbers[k] = helper[j];
				j++;
			}
			k++;
		}
		// Copy the rest of the left side of the array into the target array
		while (i <= middle) {
			numbers[k] = helper[i];
			k++;
			i++;
		}

	}

	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		int[] arr = {1,34,6,3,56,7,3};
		ms.sort(arr);
		System.out.println("Sorted array: " + Arrays.toString(arr));
	}
}