package com.muthukumarasamy.trainticket.dto;

public class User {

	private String UserName;
	private String Email;
	private String PhoneNumber;
	private String Epassword;
	private int Id;
	private String Balance;

	public User(String UserName, int Id, String Email, String PhoneNumber, String Balance, String Epassword) {

		this.UserName = UserName;
		this.Id = Id;
		this.Email = Email;
		this.PhoneNumber = PhoneNumber;
		this.Balance = Balance;
		this.Epassword = Epassword;
	}
}
