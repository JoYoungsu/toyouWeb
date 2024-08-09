package com.toyou.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.toyou.common.vo.UserVO;

@Repository
public interface LoginDAO {

	// 로그인
	public UserVO loginCheck(UserVO vo);
	
	// 회원가입
	public int join(UserVO vo);

	// 회원가입 - 중복체크
	public int userList(UserVO vo);
	
}