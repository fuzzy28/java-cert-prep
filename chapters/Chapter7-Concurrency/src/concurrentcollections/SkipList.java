package concurrentcollections;

import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class SkipList {

	// concurrent sorted set
	static void concurrentSkipListSet() {
		System.out.println("--------concurrentSkipListSet--------");
		ConcurrentSkipListSet<String> s = new ConcurrentSkipListSet<>();
		s.add("x");
		s.add("a");
		s.add("b");
		System.out.println(s);
	}

	// concurrent sorted map
	static void concurrentSkipListMap() {
		System.out.println("--------concurrentSkipListSet--------");
		ConcurrentSkipListMap<String, String> s = new ConcurrentSkipListMap<>();
		s.put("x", "x");
		s.put("a", "a");
		s.put("b", "b");
		System.out.println(s);
	}

	public static void main(String[] args) {
		concurrentSkipListSet();
		concurrentSkipListMap();
	}
}
