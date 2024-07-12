package com.toyou.common.controller;

import javax.servlet.http.HttpServletRequest;

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
}
