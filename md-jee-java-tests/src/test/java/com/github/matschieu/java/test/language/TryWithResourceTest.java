package com.github.matschieu.java.test.language;
import static org.junit.Assert.fail;

import java.io.Closeable;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

enum Status {
	OPENED, CLOSED;
}

class StatusHolder {
	Status status;
}

class MyResource implements Closeable {

	private final StatusHolder statusHolder;

	public MyResource(StatusHolder statusHolder) throws IOException {
		this.statusHolder = statusHolder;
		this.statusHolder.status = Status.OPENED;
	}

	@Override
	public void close() throws IOException {
		this.statusHolder.status = Status.CLOSED;
	}
}

public class TryWithResourceTest {

	@Test
	public void testTryWithResource() {
		final StatusHolder statusHolder = new StatusHolder();

		try(MyResource myResource = new MyResource(statusHolder)) {
			Assert.assertEquals(Status.OPENED, statusHolder.status);
		} catch (final IOException e) {
			fail();
		} finally {
			Assert.assertEquals(Status.CLOSED, statusHolder.status);
		}
	}

}
