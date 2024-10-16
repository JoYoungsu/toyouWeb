package com.toyou.common.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.toyou.common.service.LoginService;
import com.toyou.common.vo.UserVO;

@Controller
public class AuthCodeSend {

	@Autowired
	JavaMailSenderImpl mailSender;
	
	@Autowired
	private LoginService svc;
	
	private Gson gson = new Gson();
	
	//이메일 인증
	@PostMapping("/EmailAuth.json")
	@ResponseBody
	public String emailAuth(String email) {
		System.out.println("전달 받은 이메일 주소 : " + email);
		
		
		//난수의 범위 111111 ~ 999999 (6자리 난수)
		Random random = new Random();
		int checkNum = random.nextInt(888888)+111111;
		
		//이메일 보낼 양식
		String setFrom = "dudtn135623@naver.com"; //2단계 인증 x, 메일 설정에서 POP/IMAP 사용 설정에서 POP/SMTP 사용함으로 설정o
		String toMail = email;
		String title = "회원가입 인증 이메일 입니다.";
		String content = "인증 코드는 " + checkNum + " 입니다." +
						 "<br>" +
						 "해당 인증 코드를 인증 코드 확인란에 기입하여 주세요.";
		
		try {
			MimeMessage message = mailSender.createMimeMessage(); //Spring에서 제공하는 mail API
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setFrom(setFrom);
            helper.setTo(toMail);
            helper.setSubject(title);
            helper.setText(content, true);
            mailSender.send(message);
		} catch (Exception e) {
			System.out.println("오류 : "+e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("랜덤숫자 : " + checkNum);
		return Integer.toString(checkNum);
	}	
	
	/* 비밀번호 찾기 - 이메일 전송 */
	@RequestMapping(value = "/findPw.json", method=RequestMethod.POST)
	public @ResponseBody String findPw(UserVO vo){
		String user_id = vo.getUser_id();
    	Map<String,Object> map = new HashMap<String,Object>();
    	try {
    		int user = svc.userList(vo);
    		
    		if (user == 0) {
    			System.out.println("----------------");
    			map.put("message", "존재하지 않는 아이디입니다.");
            	return gson.toJson(map);
    		}
    		
    		// 랜덤문자열 생성
    		String code = RandomStringUtils.randomAlphanumeric(10);
    		vo.setUser_pw(code);
    		System.out.println(code);
    		//이메일 보낼 양식
    		String setFrom = "dudtn135623@naver.com"; //2단계 인증 x, 메일 설정에서 POP/IMAP 사용 설정에서 POP/SMTP 사용함으로 설정o
    		String toMail = user_id;
    		String title = "Toyou 임시비밀번호 안내 이메일 입니다.";
    		String content = "회원님의 임시 비밀번호는 " + code + " 입니다." +
    						 "<br>" +
    						 "로그인 후에 비밀번호 변경을 해주세요.";
    		
    		try {
    			MimeMessage message = mailSender.createMimeMessage(); //Spring에서 제공하는 mail API
                MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
                helper.setFrom(setFrom);
                helper.setTo(toMail);
                helper.setSubject(title);
                helper.setText(content, true);
                mailSender.send(message);
                
                // 임시 비밀번호로 변경
                svc.updatePw(vo);
    		} catch (Exception e) {
    			System.out.println("오류 : "+e.getMessage());
    			e.printStackTrace();
    		}
    		
    		
            map.put("result", true);
		} catch (Exception e) {
			//map.put("message", e.getMessage());
            //map.put("result", false);
            e.getStackTrace();
		}
    	return gson.toJson(map);
    }   
	
	
	
	
}
