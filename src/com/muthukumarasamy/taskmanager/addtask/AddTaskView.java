package com.muthukumarasamy.taskmanager.addtask;

import java.util.Scanner;

import com.muthukumarasamy.taskmanager.dto.Task;

public class AddTaskView {
	private AddTaskViewModel addtaskviewmodel;

	public AddTaskView() {
		this.addtaskviewmodel = new AddTaskViewModel();
	}

	public void addTask() {
		Scanner mc = new Scanner(System.in);
		System.out.println("------------------------------------------\n");
		System.out.println("Enter the title : ");
		String title = mc.nextLine();
		System.out.println("Enter the description :  ");
		String description = mc.nextLine();
		System.out.println("Enter the importance[low,mid,high]");
		String importance = mc.nextLine();
		System.out.println("Enter the urgency [low,mid,high]");
		String urgency = mc.nextLine();
		addtaskviewmodel.addTask(new Task(title,description,importance, urgency));

	}
}
