package com.github.matschieu.java.test.language;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArrayTest {

	@Test
	void testArraySize() {
		String[] array = new String[1];
		array[0] = "0";

		for(int i = 0; i < 10; i++) {
			final String[] arrayTmp = new String[array.length + 1];

			for(int j = 0; j < array.length; j++) {
				arrayTmp[j] = array[j];
			}

			arrayTmp[arrayTmp.length - 1] = "" + (arrayTmp.length - 1);
			array = arrayTmp;
		}

		for(int i = 0; i < array.length; i++) {
			Assertions.assertEquals("" + i, array[i]);
		}
	}


}
