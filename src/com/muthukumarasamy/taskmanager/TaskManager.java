package com.muthukumarasamy.taskmanager;

import java.util.Scanner;

import com.muthukumarasamy.taskmanager.addtask.AddTaskView;
import com.muthukumarasamy.taskmanager.baseview.HomeScreen;
import com.muthukumarasamy.taskmanager.deletetask.DeleteTaskView;
import com.muthukumarasamy.taskmanager.displaytask.DisplayTaskview;

public class TaskManager {

	public static void main(String[] args) {

		HomeScreen home = new HomeScreen();
		home.start();
	}

}
