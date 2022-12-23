package com.github.matschieu.java.test.language;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SwitchTest {

	enum MyEnum { ENUM1, ENUM2 };

	@SuppressWarnings("null")
	@Test
	public void testSwitchWithNull() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			final MyEnum myEnum = null;

			switch (myEnum) { // throws NPE
			case ENUM1:
				Assertions.fail(MyEnum.ENUM1.name());
				break;
			case ENUM2:
				Assertions.fail(MyEnum.ENUM2.name());
				break;
			default:
				Assertions.fail("default");
				break;
			}
		});
	}
}
