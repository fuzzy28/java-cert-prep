package collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SetUsage {

	public static void main(String[] args) {
		System.out.println("_________________________ HashSet _________________________");
		new HashSetImplementation();
		System.out.println("_________________________ TreeSet _________________________");
		new TreeSetImplementation();
	}

	static class HashSetImplementation {
		public HashSetImplementation() {
			Set<String> names = new HashSet<>();
			System.out.println("Adding new name: " + names.add("ruelos")); // returns boolean
			System.out.println("Adding new name: " + names.add("joel")); // returns boolean
			System.out.println("Adding existing name: " + names.add("joel")); // returns false for already inserted
																				// element
			System.out.println("Adding new name: " + names.add("angel")); // returns boolean
			System.out.println("Printing unordered set");
			System.out.println("Result : " + names.stream().collect(Collectors.joining(",")));
		}
	}

	static class TreeSetImplementation {

		public TreeSetImplementation() {
			TreeSet<String> orderedNames = new TreeSet<>();
			System.out.println("Adding new name: " + orderedNames.add("ruelos")); // returns boolean
			System.out.println("Adding new name: " + orderedNames.add("joel")); // returns boolean
			System.out.println("Adding existing name: " + orderedNames.add("joel")); // returns false for already
																						// inserted element
			System.out.println("Adding new name: " + orderedNames.add("angel")); // returns boolean
			System.out.println("Printing unordered set");
			System.out.println("Result : " + orderedNames.stream().collect(Collectors.joining(",")));

			NavigableSet<Integer> treeSet = new TreeSet<>(Arrays.asList(10, 5, 7, 12, 20, 16));
			System.out.println("Ordered number Result : ");
			treeSet.stream().forEach(System.out::println);
			System.out.println("Lower 100: " + treeSet.lower(100)); // < "20"
			System.out.println("Higher 10: " + treeSet.higher(10)); // > "12"
			System.out.println("Ceiling 10: " + treeSet.ceiling(10)); // >= "10"
			System.out.println("Floor 5: " + treeSet.floor(5)); // <= "5"
			System.out.println("Lower 5: " + treeSet.lower(5)); // < "null"
			System.out.println("Higher 100: " + treeSet.higher(100)); // "null"
			System.out.println("Ceiling 100: " + treeSet.ceiling(100)); // "null"
		}
	}
}