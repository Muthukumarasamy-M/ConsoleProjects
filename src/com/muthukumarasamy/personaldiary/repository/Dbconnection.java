package com.muthukumarasamy.personaldiary.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {

	private static final String URL = "jdbc:mysql://localhost:3306/notes";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Muthukumar@123";

	private static Connection connection;

	public static Connection getConnection() throws SQLException {

		synchronized (Dbconnection.class) {
			if (connection == null || connection.isClosed())
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			return connection;
		}
	}
}
