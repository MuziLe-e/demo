package com.leete.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcInterrupter implements WebMvcConfigurer{
	
	@Autowired
	private RequestHandler requestHandler;

	@Override
	public void addInterceptors(InterceptorRegistry register) {
		
		register.addInterceptor(requestHandler);
		
		WebMvcConfigurer.super.addInterceptors(register);
	}
	
	
	
	
}
