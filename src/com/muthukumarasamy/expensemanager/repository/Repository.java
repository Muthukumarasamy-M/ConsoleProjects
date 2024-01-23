package com.muthukumarasamy.expensemanager.repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.muthukumarasamy.expensemanager.dto.Model;

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

	}
	public static Repository getInstance() {
		if (repository == null)
			repository = new Repository();
		return repository;
	}
	public int addRecord(Model model, String tableName) {
		int rows=0;
		try {
	        // Step 1: Get monthid using the monthname from the Model
	        int monthId = getMonthId(model.getMonth());

	        // Step 2: Perform the INSERT operation
	        String query = String.format("INSERT INTO %s (monthid, category, amount) VALUES (?, ?, ?)", tableName);
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setInt(1, monthId);
	            preparedStatement.setString(2, model.getCategory());
	            preparedStatement.setDouble(3, model.getAmount());

	           rows = preparedStatement.executeUpdate();
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); // Handle exceptions appropriately in your application
	    }
		return rows;
	}
	private int getMonthId(String monthName) throws SQLException {
        int monthId = -1;

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT monthid FROM months WHERE monthname = ?")) {
            preparedStatement.setString(1, monthName);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    monthId = resultSet.getInt("monthid");
                }
            }
        }

        return monthId;
    }

	public List<Model> viewRecords(String tableName, String month) {
	    List<Model> records = new ArrayList<>();
	    try {
	        int monthId = getMonthId(month);
	        String query = String.format("SELECT * FROM %s WHERE monthid = ?", tableName);

	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setInt(1, monthId);
	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                while (resultSet.next()) {
	                    Model model = new Model();
	                    model.setMonth(month); // Assuming "month" is the column name
	                    model.setCategory(resultSet.getString("category"));
	                    model.setAmount(resultSet.getDouble("amount"));
	                    records.add(model);
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return records;
	}

	public int addExpense(Model model) {
	    return addRecord(model, "expenses");
	}

	public int addIncome(Model model) {
	    return addRecord(model, "income");
	}

	public List<Model> viewExpense(String month) {
	    return viewRecords("expenses", month);
	}

	public List<Model> viewIncome(String month) {
	    return viewRecords("income", month);
	}
}

	