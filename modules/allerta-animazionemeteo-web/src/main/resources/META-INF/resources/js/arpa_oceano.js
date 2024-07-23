$(function() {

	var sl, opt, d1, d2, fm, dt
	
	dt = altezzaOndaImg
	dt.sort(function(a, b) { return b._id - a._id  } )
	sl = $("#altezzaOnda")[0]
	fm = "DD/MM/YYYY HH:mm"
	
	for(var a = 0, n = dt.length; a < n; a++) {
	
		opt = document.createElement("option")
		opt.value = dt[a]._id
		opt.innerHTML = dt[a]._text_LOC
		sl.appendChild(opt)
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
		autoPlay: false,
		centeredSlides: true,
		a11y:true,
		navigation: {
			nextEl: '.swiper-button-next',
			prevEl: '.swiper-button-prev',
		},
		grabCursor: true
	});

	// legame con la input del giorno di riferimento
	$(document).on("click",'.map-toolbar__timewheel-player .swiper-container .swiper-slide a', function(e) {
		
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


	animationReset = function () {
		
		if( wheelSwiper ) {
			playable = false;
			wheelSwiper.slideTo(0);
		}
	}		
	
	$("#altezzaOnda").change(function(){
		wheelSwiper.slideTo($(this).val()-1)		
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
	animationPlay = function(){
		if( wheelSwiper && playable){

			if ( wheelSwiper.isEnd ){
				wheelSwiper.slideTo( 0 );
			} else {
				wheelSwiper.slideNext();
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
	
	changeImageTo = function (ix) {		
		
		var img, ix
		
		//ix 	= altezzaOndaImg.length - data.activeIndex - 1
		img = $("#img_animazione_previ")[0]
		img.src = 'data:image/jpg;base64,' + altezzaOndaImg[ix]._imgData
		
		//opt.innerHTML = dt[ix]._text_LOC
		
		txt = $("#text_animazione")[0]
		txt.innerHTML = "Elevazione oceano "+altezzaOndaImg[ix]._text_LOC;
	}	
	
	changeImage = function (data) {		
		
		var img, ix
		
		ix 	= altezzaOndaImg.length - data.activeIndex - 1
		img = $("#img_animazione_previ")[0]
		img.src = 'data:image/jpg;base64,' + altezzaOndaImg[ix]._imgData
		
		//opt.innerHTML = dt[ix]._text_LOC
		
		txt = $("#text_animazione")[0]
		txt.innerHTML = "Elevazione oceano "+altezzaOndaImg[ix]._text_LOC;
	}	

	/*
	animazione meteo
	 */
	$(wheelSwiper).on("wheelchanged.swa.wheel",function(swiper, slideClicked){
		var s, s2, d, m, y, h, mn, ts, img
		
		changeImage(slideClicked)
	})


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
	}

	reinitAnimationWheel = function(hours, future){
		if( wheelSwiper ){
			
			var immagini = altezzaOndaImg
			
			wheelSwiper.removeAllSlides();
			for(var a = immagini.length - 1; a >= 0; a--){

				$("#altezzaOnda")[0].options[a].value = dt[a]._id
				var time = moment(immagini[a]._ts_UTC*1000)
				if(time.isDST())
					time.add(2,'hour');
				else
					time.add(1,'hour');
				label = moment(time).format("DD/MM/YYYY<BR>HH:mm")
				wheelSwiper.appendSlide('<div class="swiper-slide"><a href="#" data-val="'+dt[a]._id+'" data-slide="'+ (n - a - 1) +'">'+label+'</a></div>');
			}

			wheelSwiper.slideTo( n - 1 );
		}
	}			

	var week = [ "Domenica", "Lunedì", "Martedì", "Mercoledì", "Giovedì", "Venerdì", "Sabato" ]

	/*
		animazione-meteo
	 */		
		
		
	if(window.id != null) {
		document.getElementsByClassName("map-animation__timespan")[0].value = (id + 1) * 3;
		reinitAnimationWheel((id + 1) * 3);
	} else
		reinitAnimationWheel();
	
	wheelSwiper.on('slideChange', function () {
		
		console.log('slideChange', wheelSwiper.activeIndex);
		
		//$(wheelSwiper).trigger("wheelchanged.swa.wheel", [wheelSwiper,  wheelSwiper.activeIndex ]);
		//slideChangeHandler(wheelSwiper,  wheelSwiper.activeIndex);
		
		changeImageTo(altezzaOndaImg.length - wheelSwiper.activeIndex - 1);
	});
	
	changeImageTo(altezzaOndaImg.length - 1);
})
/*
	scrolling image
 */

