package exceptions;

import java.util.Arrays;

public class TryWithResources {

	static void tryWithResources() throws Exception { // exception need to re throw, else compile error
		try (MyAutoCloseable ac = new MyAutoCloseable("resource1");
				MyAutoCloseable ac2 = new MyAutoCloseable("resource2")) {
//			ac = null; // won't compile, ac is effective final
			ac.doWork();
			ac2.doWork();
			throw new Exception("Error inside try..."); // primary, any exception will be treated as suppressed
		}
	}

	public static void main(String[] args) {
		try {
			tryWithResources();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			System.out.println("Suppressed errors:");
			Arrays.asList(e.getSuppressed()).stream().map(Throwable::getMessage).forEach(System.out::println);
		}
	}
}

class MyAutoCloseable implements AutoCloseable {

	private String name;

	public MyAutoCloseable(String name) {
		this.name = name;
	}

	void doWork() {
		System.out.println(name + " doing work...");
	}

	@Override
	public void close() throws Exception {
		System.out.println("Closing resource: " + name);
		throw new MyException("Error while closing resource: " + name);
	}
}