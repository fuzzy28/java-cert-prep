package streams;

import java.util.Arrays;

public class ParallelSetAll {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		Arrays.parallelSetAll(arr, (i) -> arr[i]);
		Arrays.stream(arr).forEach(System.out::println);
	}

}
