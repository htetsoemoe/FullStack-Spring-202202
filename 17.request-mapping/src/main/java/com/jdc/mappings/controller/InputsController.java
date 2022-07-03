package com.jdc.mappings.controller;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.mappings.model.dto.Level;

@Controller
@RequestMapping("inputs")
public class InputsController {
	
	@GetMapping
	public void index() {		// if get request to this controller, return inputs.jsp
		
	}
	
	// inputs/{type}/search/{id}
	@GetMapping("{type}/search/{id:\\d+}")
	public String findByType(
			@PathVariable String type,
			@PathVariable Integer id,
			Model model) {
		
		model.addAttribute("type", type);
		model.addAttribute("id", id);
		
		return "inputs";
		
	}
	
	// inputs/{date}
	//@GetMapping("{date}")
	@GetMapping("{date:\\d{4}\\-\\d{2}\\-\\d{2}}")
	public String dateInput(
			@PathVariable 	// get String path variable
			@DateTimeFormat(pattern = "yyyy-MM-dd")	// converts String to DateTime
			LocalDate date,
			Model model) {
		
		model.addAttribute("date", date);	
		return "inputs";
	}
	
	// inputs/enum/{level}
	//@GetMapping("enum/{level}")
	@GetMapping("{level:Basic|Intermediate|Advance}")
	public String useEnum(@PathVariable Level level, Model model) {
		model.addAttribute("level", level);
		return "inputs";
	}
	
	@GetMapping("matrix/{product}")
	public String useMatrix(
			@PathVariable String product,
			@MatrixVariable String size,
			@MatrixVariable int count,
			Model model
			) {
		var message = "Product: %s, Size: %s, Count: %d".formatted(product, size, count);
		model.addAttribute("date", message);
		
		return "inputs";
	}
	

	@GetMapping("request")
	public String useRequest(
			Model model,
			@RequestParam("p") String product,
			@RequestParam(name="w", required = false, defaultValue = "28") int width,
			@RequestParam(name = "l", required = false, defaultValue = "30") int lenght
			) {
		var message = "Product: %s, Width: %d, Length: %d".formatted(product, width, lenght);
		model.addAttribute("date", message);
		
		return "inputs";
	}
	

	
}
