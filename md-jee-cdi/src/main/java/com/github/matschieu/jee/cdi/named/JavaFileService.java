package com.github.matschieu.jee.cdi.named;

import com.github.matschieu.jee.cdi.ServiceCounter;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named("JavaFileService")
@ApplicationScoped
public class JavaFileService implements FileService {

	@PostConstruct
	public void postConstruct() {
		ServiceCounter.register(this.getClass());
	}

	@Override
	public String getFileExtension() {
		return ".java";
	}

}
