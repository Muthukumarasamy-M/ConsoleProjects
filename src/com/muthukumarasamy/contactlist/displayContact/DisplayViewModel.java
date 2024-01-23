package com.muthukumarasamy.contactlist.displayContact;

import java.util.List;

import com.muthukumarasamy.contactlist.dto.Contact;
import com.muthukumarasamy.contactlist.repository.Repository;

class DisplayViewModel {
	public List<Contact> display() {

		return Repository.getInstance().DisplayContacts();
	}

}
