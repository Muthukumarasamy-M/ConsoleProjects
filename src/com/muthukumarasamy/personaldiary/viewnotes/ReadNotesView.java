package com.muthukumarasamy.personaldiary.viewnotes;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.muthukumarasamy.personaldiary.dto.Note;

public class ReadNotesView {

	private ReadNotesViewModel readnotesviewmodel;

	public ReadNotesView() {
		readnotesviewmodel = new ReadNotesViewModel();

	}

	public void readnotes() {
		ArrayList<Note> notes = readnotesviewmodel.readnotes();
		if (notes.isEmpty())
			System.out.println("No Notes are there");
		else {
			printnotes(notes);
		}

	}
	public void searchNotes() {

		Scanner mc = new Scanner(System.in);
		System.out.print("Enter the keyword to search for : ");
		String keyword = mc.next();
		ArrayList<Note> notes = readnotesviewmodel.searchNotes(keyword);
		if (notes.isEmpty())
			System.out.println("No Notes are there");
		else {
			printnotes(notes);
		}
	}

	public void printnotes(List<Note> notes) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy HH-mm");
		for (Note note : notes) {
			System.out.println("-----------------------------------------------------------\n");
			System.out.println("Date : " + dateFormat.format(new Date(note.getDate())));
			System.out.println("Notes : " + note.getNote());
		}
	}
}
