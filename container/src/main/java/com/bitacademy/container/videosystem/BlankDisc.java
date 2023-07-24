package com.bitacademy.container.videosystem;

public class BlankDisc implements DigitalVideoDisc {
	private String title;
	private String studio;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStudio() {
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	@Override
	public String play() {
		return "Playing Movie " + studio + "'s "+ title;
	}

}
