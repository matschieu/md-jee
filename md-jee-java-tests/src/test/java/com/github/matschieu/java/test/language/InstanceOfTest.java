package com.github.matschieu.java.test.language;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyClass {

}

class B extends MyClass {

}

class InstanceOfTest {

	@Test
	void testInstanceOf() {
		final MyClass a = new MyClass();
		final MyClass b = new B();
		final MyClass c = null;

		Assertions.assertFalse(a instanceof B);
		Assertions.assertTrue(b instanceof B);
		Assertions.assertFalse(c instanceof B);
	}
}
