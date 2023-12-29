package com.muthukumarasamy.contactlist.searchcontact;

import java.util.Scanner;

public class SearchView {
	private SearchViewModel searchviewmodel;

	public SearchView() {
		searchviewmodel = new SearchViewModel();
	}

	public void searchContact() {
		Scanner mc = new Scanner(System.in);
		System.out.println("Enter the search name :");
		String searchName = mc.next();
		searchviewmodel.searchContact(searchName);

	}
}
