package com.muthukumarasamy.taskmanager;

import java.util.Scanner;

import com.muthukumarasamy.taskmanager.addtask.AddTaskView;
import com.muthukumarasamy.taskmanager.deletetask.DeleteTaskView;
import com.muthukumarasamy.taskmanager.displaytask.DisplayTaskview;

public class TaskManager {

	public static void main(String[] args) {
		TaskManager t = new TaskManager();
		t.init();
	}

	private void init() {
		Scanner mc = new Scanner(System.in);
		DisplayTaskview displaytaskview = new DisplayTaskview();
		int select = 0;
		do {
			menu();
			System.out.println("Enter the option : ");
			select = mc.nextInt();
			mc.nextLine();
			switch (select) {
			case 1:
				AddTaskView addtaskview = new AddTaskView();
				addtaskview.addTask();
				break;
			case 2:
				displaytaskview.displayTasks();
				break;
			case 3:
				DeleteTaskView deletetaskview = new DeleteTaskView();
				deletetaskview.deleteTask();
				break;
			case 4:
				displaytaskview.peekTask();
			}
			if (select != 5) {
				Continue();
				mc.nextLine();
			}
		} while (select != 5);
		System.out.println("!!! Exited !!!");
	}

	private void Continue() {
		System.out.println("+------------------------------------");
		System.out.println("press enter to continue");

	}

	private void menu() {
		System.out.println(" \t ^-^ TASK MANAGER ^-^  ");
		System.out.println("\t+---+------------------+");
		System.out.printf("\t| %-2s| %-17s|\n", "1", "Add Task");
		System.out.printf("\t| %-2s| %-17s|\n", "2", "Display Task");
		System.out.printf("\t| %-2s| %-17s|\n", "3", "Delete Task");
		System.out.printf("\t| %-2s| %-17s|\n", "4", "Peek Task");
		System.out.printf("\t| %-2s| %-17s|\n", "5", "Exit");
		System.out.println("\t+---+------------------+");

	}

}
