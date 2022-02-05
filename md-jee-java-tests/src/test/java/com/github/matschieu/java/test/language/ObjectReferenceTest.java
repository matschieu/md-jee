package com.github.matschieu.java.test.language;

import org.junit.Assert;
import org.junit.Test;

public class ObjectReferenceTest {

	class MyClass {
		public String value = null;

		@Override
		public boolean equals(Object obj) {
			final MyClass o = (MyClass)obj;
			return this.value != null && o.value != null && this.value.equals(o.value)
					|| this.value == null && o.value == null;
		}
	}

	private void updateObject(MyClass obj) {
		obj = new MyClass();
	}

	private void updateAttribute(MyClass obj) {
		obj.value = null;
	}

	private MyClass getMyClass(MyClass obj) {
		return obj;
	}

	private MyClass getMyClassFinal(final MyClass obj) {
		return obj;
	}

	@Test
	public void testObjectRef() {
		MyClass obj1 = null;
		obj1 = new MyClass();
		obj1.value = "VALUE";

		Assert.assertNotNull(obj1.value);
		updateAttribute(obj1);
		Assert.assertNull(obj1.value);

		obj1.value = "VALUE";

		Assert.assertNotNull(obj1.value);
		updateObject(obj1);
		Assert.assertNotNull(obj1.value);
	}

	@Test
	public void testObjectRefEquality() {
		MyClass obj1 = new MyClass();
		final MyClass obj2 = new MyClass();

		Assert.assertFalse(obj1 == new MyClass());
		Assert.assertFalse(obj1 == obj2);
		Assert.assertTrue(obj1.equals(obj2));
		Assert.assertTrue(obj2.equals(obj1));

		obj1 = obj2;

		Assert.assertTrue(obj1 == obj2);

		Assert.assertTrue(obj1 == getMyClass(obj1));
		Assert.assertTrue(obj1 == getMyClassFinal(obj1));
	}

}

