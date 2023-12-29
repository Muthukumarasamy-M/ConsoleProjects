package com.muthukumarasamy.busticketbooking.dto;

public class Booking {

	private String UserName;
	private String age;
	private String bus;
	private String Seats;

	public Booking(String UserName, String age, String busName, String Seats) {
		this.setUserName(UserName);
		this.setAge(age);
		this.setSeats(Seats);
		this.setBus(busName);

	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSeats() {
		return Seats;
	}

	public void setSeats(String seats) {
		Seats = seats;
	}

	public String getBus() {
		return bus;
	}

	public void setBus(String bus) {
		this.bus = bus;
	}
}
