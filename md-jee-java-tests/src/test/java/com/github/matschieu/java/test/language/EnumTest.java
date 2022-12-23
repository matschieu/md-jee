package com.github.matschieu.java.test.language;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EnumTest {

	private enum MyEnum { titi, tutu, toto }

	@Test
	public void testEnumEquals() {
		Assertions.assertTrue(MyEnum.titi.equals(MyEnum.titi));
		Assertions.assertFalse(MyEnum.titi.equals(MyEnum.tutu));
		Assertions.assertFalse(MyEnum.titi.equals(null));
		Assertions.assertFalse(MyEnum.titi.equals(""));
	}

	@Test
	public void testEnumValueOf() {
		Assertions.assertEquals(MyEnum.toto, MyEnum.valueOf("toto"));
	}

	@Test
	public void testEnumValueOfIllegalo() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> MyEnum.valueOf("tata"));
	}

	@Test
	public void testEnumValueOfNPE() {
		Assertions.assertThrows(NullPointerException.class, () -> MyEnum.valueOf(null));
	}

	@Test
	public void testEnumCompareTo() {
		Assertions.assertEquals(1, MyEnum.tutu.compareTo(MyEnum.titi));
		Assertions.assertEquals(0, MyEnum.tutu.compareTo(MyEnum.tutu));
		Assertions.assertEquals(-2, MyEnum.titi.compareTo(MyEnum.toto));
		Assertions.assertEquals(-1, MyEnum.tutu.compareTo(MyEnum.toto));
	}

}
