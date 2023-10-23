package com.github.matschieu.java.test.language;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ObjectSizeTest {

	@Test
	void testObjectSize() {
		final long max1 = Runtime.getRuntime().maxMemory();
		final long total1 = Runtime.getRuntime().totalMemory();
		final long free1 = Runtime.getRuntime().freeMemory();

		final List<Integer> numbers = new ArrayList<>();

		for(int i = 0 ; i < 1000000; i++) {
			numbers.add(i);
		}

		final long max2 = Runtime.getRuntime().maxMemory();
		final long total2 = Runtime.getRuntime().totalMemory();
		final long free2 = Runtime.getRuntime().freeMemory();

		//final Assertions.ass
		Assertions.assertEquals(0, max1 - max2);
		Assertions.assertEquals(0, total1 - total2);
		Assertions.assertTrue(free1 > free2);
	}

}
