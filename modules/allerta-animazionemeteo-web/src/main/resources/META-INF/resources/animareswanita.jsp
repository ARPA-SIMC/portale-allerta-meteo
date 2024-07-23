<%@page import="it.eng.allerta.animazione.bean.AnimazioneMarePioggiaBean"%>
<%@ include file="./init.jsp"%>

<%
	AnimazioneMarePioggiaBean animBean = (AnimazioneMarePioggiaBean) renderRequest.getAttribute("AnimazioneMarePioggiaBean");
%>


<script src="<%=renderRequest.getContextPath()%>/js/am.init.map-with-data.js?v=0.3"></script>
	
<main class="page main page--previsioni" id="main-content">

	<div class="page__head">
                
        <div class="container d-flex">
            <div class="row w-100 justify-content-between">
                <h1 class="col-12 col-lg-12" >Previsione altezza onda - modello swanita</h1>
                
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
       
                       <li class="breadcrumb-item active" aria-current="page">Previsione altezza onda - modello swanita</li>
        
                    </ol>
                </nav>
            </div>
        </div>
   </div>
   
   <div class="container page__body">

	<div
		class="map-component map-component--data map-component--dato-osservato--radar"
		id="map-component--dato-osservato--radar>" data-toggle="data-map"
		data-scenarios="swanita">
		
		<div class="map-component__panel">
		
			<div class="row flex-column-reverse flex-md-row map-toolbar" style="">
			
				<div class="col-12 col-md-6">
				
					<div class="map-toolbar__animation" >
					
						<div class="form-group map-animation-dropdown">
						
							<label for="animation__timespan--dato-osservato--swanita">
								Animazione </label>
							<div class="input-group" >
								<select id="animation__timespan--dato-osservato--swanita"
									style="display:none" class="form-control map-animation__timespan"><option
										value="1">Ultima 1 ora</option>
									<option value="2">Ultime 2 ore</option>
									<option value="3">Ultime 3 ore</option>
									<option value="4">Ultime 4 ore</option>
									<option value="5">Ultime 5 ore</option>
									<option value="6">Ultime 6 ore</option>
									<option value="7">Ultime 7 ore</option>
									<option value="8">Ultime 8 ore</option>
									<option value="9">Ultime 9 ore</option>
									<option value="10">Ultime 10 ore</option>
									<option value="11">Ultime 11 ore</option>
									<option value="12">Ultime 12 ore</option>
									<option value="13">Ultime 13 ore</option>
									<option value="14">Ultime 14 ore</option>
									<option value="15">Ultime 15 ore</option>
									<option value="16">Ultime 16 ore</option>
									<option value="17">Ultime 17 ore</option>
									<option value="18">Ultime 18 ore</option>
									<option value="19">Ultime 19 ore</option>
									<option value="20">Ultime 20 ore</option>
									<option value="21">Ultime 21 ore</option>
									<option value="22">Ultime 22 ore</option>
									<option value="23">Ultime 23 ore</option>
									<option value="24">Ultime 24 ore</option></select>
								
								<div class="input-group-appendx">
								
									<a href="#map-toolbar__time-player--dato-osservato--nowcasting"
										title="Lancia/Ferma l'animazione"
										data-source="#animation__timespan--dato-osservato--nowcasting"
										data-toggle="animate-data"
										class="btn btn-primary map-animation__toggle"> 
										
										<span
											class="icon i-play-rounded-corner map-animation__toggle__play"
											title="Lancia l'animazione">
										</span> 
										
										<span
											class="icon i-stop map-animation__toggle__stop"
											title="Ferma l'animazione">
										</span>
									</a>
								</div>
							</div>

						</div>
					</div>
				</div>
				<div class="col-12 col-md-6">
				
					<div class="map-toolbar__timewheel-player"
						id="#map-toolbar__timewheel-player--dato-osservato--swanita">
						
						<div class="swiper-button-prev" tabindex="0" role="button"
							aria-label="Previous slide" aria-disabled="false"></div>
							
						<div
							class="swiper-container swiper-container-initialized swiper-container-horizontal"
							data-toggle="timewheel" style="cursor: grab;">
							
							<div class="swiper-wrapper"
								style="transition-duration: 0ms; transform: translate3d(108px, 0px, 0px);">
								<!-- Qui vengono messe le slide via JS in base ai dati ricevuti dal server --->
							</div>
							
							<span class="swiper-notification" aria-live="assertive"
								aria-atomic="true"></span>
						</div>
						
						<div class="swiper-button-next" tabindex="0" role="button"
							aria-label="Next slide" aria-disabled="false"></div>
							
					</div>
				</div>
			</div>
		</div>
		
		<div
			class="u-map-section__map-side map-component__map leaflet-container leaflet-touch leaflet-fade-anim leaflet-grab leaflet-touch-drag leaflet-touch-zoom"
			id="map--animazione--radar" tabindex="0">
			
			
			<div class="leaflet-control-container2">
				<div class="leaflet-top leaflet-left">
					<div class="map-legend-control leaflet-control">
						<div class="d-flex">
							<div class="d-none d-md-flex d-print-flex flex-md-row">
								<div class="map-legend--rtdata-legend">
									<strong>Previsione altezza onda (m)</strong>
									<div id="legenda" class="row" style="margin-left:0px;margin-right:0px"><div class="col s2 legendario truncate" style="background-color: #C0F0F8; color: #000000">0.0-0.1</div><div class="col s2 legendario truncate" style="background-color: #73A2FF; color: #000000">0.1-0.5</div><div class="col s2 legendario truncate" style="background-color: #0080FF; color: #ffffff">0.5-0.8</div><div class="col s2 legendario truncate" style="background-color: #42B5A6; color: #000000">0.8-1.25</div><div class="col s2 legendario truncate" style="background-color: #A2F190; color: #000000">1.25-1.8</div><div class="col s2 legendario truncate" style="background-color: #00FF00; color: #000000">1.8-2.5</div><div class="col s2 legendario truncate" style="background-color: #FFFF00; color: #000000">2.5-3.2</div><div class="col s2 legendario truncate" style="background-color: #FFAF00; color: #000000">3.2-4.0</div><div class="col s2 legendario truncate" style="background-color: #FF8000; color: #000000">4.0-5.0</div><div class="col s2 legendario truncate" style="background-color: #FF0014; color: #ffffff">5.0-6.0</div><div class="col s2 legendario truncate" style="background-color: #DB001E; color: #ffffff">6.0-7.0</div><div class="col s2 legendario truncate" style="background-color: #B80009; color: #ffffff">7.0-9.0</div><div class="col s2 legendario truncate" style="background-color: #9B0006; color: #ffffff">9.0-14.0</div></div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="leaflet-top leaflet-right">
					<div class="leaflet-control-search leaflet-control"
						style="display: none;">
						<label class="search-input" for="searchtext9"
							autocomplete="new-password" style="display: none;"></label><input
							class="search-input" type="text" size="9"
							autocomplete="new-password" autocapitalize="off"
							placeholder="Search..." id="searchtext9" style="display: none;">
						<ul class="search-tooltip" style="display: none;"></ul>
						<a class="search-cancel" href="#" title="Cancel"
							style="display: none;"><span></span></a><a class="search-button"
							href="#" title="Search..."></a>
						<div class="search-alert" style="display: none;"></div>
					</div>
				</div>
				<div class="leaflet-bottom leaflet-left">
					<div class="map-data-loading leaflet-control"
						style="display: none;">
						<span class="icon i-spinner" title="Caricamento dati in corso"></span>
					</div>
					<div class="map-legend-control leaflet-control" style="display:none">
						<div class="d-flex">
							<div class="map-legend">
								<a href="#" class="d-block" data-toggle="modal"
									data-target="#modal--guida-mappa-dato-osservato"> <span
									class="icon i-info-circle" title="Info"></span> <span>
										Guida alla mappa </span>
								</a>
							</div>
						</div>
					</div>
				</div>
				<div class="leaflet-bottom leaflet-right">
					<div class="leaflet-control-zoom leaflet-bar leaflet-control">
						<a class="leaflet-control-zoom-in" href="#" title="Zoom in"
							role="button" aria-label="Zoom in">+</a><a
							class="leaflet-control-zoom-out" href="#" title="Zoom out"
							role="button" aria-label="Zoom out"></a>
					</div>
					<div class="leaflet-control-attribution leaflet-control">
						<a href="https://leafletjs.com"
							title="A JS library for interactive maps">Leaflet</a> | © <a
							href="https://openstreetmap.org">OpenStreetMap</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	
  </div>	
   
   
  </main> 