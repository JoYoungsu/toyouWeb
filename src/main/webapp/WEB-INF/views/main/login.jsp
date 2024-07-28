<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Toyou</title>
    <link rel="stylesheet" href="/resources/css/font/font.css">
    <link rel="stylesheet" href="/resources/css/style.css">
    <link rel="stylesheet" href="/resources/css/reset.css">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>

<%@ include file ="../common/header.jsp" %>

<body>
    <div id="wrap">
        <div id="loginpop">
            <div class="login">
                <div class="logo"><img src="/resources/img/logo.png" alt=""></div>
                <form id="toyou" method="post" action="/loginCheck.do">
                    <div class="loginId"><input type="text" name="user_id" placeholder="아이디(이메일)을 입력해주세요"> 
                        <svg width="15.75" height="18" viewBox="0 0 15.75 18">
                            <path id="Icon_awesome-user" data-name="Icon awesome-user" d="M7.875,9a4.5,4.5,0,1,0-4.5-4.5A4.5,4.5,0,0,0,7.875,9Zm3.15,1.125h-.587a6.12,6.12,0,0,1-5.126,0H4.725A4.726,4.726,0,0,0,0,14.85v1.462A1.688,1.688,0,0,0,1.688,18H14.063a1.688,1.688,0,0,0,1.688-1.687V14.85A4.726,4.726,0,0,0,11.025,10.125Z" fill="#d4dfe8"/>
                        </svg>
                    </div>
                    <div class="loginPw"><input type="password" name="user_pw" placeholder="비밀번호를 입력해주세요"> 
                        <svg width="15.104" height="19.635" viewBox="0 0 15.104 19.635">
                            <path id="Icon_ionic-ios-lock" data-name="Icon ionic-ios-lock" d="M19.966,10.171H18.833v-2.2a4.531,4.531,0,1,0-9.062-.061v2.266H8.638A1.893,1.893,0,0,0,6.75,12.059v9.062a1.893,1.893,0,0,0,1.888,1.888H19.966a1.893,1.893,0,0,0,1.888-1.888V12.059A1.893,1.893,0,0,0,19.966,10.171Zm-5,5.89v3.247a.677.677,0,0,1-.628.68.662.662,0,0,1-.694-.661V16.062a1.51,1.51,0,1,1,1.322,0Zm2.549-5.89H11.092V7.906a3.21,3.21,0,0,1,6.419,0Z" transform="translate(-6.75 -3.374)" fill="#d8e4ee"/>
                        </svg>
                    </div>
                    <div class="keepLgn">
                        <div><input type="checkbox"> 로그인 유지</div>
                        <span>
                            비밀번호를 잊으셨나요?
                        </span>
                    </div>
                    <div class="loginBtn" onclick="fnLogin()">로그인</div   >
                    <div class="simpleLgn">
                        <div>카카오 간편 로그인</div>
                    </div>
                </form>
            </div>
             <div class="sign">
                    <div class="logo">회원가입</div>
                    <div class="loginId loginem"><input type="email" placeholder="이메일 주소*" class=""> <div class="jo">인증하기</div>
                    </div>
                    <div class="logincer"><input type="text" placeholder="인증번호 입력"><div><span>1212</span><p>확인</p></div></div>
                    <div class="loginPw"><input type="password" placeholder="비밀번호(영문,숫자,특수문자 포함 8자리 이상)*"> 
                    </div>
                    <div class="loginPw"><input type="password" placeholder="비밀번호 확인* "> 
                    </div>
                    <div class="loginPw" style="margin-bottom: 22px;"><input type="text" placeholder="닉네임(선택)"> 
                    </div>
                    <div class="loginBtn">회원가입</div>
        </div>
        <p class="login_B">회원가입</p>
    </div>

    <footer></footer>
</body>

<script>

function fnLogin() {
		document.getElementById("toyou").submit();
	}
</script>



<script src="/resources/js/action.js"></script>


</html>