package com.github.matschieu.jakarta.jaxrs;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/hello")
public class HelloService {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("text")
	public String helloText() {
		return "Hello World!";
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("xml")
	public Message helloXml() {
		return new Message("Hello World!");
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("json")
	public Response helloJson() {
		return Response.ok(new Message("Hello World!")).build();
	}

	@GET
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("name") String name) {
		return Response.ok(new Message("Hello " + name + "!")).build();
	}

	@POST
	@Path("/say")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response say(Message message) {
		if (message != null) {
			return Response.ok(new Message(message.getContent())).build();
		}
		return Response.noContent().build();
	}
}
