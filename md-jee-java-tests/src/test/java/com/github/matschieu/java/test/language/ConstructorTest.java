package com.github.matschieu.java.test.language;

import org.junit.Assert;
import org.junit.Test;

class ConstA {

	boolean flag = false;

	ConstA() {
		flag = true;
	}

}

class ConstB extends ConstA { }

class ConstC extends ConstB { }

public class ConstructorTest {

	@Test
	public void testConstructor() {
		Assert.assertTrue((new ConstC()).flag);
	}

}
