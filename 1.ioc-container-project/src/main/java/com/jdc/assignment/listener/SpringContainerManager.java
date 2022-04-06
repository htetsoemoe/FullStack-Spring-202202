package com.jdc.assignment.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.support.GenericXmlApplicationContext;

@WebListener
public class SpringContainerManager implements ServletContextListener{
	
	public static final String SPRING_CONTEXT = "spring.context";
	private GenericXmlApplicationContext springContext;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// Start IoC container
		System.out.println("Initialize IoC Container...");
		
		// Add IoC Container to Application Scope
		springContext = new GenericXmlApplicationContext("classpath:/application.xml");
		sce.getServletContext().setAttribute(SPRING_CONTEXT, springContext); // getServletContext() gets ApplicationScope and set SPRING_CONTEXT as key, value
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// Stop IoC container
		System.out.println("Stop IoC Container...");
		
		if (null != springContext) {
			springContext.close();
		}
	}
}
