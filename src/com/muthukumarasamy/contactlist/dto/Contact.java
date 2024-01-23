package com.muthukumarasamy.contactlist.dto;

import org.json.JSONObject;

public class Contact  {

	private String name;
	private String email;
	private String phoneNumber;

	public Contact(String name,String phoneNumber ,String email) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setName(String Name) {

		this.name = Name;
	}

	public void setEmail(String Email) {
		this.email = Email;
	}

	public void setNumber(String number) {
		this.phoneNumber = number;
	}

	public JSONObject toJson() {
		JSONObject jsonContact = new JSONObject();
		jsonContact.put("name", name);
		jsonContact.put("email", email);
		jsonContact.put("phoneNumber", phoneNumber);
		return jsonContact;
	}

	public static Contact fromJson(JSONObject jsonContact) {
		String name = jsonContact.getString("name");
		String email = jsonContact.getString("email");
		String phoneNumber = jsonContact.getString("phoneNumber");
		return new Contact(name, email, phoneNumber);
	} 
	
	public String toString() {

		return " Name: " + name + "\n Phone.no: " + phoneNumber+"\n";
	}

}