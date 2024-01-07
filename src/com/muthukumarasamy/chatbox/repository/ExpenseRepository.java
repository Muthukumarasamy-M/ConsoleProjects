package com.muthukumarasamy.chatbox.repository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.muthukumarasamy.chatbox.dto.Expense;

public class ExpenseRepository {

	private static ExpenseRepository expenserepository = null;
	private static final String EXPENSE_FILE = "C:\\Users\\ramki\\git\\repository\\projects\\src\\com\\muthukumarasamy\\chatbox\\files\\expense.json";
	private JSONArray jsonArray;

	public static ExpenseRepository getInstance() {
		if (expenserepository == null)
			expenserepository = new ExpenseRepository();
		return expenserepository;

	}

	public void updateExpense(Expense expense) {
		try {
			JSONParser parser = new JSONParser();
			JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(EXPENSE_FILE));

			for (Object obj : jsonArray) {
				JSONObject jsonObject = (JSONObject) obj;

				if (jsonObject.get("Month").equals(expense.getMonth())) {
					JSONArray expensesArray = (JSONArray) jsonObject.get("expenses");

					for (Object expenseObj : expensesArray) {
						JSONObject expenseObject = (JSONObject) expenseObj;

						String expenseCategory = (String) expenseObject.get("category");

						if (expenseCategory.equals(expense.getCategory())) {
							double currentAmount = (double) expenseObject.get("amount");
							System.out.println("Current amount for " + expense.getCategory() + " in "
									+ expense.getAmount() + ": Existing "+ + currentAmount);

							// Update the JSON with the new amount
							expenseObject.put("amount", expense.getAmount() + currentAmount);

							// Save the updated JSON to the file
							try (FileWriter fileWriter = new FileWriter(EXPENSE_FILE)) {
								fileWriter.write(jsonArray.toJSONString());
							}

							System.out.println(
									"Expense updated for " + expense.getCategory() + " in " + expense.getMonth() + ".");
							return;
						}
					}
					System.out.println(
							"Category '" + expense.getCategory() + "' not found for " + expense.getMonth() + ".");
					return;
				}
			}
			System.out.println("No matching month found.");
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}

	public JSONArray display(String month) throws FileNotFoundException, IOException, ParseException {

		JSONArray expensesArray = null;
		JSONArray jsonArray = ExpenseRepository.getInstance().display(month);
		for (Object obj : jsonArray) {
			JSONObject jsonObject = (JSONObject) obj;

			if (jsonObject.get("Month").equals(month)) {
				expensesArray = (JSONArray) jsonObject.get("expenses");
				break;
			}
		}
		return expensesArray;
	}

}
