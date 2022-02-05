package com.github.matschieu.java.test.language;

import org.junit.Assert;
import org.junit.Test;

public class CastTest {

	@Test
	public void testCast() {
		final String str = null;
		final Object obj = str;

		Assert.assertEquals(1, (int)1.625);
		Assert.assertNull((String)obj);
		Assert.assertNull((Integer)obj);
	}
	
	@Test(expected = ClassCastException.class)
	public void testBadCast() {
		String str = "";
		Object obj = str;
		Assert.assertNull((Integer)obj);		
	}

}
