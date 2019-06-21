package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnboundedWildcards {

	static void acceptIntegers(List<Integer> list) {
		list.forEach(System.out::println);
	}

	static void acceptStrings(List<String> list) {
		list.forEach(System.out::println);
	}

	static void accept(List<Object> any) {
		any.forEach(System.out::println);
	}

//	void accept(List<String> list) { // DOES NOT compile! overloading a generic type will be the same after type erasure! 
//		
//	}

	static void acceptUnbounded(List<?> list) {
		list.forEach(System.out::println);
	}

	public static void main(String[] args) {
//		List<Number> numbers = new ArrayList<Integer>(); // DOES NOT COMPILE! 
		List<?> numbers = new ArrayList<Integer>(); // Unbounded wildcard
		System.out.println(numbers.size());
//		numbers.add(1); // DOES NOT COMPILE! unbounded wildcard is immutable.
		numbers.remove(0); // CAN DELETE though
		
		List<String> strings = Arrays.asList("a", "b", "c");
		List<Integer> integers = Arrays.asList(1, 2, 3);
		List<Object> objects = Arrays.asList(new String("a"));
		List<?> unboundedList = Arrays.asList(1, 2, 3);
		acceptIntegers(integers);
		acceptStrings(strings);
		accept(objects);
		acceptUnbounded(unboundedList);
//		accept(unboundedList); // DOES NOT COMPILE, incompatible types List<Object> - List<?>
//		acceptIntegers(strings); // DOES NOT COMPILE, incompatible types List<Integer> - List<String>
//		accept(integers); // DOES NOT COMPILE, incompatible types List<Object> - List<Integer>

		// only unbounded generics can accept any type
		acceptUnbounded(strings);
		acceptUnbounded(integers);
		acceptUnbounded(objects);

	}

}
