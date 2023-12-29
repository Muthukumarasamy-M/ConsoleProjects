package com.muthukumarasamy.chatbox.stack;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.muthukumarasamy.chatbox.repository.Display;
import com.muthukumarasamy.chatbox.repository.DisplayRepository;

class StackViewModel {

	private JSONArray jsonArray;

	public void getdisplay(String string) throws Exception {
		jsonArray = DisplayRepository.getInstance().getDisplay(string);
		System.out.println("+==================================+");
		if (jsonArray.size() >= 0) {
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonObjct = (JSONObject) jsonArray.get(i);
				System.out.println("|"+(i+1)+ ":"+jsonObjct.get(Integer.toString(i)));

			}
		}
		System.out.println("+==================================+");
	}
	
	public void exit() {
		System.out.println("-----------------------------------");
		System.out.println("Enter ->9 to Back or 0 to Exit");
	}

	public void introduction() {
		System.out.println("*---------++++++++++++++---------++++++++++++++------------++++++++++++----*");
		System.out.println("I am Expense tracker!,i can help you to easily record your daily spendings \n");

	}

}
