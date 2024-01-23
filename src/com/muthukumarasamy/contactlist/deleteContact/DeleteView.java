package com.muthukumarasamy.contactlist.deleteContact;

import java.util.Scanner;

public class DeleteView {

	private DeleteViewModel deleteviewmodel;

	public DeleteView() {
		deleteviewmodel = new DeleteViewModel();
	}

	public void deleteContact() {
		System.out.println("\n=========================================");
		Scanner mc = new Scanner(System.in);
		System.out.println("Enter the name to be deleted");
		String dname = mc.next();

		System.out.println("\n=========================================");
		if (deleteviewmodel.deleteContact(dname) == 1)
			System.out.println("contact deleted successfully");
	}
}
