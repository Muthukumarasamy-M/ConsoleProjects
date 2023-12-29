package com.muthukumarasamy.contactlist.searchcontact;

import java.util.List;

import com.muthukumarasamy.contactlist.dto.Contact;
import com.muthukumarasamy.contactlist.repository.Repository;

class SearchViewModel {

	public SearchViewModel() {
		
	}
	public void searchContact(String searchName) {
		List<Contact> contacts = Repository.getInstance().getList();
		boolean found = false;
		System.out.println("--------------------------");
		for (Contact contact : contacts) {
			if (contact.getName().toLowerCase().contains(searchName)) {
				
				System.out.println(contact);
				found = true;
			}
		}
		if (!found) {
			System.out.println("Name not found");
		}
		else
			System.out.println("--------------------------");
	}

}
