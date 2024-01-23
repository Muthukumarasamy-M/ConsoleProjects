package com.muthukumarasamy.contactlist.deleteContact;


import com.muthukumarasamy.contactlist.repository.Repository;

class DeleteViewModel {


	public int deleteContact(String dname) {
		return Repository.getInstance().DeleteContact(dname);
	}

}
