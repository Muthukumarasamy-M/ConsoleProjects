package com.muthukumarasamy.chatbox.expense;

import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.muthukumarasamy.chatbox.dto.Expense;

public class ExpenseView {

	private ExpenseViewModel expenseviewmodel;
	private JSONArray jsonArray;

	public ExpenseView() {
		expenseviewmodel = new ExpenseViewModel();
	}

	public void getExpense() {
		Scanner mc = new Scanner(System.in);
		Expense expense = new Expense();

		System.out.println("Enter the category");
		expense.setCategory(mc.next());
		System.out.println("Enter the amount");
		expense.setAmount(mc.nextInt());
		System.out.println("Enter the Month");
		expense.setMonth(mc.next());

		expenseviewmodel.updateExpense(expense);

	}
	
	public void displayExpenses() {
		Scanner scan = new Scanner(System.in);
		String month = scan.next();
		expenseviewmodel.display(month);

	}
}
