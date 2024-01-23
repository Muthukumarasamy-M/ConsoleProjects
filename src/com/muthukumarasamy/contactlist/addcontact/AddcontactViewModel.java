package com.muthukumarasamy.contactlist.addcontact;

import java.util.Scanner;

import com.muthukumarasamy.contactlist.dto.Contact;
import com.muthukumarasamy.contactlist.repository.Repository;

class AddcontactViewModel {
	static final Scanner mc = new Scanner(System.in);

	public int addContacts(Contact details) {
		return Repository.getInstance().addContacts(details);
	}

	public boolean isValidateNumber(String number) {
		return number.matches("^[6-9]\\d{9}$");
	}

	public boolean isValidateEmail(String email) {
		return email.trim().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
	}

	public boolean isValidateName(String name) {
		return name.length() >= 3 && name.matches("^[a-zA-Z ]+$");
	}

}
