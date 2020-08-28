
//Search handler
(function($){
  
	
  var Search = function(el){
    var debug = false;
    var focusingOnResults = false;
    var results = $(el).attr("data-results");
    var results__list = $(".search-menu__results__list" , results).first();
    var minSearchLength = 3;
    var searchApi = '/o/api/allerta/group/search-groups';
    var keyMap = {
        'up': 38,
        38: 'up',
        'down': 40,
        40: 'down',
        'left': 37,
        37: 'left',
        'right': 39,
        39: 'right',
        'tab': 9,
        9: 'tab',
        'escape': 27,
        27: 'escape',
        'enter': 13,
        13: 'enter',
        'pageUp': 33,
        33: 'pageUp',
        'pageDown': 34,
        34: 'pageDown',
        'shift': 16,
        16: 'shift',
        'control': 17,
        17: 'control',
        'space': 32,
        32: 'space',
        't': 84,
        84: 't',
        'delete': 46,
        46: 'delete',
        'backspace': 8,
        8: 'backspace'
    };
    var 
      onKeydown = function(e){
        var key = (event.keyCode ? event.keyCode : event.which); 

        if( key == keyMap['tab'] && $(".search-menu__results__item", results).length ){
          e.preventDefault(),
          focusingOnResults = true;
          $(".search-menu__results__item", results)[0].focus();
          return;
        }


      }, 
      onKeyUp = function(e){
        var key = (event.keyCode ? event.keyCode : event.which); 
        
        if (key == keyMap['enter']) {
        	if ($(".search-menu__results__item", results).length) {
        		e.preventDefault();
        		window.location = $(".search-menu__results__item", results)[0].href
        		return;
        	}
        }

        if( key == keyMap['escape']){
          return onBlur();
        }

        if( key == keyMap['delete'] ||  key == keyMap['backspace']){
          if( $(this).val().length == 0 ){
            if( !debug ) 
              hide();
          } else if( $(this).val().length < minSearchLength ){
            $(results__list).html('<p class="p-2">Digita  3 caratteri per cercare il comune.</p>');
          }
        }

        var target = $(this).val();

        if( target.length >= minSearchLength ){
          $.ajax({
              url: searchApi,
              dataType : "json",
              data: {
            	  placeName: target,
            	  p_auth: Liferay.authToken
              },
              method: 'get',
              contentType: "application/json; charset=utf-8",
              success: action = function(data) {

                var i=0,I=data.length, out = '';
                for(;i<I;++i){
                  out += '<a class="search-menu__results__item" href="'+data[i].href+'" '
                  +   ' title="Vai a '+data[i].place+'">'
                  +   '<div class="icon i-map-marker" aria-hidden="true"></div>'
                  +   '<div>'+data[i].place+'</div>'
                  +   (data[i].isFavourite ? '<div class="icon i-heart u-favourite-icon" title="Luogo preferito"></div>':'')
                  + '</a>';
                }
                $(results__list).html( out );
                show();
              },
              error: function (error) {
                alert('[Search] Error in calling the server: ' + eval(error));
              }
          });
        }
      },
      onFocus = function(e){
        e.preventDefault();
        if( $(this).attr("data-islogged") || $(this).val().length >= minSearchLength ){
          // if logged, echo favourite places
          show(); 

        }

        
      },
      onBlur = function(e){
        if( !debug && !focusingOnResults){
          hide();
          focusingOnResults = false;
        } 
          
      },
      show = function(){
    	  
    	  console.log( 'results__list',  $(results__list).html().length);
    	  
    	  if( $(results__list).html().length > 0) {
    		  console.log('showing');
    		  $(results).show();
    		  $(results).addClass("d-print-block"); 
    	  }
      },
      hide = function(){
        $(results).hide();
        $(results).removeClass("d-print-block"); 
      };


    $(el).on("focus", onFocus);
    $(el).on("keydown", onKeydown);
    $(el).on("keyup", onKeyUp);
    $(el).on("blur", onBlur);
    $(el).on("mousedown", function(e){
      e.stopPropagation();
    })
    $(results).on("mousedown", function(e){
      e.preventDefault();
    })
    
  };

  

  $('[data-toggle=search]').each(function(){
    $(this).on("click", function(){
      $( $(this).attr("href") ).toggle();
      $('#search-menu-box')[0].focus();
    })
  });


  $('[data-trigger=search]').each(function(){
	  new Search($(this));
	});

	
})(jQuery);
