package com.github.matschieu.jee.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ReverseServiceImpl implements ReverseService {

	@EJB
	private MessageService messageService;

	@PostConstruct
	public void postConstruct() {
		System.out.println("Using " + this.getClass().getCanonicalName());
	}

	@Override
	public String reverseString(final String str) {
		if (str != null) {
			final StringBuilder strb = new StringBuilder();
			for (int i = str.length() - 1; i >= 0; i--) {
				strb.append(str.charAt(i));
			}

			this.messageService.displayMessage(strb.toString());

			return strb.toString();
		}

		this.messageService.displayMessage(null);

		return null;
	}

}
