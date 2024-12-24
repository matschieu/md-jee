package com.github.matschieu.jakartaee.cdi;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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

		assertThat(future2.isDone()).isTrue();
		assertThat(future1.isDone()).isFalse();

		assertThat(future2.get()).isTrue();
		assertThat(future1.get()).isTrue();
	}

}
