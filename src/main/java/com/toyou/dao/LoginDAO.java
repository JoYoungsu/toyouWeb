package com.toyou.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.toyou.common.vo.User;
import com.toyou.common.vo.UserVO;

@Repository
public interface LoginDAO {

	// 로그인
	public UserVO loginCheck(UserVO vo);
	
	// 회원가입
	public int join(UserVO vo);

	// 회원가입 - 중복체크
	public int userList(UserVO vo);
	
	// 임시 비밀번호 변경
	public int updatePw(UserVO vo);

	// 카카오 로그인 - 회원정보 조회
	public User searchInfo(String userName);
	
	// 카카오 회원가입
	public int kakaoJoin(User vo);
}