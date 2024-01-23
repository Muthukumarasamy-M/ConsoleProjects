package com.muthukumarasamy.personaldiary.baseview;

import java.util.Scanner;

import com.muthukumarasamy.personaldiary.addnote.AddNoteView;
import com.muthukumarasamy.personaldiary.viewnotes.ReadNotesView;

public class HomeScreen {

	public void Start() {
		Scanner mc = new Scanner(System.in);
		int select = 0;
		do {
			displayScreen();
			select = mc.nextInt();
			mc.nextLine();
			
			switch (select) {

			case 1:
				AddNoteView addnoteview = new AddNoteView();
				addnoteview.addNote();
				break;
			case 2:
				ReadNotesView readnotesview = new ReadNotesView();
				readnotesview.readnotes();
				break;
			case 3:
				ReadNotesView readnoteview = new ReadNotesView();
				readnoteview.searchNotes();
				break;
			case 4:
				break;
			}
			if (select != 4) {
				Continue();
				mc.nextLine();
			}
		} while (select != 5);
	}

	private void Continue() {

		System.out.println("------------------------------------");
		System.out.println("press Enter to continue ");

	}

	private void displayScreen() {
		System.out.println("\t       Personal Diary       ");
		System.out.println("\t+----------------------------+");
		System.out.println("\t|   1. ADD Notes             |");
		System.out.println("\t|   2. Read Notes            |");
		System.out.println("\t|   3. Search Notes          |");
		System.out.println("\t|   4. Exit                  |");
		System.out.println("\t+----------------------------+");
		System.out.print("Enter the opteration : ");
	}

}
