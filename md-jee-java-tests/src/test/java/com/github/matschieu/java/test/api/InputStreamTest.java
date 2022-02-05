package com.github.matschieu.java.test.api;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class InputStreamTest {

	@Test
	public void testInputStream() throws IOException {
		final byte[] bytes = "toto".getBytes();
		final InputStream is = new ByteArrayInputStream(bytes);

		for(int j = 0; j < 2; j++) {
			int value;
			int idx = 0;
			int[] buffer = new int[] {};

			while ((value = is.read()) != -1) {
				Assert.assertEquals(bytes[idx], value);
				buffer = Arrays.copyOf(buffer, buffer.length + 1);
				buffer[idx++] = value;
			}

			if (j == 0) {
				Assert.assertEquals(bytes.length, buffer.length);
			} else {
				Assert.assertEquals(0, buffer.length);
			}
		}
	}
}
