package com.github.matschieu.java.test.api;
import java.util.Locale;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LocaleTest {

	@Test
	public void testGetCountry() {
		final String country = "fr";
		boolean found = false;

		for(final Locale locale : Locale.getAvailableLocales()) {
			if (country.toUpperCase().equals(locale.getCountry())) {
				Assertions.assertEquals("FRA", locale.getISO3Country());
				found = true;
			}
		}

		Assertions.assertTrue(found);
	}

}
