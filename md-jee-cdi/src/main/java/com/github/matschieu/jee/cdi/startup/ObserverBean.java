package com.github.matschieu.jee.cdi.startup;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Destroyed;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;

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
