package parallelstreams;

import java.util.Arrays;
import java.util.stream.Stream;

public class CreatingParallelStreams {

	static void create() {
		System.out.println("---------Create---------");
		Stream<Integer> parallelStream = Stream.of(1, 2, 3).parallel();
		parallelStream.forEach(System.out::println);
	}
	
	static void create2() {
		System.out.println("---------Create2---------");
		Arrays.asList(1,2,3).parallelStream().forEach(System.out::println);
	}

	public static void main(String[] args) {
		create();
		create2();
	}
}
