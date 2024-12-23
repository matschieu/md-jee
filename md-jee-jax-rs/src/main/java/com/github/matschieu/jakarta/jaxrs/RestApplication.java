package com.github.matschieu.jakarta.jaxrs;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
public class RestApplication extends Application {
	// Not used by Jersey test but would deploy resources on /api/<path>
}