package com.muthukumarasamy.trainticket.dto;

public class Ticket {

	private String start;
	private String end;
	private String price;

	public Ticket(String start, String end, String price) {
		this.start = start;
		this.end = end;
		this.price = price;
	}
}
