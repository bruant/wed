package com.tres.wedding.facade;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.tres.wedding.aws.dynamo.repository.DynamoRepository;
import com.tres.wedding.dynamo.model.User;
import com.tres.wedding.exception.TooManyUsersFound;
import com.tres.wedding.web.model.UserModel;

@Component
public class UserFacadeImpl implements UserFacade {

	private static final Logger LOG = Logger.getLogger(UserFacadeImpl.class);

	@Autowired
	DynamoRepository<User, String> repo;

	@Override
	public UserModel login(String email, String password) throws TooManyUsersFound {

		UserModel userModel = null;

		Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
        eav.put(":v_email", new AttributeValue().withS(email));
        eav.put(":v_password", new AttributeValue().withS(password));

		DynamoDBQueryExpression<User> query = new DynamoDBQueryExpression<User>()
				.withIndexName("login")
			    .withKeyConditionExpression("email = :v_email and password = :v_password")
			    .withExpressionAttributeValues(eav)
			    .withConsistentRead(false);

		PaginatedQueryList<User> users = repo.query(User.class, query);

		if (users.isEmpty()) {
			LOG.warn("No user found at login!");
		} else if (users.size() > 1) {
			throw new TooManyUsersFound();
		} else {
			userModel = new UserModel();
			User user = users.get(0);
			userModel.setName(user.getName());
		}

		return userModel;
	}
}
