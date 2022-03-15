package com.github.matschieu.jee.cdi.producer;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;

import com.github.matschieu.jee.cdi.WeldTest;

public class LanguageServiceTest extends WeldTest {

	@Inject
	private LanguageService languageService;

	@Test
	public void testWithContainer() {
		this.initContainer();

		final LanguageService languageService = this.getContainer().select(LanguageService.class).get();

		Assert.assertEquals("Java", languageService.getName());

		this.shutdownContainer();
	}

	@Test
	public void testWithAnnotation() {
		Assert.assertEquals("Java", this.languageService.getName());
	}
}
