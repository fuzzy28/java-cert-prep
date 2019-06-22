package collections;

import java.util.ArrayDeque;

public class QueueUsage {

	public static void main(String[] args) {
		new ArrayDequeImplementation();
	}

	static class ArrayDequeImplementation {
		public ArrayDequeImplementation() {
			ArrayDeque<Integer> ad = new ArrayDeque<>();
//			ad.add(null); // Runtime Exception! throws NPE, cannot add null element
//			ad.offer(null);  // Runtime Exception! throws NPE, cannot offer null element
//			System.out.println(ad.element()); // throws NoSuchElementException since queue is empty!
//			System.out.println(ad.remove()); // hrows NoSuchElementException since queue is empty!
			System.out.println(ad.peek()); // returns null if empty, doesn't throw exception!
			System.out.println(ad.add(1)); // returns boolean
			System.out.println(ad.offer(2)); // returns boolean
			System.out.println(ad.element()); // return head element "1", executes getFirst()
			System.out.println(ad.remove()); // remove first element and return "1", executes pollFirst()
			ad.push(1); // add element in the beginning, executes addFirst();
			System.out.println(ad);
			System.out.println(ad.poll()); // like remove(), remove first element and return "1", executes pollFirst()
			System.out.println(ad.pop()); // same as poll() but throws error if element is not found!
			System.out.println(ad.peek()); // returns first data

			System.out.println("______________Normal queue______________");
			ArrayDeque<Integer> queue = new ArrayDeque<>();
			System.out.println("Offer 1: " + queue.offer(1));
			System.out.println("Offer 2: " + queue.offer(2));
			System.out.println("Offer 3: " + queue.offer(3));
			System.out.println("Peek : " + queue.peek()); // 1
			System.out.println("Poll : " + queue.poll()); // "1"
			System.out.println("Remaining items: " + queue);
			System.out.println("Poll : " + queue.poll()); // "2"
			System.out.println("Remaining items: " + queue);
			System.out.println("Poll : " + queue.poll()); // "3"
			System.out.println("Remaining items: " + queue);
			System.out.println("Poll : " + queue.poll()); // "null"
//			System.out.println("Pop : " + queue.pop()); // "pop throws Runtime Exception:NoSuchElementException!"
			
			System.out.println("______________Stack______________");
			ArrayDeque<Integer> stack = new ArrayDeque<>();
			stack.push(1);
			stack.push(2);
			stack.push(3);
			System.out.println("Peek : " + stack.peek()); // 1
			System.out.println("Poll : " + stack.poll()); // "1"
			System.out.println("Remaining items: " + stack);
			System.out.println("Poll : " + stack.poll()); // "2"
			System.out.println("Remaining items: " + stack);
			System.out.println("Poll : " + stack.poll()); // "3"
			System.out.println("Remaining items: " + stack);
			System.out.println("Poll : " + stack.poll()); // "null"
//			System.out.println("Pop : " + queue.pop()); // "pop throws Runtime Exception:NoSuchElementException!"
		}
	}
}
