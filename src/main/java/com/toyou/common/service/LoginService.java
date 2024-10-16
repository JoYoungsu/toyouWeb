package com.toyou.common.service;

import com.toyou.common.vo.UserVO;

public interface LoginService {

	// 로그인 - 정보 조회 
	public UserVO loginCheck(UserVO vo) throws Exception;
	
	// 회원가입 - 중복체크
	public int userList(UserVO vo) throws Exception;

	// 회원가입
	public int join(UserVO vo) throws Exception;

	// 임시 비밀번호 변경
	public int updatePw(UserVO vo) throws Exception;
	
}
