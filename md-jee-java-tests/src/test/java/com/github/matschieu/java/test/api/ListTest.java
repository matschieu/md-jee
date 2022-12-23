package com.github.matschieu.java.test.api;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ListTest {

	@Test
	public void testList1() {
		final List<String> list = new ArrayList<String>();

		String str = "1";
		list.add(str);

		str = "2";
		list.add(str);

		str = "3";
		list.add(str);

		Assertions.assertEquals(3, list.size());
	}

	@Test
	public void testList2() {
		final List<String> list = new ArrayList<String>();

		list.add("toto");
		list.add(null);
		list.add("titi");

		Assertions.assertEquals(3, list.size());
	}

	class MyBean {

		private String value;

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

	}

	@Test
	public void testCopyList() {
		final List<MyBean> list1 = new ArrayList<MyBean>();

		for (int i = 0; i < 20; i++) {
			final MyBean mb = new MyBean();
			mb.setValue("" + i);
			list1.add(mb);
		}

		final List<MyBean> list2 = new ArrayList<MyBean>(list1);

		Assertions.assertEquals(20, list2.size());

		for (int i = 0; i < 15; i++) {
			list2.remove(list1.get(i));
		}

		Assertions.assertEquals(20, list1.size());
		Assertions.assertEquals(5, list2.size());
	}

}
