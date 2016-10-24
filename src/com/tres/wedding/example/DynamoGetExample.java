package com.tres.wedding.example;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.tres.wedding.dynamo.model.User;

public class DynamoGetExample {

	public static void main(String[] args) {

		AmazonDynamoDBClient client = new AmazonDynamoDBClient(new ProfileCredentialsProvider());
		client.withEndpoint("http://localhost:8000");

		DynamoDBMapper mapper = new DynamoDBMapper(client);

		Map<String, AttributeValue> map = new HashMap<String, AttributeValue>();
		map.put(":val1", new AttributeValue("YTDHJJK"));
		map.put(":val2", new AttributeValue("56b55411-cf65-4f50-a2be-a87f5e8db007"));

		DynamoDBQueryExpression<User> expr = new DynamoDBQueryExpression<User>()
				.withKeyConditionExpression("userId=:val2")
				.withFilterExpression("guestCode=:val1")
				.withExpressionAttributeValues(map);


		PaginatedQueryList<User> users = mapper.query(User.class, expr);
		if (users != null) {
			for (User user : users) {
				System.out.println("User: " + user.getName());
			}
		} else {
			System.out.println("User list is null");
		}
	}

	private static void get() {
		DynamoDB dynamoDB = new DynamoDB(new AmazonDynamoDBClient(
			    new ProfileCredentialsProvider()));

			Table table = dynamoDB.getTable("ProductCatalog");

			Item item = table.getItem("Id", 101);
	}

	private static void getProjection() {

		DynamoDB dynamoDB = new DynamoDB(new AmazonDynamoDBClient(
			    new ProfileCredentialsProvider()));

		Table table = dynamoDB.getTable("ProductCatalog");

		GetItemSpec spec = new GetItemSpec()
			    .withPrimaryKey("Id", 206)
			    .withProjectionExpression("Id, Title, RelatedItems[0], Reviews.FiveStar")
			    .withConsistentRead(true);

			Item item = table.getItem(spec);

			System.out.println(item.toJSONPretty());
	}

	private static void getWithJsonFormat() {

		DynamoDB dynamoDB = new DynamoDB(new AmazonDynamoDBClient(
			    new ProfileCredentialsProvider()));

		Table table = dynamoDB.getTable("ProductCatalog");

		GetItemSpec spec = new GetItemSpec()
			    .withPrimaryKey("Id", 210);

			System.out.println("All vendor info:");
			spec.withProjectionExpression("VendorInfo");
			System.out.println(table.getItem(spec).toJSON());

			System.out.println("A single vendor:");
			spec.withProjectionExpression("VendorInfo.V03");
			System.out.println(table.getItem(spec).toJSON());

			System.out.println("First office location for this vendor:");
			spec.withProjectionExpression("VendorInfo.V03.Offices[0]");
			System.out.println(table.getItem(spec).toJSON());
	}
}
