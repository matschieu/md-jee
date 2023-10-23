package com.github.matschieu.java.test.language;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.Closeable;
import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

enum Status {
	OPENED, CLOSED;
}

class StatusHolder {
	Status status;
}

class MyResource implements Closeable {

	private final StatusHolder statusHolder;

	MyResource(StatusHolder statusHolder) throws IOException {
		this.statusHolder = statusHolder;
		this.statusHolder.status = Status.OPENED;
	}

	@Override
	public void close() throws IOException {
		this.statusHolder.status = Status.CLOSED;
	}
}

class TryWithResourceTest {

	@Test
	void testTryWithResource() {
		final StatusHolder statusHolder = new StatusHolder();

		try(MyResource myResource = new MyResource(statusHolder)) {
			Assertions.assertEquals(Status.OPENED, statusHolder.status);
		} catch (final IOException e) {
			fail();
		} finally {
			Assertions.assertEquals(Status.CLOSED, statusHolder.status);
		}
	}

}
