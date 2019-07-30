package streams;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class InfiniteStreams {

	static void generate() {
		System.out.println("Generate 10 numbers from infinite stream");
		AtomicInteger i = new AtomicInteger(0);
		Stream.generate(() -> i.incrementAndGet()).limit(10).forEach(System.out::print);
		System.out.println();
	}

	static void iterate() {
		System.out.println("Iterate 10 numbers from infintie stream");
		Stream.iterate(1, (i) -> ++i).limit(10).forEach(System.out::print);
		System.out.println();
	}

	static void anyMatchFromInfiniteStream() {
		System.out.println("finding anymatch from infinite stream");
		System.out.println(Stream.generate(() -> 1).anyMatch((i) -> i >= 1));

		// INFINITE LOOP! below code hangs because it keeps looking for any match that
		// won't appear in the streams
//		System.out.println(Stream.generate(() -> 0).anyMatch((i) -> i >= 1)); 
//		System.out.println(Stream.iterate(1, (i) -> i + 2).anyMatch((i) -> (i % 2) == 0));

		System.out.println(Stream.iterate(1, (i) -> i * 5).peek((i) -> System.out.println("Checking value > 100: " + i))
				.anyMatch(i -> i > 100));
	}

	static void allMatchFromInfiniteStream() {
		System.out.println("Checking stream if all matches");

		// INFINITE LOOP! below code hangs because it keeps returning true and further
		// checking the infinite stream if all matches
//		System.out.println(Stream.generate(() -> 1).allMatch((i) -> i > 0));

		// it will immediately terminate only if any value from the stream didn't
		// satisfy the condition or returned false
		System.out.println(Stream.generate(() -> 1).allMatch((i) -> i == 0));
	}

	static void noneMatchFromInfiniteStream() {
		System.out.println("Checking stream if none matches");

		// INFINITE LOOP! below code hangs because it keeps returning true and further
		// checking the infinite stream if none matches
//		System.out.println(Stream.generate(() -> 1).noneMatch((i) -> i < 1));

		// it will immediately terminate only if any value from the stream satisfy the
		// condition or returned true
		System.out.println(Stream.generate(() -> 1).noneMatch((i) -> i == 1));
		System.out.println();

	}

	public static void main(String[] args) {
		generate();
		iterate();
		anyMatchFromInfiniteStream();
		allMatchFromInfiniteStream();
		noneMatchFromInfiniteStream();
	}

}
