package com.toyou.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.toyou.common.service.UserService;
import com.toyou.common.vo.UserVO;
import com.toyou.session.SessionConst;

@Controller
public class UserController {

	@Autowired
	private UserService svc;
	
	@RequestMapping(value = "/index.do")
	public String main(HttpServletRequest request, Model model, UserVO vo) {
		HttpSession session = request.getSession(false);
		
		try {
			svc.getUserList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		UserVO loginMember = (UserVO)session.getAttribute(SessionConst.LOGIN_MEMBER);
		
		model.addAttribute("member", loginMember);
		return "index";
	}
}
