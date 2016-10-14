package com.tres.wedding.aws.dynamo;

import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazonaws.services.dynamodbv2.model.GetItemResult;
import com.tres.wedding.spring.config.ConfigurationMgr;

public class Dynamo implements IDynamo {

	@Autowired
	private ConfigurationMgr mgr;

	private void testDynamo() {

		AmazonDynamoDBClient client = new AmazonDynamoDBClient();

		if (mgr.runningOnLocalMachine()) {
			client.withEndpoint(mgr.getEndpoint());
		}
		GetItemRequest req = new GetItemRequest();
		req.setTableName("");
		GetItemResult items = client.getItem(req);
	}

}
