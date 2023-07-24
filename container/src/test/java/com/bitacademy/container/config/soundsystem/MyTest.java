package com.bitacademy.container.config.soundsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

// 위에 비워놓으면 Spring환경에서 안하겠다는 것임. (JAVA위에서)
public class MyTest {
	@Test
	public void test01() {
		int i = 10;
		assertTrue(i-10 == 0);
	}
	
	@Test
	public void test02() {
		int i = 10;
		assertEquals(10,i);
	}
}
