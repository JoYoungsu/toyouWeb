$(document).ready(function(){

    
    $(function(){
        var $slider = $('.slider'),
            $firstSlide = $slider.find('li').first() 
            .stop(true).animate({'opacity':1},200); 
      
        function PrevSlide(){ 
          stopSlide();startSlide(); 
          var $lastSlide = $slider.find('li').last() 
          .prependTo($slider); 
          $secondSlide = $slider.find('li').eq(1)
          .stop(true).animate({'opacity':0},800); 
          $firstSlide = $slider.find('li').first() 
          .stop(true).animate({'opacity':1},800);
        }
        
        function NextSlide(){ 
          stopSlide();startSlide(); 
          $firstSlide = $slider.find('li').first() 
          .appendTo($slider); 
          var $lastSlide = $slider.find('li').last() 
          .stop(true).animate({'opacity':0},800); 
          $firstSlide = $slider.find('li').first()
          .stop(true).animate({'opacity':1},800);
        }
        
        $('#next').on('click', function(){ 
          NextSlide();
        });
        $('#prev').on('click', function(){ 
          PrevSlide();
        });
      
        startSlide();
        var theInterval;
      
        function startSlide() {
          theInterval = setInterval(NextSlide, 5000); 
        }
      
        function stopSlide() { 
          clearInterval(theInterval);
        }
        
        $('.slider').hover(function(){
          stopSlide();
        }, function (){
          startSlide();
        });
      });
      
      Resources
    
})

