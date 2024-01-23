package com.muthukumarasamy.expensemanager.expense;

import java.util.List;
import java.util.Scanner;

import com.muthukumarasamy.expensemanager.dto.Model;

public class ExpenseView {

	private ExpenseViewModel expenseviewmodel;

	Scanner mc = new Scanner(System.in);

	public ExpenseView() {
		expenseviewmodel = new ExpenseViewModel();
	}

	public void getExpense(String[] content) {
		Model expense = new Model();

		System.out.print("\nEnter the Month    ->");
		expense.setMonth(mc.next());
		System.out.print("\nEnter the category -> ");
		expense.setCategory(content[mc.nextInt() - 1]);
		System.out.print("\nEnter the amount   ->");
		expense.setAmount(mc.nextInt());

		if (expenseviewmodel.updateExpense(expense) == 1)
			System.out.println("\nExpense added successfully ");

	}

	public void displayExpenses() {

		String month = mc.next();
		List<Model> expense = expenseviewmodel.display(month);
		if (expense.size() > 0) {
			System.out.println("Expense for " + expense.get(0).getMonth() + " : ");
			for (Model model : expense) {
				System.out.println("->" + model.getCategory() + " : " + model.getAmount());
			}
		} else
			System.out.println("There is no Expense for month ");

	}
}
