package com.toyou.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toyou.common.service.LoginService;
import com.toyou.common.vo.UserVO;
import com.toyou.dao.LoginDAO;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDAO dao;
	
	@Override
	public String getUserList() throws Exception {
		
		return dao.getUserList();
	}
	
	@Override
	public UserVO loginCheck(UserVO vo) throws Exception {
		return dao.loginCheck(vo);
	}

}
