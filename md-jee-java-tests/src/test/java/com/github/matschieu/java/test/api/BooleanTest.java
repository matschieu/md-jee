package com.github.matschieu.java.test.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BooleanTest {

	@Test
	public void testParse() {
		Assertions.assertTrue(Boolean.parseBoolean("TRUE"));
		Assertions.assertTrue(Boolean.parseBoolean("true"));
		Assertions.assertFalse(Boolean.parseBoolean("FALSE"));
		Assertions.assertFalse(Boolean.parseBoolean("false"));
		Assertions.assertFalse(Boolean.parseBoolean(""));
		Assertions.assertFalse(Boolean.parseBoolean("sdqsdqs"));
		Assertions.assertFalse(Boolean.parseBoolean(null));
		Assertions.assertFalse(Boolean.parseBoolean("true,false"));
	}

}
