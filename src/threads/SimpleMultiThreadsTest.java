package threads;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleMultiThreadsTest {

	private static final int nThreads = 9;
	
	public static void main(String[] args) {
		
		ExecutorService service= Executors.newFixedThreadPool(nThreads);
		String input;
		
		for (int i = 0; i < nThreads; i++) {
			input = "nThreads = "+i;
			service.execute(new Task(input));
		}
	}
	
	static class Task implements Runnable{
		private String input;

		public Task(String input) {
			this.input = input;
		}

		@Override
		public void run() {
			try {
				Test.run(input);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

class Test extends Thread{
	
	public static void run(String input) throws InterruptedException{
		// this is just a simple method for SimpleMultiThreadsTest
		// Single thread process will be done here
		for(int i = 0; i < 10; i++){
			Thread.sleep(1);
			System.out.println("Running in Test.run " + input);
		}
	}
}
