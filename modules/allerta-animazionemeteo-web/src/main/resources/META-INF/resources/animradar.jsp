<%@ include file="./init.jsp"%>
<%@page import="it.eng.allerta.utils.AllertaTracker"%>
<%@page import="it.eng.allerta.configuration.DocumentazioneConfiguration"%>
<%
DocumentazioneConfiguration doc = AllertaTracker.getDocumentazioneConfiguration();

%>

<main class="page main page--previsioni" id="main-content">

<section id="map-section--dato-osservato--radar" class="container map-section map-section--full-width">

<div class="map-section__body">
	<div
		class="map-component map-component--data map-component--dato-osservato--radar"
		id="map-component--dato-osservato--radar" data-toggle="data-map"
		data-scenarios="radar">
		
		<div class="map-component__panel">
		
			<div class="row flex-column-reverse flex-md-row map-toolbar">
			
				<div class="col-12 col-md-6">
				
					<div class="map-toolbar__animation">
					
						<div class="form-group map-animation-dropdown">
						
							<label for="animation__timespan--dato-osservato--radar">
								Animazione </label>
							<div class="input-group">
								<select id="animation__timespan--dato-osservato--radar"
									class="form-control map-animation__timespan"><option
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
								
								<div class="input-group-append">
								
									<a href="#map-toolbar__time-player--dato-osservato--radar"
										title="Lancia/Ferma l'animazione"
										data-source="#animation__timespan--dato-osservato--radar"
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
						id="#map-toolbar__timewheel-player--dato-osservato--radar">
						
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
			
			
			<div class="leaflet-control-container">
				<div class="leaflet-top leaflet-left">
					<div class="map-legend-control leaflet-control">
						<div class="d-flex">
							<div class="d-none d-md-flex d-print-flex flex-md-row">
								<div class="map-legend--rtdata-legend">
									<strong>Radar (stima della pioggia)</strong>
									<div class="legend-image">
										<span class="legend-measure-el"> <span
											class="legend-measure-el__color"
											style="background-color: #006 !important;"></span> <span
											class="legend-measure-el__label">A tratti</span>
										</span> <span class="legend-measure-el"> <span
											class="legend-measure-el__color"
											style="background-color: #0f0 !important;"></span> <span
											class="legend-measure-el__label">Debole</span>
										</span> <span class="legend-measure-el"> <span
											class="legend-measure-el__color"
											style="background-color: #ff0 !important;"></span> <span
											class="legend-measure-el__label">Media</span>
										</span> <span class="legend-measure-el"> <span
											class="legend-measure-el__color"
											style="background-color: #f00 !important;"></span> <span
											class="legend-measure-el__label">Forte</span>
										</span> <span class="legend-measure-el"> <span
											class="legend-measure-el__color"
											style="background-color: #9d18ff !important;"></span> <span
											class="legend-measure-el__label">Intensa</span>
										</span>
									</div>
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
					<div class="map-legend-control leaflet-control">
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


