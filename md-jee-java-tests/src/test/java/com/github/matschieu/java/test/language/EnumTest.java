package com.github.matschieu.java.test.language;

import org.junit.Assert;
import org.junit.Test;

public class EnumTest {

	private enum MyEnum { titi, tutu, toto }

	@Test
	public void testEnumEquals() {
		Assert.assertTrue(MyEnum.titi.equals(MyEnum.titi));
		Assert.assertFalse(MyEnum.titi.equals(MyEnum.tutu));
		Assert.assertFalse(MyEnum.titi.equals(null));
		Assert.assertFalse(MyEnum.titi.equals(""));
	}

	@Test
	public void testEnumValueOf() {
		Assert.assertEquals(MyEnum.toto, MyEnum.valueOf("toto"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEnumValueOfIllegalo() {
		MyEnum.valueOf("tata");
	}

	@Test(expected = NullPointerException.class)
	public void testEnumValueOfNPE() {
		MyEnum.valueOf(null);
	}

	@Test
	public void testEnumCompareTo() {
		Assert.assertEquals(1, MyEnum.tutu.compareTo(MyEnum.titi));
		Assert.assertEquals(0, MyEnum.tutu.compareTo(MyEnum.tutu));
		Assert.assertEquals(-2, MyEnum.titi.compareTo(MyEnum.toto));
		Assert.assertEquals(-1, MyEnum.tutu.compareTo(MyEnum.toto));
	}

}
