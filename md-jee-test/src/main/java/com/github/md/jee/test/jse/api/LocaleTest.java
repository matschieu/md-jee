package com.github.md.jee.test.jse.api;
import java.util.Locale;



public class LocaleTest {

	public static void main(String[] args) {
		String country = "fr";

		for(Locale l : Locale.getAvailableLocales())
			if (country.toUpperCase().equals(l.getCountry()))
				System.out.println(l.getISO3Country());
	}
}
