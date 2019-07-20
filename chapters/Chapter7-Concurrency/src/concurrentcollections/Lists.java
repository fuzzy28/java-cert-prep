package concurrentcollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Lists {

	static void concurrentList() {
		List<String> names = new ArrayList<>(Arrays.asList("a", "b", "c"));
		try {
			for (String s : names) {
				names.add("1");
			}
		} catch(ConcurrentModificationException cme) {
			System.err.println("List add: ConcurrentModificationException!");
		}
		
		names = new CopyOnWriteArrayList<>(Arrays.asList("a","b","c"));
		for (String s : names) {
			names.add("1");
		}
		System.out.println("CopyOnWriteArrayList size: " + names.size());
	}

	public static void main(String[] args) {
		concurrentList();
	}
}
