package com.bitacademy.container.videosystem.mixing;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.bitacademy.container.videosystem.DVDPlayer;
import com.bitacademy.container.videosystem.DigitalVideoDisc;

/*
 *  JavaConfig2 <------- JavaConfig1
 *  			import
 *  
 *  
 *  JavaConfig2 + JavaConfig1
 */
@Configuration
@Import(DVDConfig.class)
public class DVDPlayerConfig {
	
	@Bean
	public DVDPlayer dvdPlayer(@Qualifier("avengersInfinityWar")DigitalVideoDisc dvd) {
		return new DVDPlayer(dvd);
	}
	
}
