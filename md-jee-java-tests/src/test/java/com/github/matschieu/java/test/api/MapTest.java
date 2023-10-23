package com.github.matschieu.java.test.api;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MapTest {

	@Test
	void test() {
		final String key = "KEY";
		final String value = "value";

		final Map<String, String> map = new HashMap<>();

		Assertions.assertNull(map.get(key));

		map.computeIfAbsent(key, v -> "");

		Assertions.assertNotNull(map.get(key));
		Assertions.assertEquals("", map.get(key));

		map.put(key, value);

		Assertions.assertNotNull(map.get(key));
		Assertions.assertEquals(value, map.get(key));

		map.computeIfAbsent(key, v -> "");

		Assertions.assertNotNull(map.get(key));
		Assertions.assertEquals(value, map.get(key));
	}
}
