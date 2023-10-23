package com.github.matschieu.java.test.api;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StackTraceTest {

	private void throwException() {
		final NullPointerException npe = new NullPointerException("Null in VirtualClass");
		npe.setStackTrace(new StackTraceElement[] {
				new StackTraceElement(this.getClass().getPackageName() + ".VirtualClass", "virtualMethod", "VirtualClass.class", 1317),
		});

		final RuntimeException exc = new RuntimeException(npe);

		throw exc;
	}

	@Test
	void testStackTraceElement() {
		try {
			this.throwException();
			fail();
		} catch (final Exception e) {
			Assertions.assertEquals(NullPointerException.class, e.getCause().getClass());

			final StringWriter strWriter = new StringWriter();

			e.printStackTrace(new PrintWriter(strWriter));

			final Scanner sc = new Scanner(strWriter.toString());
			String stLastLine = null;

			while (sc.hasNextLine()) {
				stLastLine = sc.nextLine();
			}

			Assertions.assertNotNull(stLastLine);
			Assertions.assertEquals("at com.github.matschieu.java.test.api.VirtualClass.virtualMethod(VirtualClass.class:1317)", stLastLine.trim());
		}
	}

}
