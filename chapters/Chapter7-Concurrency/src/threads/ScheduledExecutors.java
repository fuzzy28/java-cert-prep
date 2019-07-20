package threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ScheduledExecutors {

	static void singleThreadScheduledExecutor() throws ExecutionException, InterruptedException {
		System.out.println("--------singleThreadScheduledExecutor--------");
		ScheduledExecutorService s = Executors.newSingleThreadScheduledExecutor();
		Future<String> callable = s.schedule(() -> "Callable result after 1 sec", 1, TimeUnit.SECONDS);
		Future<?> runnable = s.schedule(() -> System.out.println("Runnable result after 1.5 sec"), 1500,
				TimeUnit.MILLISECONDS);
		System.out.println(callable.get());
		runnable.get();
		s.shutdown();
	}

	static void scheduleAtFixedRate() {
		System.out.println("--------scheduleAtFixedRate--------");
		ScheduledExecutorService s = Executors.newScheduledThreadPool(5);
		AtomicInteger counter = new AtomicInteger(1);
		s.scheduleAtFixedRate(() -> {
			sleep(1000);
			if (counter.get() == 5)
				s.shutdownNow();
			System.out.println("Fixed Rate: " + counter.getAndIncrement());
		}, 1500, 1000, TimeUnit.MILLISECONDS);
	}
	
	static void scheduleWithFixedDelay() {
		System.out.println("--------scheduleWithFixedDelay--------");
		ScheduledExecutorService s = Executors.newScheduledThreadPool(5);
		AtomicInteger counter = new AtomicInteger(1);
		s.scheduleWithFixedDelay(() -> {
			sleep(1000);
			if (counter.get() == 5)
				s.shutdownNow();
			System.out.println("Fixed Delay: " + counter.getAndIncrement());
		}, 1500, 1000, TimeUnit.MILLISECONDS);
	}
	
	static void sleep(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
		}
	}

	public static void main(String[] args) throws Exception {
		singleThreadScheduledExecutor();
		scheduleAtFixedRate();
//		scheduleWithFixedDelay();
	}

}
