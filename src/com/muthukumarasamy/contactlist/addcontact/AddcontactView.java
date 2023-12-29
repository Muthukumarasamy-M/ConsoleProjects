package com.muthukumarasamy.contactlist.addcontact;

import java.util.Scanner;

import com.muthukumarasamy.contactlist.dto.Contact;

public class AddcontactView {

	private AddcontactViewModel addcontactviewmodel;

	public AddcontactView() {
		addcontactviewmodel = new AddcontactViewModel();
	}

	public void addContacts() {

		Scanner mc = new Scanner(System.in);
		System.out.println(" Please enter the Name");
		String Name = mc.next();
		System.out.println(" Please enter the  Email");
		String Email = mc.next();
		System.out.println(" Please enter Phone number");
		String number = mc.next();
		Contact details = new Contact(Name, Email, number);
		addcontactviewmodel.setInfo(details);
	}

}