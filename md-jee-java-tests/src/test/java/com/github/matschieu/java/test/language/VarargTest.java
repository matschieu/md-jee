package com.github.matschieu.java.test.language;

import org.junit.Assert;
import org.junit.Test;

public class VarargTest {

	public int countParam(String... args) {
		Assert.assertNotNull(args);
		return args.length;
	}

	@Test
	public void testVararg() {
		Assert.assertEquals(0, countParam());
		Assert.assertEquals(1, countParam((String)null));
		Assert.assertEquals(2, countParam((String)null, (String)null));
		Assert.assertEquals(1, countParam("1"));
		Assert.assertEquals(4, countParam("1", "2", "3", "4"));
	}

	@Test(expected = AssertionError.class)
	public void testNullVararg() {
		countParam(null);
	}

}
