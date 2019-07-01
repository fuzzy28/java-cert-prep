package streams;

import java.util.List;
import java.util.function.LongFunction;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PrimitiveStreams {

	static void doubleStream() {
		System.out.println("_____________DoubleStream_____________");
		DoubleStream ds = DoubleStream.of(1.0, 4., 19.);
		System.out.println("Max: " + ds.max().getAsDouble());
		DoubleStream ds2 = DoubleStream.empty();
		System.out.println("Max from empty: " + ds2.max().orElse(0.));
		DoubleStream ds3 = DoubleStream.generate(() -> Math.random()).limit(2);
		ds3.forEach(System.out::println);
		System.out.println("Using builder pattern to initialize double stream");
		DoubleStream ds4 = DoubleStream.builder().add(2).add(8).build();
		ds4.forEach(System.out::println);
		System.out.println("Converting double primitive to double object");
		DoubleStream.of(2.0, 4.0).mapToObj(x -> new Double(x)).forEach(System.out::println);
	}

	static void intStream() {
		System.out.println("_____________IntStream_____________");
		System.out.println("Printing values from 1 to 9 (range)");
		IntStream.range(1, 10).forEach(System.out::print);
		System.out.println("\nPrinting values from 1 to 10 (rangeClosed)");
		IntStream.rangeClosed(1, 10).forEach(System.out::print);
		System.out.println("\nConverting integers to double");
		IntStream.of(1, 2, 3).mapToDouble(x -> x).forEach(System.out::println);
	}

	static void longStream() {
		System.out.println("_____________LongStream_____________");
		System.out.println("Printing values from 1 to 9 (range)");
		System.out.println("Printing values from 1 to 9 (range)");
		LongStream.range(1, 10).forEach(System.out::print);
		System.out.println("\nPrinting values from 1 to 10 (rangeClosed)");
		LongStream.rangeClosed(1, 10).forEach(System.out::print);
		System.out.println();
	}

	static void primitiveFunctions() {
		System.out.println("_____________Primitive conversion functions_____________");
		LongToIntFunction lti = l -> (int) l;
		LongToDoubleFunction ltd = l -> l; // autoboxing
		LongUnaryOperator luo = l -> l + 1;
		LongFunction<String> lf = l -> "(" + l + ")";
		System.out.println("Converting long values to int");
		LongStream.of(1L, 2, 3).mapToInt(lti).forEach(System.out::print);
		System.out.println("\nConverting long values to double");
		LongStream.of(1L, 2, 3).mapToDouble(ltd).forEach(System.out::println);
		System.out.println("Converting long values to long");
		LongStream.of(1L, 2, 3).map(luo).forEach(System.out::println);
		System.out.println("Converting long values to String");
		LongStream.of(1L, 2, 3).mapToObj(lf).forEach(System.out::println);
	}

	public static void main(String[] args) {
		doubleStream();
		intStream();
		longStream();
		primitiveFunctions();
	}
}
