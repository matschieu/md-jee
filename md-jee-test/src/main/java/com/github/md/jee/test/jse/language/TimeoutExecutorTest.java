package com.github.md.jee.test.jse.language;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class TimeoutExecutorTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		List<Future<String>> futures = executor.invokeAll(Arrays.asList(new Callable<String>() {

			@Override
			public String call() throws Exception {
				System.out.println("called");
				Thread.sleep(3000);
				return "OK";
			}

		}), 2, TimeUnit.SECONDS);

		try {
			System.out.println("Task returned: " + futures.get(0).get());
		} catch(CancellationException e) {
			System.out.println("Task cancelled by timeout");
		}

		executor.shutdown();
	}
}
