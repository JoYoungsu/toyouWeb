package com.toyou.common.vo;

import java.security.Timestamp;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class User {

	private String userName; // 아이디

	private String password; // 비밀번호
	
	private String nickname; // 비밀번호

	private String email; // 이메일
	
	private String role; // ADMIN, USER 만 값이 들어가게된다. 
	
	private String oauth; // kakao, google
	
	private Timestamp createDate;
}
