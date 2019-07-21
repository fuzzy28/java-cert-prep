package parallelstreams;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class CyclicBarrierUsage {

	static void cyclicBarrier() {
		ExecutorService s = Executors.newFixedThreadPool(10);
		CyclicBarrier cb = new CyclicBarrier(5); // parties should be <= number of executors, else deadlock!

		IntStream.rangeClosed(1, 5).forEach(i -> s.submit(() -> {
			try {
				System.out.println("Doing task " + i);
				cb.await(); // wait all other threads before doing next task.
				System.out.println("Doing next task " + i);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}));
		s.shutdown();
	}
	
	public static void main(String[] args) {
		cyclicBarrier();
	}

}
