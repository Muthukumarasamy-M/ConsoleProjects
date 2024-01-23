package com.muthukumarasamy.personaldiary.dto;

public class Note {

	private String note;
	private long date;

	public Note(long date,String note) {
		this.setNote(note);
		this.setDate(date);
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

}
