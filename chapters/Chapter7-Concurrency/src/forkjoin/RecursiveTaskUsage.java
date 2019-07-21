package forkjoin;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RecursiveTaskUsage extends RecursiveTask<Double> {

	private List<Double> values;
	private int start;
	private int end;
	private static final int threshold = 10;

	public RecursiveTaskUsage(List<Double> values, int start, int end) {
		this.values = values;
		this.start = start;
		this.end = end;
	}

	public Double compute() {
		if ((end - start) <= threshold) {
			System.out.println("Printing between " + start + " and " + end);
			return IntStream.range(start, end).mapToDouble(i -> values.get(i)).sum();
		}
		int middle = ((end - start) / 2) + start;
		System.out.printf("Splitting... start=%d,middle=%d,end=%d %n", start, middle, end);
		RecursiveTaskUsage left = new RecursiveTaskUsage(values, start, middle);
		RecursiveTaskUsage right = new RecursiveTaskUsage(values, middle, end);
		right.fork(); // fork first to execute in separate thread!
		return left.compute() + right.join();  // then compute, task will wait. Join the result of the forked task.
	}

	public static void main(String[] args) {
		List<Double> values = IntStream.rangeClosed(1,100).mapToObj(i -> new Double(i + "")).collect(Collectors.toList());
		ForkJoinTask<Double> fjt = new RecursiveTaskUsage(values, 0, values.size());
		ForkJoinPool fjp = new ForkJoinPool();
		System.out.println("Result is : " + fjp.invoke(fjt));
	}
}