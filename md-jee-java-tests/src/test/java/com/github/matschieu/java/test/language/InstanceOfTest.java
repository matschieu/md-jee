package com.github.matschieu.java.test.language;

import org.junit.Assert;
import org.junit.Test;

class MyClass {

}

class B extends MyClass {

}

public class InstanceOfTest {

	@Test
	public void testInstanceOf() {
		final MyClass a = new MyClass();
		final MyClass b = new B();
		final MyClass c = null;

		Assert.assertFalse(a instanceof B);
		Assert.assertTrue(b instanceof B);
		Assert.assertFalse(c instanceof B);
	}
}
