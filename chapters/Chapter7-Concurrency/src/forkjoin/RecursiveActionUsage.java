package forkjoin;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RecursiveActionUsage extends RecursiveAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2620920589458998377L;
	private List<Integer> numbers;
	static final int threshold = 5;
	int start;
	int end;

	public RecursiveActionUsage(List<Integer> numbers, int start, int end) {
		this.numbers = numbers;
		this.start = start;
		this.end = end;
	}

	public void compute() {
		if ((end - start) <= threshold) {
			System.out.println("Printing between index " + start + " and " + end);
			for (int i = start; i < end; i++) {
				System.out.println("Index at: " + i + ", Value: " + numbers.get(i));
			}
		} else {
			int middle = ((end - start) / 2) + start;
			System.out.printf("Splitting... start=%d,middle=%d,end=%d %n", start, middle, end);
			invokeAll(new RecursiveActionUsage(numbers, start, middle), new RecursiveActionUsage(numbers, middle, end));
		}

	}

	public static void main(String[] args) {
		List<Integer> numbers = IntStream.rangeClosed(1, 1000).mapToObj(i -> i).collect(Collectors.toList());
		ForkJoinTask<?> fjt = new RecursiveActionUsage(numbers, 0, numbers.size());
		ForkJoinPool fjp = new ForkJoinPool();
		fjp.invoke(fjt);
	}

}
