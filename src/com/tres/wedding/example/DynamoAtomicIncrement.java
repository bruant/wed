package com.tres.wedding.example;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.UpdateItemOutcome;

public class DynamoAtomicIncrement {

	public static void main(String[] args) {

	}

	private static void increment() {

		DynamoDB dynamoDB = new DynamoDB(new AmazonDynamoDBClient(
				new ProfileCredentialsProvider()));

		Table table = dynamoDB.getTable("ProductCatalog");

		Map<String,String> expressionAttributeNames = new HashMap<String,String>();
		expressionAttributeNames.put("#p", "PageCount");

		Map<String,Object> expressionAttributeValues = new HashMap<String,Object>();
		expressionAttributeValues.put(":val", 1);

		UpdateItemOutcome outcome = table.updateItem(
		    "Id", 121,
		    "set #p = #p + :val",
		    expressionAttributeNames,
		    expressionAttributeValues);
	}
}
