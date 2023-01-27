package com.github.matschieu.jakartaee.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

public class BookTest {

	public final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

	@Test
	public void testValidationMessage() {
		Book book = new Book();
		book.setAuthor("123");
		book.setDescription("");

		Set<ConstraintViolation<Book>> violations = validator.validate(book);
		List<String> messages = new ArrayList<>();

		Assertions.assertNotNull(violations);
		Assertions.assertEquals(5, violations.size());

		violations.stream().forEach(v -> messages.add(v.getMessage()));
		violations.stream().forEach(System.out::println);

		Assertions.assertTrue(messages.contains("Book title must not be null"));
		Assertions.assertTrue(messages.contains("Book title must not be blank"));
		Assertions.assertTrue(messages.contains("Book author must respect the regex [ a-zA-Z]*"));
		Assertions.assertTrue(messages.contains("Book description must be between 1 and 50"));
		Assertions.assertTrue(messages.contains("Book pages must be positive"));
	}

}
