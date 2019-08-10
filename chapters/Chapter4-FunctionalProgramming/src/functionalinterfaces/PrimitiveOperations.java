package functionalinterfaces;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimitiveOperations {

	static void max() {
		System.out.println("----------max()----------");
		IntStream is = Arrays.stream(new int[] { 1, 2, 3, 4, 5 });
		System.out.println(is.max());
	}
	
	public static void main(String[] args) {
		Stream<Integer> is = Arrays.asList(1,2,3,4).stream();
		max();
	}

}
