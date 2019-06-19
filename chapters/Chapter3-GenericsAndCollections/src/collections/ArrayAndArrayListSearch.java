package collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class ArrayAndArrayListSearch {
	public static void main(String[] args) {

		testArrays();
		System.out.println("--------------------------------");
		testArrayList();
	}

	static void testArrays() {
		String[] names = { "f", "d", "c", "a", "e", };
		System.out.println("array length: " + names.length);

		Consumer<String> n = (s) -> System.out.printf("%s is at index: %s %n", s, Arrays.binarySearch(names, s));

		n.accept("e"); // undefine since it's not sorted
		n.accept("a"); // -1 because insertion is at index 0, make it negative, and add -1
		n.accept("x"); // -6 because insertion is at index 5, make it negative, and add -1
		Arrays.sort(names);
		System.out.println("Sorted array:");
		n.accept("e"); // always 3
		n.accept("a"); // 0 because array is sorted now
		n.accept("x"); // -6 because insertion is -5 + -1

	}

	static void testArrayList() {
		List<Integer> numbers = Arrays.asList(4, 3, 2, 10, 6);
		Consumer<Integer> n = (i) -> System.out.printf("%s is at index: %s %n", i,
				Collections.binarySearch(numbers, i));

		n.accept(4); // undefined since it's not sorted
		n.accept(5); // -4 because insertion is at index 3, make it negative, and add -1
		n.accept(11); // -6 because insertion is at index 5, make it negative, and add -1
		n.accept(1); // -1 because insertion is at index 0, make it negative, and add -1
		Collections.sort(numbers);

		n.accept(10); // 4
		n.accept(4); // 2
		n.accept(5); // -4 because insertion is at index 3, make it negative, and add -1
		n.accept(11); // -6 because insertion is at index 5, make it negative, and add -1
		n.accept(1); // -1 because insertion is at index 0, make it negative, and add -1
	}
}
