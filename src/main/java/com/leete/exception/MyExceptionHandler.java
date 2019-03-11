package com.leete.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class MyExceptionHandler {
	
	private static Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);
	
	@ExceptionHandler(Exception.class)
	public ModelAndView exceptionHandler(HttpServletRequest request,HttpServletResponse response,Exception e) {
		
		logger.error("访问异常");
		
		e.printStackTrace();
		ModelAndView view = new ModelAndView("exception");
		view.addObject("e", e.getMessage());
		view.addObject("url", request.getRequestURL());
		view.setViewName("err");
		return view;
	}

}
