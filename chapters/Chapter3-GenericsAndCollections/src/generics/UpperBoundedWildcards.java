package generics;

import java.util.ArrayList;
import java.util.List;

public class UpperBoundedWildcards {

	public static void main(String[] args) {
//		List<Number> numbers = new ArrayList<Integer>(); // DOES NOT COMPILE, incompatible types

		// meaning only list of type that is child class of Number can be parameterized!
		List<? extends Number> n1 = new ArrayList<Integer>();
		List<? extends Number> n2 = new ArrayList<Double>();
		List<? extends Number> n3 = new ArrayList<Float>();
		List<? extends Number> n4 = new ArrayList<Long>();

//		List<? extends Number> n5 = new ArrayList<? extends Number>(); // Wildcard cannot occur on the right side!

//		n1.add(1); // DOES NOT COMPILE, upperbounded wildcard is IMMUTABLE! n1 can be List<Integer>, List<Double> etc...

	}

	static void printList(List<Number> numbers) {
	}

	// DOES NOT COMPILE, generic type erasure will make the two methods duplicate.
//	static void printList(List<? extends Number> numbers) {
//	}
}
