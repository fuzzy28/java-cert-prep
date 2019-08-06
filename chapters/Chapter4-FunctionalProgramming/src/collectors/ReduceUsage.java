package collectors;

import java.util.Arrays;
import java.util.List;

public class ReduceUsage {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("joel", "ruelos", "jr");
		System.out.println(names.stream().reduce(0, (a, b) -> a + b.length() , (a, b) -> a + b));
	}
}
