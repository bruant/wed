package com.tres.wedding.aws.dynamo.repository;

import java.io.Serializable;

import org.springframework.data.repository.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;

public interface DynamoRepository<ENTITY, ID extends Serializable> extends Repository<ENTITY, ID> {

	void save(ENTITY toSave);
	ENTITY load(Class<ENTITY> clazz, ID pk);
	void delete(ENTITY toDelete);
	PaginatedQueryList<ENTITY> query(Class<ENTITY> clazz, DynamoDBQueryExpression<ENTITY> expression);
	PaginatedScanList<ENTITY> scan(Class<ENTITY> clazz, DynamoDBScanExpression expression);

}
