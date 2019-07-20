package threads;

public class RunnableUsage {

	static void anonymousImpl() {
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello world from anonymous class!");
			}
		};
		new Thread(r).start();
	}

	static void lambdaImpl() throws InterruptedException {
		Runnable r = () -> System.out.println("Hello world from lambda expression");
//		Runnable r2 = () -> ""; compiler error, can't return a value because return is Void.
		
		new Thread(r).start();
		Thread.sleep(1000);
		new Thread(r).run(); // will just invoke the run method in the same thread.
	}
	
	public static void main(String[] args) throws InterruptedException {
		anonymousImpl();
		lambdaImpl();
	}
}
