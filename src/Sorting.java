public class Sorting {
    
	/**
     * Sorts the given array of integers using the merge sort
     *
     * @param array The array of integers to be sorted
     * @return The sorted array of integers
     */
	public static int[] mergeSort(int[] array) {
		
		// if there are 1 or less elements in the array, consider it sorted
		if (array.length <= 1) {
			return array;
		}
		
		// get the lengths for splitting the array into two
		// they are different in case the array has an odd number of elements
		int firstLimit = array.length / 2;
		int lastLimit = array.length - firstLimit;
		
		// initialize empty arrays
		int[] first = new int[firstLimit];
		int[] last = new int[lastLimit];
		
		// copy first and last halves of the arrays into the corresponding empty arrays 
		System.arraycopy(array, 0, first, 0, firstLimit);
		System.arraycopy(array, firstLimit, last, 0, lastLimit);
		
		// recursively sort the newly made arrays
		// basically it splits the arrays until there is 1 or 2 elements left 
		first = mergeSort(first);
		last = mergeSort(last);
		
		// merge the splitted arrays into one
		return merge(first, last);
	}

    /**
     * Merges two arrays into a single sorted array.
     *
     * @param first The first sorted array.
     * @param last The last sorted array.
     * @return The merged sorted array.
     */	
	
	private static int[] merge(int[] first, int[] last) {
		
		// initialize an empty array to store the sorted integers
		int[] result = new int[first.length + last.length];

		// index counters
		int firstIndex = 0;
		int lastIndex = 0;
		int resultIndex = 0;
		
		// merge first and last arrays in sorted order
		while (firstIndex < first.length && lastIndex < last.length) {
			// compare integers and add them to the resulting sorted array
			if (first[firstIndex] <= last[lastIndex]) {
				result[resultIndex] = first[firstIndex];
				firstIndex++;
			} else {
				result[resultIndex] = last[lastIndex];
				lastIndex++;
			}
			resultIndex++;
		}
		
		// copy any remaining elements from first and last arrays
		System.arraycopy(first, firstIndex, result, resultIndex, first.length - firstIndex);
		System.arraycopy(last, lastIndex, result, resultIndex, last.length - lastIndex);
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] array = {14, 66, 2, 44, 13, 78, 15, 16, 99, 0, 2, 2, 3, 5, 7, 12, 109};
		array = mergeSort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}