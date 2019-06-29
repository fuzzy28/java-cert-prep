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

	static void createOptionalOrElse() {
		String nullValue = null;

		System.out.println("Get or else for null: " + Optional.ofNullable(nullValue).orElse(getDefault()));
		// or else method is always invoke even if the the value is not null
		System.out.println("Get or else for non null: " + Optional.ofNullable("Joel Ruelos").orElse(getDefault()));
	}

	static void createOptionalOrElseGet() {
		String nullValue = null;
		System.out.println("Get or else get: " + Optional.ofNullable(nullValue).orElseGet(OptionalUsage::getDefault));
	}

	static void createOptionalOrElseThrow() {
		String value = null;
		try {
			System.out.println("Get or else throw: " + Optional.ofNullable(value).orElseThrow(() -> {
				throw new IllegalArgumentException("cannot be null");
			}));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	static String getDefault() {
		System.out.println("Getting default");
		return "Default Name";
	}
	
	static void createOptionalWithFilter() {
		String name = "Joel";
		System.out.println(Optional.ofNullable(name).filter(s -> s.startsWith("a")).orElse("Name doesn't start with 'a'!"));		
		Integer age = 27;
		System.out.println("Legal age? : " +Optional.ofNullable(age).filter(i -> i > 18).isPresent());
	}
	
	static void createOptionalAndMap() {
		String name = "Joel";
		Optional.ofNullable(name).map(String::length).ifPresent(System.out::println);
	}
	
	public static void main(String[] args) {
		System.out.println("___________createEmptyOptional___________");
		createEmptyOptional();
		System.out.println("___________createOptionalOfString___________");
		createOptionalOfString();
		System.out.println("___________createOptionalOfNullableString___________");
		createOptionalOfNullableString();
		System.out.println("___________createOptionalOrElse___________");
		createOptionalOrElse();
		System.out.println("___________createOptionalOrElseGet___________");
		createOptionalOrElseGet();
		System.out.println("___________createOptionalOrElseThrow___________");
		createOptionalOrElseThrow();
		System.out.println("___________createOptionalWithFilter___________");
		createOptionalWithFilter();
		System.out.println("___________createOptionalAndMap___________");
		createOptionalAndMap();
	}
}
