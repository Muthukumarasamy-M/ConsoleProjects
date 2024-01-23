package com.muthukumarasamy.taskmanager.dto;

public class Task {
	private String title;
	private String description;
	private String importance;
	private String urgency;

	public Task(String title, String description, String importance, String urgency) {
		setTitle(title);
		setDescription(description);
		setImportance(importance);
		setUrgency(urgency);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImportance() {
		return importance;
	}

	public void setImportance(String importance) {
		this.importance = importance;
	}

	public String getUrgency() {
		return urgency;
	}

	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}

}
