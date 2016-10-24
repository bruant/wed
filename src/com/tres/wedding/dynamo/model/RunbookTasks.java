package com.tres.wedding.dynamo.model;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class RunbookTasks {

	private List<RunbookTask> runbookTasks;

	public void setRunbookTasks(List<RunbookTask> runbookTasks) {
		this.runbookTasks = runbookTasks;
	}

	public List<RunbookTask> getRunbookTasks() {
		return runbookTasks;
	}
}
