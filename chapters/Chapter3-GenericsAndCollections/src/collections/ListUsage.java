package collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListUsage {

	public static void main(String[] args) {
		System.out.println("------------------ArrayList------------------");
		new ArrayListImplementation();
		System.out.println("------------------LinkedList------------------");
		new LinkedListImplementation();
	}

	static class ArrayListImplementation {

		public ArrayListImplementation() {
			List<String> strings = new ArrayList<String>();
			System.out.println(strings.add("String1")); // List.add(E) returns boolean
			System.out.println(strings.add("String2"));
			System.out.println(strings.add("String3"));
			strings.add(2, "String2.5");
//			System.out.println(strings.add(1, "String1.5")); // DOES NOT COMPILE!, list.add with specific index returns void
			strings.forEach(System.out::println);

			System.out.println("___________________\nRemoving element that is not in the list");
			System.out.println(strings.remove("StringX")); // should return false
			strings.forEach(System.out::println);

			System.out.println("___________________\nRemoving String1");
			System.out.println(strings.remove("String1")); // List.remove(E) returns boolean
			strings.forEach(System.out::println);

			System.out.println("___________________\nRemoving element at index 1");
			System.out.println("Element removed:" + strings.remove(1)); // List.remove(index) returns the element
																		// removed
//			System.out.println(strings.remove(200)); // Runtime Exception! index out of bounds!
			strings.forEach(System.out::println);

			System.out.println(strings.isEmpty() ? "Empty!" : "Not empty!");
			System.out.println("Size is: " + strings.size());
			System.out.println("Index of String3: " + strings.indexOf("String3"));
			System.out.println("Index of 'Not found': " + strings.indexOf("Not found"));
			System.out.println("Setting index 0 value to '0' : " + strings.set(0, "0")); // returns the previous element
			System.out.println("___________________\nPrinting again");
			strings.forEach(System.out::println);
			
//			strings.forEach(x -> strings.add(x)); // throws concurrentModificationException
		}
	}

	// Implements both List, Double-ended Queue (Deque)
	static class LinkedListImplementation {
		public LinkedListImplementation() {
			LinkedList<String> linkedList = new LinkedList<>();
			linkedList.add("a"); //add > linkedLast
			linkedList.add("b");
			linkedList.addFirst("before a"); //addFirst > linkedFirst
			linkedList.addLast("last item 1"); //addLast > LinkedLast
			linkedList.offer("last item 2"); // offer > add > LinkedLast
			linkedList.offerFirst("first item"); //offerFirst > addFirst > LinkedFirst		
			linkedList.push("push first"); //pushFirst > addFirst > LinkedFirst
			linkedList.forEach(System.out::println);
		}
	}
}
