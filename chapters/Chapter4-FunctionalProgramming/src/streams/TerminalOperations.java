package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class TerminalOperations {

	static List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);

	static void count() {
		long count = nums.stream().count();
		System.out.println("Stream count: " + count);
	}

	static void minMax() {
		Optional<Integer> min = nums.stream().min((a, b) -> a.compareTo(b));
		min.ifPresent((i) -> System.out.println("Min value from list: " + min.orElse(0)));

		Optional<Integer> max = nums.stream().max(Comparator.comparing(Integer::intValue));
		max.ifPresent((i) -> System.out.println("Max value from list: " + max.orElse(9999)));
	}

	static void findAny() {
		Optional<Integer> findAny = nums.stream().findAny();
		findAny.ifPresent((i) -> System.out.println("Find any: " + i));
	}

	static void findFirst() {
		Optional<Integer> findFirst = nums.stream().findFirst();
		findFirst.ifPresent((i) -> System.out.println("Find any: " + i));
	}

	static void allMatch() {
		System.out.println("List allmatch > 0: "
				+ nums.stream().peek((i) -> System.out.println("Checking " + i)).allMatch(i -> i > 0));
	}

	static void anyMatch() {
		System.out.println("List anyMatch >= 3: "
				+ nums.stream().peek((i) -> System.out.println("Checking " + i)).anyMatch(i -> i >= 3));
	}

	static void noneMatch() {
		System.out.println("List noneMatch >= 5: "
				+ nums.stream().peek((i) -> System.out.println("Checking " + i)).noneMatch(i -> i >= 5));
	}

	static void reduce() {
		Optional<Integer> sum = nums.stream().reduce((a, b) -> a + b);
		sum.ifPresent((i) -> System.out.println("Sum using reduce: " + i));
	}

	static void collect() {
		System.out.println("Using collect");
		nums.parallelStream().filter(i -> i > 3).collect(ArrayList<Integer>::new, List::add, List::addAll)
				.forEach(System.out::println);
	}

	public static void main(String[] args) {
		count();
		minMax();
		findAny();
		findFirst();
		allMatch();
		anyMatch();
		noneMatch();
		reduce();
		collect();
	}
}
