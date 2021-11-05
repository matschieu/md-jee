package com.github.matschieu.jee.test.jse.misc;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Matschieu
 *
 */
public class StreamTest {

	public static void main(String[] args) {
		new ArrayList<String>(Arrays.asList("bibi", "toto", "titi")).stream()
				.filter(val -> val.contains("i"))
				.forEach(System.out::println);
	}

}
