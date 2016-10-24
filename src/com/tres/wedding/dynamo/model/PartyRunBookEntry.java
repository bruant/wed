package com.tres.wedding.dynamo.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class PartyRunBookEntry {

	private String runBookEntryId;
	private String shortDescription;
	private Integer order;

	public String getRunBookEntryId() {
		return runBookEntryId;
	}
	public void setRunBookEntryId(String runBookEntryId) {
		this.runBookEntryId = runBookEntryId;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
}
