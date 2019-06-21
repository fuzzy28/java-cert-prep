package generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LowerboundedWildcards {

	public static void main(String[] args) {

		List<? super Number> list = new ArrayList<>(); // tells java that all items to be added are from Number class or
														// class that extends (or super) is Number
		//But only class that is parent of Number can be used as a parameter type
//		list = new ArrayList<Integer>(); // DOES NOT COMPILE, we allow all values of child class Number but we restrict it to Integer
		list = new ArrayList<Object>();
//		list = new ArrayList<String>(); // DOES NOT COMPILE, incompatible types
		list = new ArrayList<Serializable>();
		list.add(123);
		list.add(1.0);

		System.out.println(list);

		List<String> strings = new ArrayList<>();
		List<Object> objects = new ArrayList<>();

		addStringListLowerBounded(strings, "a");
		addStringListLowerBounded(objects, "a");

	}

	static void addStringListObject(List<Object> object, String string) {
		object.add(string); // Can add String but can pass List<Object> only! / Exact match
	}

	static void addStringListUnbounded(List<?> object, String string) {
//		object.add(string); // DOESN'T COMPILE, unbounded wildcard is IMMUTABLE!
	}

	static void addStringListUpperBounded(List<? extends Object> object, String string) {
//		object.add(string); //DOESN'T COMPILE, upper bounded wildcard is IMMUTABLE!, what if List<Integer> is passed as an argument?!
	}

	static void addStringListLowerBounded(List<? super String> object, String string) {
		object.add(string);
	}

}

interface SuperInterface {

}
