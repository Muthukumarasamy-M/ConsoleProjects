package com.muthukumarasamy.chatbox.expense;

import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.muthukumarasamy.chatbox.dto.Expense;
import com.muthukumarasamy.chatbox.repository.ExpenseRepository;

class ExpenseViewModel {

	private JSONArray expensesArray;

	public ExpenseViewModel() {
	}

	public void updateExpense(Expense expense) {

		ExpenseRepository.getInstance().updateExpense(expense);
	}

	public void display(String month) {

		try {
			expensesArray = ExpenseRepository.getInstance().display(month);

			System.out.println("Expenses for " + month + ":");
			for (Object expenseObj : expensesArray) {
				JSONObject expenseObject = (JSONObject) expenseObj;

				String category = (String) expenseObject.get("category");
				double amount = (double) expenseObject.get("amount");

				System.out.println("Category: " + category + ", Amount:" + "\u20B9" + " " + amount);
			}
			System.out.println("No matching month found.");
			return;

		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

	}
}
