package com.github.matschieu.java.test.functional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EmailDomainRangesCheckTest {

	private static final String[] list = new String[] {
			"myDomain1.*",
			"myDomain2.fr",
			"myDomain2.com",
			"myDomain3.be",
			null,
	};

	private boolean check(String[] list, String value) {
		for (final String item : list) {
			if (value == null || item == null) {
				continue;
			}

			if (item.endsWith(".*")) {
				if (value.toLowerCase().matches("((?i).+)@" + item.toLowerCase().replace(".*", "\\.(\\w+)"))) {
					return true;
				}
			} else if (value.toLowerCase().matches("((?i).+)@" + item.toLowerCase())) {
				return true;
			}
		}
		return false;
	}

	@ParameterizedTest
	@ValueSource(strings = {"toto@myDomain1.com", "yo@myDomain2.fr", "fck@myDomain3.be", "ami.toto@MYDOMAIN1.com", "bidou@myDOMain2.fr"})
	public void testEmailInList(String email) {
		Assertions.assertTrue(check(list, email));
	}

	@ParameterizedTest
	@ValueSource(strings = {"ploup@myDomain2.be", "burn@myDomain4.fr", "me@MYdomain2.be"})
	public void testEmailNotInList(String email) {
		Assertions.assertFalse(check(list, email));
		Assertions.assertFalse(check(list, null));
	}
}
