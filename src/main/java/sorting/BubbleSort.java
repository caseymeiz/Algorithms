package sorting;

import java.util.Comparator;

/**
 * Bubble Sort
 *
 * @author <a href='mailto:casey.meisenzahl@gmail.com'>Casey Meisenzahl</a>
 */
public class BubbleSort implements Sort{

	public <T> void sort(T[] array, Comparator<T> comparator){
		T swap;
		int n = array.length;
		for(int i = 0; i < n-1; i++){
			for(int j = 0; j < n-i-1; j++){
				if(comparator.compare(array[j], array[j+1]) > 0){
					swap = array[j];
					array[j] = array[j+1];
					array[j+1] = swap;
				}
			}
		}
	}
}
