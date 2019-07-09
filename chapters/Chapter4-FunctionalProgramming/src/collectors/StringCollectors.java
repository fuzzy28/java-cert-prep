package collectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCollectors {

	static List<String> names = Arrays.asList("Joel", "Ruelos", "Angel");

	static void join() {
		System.out.println("Print names concatenated: " + names.stream().collect(Collectors.joining()));
	}

	static void joinDelimited() {
		System.out.println("Print names in comma delimitted: " + names.stream().collect(Collectors.joining(",")));
	}

	static void joinDelimetedPrefixSuffix() {
		System.out.println("Print names in pipe delimitted with prefix + suffix: "
				+ names.stream().collect(Collectors.joining("|", "<", ">")));
	}

	public static void main(String[] args) {
		join();
		joinDelimited();
		joinDelimetedPrefixSuffix();
	}
}
