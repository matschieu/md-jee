package com.github.matschieu.java.test.language;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

record Data(String str, int i) {

	Data() {
		this(null, 0);
	}

	static Data getDefault() {
		return new Data();
	}

}

public class RecordTest {

	@Test
	public void testRecord() {
		Data data = new Data("foo", 10);

		Assertions.assertEquals("foo", data.str());
		Assertions.assertEquals(10, data.i());

		data = new Data();

		Assertions.assertNull(data.str());
		Assertions.assertEquals(0, data.i());

		data = Data.getDefault();

		Assertions.assertNull(data.str());
		Assertions.assertEquals(0, data.i());
	}

	@Test
	public void testRecordEquals() {
		Data data1 = new Data("foo", 10);
		Data data2 = new Data("foo", 10);

		Assertions.assertEquals(data1, data2);
		Assertions.assertNotSame(data1, data2);
	}
}
