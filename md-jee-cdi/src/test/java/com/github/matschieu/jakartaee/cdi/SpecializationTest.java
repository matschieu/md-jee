package com.github.matschieu.jakartaee.cdi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.github.matschieu.WeldTest;
import com.github.matschieu.jakartaee.cdi.common.Asynchronous;
import com.github.matschieu.jakartaee.cdi.service.AsynchronousService;
import com.github.matschieu.jakartaee.cdi.service.MockAsynchronousService;
import com.github.matschieu.jakartaee.cdi.service.MockAsynchronousSpecializedService;
import com.github.matschieu.jakartaee.cdi.service.Service;
import com.github.matschieu.jakartaee.cdi.service.SpecializedService;

import jakarta.inject.Inject;

class SpecializationTest extends WeldTest {

	@Inject
	private Service service;

	@Inject
	@Asynchronous
	private Service asyncService;

	@Inject
	private SpecializedService specializedService;

	@Inject
	@Asynchronous
	private SpecializedService asyncSpecializedService;

	@Test
	void testAlternative() {
		// MockAsynchronous service because priority increased on the alternative with @Priority
		Assertions.assertInstanceOf(MockAsynchronousService.class, service);
		// AsynchronousService because qualifier @Asynchronous is only on the Default implementation
		Assertions.assertInstanceOf(AsynchronousService.class, asyncService);
		// Both SpecializedService have the same type because of the use of the annotation @Specializes
		// @Specializes guarantees that the second bean is never instantiated or called by the container, even if the second bean defines a producer or observer method
		Assertions.assertInstanceOf(MockAsynchronousSpecializedService.class, specializedService);
		Assertions.assertInstanceOf(MockAsynchronousSpecializedService.class, asyncSpecializedService);
	}
}
