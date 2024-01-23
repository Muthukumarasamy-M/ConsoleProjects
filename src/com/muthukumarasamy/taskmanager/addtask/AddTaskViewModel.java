package com.muthukumarasamy.taskmanager.addtask;

import java.util.List;

import com.muthukumarasamy.taskmanager.dto.Task;
import com.muthukumarasamy.taskmanager.repository.Repository;

class AddTaskViewModel {

	public void addTask(Task task) {
		List<Task> tasks = Repository.getInstance().getTask();
		tasks.add(task);
		Repository.getInstance().saveTasksToJson();
	}

}
