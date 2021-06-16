package com.douzone.hellospring.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.douzone.hellospring.config.WebConfig;

public class HelloSpringWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// Root Application Context 설정 class 
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// Web Application Context 설정 class
		return new Class<?>[] {WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// DispatcherServlet Mapping URL
		return new String[] { "/" };
	}

}
