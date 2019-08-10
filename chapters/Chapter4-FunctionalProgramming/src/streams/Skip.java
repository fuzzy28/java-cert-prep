package streams;

import java.util.stream.Stream;

public class Skip {

	public static void main(String[] args) {
		Stream<String> names = Stream.of("A", "B", "C", "D");
		names.peek(x -> System.out.println("processing..." + x)).skip(2).forEach(x -> System.out.println("printing..." + x));
		
	}
}

