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

public class IncomeRepository {

	private static IncomeRepository incomerepository = null;
	private static final String INCOME_FILE = "C:\\Users\\ramki\\git\\repository\\projects\\src\\com\\muthukumarasamy\\chatbox\\files\\income.json";

	public static IncomeRepository getInstance() {
		if (incomerepository == null)
			incomerepository = new IncomeRepository();
		return incomerepository;
	}

	public void updateIncome(Expense expense) {
		try {
			JSONParser parser = new JSONParser();
			JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(INCOME_FILE));

			for (Object obj : jsonArray) {
				JSONObject jsonObject = (JSONObject) obj;
				if (jsonObject.get("Month").equals(expense.getMonth())) {
					JSONArray IncomeArray = (JSONArray) jsonObject.get("Income");
					for (Object IncomeObj : IncomeArray) {
						JSONObject IncomeObject = (JSONObject) IncomeObj;

						String IncomeCategory = (String) IncomeObject.get("category");

						if (IncomeCategory.equals(expense.getCategory())) {
							double currentAmount = (double) IncomeObject.get("amount");
							System.out.println("Current amount for " + expense.getCategory() + " in "
									+ expense.getMonth() + ": "+"\u20B9" + currentAmount);
							IncomeObject.put("amount", expense.getAmount() + currentAmount);

							// Save the updated JSON to the file
							try (FileWriter fileWriter = new FileWriter(INCOME_FILE)) {
								fileWriter.write(jsonArray.toJSONString());
							}

							System.out.println(
									"Income updated for " + expense.getCategory() + " in " + expense.getMonth() + ".");
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

	public JSONArray displayIncome(String month) throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(INCOME_FILE));
		JSONArray IncomeArray = null;
		for (Object obj : jsonArray) {
			JSONObject jsonObject = (JSONObject) obj;

			if (jsonObject.get("Month").equals(month)) {
				IncomeArray = (JSONArray) jsonObject.get("Income");
			}
		}
		return IncomeArray;

	}
}
