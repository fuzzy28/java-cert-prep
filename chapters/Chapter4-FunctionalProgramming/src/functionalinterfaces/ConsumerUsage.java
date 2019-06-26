package functionalinterfaces;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerUsage {

	static void consumer() {
		Consumer<String> consumeString = System.out::println;
		Consumer<Integer> consumeInteger = System.out::println;
		Consumer<ConsumerUsage> consumeClass = System.out::println;

		consumeString.accept("Hello World!");
		consumeInteger.accept(6281992);
		consumeClass.accept(new ConsumerUsage());

	}

	static void biConsumer() {
		BiConsumer<Integer, String> intAndString = (i, s) -> {
			System.out.println("Queue number: " + i + " , Name: " + s);
		};

		BiConsumer<String, String> doubleString = (s1, s2) -> System.out.println(s1.concat(s2).toUpperCase()); // Better
																												// to
																												// use
																												// BinaryOperator

		intAndString.accept(20, "Joel");
		doubleString.accept("joel", " ruelos");

	}

	public static void main(String[] args) {
		System.out.println("___________ consumer ___________");
		consumer();
		System.out.println("___________ biconsumer ___________");
		biConsumer();
	}
}
