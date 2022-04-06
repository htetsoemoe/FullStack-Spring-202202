package com.jdc.assignment.controller;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdc.assignment.domain.OpenClass;
import com.jdc.assignment.domain.Registration;
import com.jdc.assignment.model.CourseModel;
import com.jdc.assignment.model.OpenClassModel;
import com.jdc.assignment.model.RegistrationModel;

@WebServlet(urlPatterns = { "/registrations", "/registration-edit" })
public class RegistrationServlet extends AbstractBeanFactoryServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var courseId = req.getParameter("courseId");

		var courseModel = getBean("courseModel", CourseModel.class);
		var course = courseModel.findById(Integer.parseInt(courseId));
		req.setAttribute("course", course);
		
		var openClassModel = getBean("openClassModel", OpenClassModel.class);
		var openClass = openClassModel.findByCourse(Integer.parseInt(courseId));
		req.setAttribute("openClass", openClass);
		
		
		Map<Integer, String> openClassIds = new TreeMap<>();
		
		for (OpenClass op : openClass) {
			int openClassId = op.getId();
			String teacher = op.getTeacher();
			openClassIds.put(openClassId, teacher);
		}
		
		req.setAttribute("openClassIds", openClassIds);
		
		
		var registrationId = req.getParameter("openClassId");
		
		// Page Navigation
		var page = switch (req.getServletPath()) {
		case "/registrations" -> {
			var model = getBean("registrationModel", RegistrationModel.class);// get OpenClassModel bean from IoC container
			req.setAttribute("registrations", model.findByCourseId(Integer.parseInt(registrationId)));
			yield "registrations";
		}
		default -> "registration-edit";
		};

		getServletContext().getRequestDispatcher("/%s.jsp".formatted(page)).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var courseId = req.getParameter("courseId");
		
		// find OpenClass
		var openClassId = req.getParameter("openClassId");
		//System.out.println(openClassId);
		
		var openClassObjOfStu = getBean("openClassModel", OpenClassModel.class);//********
		var realOpenClass = openClassObjOfStu.findById(Integer.parseInt(openClassId), Integer.parseInt(courseId));
		
		var studentName = req.getParameter("student");
		var phone = req.getParameter("phone");
		var email = req.getParameter("email");
		
		var registration = new Registration();
		registration.setId(Integer.parseInt(openClassId));
		registration.setOpenClass(realOpenClass);
		registration.setStudent(studentName);
		registration.setPhone(phone);
		registration.setEmail(email);
		
		// save to db
		getBean("registrationModel", RegistrationModel.class).createRegistration(registration);
		
		// redirect to registrations.jsp
		resp.sendRedirect("/registrations?openClassId=" + openClassId + "&courseId=" + courseId);
	}
	
	
//	var openClassModel = getBean("openClassModel", OpenClassModel.class);
//	var openClass = openClassModel.findByCourse(Integer.parseInt(courseId));
//	req.setAttribute("openClass", openClass);
	
	
//	var openClassObj = getBean("OpenClassModel", OpenClassModel.class);
//	var openClassObjOfStu = openClassObj.findById(openClassId);
	

}
