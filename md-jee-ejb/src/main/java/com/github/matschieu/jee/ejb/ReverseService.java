package com.github.matschieu.jee.ejb;

import javax.ejb.Local;

@Local
public interface ReverseService {

	String reverseString(String str);

}
