package com.leete.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.leete.domain.User;
import com.leete.mapper.UserMapper;
import com.leete.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	public UserMapper userMapper;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<User> queryAllUser() {
		
		return userMapper.selectAll();
	}

}
