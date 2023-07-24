package com.bitacademy.container.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer {
	
	@Autowired
	private CompactDisc cd;
	
	public Object play() {
		// TODO Auto-generated method stub
		return cd.play();
	}

}
