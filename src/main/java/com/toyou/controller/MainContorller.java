package com.toyou.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.toyou.service.MainService;

@Controller
public class MainContorller {

	@Resource(name="mainService")
	private MainService mainService;
	
	@RequestMapping(value="/")
	public String test(Model model) throws Exception {
		System.out.println("controller");
		String test=mainService.selectTest();
		System.out.println(test);
		model.addAttribute("selectTableList", test);
		return "main/Main";
	}
	
//	@Autowired
//	public UserMapper mapper;
//	
//	@RequestMapping(value = "/list", method = RequestMethod.POST)
//	public String list(HttpServletRequest request, Model model) {
//		
//		String memberId = request.getParameter("memberId"); 
//		model.addAttribute("memberId", mapper.memberId(memberId));
//		return "list";
//	}
	
}
