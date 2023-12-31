package com.bitacademy.container.config.videosystem.mixing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bitacademy.container.videosystem.DVDPlayer;
import com.bitacademy.container.videosystem.mixing.DVDPlayerConfig;


@ExtendWith(SpringExtension.class)	//Spring환경에서 테스트 하겠다. 
@ContextConfiguration(classes=  { DVDPlayerConfig.class } ) 
public class DVDPlayerMixingConfigTest01 {
	@Autowired
	private DVDPlayer dvdPlayer;
	
	@Test
	public void testPlay() {
		assertEquals("Playing Movie MARVEL's Avengers Infinity War", dvdPlayer.play());
	}
}
