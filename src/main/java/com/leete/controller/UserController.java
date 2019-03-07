package com.leete.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.leete.domain.User;
import com.leete.service.UserService;

@Controller
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService  userService;
	
	@RequestMapping("/allUser")
	public ModelAndView queryAllUser(ModelAndView  modelAndView){
		List<User> userList = userService.queryAllUser();
		logger.info(userList.get(0).getName().toString());
		//modelAndView.addObject("user",userList.get(0));
		modelAndView.addObject("userList", userList);
		modelAndView.setViewName("user");
		return modelAndView;
	}

}
