package com.github.matschieu.java.test.language;


import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class LabelTest {

	@SuppressWarnings("unused")
	@Test
	void testLabel() {
		label1: {
			label2: {
				for(int i = 0; i < 10; i++) {
					for(int j = 0; j < 10; j++) {
						if (i == 0 && j == 5) {
							break; // Break the current for loop
						}
						if (i == 1 && j == 5) {
							break label2; // Break the label2 bloc
						}
					}
					if (i > 1) {
						fail();
					}
				}
			}
			label3: {
				// NOOP
			}
		}
	}
}
