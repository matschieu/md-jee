package com.github.matschieu.java.test.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ThreadTest {

	@Test
	public void testThreadWithTimeout() {
		final Thread t = new Thread(() -> {
			try {
				Thread.sleep(5000);
			} catch (final InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});

		final long start = System.currentTimeMillis();

		t.start();

		final int timeoutValue = 500;
		boolean timeout = false;

		Assertions.assertFalse(t.isInterrupted());

		while (!timeout && t.isAlive()) {
			if (start + timeoutValue < System.currentTimeMillis()) {
				t.interrupt();
				timeout = true;
			}
		}

		Assertions.assertTrue(timeout);
		Assertions.assertTrue(t.isInterrupted());
	}
}
