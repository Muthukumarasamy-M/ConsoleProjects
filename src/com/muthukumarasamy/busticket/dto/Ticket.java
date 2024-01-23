package com.muthukumarasamy.busticket.dto;

public class Ticket {

	private String userName;
	private String Date;
	private String Arrival;
	private String Departure;
	private String Price;
	private String busName;
	private String Seats;
	private String status;

	public Ticket(String username, String Date, String Arrival, String Departure, String price, String busname,
			String Seats, String Status) {
		setUserName(username);
		setBusName(busname);
		setDate(Date);
		setPrice(price);
		setSeats(Seats);
		setArrival(Arrival);
		setDeparture(Departure);
		setStatus(Status);

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		this.Price = price;
	}

	public String getSeats() {
		return Seats;
	}

	public void setSeats(String seats) {
		this.Seats = seats;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getArrival() {
		return Arrival;
	}

	public void setArrival(String arrival) {
		Arrival = arrival;
	}

	public String getDeparture() {
		return Departure;
	}

	public void setDeparture(String departure) {
		Departure = departure;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
