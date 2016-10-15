package com.tres.wedding.example;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;

public class DynamoGetExample {

	public static void main(String[] args) {

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
