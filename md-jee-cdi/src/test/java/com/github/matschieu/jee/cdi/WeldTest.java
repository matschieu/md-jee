package com.github.matschieu.jee.cdi;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;

@EnableWeld
public abstract class WeldTest {

	private WeldContainer container = null;

	@WeldSetup
	public WeldInitiator weld = WeldInitiator.of(WeldInitiator.createWeld().enableDiscovery());

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