<div class="modal  fade modal--map-guide modal--map-guide--rtdata" id="modal--guida-mappa-dato-osservato" tabindex="-1" role="dialog" aria-labelledby="modal-guida-mappa-osservato-title" style="display: none;" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="modal-guida-mappa-osservato-title">Guida alla mappa</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-lead">
                I livelli di criticità di ogni fenomeno si basano su soglie e valutazioni differenti.<br> 
                Questa è una breve guida alla lettura della mappa.
            </div>
            <div class="modal-body">
                <div class="row flex-lg-column">
                    
                        <div class="col-12 col-lg-7 mb-4" data-if="legend" data-when="rtdata" style="display: block;">
                            <h6>Legenda dati osservati mostrati sulla mappa</h6>
                            <ul class="mb-md-2 nav map-legend__rtdata-guides flex-column">                       
                                <li class="nav-item" data-if="legend" data-when="radar" style="display: list-item;">
                                    <div class="nav-span d-flex flex-column mb-3">
                                        <strong>Radar (stima della pioggia)</strong>
                                            <div class="legend-image"> <span class="legend-measure-el"> <span class="legend-measure-el__color" style="background-color: #006 !important;"></span> <span class="legend-measure-el__label">A tratti</span> </span> <span class="legend-measure-el"> <span class="legend-measure-el__color" style="background-color: #0f0 !important;"></span> <span class="legend-measure-el__label">Debole</span> </span> <span class="legend-measure-el"> <span class="legend-measure-el__color" style="background-color: #ff0 !important;"></span> <span class="legend-measure-el__label">Media</span> </span> <span class="legend-measure-el"> <span class="legend-measure-el__color" style="background-color: #f00 !important;"></span> <span class="legend-measure-el__label">Forte</span> </span> <span class="legend-measure-el"> <span class="legend-measure-el__color" style="background-color: #9d18ff !important;"></span> <span class="legend-measure-el__label">Intensa</span> </span> </div>
                                    </div>
                                </li>
                                <li class="nav-item" data-if="legend" data-when="vento" aria-hidden="true" style="display: none;">
                                    <div class="nav-span d-flex flex-column mb-3">
                                        <strong>Vento (m/s)</strong>
                                        <picture>
                                            <img src="/o/allerta-theme/img/legend/rt_D_vento.png" alt="Legenda per Vento (m/s)">
                                        </picture>
                                    </div>
                                </li>
                                <li class="nav-item" data-if="legend" data-when="idrometrico" aria-hidden="true" style="display: none;">
                                    <div class="nav-span d-flex flex-column mb-3">
                                        <strong>Livello Idrometrico</strong>
                                            <div class="legend-image"> <span class="legend-measure-el"> <span class="legend-measure-el__color legend-measure-el__color--green"></span> <span class="legend-measure-el__label">Inf. soglia 1</span> </span> <span class="legend-measure-el"> <span class="legend-measure-el__color legend-measure-el__color--yellow"></span> <span class="legend-measure-el__label">Sup. soglia 1</span> </span> <span class="legend-measure-el"> <span class="legend-measure-el__color legend-measure-el__color--orange"></span> <span class="legend-measure-el__label">Sup. soglia 2</span> </span> <span class="legend-measure-el"> <span class="legend-measure-el__color legend-measure-el__color--red"></span> <span class="legend-measure-el__label">Sup. soglia 3</span> </span> </div>
                                    </div>
                                </li>
                                <li class="nav-item" data-if="legend" data-when="precipitazioni" aria-hidden="true" style="display: none;">
                                    <div class="nav-span d-flex flex-column mb-3">
                                        <strong>Precipitazioni (mm/ora)</strong>
                                        <picture>
                                            <img src="/o/allerta-theme/img/legend/rt_P_piogge.png" alt="Legenda per Precipitazioni (mm/ora)">
                                        </picture>
                                    </div>
                                </li>
                                <li class="nav-item" data-if="legend" data-when="pressione" aria-hidden="true" style="display: none;">
                                    <div class="nav-span d-flex flex-column mb-3">
                                        <strong>Pressione (hPa)</strong>
                                        <picture>
                                            <img src="/o/allerta-theme/img/legend/rt_P_pressione.png" alt="Legenda per Pressione (hPa)">
                                        </picture>
                                    </div>
                                </li>
                                <li class="nav-item" data-if="legend" data-when="umidita" aria-hidden="true" style="display: none;">
                                    <div class="nav-span d-flex flex-column mb-3">
                                        <strong>Umidità (%)</strong>
                                        <picture>
                                            <img src="/o/allerta-theme/img/legend/rt_U_umidita.png" alt="Legenda per Umidità (%)">
                                        </picture>
                                    </div>
                                </li>
                                <li class="nav-item" data-if="legend" data-when="temperature" aria-hidden="true" style="display: none;">
                                    <div class="nav-span d-flex flex-column mb-3">
                                        <strong>Temperature (C°)</strong>
                                        <picture>
                                            <img src="/o/allerta-theme/img/legend/rt_T_temperature.png" alt="Legenda per Temperature (C°)">
                                        </picture>
                                    </div>
                                </li>
                            </ul>
                        </div>

              
                         <div class="col-12 col-lg-5 mb-4">
                            <h6>Guide di utilità</h6>
                            <ul class="mb-md-2 nav map-legend__utility-guides flex-column">
                                <li class="nav-item">
                                    <a class="nav-link" href="<%=doc.linkLetturaRadar() %>" target="_blank"><span class="icon i-file-pdf-o"></span>Guida alla lettura della mappa</a>
                                </li>
                            </ul>
                        </div>

                        
                       
                    
                </div>
            </div> <!-- / modal-body -->

        </div>
    </div>
</div>
                                    
</section>
</main>

<!-- 
<script src="/o/allerta-theme/js/am.init.map-with-data.js?v=0.0"></script> 	
 -->
	