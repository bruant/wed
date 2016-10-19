package com.tres.wedding.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="party")
public class Party extends Model {

	private String partyId;
	private String name;
	private String desciption;
	private String city;
	private String address;
	private String date;
	private String gpsX;
	private String gpsY;
	private PartyRunbook runbook;
	private PartyUsers users;

	@DynamoDBAutoGeneratedKey
	@DynamoDBHashKey
	public String getPartyId() {
		return partyId;
	}
	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesciption() {
		return desciption;
	}
	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
	@DynamoDBRangeKey
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getGpsX() {
		return gpsX;
	}
	public void setGpsX(String gpsX) {
		this.gpsX = gpsX;
	}
	public String getGpsY() {
		return gpsY;
	}
	public void setGpsY(String gpsY) {
		this.gpsY = gpsY;
	}
	public PartyRunbook getRunbook() {
		return runbook;
	}
	public void setRunbook(PartyRunbook runbook) {
		this.runbook = runbook;
	}
	public PartyUsers getUsers() {
		return users;
	}
	public void setUsers(PartyUsers users) {
		this.users = users;
	}
}