package com.toyou.common.controller;

import java.io.IOException;
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
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.CookieGenerator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.toyou.common.service.LoginService;
import com.toyou.common.vo.KakaoProfile;
import com.toyou.common.vo.OAuthToken;
import com.toyou.common.vo.User;
import com.toyou.common.vo.UserVO;
import com.toyou.session.SessionConst;

@Controller
public class LoginController {
	
	// 상단에 추가
	@Value("${lwj.key}")
	private String lwjKey;

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

			Cookie idCookie = new Cookie("memberId", String.valueOf(user.getUser_id()));
			response.addCookie(idCookie);
			idCookie.setMaxAge(60*60);
		} catch (Exception e) {			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:/index.do";
	}
	
	/* 로그아웃 */
	@RequestMapping(value = "/logout.do")
	public String logout(HttpServletRequest request, HttpServletResponse response, String cookieName) {
		
		Cookie[] cookies = request.getCookies(); // 모든 쿠키의 정보를 cookies에 저장
	    if (cookies != null) { // 쿠키가 한개라도 있으면 실행
	        for (int i = 0; i < cookies.length; i++) {
	            cookies[i].setMaxAge(0); // 유효시간을 0으로 설정
	            response.addCookie(cookies[i]); // 응답에 추가하여 만료시키기.
	        }
	        System.out.println("cookies : " + cookies);
	    }

		return "redirect:/index.do";
	}
	
	/* 회원가입 */
	@RequestMapping(value = "/join.json", method=RequestMethod.POST)
	public @ResponseBody String join(UserVO vo){
    	Map<String,Object> map = new HashMap<String,Object>();
    	try {
    		int user = svc.userList(vo);
    		System.out.println(user);
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


	@RequestMapping(value = "login/callback")
	public String kakaoCallback(HttpServletRequest request, HttpServletResponse response3, String code) { // Data를 리턴해주는 컨트롤러 함수, 쿼리스트링에 있는 code값을 받을 수 있음  
	    // POST 방식으로 key=value 데이터를 요청 (카카오톡으로)
	    /* Retrofit2
	     * OkHttp
	     * HttpsURLConnection
	     * RestTemplate (우린 이걸로 할거다)
	     */
	    RestTemplate rt = new RestTemplate();

	    // HttpHeader 오브젝트 생성
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8"); // 내가 지금 전송할 body data 가 key=velue 형임을 명시

	    // HttpBody 오브젝트 생성
	    MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
	    params.add("grant_type", "authorization_code");
	    params.add("client_id", "eb924f4e7ce51fdc0a8f51ea525d6a5e");
	    params.add("redirect_uri", "http://localhost:8080/login/callback");
	    params.add("code", code);

	    // HttpHeader 와 HttpBody를 하나의 오브젝트에 담기
	    HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = 
	            new HttpEntity<>(params, headers); // header 와 body 값을 가지고 있는 entity 값이 된다.

	    // Http 요청하기 - Post 방식으로 - 그리고 Response 변수의 응답 받음.
	    ResponseEntity<String> response = rt.exchange(
	                "https://kauth.kakao.com/oauth/token",
	                HttpMethod.POST,
	                kakaoTokenRequest,
	                String.class // String 타입으로 응답 데이터를 받겠다.
	            );

	    
	    RestTemplate rt2 = new RestTemplate();

	    // Gson, Json, Simple, ObjectMapper라이브러리를 사용하여 자바객체로 만들 수 있다.
	    ObjectMapper objectMapper = new ObjectMapper();
	    OAuthToken oauthToken = null;
	    try {
	    	oauthToken = objectMapper.readValue(response.getBody(), OAuthToken.class);
		} catch (JsonMappingException e) {
	        e.printStackTrace();
	    } catch (JsonProcessingException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    System.out.println("카카오 액세스 토큰 : " + oauthToken.getAccess_token());
	    
		// HttpHeader 오브젝트 생성
		HttpHeaders headers2 = new HttpHeaders();
		headers2.add("Authorization", "Bearer " + oauthToken.getAccess_token());
		headers2.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8"); // 내가 지금 전송할 body data 가
		                                                                                     // key=velue 형임을 명시
	
		// HttpHeader 와 HttpBody를 하나의 오브젝트에 담기
		HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest = new HttpEntity<>(headers2);
	
		// Http 요청하기 - Post 방식으로 - 그리고 Response 변수의 응답 받음.
		ResponseEntity<String> response2 = rt2.exchange("https://kapi.kakao.com/v2/user/me", HttpMethod.POST,
				kakaoProfileRequest, String.class // String 타입으로 응답 데이터를 받겠다.
		);
	
		System.out.println("유저정보 : " + response2.getBody());
		
		// Gson, Json, Simple, ObjectMapper
		ObjectMapper objectMapper2 = new ObjectMapper();
		KakaoProfile kakaoProfile = null;
		try {
		    kakaoProfile = objectMapper2.readValue(response2.getBody(), KakaoProfile.class);
		} catch (JsonMappingException e) {
		    e.printStackTrace();
		} catch (JsonProcessingException e) {
		    e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// User 오브젝트 : userName, password, email
		System.out.println("카카오 아이디(번호) : " + kakaoProfile.getId());
		System.out.println("카카오 이메일 : " + kakaoProfile.getKakao_account().getEmail());
		System.out.println("카카오 닉네임 : " + kakaoProfile.getProperties().getNickname());
	
		// UUID garbagePassword = UUID.randomUUID(); 
		// UUID란 -> 중복되지 않는 어떤 특정 값을 만들어내는 알고리즘
//			 System.out.println("블로그서버 패스워드 : " + garbagePassword); // DB에 넣기위한 랜덤 임시 비밀번호
		System.out.println("블로그서버 패스워드 : " + lwjKey); // DB에 넣기위한 랜덤 임시 비밀번호
		
		//랜덤 비밀번호
		String pw = RandomStringUtils.randomAlphanumeric(10);
		
		User kakakoUser = User.builder()
		        .userName(String.valueOf(kakaoProfile.getId()))
		        .password(pw)
		        .oauth("kakao")
		        .build(); 
		System.out.println(kakakoUser.getUserName());
		System.out.println(kakakoUser.getOauth());
		
		// 이미 등록된 회원이면 로그인 , 등록되있지 않은 회원일 경우 로그인을 하는 분기 처리를 해야한다.
		// 가입자 혹은 비가입자 체크 해서 처리
		try {
			User originUser = svc.searchInfo(kakakoUser.getUserName());
			System.out.println("로그인 아이디 ============= "+ originUser);
			if(originUser == null) {
				System.out.println("기존 회원이 아닙니다. ~~~");
				svc.kakaoJoin(kakakoUser);			
			}
			
			System.out.println("자동 로그인을 진행합니다.");
			// 로그인 처리
			CookieGenerator idCookie = new CookieGenerator();
			idCookie.setCookieName("memberId");
			idCookie.addCookie(response3, String.valueOf(kakakoUser.getUserName()));
			idCookie.setCookieMaxAge(60*60);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(kakakoUser.getUserName(), lwjKey));
//		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		return "redirect:/index.do";
	}
	
}
