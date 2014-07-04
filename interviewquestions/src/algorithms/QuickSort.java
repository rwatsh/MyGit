package algorithms;

import java.util.Arrays;

/**
 * Fast, recursive, non-stable sort algorithm which works by the divide and
 * conquer principle. Quicksort will in the best case divide the array into
 * almost two identical parts. It the array contains n elements then the first
 * run will need O(n). Sorting the remaining two sub-arrays takes 2* O(n/2).
 * This ends up in a performance of O(n log n).
 * 
 * In the worst case quicksort selects only one element in each iteration. So it
 * is O(n) + O(n-1) + (On-2).. O(1) which is equal to O(n^2).
 * 
 * The average case of quicksort is O(n log n).
 * 
 * @author Watsh
 * 
 */
public class QuickSort {
	private int[] numbers;
	private int number;

	public void sort(int[] values) {
		// check for empty or null array
		if (values == null || values.length == 0) {
			return;
		}
		this.numbers = values;
		number = values.length;
		quicksort(0, number - 1);
	}

	private void quicksort(int low, int high) {
		int i = low, j = high;
		// Get the pivot element from the middle of the list
		int pivot = numbers[low + (high - low) / 2];

		// Divide into two lists
		while (i <= j) {
			// If the current value from the left list is smaller then the pivot
			// element then get the next element from the left list
			while (numbers[i] < pivot) {
				i++;
			}
			// If the current value from the right list is larger then the pivot
			// element then get the next element from the right list
			while (numbers[j] > pivot) {
				j--;
			}

			// If we have found a values in the left list which is larger then
			// the pivot element and if we have found a value in the right list
			// which is smaller then the pivot element then we exchange the
			// values.
			// As we are done we can increase i and j
			if (i <= j) {
				exchange(i, j);
				i++;
				j--;
			}
		}
		// Recursion
		if (low < j)
			quicksort(low, j);
		if (i < high)
			quicksort(i, high);
	}

	private void exchange(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
	
	public static void main(String[] args) {
		QuickSort ms = new QuickSort();
		int[] arr = {1,34,6,3,56,7,3};
		ms.sort(arr);
		System.out.println("Sorted array: " + Arrays.toString(arr));
	}
}
