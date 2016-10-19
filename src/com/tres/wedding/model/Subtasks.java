package com.tres.wedding.model;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class Subtasks {

	private List<Subtask> subTasks;

	public List<Subtask> getSubTasks() {
		return subTasks;
	}

	public void setSubTasks(List<Subtask> subTasks) {
		this.subTasks = subTasks;
	}


}
