package com.tres.wedding.example;

import java.util.List;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.BatchGetItemOutcome;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.TableKeysAndAttributes;

public class DynamoGetBatchExample {

	private static void getBatch() {
		DynamoDB dynamoDB = new DynamoDB(new AmazonDynamoDBClient(
			    new ProfileCredentialsProvider()));

			    TableKeysAndAttributes forumTableKeysAndAttributes = new TableKeysAndAttributes("forumTableName");
			    forumTableKeysAndAttributes.addHashOnlyPrimaryKeys("Name",
			    "Amazon S3",
			    "Amazon DynamoDB");

			TableKeysAndAttributes threadTableKeysAndAttributes = new TableKeysAndAttributes("threadTableName");
			threadTableKeysAndAttributes.addHashAndRangePrimaryKeys("ForumName", "Subject",
			    "Amazon DynamoDB","DynamoDB Thread 1",
			    "Amazon DynamoDB","DynamoDB Thread 2",
			    "Amazon S3","S3 Thread 1");

			BatchGetItemOutcome outcome = dynamoDB.batchGetItem(
			    forumTableKeysAndAttributes, threadTableKeysAndAttributes);

			for (String tableName : outcome.getTableItems().keySet()) {
			    System.out.println("Items in table " + tableName);
			    List<Item> items = outcome.getTableItems().get(tableName);
			    for (Item item : items) {
			        System.out.println(item);
			    }
			}
	}

	private static void getBartchExpr() {
		DynamoDB dynamoDB = new DynamoDB(new AmazonDynamoDBClient(
			    new ProfileCredentialsProvider()));

		TableKeysAndAttributes forumTableKeysAndAttributes = new TableKeysAndAttributes("Forum")
			    .withProjectionExpression("Threads");

			forumTableKeysAndAttributes.addHashOnlyPrimaryKeys("Name",
			    "Amazon S3",
			    "Amazon DynamoDB");

			BatchGetItemOutcome outcome = dynamoDB.batchGetItem(forumTableKeysAndAttributes);
	}
}
