package com.toyou.common.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.toyou.common.service.UserService;
import com.toyou.common.vo.UserVO;

@Controller
public class UserController {

	@Autowired
	private UserService svc;
	
	@RequestMapping(value = "/index.do")
	public String list(HttpServletRequest request, Model model, UserVO vo) {
		try {
			svc.getUserList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "index";
	}
}
