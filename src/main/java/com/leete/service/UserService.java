package com.leete.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.leete.domain.User;

public interface UserService {
	
	public List<User>  queryAllUser();

}
