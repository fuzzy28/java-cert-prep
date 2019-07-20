package concurrentcollections;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashMaps {

	static void concurrentHashMap() {
		Map<String, String> s = new HashMap<>();
		s.put("a", "a");
		s.put("b", "b");

//		this throws ConcurrentModificationException
		try {
			for (String k : s.keySet()) {
				s.remove(k);
			}
		} catch (ConcurrentModificationException cme) {
			System.err.println("HashMap: ConcurrentModificationException!!!");
		}

		s = new ConcurrentHashMap<>();
		s.put("a", "a");
		s.put("b", "b");
		for (String k : s.keySet()) {
			s.remove(k);
		}
		System.out.println("Concurrent hashmap size: " + s.size());
	}

	public static void main(String[] args) {
		concurrentHashMap();
	}
}

//to make it thread safe, we put synchronize or use HashTable
//alternatively, we can use ConcurrentHashMap!
class HashMapUsage {
	Map<String, String> map = new HashMap<>();

	synchronized void addEntry(String key, String value) {
		map.put(key, value);
	}

	synchronized void getEntry(String key) {
		map.get(key);
	}
}