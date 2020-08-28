
// styleguide-search
if(console) console.log("[StyleguideJS] Hello world, I'm here!");

// search
(function($){

    $(document).ready(function () {


        if( $('[data-toggle="styleguide-search"]').length > 0){

            $('[data-toggle="styleguide-search"]').closest("form").on("submit", function(){
                return false;
            });

            $('[data-toggle="styleguide-search"]').keydown(function(){
                let t = jQuery.trim($(this).val()).toLowerCase(); 
                
                // show the list
                if(!$('.row-offcanvas-left').hasClass("active"))
                    $('.row-offcanvas-left').addClass("active");

                
                if( t == '' ){
                    // show all if none is searched
                    $('.sidebar__nav nav a').show();
                    $('[data-toggle="styleguide-search-clear"]').removeClass("d-flex");
                } else {
                    // hide all non matching items
                    $('.sidebar__nav nav nav a').filter(function(index, el){
                        return $(el).text().toLowerCase().indexOf( t ) < 0;
                    }).hide();
                    $('[data-toggle="styleguide-search-clear"]').addClass("d-flex");
                }
            });
            $('[data-toggle="styleguide-search-clear"]').click(function(){
                $('[data-toggle="styleguide-search"]').val("");
                $('.sidebar__nav nav a').show();
                $(this).removeClass("d-flex");
                $('[data-toggle="styleguide-search"]').focus();
            });
        }

    });

    
})(jQuery);


// offcanvas
(function($) {

    $(document).ready(function () {
        $('[data-toggle="offcanvas"]').click(function () {
            $('.row-offcanvas').toggleClass('active')
        });
    });

})(jQuery);
