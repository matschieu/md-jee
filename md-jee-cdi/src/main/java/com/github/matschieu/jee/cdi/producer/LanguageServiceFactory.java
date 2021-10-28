package com.github.matschieu.jee.cdi.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

public class LanguageServiceFactory {

	@Produces
	@ApplicationScoped
	public LanguageService createLanguageService() {
		return new JavaService();
	}

}
