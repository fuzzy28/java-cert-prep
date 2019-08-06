package functionalinterfaces;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Predicateusage {

	static void predicate() {
		Predicate<String> startsWithA = (s) -> s.toLowerCase().startsWith("a");
		Predicate<String> endsWithA = (s) -> s.toLowerCase().endsWith("a");
		Predicate<String> startsAndEndsWithA = startsWithA.and(endsWithA);
		Predicate<String> startsOrEndsWithA = startsWithA.or(endsWithA);
		Predicate<String> notStartsWithA = startsWithA.negate();
		System.out.println("String 'abc' starts with a: " + startsWithA.test("abc"));
		System.out.println("String 'abc' ends with a: " + endsWithA.test("abc"));
		System.out.println("String 'abca' starts AND ends with a: " + startsAndEndsWithA.test("abca"));
		System.out.println("String 'xbca' starts OR ends with a: " + startsOrEndsWithA.test("xbca"));
		System.out.println("String 'xbca' NOT starts with a: " + notStartsWithA.test("xbca"));
		
	}

	static void bipredicate() {

		BiPredicate<String, String> stringEquals = String::equals;
		System.out.println("String 'abc' and 'abc' are equals: " + stringEquals.test("abc", "abc"));
	}

	public static void main(String[] args) {
		System.out.println("__________ predicate __________");
		predicate();
		System.out.println("__________ bipredicate __________");
		bipredicate();
	}

}
