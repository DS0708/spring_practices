package com.bitacademy.container.config.videosystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bitacademy.container.videosystem.Avengers;
import com.bitacademy.container.videosystem.DVDPlayer;
import com.bitacademy.container.videosystem.DigitalVideoDisc;

@Configuration
public class DVDPlayerConfig {
	
	@Bean
	public DigitalVideoDisc avengers() {
		return new Avengers();
	}
	
	// 주입하기 1
	// Bean 생성 method를 직접 호출하는 방법 (위의 avengers를 호출)
	// 생성자 주입 
	@Bean
	public DVDPlayer dvdPlayer01() {
		return new DVDPlayer(avengers());
	}
	
	// 주입하기 2
	// parameter로 빈을 전달하는 방법 
	// 생성자 주입 
	// 이것 추천
	// id를 바꿔줘야 한다.
	@Bean
	public DVDPlayer dvdPlayer02(DigitalVideoDisc dvd) {
		return new DVDPlayer(dvd);
	}
	
	//주입하기 3
	//parameter 로 빈을 전달하는 방법 
	//setter 주입 
	@Bean
	public DVDPlayer dvdPlayer03(DigitalVideoDisc dvd) {
		DVDPlayer dvdPlayer = new DVDPlayer();
		dvdPlayer.setDvd(dvd);
		
		return dvdPlayer;
	}
}
