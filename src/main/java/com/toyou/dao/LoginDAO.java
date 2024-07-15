package com.toyou.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.toyou.common.vo.UserVO;

@Repository
public interface LoginDAO {

	public String getUserList();
	
	public UserVO loginCheck(UserVO vo);
	
}
