package com.tres.wedding.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class PartyUser {

	private String partyUserId;
	private String partyUserName;
	private String role;

	public String getPartyUserId() {
		return partyUserId;
	}

	public void setPartyUserId(String partyUserId) {
		this.partyUserId = partyUserId;
	}

	public String getPartyUserName() {
		return partyUserName;
	}

	public void setPartyUserName(String partyUserName) {
		this.partyUserName = partyUserName;
	}

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
