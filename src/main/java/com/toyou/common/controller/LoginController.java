package com.toyou.common.controller;

import java.io.PrintWriter;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.toyou.common.service.LoginService;
import com.toyou.common.vo.UserVO;
import com.toyou.session.SessionConst;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService svc;

	private Gson gson = new Gson();
	
	@RequestMapping(value = "/login.do")
	public String list(HttpServletRequest request, Model model, UserVO vo) {
		return "main/login";
	}
	
	/* 로그인 */
	@RequestMapping(value = "/loginCheck.do")
	public String loginCheck(HttpServletRequest request, HttpServletResponse response, Model model, UserVO vo) {
		
		try {
			UserVO user = svc.loginCheck(vo);
			
			if(user == null) {
				request.setAttribute("msg", "없는 회원정보입니다 확인해주세요");
		        request.setAttribute("url", "/login.do");
				
				return "common/message";
			} 

			HttpSession session = request.getSession();//세션이 있으면 있는 세션 반환, 없으면 신규세션 생성
		    session.setAttribute(SessionConst.LOGIN_MEMBER, user);
		     
		} catch (Exception e) {			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:/index.do";
	}
	
	/* 로그아웃 */
	@RequestMapping(value = "/logout.do")
	public String logout(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		
		System.out.println("=============================="+ session);
		session.invalidate();
		
//	    if (session != null) {
//	        session.invalidate(); //세션 제거
//	    }
//		
		return "redirect:/index.do";
	}
	
	/* 회원가입 */
	@RequestMapping(value = "/join.json", method=RequestMethod.POST)
	public @ResponseBody String join(UserVO vo){
    	Map<String,Object> map = new HashMap<String,Object>();
    	try {
    		int user = svc.userList(vo);
    		
    		if (user > 0) {
    			map.put("message", "이미 사용중인 아이디입니다.");
            	return gson.toJson(map);
    		}
            map.put("cnt", svc.join(vo));
            map.put("result", true);
		} catch (Exception e) {
			//map.put("message", e.getMessage());
            //map.put("result", false);
            e.getStackTrace();
		}
    	return gson.toJson(map);
    }   

}
