package com.muthukumarasamy.personaldiary.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.muthukumarasamy.personaldiary.dto.Note;

public class Repository {

	private static Repository repository;
	private Connection connection;

	private Repository() {
		try {
			connection = Dbconnection.getConnection();
			createTableIfNotExists();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Repository getInstance() {
		if (repository == null)
			repository = new Repository();
		return repository;
	}

	private void createTableIfNotExists() {

		try {
			String CreateTableifnotpresent = "CREATE TABLE IF NOT EXISTS personal_diary (" + " date bigint " + ","
					+ "note varchar(255)); ";
			Statement statement = connection.createStatement();
			statement.execute(CreateTableifnotpresent);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int addNote(Note note) {

		String insertquery = "Insert into personal_diary values(?,?)";
		int noofRows = 0;
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(insertquery);
			statement.setLong(1, note.getDate());
			statement.setString(2, note.getNote());
			noofRows = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return noofRows;
	}

	public ArrayList<Note> readnotes() {

		ArrayList<Note> notes = new ArrayList<>();
		String read = "SELECT *  FROM personal_diary";
		try {
			PreparedStatement statement = connection.prepareStatement(read);
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {

				long date = resultset.getLong(1);
				String para = resultset.getString(2);
				notes.add(new Note(date, para));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return notes;

	}

	public ArrayList<Note> searchNotes(String keyword) {

		ArrayList<Note> notes = new ArrayList<>();
		String query = "SELECT * FROM personal_diary WHERE note LIKE ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, "%" + keyword + "%");
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {

				Long date = resultset.getLong(1);
				String note = resultset.getString(2);
				notes.add(new Note(date, note));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notes;

	}

}
