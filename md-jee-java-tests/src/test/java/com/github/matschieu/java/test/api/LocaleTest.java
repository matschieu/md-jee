package com.github.matschieu.java.test.api;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;

public class LocaleTest {

	@Test
	public void testGetCountry() {
		final String country = "fr";
		boolean found = false;

		for(final Locale locale : Locale.getAvailableLocales()) {
			if (country.toUpperCase().equals(locale.getCountry())) {
				Assert.assertEquals("FRA", locale.getISO3Country());
				found = true;
			}
		}

		Assert.assertTrue(found);
	}

}
