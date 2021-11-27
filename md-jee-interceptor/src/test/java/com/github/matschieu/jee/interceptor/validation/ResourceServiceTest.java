package com.github.matschieu.jee.interceptor.validation;

import static org.junit.Assert.fail;

import javax.inject.Inject;

import org.jboss.weld.junit4.WeldInitiator;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

public class ResourceServiceTest {

	@Rule
	public WeldInitiator weld = WeldInitiator.from(ResourceService.class, ResourceServiceImpl.class).activate().inject(this).build();

	@Inject
	private ResourceService resourceService;

	@Test
	public void testMyServiceCreateResource1() {
		try {
			this.resourceService.createResource(null, "", "");
			fail();
		} catch (final Exception e) {
			Assert.assertEquals(NullElementException.class, e.getClass());
			Assert.assertEquals("arg0 is null", e.getMessage());
		}

		try {
			this.resourceService.createResource("", null, "");
			fail();
		} catch (final Exception e) {
			Assert.assertEquals(NullElementException.class, e.getClass());
			Assert.assertEquals("arg1 is null", e.getMessage());
		}

		this.resourceService.createResource("", "", null);
	}

	@Test
	public void testMyServiceCreateResource2() {
		try {
			this.resourceService.createResource(new Resource(null, "", ""));
			fail();
		} catch (final Exception e) {
			Assert.assertEquals(NullElementException.class, e.getClass());
			Assert.assertEquals("name is null", e.getMessage());
		}

		try {
			this.resourceService.createResource(new Resource("", null, ""));
			fail();
		} catch (final Exception e) {
			Assert.assertEquals(NullElementException.class, e.getClass());
			Assert.assertEquals("type is null", e.getMessage());
		}

		this.resourceService.createResource(new Resource("", "", null));
	}

	@Test
	public void testMyServiceGetResource() {
		Resource resource;

		try {
			resource = this.resourceService.getResource(null);
			fail();
		} catch (final Exception e) {
			Assert.assertEquals(NullElementException.class, e.getClass());
			Assert.assertEquals("arg0 is null", e.getMessage());
		}

		resource = this.resourceService.getResource("name");

		Assert.assertNotNull(resource);
		Assert.assertEquals("name", resource.getName());
		Assert.assertEquals("type", resource.getType());
		Assert.assertEquals("description", resource.getDescription());
	}

	@Test
	public void testMyServiceDeleteResource() {
		try {
			this.resourceService.deleteResource(null);
			fail();
		} catch (final Exception e) {
			Assert.assertEquals(NullElementException.class, e.getClass());
			Assert.assertEquals("arg0 is null", e.getMessage());
		}

		this.resourceService.getResource("name");
	}

}
