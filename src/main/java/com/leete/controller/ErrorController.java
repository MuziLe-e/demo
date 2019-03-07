package com.leete.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {

	@RequestMapping("/err")
	public String errHandler(HttpServletRequest request) {
		
		return "URL:" + request.getAttribute("url") + " ~~~~~~~~~~ " + "REEOR:" + request.getAttribute("e");
	}
}
