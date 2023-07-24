package com.bitacademy.container.config.videosystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bitacademy.container.videosystem.DVDPlayer;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes= {DVDPlayerConfig.class})
public class DVDPlayerConfigTest {
	
	@Autowired
	@Qualifier("dvdPlayer01")	//id를 지정해주기
	private DVDPlayer dvdPlayer01;
	
	@Autowired
	@Qualifier("dvdPlayer02")	//id를 지정해주기 (method이름이 id가 된다.)
	private DVDPlayer dvdPlayer02;
	
	@Autowired
	@Qualifier("dvdPlayer03")
	private DVDPlayer dvdPlayer03;
	
	@Test
	public void test() {
		//	설정 잘 되 었나 확인 
		assertTrue(true);
	}
	
	@Test
	public void dvdPlayer01NotNull() {
		assertNotNull(dvdPlayer01);
	}
	
	@Test
	public void dvdPlayer02NotNull() {
		assertNotNull(dvdPlayer02);
	}
	
	@Test
	public void dvdPlayer03NotNull() {
		assertNotNull(dvdPlayer03);
	}
	
	@Test
	public void testPlay01() {
		assertEquals("Playing Movie MARVEL's Avengers",dvdPlayer01.play());
	}
	
	@Test
	public void testPlay02() {
		assertEquals("Playing Movie MARVEL's Avengers",dvdPlayer02.play());
	}
	
	@Test
	public void testPlay03() {
		assertEquals("Playing Movie MARVEL's Avengers",dvdPlayer03.play());
	}
}
