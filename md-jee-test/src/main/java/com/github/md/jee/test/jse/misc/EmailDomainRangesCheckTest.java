package com.github.md.jee.test.jse.misc;


public class EmailDomainRangesCheckTest {

	static final String[] list = new String[] {
			"myDomain1.*",
			"myDomain2.fr",
			"myDomain2.com",
			"myDomain3.be",
			null,
	};
	
	static boolean check(String[] list, String value) {
		for (String item : list) {
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
	
	public static void main(String[] args) {
		for(String value : new String[] { "toto@myDomain1.com", "ploup@myDomain2.be", "yo@myDomain2.fr", "fck@myDomain3.be", "burn@myDomain4.fr",
				"ami.toto@MYDOMAIN1.com", "me@MYdomain2.be", "bidou@myDOMain2.fr", null }) {
			System.out.println(value + " -> " + check(list, value));
		}
	}

}
