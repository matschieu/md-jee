package com.github.matschieu.java.test.api;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



class MathTest {

	 @Test
	void testRandom() {
		for(int i = 0; i < 20; i++) {
			final int n = (int)(Math.random() * 100.0);
			Assertions.assertTrue(String.format("%03d", n).matches("[0][0-9]{2}"));
		}

		for(int i = 0; i < 20; i++) {
			final int n = new Random().nextInt(100);
			Assertions.assertTrue(String.format("%03d", n).matches("[0][0-9]{2}"));
		}
	}
}
