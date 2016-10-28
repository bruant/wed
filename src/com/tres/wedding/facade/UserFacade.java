package com.tres.wedding.facade;

import com.tres.wedding.exception.AlreadyRegisteredUser;
import com.tres.wedding.exception.TooManyUsersFound;
import com.tres.wedding.web.model.UserModel;

public interface UserFacade {

	UserModel login(String email, String password) throws TooManyUsersFound;

	void register(UserModel toSave) throws AlreadyRegisteredUser;


}
