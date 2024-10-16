$(document).ready(function(){

//로그인  
  $('.loginId').click(function(){

      $(this).addClass('on')

  })

  $('.loginPw').click(function(){

      $(this).addClass('on')

  })



//비밀번호 찾기   
  $('.keepLgn span').click(function(){

      $('.login').animate({left:-100 + "%",opacity:0},200)

      $('.F_pw').show().animate({opacity:1},200) 

      $('.login_B .lb_1').hide().siblings().show()

  })



  $('.login_B .lb_1').click(function(){

    $('.login').animate({left:-100 + "%",opacity:0},200)
    $('.sign').show().animate({opacity:1},100)
    $(this).hide().siblings().show()

  })


  $('.login_B .lb_2').click(function(){

    $('.sign').animate({opacity:0},100).hide()
    $('.F_pw').animate({opacity:0},100).hide()
    $('.login').animate({left:40,opacity:1},200).show()

    $(this).hide().siblings().show()

  })


  $('.jo').click(function(){

  $('.sign .logincer').addClass('on')
    
  })
   
})

