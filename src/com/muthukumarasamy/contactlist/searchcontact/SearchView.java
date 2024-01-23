package com.muthukumarasamy.contactlist.searchcontact;

import java.util.List;
import java.util.Scanner;

import com.muthukumarasamy.contactlist.dto.Contact;

public class SearchView {
	private SearchViewModel searchviewmodel;

	public SearchView() {
		searchviewmodel = new SearchViewModel();
	}

	public void searchContact() {
		
		System.out.println("==========================================\n");
		Scanner mc = new Scanner(System.in);
		System.out.print("Enter the search name :");
		String searchName = mc.next();
		System.out.println("==========================================\n");
		List<Contact> contacts =searchviewmodel.searchContact(searchName);
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
