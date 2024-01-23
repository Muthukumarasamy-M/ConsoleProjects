package com.muthukumarasamy.taskmanager.deletetask;

import java.util.List;

import com.muthukumarasamy.taskmanager.dto.Task;
import com.muthukumarasamy.taskmanager.repository.Repository;

public class DeleteTaskViewModel {

	public void deleteTask(String dtask) {
		List<Task> tasks = Repository.getInstance().getTask();
		for (int i = 0; i < tasks.size(); i++) {
			Task task = tasks.get(i);

			if (task.getTitle().contains(dtask)) {
				tasks.remove(i); // Remove the task
				System.out.println("Task with title '" + dtask + "' deleted successfully.");
				return;
			}
		}
		Repository.getInstance().saveTasksToJson();
	}

}
