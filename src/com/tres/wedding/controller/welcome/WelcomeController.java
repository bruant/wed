package com.tres.wedding.controller.welcome;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tres.wedding.web.model.LoginModel;

@Controller
public class WelcomeController {

	private static final Logger LOG = Logger.getLogger(WelcomeController.class);

	@RequestMapping("/")
	public String processRequest(Model model) {

		LOG.info("Process request started..");

		model.addAttribute("login", new LoginModel());

		LOG.info("Process request completed..");

		return "welcome";
	}

}
