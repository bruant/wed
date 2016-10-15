package com.tres.wedding.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.PrimaryKey;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.UpdateItemOutcome;

public class DynamoUpdateExample {

	public static void main(String[] args) {

	}

	private static void update() {
		DynamoDB dynamoDB = new DynamoDB(new AmazonDynamoDBClient(
				new ProfileCredentialsProvider()));

	Table table = dynamoDB.getTable("ProductCatalog");

	Map<String, String> expressionAttributeNames = new HashMap<String, String>();
	expressionAttributeNames.put("#A", "Authors");
	expressionAttributeNames.put("#P", "Price");
	expressionAttributeNames.put("#I", "ISBN");

	Map<String, Object> expressionAttributeValues = new HashMap<String, Object>();
	expressionAttributeValues.put(":val1",
	    new HashSet<String>(Arrays.asList("Author YY","Author ZZ")));
	expressionAttributeValues.put(":val2", 1);   //Price

	UpdateItemOutcome outcome =  table.updateItem(
	    "Id",          // key attribute name
	    101,           // key attribute value
	    "add #A :val1 set #P = #P - :val2 remove #I", // UpdateExpression
	    expressionAttributeNames,
	    expressionAttributeValues);
	}

	private static void updateExpr() {

		DynamoDB dynamoDB = new DynamoDB(new AmazonDynamoDBClient(
				new ProfileCredentialsProvider()));

		Table table = dynamoDB.getTable("ProductCatalog");

		Map<String, String> expressionAttributeNames = new HashMap<String, String>();
		expressionAttributeNames.put("#P", "Price");

		Map<String, Object> expressionAttributeValues = new HashMap<String, Object>();
		expressionAttributeValues.put(":val1", 25);  // update Price to 25...
		expressionAttributeValues.put(":val2", 20);  //...but only if existing Price is 20

		UpdateItemOutcome outcome = table.updateItem(
		    new PrimaryKey("Id",101),
		    "set #P = :val1", // UpdateExpression
		    "#P = :val2",     // ConditionExpression
		    expressionAttributeNames,
		    expressionAttributeValues);
	}
}
