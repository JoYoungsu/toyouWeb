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
	public UserVO loginCheck(UserVO vo) throws Exception {
		return dao.loginCheck(vo);
	}

	// 회원가입 - 중복체크
	@Override
	public int userList(UserVO vo) throws Exception {
		return dao.userList(vo);
	}

	// 회원가입
	@Override
	public int join(UserVO vo) throws Exception {		
		return dao.join(vo);
	}
	
}
