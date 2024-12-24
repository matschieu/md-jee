package com.github.matschieu.jakartaee.cdi;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.github.matschieu.WeldTest;
import com.github.matschieu.jakartaee.cdi.bean.AppLifeCycleObserverBean;

class AppLifeCycleTest extends WeldTest {

	@BeforeAll
	static void beforeContainerStart() {
		AppLifeCycleObserverBean.reset();

		assertThat(AppLifeCycleObserverBean.getAppInitialized()).isEqualTo(0);
		assertThat(AppLifeCycleObserverBean.getAppBeforeDestroyed()).isEqualTo(0);
		assertThat(AppLifeCycleObserverBean.getAppDestroyed()).isEqualTo(0);
	}

	@Test
	void testLifeCycleEvent() {
		assertThat(AppLifeCycleObserverBean.getAppInitialized()).isEqualTo(1);
		assertThat(AppLifeCycleObserverBean.getAppBeforeDestroyed()).isEqualTo(0);
		assertThat(AppLifeCycleObserverBean.getAppDestroyed()).isEqualTo(0);
	}

	@AfterAll
	static void afterContainerStop() {
		assertThat(AppLifeCycleObserverBean.getAppInitialized()).isEqualTo(1);
		assertThat(AppLifeCycleObserverBean.getAppBeforeDestroyed()).isEqualTo(1);
		assertThat(AppLifeCycleObserverBean.getAppDestroyed()).isEqualTo(1);
	}

}
