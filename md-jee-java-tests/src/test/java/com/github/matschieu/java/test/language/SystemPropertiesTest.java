package com.github.matschieu.java.test.language;

import java.util.Map.Entry;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class SystemPropertiesTest {

	@Test
	void testSystemProperties() {
		Assertions.assertNotNull(System.getProperties().entrySet());

		for(final Entry<Object, Object> entry : System.getProperties().entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
	}
}
