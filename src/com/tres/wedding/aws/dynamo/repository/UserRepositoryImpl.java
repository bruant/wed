package com.tres.wedding.aws.dynamo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tres.wedding.dynamo.model.User;
import com.tres.wedding.encryption.AES;

@Component
public class UserRepositoryImpl extends CommonRepository<User, String>{

	private String secretKey = "test"; // TODO move to file

	@Autowired
	private AES aes;

	@Override
	public void save(User toSave) {
		encryptSensitiveData(toSave);
		getMapper().save(toSave);
	}

	private void encryptSensitiveData(User user) {
		user.setPassword(aes.encrypt(user.getPassword(), secretKey));
	}
}
