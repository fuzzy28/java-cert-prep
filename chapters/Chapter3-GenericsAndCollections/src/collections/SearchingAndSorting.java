package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import comparabe.comparator.Student;

public class SearchingAndSorting {

	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		students.add(new Student("b", 2));
		students.add(new Student("c", 3));
		students.add(new Student("a", 1));
		Collections.sort(students);
		System.out.println(students);
		
		List<SearchingAndSorting> list = new ArrayList<>();
//		Collections.sort(list); // DOES NOT COMPILE, object does not implement Comparable
		System.out.println(list);
	}
}
