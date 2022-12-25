package com.github.matschieu.jakartaee.cdi;

import java.lang.annotation.Annotation;

public final class AnnotationUtils {

	private AnnotationUtils() { }

	public static final Annotation toAnnotation(Class<? extends Annotation> annotationType) {
		return new Annotation() {
			@Override
			public Class<? extends Annotation> annotationType() {
				return annotationType;
			}
		};
	}

}
