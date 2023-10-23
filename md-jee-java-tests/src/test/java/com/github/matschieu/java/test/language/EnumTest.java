package com.github.matschieu.java.test.language;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EnumTest {

	private enum MyEnum { titi, tutu, toto }

	@Test
	void testEnumEquals() {
		Assertions.assertEquals(MyEnum.titi, MyEnum.titi);
		Assertions.assertNotEquals(MyEnum.titi, MyEnum.tutu);
		Assertions.assertNotEquals(MyEnum.titi, null);
		Assertions.assertNotEquals(MyEnum.titi, "");
	}

	@Test
	void testEnumValueOf() {
		Assertions.assertEquals(MyEnum.toto, MyEnum.valueOf("toto"));
	}

	@Test
	void testEnumValueOfIllegalo() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> MyEnum.valueOf("tata"));
	}

	@Test
	void testEnumValueOfNPE() {
		Assertions.assertThrows(NullPointerException.class, () -> MyEnum.valueOf(null));
	}

	@Test
	void testEnumCompareTo() {
		Assertions.assertEquals(1, MyEnum.tutu.compareTo(MyEnum.titi));
		Assertions.assertEquals(0, MyEnum.tutu.compareTo(MyEnum.tutu));
		Assertions.assertEquals(-2, MyEnum.titi.compareTo(MyEnum.toto));
		Assertions.assertEquals(-1, MyEnum.tutu.compareTo(MyEnum.toto));
	}

}
