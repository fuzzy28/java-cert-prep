package collections;

import java.util.HashMap;
import java.util.Map;

public class MapNewMethods {

	static void putIfAbsent() {
		Map<String, String> map = new HashMap<>();
		map.put("name", "joel");

		System.out.println("Put 'x' if 'name' is absent: " + map.putIfAbsent("name", "x")); // won't replace since name
																							// already exists
		System.out.println("Put 'ruelos' if 'lastName' is absent: " + map.putIfAbsent("lastName", "ruelos")); // performs
																												// atomic
																												// put

		System.out.println(map);
	}

	static void merge() {
		Map<String, String> map = new HashMap<>();
		map.put("name", "Joel");

		map.merge("name", " Jr.", String::concat); // will give you an option on what to do in case key exists, like
													// merge two existing values.

		map.merge("lastName", "Ruelos", (a, b) -> "this wont get executed");

		System.out.println(map);
	}

	static void computeIfAbsent() {
		Map<String, String> map = new HashMap<>();
		map.put("name", "joel");

		System.out.println(map.computeIfAbsent("lastName", (s) -> new String("Ruelos")));

		System.out.println(map);
	}

	static void computeIfPresent() {
		Map<String, String> map = new HashMap<>();
		map.put("name", "joel");

//		if(map.containsKey("name")) {
//			String s = map.get("name");
//			map.put("name", s + s);
//		}
		// instead of doing the above, we can perform atomic operation like below
		map.computeIfPresent("name", (a, b) -> b + b);

		System.out.println(map);
	}

	public static void main(String[] args) {
		System.out.println("__________ putIfAbsent __________");
		putIfAbsent();
		System.out.println("__________ merge __________");
		merge();
		System.out.println("__________ computeIfAbsent __________");
		computeIfAbsent();
		System.out.println("__________ computeIfPresent __________");
		computeIfPresent();
	}
}
