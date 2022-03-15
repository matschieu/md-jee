package com.github.matschieu.jee.cdi;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.jboss.weld.junit4.WeldInitiator;
import org.junit.Rule;

public abstract class WeldTest {

	private WeldContainer container = null;

	@Rule
	public WeldInitiator weld = WeldInitiator.from(WeldInitiator.createWeld().enableDiscovery()).activate().inject(this).build();

	public void initContainer() {
		if (container == null) {
			final Weld weld = new Weld();
			container = weld.initialize();
		}
	}

	public WeldContainer getContainer() {
		return container;
	}

	public void shutdownContainer() {
		if (container != null) {
			container.shutdown();
		}
	}

}
