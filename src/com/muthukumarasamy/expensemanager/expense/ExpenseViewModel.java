package com.muthukumarasamy.expensemanager.expense;

import java.util.List;

import com.muthukumarasamy.expensemanager.dto.Model;
import com.muthukumarasamy.expensemanager.repository.Repository;

class ExpenseViewModel {

	public List<Model> display(String month) {

		return Repository.getInstance().viewExpense(month.toLowerCase());
	}

	public int  updateExpense(Model expense) {

		return Repository.getInstance().addExpense(expense);

	}
}
