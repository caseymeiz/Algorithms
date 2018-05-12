package sorting;

import java.util.Comparator;

/**
 * Selection Sort
 *
 * @author <a href='mailto:casey.meisenzahl@gmail.com'>Casey Meisenzahl</a>
 */
public class SelectionSort implements Sort {

	public <T> void sort(T[] array, Comparator<T> comparator){
		T swap;
		int n = array.length;
		for(int i = 0; i < n-1; i++){
			for(int j = i+1; j < n; j++){
				if(comparator.compare(array[i], array[j]) > 0){
					swap = array[i];
					array[i] = array[j];
					array[j] = swap;
				}
			}
		}
	}
}
