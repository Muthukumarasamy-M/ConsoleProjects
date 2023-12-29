package com.muthukumarasamy.contactlist;

import java.util.Scanner;

import com.muthukumarasamy.contactlist.addcontact.AddcontactView;
import com.muthukumarasamy.contactlist.deleteContact.DeleteView;
import com.muthukumarasamy.contactlist.displayContact.DisplayView;
import com.muthukumarasamy.contactlist.searchcontact.SearchView;

public class ContactList {

	public static void main(String[] args) {

		ContactList c = new ContactList();
		c.init();
	}

	private void init() {
		introduction();
		int select;
		Scanner mc = new Scanner(System.in);
		do {
			display();
			select = mc.nextInt();
			mc.nextLine();
			switch (select) {
			case 1:
				AddcontactView addcontactview = new AddcontactView();
				addcontactview.addContacts();
				break;
			case 2:
				SearchView searchview = new SearchView();
				searchview.searchContact();
				break;

			case 3:
				DeleteView deleteview = new DeleteView();
				deleteview.deleteContact();
				break;
			case 4:
				DisplayView displayview = new DisplayView();
				displayview.display();
				break;
			}
			if(select !=0)
			{
				Continue();
				mc.nextLine();
			}
			
		} while (select != 0);
		System.out.println("Exited");
	}

	private void Continue() {
		System.out.println("--------------------------");
		System.out.print("Enter to continue");
	}

	private void introduction() {
		System.out.println(" Welcome to the ContactList console application! ");
	}

	private void display() {
		System.out.println("+=====+=====+=====+=====+");
		System.out.println("| 1.Add Contact\n| 2.Search Contact\n| 3.Delete Contact\n| 4.Display Contact\n| 0.Exit");
		System.out.println("+=====+=====+=====+=====+");

	}

}
