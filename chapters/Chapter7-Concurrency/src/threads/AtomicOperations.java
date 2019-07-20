package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicOperations {
	static int ctr = 1;

	static void atomicBoolean() {
		System.out.println("--------Atomic Boolean--------");

		// instead of doing this
		boolean regularBooolean = false;
		if (!regularBooolean)
			regularBooolean = true;
		System.out.println("Regular boolean: " + regularBooolean);

		// do this
		AtomicBoolean ab = new AtomicBoolean(false);
		ab.weakCompareAndSet(false, true);
		System.out.println("Atomic boolean: " + ab.get());
	}

	static void atomicInteger() {
		System.out.println("--------Atomic Integer--------");

		// instead of doing this
		int i = 100;
		System.out.println("Regular int: " + ++i);

		// do this
		AtomicInteger ai = new AtomicInteger(100);
		System.out.println("Atomic integer: " + ai.incrementAndGet());
	}

	static void testImplications() throws InterruptedException {
		System.out.println("--------Using normal integer as a counter--------");
		ExecutorService s = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			s.submit(() -> {
				++ctr;
				System.out.println("Counter is " + ctr);
			});
		}
		s.shutdown();
		if(s.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
			s.shutdownNow();
		}
	}

	static void properWay() throws InterruptedException {
		System.out.println("--------Using Atomic integer as a counter--------");
		AtomicInteger ai = new AtomicInteger(1);
		ExecutorService s = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			s.submit(() -> System.out.println("Counter is " + ai.incrementAndGet()));
		}
		s.shutdown();
		if(s.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
			s.shutdownNow();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		atomicBoolean();
		atomicInteger();
		testImplications();
		properWay();
	}

}
