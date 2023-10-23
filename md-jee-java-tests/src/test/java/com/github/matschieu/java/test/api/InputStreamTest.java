package com.github.matschieu.java.test.api;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InputStreamTest {

	@Test
	void testInputStream() throws IOException {
		final byte[] bytes = "toto".getBytes();
		final InputStream is = new ByteArrayInputStream(bytes);

		for(int j = 0; j < 2; j++) {
			int value;
			int idx = 0;
			int[] buffer = new int[] {};

			while ((value = is.read()) != -1) {
				Assertions.assertEquals(bytes[idx], value);
				buffer = Arrays.copyOf(buffer, buffer.length + 1);
				buffer[idx++] = value;
			}

			if (j == 0) {
				Assertions.assertEquals(bytes.length, buffer.length);
			} else {
				Assertions.assertEquals(0, buffer.length);
			}
		}
	}
}
