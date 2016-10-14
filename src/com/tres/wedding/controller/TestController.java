package com.tres.wedding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/wedding")
public class TestController {

	@RequestMapping("/test")
	public String test(Model model) {
		System.out.println("Wedding");
		return "success";
	}
}
