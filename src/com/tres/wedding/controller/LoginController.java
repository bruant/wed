package com.tres.wedding.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tres.wedding.exception.TooManyUsersFound;
import com.tres.wedding.facade.UserFacade;
import com.tres.wedding.web.model.UserModel;

@Controller
public class LoginController {

	private static final Logger LOG = Logger.getLogger(LoginController.class);

	@Autowired
	UserFacade facade;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public UserModel PostService(@RequestBody UserModel input) throws TooManyUsersFound {

		LOG.info("Login..");
		LOG.info(input.toLog());

		UserModel userModel = null;

		try {
			userModel = facade.login(input.getEmail(), input.getPassword());

		} catch (TooManyUsersFound e) {
			LOG.error("More user assigned to the email address!");
			throw e;
		}

		return userModel;
	}

	@ExceptionHandler(TooManyUsersFound.class)
	public ModelAndView handleTooManyUsersFound(HttpServletRequest request, Exception ex){

		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("exception", ex);
	    modelAndView.addObject("url", request.getRequestURL());

	    modelAndView.setViewName("error");
	    return modelAndView;
	}

}
