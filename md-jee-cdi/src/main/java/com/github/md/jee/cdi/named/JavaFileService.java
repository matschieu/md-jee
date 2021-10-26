package com.github.md.jee.cdi.named;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.github.md.jee.cdi.ServiceCounter;

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
