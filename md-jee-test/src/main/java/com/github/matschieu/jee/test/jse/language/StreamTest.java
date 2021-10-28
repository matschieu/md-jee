package com.github.matschieu.jee.test.jse.language;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class StreamTest {

	public static void main(String[] args) {
		test1();
	}

	public static void test1() {
		List<Integer> items = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10);

		items = items.stream().filter(n -> n > 3 && n < 9).collect(Collectors.toList());

		System.out.println(Arrays.toString(items.toArray()));

		items = items.stream().limit(3).collect(Collectors.toList());

		System.out.println(Arrays.toString(items.toArray()));

	}
}
