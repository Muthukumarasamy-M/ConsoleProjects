package com.muthukumarasamy.taskmanager.displaytask;

import java.util.List;

import com.muthukumarasamy.taskmanager.dto.Task;

public class DisplayTaskview {

	private DisplayTaskviewmodel displaytaskviewmodel;

	public DisplayTaskview() {
		displaytaskviewmodel = new DisplayTaskviewmodel();
	}

	public void displayTasks() {
		List<Task> tasks = displaytaskviewmodel.getTask();

		for (Task task : tasks) {
			System.out.println("+---------------------------------------------------------------------------+");
			System.out.printf("| %-20s | %-50s |\n", "Task Title", task.getTitle());
			System.out.printf("| %-20s | %-50s |\n", "Description", truncateDescription(task.getDescription(), 50));
			System.out.printf("| %-20s | %-50s |\n", "Importance", task.getImportance());
			System.out.printf("| %-20s | %-50s |\n", "Urgency", task.getUrgency());
			System.out.println("+---------------------------------------------------------------------------+");
		}
	}

	private String truncateDescription(String description, int maxLength) {
		if (description.length() <= maxLength) {
			return description;
		} else {
			return description.substring(0, maxLength - 3) + "...";
		}
	}

	public void peekTask() {
		List<Task> tasks = displaytaskviewmodel.getTask();
		if (!tasks.isEmpty()) {
		    Task task = tasks.get(0);
		    
		    System.out.println("+---------------------------------------------------------------------------+");
		    System.out.println("| Topic:        ");
		    System.out.println("|   " + task.getTitle());
		    System.out.println("| Description:  ");
		    System.out.println("|   " + task.getDescription());
		    System.out.println("+---------------------------------------------------------------------------+");
		}
	}
}
