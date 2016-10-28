package com.tres.wedding.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tres.wedding.exception.AlreadyRegisteredUser;
import com.tres.wedding.facade.UserFacade;
import com.tres.wedding.web.model.UserModel;

@Controller
public class RegistrationController {

	private static final Logger LOG = Logger.getLogger(RegistrationController.class);

	@Autowired
	UserFacade facade;

	@RequestMapping(value="/registration/init", method=RequestMethod.GET)
	public String processRequest(Model registration) {

		LOG.info("Process request started..");

		registration.addAttribute("registration", new UserModel());

		LOG.info("Process request completed..");

		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	@ResponseBody
	public UserModel PostService(@RequestBody UserModel input) throws AlreadyRegisteredUser {

		LOG.info("Registration started..");

		if (checkConfirmPassword(input)) {
			facade.register(input);
			LOG.info("Registration completed..");
		} else {
			LOG.info("Registration cannot be done because the password confirmaton is wrong.");
		}

		return input;
	}

	@ExceptionHandler(AlreadyRegisteredUser.class)
	public ModelAndView handleTooManyUsersFound(HttpServletRequest request, Exception ex){

		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("exception", ex);
	    modelAndView.addObject("url", request.getRequestURL());
	    modelAndView.addObject("registration", new UserModel());

	    modelAndView.setViewName("registration");
	    return modelAndView;
	}

	private boolean checkConfirmPassword(UserModel userModel) {
		boolean retVal = false;

		if (!StringUtils.isEmpty(userModel.getPassword())) {
			retVal = userModel.getPassword().equals(userModel.getPasswordToConfirm());
		}
		return retVal;
	}
}
