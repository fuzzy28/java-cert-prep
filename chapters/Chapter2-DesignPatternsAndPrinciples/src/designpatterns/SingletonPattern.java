package designpatterns;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class SingletonPattern {

	public static void main(String[] args) {
		EagerInitSingleton eager = EagerInitSingleton.getInstance();
		ExecutorService e = Executors.newFixedThreadPool(100);
		List<Future<Integer>> returnValues = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			returnValues.add(e.submit(() -> eager.incrementCounter()));
		}
		
		returnValues.forEach(x -> {
			try {
				System.out.println("Future" + x.get().intValue());
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ExecutionException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}

}

class EagerInitSingleton {

	private static final EagerInitSingleton instance = new EagerInitSingleton();
	static final String constant = "constant";
	private AtomicInteger counter = new AtomicInteger(0);
	private int regularCounter = 0;

	// private constructor
	private EagerInitSingleton() {
	}

	public static EagerInitSingleton getInstance() {
		return instance;
	}

	public int incrementCounter() {
		return counter.incrementAndGet();
	}
	
	//NOT THREAD SAFE!
	public int incrementRegularCounter() {
		return ++regularCounter;
	}
}

class LazyInitSingleton {

	private static LazyInitSingleton instance;

	// private constructor
	private LazyInitSingleton() {
	}

	// mark static getInstance method with synchronized method to make it THREAD
	// SAFE!
	public static synchronized LazyInitSingleton getInstance() {
		return Optional.ofNullable(instance).orElse(new LazyInitSingleton());
	}

}

class DoubleCheckLockingSingleton {

	private static DoubleCheckLockingSingleton doubleCheckLockingSingleton;

	// private constructor
	private DoubleCheckLockingSingleton() {
	}

	// don't mark static getInstance as synchronized as this has performance issue.
	public static DoubleCheckLockingSingleton getInstance() {
		if (doubleCheckLockingSingleton == null) {
			synchronized (DoubleCheckLockingSingleton.class) {
				if (doubleCheckLockingSingleton == null) {
					doubleCheckLockingSingleton = new DoubleCheckLockingSingleton();
				}
			}
		}
		return doubleCheckLockingSingleton;
	}
}