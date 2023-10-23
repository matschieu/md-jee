package com.github.matschieu.java.test.language;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConstA {

	boolean flag = false;

	ConstA() {
		flag = true;
	}

}

class ConstB extends ConstA { }

class ConstC extends ConstB { }

class ConstructorTest {

	@Test
	void testConstructor() {
		Assertions.assertTrue((new ConstC()).flag);
	}

}
