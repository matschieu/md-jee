package com.github.matschieu.java.test.api;

import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;

class Sleeper implements Callable<String> {

	private final int sleep;

	public Sleeper(int sleep) {
		this.sleep = sleep;
	}

	@Override
	public String call() throws Exception {
		Thread.sleep(sleep);
		return "OK";
	}

}

public class ExecutorTest {

	@Test
	public void testExecutorWithTimeout() throws InterruptedException, ExecutionException {
		final ExecutorService executor = Executors.newSingleThreadExecutor();
		final List<Future<String>> futures = executor.invokeAll(Arrays.asList(new Sleeper(100), new Sleeper(1000), new Sleeper(100)), 500, TimeUnit.MILLISECONDS);

		try {
			Assert.assertEquals("OK", futures.get(0).get());
		} catch(final CancellationException e) {
			fail(e.getMessage());
		}

		try {
			fail(futures.get(1).get());
		} catch(final CancellationException e) {
			Assert.assertNotNull(e);
		}

		try {
			fail(futures.get(2).get());
		} catch(final CancellationException e) {
			Assert.assertNotNull(e);
		}

		executor.shutdown();
	}
}
