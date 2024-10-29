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


// 241022 추가

// visual 지도

$('#V_map .map_sw img').fadeOut()
$('.map_in').fadeOut()



// $('#V_map .map_sw_1.v2 path').click(function(){
  
//   let svgTop = $(this).parents('svg').offset().top;
//   let mapnum = $(this).parents('svg').index()

//   $('#V_search').fadeOut()
//   $('.map_in').fadeIn()

//   $(this).parents('svg').animate({'top':svgTop - 10}).addClass('on').siblings().removeClass('on')
//   if($(this).parents('svg').hasClass('on')){

//     $(this).parents('svg').css({'top':svgTop })

//   }

//   $('.map_sw img').eq(mapnum).fadeIn()
//   $('.map_sw_1.v1 svg').eq(mapnum).addClass('on').siblings().removeClass('on')

// })



$('#V_map .map_sw_1.v2 path').click(function() {
  let svg = $(this).parents('svg');
  let originalTop = svg.data('originalTop'); // 초기 top 값을 저장하기 위한 변수
  let currentTop = svg.offset().top;
  let mapnum = svg.index();

  // 최초 클릭 시 초기 top 값을 저장
  if (originalTop === undefined) {
      originalTop = currentTop;
      svg.data('originalTop', originalTop);  // originalTop 값 저장
  }

  // top 값을 복구하거나 변경하는 로직
  if (svg.hasClass('on')) {
    svg.css({ 'top': currentTop }).addClass('on').siblings().removeClass('on'); // 원상복구
  } else {
      $('#V_search').fadeOut();
      $('.map_in').fadeIn();

      svg.css({ 'top': originalTop - 10 }).addClass('on').siblings().removeClass('on');

      $('.map_sw img').eq(mapnum).fadeIn();
      $('.map_sw_1.v1 svg').eq(mapnum).addClass('on').siblings().removeClass('on');
  }
});


