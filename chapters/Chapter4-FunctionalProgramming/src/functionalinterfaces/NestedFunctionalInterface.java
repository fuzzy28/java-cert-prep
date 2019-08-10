package functionalinterfaces;

import java.util.function.IntFunction;
import java.util.function.UnaryOperator;

public class NestedFunctionalInterface {

	static void test() {
		IntFunction<UnaryOperator<Integer>> i = a -> b -> a - b;
		System.out.println(i.apply(10).apply(5));
	}
	
	public static void main(String[] args) {
		test();
	}
}
