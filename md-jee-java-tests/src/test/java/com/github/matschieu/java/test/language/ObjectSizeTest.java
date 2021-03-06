package com.github.matschieu.java.test.language;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ObjectSizeTest {

	@Test
	public void testObjectSize() {
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

		//final Assert.ass
		Assert.assertEquals(0, max1 - max2);
		Assert.assertEquals(0, total1 - total2);
		Assert.assertTrue(free1 > free2);
	}

}
