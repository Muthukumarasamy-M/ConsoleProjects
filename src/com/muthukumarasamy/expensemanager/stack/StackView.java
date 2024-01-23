package com.muthukumarasamy.expensemanager.stack;

import java.util.Scanner;
import java.util.Stack;

import com.muthukumarasamy.expensemanager.expense.ExpenseView;
import com.muthukumarasamy.expensemanager.income.IncomeView;

public class StackView {

	public void start() {

		Scanner mc = new Scanner(System.in);

		ExpenseView expenseview = new ExpenseView();
		IncomeView incomeview = new IncomeView();
		Stack<String> stack = new Stack<>();
		introduction();
		String string = "press";
		display(string);
		stack.push(string);
		int select;
		do {
			System.out.print("Enter the option -> ");
			select = mc.nextInt();
			try {
				if (select == 0)
					break;
				else if (select == 9) {
					stack.pop();
					if (stack.isEmpty()) {
						break;
					}
				} else
					stack.push(stack.peek() + "_" + select);
				string = stack.peek();
				switch (string) {
				case "press_1_1":
					expenseview.getExpense(display(string));
					break;
				case "press_1_2":
					incomeview.updateincome(display(string));
					break;
				case "press_2_1":
					display(string);
					expenseview.displayExpenses();
					break;
				case "press_2_2":
					display(string);
					incomeview.displayIncome();
					break;
				default:
					display(string);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (string != "press")
				exit();
			else
				exitout();
		} while (select != 0);
		System.out.println("Exited");
	}

	private void exitout() {
		System.out.println("-----------------------------------");
		System.out.println("0 to Exit");

	}

	public void exit() {
		System.out.println("-----------------------------------");
		System.out.println("Enter ->9 to Back or 0 to Exit");
	}

	public void introduction() {
		System.out.println("*---------++++++++++++++---------++++++++++++++------------++++++++++++----*");
		System.out.println("\tI am Expense tracker!");
	}

	public String[] display(String category) {

		String[] subcategories = null;
		switch (category) {
		case "press":
			print(subcategories = new String[] { "ADD", "View" });
			break;
		case "press_1":
			print(subcategories = new String[] { "Add Expense", "Add Income" });
			break;
		case "press_1_1":
			print(subcategories = new String[] { "Groceries", "Entertainment", "Outside food", "Bills", "health" });
			break;
		case "press_1_2":
			print(subcategories = new String[] { "Salary", "Advance", "Bonus" });
			break;
		case "press_2":
			print(subcategories = new String[] { "View Expense", "View Income" });
			break;
		case "press_2_1":
		case "press_2_2":
			print(subcategories = new String[] { "Enter the month name :" });
			break;
		}
		return subcategories;

	}

	private void print(String[] strings) {

		System.out.println("\n\t+--------------------+");
		for (int i = 0; i < strings.length; i++) {

			System.out.println("\t|   " + (i + 1) + " : " + strings[i]);
		}
		System.out.println("\t+--------------------+");

	}

}
