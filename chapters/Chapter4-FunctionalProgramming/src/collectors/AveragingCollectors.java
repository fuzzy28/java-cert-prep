package collectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AveragingCollectors {

	static List<String> i = Arrays.asList("1", "2", "3");
	static List<String> d = Arrays.asList("1.", "2.43", "3.75");

	static void averagingInt() {
		System.out.println("-------------averagingInt-------------");
		System.out.println(
				"Average of String numeric list: " + i.stream().collect(Collectors.averagingInt(Integer::parseInt)));

		// alternative
		System.out.println("Alternative to averaging collector using map: "
				+ i.stream().mapToInt(Integer::parseInt).average().getAsDouble());
	}

	static void averagingDouble() {
		System.out.println("-------------averagingDouble-------------");
		System.out.println("Average of String double list: "
				+ d.stream().collect(Collectors.averagingDouble(Double::parseDouble)));

		// alternative
		System.out.println("Alternative to averaging collector using map: "
				+ d.stream().mapToDouble(Double::parseDouble).average().getAsDouble());
	}

	static void averagingLong() {
		System.out.println("-------------averagingLong-------------");
		System.out.println(
				"Average of String long list: " + i.stream().collect(Collectors.averagingLong(Long::parseLong)));

		// alternative
		System.out.println("Alternative to averaging collector using map: "
				+ i.stream().mapToLong(Long::parseLong).average().getAsDouble());
	}

	public static void main(String[] args) {
		averagingInt();
		averagingDouble();
		averagingLong();
	}
}
