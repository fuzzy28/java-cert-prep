package collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingMapping {

	static List<String> names = Arrays.asList("Joel", "Ruelos", "Joel", "Joel", "Fransico", "Ruelos", "Fransico",
			"Test", "Mark");

	static void groupingByDefaultCollection() {
		System.out.println("---------Grouping by (default collection list)---------");
		Map<Integer, List<String>> map = names.stream().collect(Collectors.groupingBy(String::length));
		System.out.println(map.getClass() + ": " + map);

		Map<Integer, List<String>> treeMap = names.stream()
				.collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toList()));
		System.out.println(treeMap.getClass() + ": " + treeMap);
	}

	static void groupingBySetCollection() {
		System.out.println("---------Grouping by (set collection)---------");
		Map<Integer, Set<String>> map = names.stream()
				.collect(Collectors.groupingBy(String::length, Collectors.toSet()));
		System.out.println(map);
	}

	static void groupingByTreeSetCollection() {
		System.out.println("---------Grouping with mapping---------");
		Map<String, Set<Student>> map = names.stream().collect(
				Collectors.groupingBy(Function.identity(), Collectors.mapping(Student::new, Collectors.toSet())));
		System.out.println(map);
	}

	public static void main(String[] args) {
		groupingByDefaultCollection();
		groupingBySetCollection();
		groupingByTreeSetCollection();
	}
}

class Student {
	String name;

	public Student(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + "]";
	}

}