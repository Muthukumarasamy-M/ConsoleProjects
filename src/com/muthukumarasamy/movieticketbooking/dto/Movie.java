package com.muthukumarasamy.movieticketbooking.dto;

import java.util.List;

public class Movie {
	private String title;
	private String timings;
	private List<List<String>> seats;

	public Movie(String title, String timings, List<List<String>> seats2) {
		this.title = title;
		this.timings = timings;
		this.seats = seats2;
	}
	
	public String getTitle() {
		return title;
	}

	public List<List<String>> getSeats() {
		return seats;
	}

	public void setSeats(List<List<String>> data) {
		this.seats = data;

	}

	public String getTimings() {
		return timings;
	}

	public void setTimings(String timings) {
		this.timings = timings;
	}

}
