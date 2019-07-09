package collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectToMap {

	static void toMapUniqueElements() {
		System.out.println("-----------toMapWithDuplicates-----------");
		List<String> names = Arrays.asList("Joel", "Ruelos", "Angel", "Medina", "Fransico");
		Map<String, Integer> map = names.stream().collect(Collectors.toMap(Function.identity(), String::length));
		System.out.println(map);
	}

	static void toMapWithDuplicates() {
		System.out.println("-----------toMapWithDuplicates-----------");
		List<String> names = Arrays.asList("Joel", "Ruelos", "Joel", "Joel", "Fransico", "Ruelos", "Fransico");

		// Runtime Exception! collections contains duplicate elements, combiner is
		// required!
//		Map<String,String> map = names.stream().collect(Collectors.toMap(Function.identity(), Function.identity()));

		System.out.println("--Using default hashmap implementation--");
		Map<String, String> map = names.stream()
				.collect(Collectors.toMap(Function.identity(), Function.identity(), String::concat));
		System.out.println(map.getClass() + ": " + map);

		System.out.println("--Using concurrent hashmap--");
		Map<String, String> concurrentMap = names.stream().collect(
				Collectors.toMap(Function.identity(), Function.identity(), String::concat, ConcurrentHashMap::new));
		System.out.println(concurrentMap.getClass() + ": " + concurrentMap);
	}

	public static void main(String[] args) {
		toMapUniqueElements();
		toMapWithDuplicates();
	}
}
