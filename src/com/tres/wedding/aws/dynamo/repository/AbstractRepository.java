package com.tres.wedding.aws.dynamo.repository;

import java.io.Serializable;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;

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
	public PaginatedQueryList<ENTITY> query(Class<ENTITY> clazz, DynamoDBQueryExpression<ENTITY> expression) {
		return getMapper().query(clazz, expression);
	}

	@Override
	public PaginatedScanList<ENTITY> scan(Class<ENTITY> clazz, DynamoDBScanExpression expression) {
		return getMapper().scan(clazz, expression);
	}

}
