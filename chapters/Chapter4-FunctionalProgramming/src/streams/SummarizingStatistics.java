package streams;

import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.LongSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class SummarizingStatistics {

	static void intSummaryStatistics() {
		System.out.println("____________Int statistics____________");
		OptionalInt max = IntStream.of(1, 2, 3).max();
		if (max.isPresent())
			System.out.println("Max: " + max.getAsInt());
		OptionalInt min = IntStream.of(1, 2, 3).min();
		if (min.isPresent())
			System.out.println("Min: " + min.getAsInt());
		OptionalDouble avg = IntStream.of(1, 2, 3).average(); // NOTE: average returns OptionalDouble!
		if (avg.isPresent())
			System.out.println("Avg: " + avg.getAsDouble());
		long count = IntStream.of(1, 2, 3).count(); // NOTE: count returns long!
		System.out.println("Count: " + count);
		int sum = IntStream.of(1, 2, 3).sum();
		System.out.println("Sum:" + sum);
		System.out.println("____________Int summary statistics____________");
		IntSummaryStatistics iss = IntStream.of(1, 2, 3).summaryStatistics();
		System.out.println("Max: " + iss.getMax());
		System.out.println("Min: " + iss.getMin());
		System.out.println("Average: " + iss.getAverage());
		System.out.println("Count: " + iss.getCount());
		System.out.println("Sum: " + iss.getSum());
		iss.accept(4);
		System.out.println(iss.getMax());
	}

	static void doubleSummaryStatistics() {
		System.out.println("____________Double statistics____________");
		OptionalDouble max = DoubleStream.of(1., 2.0, 3).max();
		if (max.isPresent())
			System.out.println("Max: " + max.getAsDouble());
		OptionalDouble min = DoubleStream.of(1., 2.0, 3).min();
		if (min.isPresent())
			System.out.println("Min: " + min.getAsDouble());
		OptionalDouble avg = DoubleStream.of(1., 2.0, 3).average(); // NOTE: average returns OptionalDouble!
		if (avg.isPresent())
			System.out.println("Avg: " + avg.getAsDouble());
		long count = DoubleStream.of(1., 2.0, 3).count(); // NOTE: count returns long!
		System.out.println("Count: " + count);
		double sum = DoubleStream.of(1., 2.0, 3).sum();
		System.out.println("Sum:" + sum);
		System.out.println("____________Double summary statistics____________");
		DoubleSummaryStatistics iss = DoubleStream.of(1., 2.0, 3).summaryStatistics();
		System.out.println("Max: " + iss.getMax());
		System.out.println("Min: " + iss.getMin());
		System.out.println("Average: " + iss.getAverage());
		System.out.println("Count: " + iss.getCount());
		System.out.println("Sum: " + iss.getSum());
	}
	
	static void longSummaryStatistics() {
		System.out.println("____________Long statistics____________");
		OptionalLong max = LongStream.of(1L, 2, 3).max();
		if (max.isPresent())
			System.out.println("Max: " + max.getAsLong());
		OptionalLong min = LongStream.of(1L, 2, 3).max();
		if (min.isPresent())
			System.out.println("Min: " + min.getAsLong());
		OptionalDouble avg = LongStream.of(1L, 2, 3).average(); // NOTE: average returns OptionalDouble!
		if (avg.isPresent())
			System.out.println("Avg: " + avg.getAsDouble());
		long count = LongStream.of(1L, 2, 3).count(); // NOTE: count returns long!
		System.out.println("Count: " + count);
		long sum = LongStream.of(1L, 2, 3).sum();
		System.out.println("Sum:" + sum);
		System.out.println("____________Long summary statistics____________");
		LongSummaryStatistics iss = LongStream.of(1L, 2, 3).summaryStatistics();
		System.out.println("Max: " + iss.getMax());
		System.out.println("Min: " + iss.getMin());
		System.out.println("Average: " + iss.getAverage());
		System.out.println("Count: " + iss.getCount());
		System.out.println("Sum: " + iss.getSum());
	}

	public static void main(String[] args) {
		intSummaryStatistics();
		doubleSummaryStatistics();
		longSummaryStatistics();
	}
}
