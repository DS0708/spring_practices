package com.bitacademy.container.soundsystem;

import org.springframework.stereotype.Component;

@Component
public class HighSchoolRapper2Final implements CompactDisc {
	private String artist = "Haon";
	private String title = "BongBong";
	
	@Override
	public Object play() {
		// TODO Auto-generated method stub
		return "Playing "+ title + " by "+ artist;
	}

}
