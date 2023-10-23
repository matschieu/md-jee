package com.github.matschieu.jee.interceptor.validation;

import static org.junit.jupiter.api.Assertions.fail;

import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;

@EnableWeld
class ResourceServiceTest {

	@WeldSetup
	public WeldInitiator weld = WeldInitiator.from(ResourceService.class, ResourceServiceImpl.class).build();

	@Inject
	private ResourceService resourceService;

	@Test
	void testMyServiceCreateResource1() {
		try {
			this.resourceService.createResource(null, "", "");
			fail();
		} catch (final Exception e) {
			Assertions.assertEquals(NullElementException.class, e.getClass());
			Assertions.assertEquals("arg0 is null", e.getMessage());
		}

		try {
			this.resourceService.createResource("", null, "");
			fail();
		} catch (final Exception e) {
			Assertions.assertEquals(NullElementException.class, e.getClass());
			Assertions.assertEquals("arg1 is null", e.getMessage());
		}

		this.resourceService.createResource("", "", null);
	}

	@Test
	void testMyServiceCreateResource2() {
		try {
			this.resourceService.createResource(new Resource(null, "", ""));
			fail();
		} catch (final Exception e) {
			Assertions.assertEquals(NullElementException.class, e.getClass());
			Assertions.assertEquals("name is null", e.getMessage());
		}

		try {
			this.resourceService.createResource(new Resource("", null, ""));
			fail();
		} catch (final Exception e) {
			Assertions.assertEquals(NullElementException.class, e.getClass());
			Assertions.assertEquals("type is null", e.getMessage());
		}

		this.resourceService.createResource(new Resource("", "", null));
	}

	@Test
	void testMyServiceGetResource() {
		Resource resource;

		try {
			resource = this.resourceService.getResource(null);
			fail();
		} catch (final Exception e) {
			Assertions.assertEquals(NullElementException.class, e.getClass());
			Assertions.assertEquals("arg0 is null", e.getMessage());
		}

		resource = this.resourceService.getResource("name");

		Assertions.assertNotNull(resource);
		Assertions.assertEquals("name", resource.getName());
		Assertions.assertEquals("type", resource.getType());
		Assertions.assertEquals("description", resource.getDescription());
	}

	@Test
	void testMyServiceDeleteResource() {
		try {
			this.resourceService.deleteResource(null);
			fail();
		} catch (final Exception e) {
			Assertions.assertEquals(NullElementException.class, e.getClass());
			Assertions.assertEquals("arg0 is null", e.getMessage());
		}

		this.resourceService.getResource("name");
	}

}
