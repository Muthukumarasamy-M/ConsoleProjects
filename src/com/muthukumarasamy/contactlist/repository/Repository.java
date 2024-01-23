
package com.muthukumarasamy.contactlist.repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.muthukumarasamy.contactlist.dto.Contact;

public class Repository {
	private static Repository repository;
	private Connection connection;

	private Repository() {
		try {
			connection = DBconnection.getConnection();
			createTableIfNotExists();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void createTableIfNotExists() {

		try {
			String CreatetableSQL = "CREATE TABLE IF NOT EXISTS contacts( name varchar(30) primary key , phonenumber varchar(20) , email varchar(30));";
			Statement statement = connection.createStatement();
			statement.execute(CreatetableSQL);
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

	public int addContacts(Contact details) {

		try {
			String query = "INSERT into contacts VALUES(?,?,?)";
			PreparedStatement statement = connection.prepareStatement(query);

			statement.setString(1, details.getName());
			statement.setString(2, details.getPhoneNumber());
			statement.setString(3, details.getEmail());
			int Rows = statement.executeUpdate();
			return Rows;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public ArrayList<Contact> DisplayContacts() {

		ArrayList<Contact> contacts = new ArrayList<>();
		try {
			String query = "SELECT * FROM contacts";
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery(query);
			while (resultset.next()) {

				String name = resultset.getString(1);
				String phone = resultset.getString(2);
				String email = resultset.getString(3);
				contacts.add(new Contact(name, phone, email));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return contacts;

	}

	public ArrayList<Contact> SearchContacts(String keyword) {
		ArrayList<Contact> contacts = new ArrayList<>();
		try {
			String query = "SELECT * FROM contacts WHERE name LIKE ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, "%" + keyword + "%");
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				String name = resultset.getString(1);
				String phone = resultset.getString(2);
				String email = resultset.getString(3);
				contacts.add(new Contact(name, phone, email));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return contacts;
	}

	public int DeleteContact(String keyword) {
		try {
			String query = " DELETE FROM contacts WRERE name = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, keyword);
			
			int rows =statement.executeUpdate();
			return rows;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 0;

	}

}
