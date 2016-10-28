package com.tres.wedding.facade;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazonaws.services.dynamodbv2.transactions.Transaction;
import com.amazonaws.services.dynamodbv2.transactions.TransactionManager;
import com.tres.wedding.aws.dynamo.repository.DynamoRepository;
import com.tres.wedding.dynamo.model.User;
import com.tres.wedding.exception.AlreadyRegisteredUser;
import com.tres.wedding.exception.TooManyUsersFound;
import com.tres.wedding.web.model.UserModel;

@Component
public class UserFacadeImpl implements UserFacade {

	private static final Logger LOG = Logger.getLogger(UserFacadeImpl.class);

	@Autowired
	private DynamoRepository<User, String> repo;

	@Autowired
	private AmazonDynamoDBClient localClient;

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
			userModel.setEmail(user.getEmail());
		}

		return userModel;
	}

	@Override
	public void register(UserModel model) throws AlreadyRegisteredUser {

		User toSave = new User();
		toSave.setEmail(model.getEmail());
		toSave.setName(model.getName());
		toSave.setPassword(model.getPassword());

		boolean alreadyRegistered = false;
		try {
			TransactionManager.verifyOrCreateTransactionTable(localClient, "Transactions", 1, 1, null);
	        TransactionManager.verifyOrCreateTransactionImagesTable(localClient, "TransactionImages", 1, 1, null);
			TransactionManager txManager = new TransactionManager(localClient, "Transactions", "TransactionImages");

			Transaction t1 = txManager.newTransaction();

			User user = new User();
			user.setEmail(model.getEmail());

	        User loadedUser = t1.load(user);

	        if (loadedUser == null) {
				Map<String, AttributeValue> item1 = new HashMap<String, AttributeValue>();
		        item1.put("email", new AttributeValue(model.getEmail()));
		        item1.put("password", new AttributeValue(model.getPassword()));
		        item1.put("name", new AttributeValue(model.getName()));

		        t1.putItem(new PutItemRequest()
		            .withTableName("user")
		            .withItem(item1));
	        } else {
	        	alreadyRegistered = true;
	        }

	        t1.commit();
	        t1.delete();

		} catch (InterruptedException e) {
			LOG.error("Registration cannot be done!");
		}

		if (alreadyRegistered) {
			throw new AlreadyRegisteredUser();
		}

	}
}
