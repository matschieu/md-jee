package com.github.matschieu.jakarta.jaxrs;

import static org.assertj.core.api.Assertions.assertThat;

import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.jupiter.api.Test;

import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.Response;


public class HelloServiceTest extends JerseyTest {

	@Override
	protected Application configure() {
		return new ResourceConfig(HelloService.class).property(LoggingFeature.LOGGING_FEATURE_LOGGER_LEVEL_SERVER, "WARNING");
	}

	@Test
	public void testNotFound() {
		Response response = target("/hello").request().get();
		assertThat(response).isNotNull();
		assertThat(response.getStatus()).isEqualTo(404);
	}

	@Test
	public void testHelloText() {
		Response response = target("/hello/text").request().get();
		assertThat(response).isNotNull();
		assertThat(response.getStatus()).isEqualTo(200);
		assertThat(response.readEntity(String.class)).isEqualTo("Hello World!");
	}

	@Test
	public void testHelloJsonRaw() {
		Response response = target("/hello/json").request().get();
		assertThat(response).isNotNull();
		assertThat(response.getStatus()).isEqualTo(200);
		assertThat(response.readEntity(String.class)).isEqualTo("{\"content\":\"Hello World!\"}");
	}

	@Test
	public void testHelloJsonBinding() {
		Response response = target("/hello/json").request().get();
		assertThat(response).isNotNull();
		assertThat(response.getStatus()).isEqualTo(200);
		assertThat(response.readEntity(Message.class).getContent()).isEqualTo("Hello World!");
	}

	@Test
	public void testHelloXmlRaw() {
		Response response = target("/hello/xml").request().get();
		assertThat(response).isNotNull();
		assertThat(response.getStatus()).isEqualTo(200);
		assertThat(response.readEntity(String.class)).isEqualTo("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><message content=\"Hello World!\"/>");
	}

	@Test
	public void testHelloXmlBinding() {
		Response response = target("/hello/xml").request().get();
		assertThat(response).isNotNull();
		assertThat(response.getStatus()).isEqualTo(200);
		assertThat(response.readEntity(Message.class).getContent()).isEqualTo("Hello World!");
	}

	@Test
	public void testHelloName() {
		Response response = target("/hello/Bob").request().get();
		assertThat(response).isNotNull();
		assertThat(response.getStatus()).isEqualTo(200);
		assertThat(response.readEntity(Message.class).getContent()).isEqualTo("Hello Bob!");
	}

	@Test
	public void testSay() {
		Message message = new Message("Hello!");
		Response response = target("/hello/say").request().post(Entity.json(message));
		assertThat(response).isNotNull();
		assertThat(response.getStatus()).isEqualTo(200);
		assertThat(response.readEntity(Message.class).getContent()).isEqualTo(message.getContent());
	}

	@Test
	public void testSayNothing() {
		Response response = target("/hello/say").request().post(null);
		assertThat(response).isNotNull();
		assertThat(response.getStatus()).isEqualTo(204);
		assertThat(response.readEntity(Message.class)).isNull();
	}

}
