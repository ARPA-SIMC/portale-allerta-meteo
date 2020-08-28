/*
* -----
* allerta-meteo UI JS
* -----
* This JS code is needed for the Allerta Meteo Theme UI to work (eg. interaction aspects of the UI).
*
* Details:
* - It's standard: based on jQuery and takes into account that Bootstrap 4 JS is loaded on the page (see requirements
*   in the styleguide for more info)
* - It's modular: each fragment of the following JS code is associated to a UI component of the styleguide (you can 
*   integrate just the one you need, if needed)
* - It's compliant: each fragment is encapsulated in a separate javascript scope (with a jQuery object as input) to 
*   match the framework where it's supposed to run in.
* 
* @author Roberto Maggi <roberto.maggi@eng.it>
* @author Leopoldo Dorigo <leopoldo.dorigo@eng.it>
*/


// menu
(function($) {

  $(document).ready(function(){

    // main menu toggling
    $('.header__nav-toggle, .main-nav__nav-toggle').click(function(e){
      
      e.preventDefault();
      
      $('.main-nav').toggleClass("main-nav--open");
      
      // keep both toggle button sync
      $('.header__nav-toggle').toggleClass("header__nav-toggle--open");
      $('.main-nav__nav-toggle').toggleClass(".main-nav__nav-toggle");

      if( !$(".main-nav").hasClass(".main-nav--open") ){
        $(".main-nav .nav-item .nav").removeAttr("style");
      }
    });

    // main menu sub-menu toggling (just first level item)
    $(".main-nav .nav-link").click(function(e){
      
      if( $(this).next('.nav').length ){ // if not a leaf page, prevent default
        e.preventDefault();
        $('.main-nav').addClass("main-nav--open");
        $('.header__nav-toggle').addClass("header__nav-toggle--open");
        $('.main-nav__nav-toggle').addClass(".main-nav__nav-toggle");

        $(this).next('.nav').slideToggle();
        $(this).closest(".nav-item").toggleClass("nav-item--open");

        // fix aria stuff
        if( $(this).closest(".nav-item").hasClass("nav-item--open") ){
          $('.icon-expand', $(this)).attr("aria-hidden", true);
          $('.icon-collapse', $(this)).attr("aria-hidden", false);
        } else {
          $('.icon-expand', $(this)).attr("aria-hidden", false);
          $('.icon-collapse', $(this)).attr("aria-hidden", true);
        }

      }
    });

  });


})(jQuery);



// upload file 
(function($) {

  function initCampiFile(){
    'use strict';

    ;( function ( document, window, index )
    {
      var inputs = document.querySelectorAll( '.upload-file__input' );
      Array.prototype.forEach.call( inputs, function( input )
      {
        var label  = input.nextElementSibling,
          labelVal = label.innerHTML;

        input.addEventListener( 'change', function( e )
        {
          var fileName = '';
          if( this.files && this.files.length > 1 )
            fileName = ( this.getAttribute( 'data-multiple-caption' ) || '' ).replace( '{count}', this.files.length );
          else
            fileName = e.target.value.split( '\\' ).pop();

          if( fileName )
            label.querySelector( 'span' ).innerHTML = fileName;
          else
            label.innerHTML = labelVal;
        });

        // Firefox bug fix
        input.addEventListener( 'focus', function(){ input.classList.add( 'has-focus' ); });
        input.addEventListener( 'blur', function(){ input.classList.remove( 'has-focus' ); });

        $(input).next().find("a.btn-link").click(function(e){
          e.stopPropagation();
          e.preventDefault();
          $(input).click();
        });
      });
    }( document, window, 0 ));
  }
  initCampiFile();

})(jQuery);


// popover
(function($) {

	if ($('[data-toggle="popover"]').length > 0) {
  
		$('[data-toggle="popover"]').popover({html:true, placement: "auto right"})

		$('body').on('click', function (e) {
			$('[data-toggle="popover"]').each(function () {
      //the 'is' for buttons that trigger popups
      //the 'has' for icons within a button that triggers a popup
				if (!$(this).is(e.target) && $(this).has(e.target).length === 0 &&
						$('.popover').has(e.target).length === 0) {
					$(this).popover('hide');
				}
			});
		});
  
	}

})(jQuery);






