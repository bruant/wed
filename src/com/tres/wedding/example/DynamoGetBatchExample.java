package com.tres.wedding.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;
import com.amazonaws.services.dynamodbv2.document.BatchGetItemOutcome;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.TableKeysAndAttributes;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.tres.wedding.dynamo.model.User;

public class DynamoGetBatchExample {

	 public static void main(String[] args) {

			AmazonDynamoDBClient client = new AmazonDynamoDBClient(new ProfileCredentialsProvider());
			client.withEndpoint("http://localhost:8000");

			DynamoDBMapper mapper = new DynamoDBMapper(client);

			Map<String, AttributeValue> map = new HashMap<String, AttributeValue>();
			map.put(":val1", new AttributeValue("YTDHJJK"));

			DynamoDBScanExpression expr = new DynamoDBScanExpression().withFilterExpression("guestCode=:val1").withExpressionAttributeValues(map);

			PaginatedScanList<User> users = mapper.scan(User.class, expr);
			if (users != null) {
				for (User user : users) {
					System.out.println("User: " + user.getUserId());
				}
			} else {
				System.out.println("User list is null");
			}
	}


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
