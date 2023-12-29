package com.muthukumarasamy.contactlist.displayContact;

import java.util.List;

import com.muthukumarasamy.contactlist.dto.Contact;
import com.muthukumarasamy.contactlist.repository.Repository;

class DisplayViewModel {

	public DisplayViewModel() {
		// TODO Auto-generated constructor stub
	}

	public List<Contact> display() {

		List<Contact> contacts = Repository.getInstance().getList();
		return contacts;
	}

}
