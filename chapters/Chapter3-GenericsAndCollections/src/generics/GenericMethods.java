package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericMethods {

	public static void main(String[] args) {
		printAnyType("a");

		List raw = new ArrayList();
		raw.add(123); // BAD!
		printNames(raw);

		List<Integer> rawNums = Arrays.asList(1, 2, 3, 4);
		printNumbers(rawNums);
	}

	static <T> void printAnyType(T t) {
		System.out.println(t);
	}

	static void printNames(List<String> names) {
		try {
			names.forEach(System.out::println); // RUNTIME EXCEPTION! (ClassCastException) java compiler doesn't know
												// there's a problem due to type
			// erasure, printNames accepts List<Object> now
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void printNumbers(List numbers) {
		try {
			numbers.add("not a number"); // RUNTIME EXEPTION! ( UnsupportedOperationException) list is list of numbers
											// now
		} catch (Exception e) {
			e.printStackTrace();
		}
		numbers.forEach(System.out::println);
	}

}