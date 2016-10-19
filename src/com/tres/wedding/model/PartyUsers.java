package com.tres.wedding.model;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class PartyUsers {

	private List<PartyUser> partyUsers;

	public List<PartyUser> getPartyUsers() {
		return partyUsers;
	}
	public void setPartyUsers(List<PartyUser> partyUsers) {
		this.partyUsers = partyUsers;
	}
}
