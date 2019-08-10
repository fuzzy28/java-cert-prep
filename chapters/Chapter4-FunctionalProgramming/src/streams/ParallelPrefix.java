package streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class ParallelPrefix {

	static void parallelPrefixString() {
		System.out.println("----------parallelPrefixString----------");
		String[] names = { "A", "B", "C" };
		Arrays.parallelPrefix(names, String::concat);
		Arrays.asList(names).forEach(System.out::println);
	}

	static void parallelPrefixInteger() {
		System.out.println("----------parallelPrefixInteger----------");
		int[] nums = { 1, 2, 3, 4 };
		Arrays.parallelPrefix(nums, (a, b) -> a * b);
		Arrays.stream(nums).forEach(System.out::println);
	}

	public static void main(String[] args) {
		parallelPrefixString();
		parallelPrefixInteger();
		
	}

}
