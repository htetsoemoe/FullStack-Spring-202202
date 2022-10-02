package com.jdc.mappings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jdc.mappings.model.dto.Course;
import com.jdc.mappings.model.dto.Level;
import com.jdc.mappings.model.dto.Result;
import com.jdc.mappings.model.dto.Result.Status;
import com.jdc.mappings.model.service.CourseService;

@Controller
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseService service;
	
	@GetMapping
	public String index(ModelMap model) {
		model.put("list", service.getAll());	// model
		return "course-list";	// return logical view name
	}
	
	@GetMapping("edit")
	public String edit() {
		return "course-edit";
	}
	
	/**
	 * 
	 * @param name
	 * @param level
	 * @param duration
	 * @param fees
	 * @param redirect
	 * @return
	
	@PostMapping
	public String save(
			@RequestParam String name,
			@RequestParam Level level,
			@RequestParam int duration,
			@RequestParam int fees,
			RedirectAttributes redirect 
			) {
		System.out.println(name + "" + level.name() + "" + duration + "" + fees);
		var course = new Course(name, level, duration, fees);
		var id = service.create(course);
		redirect.addFlashAttribute("result", new Result(Status.Success, "New course has been created!"));
		return "redirect:course/%d".formatted(id);
	}
	
	 */
	
	@PostMapping
	public String save(
			@ModelAttribute Course course,
			RedirectAttributes redirect
			) {
		var id = service.save(course);
		
		if (course.getId() != id) {
			redirect.addFlashAttribute("result", new Result(Status.Success, "New course has been created!"));			
		}

		return "redirect:course/%d".formatted(id);
		
	}
	
	@GetMapping("{id:\\d+}")
	public String findById(@PathVariable int id, ModelMap model) {
		model.put("course", service.findById(id));
		return "course-details";
	}
	
	/**
	 * @ModelAttribute annotated method will call before each request handler method call
	 * 
	 */
	@ModelAttribute
	public void loadLevels(ModelMap model) {
		model.put("levels", Level.values());
	}
	
	/**
	 * @ModelAttribute annotated method will call before each request handler method call
	 */
	@ModelAttribute
	public void loadCourse(@RequestParam(required = false) Integer id, ModelMap model) {
		if (null != id) {
			model.put("course", service.findById(id));
		}
	}
	
	
	/*
	@GetMapping
	public ModelAndView index() {	
		var modelAndView = new ModelAndView();
		modelAndView.getModel().put("list", service.getAll());
		modelAndView.setViewName("course-list");	// set logical view name
		return modelAndView;
	}
	*/
	
}
