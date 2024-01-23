package com.muthukumarasamy.contactlist.displayContact;

import java.util.List;

import com.muthukumarasamy.contactlist.dto.Contact;

public class DisplayView {

	private DisplayViewModel displayviewmodel;

	public DisplayView() {
		displayviewmodel = new DisplayViewModel();
	}

	public void display() {

		List<Contact> contacts = displayviewmodel.display();
		if (contacts.isEmpty()) {
			System.out.println("Contact book is empty.");
		} else {
			System.out.println("Contacts:");
	        System.out.printf("%-20s %-15s %-30s%n", "Name","Phone Number", "Email");
	        System.out.println("------------------------------------------------------------");

	        for (Contact contact : contacts) {
	            System.out.printf("%-20s %-15s %-30s%n",contact.getName(),contact.getPhoneNumber(),contact.getEmail());
	        }
		}
	}

}
