package streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MaxUsage {

	static void basicUsage() {
		List<Integer> i = Arrays.asList(1, 2, 3, 4);
		Optional<Integer> max = i.stream().max(Comparator.reverseOrder());
		max.ifPresent(x -> System.out.println("Max reverse order : " + x));
		max = i.stream().max(Comparator.naturalOrder());
		max.ifPresent(x -> System.out.println("Max natural order : " + x));
		max = i.stream().max(Collections.reverseOrder());
		max.ifPresent(x -> System.out.println("Max reverse order (Comparator) : " + x));
		max = i.stream().max((a, b) -> a - b);
		max.ifPresent(x -> System.out.println("Max comparator impl : " + x));
		max = i.stream().max(Comparator.comparing(x -> x));
		max.ifPresent(x -> System.out.println("Max comparator comparing : " + x));
		System.out.println("Max using reduce : " + i.stream().reduce((a, b) -> a > b ? a : b).get());
	}

	public static void main(String[] args) {
		basicUsage();
	}
}
