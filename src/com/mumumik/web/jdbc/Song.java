package com.mumumik.web.jdbc;

public class Song {
	
	private int id;
	private String title;
	private String startingLyrics;
	private String reff;
	private String baseKey;
	
	public Song(int id, String title, String startingLyrics, String reff, String baseKey) {
		this.id = id;
		this.title = title;
		this.startingLyrics = startingLyrics;
		this.reff = reff;
		this.baseKey = baseKey;
	}

	public Song(String title, String startingLyrics, String reff, String baseKey) {
		this.title = title;
		this.startingLyrics = startingLyrics;
		this.reff = reff;
		this.baseKey = baseKey;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStartingLyrics() {
		return startingLyrics;
	}

	public void setStartingLyrics(String startingLyrics) {
		this.startingLyrics = startingLyrics;
	}

	public String getReff() {
		return reff;
	}

	public void setReff(String reff) {
		this.reff = reff;
	}

	public String getBaseKey() {
		return baseKey;
	}

	public void setBaseKey(String baseKey) {
		this.baseKey = baseKey;
	}

	@Override
	public String toString() {
		return "Song [id=" + id + ", title=" + title + ", startingLyrics=" + startingLyrics + ", reff=" + reff
				+ ", baseKey=" + baseKey + "]";
	}
	
	
}
