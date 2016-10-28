package com.tres.wedding.dynamo.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

/**
 * Model object to represent a user.
 * @author Peter_Trestyanszki
 */
@DynamoDBTable(tableName="user")
public class User extends Model {

	private String email;

	private String password;

	private String guestCode;

	private String name;

	private Addresses addresses;

	private Privileges privileges;

	private Attributes attributes;


	@DynamoDBHashKey
	@DynamoDBIndexHashKey(globalSecondaryIndexName = "login")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@DynamoDBIndexRangeKey(globalSecondaryIndexName = "login")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@DynamoDBIndexHashKey(globalSecondaryIndexName = "guestCode")
	public String getGuestCode() {
		return guestCode;
	}

	public void setGuestCode(String guestCode) {
		this.guestCode = guestCode;
	}

	@DynamoDBIndexHashKey(globalSecondaryIndexName = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Addresses getAddresses() {
		return addresses;
	}

	public void setAddresses(Addresses addresses) {
		this.addresses = addresses;
	}

	public Privileges getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Privileges privileges) {
		this.privileges = privileges;
	}

	public Attributes getAttributes() {
		return attributes;
	}

	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}
}
