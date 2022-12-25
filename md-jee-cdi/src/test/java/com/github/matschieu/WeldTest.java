package com.github.matschieu;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;

@EnableWeld
public abstract class WeldTest {

	private WeldContainer container = null;

	@WeldSetup
	protected WeldInitiator weld = WeldInitiator.of(WeldInitiator.createWeld().enableDiscovery());

	public WeldContainer getWeldContainer() {
		if (container == null) {
			container = new Weld().initialize();
		}
		return container;
	}

	public void shutdownWeldContainer() {
		if (container != null) {
			container.shutdown();
		}
		container = null;
	}

}
