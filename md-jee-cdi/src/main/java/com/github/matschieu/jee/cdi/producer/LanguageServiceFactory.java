package com.github.matschieu.jee.cdi.producer;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

public class LanguageServiceFactory {

	@Produces
	@ApplicationScoped
	public LanguageService createLanguageService() {
		return new JavaService();
	}

}
