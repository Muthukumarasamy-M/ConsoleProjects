package com.muthukumarasamy.expensemanager.income;

import java.util.List;

import com.muthukumarasamy.expensemanager.dto.Model;
import com.muthukumarasamy.expensemanager.repository.Repository;

class IncomeViewModel {

	public List<Model> displayIncome(String month) {

		return Repository.getInstance().viewIncome(month.toLowerCase());
	}

	public int updateIncome(Model income) {

		return Repository.getInstance().addIncome(income);
	}

}
