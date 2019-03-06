package com.leete.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leete.domain.User;

@RestController
public class HelloWorldController {
	
	private Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
	
	@Autowired
	private User user;
	
    @RequestMapping("/hello")
    public String index() {
		logger.info(user.getName());
		int a = 3/0;
		
		return user.getName();
		//return "hello boot";
    }
    
}