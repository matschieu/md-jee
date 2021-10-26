package org.github.md.jee.cdi.producer;

import javax.inject.Inject;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.jboss.weld.junit4.WeldInitiator;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import com.github.md.jee.cdi.producer.LanguageService;
import com.github.md.jee.cdi.producer.LanguageServiceFactory;

public class LanguageServiceTest {

    @Rule
    public WeldInitiator weld = WeldInitiator.from(LanguageServiceFactory.class).activate().inject(this).build();

    @Inject
    private LanguageService languageService;

	@Test
	public void testWithContainer() {
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		LanguageService languageService = container.select(LanguageService.class).get();

		Assert.assertEquals("Java", languageService.getName());

		container.shutdown();
	}

	@Test
	public void testWithAnnotation() {
		Assert.assertEquals("Java", this.languageService.getName());
	}
}
