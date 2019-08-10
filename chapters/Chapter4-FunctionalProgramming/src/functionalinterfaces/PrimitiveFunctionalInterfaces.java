package functionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleSupplier;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongSupplier;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;

public class PrimitiveFunctionalInterfaces {

	static void booleanFunctionalInterface() {
		System.out.println("----Boolean supplier----");
		BooleanSupplier bs = () -> new Random().nextInt(10) > 5;
		System.out.println("Get as boolean: " + bs.getAsBoolean());
	}

	static void intFunctionalInterface() {
		System.out.println("----Int supplier----");
		IntSupplier is = () -> new Random().nextInt(10);
		System.out.println("Get as Int: " + is.getAsInt());
		System.out.println("----Int consumer----");
		IntConsumer ic = (x) -> System.out.println("Accept integer: " + x);
		ic.accept(new Random().nextInt(10));
		System.out.println("----Int predicate----");
		IntPredicate ip = (i) -> i > 5;
		System.out.println("Test int: " + ip.test(new Random().nextInt(10)));
		System.out.println("----Int To <T> function----");
		IntFunction<Double> ii = (i) -> (double) i;
		System.out.println("Int to double function: " + ii.apply(10));
		System.out.println("----<T> To Int function----");
		ToIntFunction<String> tif = Integer::parseInt;
		System.out.println("String to int function: " + tif.applyAsInt("2"));
		System.out.println("----<T> To Int Bi function----");
		ToIntBiFunction<Integer, Integer> tibf = (i1, i2) -> i1 + i2;
		System.out.println("Two integer object to int: " + tibf.applyAsInt(10, 20));
	}

	static void doubleFunctionInterface() {
		System.out.println("----Double supplier----");
		DoubleSupplier ds = Math::random;
		System.out.println("Get as double: " + ds.getAsDouble());
		System.out.println("----Double consumer----");
		DoubleConsumer dc = d -> System.out.println("Random double: " + d);
		dc.accept(Math.random());
		System.out.println("----Double predicate----");
		DoublePredicate dp = d -> d > 3.;
		System.out.println("Random greater than 3: " + dp.test(Math.random()));
		System.out.println("----Double function----");
		DoubleFunction<String> df = d -> "Double is " + d;
		System.out.println("Double to String function: " + df.apply(Math.random()));
	}

	static void longFunctionInterface() {
		System.out.println("----Long supplier----");
		LongSupplier ls = () -> new Random().nextLong();
		System.out.println("Get as long: " + ls.getAsLong());
		System.out.println("----Long consumer----");
		LongConsumer lc = l -> System.out.println("Random long: " + l);
		lc.accept(new Random().nextLong());
		System.out.println("----Long predicate----");
		LongPredicate lp = l -> l > 3;
		System.out.println("Random greater than 3: " + lp.test(new Random().nextLong()));
		System.out.println("----Long function----");
		LongFunction<String> lf = d -> "Double is " + d;
		System.out.println("Long to String function: " + lf.apply(new Random().nextLong()));
	}

	static void convertObjectToPrimitive() {
		System.out.println("----convertObjectToPrimitive----");
		int[] iValues = { 1, 2, 3 };
		Arrays.stream(iValues).asLongStream();
	}

	public static void main(String[] args) {
		booleanFunctionalInterface();
		intFunctionalInterface();
		doubleFunctionInterface();
		longFunctionInterface();
	}
}
