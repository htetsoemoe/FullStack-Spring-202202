package com.jdc.mappings.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	
	@RequestMapping(
			value = {"/", "/home", "/hello"})
	public String index() {
		return "home";
	}

}
