package com.github.matschieu.jee.interceptor.validation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
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
		assertThatExceptionOfType(NullElementException.class).isThrownBy(() -> this.resourceService.createResource(null, "", "")).withMessage("arg0 is null");
		assertThatExceptionOfType(NullElementException.class).isThrownBy(() -> this.resourceService.createResource("", null, "")).withMessage("arg1 is null");
		assertThatNoException().isThrownBy(() -> this.resourceService.createResource("", "", null));
	}

	@Test
	void testMyServiceCreateResource2() {
		assertThatExceptionOfType(NullElementException.class).isThrownBy(() -> this.resourceService.createResource(new Resource(null, "", ""))).withMessage("name is null");
		assertThatExceptionOfType(NullElementException.class).isThrownBy(() -> this.resourceService.createResource(new Resource("", null, ""))).withMessage("type is null");
		assertThatNoException().isThrownBy(() -> this.resourceService.createResource("", "", null));
	}

	@Test
	void testMyServiceGetResource() {
		assertThatExceptionOfType(NullElementException.class).isThrownBy(() -> this.resourceService.getResource(null)).withMessage("arg0 is null");

		Resource resource = this.resourceService.getResource("name");

		assertThat(resource).isNotNull();
		assertThat(resource.getName()).isEqualTo("name");
		assertThat(resource.getType()).isEqualTo("type");
		assertThat(resource.getDescription()).isEqualTo("description");
	}

	@Test
	void testMyServiceDeleteResource() {
		assertThatExceptionOfType(NullElementException.class).isThrownBy(() -> this.resourceService.deleteResource(null)).withMessage("arg0 is null");
		assertThatNoException().isThrownBy(() -> this.resourceService.getResource("name"));
	}

}
