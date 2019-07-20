package concurrentcollections;

import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Queues {

	static void concurrentQueue() {
		System.out.println("-------concurrentQueue-------");
		Queue<String> q = new ConcurrentLinkedQueue<>();
		q.offer("a");
		q.offer("b");
		System.out.println("Peek queue: " + q.peek());
		System.out.println("Poll queue: " + q.poll());
		System.out.println("Poll queue: " + q.poll());
		System.out.println("Poll queue: " + q.poll());
	}

	static void concurrentDequeue() {
		System.out.println("-------concurrentDequeue-------");
		Deque<String> q = new ConcurrentLinkedDeque<>();
		q.offer("a");
		q.push("b");
		System.out.println("Peek queue: " + q.peek());
		System.out.println("Poll queue: " + q.pop());
		System.out.println("Poll queue: " + q.pop());
	}

	static void blockingQueue() throws InterruptedException {
		System.out.println("-------blockingQueue-------");
		BlockingQueue<String> bq = new LinkedBlockingQueue<>();
		bq.offer("bq1");
		bq.offer("bq2", 1, TimeUnit.SECONDS);
		
		System.out.println(bq.poll());
		System.out.println(bq.poll(10, TimeUnit.MILLISECONDS));
		
	}

	public static void main(String[] args) throws InterruptedException {
		concurrentQueue();
		concurrentDequeue();
		blockingQueue();
	}
}
