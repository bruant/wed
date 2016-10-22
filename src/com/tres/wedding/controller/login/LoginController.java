package com.tres.wedding.controller.login;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tres.wedding.web.model.LoginModel;

@Controller
public class LoginController {

	private static final Logger LOG = Logger.getLogger(LoginController.class);

	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String processRequest(LoginModel input, ModelMap output) {

		LOG.info("Process request started..");
		LOG.info(input.getUserName());

		LOG.info("Process request completed..");

		return "myAccount";
	}


}
