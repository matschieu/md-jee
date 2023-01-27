package com.github.matschieu.jakartaee.validation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class Book {

	@NotNull(message = "{book.title.notNull}")
	@NotBlank(message = "{book.title.notBlank}")
	private String title;

	@Pattern(regexp = "[ a-zA-Z]*", message = "{book.author.pattern}")
	private String author;

	@Size(min = 1, max = 50, message = "{book.description.size}")
	private String description;

	@Positive(message = "{book.pages.positive}")
	private int pages;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

}
