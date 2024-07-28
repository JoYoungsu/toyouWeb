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

<%@ include file ="common/header.jsp" %>

<body>
    <div id="wrap">
        <div id="visual">
            <div id="V_bimg">
                <img src="/resources/img/seoul.jpg" alt="">
            </div>
            <div class="visual_main">
                <div class="V_left">
                    <div>
                        <p>To You</p>
                        <h2>나만의 여행일지</h2>
                        <i>Make Life Better</i>
                    </div>
                    <div class="mainst">
                        시작하기
                    </div>
                </div> 
                <div class="V_right shadow">
                    <div class="V_rimg">
                        <img src="/resources/img/seoul.jpg" alt="">
                    </div>
                    <!-- <div class="V_rtx">
                        <p>Seoul</p>
                        <span>01</span>
                    </div> -->
                </div> 
                <div id="V_search">
                    <form>
                        <div class="shadow">
                            <button>
                                <svg width="21.579" height="21.567" viewBox="0 0 21.579 21.567">
                                    <g transform="translate(-1093.5 -800.5)">
                                      <path d="M19.579,20.567a1,1,0,0,1-.706-.291L14.8,16.22A9.694,9.694,0,1,1,8.7-1a9.69,9.69,0,0,1,7.521,15.807l4.068,4.052a1,1,0,0,1-.706,1.708ZM8.7,1a7.7,7.7,0,1,0,7.7,7.7A7.7,7.7,0,0,0,8.7,1Z" transform="translate(1094.5 801.5)" fill="#222"/>
                                    </g>
                                </svg>
                            </button>
                            <input type="text" placeholder="여행지를 입력하세요.">
                        </div>
                        <ul>
                            <li>
                                <div>
                                    <svg width="13.237" height="13.231" viewBox="0 0 13.237 13.231">
                                    <path d="M-4016.469-846.768l-2.661-2.65A5.974,5.974,0,0,1-4023-848a6.007,6.007,0,0,1-6-6,6.007,6.007,0,0,1,6-6,6.007,6.007,0,0,1,6,6,5.973,5.973,0,0,1-1.422,3.874l2.659,2.648ZM-4023-859a5.006,5.006,0,0,0-5,5,5.006,5.006,0,0,0,5,5,5.006,5.006,0,0,0,5-5A5.006,5.006,0,0,0-4023-859Z" transform="translate(4029 860)" fill="#fff"/>
                                    </svg>
                                    <p>제주(Jeju)</p>
                                </div>
                                <span>대한민국</span>
                            </li>
                            <li>
                                <div>
                                    <svg width="13.237" height="13.231" viewBox="0 0 13.237 13.231">
                                    <path d="M-4016.469-846.768l-2.661-2.65A5.974,5.974,0,0,1-4023-848a6.007,6.007,0,0,1-6-6,6.007,6.007,0,0,1,6-6,6.007,6.007,0,0,1,6,6,5.973,5.973,0,0,1-1.422,3.874l2.659,2.648ZM-4023-859a5.006,5.006,0,0,0-5,5,5.006,5.006,0,0,0,5,5,5.006,5.006,0,0,0,5-5A5.006,5.006,0,0,0-4023-859Z" transform="translate(4029 860)" fill="#fff"/>
                                    </svg>
                                    <p>서울(Seoul)</p>
                                </div>
                                <span>대한민국</span>
                            </li>
                            <li>
                                <div>
                                    <svg width="13.237" height="13.231" viewBox="0 0 13.237 13.231">
                                    <path d="M-4016.469-846.768l-2.661-2.65A5.974,5.974,0,0,1-4023-848a6.007,6.007,0,0,1-6-6,6.007,6.007,0,0,1,6-6,6.007,6.007,0,0,1,6,6,5.973,5.973,0,0,1-1.422,3.874l2.659,2.648ZM-4023-859a5.006,5.006,0,0,0-5,5,5.006,5.006,0,0,0,5,5,5.006,5.006,0,0,0,5-5A5.006,5.006,0,0,0-4023-859Z" transform="translate(4029 860)" fill="#fff"/>
                                    </svg>
                                    <p>부산(Busan)</p>
                                </div>
                                <span>대한민국</span>
                            </li>
                            <li>
                                <div>
                                    <svg width="13.237" height="13.231" viewBox="0 0 13.237 13.231">
                                    <path d="M-4016.469-846.768l-2.661-2.65A5.974,5.974,0,0,1-4023-848a6.007,6.007,0,0,1-6-6,6.007,6.007,0,0,1,6-6,6.007,6.007,0,0,1,6,6,5.973,5.973,0,0,1-1.422,3.874l2.659,2.648ZM-4023-859a5.006,5.006,0,0,0-5,5,5.006,5.006,0,0,0,5,5,5.006,5.006,0,0,0,5-5A5.006,5.006,0,0,0-4023-859Z" transform="translate(4029 860)" fill="#fff"/>
                                    </svg>
                                    <p>경주(Gyengju)</p>
                                </div>
                                <span>대한민국</span>
                            </li>
                        </ul>
                    </form>
                </div>
            </div>
            <div id="V_map">
                <div><img src="/resources/img/map.png" alt=""></div>
            </div>
            
        </div>
    </div>


    <script>
        $('header').slideUp()

        $('.mainst').click(function(){
             $('#visual').addClass('on') 
             $('#V_map').addClass('on') 
             $('.V_right').hide()
             $('.V_left').hide()
             $('#V_search').show()
             $(this).hide()
             $('header').slideDown(200)
        })
    </script>

</body>

</html>