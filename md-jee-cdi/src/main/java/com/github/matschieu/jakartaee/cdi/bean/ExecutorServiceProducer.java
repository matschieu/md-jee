package com.github.matschieu.jakartaee.cdi.bean;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;

@ApplicationScoped
public class ExecutorServiceProducer {

	@Produces
	@Named("ExecutorService")
	public ExecutorService getExecutorService() {
		return Executors.newFixedThreadPool(2);
	}

	public void disposeExecutorService(@Disposes @Named("ExecutorService") ExecutorService executor) {
		executor.shutdown();
	}

}
