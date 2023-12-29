package com.muthukumarasamy.busticketbooking.dto;

import java.util.ArrayList;
import java.util.List;

public class Arrangement {

	private String busName;
	private String price;
	private String departureTime;

	private List<List<String>> Seating = new ArrayList<>();

	public Arrangement(String name, String price2, String dtime, List<List<String>> seats) {
		this.busName = name;
		this.price = price2;
		this.departureTime = dtime;
		this.Seating = seats;
	}

	public String getBusName() {
		return busName;
	}

	public String getPrice() {
		return price;
	}

	public List<List<String>> getSeating() {
		return Seating;
	}

	public void setSeating(List<List<String>> seating) {
		Seating = seating;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

}
