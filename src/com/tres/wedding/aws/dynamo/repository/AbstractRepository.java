package com.tres.wedding.aws.dynamo.repository;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

public abstract class AbstractRepository<ENTITY, ID extends Serializable> implements DynamoRepository<ENTITY, ID>{

	protected abstract DynamoDBMapper getMapper();

	@Override
	public void save(ENTITY toSave) {
		getMapper().save(toSave);
	}

	@Override
	public ENTITY load(Class<ENTITY> clazz, ID pk) {
		return getMapper().load(clazz, pk,  DynamoDBMapperConfig.ConsistentReads.CONSISTENT);
	}

	@Override
	public void delete(ENTITY toDelete) {
		getMapper().delete(toDelete);
	}

	@Override
	public List<ENTITY> list(Class<ENTITY> clazz, Map<String, String> parameters) {

		Map<String, AttributeValue> map = new HashMap<String, AttributeValue>();
		map.put(":val1", new AttributeValue("YTDHJJK"));
		map.put(":val2", new AttributeValue("56b55411-cf65-4f50-a2be-a87f5e8db007"));

		DynamoDBQueryExpression<ENTITY> expr = new DynamoDBQueryExpression<ENTITY>()
				.withKeyConditionExpression("userId=:val2")
				.withFilterExpression("guestCode=:val1")
				.withExpressionAttributeValues(map);

		return getMapper().query(clazz, expr);
	}
}
