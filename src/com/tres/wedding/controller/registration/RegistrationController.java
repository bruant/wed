package com.tres.wedding.controller.registration;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationController {

	private static final Logger LOG = Logger.getLogger(RegistrationController.class);

	@RequestMapping("/registration")
	public String processRequest(Model registration) {

		LOG.info("Process request started..");

		LOG.info("Process request completed..");

		return "welcome";
	}


}
