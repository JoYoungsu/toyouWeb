package com.toyou.common.controller;

import java.io.PrintWriter;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.toyou.common.service.LoginService;
import com.toyou.common.vo.UserVO;
import com.toyou.session.SessionConst;

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
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		try {
			UserVO user = svc.loginCheck(vo);
			
			if(user == null) {
				PrintWriter out = response.getWriter();
				
				out.println("<script> alert('아이디 또는 비밀번호가 틀립니다.');");
				out.println("history.go(-1); </script>"); 
				out.close();
				return "main/login";
			} 
			
//			Cookie id = new Cookie("user_id", user.getUser_id());
//			response.addCookie(id);
			
			 HttpSession session = request.getSession();//세션이 있으면 있는 세션 반환, 없으면 신규세션 생성
		     session.setAttribute(SessionConst.LOGIN_MEMBER, user);
		        
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "index";
	}
	
}
