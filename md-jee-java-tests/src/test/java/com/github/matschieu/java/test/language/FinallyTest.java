package com.github.matschieu.java.test.language;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FinallyTest {

	@Test
	void testFinally1() throws Exception {
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;

		try {
			try {
				throw new Exception();
			} catch(final Exception e) {
				throw new Exception(e);
			} finally {
				flag1 = true;
			}
		} catch(final Exception e) {
			flag2 = true;
		} finally {
			flag3 = true;
		}

		Assertions.assertTrue(flag1);
		Assertions.assertTrue(flag2);
		Assertions.assertTrue(flag3);
	}

	@Test
	void testFinally2() {
		Assertions.assertEquals(0, getNumber1());
	}

	int getNumber1() {
		int r = 0;
		try {
			return r;
		} catch(final Exception e) {
			return -1;
		} finally {
			r = 1;
		}
	}

	@Test
	void testFinally3() throws Exception {
		Assertions.assertThrows(Exception.class, () -> getNumber2());
	}

	@SuppressWarnings("finally")
	int getNumber2() throws Exception {
		try {
			return 1;
		} catch(final Exception e) {
			return -1;
		} finally {
			throw new Exception();
		}
	}
}
