package streams;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

public class EmptyStreams {

	static void emptyStream() {
		System.out.println("-------emptyStream-------");
		Stream<Integer> i = Stream.empty();
		Optional<Integer> o = i.filter(ii -> ii < 10).max((x, y) -> x - y);
		System.out.println("No error on empty stream");
		try {
			System.out.println(o.get());
		} catch (NoSuchElementException nse) {
			System.err.println("Error is in optional if it's empty!");
		}
	}

	public static void main(String[] args) {
		emptyStream();
	}
}
