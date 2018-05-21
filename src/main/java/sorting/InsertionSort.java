package sorting;

import java.util.Comparator;


/**
 * Insertion Sort
 *
 * @author <a href='mailto:casey.meisenzahl@gmail.com'>Casey Meisenzahl</a>
 */
public class InsertionSort implements Sort {
	@Override
	public <T> void sort(T[] array, Comparator<T> comparator) {
		T swap;
		int n = array.length;
		for(int i = 1; i < n; i++){
			for(int j = i-1; j >= 0; j--){
				if(comparator.compare(array[j+1], array[j]) < 0){
					swap = array[j+1];
					array[j+1] = array[j];
					array[j] = swap;
				}
			}
		}
	}
}
