package com.muthukumarasamy.contactlist.searchcontact;

import java.util.List;

import com.muthukumarasamy.contactlist.dto.Contact;
import com.muthukumarasamy.contactlist.repository.Repository;

class SearchViewModel {

	public List<Contact> searchContact(String searchName) {

		return Repository.getInstance().SearchContacts(searchName);
	}

}
