package com.jdc.assignment.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdc.assignment.domain.OpenClass;
import com.jdc.assignment.model.CourseModel;
import com.jdc.assignment.model.OpenClassModel;

@WebServlet(urlPatterns = { "/classes", "/class-edit" })
public class OpenClassServlet extends AbstractBeanFactoryServlet {

	private static final long serialVersionUID = 1L;

	public OpenClassModel model;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var courseId = req.getParameter("courseId");
		
		// Find Course
		var courseModel = getBean("courseModel", CourseModel.class);// get CourseModel bean from IoC container
		var course = courseModel.findById(Integer.parseInt(courseId));
		
		//System.out.println(course.toString());
		
		req.setAttribute("course", course);
		
		// Page Navigation
		var page = switch (req.getServletPath()) {
		case "/classes" -> {
			var model = getBean("openClassModel", OpenClassModel.class);// get OpenClassModel bean from IoC container
			req.setAttribute("classes", model.findByCourse(Integer.parseInt(courseId)));
			yield "classes";
		}
		default -> "class-edit";
		};
		
		getServletContext().getRequestDispatcher("/%s.jsp".formatted(page)).forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		var courseId = req.getParameter("courseId");
		
		var startDate = req.getParameter("startDate");//
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(startDate, formatter);
		
		
		var teacherName = req.getParameter("teacherName");
		
		// find course
		var courseModel = getBean("courseModel", CourseModel.class);
		var course = courseModel.findById(Integer.parseInt(courseId));
		
		// create OpenClass object
		var openClass = new OpenClass();
		openClass.setCourse(course);
		openClass.setStartDate(localDate);
		openClass.setTeacher(teacherName);
		
		// save to db
		getBean("openClassModel", OpenClassModel.class).createClass(openClass);
		
		// redirect to classes.jsp
		resp.sendRedirect("/classes?courseId=" + courseId);//
	}

}
