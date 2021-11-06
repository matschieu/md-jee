package com.github.matschieu.jee.interceptor.validation;

import javax.interceptor.Interceptors;

@Interceptors(ValidationInterceptor.class)
public class ResourceServiceImpl implements ResourceService {

	@Override
	public void createResource(@NotNullElement String name, @NotNullElement String type, String description) {
	}

	@Override
	public void createResource(@NotNullElement Resource resource) {
	}

	@Override
	public Resource getResource(@NotNullElement String name) {
		return new Resource(name, "type", "description");
	}

	@Override
	public void deleteResource(@NotNullElement String name) {
	}

}
