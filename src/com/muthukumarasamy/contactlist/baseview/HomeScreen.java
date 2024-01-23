package com.muthukumarasamy.contactlist.baseview;

import java.util.Scanner;

import com.muthukumarasamy.contactlist.addcontact.AddcontactView;
import com.muthukumarasamy.contactlist.deleteContact.DeleteView;
import com.muthukumarasamy.contactlist.displayContact.DisplayView;
import com.muthukumarasamy.contactlist.searchcontact.SearchView;
import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

public class HomeScreen {

	public void Start() {
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
				DisplayView displayview = new DisplayView();
				displayview.display();
				break;
			case 4:

				DeleteView deleteview = new DeleteView();
				deleteview.deleteContact();
				break;
			}
			if (select != 0) {
				Continue();
				mc.nextLine();
			}

		} while (select != 0);
		System.out.println("Exited");
	}

	private void Continue() {
		System.out.println("----------------------------------------------");
		System.out.print("Enter to continue");
	}

	private void introduction() {
		System.out.println("     ContactList console application! ");
	}

	private void display() {
		System.out.println("\n\t+=====+=====+=====+=====+");
		System.out.println("\t| 1.Add Contact         |");
		System.out.println("\t| 2.Search Contact      |");
		System.out.println("\t| 3.Display Contact     |");
		System.out.println("\t| 4.Delete Contact      |");
		System.out.println("\t| 0.EXIT                |");
		System.out.println("\t+=====+=====+=====+=====+");
		System.out.print("\nEnter the operation -> ");
	}
}
