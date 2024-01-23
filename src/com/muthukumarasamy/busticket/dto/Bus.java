package com.muthukumarasamy.busticket.dto;

import java.util.List;

public class Bus {

	private String BusName;
	private List<List<String>> seating;

	public Bus(String name, List<List<String>> seating) {

		setBusName(name);
		setSeating(seating);
		
	}

	public String getBusName() {
		return BusName;
	}

	public void setBusName(String busName) {
		BusName = busName;
	}

	public List<List<String>> getSeating() {
		return seating;
	}

	public void setSeating(List<List<String>> seating) {
		this.seating = seating;
	}

}