// Responsive Swiper
// ---
// It's a Swiper in mobile-first approach, from xs to a breakpoint. 
// It's needed to Carousel component of the UI.
// Three different modes:
// - "full-width", mono-slide carousel 
// - "auto", different width slides, grouping slides above "md" breakpoint
// - "adaptive-carousel", turns the carousel to a a simple list above "md" breakpoint
(function($){

  // breakpoint where swiper will be destroyed
  // and switches to a dual-column layout
  const responsiveSwiperBreakpoint = window.matchMedia( '(min-width: 768px)' );

  // Enable and Disable functions
  function enableSwiper(el, conf){
    var sw = new Swiper( el, conf);
    $(el).data("swiper", sw);
    $(el).data("swiper-conf", sw);
    return sw;
  }
  function disableSwiper(el){
    let sw = $(el).data("swiper");
    if ( sw !== undefined ) sw.destroy( true, true );
    $(el).data("swiper", undefined);
    $(".swiper-pagination", $(el)).html(""); // clean dynamically created pagination
  }

  // Build all needed swipers
  $('[data-toggle=responsive-swiper]').each(function(){

    // get data-attributes
    const mode = $(this).attr("data-swiper-mode");
    var container = $('.swiper-container', $(this));
    if( !container || container.length == 0 && $(this).attr("data-toggle")=='responsive-swiper'){
      container = $(this);
    }

    // define default conf (also a11y)
    var conf = {
      autoHeight: true,
      grabCursor: true,
      pagination:  {
        el: $('.swiper-pagination', $(this)),
        type: 'bullets',
        clickable: true
      },
      a11y: {
        enabled: true,
        prevSlideMessage: 'Elemento precedente della lista',
        nextSlideMessage: 'Elemento successivo della lista',
        firstSlideMessage: 'Primo elemento della lista',
        lastSlideMessage: 'Ultimo elemento della lista',
        paginationBulletMessage: 'Vai all\'elemento {{index}}'
      }
    };

    // specific conf and setup, depending on swiper mode
    switch( mode ){
      case 'adaptive-carousel': // slides width fixed in carousel auto-mode below md, but turn off swiper above md

        // specific conf
        conf.slidesPerView = "auto";
        conf.spaceBetween = 10;

        // Load/unload closure, depending on the breakpoint
        const bpChecker = function(){
            if( responsiveSwiperBreakpoint.matches === true ){ // Above md
              disableSwiper(container);
            } else { // Below md
              enableSwiper(container, conf); 
            }
        };
        
        // setup listener
        responsiveSwiperBreakpoint.addListener(bpChecker);

        // first init
        bpChecker();

        break;
      case 'adaptive-carousel-cols-on-wide': 
        // slides width fixed in carousel auto-mode below md, but 2 or 3 slide per view above md
        // This conf is the one used for Allerta Meteo News ;-)
        
        // Setup slidePerView on the base of the amount of available slides
        var slideCount = $('.swiper-slide', $(this)).length;
        var slidePerView = {};
        switch( slideCount ){
          case 1:
            slidePerView = { md: 1, lg: 1 };
            conf.pagination = false;
            break;
          case 2:
            slidePerView = { md: 2, lg: 2 };
            conf.pagination = false;
            break;
          case 3:
            slidePerView = { md: 2, lg: 3 };
            conf.pagination = false;
            break;
          case 4:
          default:
              slidePerView = { md: 2, lg: 3 };
        }

       
        

        // specific conf
        conf.slidesPerView = "auto";
        conf.spaceBetween = 10;
        conf.breakpointsInverse = true;
        conf.breakpoints = {
          // when window width is >= 768px
          768: {
            slidesPerView: slidePerView.md,
            spaceBetween: 0,
            pagination: false
          },
          // when window width is >= 99px
          992: {
            slidesPerView: slidePerView.lg,
            spaceBetween: 0
          }
        }
        var sw = enableSwiper(container, conf);

        // Setup responsiveness changes 
        function refreshResponsiveness(){
          let sw = $(this).data("swiper");

          if( responsiveSwiperBreakpoint.matches === true ){ // Above md
            // show pagination and more link
            $('.featured-contents__pagination-and-more', $(this)).show();

            // remove the "See more" last slide
            if( $(".swiper-slide--see-more", $(this) ).length ){
              sw.removeSlide( sw.slides.length - 1 );
            }

          } else { // Below md
            // hide pagination and more links
            $('.featured-contents__pagination-and-more', $(this)).hide();
            
            // add a "See more" as a last slide
            if( $(".swiper-slide--see-more", $(this) ).length == 0 )
              sw.appendSlide('<div class="swiper-slide swiper-slide--see-more">'+$('.featured-contents__more', $(this)).html()+'</div>');
          }

          // if no pagination needed, hide it
          // if( !sw.slides.length < 4 ){
          //   $('.swiper-pagination', $(this)).hide();
          // }
        }
        $(window).on("resize", refreshResponsiveness.bind(container) );
        refreshResponsiveness.bind(container).call(); // first check

        break;
      case 'auto': // slides with fixed with, pagination auto

        // specific conf for responsiveness grouping
        conf.slidesPerView = "auto";
        conf.spaceBetween = 1;
        conf.breakpointsInverse = true;
        conf.breakpoints = {
          // when window width is >= 769px (aka BS4 "md")
          // build some grouping style
          769: {
            slidesPerGroup: 3,
            spaceBetween: 5
          }
        }
        enableSwiper(container, conf);

        break;
      case 'full-width': // classic, one slide for page slider
        
        // no other conf needed
        enableSwiper(container, conf);
        break;
    }

  });

})(jQuery);

