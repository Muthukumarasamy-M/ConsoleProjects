package com.muthukumarasamy.taskmanager.deletetask;

import java.util.Scanner;

public class DeleteTaskView {

	public DeleteTaskViewModel deletetaskviewmodel;

	public DeleteTaskView() {
		deletetaskviewmodel = new DeleteTaskViewModel();
	}

	public void deleteTask() {

		Scanner mc = new Scanner(System.in);
		System.out.println("Enter the title : ");
		String dtask = mc.nextLine();
		deletetaskviewmodel.deleteTask(dtask);
	}
}
