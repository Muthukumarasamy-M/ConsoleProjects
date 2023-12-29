package com.muthukumarasamy.chatbox.stack;

import com.muthukumarasamy.chatbox.expense.ExpenseView;
import com.muthukumarasamy.chatbox.income.IncomeView;

import java.util.Scanner;
import java.util.Stack;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.muthukumarasamy.chatbox.expense.ExpenseView;

import box.JsonFileHandler;

public class StackView {

	private StackViewModel stackviewmodel;

	public StackView() {
		stackviewmodel = new StackViewModel();
	}

	public void start() throws Exception {

		Scanner mc = new Scanner(System.in);

		ExpenseView expenseview = new ExpenseView();
		IncomeView incomeview = new IncomeView();
		Stack<String> stack = new Stack<>();
		stackviewmodel.introduction();
		String string = "press";
		stack.push(string);
		stackviewmodel.getdisplay(stack.peek());
		int select;
		do {
			System.out.println("Enter the option");
			select = mc.nextInt();
			try {
				if (select == 0)
					break;
				if (select == 9) {
					stack.pop();
					if (stack.isEmpty()) {
						break;
					}

				} else
					stack.push(stack.peek() + "_" + select);
				string = stack.peek();
				stackviewmodel.getdisplay(string);
				switch (string) {
				case "press_1_1":
					expenseview.getExpense();
					break;
				case "press_1_2":
					incomeview.updateincome();
					break;
				case "press_2_1":
					expenseview.displayExpenses();
					break;
				case "press_2_2":
					incomeview.displayIncome();
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (string != "press")
				stackviewmodel.exit();
			else
				exitout();
		} while (select != 0);
		System.out.println("Exited");
	}

	private void exitout() {
		System.out.println("-----------------------------------");
		System.out.println("0 to Exit");

	}

}
