package com.jdc.mappings.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/multi")
public class MultiController {

	/**
	 * multi
	 */
	@RequestMapping
	public void index() {
		
	}
	
	/**
	 * multi/action1
	 */
	//@RequestMapping("action1")
	@GetMapping(value = "action1")
	 public String action1(ModelMap model) {
		model.addAttribute("message", "Multi Action 1");
		return "multi";
	}
	
	/**
	 * multi/action1?id=1122
	 */
	@GetMapping(value = "action1", params = "id")
	 public String action1WithParameter(ModelMap model) {
		model.addAttribute("message", "Multi Action 1 with Parameter");
		return "multi";
	}
	
	
	/**
	 * multi/action2
	 */
	@RequestMapping("action2")
	public String action2(ModelMap model) {
		model.addAttribute("message", "Multi Action2");
		return "multi";
	}
	
	/**
	 * multi/**
	 */
	@RequestMapping("**")
	public String actionWildCard(ModelMap model) {
		model.addAttribute("message", "Wild Card");
		return "multi";
	}
	
	/**
	 * multi/112
	 */
	@RequestMapping("{:\\d+}")
	public String actionDigit(ModelMap model) {
		model.addAttribute("message", "Digit");
		return "multi";
	}
}
