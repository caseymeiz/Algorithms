package sorting;

import java.util.Comparator;


/**
 * Merge Sort
 *
 * @author <a href='mailto:casey.meisenzahl@gmail.com'>Casey Meisenzahl</a>
 */
public class MergeSort implements Sort {
	@Override
	public <T> void sort(T[] array, Comparator<T> comparator) {
		mSort(array,0, array.length-1, comparator);
	}

	/**
	 * Recursive merge sort algorithm called each time
	 * the array is partitioned. Each partition is then merged
	 */
	private <T> void mSort(T[] values, int low, int high, Comparator<T> comparator){
		if(low < high){
			int middle = (low+high)/2;
			mSort(values, low, middle, comparator);
			mSort(values, middle+1, high, comparator);
			merge(values, low, middle, high, comparator);
		}
	}


	/**
	 * Merge two sorted lists
	 */
	private <T> void merge(T[] values, int low, int middle, int high, Comparator<T> comparator){
		T[] left = (T[])new Object[middle-low+1];
		T[] right = (T[])new Object[high-middle];

		for(int i = 0; i < left.length; i++){
			left[i] = values[low+i];
		}

		for(int i = 0; i < right.length; i++){
			right[i] = values[middle+i+1];
		}

		int li = 0;
		int ri = 0;
		int index = low;

		// merge the left and right arrays
		while(li < left.length && ri < right.length){
			if(comparator.compare(left[li], right[ri]) < 0){
				values[index++] = left[li++];
			} else {
				values[index++] = right[ri++];
			}
		}

		// copy the rest of the left array
		while(li < left.length){
			values[index++] = left[li++];
		}

		// copy the rest of the right array
		while(ri < right.length){
			values[index++] = right[ri++];
		}
	}
}
