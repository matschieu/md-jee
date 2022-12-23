package com.github.matschieu.java.test.api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class StreamTest {

	@Test
	public void testStream() {
		List<Integer> items = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		items = items.stream().filter(n -> n > 3 && n < 9).collect(Collectors.toList());

		Assertions.assertArrayEquals(new Integer[] {4, 5, 6, 7, 8}, items.toArray());

		items = items.stream().limit(3).collect(Collectors.toList());

		Assertions.assertArrayEquals(new Integer[] {4, 5, 6}, items.toArray());

		items.stream().forEach(System.out::println);
	}

}
