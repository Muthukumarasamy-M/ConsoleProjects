package com.muthukumarasamy.personaldiary.addnote;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		System.out.println("Enter the date(dd-mm-yyyy");
		String tdate = mc.nextLine();
		System.out.println("Enter the note : ");
		String note = mc.nextLine();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        Date date;
		try {
			date = dateFormat.parse(tdate);
			addnoteviewmodel.addNote(new Note(date.getTime(), note));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
