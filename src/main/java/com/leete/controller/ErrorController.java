package com.leete.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {

	@RequestMapping("/err")
	public String errHandler() {
		
		
		return "webapp/page/exception";
	}
}
