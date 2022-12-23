package com.github.matschieu.jee.cdi.startup;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Destroyed;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;

@ApplicationScoped
public class ObserverBean {

	private boolean init = false;

	private boolean destroyed = false;

	public void init(@Observes @Initialized(ApplicationScoped.class) final Object init) {
		System.out.println("Initializing bean");
		this.init = true;
	}

	public void destroy(@Observes @Destroyed(ApplicationScoped.class) final Object init) {
		System.out.println("Destroying bean");
		this.destroyed = true;
	}

	/**
	 * @return the init
	 */
	public boolean isInit() {
		return this.init;
	}

	/**
	 * @return the destroyed
	 */
	public boolean isDestroyed() {
		return this.destroyed;
	}

}
