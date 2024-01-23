package com.muthukumarasamy.taskmanager.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.muthukumarasamy.taskmanager.dto.Task;

public class Repository {

	private static final String ALLTASK = "C:\\Users\\ramki\\git\\ConsoleProjects\\src\\com\\muthukumarasamy\\taskmanager\\files\\ALLTASK.json";
	private List<Task> tasks;
	public  static Repository repository = null;

	private Repository() {
		loadTasksFromJson();

	}

	public static Repository getInstance() {
		if (repository == null)
			repository = new Repository();
		return repository;
	}

	private void loadTasksFromJson() {
		try {
			String jsonString = new String(Files.readAllBytes(Paths.get(ALLTASK)));
			JSONArray jsonArray = new JSONArray(jsonString);

			tasks = new ArrayList<>();
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonTask = jsonArray.getJSONObject(i);
				Task task = new Task(jsonTask.getString("title"), jsonTask.getString("description"),
						jsonTask.getString("importance"), jsonTask.getString("urgency"));
				tasks.add(task);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// Handle exception (e.g., file not found, JSON parsing error)
		}
	}

	public  void saveTasksToJson() {
		JSONArray jsonArray = new JSONArray();
		for (Task task : tasks) {
			JSONObject jsonTask = new JSONObject();
			jsonTask.put("title", task.getTitle());
			jsonTask.put("description", task.getDescription());
			jsonTask.put("importance", task.getImportance());
			jsonTask.put("urgency", task.getUrgency());

			jsonArray.put(jsonTask);
		}

		try {
			Files.write(Paths.get(ALLTASK), jsonArray.toString(4).getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Task> getTask() {
		
		return tasks;
	}

}
