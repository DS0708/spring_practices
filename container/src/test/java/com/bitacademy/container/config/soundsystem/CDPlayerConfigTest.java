package com.bitacademy.container.config.soundsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bitacademy.container.soundsystem.CDPlayer;


@ExtendWith(SpringExtension.class)	//Spring환경에서 테스트 하겠다. 
@ContextConfiguration(classes=  { CDPlayerConfig.class } ) 
public class CDPlayerConfigTest {
	
	@Autowired
	private CDPlayer cdplayer;
	
	@Test
	public void testCDPlayerNotNull() {
		assertNotNull(cdplayer);
	}
	
	@Test
	public void testPlay() {
		assertEquals("Playing BongBong by Haon",cdplayer.play());
	}
	
}
