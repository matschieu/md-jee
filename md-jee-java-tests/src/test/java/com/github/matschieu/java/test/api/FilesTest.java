package com.github.matschieu.java.test.api;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FilesTest {

	private static final Path FILE1 = Paths.get("target/file1.txt");

	@BeforeEach
	public void init() throws IOException {
		if (Files.exists(FILE1)) {
			Files.delete(FILE1);
		}

		Assertions.assertFalse(Files.exists(FILE1));
	}

	@Test
	public void testWriteDefault( ) throws IOException {
		for(int i = 0; i < 5; i++) {
			// No option, the line won't be appended to the file but will replace the precedent
			Files.write(FILE1, ("line" + i + System.getProperty("line.separator")).getBytes());
		}

		final List<String> lines = Files.readAllLines(FILE1);

		Assertions.assertNotNull(lines);
		Assertions.assertEquals(1, lines.size());
	}

	@Test
	public void testWriteAppend( ) throws IOException {
		for(int i = 0; i < 5; i++) {
			Files.write(FILE1, ("line" + i + System.getProperty("line.separator")).getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		}

		final List<String> lines = Files.readAllLines(FILE1);

		Assertions.assertNotNull(lines);
		Assertions.assertEquals(5, lines.size());
	}
}
