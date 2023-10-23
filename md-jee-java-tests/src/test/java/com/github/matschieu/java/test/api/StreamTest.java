package com.github.matschieu.java.test.api;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class StreamTest {

	@Test
	void testStream() {
		List<Integer> items = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		items = items.stream().filter(n -> n > 3 && n < 9).collect(Collectors.toList());

		Assertions.assertArrayEquals(new Integer[] {4, 5, 6, 7, 8}, items.toArray());

		items = items.stream().limit(3).collect(Collectors.toList());

		Assertions.assertArrayEquals(new Integer[] {4, 5, 6}, items.toArray());

		items.stream().forEach(System.out::println);
	}

	@Test
	void testSorted() {
		final List<Integer> expectedList = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		final List<Integer> initialList = Arrays.asList(5, 4, 2, 3, 7, 8, 9, 1, 0, 6);
		final List<Integer> sortedList = initialList.stream().sorted((a, b) -> a - b).collect(Collectors.toList());

		System.out.println(initialList + " -> " + sortedList);

		assertArrayEquals(expectedList.toArray(), sortedList.toArray());
	}

}
