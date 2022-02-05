package com.github.matschieu.java.test.api;

import org.junit.Assert;
import org.junit.Test;

public class BooleanTest {

	@Test
	public void testParse() {
		Assert.assertTrue(Boolean.parseBoolean("TRUE"));
		Assert.assertTrue(Boolean.parseBoolean("true"));
		Assert.assertFalse(Boolean.parseBoolean("FALSE"));
		Assert.assertFalse(Boolean.parseBoolean("false"));
		Assert.assertFalse(Boolean.parseBoolean(""));
		Assert.assertFalse(Boolean.parseBoolean("sdqsdqs"));
		Assert.assertFalse(Boolean.parseBoolean(null));
		Assert.assertFalse(Boolean.parseBoolean("true,false"));
	}

}
