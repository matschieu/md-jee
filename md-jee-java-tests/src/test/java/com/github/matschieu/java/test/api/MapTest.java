package com.github.matschieu.java.test.api;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MapTest {

	private static final String KEY = "KEY";
	private static final String VALUE = "value";

	@Test
	void test() {
		final Map<String, String> map = new HashMap<>();

		Assertions.assertNull(map.get(KEY));

		map.computeIfAbsent(KEY, v -> "");

		Assertions.assertNotNull(map.get(KEY));
		Assertions.assertEquals("", map.get(KEY));

		map.put(KEY, VALUE);

		Assertions.assertNotNull(map.get(KEY));
		Assertions.assertEquals(VALUE, map.get(KEY));

		map.computeIfAbsent(KEY, v -> "");

		Assertions.assertNotNull(map.get(KEY));
		Assertions.assertEquals(VALUE, map.get(KEY));
	}

	private int count = 0;

	@Test
	void testComputeIfAbsent() {
		final Map<String, String> map = new HashMap<>();

		Assertions.assertNull(map.get(KEY));

		for(int i = 0; i < 10; i++) {
			map.computeIfAbsent(KEY, k -> {
				count++;
				System.out.println("Add value to map");
				return VALUE;
			});
		}

		Assertions.assertEquals(1, map.size());
		Assertions.assertEquals(1, count);
		Assertions.assertEquals(VALUE, map.get(KEY));
	}
}
