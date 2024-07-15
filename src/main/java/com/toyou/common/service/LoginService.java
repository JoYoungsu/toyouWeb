package com.toyou.common.service;

import com.toyou.common.vo.UserVO;

public interface LoginService {

	public String getUserList() throws Exception;
	
	public UserVO loginCheck(UserVO vo) throws Exception;

}
