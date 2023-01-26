package com.github.matschieu.jakartaee.cdi.bean;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import jakarta.inject.Inject;
import jakarta.inject.Named;

public class AsynchronousBean {

	@Inject
	@Named("ExecutorService")
	private ExecutorService executor;

	public Future<Boolean> process(long pause) {
		return executor.submit(() -> {
			try {
				Thread.sleep(pause);
			} catch (InterruptedException e) {
				return false;
			}
			return true;
		});
	}

}
