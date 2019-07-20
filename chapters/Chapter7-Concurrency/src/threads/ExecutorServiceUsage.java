package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ExecutorServiceUsage {

	static void singleThreadExecutor() throws InterruptedException {
		System.out.println("-------------singleThreadExecutor-----------");
		ExecutorService s = Executors.newSingleThreadExecutor();
		s.execute(() -> System.out.println("Executing single thread executor 1..."));
		s.execute(() -> System.out.println("Executing single thread executor 2..."));
		s.execute(() -> System.out.println("Executing single thread executor 3..."));
		s.shutdown(); // if not invoked, java will not be terminated.
		if (s.awaitTermination(1, TimeUnit.SECONDS)) {
			s.shutdownNow();
		}
		System.out.println("Single thread executor done.");
	}

	static void submitTask() throws InterruptedException {
		System.out.println("-------------submitTask-----------");
		ExecutorService s = Executors.newFixedThreadPool(5);
		IntStream.rangeClosed(1, 10).forEach(i -> s.submit(() -> System.out.println("Executing " + i)));
		s.shutdown();
		if (s.awaitTermination(5, TimeUnit.SECONDS)) {
			s.shutdownNow();
		}
		System.out.println("Submitted tasks to thread pool done.");
	}

	static void usingCallableFuture() throws InterruptedException {
		System.out.println("-------------usingCallableFuture-----------");
		ExecutorService s = Executors.newFixedThreadPool(5);
		List<Future<String>> results = new ArrayList<>();
		IntStream.rangeClosed(1, 10)
				.forEach(i -> results.add(s.submit(() -> String.format("Mapped %d to %s", i, i * Math.random()))));

		s.shutdown();
		if (s.awaitTermination(5, TimeUnit.SECONDS)) {
			s.isShutdown();
		}
		results.forEach(r -> {
			try {
				System.out.println(r.get());
			} catch (ExecutionException | InterruptedException e) {
				throw new RuntimeException(e);
			}
		});
	}

	public static void main(String[] args) throws InterruptedException {
		singleThreadExecutor();
		submitTask();
		usingCallableFuture();
	}
}
