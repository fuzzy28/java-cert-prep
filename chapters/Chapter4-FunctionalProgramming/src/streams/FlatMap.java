package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FlatMap {

	static void basicUsage() {
		List<String> l1 = Arrays.asList("a","b","c");
		List<String> l2 = Arrays.asList("d","e","f");
		Stream.of(l1,l2).flatMap(x -> x.stream()).forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		basicUsage();
	}
}
