package com.github.matschieu.java.test.api;

import org.junit.Assert;
import org.junit.Test;

public class ThreadTest {

	@Test
	public void testThreadWithTimeout() {
		final Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(200);
				} catch (final InterruptedException e) { }
			}
		});

		t.start();

		final short timeoutValue = 100;
		final long start = System.currentTimeMillis();
		boolean timeout = false;

		Assert.assertFalse(t.isInterrupted());

		while (!timeout && t.isAlive()) {
			if (start + timeoutValue < System.currentTimeMillis()) {
				t.interrupt();
				timeout = true;
			}
		}

		Assert.assertTrue(t.isInterrupted());
		Assert.assertTrue(timeout);
	}
}
