package com.toyou.common.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVO {

	private Integer		user_no;
	private String 		user_id;
	private String 		user_pw;
	private String 		name;
	private String 		auth_yn;
	private String 		profile;
	private String 		nickname;
	private String 		zip;
	private String 		address;
	private String 		dtl_address;
	private String 		birth;
	private String 		phone_num1;
	private String 		phone_num2;
	private String 		phone_num3;
	private String 		email;
	private String 		user_info;
	
	private String 		authCode;
	
	private String 		userName; 	// 아이디
	private String		oauth; 		// kakao, google
	
}
