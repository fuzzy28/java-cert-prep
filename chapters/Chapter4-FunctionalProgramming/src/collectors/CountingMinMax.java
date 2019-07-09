package collectors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountingMinMax {

	static List<String> names = Arrays.asList("Joel", "Ruelos", "Joel", "Joel", "Fransico", "Ruelos", "Fransico",
			"Test", "Mark");

	static void counting() {
		System.out.println("Group by and the count");
		Map<String, Long> map = names.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(map);
	}

	static void maxBy() {
		System.out.println("Max by:");
		names.stream().collect(Collectors.maxBy(Comparator.naturalOrder()))
				.ifPresent(s -> System.out.println("Max is : " + s));
	}
	
	static void minBy() {
		System.out.println("Min by:");
		names.stream().collect(Collectors.minBy(Comparator.naturalOrder()))
				.ifPresent(s -> System.out.println("Min is : " + s));
	}

	public static void main(String[] args) {
		counting();
		maxBy();
		minBy();
	}
}
