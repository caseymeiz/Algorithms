package sorting;

import java.util.Comparator;

public interface Sort {
	<T> void sort(T[] array, Comparator<T> comparator);
}
