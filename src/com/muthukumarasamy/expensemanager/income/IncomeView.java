package com.muthukumarasamy.expensemanager.income;

import java.util.List;
import java.util.Scanner;
import com.muthukumarasamy.expensemanager.dto.Model;

public class IncomeView {

	private IncomeViewModel incomeviewmodel;
	Scanner mc = new Scanner(System.in);

	public IncomeView() {
		incomeviewmodel = new IncomeViewModel();
	}

	public void updateincome(String[] content) {
		Scanner mc = new Scanner(System.in);
		Model expense = new Model();
		System.out.print("Enter the category -> ");
		expense.setCategory(content[mc.nextInt()]);
		System.out.print("Enter the amount   -> ");
		expense.setAmount(mc.nextInt());
		System.out.print("Enter the Month    -> ");
		expense.setMonth(mc.next());

		if (incomeviewmodel.updateIncome(expense) == 1)
			System.out.println("\nIncome added successfully ");

	}

	public void displayIncome() {

		String month = mc.next().toLowerCase();
		List<Model> income = incomeviewmodel.displayIncome(month);
		if (income.size() > 0) {
			System.out.println("Income for the month " + income.get(0).getMonth() + " : ");
			for (Model model : income) {
				System.out.println(" " + model.getCategory() + " : " + model.getAmount());
			}
		} else {
			System.out.println("Income is empty");
		}
	}
}
