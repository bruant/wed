package com.tres.wedding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StartController {

	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String test(Model model) {
		System.out.println("S T A R T");
		return "success";
	}
}
