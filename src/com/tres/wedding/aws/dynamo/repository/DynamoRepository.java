package com.tres.wedding.aws.dynamo.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.repository.Repository;

public interface DynamoRepository<ENTITY, ID extends Serializable> extends Repository<ENTITY, ID> {

	void save(ENTITY toSave);
	ENTITY load(Class<ENTITY> clazz, ID pk);
	void delete(ENTITY toDelete);
	List<ENTITY> list(Class<ENTITY> clazz, Map<String, String> parameters);

}
