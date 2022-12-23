package com.github.matschieu.jee.cdi.producer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.github.matschieu.jee.cdi.WeldTest;

import jakarta.inject.Inject;

public class LanguageServiceTest extends WeldTest {

	@Inject
	private LanguageService languageService;

	@Test
	public void testWithContainer() {
		this.initContainer();

		final LanguageService languageService = this.getContainer().select(LanguageService.class).get();

		Assertions.assertEquals("Java", languageService.getName());

		this.shutdownContainer();
	}

	@Test
	public void testWithAnnotation() {
		Assertions.assertEquals("Java", this.languageService.getName());
	}
}
