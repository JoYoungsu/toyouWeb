package com.toyou.common.controller;

import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.toyou.common.service.LoginService;
import com.toyou.common.vo.UserVO;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService svc;
	
	@RequestMapping(value = "/login.do")
	public String list(HttpServletRequest request, Model model, UserVO vo) {
		return "main/login";
	}
	
	@RequestMapping(value = "/loginCheck.do")
	public String loginCheck(HttpServletRequest request, HttpServletResponse response, Model model, UserVO vo) {
		System.out.println(vo.getUser_id());
		System.out.println(vo.getUser_pw());
		
		try {
			UserVO user = svc.loginCheck(vo);
			
			if(user == null) {
				System.out.println("로그인 실패");
				PrintWriter out = response.getWriter();
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset=UTF-8");
				out.println("<script> alert('아이디 또는 비밀번호가 틀립니다.');");
				out.println("history.go(-1); </script>"); 
				out.close();
				return "main/login";
			} 
			
			Cookie id = new Cookie("user_id", user.getUser_id());
			System.out.println(user.getUser_id());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "index";
	}

}
