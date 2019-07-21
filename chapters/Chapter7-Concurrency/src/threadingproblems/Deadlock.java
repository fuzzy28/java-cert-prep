package threadingproblems;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Deadlock {

	class Monitor {
	}

	Monitor monitor1;
	Monitor monitor2;
	String task1 = "Doing task 1...";
	String task2 = "Doing task 2...";

	public Deadlock() {
		monitor1 = new Monitor();
		monitor2 = new Monitor();
	}

	void doFirstTaskThenSecond() {
		System.out.println("doFirstTaskThenSecond");
		synchronized (monitor1) {
			System.out.println("doFirstTaskThenSecond got monitor1");
			sleep(100);
			System.out.println(task1);
			
			//DEADLOCK!
			synchronized (monitor2) {
				System.out.println(task2);
			}
		}
	}

	void doSecondTaskThenFirst() {
		System.out.println("doSecondTaskThenFirst");
		synchronized (monitor2) {
			System.out.println("doSecondTaskThenFirst got monitor2");
			sleep(100);
			System.out.println(task2);
			
			//DEADLOCK!
			synchronized (monitor1) {
				System.out.println(task1);
			}
		}
	}

	public static void main(String[] args) {
		Deadlock d = new Deadlock();
		ExecutorService s = Executors.newFixedThreadPool(2);
		s.submit(d::doFirstTaskThenSecond);
		s.submit(d::doSecondTaskThenFirst);
		s.shutdown();
	}

	static void sleep(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
		}
	}

}
