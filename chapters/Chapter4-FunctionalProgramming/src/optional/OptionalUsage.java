package optional;

import java.util.Optional;

public class OptionalUsage {

	static void createEmptyOptional() {
		Optional<String> emptyString = Optional.empty();
		System.out.println("Optional empty - isPresent: " + emptyString.isPresent());
	}

	static void createOptionalOfString() {
		String name = "Joel";
		Optional<String> optionalName = Optional.of(name); // Can't be null else will throw NullPointerException
		System.out.println("Optional.of: " + optionalName.get());
	}

	static void createOptionalOfNullableString() {
		String nullValue = null;
		Optional<String> nullableName = Optional.ofNullable(nullValue);
//		nullableName.get(); // throws Runtime Exception when optional is null!
		System.out.println("Optional.ofNullable - isPresent: " + nullableName.isPresent());
		
		nullValue = "test";
		nullableName.ifPresent(System.out::println);

	}

	public static void main(String[] args) {
		createEmptyOptional();
		createOptionalOfString();
		createOptionalOfNullableString();
	}
}
