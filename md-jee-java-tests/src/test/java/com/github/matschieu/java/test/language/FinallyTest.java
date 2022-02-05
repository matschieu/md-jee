package com.github.matschieu.java.test.language;

import org.junit.Assert;
import org.junit.Test;

public class FinallyTest {

	@Test
	public void testFinally1() throws Exception {
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

		Assert.assertTrue(flag1);
		Assert.assertTrue(flag2);
		Assert.assertTrue(flag3);
	}

	@Test
	public void testFinally2() {
		Assert.assertEquals(0, getNumber1());
	}

	public int getNumber1() {
		int r = 0;
		try {
			return r;
		} catch(final Exception e) {
			return -1;
		} finally {
			r = 1;
		}
	}

	@Test(expected = Exception.class)
	public void testFinally3() throws Exception {
		getNumber2();
	}

	public int getNumber2() throws Exception {
		try {
			return 1;
		} catch(final Exception e) {
			return -1;
		} finally {
			throw new Exception();
		}
	}
}
