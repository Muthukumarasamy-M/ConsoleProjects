package com.muthukumarasamy.taskmanager.displaytask;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.muthukumarasamy.taskmanager.dto.Task;
import com.muthukumarasamy.taskmanager.repository.Repository;

public class DisplayTaskviewmodel {

	public List<Task> getTask() {
		List<Task> tasks = Repository.getInstance().getTask();
		sortTasksByImportanceAndUrgency(tasks);
		return tasks;
	}

	public void sortTasksByImportanceAndUrgency(List<Task> tasks) {
		Collections.sort(tasks, Comparator.comparing(Task::getImportance, (s1, s2) -> compareImportance(s2, s1))
				.thenComparing(Task::getUrgency, (s1, s2) -> compareUrgency(s2, s1)));
	}

	private static int compareImportance(String importance1, String importance2) {
		return getImportanceValue(importance1) - getImportanceValue(importance2);
	}

	private static int compareUrgency(String urgency1, String urgency2) {
		return getUrgencyValue(urgency1) - getUrgencyValue(urgency2);
	}

	private static int getImportanceValue(String importance) {
		switch (importance.toLowerCase()) {
		case "high":
			return 3;
		case "medium":
			return 2;
		case "low":
			return 1;
		default:
			return 0;
		}
	}

	private static int getUrgencyValue(String urgency) {

		switch (urgency.toLowerCase()) {
		case "high":
			return 3;
		case "medium":
			return 2;
		case "low":
			return 1;
		default:
			return 0;
		}
	}
}
