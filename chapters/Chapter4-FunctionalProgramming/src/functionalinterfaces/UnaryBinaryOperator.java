package functionalinterfaces;

import java.util.concurrent.Future;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryBinaryOperator {

	static void unaryOperator() {

		UnaryOperator<String> applyToString = String::toUpperCase;
		UnaryOperator<Integer> applyToInteger = (i) -> i * 10;

		System.out.println("Change string to uppercase: " + applyToString.apply("joel"));
		System.out.println("Multiply number to 10: " + applyToInteger.apply(10));

	}

	static void binaryOperator() {
		BinaryOperator<String> concatStrings = (s1, s2) -> s1.concat(s2);
		BinaryOperator<Integer> multTwoNumbers = (i1, i2) -> i1 * i2;
		
		System.out.println("Concat two strings: " + concatStrings.apply("Joel", " Ruelos"));
		System.out.println("Multiply two numbers: " + multTwoNumbers.apply(2, 6));
	}

	public static void main(String[] args) {
		System.out.println("__________ unaryOperator __________");
		unaryOperator();
		System.out.println("__________ binaryOprator __________");
		binaryOperator();
	}
}
