package com.github.matschieu.jakartaee.cdi.bean;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.BeforeDestroyed;
import jakarta.enterprise.context.Destroyed;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;

public class AppLifeCycleObserverBean {

	private static int appInitialized = 0;
	private static int appBeforeDestroyed = 0;
	private static int appDestroyed = 0;

	public static void reset() {
		appInitialized = 0;
		appBeforeDestroyed = 0;
		appDestroyed = 0;
	}

	public static int getAppInitialized() {
		return appInitialized;
	}

	public static int getAppBeforeDestroyed() {
		return appBeforeDestroyed;
	}

	public static int getAppDestroyed() {
		return appDestroyed;
	}

	// Observes the event @Initialized for the scope ApplicationScoped = executed when starting of the container
	public void initApp(@Observes @Initialized(ApplicationScoped.class) final Object obj) {
		System.out.println("Initializing app");
		appInitialized++;
	}

	// Observes the event @BeforeDestroyed for the scope ApplicationScoped = executed before stopping the container
	public void beforeDestroyApp(@Observes @BeforeDestroyed(ApplicationScoped.class) final Object obj) {
		System.out.println("Before destroying app");
		appBeforeDestroyed++;
	}

	// Observes the event @Destroyed for the scope ApplicationScoped = executed when stopping of the container
	public void destroyApp(@Observes @Destroyed(ApplicationScoped.class) final Object obj) {
		System.out.println("Destroying app");
		appDestroyed++;
	}

}
