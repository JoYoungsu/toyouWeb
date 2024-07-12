package com.toyou.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toyou.common.service.UserService;
import com.toyou.common.vo.UserVO;
import com.toyou.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO dao;
	
	@Override
	public String getUserList() throws Exception {
		
		return dao.getUserList();
	}
}
