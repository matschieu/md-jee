package com.github.matschieu.jakartaee.cdi.interceptor;

@BeanLogging // Interceptor needs to be activated in beans.xml
@BeanTimer // Interceptor needs to be activated in beans.xml
public class InterceptedBean {

	public String reverseString(String value) {
		return value != null ? new StringBuilder(value).reverse().toString() : null;
	}

}
