<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Toyou</title>

    <!-- 레일웨이 구글 폰트 -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Raleway&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@200;300;400&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="/resources/css/font/font.css">
    <link rel="stylesheet" href="/resources/css/font/segoe-ui-4-cufonfonts-webfont/segoefont.css">
    <link rel="stylesheet" href="/resources/css/style.css">
    <link rel="stylesheet" href="/resources/css/reset.css">
    <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">

    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">

</head>
<body>
    <div id="wrap">
        <header>
            <div class="H_top">
                <div id="logo"></div>
                <div id="H_right">
                    <ul>
                        <li class="U_login">로그인</li>
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
        <div id="visual">
            <div id="V_left">
                <div><img src="img/map.png" alt=""></div>
            </div>
            <div id="V_right">
                <ul class="slider">
                    <li>
                      <div style="background-image:url(/resources/img/seoul.png)">
                        <dl>
                            <p>Seoul</p>
                        </dl>
                      </div>
                    </li>
                    <li>
                      <div style="background-image:url(/resources/img/busan.png);">
                        <dl>
                            <p>Busan</p>
                        </dl>
                      </div>
                    </li>
                    <li>
                      <div style="background-image:url(/resources/img/gyengju.png);">
                        <dl>
                            <p>Gyengju</p>
                        </dl>
                      </div>
                    </li>
                    <li>
                        <div style="background-image:url(/resources/img/jeju.png);">
                          <dl>
                            <p>Jeju</p>
                          </dl>
                        </div>
                      </li>
                    
                  </ul>
            
                <ul class="btn ">
                    <li class="ar_l">
                        <button type="button" id="prev"><img src="/resources/img/arrow_L.png" alt=""></button></li>
                    <li class="ar_r">
                        <button type="button" id="next"><img src="/resources/img/arrow_R.png" alt=""></button></li>
                </ul>
            </div>
            <div id="V_maintext">
                <div>
                    <p>To You</p>
                    <h2>
                        <div class="drawsvg">
                        <svg version="1.1" viewBox="0 0 900 300">
                          <symbol id="fade-text">
                            <text x="23%" y="35%" text-anchor="middle">나만의 여행일지</text>
                          </symbol>
                          <g>
                            <use class="stroke" xlink:href="#fade-text"/>
                            <use class="fill" xlink:href="#fade-text"/>
                          </g>
                        </svg>					
                        </div>
                    </h2>
                    <div class="v_i"><i>Make Life Better</i></div>
                </div>
                <ul class="V_input">
                    <li class="V_search">
                        <div>
                            <p>2 서울</p>
                        </div>
                        <div>
                            <input type="text" placeholder="여행지를 입력해주세요.">
                        </div>
                    </li>
                    <li>
                        <img src="/resources/img/search.png" alt="">
                        <img src="/resources/img/search_w.png" alt="">
                    </li>
                </ul>
            </div>
        </div>
    </div>


    <script src="/resources/js/action.js">

    </script>

</body>
</html>