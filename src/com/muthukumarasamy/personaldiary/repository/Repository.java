package com.muthukumarasamy.personaldiary.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

	public Repository getInstance() {
		if (repository == null)
			repository = new Repository();
		return repository;
	}

	private void createTableIfNotExists() {

		String query = "create table if not exists ("+" date_of_entry bigint primary key" +","+"note varchar(255) ";

	}
}
