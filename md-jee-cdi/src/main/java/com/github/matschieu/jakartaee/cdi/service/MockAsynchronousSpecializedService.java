package com.github.matschieu.jakartaee.cdi.service;

import jakarta.enterprise.inject.Specializes;

// Using @Specializes makes this bean the default for the Type it extends ; then superclass won't be injected
@Specializes
public class MockAsynchronousSpecializedService extends AsynchronousSpecializedService {
}
