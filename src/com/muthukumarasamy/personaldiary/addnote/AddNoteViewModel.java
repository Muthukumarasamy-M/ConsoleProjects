package com.muthukumarasamy.personaldiary.addnote;


import com.muthukumarasamy.personaldiary.dto.Note;
import com.muthukumarasamy.personaldiary.repository.Repository;

public class AddNoteViewModel {

	public static void addNote(Note note) {

	
			Repository.getInstance().addNote(note);

		

	}

}
