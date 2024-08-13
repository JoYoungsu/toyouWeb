<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<header class="shadow">
		<div class="H_top">
			<div id="logo">
				<img src="/resources/img/logo.png" alt="" onclick="location.href='/index.do'">
			</div>
		
			<div id="H_right">
				<ul>
					<li class="U_login" onclick="fnLoginCheck()"><a href="/login.do">로그인</a></li>
					<li class="customer">고객센터</li>
					<li class="U_info"><img src="/resources/img/user.png" alt=""></li>
					<li class="menu">
						<div></div>
						
						<div></div>
						<div></div>
					</li>
				</ul>
			</div>
		</div>              
	</header>
	
	<script>

		$( document ).ready(function() {
			console.log("cookies : "+"${member}")
			
			if("${member}" != '') {
				$(".U_login").text("로그아웃");
			} else {
				$(".U_login").text("로그인");	
			}
		});
		
		function fnLoginCheck() {
			if("${member}" != '') {
				window.location = "/logout.do";
			} else {
				window.location = "/login.do";
			}	
		}
		
	</script>
