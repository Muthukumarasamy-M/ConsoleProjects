package com.muthukumarasamy.contactlist.deleteContact;

import java.util.Scanner;

public class DeleteView {

	private DeleteViewModel deleteviewmodel;

	public DeleteView() {
		deleteviewmodel = new DeleteViewModel();
	}

	public void deleteContact() {
		Scanner mc = new Scanner(System.in);
		System.out.println("Enter the name to be deleted");
		String dname = mc.next();
		deleteviewmodel.deleteContact(dname);
	}
}
