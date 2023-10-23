package com.github.matschieu.jakartaee.cdi;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.github.matschieu.WeldTest;
import com.github.matschieu.jakartaee.cdi.bean.AppLifeCycleObserverBean;

class AppLifeCycleTest extends WeldTest {

	@BeforeAll
	static void beforeContainerStart() {
		AppLifeCycleObserverBean.reset();
		Assertions.assertEquals(0, AppLifeCycleObserverBean.getAppInitialized());
		Assertions.assertEquals(0, AppLifeCycleObserverBean.getAppBeforeDestroyed());
		Assertions.assertEquals(0, AppLifeCycleObserverBean.getAppDestroyed());
	}

	@Test
	void testLifeCycleEvent() {
		Assertions.assertEquals(1, AppLifeCycleObserverBean.getAppInitialized());
		Assertions.assertEquals(0, AppLifeCycleObserverBean.getAppBeforeDestroyed());
		Assertions.assertEquals(0, AppLifeCycleObserverBean.getAppDestroyed());
	}

	@AfterAll
	static void afterContainerStop() {
		Assertions.assertEquals(1, AppLifeCycleObserverBean.getAppInitialized());
		Assertions.assertEquals(1, AppLifeCycleObserverBean.getAppBeforeDestroyed());
		Assertions.assertEquals(1, AppLifeCycleObserverBean.getAppDestroyed());
	}

}
