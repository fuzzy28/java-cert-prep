package functionalinterfaces;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionUsage {

	static void function() {
		Function<String, Boolean> stringToBool = (s) -> s.equalsIgnoreCase("true");
		Function<String, Boolean> stringToBool2 = Boolean::valueOf;

		Function<Boolean, String> booleanToString = (b) -> b ? "boolean is true" : "boolean is false";

		Function<String, String> stringToBooleanToString = stringToBool.andThen(booleanToString);

		System.out.println("Converting string boolean to boolean: " + stringToBool.apply("TrUe"));
		System.out.println("Converting string boolean to boolean: " + stringToBool2.apply("TrUe"));
		System.out.println("Converting string boolean to boolean: " + stringToBool.apply("Tues"));
		System.out.println("Converting string boolean to boolean string: " + stringToBooleanToString.apply("TrUe"));

	}

	static void biFunction() {
		BiFunction<String, String, Boolean> stringsTheSame = (s1, s2) -> s1.equalsIgnoreCase(s2);
		BiFunction<String, String, Boolean> stringsTheSame2 = String::equalsIgnoreCase;
		System.out.println("Apply whether two strings are equal: " + stringsTheSame.apply("JOEL", "jOEl"));
		System.out.println("Apply whether two strings are equal: " + stringsTheSame2.apply("RUELOS", "ruelos"));

	}

	static void triFunction() {
		TriFunction<String, String, String, String> concatenateAll = (a, b, c) -> a + b + c;

		System.out.println(
				"Using tri function to concat three Strings: " + concatenateAll.apply("Joel", " Ruelos", " Jr."));
	}

	static void andThenVsCompose() {
		Function<Integer, Integer> addOne = (i) -> Integer.valueOf(i).intValue() + 1;
		Function<Integer, Integer> mulTwo = (i) -> Integer.valueOf(i).intValue() * 2;
		Function<Integer, Integer> addOneAndMultByTwo = addOne.andThen(mulTwo);
		Function<Integer, Integer> multByTwoAndAddOne = addOne.compose(mulTwo);
		System.out.println("Add 1 then add 2 from 10: " + addOneAndMultByTwo.apply(10));
		System.out.println("Add 1 then add 2 from 10: " + multByTwoAndAddOne.apply(10));
	}

	public static void main(String[] args) {
		System.out.println("__________ function __________ ");
		function();
		System.out.println("__________ bifunction __________ ");
		biFunction();
		System.out.println("__________ trifunction __________ ");
		triFunction();
		System.out.println("__________ andThenVsCompose __________ ");
		andThenVsCompose();
	}
}

interface TriFunction<T, U, V, R> {

	R apply(T t, U u, V v);
}
