$(document).ready(function(){

     //로그인  
     $('.loginId').click(function(){

      $(this).addClass('on')

  })
  $('.loginPw').click(function(){

      $(this).addClass('on')

  })

  $('.keepLgn span').click(function(){

      $('.login').animate({left:-100 + "%",opacity:0},200)
      $('.login').animate({left:0})

      /* $('.sign').show().animate({opacity:1},200) */

  })

  $('.login_B').click(function(){

  $('.login').animate({left:-100 + "%",opacity:0},200)
  $('.login').animate({left:0})

  $('.sign').show().animate({opacity:1},100)

  })


  $('.jo').click(function(){

  $('.sign .logincer').addClass('on')
    
  })
   
})

