package com.muthukumarasamy.personaldiary.viewnotes;

import java.util.ArrayList;

import com.muthukumarasamy.personaldiary.dto.Note;
import com.muthukumarasamy.personaldiary.repository.Repository;

public class ReadNotesViewModel {

	public ArrayList<Note> readnotes() {

		return Repository.getInstance().readnotes();
	}

	public ArrayList<Note> searchNotes(String keyword) {
	
		return Repository.getInstance().searchNotes(keyword);
	}

}
