<%@page import="it.eng.allerta.animazione.bean.AnimazioneMarePioggiaBean"%>
<%@ include file="./init.jsp"%>

<%
	AnimazioneMarePioggiaBean animBean = (AnimazioneMarePioggiaBean) renderRequest.getAttribute("AnimazioneMarePioggiaBean");
%>

<script type="text/javascript">
	var altezzaOndaImg = <%=animBean.elevazioneJson()%>; 	
</script>

<script src="<%=request.getContextPath()%>/js/arpa_oceano.js?v=0.1f"></script>
	
<main class="page main page--previsioni" id="main-content">

	<div class="page__head">
                
        <div class="container d-flex">
            <div class="row w-100 justify-content-between">
                <h1 class="col-12 col-lg-12" >Animazione immagini oceanografiche: elevazione della superficie del mare</h1>
                
                <p class="col-12 lead">
                    
                </p>
            </div>

            
        </div>
        <div class="breadcrumb-container">
            <div class="container d-flex">
                <nav class="row" aria-label="Hai percorso">
                    <ol class="breadcrumb">
        
                       <li class="breadcrumb-item">
                           <a href="/">Home</a>
                       </li>
       
                       <li class="breadcrumb-item active" aria-current="page">Animazione elevazione mare</li>
        
                    </ol>
                </nav>
            </div>
        </div>
   </div>
   
   <div class="container page__body">
   
	 <div class="row">
	 
		<div class="col-12 page__content" id="page-content">

			<p>
				
			</p>
			
			<div class="col-12">

				<div style="text-align: center; padding-bottom: 15px;">

					<div id="text_animazione"></div>
					<img id="img_animazione_previ" alt="Elevazione superficie del mare" src="" />
					
				</div>

			</div>
			
	  </div>
		
	</div>
	
	<div class="row flex-column-reverse flex-md-row map-toolbar">
	
		<div class="col-12 col-md-6">
		
			<div class="map-toolbar__animation">
			
				<div class="form-group map-animation-dropdown">
				
					<label for="animation__timespan--dato-osservato--anim-oceano">
						Animazione </label>
						
					<div class="input-group">
					
						<select  id="altezzaOnda"
							class="form-control map-animation__timespan">
							
						</select>

						 <div class="input-group-append">
						     <a href="#map-toolbar__time-player--dato-osservato--anim-oceano" title="Lancia/Ferma l'animazione"
						         data-source="#animation__timespan--dato-osservato--anim-oceano"
						         data-toggle="animate-data" class="btn btn-primary map-animation__toggle">
						         <span class="icon i-play-rounded-corner map-animation__toggle__play" title="Lancia l'animazione"></span>
						         <span class="icon i-stop map-animation__toggle__stop" title="Ferma l'animazione"></span>
						     </a>
						 </div>
						<!-- 
						<div class="input-group-append">
						
							<div class="btn btn-primary map-animation__toggle">
							
								<a href="#" class="map-animation__toggle__play">
									<i class="fa fa-play"></i>
								</a>
								
							 	<a href="#" class="map-animation__toggle__stop">
									<i class="fa fa-stop"></i>
								</a>
							</div>
						</div>
						-->
					</div>

				</div>
			</div>
		</div>
		
		<!--  
		<div class="col-12 col-md-6">
		
			<div class="map-toolbar__timewheel-player"
				id="#map-toolbar__timewheel-player--dato-osservato--anim-mare">
				
			
				<div class="swiper-container" data-toggle="timewheel">
					<div class="swiper-wrapper">
						
					</div>
				</div>
				
				<div class="swiper-button-prev" aria-disabled="false" tabindex="0" role="button" aria-label="Previous slide"></div>
				
				<div class="swiper-button-next" aria-disabled="false" tabindex="0" role="button" aria-label="Next slide"></div>
				
			</div>
		</div>
		-->
		
  	 	<div class="col-12 col-md-6">
          <div class="map-toolbar__timewheel-player" id="#map-toolbar__timewheel-player--dato-osservato--anim-oceano">
              <div class="swiper-button-prev"></div>
              <div class="swiper-container" data-toggle="timewheel">
                  <div class="swiper-wrapper">
                      <!-- Qui vengono messe le slide via JS in base ai dati ricevuti dal server --->
                  </div>
              </div>
              <div class="swiper-button-next"></div>
          </div>
        </div>
    
		
	</div>	
	
	<div class="row flex-column-reverse flex-md-row">
	
		<div class="col-12 col-md-6">
			<div style="text-align: center;">
			<h2></h2>
			</div>
		</div>
	</div>
	
	<div class="row flex-column-reverse flex-md-row">		
		
		
		<div class="col-6">
			
		</div>
	</div>
	
  </div>	
   
   
  </main> 