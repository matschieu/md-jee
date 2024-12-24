package com.github.matschieu.jakartaee.validation;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class UserTest {

	public final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

	private String getAnnotationName(ConstraintViolation<?> constraintViolation) {
		return constraintViolation.getConstraintDescriptor().getAnnotation().toString().split("\\(")[0].substring(1);
	}

	private void checkConstraintViolations(String field, List<Class<?>> expectedConstraintViolations, Set<ConstraintViolation<User>> violations) {
		assertThat(violations).isNotNull();
		assertThat(violations.size()).isEqualTo(expectedConstraintViolations.size());

		List<String> constraints = new ArrayList<>();

		violations.stream().forEach(v -> {
			constraints.add(getAnnotationName(v));
			assertThat(v.getPropertyPath().toString()).isEqualTo(field);
		});

		expectedConstraintViolations.stream().forEach(c -> assertThat(constraints).contains(c.getCanonicalName()));

		violations.stream().forEach(System.out::println);
	}

	private User getValidUser() {
		User user = new User();
		user.setName("Mat");
		user.setActive(true);
		user.setAge(35);
		user.setBirthday(LocalDate.now().minusYears(10));
		user.setDescription("This is my user");
		user.setEmail("mat@domain.com");
		user.setRights(Arrays.asList("admin"));
		return user;
	}

	@Test
	public void testValidUser() {
		Set<ConstraintViolation<User>> violations = validator.validate(getValidUser());

		assertThat(violations).isNotNull();
		assertThat(violations).isEmpty();
	}

	@Test
	public void testNameNotNull() {
		User user = getValidUser();
		user.setName(null);

		Set<ConstraintViolation<User>> violations = validator.validate(user);

		checkConstraintViolations("name", Arrays.asList(NotNull.class, NotBlank.class), violations);
	}

	@Test
	public void testNameNotBlank() {
		User user = getValidUser();
		user.setName("");

		Set<ConstraintViolation<User>> violations = validator.validate(user);

		checkConstraintViolations("name", Arrays.asList(NotBlank.class), violations);
	}

	@Test
	public void testNameInvalidPattern() {
		User user = getValidUser();
		user.setName("123");

		Set<ConstraintViolation<User>> violations = validator.validate(user);

		checkConstraintViolations("name", Arrays.asList(Pattern.class), violations);
	}

	@Test
	public void testAgeLessThanMin() {
		User user = getValidUser();
		user.setAge(10);

		Set<ConstraintViolation<User>> violations = validator.validate(user);

		checkConstraintViolations("age", Arrays.asList(Min.class), violations);
	}

	@Test
	public void testAgeGreaterThanMax() {
		User user = getValidUser();
		user.setAge(200);

		Set<ConstraintViolation<User>> violations = validator.validate(user);

		checkConstraintViolations("age", Arrays.asList(Max.class), violations);
	}

	@Test
	public void testAgeNegative() {
		User user = getValidUser();
		user.setAge(-10);

		Set<ConstraintViolation<User>> violations = validator.validate(user);

		checkConstraintViolations("age", Arrays.asList(Positive.class, Min.class), violations);
	}

	@Test
	public void testBirthdayInFuture() {
		User user = getValidUser();
		user.setBirthday(LocalDate.now().plusDays(10));

		Set<ConstraintViolation<User>> violations = validator.validate(user);

		checkConstraintViolations("birthday", Arrays.asList(Past.class), violations);
	}

	@Test
	public void testEmailInvalid() {
		User user = getValidUser();
		user.setEmail("email");

		Set<ConstraintViolation<User>> violations = validator.validate(user);

		checkConstraintViolations("email", Arrays.asList(Email.class), violations);
	}

	@Test
	public void testDescriptionTooShort() {
		User user = getValidUser();
		user.setDescription("desc");

		Set<ConstraintViolation<User>> violations = validator.validate(user);

		checkConstraintViolations("description", Arrays.asList(Size.class), violations);
	}

	@Test
	public void testDescriptionTooLong() {
		StringBuilder desc = new StringBuilder();
		for(int i = 0; i < 250; i++) {
			desc.append("A");
		}

		User user = getValidUser();
		user.setDescription(desc.toString());

		Set<ConstraintViolation<User>> violations = validator.validate(user);

		checkConstraintViolations("description", Arrays.asList(Size.class), violations);
	}

	@Test
	public void testActiveFalse() {
		User user = getValidUser();
		user.setActive(false);

		Set<ConstraintViolation<User>> violations = validator.validate(user);

		checkConstraintViolations("active", Arrays.asList(AssertTrue.class), violations);
	}

	@Test
	public void testRightsEmpty() {
		User user = getValidUser();
		user.setRights(new ArrayList<>());

		Set<ConstraintViolation<User>> violations = validator.validate(user);

		checkConstraintViolations("rights", Arrays.asList(NotEmpty.class), violations);
	}

	@Test
	public void testRightsWithBlankValue() {
		User user = getValidUser();
		user.setRights(Arrays.asList("A", "", "C"));

		Set<ConstraintViolation<User>> violations = validator.validate(user);

		checkConstraintViolations("rights[1].<list element>", Arrays.asList(NotBlank.class), violations);
	}

}
