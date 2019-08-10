package functionalinterfaces;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamOperations {

	static List<Integer> i = Arrays.asList(1, 2, 3, 4);

	static void max() {
		System.out.println("----------max()----------");

		Optional<Integer> max = i.stream().max(Integer::compare);
		System.out.println(max.get());
	}

	static void count() {
		System.out.println("----------count()----------");
		long count = i.stream().count();
		System.out.println(count);
	}

	public static void main(String[] args) {
		max();
		count();
	}

}
