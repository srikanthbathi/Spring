package com.bathi;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;


import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements  WebApplicationInitializer  {

	

	public void onStartup(ServletContext servletContext) throws ServletException {

		//get the application context
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.register(ContextInitializer.class);
		DispatcherServlet servlet = new DispatcherServlet(appContext);
		servletContext.addServlet("dispatcher", servlet).addMapping("/*");
		
		servletContext.addListener(new ContextLoaderListener(appContext));
		
		
		
	}

}
