package com.muthukumarasamy.contactlist.addcontact;

import java.util.Scanner;

import com.muthukumarasamy.contactlist.dto.Contact;
import com.muthukumarasamy.contactlist.repository.Repository;

class AddcontactViewModel {
	static final Scanner mc = new Scanner(System.in);
	
	public void setInfo(Contact details) {
		boolean name = isValidateName(details.getName());
		boolean email = isValidateEmail(details.getEmail());
		boolean number = isValidateNumber(details.getPhoneNumber());
		while (!name) {
			System.out.println("Please Enter the valid name");
			details.setName(mc.nextLine());
			if (isValidateName(details.getName()))
				name = true;
		}
		while (!email) {
			System.out.println("Please Enter the valid Email");
			details.setEmail(mc.nextLine());
			email = isValidateEmail(details.getEmail());
		}
		while (!number) {
			System.out.println("Please Enter the valid Number");
			details.setNumber(mc.nextLine());
			if (isValidateNumber(details.getPhoneNumber()))
				number = true;
		}

		Repository.getInstance().addContacts(details);
	}

	private boolean isValidateNumber(String number) {

		if (number.matches("^[6-9]\\d{9}$"))
			return true;
		return false;
	}

	private boolean isValidateEmail(String email) {
		if (email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.com$")) {
			return true;
		}
		return false;
	}

	private boolean isValidateName(String name) {
		if (name.length() < 3)
			return false;
		if (name.matches("^[a-zA-Z ]+$"))
			return true;
		else
			return false;

	}

}
