package com.github.matschieu.jakartaee.cdi.service;

import jakarta.annotation.Priority;
import jakarta.enterprise.inject.Alternative;

// An alternative is a bean that must be explicitly selected if it should be available for lookup, injection or name resolution
@Alternative
// @Priority increase the priority of this bean so it will be selected in priority before the one annotated @Default
@Priority(jakarta.interceptor.Interceptor.Priority.APPLICATION + 100)
public class MockAsynchronousService extends AsynchronousService {
}
