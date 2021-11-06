package com.github.matschieu.jee.interceptor.validation;

public interface ResourceService {

	void createResource(String name, String type, String description);

	void createResource(Resource resource);

	Resource getResource(String name);

	void deleteResource(String name);

}
