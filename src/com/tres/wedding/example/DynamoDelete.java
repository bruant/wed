package com.tres.wedding.example;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DeleteItemOutcome;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;

public class DynamoDelete {

	private static void delete() {
		DynamoDB dynamoDB = new DynamoDB(new AmazonDynamoDBClient(
				new ProfileCredentialsProvider()));

	Table table = dynamoDB.getTable("ProductCatalog");

	DeleteItemOutcome outcome = table.deleteItem("Id", 101);
	}


	private static void deleteExpression() {

		DynamoDB dynamoDB = new DynamoDB(new AmazonDynamoDBClient(
				new ProfileCredentialsProvider()));

	Table table = dynamoDB.getTable("ProductCatalog");

		Map<String,Object> expressionAttributeValues = new HashMap<String,Object>();
		expressionAttributeValues.put(":val", false);

		DeleteItemOutcome outcome = table.deleteItem("Id",103,
		    "InPublication = :val",
		    null, // ExpressionAttributeNames - not used in this example
		    expressionAttributeValues);
	}
}
