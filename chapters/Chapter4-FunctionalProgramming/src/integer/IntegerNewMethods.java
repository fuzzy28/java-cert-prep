package integer;

import java.util.Arrays;
import java.util.stream.Stream;

public class IntegerNewMethods {
	
	static void max() {
		System.out.println("------max()------");
		System.out.println(Integer.max(4, 3));
		System.out.println("When used as comparator");
		Stream<Integer> ints = Arrays.asList(5,2,3,4,6).stream();
		System.out.println(ints.max(Integer::max));
	}
	
	static void min() {
		System.out.println("------min()------");
		System.out.println(Integer.min(4, 3));
		System.out.println("When used as comparator");
		Stream<Integer> ints = Arrays.asList(5,2,3,4,6).stream();
		System.out.println(ints.max(Integer::min));
	}
	
	static void compare() {
		System.out.println("------compare()------");
		System.out.println(Integer.compare(4, 3));
		System.out.println("When used as comparator");
		Stream<Integer> ints = Arrays.asList(5,2,3,4,6).stream();
		System.out.println(ints.max(Integer::compare));
	}

	
	public static void main(String[] args) {
		max();
		min();
		compare();
	}
}
