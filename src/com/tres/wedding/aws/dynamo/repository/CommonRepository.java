package com.tres.wedding.aws.dynamo.repository;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.tres.wedding.spring.config.ConfigurationMgr;

public class CommonRepository<ENTITY, ID extends Serializable> extends AbstractRepository<ENTITY, ID> {

	@Autowired
	private DynamoDBMapper awsDynamoDBMapper;

	@Autowired
	private DynamoDBMapper localDynamoDBMapper;

	@Autowired
	private ConfigurationMgr mgr;

	@Override
	protected DynamoDBMapper getMapper() {
		return mgr.runningOnLocalMachine() ? localDynamoDBMapper : awsDynamoDBMapper ;
	}
}
