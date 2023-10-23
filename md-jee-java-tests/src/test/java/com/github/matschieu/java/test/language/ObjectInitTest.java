package com.github.matschieu.java.test.language;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;


class ObjectInitTest {

	private int number;

	String str;


	void setNumber(int a) {
		this.number = a;
	}

	int getNumber() {
		return number;
	}

	void testObjectInit1() {
		final ObjectInitTest objectInit = new ObjectInitTest() {{
			setNumber(3);
			str = "toto";
		}};

		Assertions.assertEquals(3, objectInit.getNumber());
		Assertions.assertEquals("toto", objectInit.str);

	}

	void testObjectInit2() {
		@SuppressWarnings("serial")
		final
		List<String> list = new ArrayList<String>() {{
			add("toto");
			add("titi");
			add("tata");
		}};

		Assertions.assertEquals(3, list.size());
	}

}
