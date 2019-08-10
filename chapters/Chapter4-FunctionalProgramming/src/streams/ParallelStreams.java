package streams;

import java.util.Arrays;
import java.util.List;

public class ParallelStreams {

	static void tryReduce() {
		List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
		String result = letters.parallelStream().reduce("_", (a, b) -> a.concat(b));
		System.out.println(result);
	}

	static void tryReduce2() {
		List<String> vals = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "a", "b", "c", "d", "e", "f", "g", "a",
				"b", "c", "d", "e", "f", "g", "a", "b", "c", "d", "e", "f", "g");
		String join = vals.parallelStream().peek(System.out::println).reduce("_", (a, b) -> {
			System.out.println("reducing " + a + " and " + b + " Thread: " + Thread.currentThread().getName());
			return a.concat(b);
		}, (a, b) -> {
			System.out.println("combining " + a + " and " + b + " Thread: " + Thread.currentThread().getName());
			return a.concat(b);
		});
		System.out.println(join);
	}

	static void tryReduce3() {
		List<Integer> i = Arrays.asList(10, 20, 30);
		int result = i.parallelStream().reduce(10, (a,b) -> {
			
			System.out.println("Adding : " + a + " and " + b);
			return  a + b;
		});
		System.out.println(result);
	}

	public static void main(String[] args) {
		tryReduce();
		tryReduce2();
		tryReduce3();
	}

}
