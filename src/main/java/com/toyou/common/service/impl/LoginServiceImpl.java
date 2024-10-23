package com.toyou.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toyou.common.service.LoginService;
import com.toyou.common.vo.User;
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
	
	// 임시 비밀번호 변경
	@Override
	public int updatePw(UserVO vo) throws Exception {		
		return dao.updatePw(vo);
	}
	
	// 카카오 로그인 - 회원정보 조회
	@Override
	public User searchInfo(String userName) throws Exception {
		return dao.searchInfo(userName);
	}
	
	// 카카오 로그인 - 회원가입
	@Override
	public int kakaoJoin(User vo) throws Exception {
		return dao.kakaoJoin(vo);
	}
}
