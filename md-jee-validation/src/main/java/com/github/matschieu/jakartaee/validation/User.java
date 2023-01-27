package com.github.matschieu.jakartaee.validation;

import java.time.LocalDate;
import java.util.List;

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

public class User {

	@NotNull(message = "Name cannot be null")
	@NotBlank(message = "Name cannot be blank")
	@Pattern(regexp = "[ a-zA-Z]*", message = "Name must only contain letters")
	private String name;

	@Positive(message = "Age must be positive")
	@Min(value = 18, message = "Age should not be less than {value}")
	@Max(value = 150, message = "Age should not be greater than {value}")
	private int age;

	@Past
	private LocalDate birthday;

	@Email(message = "Email must be valid")
	private String email;

	@Size(min = 10, max = 200, message = "Description me must be between {min} and {max} characters")
	private String description;

	@AssertTrue
	private boolean active;

	@NotEmpty
	private List<@NotBlank String> rights;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<String> getRights() {
		return rights;
	}

	public void setRights(List<String> rights) {
		this.rights = rights;
	}

}
