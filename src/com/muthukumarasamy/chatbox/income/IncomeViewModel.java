package com.muthukumarasamy.chatbox.income;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.muthukumarasamy.chatbox.dto.Expense;
import com.muthukumarasamy.chatbox.repository.IncomeRepository;

class IncomeViewModel {

	private JSONArray IncomeArray;

	public static void updateExpense(Expense expense) {
		IncomeRepository.getInstance().updateIncome(expense);
	}

	public void displayIncome(String month) {

		try {
			IncomeArray = IncomeRepository.getInstance().displayIncome(month);
			System.out.println("Income for " + month + ":");
			for (Object IncomeObj : IncomeArray) {
				JSONObject IncomeObject = (JSONObject) IncomeObj;

				String category = (String) IncomeObject.get("category");
				double amount = (double) IncomeObject.get("amount");

				System.out.println("Category: " + category + ", Amount: " + amount);

			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();

		}

	}

}
