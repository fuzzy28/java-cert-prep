package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOperations {

	static List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 5, 3, 4, 3);

	static void filter() {
		System.out.println("-----Filter result-----");
		nums.stream().filter(i -> i > 2).forEach(System.out::print);
		System.out.println();
	}

	static void distinct() {
		System.out.println("-----Distinct list-----");
		nums.stream().distinct().forEach(System.out::print);
		System.out.println();
	}

	static void limit() {
		System.out.println("-----Limit 4-----");
		nums.stream().limit(4).forEach(System.out::print);
		System.out.println();
	}

	static void skip() {
		System.out.println("-----Skip 3-----");
		nums.stream().skip(3).distinct().forEach(System.out::print);
		System.out.println();
	}

	static void map() {
		System.out.println("-----Map-----");
		nums.stream().distinct().map(i -> i * 2).forEach(System.out::print);
		System.out.println();
	}
	
	static void flatMap() {
		System.out.println("-----FlatMap-----");
		Stream.of(nums, nums).flatMap(Stream::of).forEach(System.out::print);
		System.out.println();
	}
	
	static void sortedAscending() {
		System.out.println("-----Sorted ascending-----");
		nums.stream().sorted().forEach(System.out::print);
		System.out.println();
	}
	
	static void sortedDescending() {
		System.out.println("-----Sorted desscending-----");
		nums.stream().sorted((a,b) -> b.compareTo(a)).forEach(System.out::print);
		System.out.println();
	}
	
	static void peek() {
		System.out.println("-----Peek-----");
		nums.stream().peek((i) -> System.out.print("Debugging... " + i)).forEach(System.out::print);
		System.out.println();
	}

	public static void main(String[] args) {
		filter();
		distinct();
		limit();
		skip();
		map();
		flatMap();
		sortedAscending();
		sortedDescending();
		peek();
	}

}
