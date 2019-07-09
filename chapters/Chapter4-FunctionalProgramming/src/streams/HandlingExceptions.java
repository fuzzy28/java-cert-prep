package streams;

import java.util.function.Function;

public class HandlingExceptions {

	public static void main(String[] args) {
//		Function<String, Integer> func = HandlingExceptions::method1; // Won't compile, unhandle checked exception
		Function<String, Integer> func = HandlingExceptions::callMethod1Safe;
		System.out.println(func.apply("1"));
		System.out.println(func.apply("error"));
	}

	static Integer callMethod1Safe(String input) {
		try {
			return method1(input);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	static Integer method1(String input) throws Exception {
		return Integer.parseInt(input);
	}

}
