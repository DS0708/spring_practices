package com.bitacademy.container.videosystem;

//Annotation 안달거임
public class DVDPlayer {
	private DigitalVideoDisc dvd;
	
	public DVDPlayer(DigitalVideoDisc dvd) {
		this.dvd = dvd;
	}

	public DVDPlayer() {
	}

	public String play() {
		return dvd.play();
	}

	public DigitalVideoDisc getDvd() {
		return dvd;
	}

	public void setDvd(DigitalVideoDisc dvd) {
		this.dvd = dvd;
	}
}
