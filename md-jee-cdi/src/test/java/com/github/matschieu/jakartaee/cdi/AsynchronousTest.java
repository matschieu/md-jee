package com.github.matschieu.jakartaee.cdi;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.github.matschieu.WeldTest;
import com.github.matschieu.jakartaee.cdi.bean.AsynchronousBean;

import jakarta.inject.Inject;

class AsynchronousTest extends WeldTest {

	@Inject
	private AsynchronousBean asyncBean;

	@Test
	void testAsynchronousBean() throws InterruptedException, ExecutionException {
		Future<Boolean> future1 = asyncBean.process(1000);
		Future<Boolean> future2 = asyncBean.process(0);

		Thread.sleep(100);

		Assertions.assertTrue(future2.isDone());
		Assertions.assertFalse(future1.isDone());

		Assertions.assertTrue(future2.get());
		Assertions.assertTrue(future1.get());
	}

}
