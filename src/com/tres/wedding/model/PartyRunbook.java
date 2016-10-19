package com.tres.wedding.model;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class PartyRunbook {

	private List<PartyRunBookEntry> runbookEntries;

	public List<PartyRunBookEntry> getRunbookEntries() {
		return runbookEntries;
	}

	public void setRunbookEntries(List<PartyRunBookEntry> runbookEntries) {
		this.runbookEntries = runbookEntries;
	}
}
