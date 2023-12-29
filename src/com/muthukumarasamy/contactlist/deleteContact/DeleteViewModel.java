package com.muthukumarasamy.contactlist.deleteContact;

import java.util.List;

import com.muthukumarasamy.contactlist.dto.Contact;
import com.muthukumarasamy.contactlist.repository.Repository;

class DeleteViewModel {

	public DeleteViewModel() {
	}

	public void deleteContact(String dname) {

		List<Contact> contacts = Repository.getInstance().getList();
		int index = -1;
		for (int i = 0; i < contacts.size(); i++) {
			if (contacts.get(i).getName().equals(dname)) {
				index = i;
				break;
			}
		}
		if (index != -1) {
			contacts.remove(index);
			System.out.println(dname + " contact is deleted");
			System.out.println("Remaining contacts :" + contacts.size());
			Repository.getInstance().loadContactsToJson(contacts);
		} else
			System.out.println("name not found");
	}

}
