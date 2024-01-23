package com.muthukumarasamy.contactlist.addcontact;

import java.util.Scanner;

import com.muthukumarasamy.contactlist.dto.Contact;

public class AddcontactView {

	private AddcontactViewModel addcontactviewmodel;
	Scanner mc = new Scanner(System.in);

	public AddcontactView() {
		addcontactviewmodel = new AddcontactViewModel();
	}

	public void addContacts() {

		System.out.println("==========================================\n");
		System.out.println("Please Enter contact Details");
		System.out.print("\nName : ");
		String Name = mc.nextLine();
		checkname(Name);
		System.out.print("\nEmail : ");
		String Email = mc.nextLine();
		checkemail(Email);
		System.out.print("\nPhone number : ");
		String number = mc.nextLine();
		checkphone(number);
		System.out.println("\n==========================================");

		Contact details = new Contact(Name, number,Email);
		if(addcontactviewmodel.addContacts(details)==1)
			System.out.println("Contact successfully added");
	}

	private void checkphone(String number) {
		if (!addcontactviewmodel.isValidateNumber(number)) {
			System.out.print("Enter the valid number : ");
			String str = mc.nextLine();
			checkphone(str);
		}
	}

	private void checkname(String name) {
		if (!addcontactviewmodel.isValidateName(name)) {
			System.out.print("Enter the valid name: ");
			String str = mc.nextLine();
			checkname(str);
		}

	}

	private void checkemail(String email) {
		if (!addcontactviewmodel.isValidateEmail(email)) {
			System.out.print("Enter the valid Email : ");
			String str = mc.nextLine();
			checkemail(str);
		}

	}
}