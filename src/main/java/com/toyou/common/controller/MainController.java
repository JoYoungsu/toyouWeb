
package com.toyou.common.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.toyou.common.service.MainService;
import com.toyou.common.vo.UserVO;
import com.toyou.session.SessionConst;

@Controller
public class MainController {

	@Autowired
	private MainService svc;
	
	@RequestMapping(value = "/index.do")
	public String main(HttpServletRequest request, Model model, UserVO vo) {
		
//		HttpSession session = request.getSession(false);
//        if (session == null) {
//            return "index";
//        }

        Cookie[] cookies=request.getCookies(); // 모든 쿠키 가져오기
        System.out.println("cookies : " + cookies);
        if(cookies!=null){
            for (Cookie c : cookies) {
                String name = c.getName(); // 쿠키 이름 가져오기
                String value = c.getValue(); // 쿠키 값 가져오기
                System.out.println("name ============== " + name);
                System.out.println("value ============== " + value);
                if (name.equals("memberId")) {
                	model.addAttribute("member", value);
                }
            }
        }
		
		return "index";
	}
	
}
