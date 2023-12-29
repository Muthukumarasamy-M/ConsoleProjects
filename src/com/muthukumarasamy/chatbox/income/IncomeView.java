package com.muthukumarasamy.chatbox.income;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

import com.muthukumarasamy.chatbox.dto.Expense;

public class IncomeView {

	private IncomeViewModel incomeviewmodel;

	public IncomeView() {
		incomeviewmodel = new IncomeViewModel();
	}

	public void updateincome()
	{
		Scanner mc = new Scanner(System.in);
		Expense expense = new Expense();
		System.out.println("Enter the category");
		expense.setCategory(mc.next());
		System.out.println("Enter the amount");
		expense.setAmount(mc.nextInt());
		System.out.println("Enter the Month");
		expense.setMonth(mc.next());

		IncomeViewModel.updateExpense(expense);
	}
	public void displayIncome() throws FileNotFoundException, IOException, ParseException
	{
		Scanner mc = new Scanner(System.in);
		String month = mc.next().toLowerCase();
		incomeviewmodel.displayIncome(month);
		
	}
}
