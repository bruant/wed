package com.tres.wedding.controller.login;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tres.wedding.exception.TooManyUsersFound;
import com.tres.wedding.facade.UserFacade;
import com.tres.wedding.web.model.LoginModel;

@Controller
public class LoginController {

	private static final Logger LOG = Logger.getLogger(LoginController.class);

	@Autowired
	UserFacade facade;

	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String processRequest(LoginModel input, ModelMap output) {

		LOG.info("Login..");
		LOG.info(input.toLog());

		try {
			facade.login(input.getEmail(), input.getPassword());
		} catch (TooManyUsersFound e) {
			LOG.error("More user assigned to the email address!");
		}


		return "myAccount";
	}


}
