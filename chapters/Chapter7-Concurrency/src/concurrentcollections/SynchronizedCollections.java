package concurrentcollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.List;

public class SynchronizedCollections {

	static void sychronizedList() {
		System.out.println("---------sychronizedList---------");
		List<String> notThreadSafeList = new ArrayList<>(Arrays.asList("a", "b", "c"));
		List<String> threadSafeList = Collections.synchronizedList(notThreadSafeList);
		System.out.println("Implementation class: " + threadSafeList.getClass());
		try {
			for(String s : threadSafeList) {
				threadSafeList.add("1");
			}
		} catch (ConcurrentModificationException cme) {
			System.err.println("ConcurrentModificationException!");
		}
	}

	public static void main(String[] args) {
		sychronizedList();
	}

}
