
	$( document ).ready(function() {

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
	        grabCursor: true,
	        onSlideChangeEnd: function(sw){
	        	// Qua triggero l'evento della slide cliccata: anche se è uno slide end, per la UX è lo stesso evento
				$(sw).trigger("wheelchanged.swa.wheel", [sw, sw.activeIndex]);
	        }
	        	
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
		

		animationReset = function (){
			if( wheelSwiper ){
				playable = false;
				wheelSwiper.slideTo(0);
			}
		}
		
		reinitAnimationWheel = function(hours, step, future){
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
					$('.dati-filter__animation__toggler__stop').trigger("click");
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
						imageSize: [549,303],
						imageExtent: ol.extent.applyTransform(img_ext,ol.proj.getTransform("EPSG:4326","EPSG:3857")),
						projection: map.getView().getProjection()
					})
			)
		};	
	
		changeImageTo = function (idx) {
			
			image_layer.setSource(
			
					new ol.source.ImageStatic({
						url: 'data:image/png;base64,' + img_data[idx],
						imageSize: [549,303],
						imageExtent: ol.extent.applyTransform(img_ext,ol.proj.getTransform("EPSG:4326","EPSG:3857")),
						projection: map.getView().getProjection()
					})
			)
		};	

		$(wheelSwiper).on("wheelchanged.swa.wheel",function(swiper, slideClicked){
			
			var s, s2, d, m, y, h, mn, ts, img
			
			//s = $($(slideClicked)[0].container.get()[0].getElementsByClassName("swiper-slide-active")[0].childNodes[0]).text()
			s = $(slideClicked.el.childNodes[1].getElementsByClassName('swiper-slide-active')[0]).text();
			d = +s.slice(0, 2)	
			m = +s.slice(3, 5) - 1
			y = +("20" + s.slice(6, 8))
			
			s2 = s.split(/[\s\n\r]+/)[1]
			h  = +s2.split(":")[0] 
			mn = +s2.split(":")[1]
			ts = +new Date(+new Date(y, m, d, h, mn))
			
			img = img_data[ts]
			changeImage(img)
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
	};

	reinitAnimationWheel = function(hours, step, future){
		if( wheelSwiper ){
			
			if( !step )
				step = 15;
			
			var now =  moment(); //.format("DD/MM/YYYY HH:mm");
			var start = now.subtract(hours,"h");
			var ts = +start
			
			for(var a = 0; a < immagini.length; a++)
				if(immagini[a] >= ts)
					break;
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

	initImages(elenco_img, bounds)
	reinitAnimationWheel(1)
	
	wheelSwiper.on('slideChange', function () {
		
		console.log('slideChange', wheelSwiper.activeIndex);
		
		//$(wheelSwiper).trigger("wheelchanged.swa.wheel", [wheelSwiper,  wheelSwiper.activeIndex ]);
		//slideChangeHandler(wheelSwiper,  wheelSwiper.activeIndex);
		
		changeImageTo(immagini.length - wheelSwiper.activeIndex - 1);
	});
	
	//changeImageTo(immagini.length - 1);
	
	$(".dati-filter__animation__select").change(function(){
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
  
})
