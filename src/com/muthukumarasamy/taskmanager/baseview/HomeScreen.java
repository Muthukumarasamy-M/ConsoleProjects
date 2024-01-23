package com.muthukumarasamy.taskmanager.baseview;

import java.util.Scanner;

import com.muthukumarasamy.taskmanager.addtask.AddTaskView;
import com.muthukumarasamy.taskmanager.deletetask.DeleteTaskView;
import com.muthukumarasamy.taskmanager.displaytask.DisplayTaskview;

public class HomeScreen {

	public void start() {
		Scanner mc = new Scanner(System.in);

		int select = 0;
		do {
			methodView();
			select = mc.nextInt();
			mc.nextLine();
			switch (select) {
			case 1:
				AddTaskView add = new AddTaskView();
				add.addTask();
				break;
			case 2:
				DisplayTaskview display = new DisplayTaskview();
				display.peekTask();
				break;
			case 3:
				DisplayTaskview displays = new DisplayTaskview();
				displays.displayTasks();
				break;
			case 4:
				DeleteTaskView delete = new DeleteTaskView();
				delete.deleteTask();
				break;
			}
			if (select != 5) {
				Continue();
				mc.nextLine();
			}
		} while (select != 5);
		Exit();
	}

	public void Continue() {
		System.out.println("------------------------------");
		System.out.println("press enter to continue");

	}

	public void Exit() {
		System.out.println("EXITED !!! ");
	}

	private void methodView() {
		System.out.println("\t+-------------------------+");
		System.out.println("\t|   1.  ADD TASK          |");
		System.out.println("\t|   2.  PEEK TASK         |");
		System.out.println("\t|   3.  DISPLAY TASK      |");
		System.out.println("\t|   4.  DELETE TASK       |");
		System.out.println("\t|   5.  EXIT              |");
		System.out.println("\t+-------------------------+");
		System.out.print("Enter the operation :");

	}

}
