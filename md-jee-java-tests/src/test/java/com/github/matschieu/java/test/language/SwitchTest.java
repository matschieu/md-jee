package com.github.matschieu.java.test.language;

import org.junit.Assert;
import org.junit.Test;

public class SwitchTest {

	enum MyEnum { ENUM1, ENUM2 };

	@Test(expected = NullPointerException.class)
	public void testSwitchWithNull() {
		final MyEnum myEnum = null;

		switch (myEnum) { // throws NPE
		case ENUM1:
			Assert.fail(MyEnum.ENUM1.name());
			break;
		case ENUM2:
			Assert.fail(MyEnum.ENUM2.name());
			break;
		default:
			Assert.fail("default");
			break;
		}
	}
}
