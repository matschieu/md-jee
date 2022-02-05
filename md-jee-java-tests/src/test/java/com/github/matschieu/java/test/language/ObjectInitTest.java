package com.github.matschieu.java.test.language;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;


public class ObjectInitTest {

	private int number;

	String str;


	public void setNumber(int a) {
		this.number = a;
	}

	public int getNumber() {
		return number;
	}

	public void testObjectInit1() {
		final ObjectInitTest objectInit = new ObjectInitTest() {{
			setNumber(3);
			str = "toto";
		}};

		Assert.assertEquals(3, objectInit.getNumber());
		Assert.assertEquals("toto", objectInit.str);

	}

	public void testObjectInit2() {
		@SuppressWarnings("serial")
		final
		List<String> list = new ArrayList<String>() {{
			add("toto");
			add("titi");
			add("tata");
		}};

		Assert.assertEquals(3, list.size());
	}

}
