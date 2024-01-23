package com.muthukumarasamy.personaldiary.addnote;

import java.util.Date;
import java.util.Scanner;

import com.muthukumarasamy.personaldiary.dto.Note;

public class AddNoteView {

	private AddNoteViewModel addnoteviewmodel;

	public AddNoteView() {
		addnoteviewmodel = new AddNoteViewModel();
	}

	public void addNote() {
		Scanner mc = new Scanner(System.in);

		Date date = new Date();
		System.out.println("\nEnter the note : ");
		String note = mc.nextLine();
		AddNoteViewModel.addNote(new Note(date.getTime(), note));
		
		System.out.println("\nThe note was successfully added !!!");
	}

}
