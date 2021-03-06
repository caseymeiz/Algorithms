package sorting;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * SortTest Test
 *
 * @author <a href='mailto:casey.meisenzahl@gmail.com'>Casey Meisenzahl</a>
 */
public class SortTest {
	static final Integer[] INCREASING_INT = {1,2,3,4,5,6,7};
	static final Integer[] DECREASING_INT = {7,6,5,4,3,2,1};
	static final String[] ALPHABETICAL_STR = {"a","b","c","d"};
	static final String[] REVERSE_ALPHABETICAL_STR = {"d","c","b","a"};

	static final Comparator<Integer> INT_INCREASING_COMPARE = Comparator.comparingInt(x -> x);
	static final Comparator<Integer> INT_DECREASING_COMPARE = INT_INCREASING_COMPARE.reversed();
	static final Comparator<String> ALPHABETICAL_COMPARE = Comparator.comparing(String::toString);
	static final Comparator<String> REVERSE_ALPHABETICAL_COMPARE = ALPHABETICAL_COMPARE.reversed();


	/**
	 * Tests the given sort class.
	 *
	 * @param sorter type of sort to be used
	 * @param comparator determines how to compare the elements
	 * @param toBeSorted array of unsorted elements
	 * @param expected sorted array of elements
	 * @param <T> Type of elements to be sorted
	 */
	@ParameterizedTest
	@MethodSource("sortProvider")
	<T> void sort(Sort sorter, Comparator<T> comparator, T[] toBeSorted, T[] expected) {
		sorter.sort(toBeSorted, comparator);
		assertArrayEquals(toBeSorted, expected, Arrays.toString(toBeSorted));
	}


	/**
	 * Helper method to provide the sort class with the test data and the expected
	 * sorted array.
	 */
	static Stream<Arguments> sortProvider() {

		BubbleSort bs = new BubbleSort();
		SelectionSort ss = new SelectionSort();
		InsertionSort is = new InsertionSort();
		MergeSort ms = new MergeSort();

		return Stream.of(bs,ss,is,ms).flatMap(SortTest::basicTests);
	}

	/**
	 * Provides some basic tests
	 *
	 * @param sorter
	 * @return
	 */
	static Stream<Arguments> basicTests(Sort sorter){
		return Stream.of(
				Arguments.of(sorter, INT_DECREASING_COMPARE, new Integer[]{1,2,3,4,5,6,7}, DECREASING_INT),
				Arguments.of(sorter, INT_INCREASING_COMPARE, new Integer[]{7,6,5,4,3,2,1}, INCREASING_INT),
				Arguments.of(sorter, ALPHABETICAL_COMPARE, new String[]{"d","c","b","a"}, ALPHABETICAL_STR),
				Arguments.of(sorter, REVERSE_ALPHABETICAL_COMPARE, new String[]{"a","b","c","d"}, REVERSE_ALPHABETICAL_STR)
		);
	}
}
