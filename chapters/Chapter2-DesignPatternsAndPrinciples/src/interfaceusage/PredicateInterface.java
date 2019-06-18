package interfaceusage;

import java.util.function.Predicate;

public class PredicateInterface {

	public static void main(String[] args) {
		Predicate<String> pre = (s) -> s.startsWith("a");
		System.out.println(pre.test("abc"));
		System.out.println(pre.test("bc"));
	}
}