/**
 *  Internal Index
 * ---
 * Takes all the H2 in a specified context node and setup an internal sticky index with
 * one anchor for each H2 found.
 * 
 *  */
(function($){
  $(document).ready(function(){

    // normalize id
    function normalizeId(str){
      if( str.normalize ){ // IE11 doesn't support normalize :(
        return str.normalize('NFD').replace(/[\u0300-\u036f]/g, "").replace(/\ /gi,"-").replace(/\'/gi,"-").replace(/\"/gi,"").toLowerCase().trim();
      } else {
        return str.toString().toLowerCase()
        .replace(/\s+/g, '-')           // Replace spaces with -
        .replace(/[^\w\-]+/g, '')       // Remove all non-word chars
        .replace(/\-\-+/g, '-')         // Replace multiple - with single -
        .replace(/\"/gi,"")           // Remove all "
        .trim();
      }
      
    }

    // ### Sticky Top Horizontal when < LG
    // Internal Index is sticky on top when below the "lg" breakpoint
    const responsiveStickyTopBreakpoint = window.matchMedia( '(min-width: 992px)' );
    // Handler for the sticyness
    function stickyTopOnScrollHandler(el, fixmeTop){
      var currentScroll = $(window).scrollTop(); // get current position of scroll
      if (currentScroll >= fixmeTop) {

          let conf = null;
           {
            conf = {                      
                position: 'fixed',
                top: 0, //$('.header').offset().top+$('.header').height(),
                left: 0,
                width: $(window).width()
            };
          }

          $(el).css(conf).addClass("sticky-top");
          $(el).data("stickyTopOffset", $(el).height() );
      } else {
          clearStickyTopCss(el);
      }
    }
    // Clear the stickyness
    function clearStickyTopCss(el){
      $(el).css({                      
        position: 'static',
        top: 0,
        left: 0,
        width: 'auto'
      }).removeClass("sticky-top");
      $(el).data("stickyTopOffset", 0);
    }
   
    // ### Sticky Left Vertically when > LG
    // Internal Index is sticky on top-left when abobe the "lg" breakpoint
    const responsiveStickyTopLeftBreakpoint = window.matchMedia( '(min-width: 992px)' );
  

    // For each internal index (it should be just one, but this is generic)
    $('[data-toggle=internal-index]').each(function(){

      // Get all section heading to build the index
      var h2 = $($(this).attr("data-target")).find("h2");
      var i=0, I=h2.length, tmpId=null;

      // Set Body as top anchor
      var bodyId = $('body').attr("id");
      if(!bodyId){
        bodyId = '_body';
        $('body').attr("id", bodyId);
      }
      // Append the "go top" anchor first
      $(this).append('<li class="nav-item"><a class="nav-link active" href="#'+bodyId+'" data-toggle="smooth-scroll">Inizio pagina</a></li>');

      // Loop and create index anchors
      for(;i<I;++i){
        
        // get/set id
        tmpId = $(h2[i]).attr("id");
        if(!tmpId){
          tmpId = "_internal-index-"+normalizeId($(h2[i]).text());
          $(h2[i]).attr("id", tmpId);
        }
        
        // inject html
        $(this).append('<li class="nav-item"><a class="nav-link" href="#'+tmpId+'" data-toggle="smooth-scroll">'+$(h2[i]).text()+'</a></li>');

        
        if( $(h2[i]).parent().hasClass("u-section--highlighted") ){
          $(h2[i]).prepend('<span class="icon i-bell-o" title="Icona della campanella"></span>')
        } else {
          // make the section collapsible
          var collapsible = $('<div class="collapse" id="collapse--'+tmpId+'"></div>').append( $(h2[i]).siblings() );
          $(h2[i]).prepend('<span class="icon i-angle-right"></span>')
          $(h2[i]).after( collapsible );
          $(h2[i]).attr("data-toggle", "collapse");
          $(h2[i]).attr("data-target", '#collapse--'+tmpId+'');

          // note: since on small devices we have the sticky upper index, there's no need to collapse by default the sections
          if( true || responsiveStickyTopLeftBreakpoint.matches === true ){ 
            $(h2[i]).attr("aria-expanded", true);
            $(collapsible).addClass("show");
          } else {
            $(h2[i]).attr("aria-expanded", false);
          }
        }

      }

      // smooth scroll setup
      const headOffset = (( responsiveStickyTopBreakpoint.matches === true )?  $('.header .navbar').height() : 15); // No sticky head on AM (else ti would be so keep just a padding
      $('*[data-toggle=smooth-scroll]').click(function(e){
        e.preventDefault();
        $('html,body').animate({
          scrollTop: $($(this).attr("href")).offset().top - (headOffset + $(this).closest("[data-toggle=internal-index]").data("stickyTopOffset")) * 1.75
        });
      })
      
      
      // Setup the "sticky top on scroll" below "lg".
      var me = $(this); // below lg, stickyness works on the UL element
      // CHANGE THIS: to adjust the index to the header
      // $(me).offset().top+$(".header").height()
      var fixmeTop = $(me).offset().top; // $(".header").height(); 
      var fixmeTopEventHandler = function(){
        stickyTopOnScrollHandler( me, fixmeTop );
      };
      const bpResponsiveStickyTopChecker = function(){
        if( responsiveStickyTopBreakpoint.matches === true ){ // Above md
          $(window).off("scroll", fixmeTopEventHandler);
          clearStickyTopCss(me);
        } else { // Below md
          $(window).scroll(fixmeTopEventHandler);
        }
      };
      // setup listener for stickyness
      responsiveStickyTopBreakpoint.addListener(bpResponsiveStickyTopChecker);
      // first init of top stickyness (in case we load the page below "lg")
      bpResponsiveStickyTopChecker();


      // Setup the "sticky top left on scroll" above "lg". It works like this: 
      // we get a ref to the last visible item of the index and then, using Bootstrap Scrollspy, 
      // we turn the index from position:fixed to position:absolute when users scroll down beyond last visible index item
      // (the last visible index item is the "turning point" from fixed position to temporary absolute positioning 
      var myIndexContainer = $(this).closest(".page__internal-index"); 
      var lastVisibleIndexItem = null;
      var footerTop = $('.footer').offset().top - $(window).height();

      /* The following closure gets the last visibile item of the index base on the current viewport.
       * It assumes that, above LG, the index container (.page__internal-index) has an explicit height,
       * calculated via CSS to be exactly the visible part of the index.
       * This function should also be executed at each window resize.
      */
      function getLastVisibleIndexItem(){
        let ul = $(me);
        let container = $(myIndexContainer); 
        let last = null;
        let nl = $('a', ul),
            i = 0,
            I = nl.length,
            vp = $(container).height(),
            nav = $(ul).parent().position().top ;
        for(;i<I;++i){
          if( nav + $(nl[i]).position().top + $(nl[i]).outerHeight() > vp ){
            last = nl[i];
            break;
          }
        }
        lastVisibleIndexItem = last;
      }
      $(window).resize( getLastVisibleIndexItem ); // set handler
      getLastVisibleIndexItem(); // first exec

      // handler for the scroll (when beyond the limit, go fixed)
      function stickyTopLeftOnScrollHandler(el, fixmeTop){
        var currentScroll = $(window).scrollTop(); // get current position of scroll
        console.log(currentScroll+" >= "+ footerTop);

        if (currentScroll >= fixmeTop) {
          getLastVisibleIndexItem(); // refresh the last visible item
  
          if( currentScroll >= footerTop )
            stickyTopLeftOnScrollHandler_fixedBottomOn();

          


          if( !$(el).hasClass("is-absoluteSticky") ){
            let conf = {                      
                position: 'fixed',
                top: 0,
                //left: $(el).offset().left, 
                //width: $(el).width(),
                "min-width": 0
            };
            $(el).css(conf).addClass("sticky-top");
          } else {
            if(  currentScroll < footerTop ){
              stickyTopLeftOnScrollHandler_fixedBottomOff();
            }
          }
          
        } else{
          clearStickyTopLeftCss(el)
        }
      }
      // Clear the stickyness
      function clearStickyTopLeftCss(el){
        $(el).css({                      
          position: 'absolute',
          top: $(el).data("originalCssTop"),
          //left: 0,
          // width: 'auto'
        }).removeClass("sticky-top");
      }

      function stickyTopLeftOnScrollHandler__absoluteOn(){
        $(myIndexContainer).css({
          "position": "absolute",
          "top": $(myIndexContainer).offset().top - $(myIndexContainer).data("originalOffsetTop")  //- ( parseInt( $(myIndexContainer).css("top"), 10 ))// + $('.header > nav').outerHeight())
        });
        $(myIndexContainer).addClass("is-absoluteSticky");
      }
      function stickyTopLeftOnScrollHandler__absoluteOff(){
        $(myIndexContainer).css({
          "position":"fixed",
          "top": $(myIndexContainer).data("originalOffsetTop")+"px"
        });
        $(myIndexContainer).removeClass("is-absoluteSticky");
      }
      function stickyTopLeftOnScrollHandler_fixedBottomOn(){
        if( ! $(myIndexContainer).hasClass("is-absoluteSticky--onBottom") ){
          $(myIndexContainer).css({
            "position":"absolute",
            "top": $(myIndexContainer).offset().top - $(myIndexContainer).data("originalOffsetTop"), //$('.footer').offset().top - 10
          });
        }
        $(myIndexContainer).addClass("is-absoluteSticky");
        $(myIndexContainer).addClass("is-absoluteSticky--onBottom");
      }
      function stickyTopLeftOnScrollHandler_fixedBottomOff(){
        $(myIndexContainer).css({
          "position":"fixed",
          "top": 0
        });
        $(myIndexContainer).removeClass("is-absoluteSticky");
        $(myIndexContainer).removeClass("is-absoluteSticky--onBottom");
      }

      // get the original offset top position to place the index back where it was
      $(myIndexContainer).data("originalOffsetTop", $(myIndexContainer).offset().top ); // parseInt( $(myIndexContainer).css("top")));
      $(myIndexContainer).data("originalCssTop",  parseInt( $(myIndexContainer).css("top")));

      function fixmeTopLefEventHandler() {
        stickyTopLeftOnScrollHandler(myIndexContainer, fixmeTop)
      }
      // get the current breakpoint state
      var aboveLg = false;
      const bpResponsiveStickyTopLeftChecker = function(){
        aboveLg = responsiveStickyTopLeftBreakpoint.matches === true;
         // Reset sticky styling when changing breakpoint
        if(!aboveLg){
          $(myIndexContainer).css({ "position": "static", "top": "0" });
          $(myIndexContainer).removeClass("is-absoluteSticky");
          $(window).off("scroll", fixmeTopLefEventHandler);
        } else {
          $(myIndexContainer).css({ "position": "", "top": "" });
           $(myIndexContainer).removeClass("is-absoluteSticky");          
          $(window).scroll(fixmeTopLefEventHandler);
        }
      };
      responsiveStickyTopLeftBreakpoint.addListener(bpResponsiveStickyTopLeftChecker);
      // first init of left stickyness (in case we load the page above "lg")
      bpResponsiveStickyTopLeftChecker();


      // Boostrap scrollspy setup
      $('body').attr("data-target", $(this).attr("data-scrollspyTarget"));
      $('body').attr("data-offset", 190);
      $('body').attr("data-spy", "scroll");
      $(window).on('activate.bs.scrollspy', function (e, obj) { // when spying body, the event get fired on window
        let al = $('.active', me).offset().left;
        let aw = $('.active', me).width();
        let w = $(window).width();
      
        // IE11 fix (Bootstrap doesn't provide the second param on IE11)
        if( !obj || !obj.relatedTarget ){
          obj = {};
          obj.relatedTarget = $(e.targetElement).attr("href");
        }

        // Below LG: 
        // keep the active element visible in the viewport, so scroll the index horizontally!
        if( al+aw/2 > w || al < 0){ 
          $(me).animate({ scrollLeft: $(me).scrollLeft()+al-15}, 250);
        }

        // Above LG:
        // when the scrolling reaches the last visible item of the index (or its next sibling), 
        //  then turn the index temporarily position:absolute;
        // when scolling back and reaching the last visibile item (or its prev sibling), 
        //  then turn back to position: fixed
        if( aboveLg ){
          
          if ( !$(myIndexContainer).hasClass("is-absoluteSticky") && 
            ( obj.relatedTarget == $(lastVisibleIndexItem).attr("href") ||
              obj.relatedTarget == $(lastVisibleIndexItem).parent().next().children("a").attr("href") 
            )  ){ // we reached the last visible item
            
            stickyTopLeftOnScrollHandler__absoluteOn();

          } else if( $(myIndexContainer).hasClass("is-absoluteSticky") &&
            ( obj.relatedTarget == $(lastVisibleIndexItem).parent().prev().children("a").attr("href") ||
              obj.relatedTarget == $(lastVisibleIndexItem).attr("href") ) ) { // we're going up above the last visible item

              stickyTopLeftOnScrollHandler__absoluteOff();

          }

        }

      });
      
      $(window).on("resize", function(){
        $("body").scrollspy('refresh');
      });


    });

  });

})(jQuery);


// Responsive collapsible
(function($){

  $(document).ready(function(){

    // Enable and Disable functions
    function enableCollapsible(toggler, target){
      // do collapse
      $( target ).hide();
      $( toggler ).attr("aria-expanded", 'false' );
      $( toggler ).addClass("collapsed");
      // attach handler
      $(toggler).on("click", function(){
        if( $( toggler ).attr("aria-expanded") === 'false'){
          $( toggler ).attr("aria-expanded", 'true' );
          $( toggler ).removeClass("collapsed");
        } else {
          $( toggler ).attr("aria-expanded", 'false' );
          $( toggler ).addClass("collapsed");
        }
        $( target ).slideToggle();
      });

    }
    function disableCollapsible(toggler, target){
      // detach handler
      $(toggler).off("click");
      // do expand
      $(target).show();
      $(toggler).removeClass("collapsed");
      $( toggler ).attr("aria-expanded", 'true' );
    }
    
    // breakpoint where collapsible will be destroyed
    // and switches to a full visible element
    const responsiveCollapsibleBreakpoint = window.matchMedia( '(min-width: 768px)' );

    // Build all needed responsive collapsible
    $('[data-toggle=collapse-down-md]').each(function(){

      // Get the collapsible element
      var target = $( $(this).attr("data-target") );
      var toggler = $(this);
      if( !target ){
        return null;
      }
      // Load/unload closure, depending on the breakpoint
      const bpCollapsibleChecker = function(){
        if( responsiveCollapsibleBreakpoint.matches === true ){ // Above md
          disableCollapsible( toggler, target ); 
        } else { // Below md
          enableCollapsible( toggler, target ); 
        }
      };
      
      // setup listener
      responsiveCollapsibleBreakpoint.addListener(bpCollapsibleChecker);
      
      // first init
      bpCollapsibleChecker();
    });

  });

})(jQuery);






// Wizard simulator
(function($){
  $(document).ready(function(){


    // Simulation of wizard bar
    $('[data-toggle=wizard-bar]').each(function(){
      let wModal = $(this);
      let wBar = $('.wizard-bar', $(this));
      $('.nav-item', wBar).on("select.iol", function(){
        
        // show new step body
        let wStepBody = $(this).attr("data-target");
        $('.modal-fluid--has-wizard__wizard-step').removeClass("active");
        $(wStepBody).addClass("active");

        // update wizard bar
        $(this).addClass("active");
        $(this).addClass("current");
      });
    });

    // FIXME / Remove me
    $('[data-toggle=wizard-back]').click(function(){
      
      let current = $('.wizard-bar .active.current', $(this).closest('.modal-fluid--has-wizard'));
      if( current.length ){
        let prev = $(current).prev();
        if( prev.length ){
          $(current).removeClass("current");
          $(current).removeClass("active");
          $(prev).trigger("select.iol");
        }
        
      }
    });

    // FIXME / Remove me
    $('[data-toggle=wizard-next]').click(function(){
      
      let current = $('.wizard-bar .active.current', $(this).closest('.modal-fluid--has-wizard'));
      
      if( current.length ){
        let next = $(current).next();
        if( next.length ){
          $(current).removeClass("current");
          $(next).trigger("select.iol");
        }
      }
      
    });

    // FIXME
    $('[data-toggle=save-draft]').click(function(){
      
      console.log("Save draft simulation");
      alert("Qui partirebbe la richiesta al server per il salvataggio");
      
    });

    // FIXME
    $('[data-toggle=wizard-end]').click(function(){
      
      console.log("Jump to last step");
      alert("Qui adrebbe all'ultimo passo");
      
    });
    $('[data-toggle=wizard-close]').click(function(){
      console.log("Close modal");
      $('.modal-fluid__close-btn').click();
    });
    $('[data-toggle=wizard-restart]').click(function(){
      let wBar = $('.wizard-bar');
      $('.nav-item', wBar).removeClass("active");
      $('.nav-item', wBar).removeClass("current");
      $('.nav-item:first-child', wBar).trigger("select.iol");
    });


    // Simulation custom
    $('[data-toggle=disable-button]').change(function(){
      if($(this).is(":checked")) {
        $($(this).attr("data-target")).prop("disabled", false);
      } else {
        $($(this).attr("data-target")).prop("disabled", true);
      }
    });




    // Simulate table editing
    $('[data-toggle=wizard-edit-row]').click(function(e){
      e.preventDefault();
      let tr = $(this).closest("tr");
      let field =  $(".js-prototype-iol-simulate-field", tr);
      tr.siblings().addClass("table__tr--disable-editing");
      field.prev().hide();
      field.show();
      $(this).siblings('[data-toggle=wizard-cancel-edit-row], [data-toggle=wizard-save-row]').show();
      $(this).hide();
    });
    $('[data-toggle=wizard-cancel-edit-row]').click(function(e){
      e.preventDefault();
      let tr = $(this).closest("tr");
      let field =  $(".js-prototype-iol-simulate-field", tr);
      field.hide();
      field.prev().show();
      $(this).siblings('[data-toggle=wizard-save-row]').hide();
      $(this).siblings('[data-toggle=wizard-edit-row]').removeAttr("style");
      $(this).hide();
      tr.siblings().removeClass("table__tr--disable-editing");
    });
    $('[data-toggle=wizard-save-row]').click(function(e){
      e.preventDefault();
      let tr = $(this).closest("tr");
      let field =  $(".js-prototype-iol-simulate-field", tr);
      field.hide();
      field.prev().html( $("input", field).val() ).show();
      $(this).siblings('[data-toggle=wizard-cancel-edit-row]').hide();
      $(this).siblings('[data-toggle=wizard-edit-row]').removeAttr("style");
      $(this).hide();
      tr.siblings().removeClass("table__tr--disable-editing");
    });

  });
})(jQuery);



// Print handler
(function($){
  $('[data-trigger=print]').on("click", function(){
    window.print();
  });
})(jQuery);


// Date time picker
(function($){
  $(document).ready(function(){

      
      var dtp = [];
      var d = new Date
      d.setMilliseconds(0)
      d.setSeconds(0)
      d.setMinutes(d.getMinutes()<31?0:30)


      $('[data-toggle=datetimepicker]').each(function(){

        // Do not init date-time-pickers placed inside a MapComponent
        // because they're init with a specific logic inside the MapComponent code
        if( $(this).closest(".map-component").length )
          return;

        // Init
        let x = $(this).datetimepicker({
            //debug: true, // delete me when going online
            locale: 'it',
            icons:{
                time: 'icon i-clock-o',
                date: 'icon i-calendar',
                up: 'icon i-arrow-up',
                down: 'icon i-arrow-down',
                previous: 'icon i-chevron-left',
                next: 'icon i-chevron-right',
                today: 'icon i-calendar-check-o',
                clear: 'icon i-trash',
                close: 'icon i-times'
            },
            focusOnShow: false,
            allowInputToggle: false,
            date: d
        });  
        $(this).datetimepickerAriaPatch(); // patch for ARIA accessibility (keyboard navigation)

        // Store it
        dtp.push(dtp);
      });
    });
})(jQuery);




//Bootstrap stuff setup
(function($){
  $(document).ready(function(){
    // Tooltips
	  if ($('[data-toggle=tooltip]').length > 0) {
		  $('[data-toggle=tooltip]').tooltip();
	  }

    // Move all inner dialog to body on show, to avoid z-indexing stuff
    $('.modal-dialog').parent().on('show.bs.modal', function(e){ 
      
      if( e.relatedTarget ){
        var m = e.relatedTarget.attributes['data-target']; 
        if( !m )
          m = e.relatedTarget.attributes['href'];
        m = $(m.value);
      } else {
        m = $(this); // if triggered via JS, default this is 
      }

      if($(m).hasClass("modal--map-guide") && $('.am').length > 0){
        $(m).appendTo($('am'));
      }else{
        $(m).appendTo('body'); 
      }
    });

    // Prevent any dropdown with collapsible submenu to close when expanding/collapse one inner collapsible
    $('[data-toggle=collapse]').each(function(){
      var dd = $(this).closest(".dropdown");
      $(dd).data("preventClosing", false);
      var pc = function(){
        if( $(dd).data("preventClosing") == true ){
          $(dd).data("preventClosing", false);
          return false;
        }
      };
      $(dd).on( "hide.bs.dropdown", pc );
      $(this).on("mousedown", function(e){
        $(dd).data("preventClosing", true);
      });
    });
      

    // // Avoid double scrollbar on modal-fluid template
    // // It's a JS fix because the modal itself is inside a Liferay Portlet so we
    // // can't rely on a diffent css class on the body
    // if( $('.modal-fluid').length == 1 && !$('body').hasClass("Styleguide") ){
    //   $('body').css("overflow-y", "hidden");
    // }

    // // secondo livello user menu header 
    // $(document).on('click', '.personal-menu', function (e) {
    //   e.stopPropagation();
    // });
  });
})(jQuery);


// Social allerta embed manager
(function($){

  // This functions resize the FB feed and realoads it
  if( $('#facebook-feed').length ){
    var reloadTimeout = null;
    var refreshFB = function(){
      var src = $('#facebook-feed').attr("src");
      var w = $('#facebook-feed').parent().width();
      src = src.split( "&width=");
      src = src[0]+"&width="+w+src[1].substring( src[1].indexOf("&") );
      
      clearTimeout( reloadTimeout );
      reloadTimeout = setTimeout( function(){
        $('#facebook-feed')[0].src = src;
        reloadTimeout = null;
      }, 500);

    };
    // we use it on start and on window resize
    $(window).on("resize", refreshFB );
    $(document).ready(refreshFB);
  }

})(jQuery);


// Social Share tools
(function($){


  var setup = false;
  var countdown = 2;
  function setupShareComponent(){
    if( $('.at-svc-facebook').length > 0 ){
      countdown -= 1;
    } 
    if( countdown == 0 ){
      clearInterval(setup);
    } else return;

    // then substitute AddThis html with ours
    $('.share-component__item').each(function(){
      
      var ch = $(this).attr("data-am-share-channel");
      let dest = null;
      switch(ch){
        case 'fb':
          dest = $('.at-svc-facebook');
          break;
        case 'tw':
          dest = $('.at-svc-twitter');
          break;
        case 'wa':
            dest = $('.at-svc-whatsapp');
          break;
        default:
      }

      $(dest).addClass("share-component__item");
      $(dest).removeAttr("style");
      $(dest).html($(this).html());
      $(this).remove();

      $(this).parent().show();
    });

    // if it's inside a page tool component (with a popover)
    let po = $('.share-component__item').closest( $('.page-tools__share-popover-content') );
    let ct = $('body .am');
    
    if(  po.length > 0 ){

      if( ct.length ==  0){
        ct = $('.am');
      }

      $(po).prev().popover({
        content: $(po),
        html: true,
        placement: 'auto',
        container: ct
      });
    }
  };

  if( $('.share-component__item').length > 0 ){
    setup = setInterval(setupShareComponent, 1000);
  }

  // $('.share-popover').popover();
  

})(jQuery);





// PDF Viewer Modal
(function($){
  $(document).ready(function(){
    $('[data-toggle=pdf-viewer]').click(function(e){
      let url = $(this).attr("href");

      let pdfModal = $('.modal-pdf-viewer');
      if( pdfModal.length ){
        e.preventDefault();
        $('a[data-beforeload=pdf-viewer]',pdfModal).attr("href", url); 
        $('object[data-beforeload=pdf-viewer]',pdfModal).attr("data", url+"#zoom=100");
        $(pdfModal).modal("show");
      }

    });
  });
})(jQuery);

