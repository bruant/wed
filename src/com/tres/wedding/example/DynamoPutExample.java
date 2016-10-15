package com.tres.wedding.example;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.BatchWriteItemOutcome;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.TableWriteItems;

public class DynamoPutExample {

	public static void main(String[] args) {

	}

	private static void put() {
		DynamoDB dynamoDB = new DynamoDB(new AmazonDynamoDBClient(
			    new ProfileCredentialsProvider()));

			Table table = dynamoDB.getTable("Sequence");
			Item item = new Item()
				    .withPrimaryKey("Id", 206)
				    .withString("Title", "20-Bicycle 206")
				    .withString("Description", "206 description")
				    .withString("BicycleType", "Hybrid")
				    .withString("Brand", "Brand-Company C")
				    .withNumber("Price", 500)
//				    .withStringSet("Color",  new HashSet()<String>(Arrays.asList("Red", "Black")))
				    .withString("ProductCategory", "Bike")
				    .withBoolean("InStock", true)
				    .withNull("QuantityOnHand");
	//			    .withList("RelatedItems", relatedItems)
		//		    .withMap("Pictures", pictures)
	//			    .withMap("Reviews", reviews);

				// Write the item to the table
				PutItemOutcome outcome = table.putItem(item);
	}


/*	private static void putBatch() {
		DynamoDB dynamoDB = new DynamoDB(new AmazonDynamoDBClient(
			    new ProfileCredentialsProvider()));

			TableWriteItems forumTableWriteItems = new TableWriteItems("Forum")
			    .withItemsToPut(
			        new Item()
			            .withPrimaryKey("Name", "Amazon RDS")
			            .withNumber("Threads", 0));

			TableWriteItems threadTableWriteItems = new TableWriteItems("")
			    .withItemsToPut(
			        new Item()
			            .withPrimaryKey("ForumName","Amazon RDS","Subject","Amazon RDS Thread 1")
			    .withHashAndRangeKeysToDelete("ForumName","Some partition key value", "Amazon S3", "Some sort key value");

			BatchWriteItemOutcome outcome = dynamoDB.batchWriteItem(forumTableWriteItems, threadTableWriteItems);

			// Code for checking unprocessed items is omitted in this example
	}
*/
}
