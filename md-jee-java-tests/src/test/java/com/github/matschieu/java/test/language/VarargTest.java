package com.github.matschieu.java.test.language;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VarargTest {

	public int countParam(String... args) {
		Assertions.assertNotNull(args);
		return args.length;
	}

	@Test
	public void testVararg() {
		Assertions.assertEquals(0, countParam());
		Assertions.assertEquals(1, countParam((String)null));
		Assertions.assertEquals(2, countParam((String)null, (String)null));
		Assertions.assertEquals(1, countParam("1"));
		Assertions.assertEquals(4, countParam("1", "2", "3", "4"));
	}

	@Test
	public void testNullVararg() {
		Assertions.assertThrows(AssertionError.class, () -> countParam(null));
	}

}
