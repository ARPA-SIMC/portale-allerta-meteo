
//$(function() {
	
	
$( document ).ready(function() {
	
	if (typeof(wheelSwiper) !== "undefined" ) {
		wheelSwiper.destroy();
    }

	wheelSwiper = new Swiper('.map-toolbar__timewheel-player .swiper-container', {
		direction: 'horizontal',
		slidesPerView: 5,
		spaceBetween: 8,
		initialSlide: 6,
		breakpoints:{
			640:{
				slidesPerView: 3,
				spaceBetween: 5,
			},
	
		},
		autoPlay: false, //300
		centeredSlides: true,
		a11y:true,
		navigation: {
			nextEl: '.swiper-button-next',
			prevEl: '.swiper-button-prev',
		},
		grabCursor: true,
		on: {
            lazyImageReady: function () {
            	this.autoplay.stop();
            }
        }
	});
	
	
	// legame con la input del giorno di riferimento
	$(document).on("click",'.map-toolbar__timewheel-player .swiper-container .swiper-slide a', function(e){
		
		e.preventDefault();
		
		if( $(this).attr("data-slide") == 'false'){
			return;
		}
		
		var me = parseInt($(this).attr("data-slide"));
		
		if ( me < wheelSwiper.activeIndex)
			wheelSwiper.slideTo( me );
		else 
			wheelSwiper.slideTo( me );

		// Qua è dove triggero l'evento della slide cliccata
		$(wheelSwiper).trigger("wheelchanged.swa.wheel", [wheelSwiper, me]);

	});


	animationReset = function (){
		if( wheelSwiper ){
			playable = false;
			wheelSwiper.slideTo(0);
		}
	}		
	
	reinitAnimationWheel = function(hours, step, future) {
		
		if( wheelSwiper ){

			if( !step )
				step = 15;

			var now =  moment(); //.format("DD/MM/YYYY HH:mm");
			var start = now.subtract(hours,"h");


			var i=0, I = hours * (60/step); // default step of 15minutes
			var unit = "m";
			var label = "";
			wheelSwiper.removeAllSlides();
			for(;i<I;++i){

				if( future ){
					label = start.add( step, unit).format("DD/MM/YY HH:mm");
					wheelSwiper.appendSlide('<div class="swiper-slide"><a href="#" data-val="'+label+'" data-slide="'+(wheelSwiper.activeIndex+i)+'">'+label+'</a></div>');
				} else {
					label = start.subtract( step, unit).format("DD/MM/YY HH:mm");
					wheelSwiper.prependSlide('<div class="swiper-slide"><a href="#" data-val="'+label+'" data-slide="'+(I-i-1)+'">'+label+'</a></div>');
				}
			}

			if( future )
				wheelSwiper.slideTo( 0 );
			else
				wheelSwiper.slideTo( I -1 );
		}
	}
	
	$(".map-animation__timespan").change(function(){
		animationReset();
		reinitAnimationWheel( parseInt($(this).val()) ); 
	});

	$('.map-animation__toggle__play').click(function(e){
		
		e.preventDefault();
		$(this).parent().addClass("active");

		// play animation
		
		playable = !playable;
		
		animationPlay();
	});
	
	$('.map-animation__toggle__stop').click(function(e){
		e.preventDefault();
		// stop animation
		animationStop();
		$(this).parent().removeClass("active");
	});

	// Legame tra animazione e ruota (se presente)
	// Questa è una parte di logica che non posso sviluppare io
	var playable = false;
	animationPlay = function() {
			
		if( wheelSwiper && playable){

			if ( wheelSwiper.isEnd ){
				wheelSwiper.slideTo( 0 );
			} else {
				wheelSwiper.slideNext();
				
				//$(wheelSwiper).trigger("wheelchanged.swa.wheel", [wheelSwiper,  wheelSwiper.activeIndex ]);
				
			}

			// Cambia l'immagine dell'animazione e/o la mappa
			// TODO: qui attaccateci le robe vostre

			if( wheelSwiper.isEnd ){
				$('.map-animation__toggle__stop').trigger("click");
			}else{
				setTimeout(animationPlay, 1000);
			}

		}
	}
	
	animationStop = function(){
		playable = false;
	}

	changeImage = function (data) {				
		image_layer.setSource(
				new ol.source.ImageStatic({
					url: 'data:image/png;base64,' + data,
					imageSize: [4096,2048],
					imageExtent: ol.extent.applyTransform(img_ext,ol.proj.getTransform("EPSG:4326","EPSG:3857")),
					projection: map.getView().getProjection()
				})
		)
	};	


	/*
	animazione meteo
	 */
	$(wheelSwiper).on("wheelchanged.swa.wheel",function(swiper, slideClicked){
		
		var s, s2, d, m, y, h, mn, ts, img

		//s = $($(slideClicked)[0].container.get()[0].getElementsByClassName("swiper-slide-active")[0].childNodes[0]).text()
		s = $(slideClicked.el.childNodes[1].getElementsByClassName('swiper-slide-active')[0]).text();
		if( s == '') return;
		d = +s.slice(0, 2)	
		m = +s.slice(3, 5) - 1
		y = +("20" + s.slice(6, 8))

		s2 = s.split(/[\s\n\r]+/)[1]
		h  = +s2.split(":")[0] 
		mn = +s2.split(":")[1]
		ts = +new Date(+new Date(y, m, d, h, mn) + (new Date).getTimezoneOffset() * 60 * 1000)

		img = img_data[ts]
		changeImage(slideClicked)
	})
	
	function slideChangeHandler(swiper, slideClicked) {
		
		var s, s2, d, m, y, h, mn, ts, img

		//s = $($(slideClicked)[0].container.get()[0].getElementsByClassName("swiper-slide-active")[0].childNodes[0]).text()
		//s = $(slideClicked.el.childNodes[1].getElementsByClassName('swiper-slide-active')[0]).text();
		s = $(swiper.el.childNodes[1].getElementsByClassName('swiper-slide-active')[0]).text();
		if( s == '') return;
		d = +s.slice(0, 2)	
		m = +s.slice(3, 5) - 1
		y = +("20" + s.slice(6, 8))

		s2 = s.split(/[\s\n\r]+/)[1]
		h  = +s2.split(":")[0] 
		mn = +s2.split(":")[1]
		ts = +new Date(+new Date(y, m, d, h, mn) + (new Date).getTimezoneOffset() * 60 * 1000)

		img = img_data[ts]
		//changeImage(slideClicked);
		changeImageByIndex(slideClicked);
				//$(swiper.el.childNodes[1].getElementsByClassName('swiper-slide-active')[0])[0].childNodes[0].attributes['data-actindex'].nodeValue
	}


	var immagini 	= []
	var img_data	= {}
	var img_ext		= null

	initImages = function(data, extents) {
		var pid

		img_data 	= data
		img_ext		= extents
		for(var id in data) {
			pid = +id * 1000
			immagini.push(pid)
			img_data[pid] = data[id]
		}

		immagini.sort()
	};

	reinitAnimationWheel = function(hours, future) {
		
		if( wheelSwiper ){

			var now =  moment(); //.format("DD/MM/YYYY HH:mm");
			var start = now.subtract(hours,"h");
			var ts = +start

			for(var a = 0; a < immagini.length; a++)
				if(immagini[a] >= ts)
					break
					//console.log(a + ":" + ts + ":" + immagini[immagini.length - 1]);
					var unit = "m";
			var label = "";
			var i = a
			var n = immagini.length - a + 1
			wheelSwiper.removeAllSlides();
			for(a = immagini.length - 1; a >= i; a--){

				if( future ){
					label = moment(new Date(immagini[a])).format("DD/MM/YY HH:mm");
					wheelSwiper.appendSlide('<div class="swiper-slide"><a href="#" data-val="'+label+'" data-slide="'+(wheelSwiper.activeIndex+i)+'">'+label+'</a></div>');
				} else {
					label = moment(new Date(immagini[a])).format("DD/MM/YY HH:mm");
					wheelSwiper.prependSlide('<div class="swiper-slide"><a href="#" data-val="'+label+'" data-slide="'+ (a - i) +'">'+label+'</a></div>');
				}
			}

			if( future )
				wheelSwiper.slideTo( 0 );
			else
				wheelSwiper.slideTo( i - 1 );
		}
	}			

	var week = [ "Domenica", "Lunedì", "Martedì", "Mercoledì", "Giovedì", "Venerdì", "Sabato" ]

/*
	animazione-meteo
 */		
	reinitAnimationWheel = function(index){
		if( wheelSwiper ){
			var d

			wheelSwiper.removeAllSlides();
			d = new Date;
			d.setHours(0)

			index = index / 3 - 1
			for(a = index; a >= 0; a--){					
				label = week[(new Date(+d + (a + 1) * 3 * 60 * 60 * 1000)).getDay()] + "<br>ore " + moment(new Date(+d + (a + 1) * 3 * 60 * 60 * 1000)).format("H") + " UTC";
				wheelSwiper.prependSlide('<div class="swiper-slide"><a href="#" data-val="'+label+'" data-actindex="' + index + '" data-slide="'+ a  +'">'+label+'</a></div>');
			}

			wheelSwiper.slideTo( index );
			//changeImage({ activeIndex: index })
			changeImageByIndex(index);
		}
	}
	
	changeImageByIndex = function( activeIndex) {
		
		var img

		document.getElementById("image-label").innerHTML = $(".swiper-slide-active a").attr("data-val").replace("<br>", " ")
		img = document.getElementById("img_animazione_previ")
		img.src = "data:image/png;base64," + testImg[activeIndex]._data
	}
	
	changeImage = function (node) {				
		var img

		document.getElementById("image-label").innerHTML = $(".swiper-slide-active a").attr("data-val").replace("<br>", " ")
		img = document.getElementById("img_animazione_previ")
		img.src = "data:image/png;base64," + testImg[node.activeIndex]._data
	}	
	
	if(window.id != null) {
		
		document.getElementsByClassName("map-animation__timespan")[0].value = (id + 1) * 3;
		
		reinitAnimationWheel((id + 1) * 3);
		
		wheelSwiper.on('slideChange', function () {
			
			console.log('slideChange',[wheelSwiper,  wheelSwiper.activeIndex ]);
			
			//$(wheelSwiper).trigger("wheelchanged.swa.wheel", [wheelSwiper,  wheelSwiper.activeIndex ]);
			slideChangeHandler(wheelSwiper,  wheelSwiper.activeIndex);
		});
		
		console.log('autoplay running : ' , wheelSwiper.autoplay.running);
		
		
	}
	
	
	});

//})





/*
	scrolling image
 */

