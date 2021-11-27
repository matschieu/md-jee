package com.github.matschieu.jee.interceptor.validation;

import javax.interceptor.Interceptors;

@Interceptors(ValidationInterceptor.class)
public class ResourceServiceImpl implements ResourceService {

	@Override
	public void createResource(@NotNullElement final String name, @NotNullElement final String type, final String description) {}

	@Override
	public void createResource(@NotNullElement final Resource resource) {}

	@Override
	public Resource getResource(@NotNullElement final String name) {
		return new Resource(name, "type", "description");
	}

	@Override
	public void deleteResource(@NotNullElement final String name) {}

}
