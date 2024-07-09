package com.toyou.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toyou.dao.UserDAO;
import com.toyou.service.UserService;
import com.toyou.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO dao;
	
	@Override
	public String getUserList() throws Exception {
		
		return dao.getUserList();
	}
}
