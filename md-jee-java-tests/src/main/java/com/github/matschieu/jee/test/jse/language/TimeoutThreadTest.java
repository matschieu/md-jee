package com.github.matschieu.jee.test.jse.language;

public class TimeoutThreadTest {

	public static void main(String[] args) {
		System.out.println("Starting");

		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				// Business process here
				System.out.println("Thread is running");

				for(int i = 0 ; i < 100 ; i++) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				System.out.println("Thread ends");
			}

		});

		t.start();

		final short timeoutValue = 5000;
		long start = System.currentTimeMillis();
		boolean timeout = false;

		while (!timeout && t.isAlive()) {
			if (start + timeoutValue < System.currentTimeMillis()) {
				System.out.println("Interrupting thread");
				t.interrupt();
				timeout = true;
			}
		}

		System.out.println("timeout: " + timeout);
	}
}
