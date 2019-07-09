package collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class PartinioningBy {

	static List<String> names = Arrays.asList("Joel", "Ruelos", "Joel", "Joel", "Fransico", "Ruelos", "Fransico",
			"Test", "Mark", "John");

	static void partitioningByDefaultCollection() {
		System.out.println("--------partitioningByDefaultCollection--------");
		Map<Boolean, List<String>> map = names.stream().collect(Collectors.partitioningBy(s -> s.startsWith("J")));
		System.out.println(map);
	}

	static void partitioningByCollectionSet() {
		System.out.println("--------partitioningByCollectionSet--------");
		Map<Boolean, Set<String>> map = names.stream()
				.collect(Collectors.partitioningBy(s -> s.startsWith("J"), Collectors.toSet()));
		System.out.println(map);
	}

	public static void main(String[] args) {
		partitioningByDefaultCollection();
		partitioningByCollectionSet();
	}
}
