package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ShortCircuitOperation {

	static List<String> names = Arrays.asList("joel", "angel", "james");

	static void allMatch() {
		System.out.println("-------allMatch-------");
		boolean allMatch = names.stream().peek(n -> System.out.println("Name is " + n))
				.allMatch(p -> p.startsWith("j"));
		System.out.println(allMatch);
	}

	static void noneMatch() {
		System.out.println("-------noneMatch-------");
		boolean noneMatch = names.stream().peek(n -> System.out.println("Name is " + n))
				.noneMatch(p -> p.startsWith("j"));
		System.out.println(noneMatch);
	}

	static void anyMatch() {
		System.out.println("-------anyMatch-------");
		boolean anyMatch = names.stream().peek(n -> System.out.println("Name is " + n))
				.anyMatch(p -> p.startsWith("j"));
		System.out.println(anyMatch);
	}

	static void findAny() {
		System.out.println("-------findAny-------");
		Optional<String> o = names.stream().peek(n -> System.out.println("Name is " + n)).parallel().findAny();
		o.ifPresent(v -> System.out.println("Value is: " + o.get()));
	}
	
	static void findFirst() {
		System.out.println("-------findFirst-------");
		Optional<String> o = names.stream().peek(n -> System.out.println("Name is " + n)).parallel().findFirst();
		o.ifPresent(v -> System.out.println("Value is: " + o.get()));
	}

	public static void main(String[] args) {
		allMatch();
		noneMatch();
		anyMatch();
		findAny();
		findFirst();
	}

}
