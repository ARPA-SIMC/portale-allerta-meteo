<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="./init.jsp"%>

<%
	AnimazioneBean animBean = (AnimazioneBean) renderRequest.getAttribute("AnimazioneBean");
	int id = ParamUtil.getInteger(renderRequest, "id");
	String animType = (String) renderRequest.getAttribute("AnimType");
	if (animType==null) animType="preci";
%>
<script type="text/javascript">

	var id =<%=id%>;
		
</script>

<script src="<%=request.getContextPath()%>/js/am.init.map-with-data.js?v=0.3"></script>

<main class="page main page--previsioni" id="main-content">

<div class="page__head">

	<div class="container d-flex">
		<div class="row w-100 justify-content-between">
			<h1 class="col-12 col-lg-12">Previsioni meteo modellistiche</h1>

			<p class="col-12 lead"></p>
		</div>
	</div>

	<div class="breadcrumb-container">
		<div class="container d-flex">
			<nav class="row" aria-label="Hai percorso">
				<ol class="breadcrumb">

					<li class="breadcrumb-item"><a href="/">Home</a></li>

					<li class="breadcrumb-item active" aria-current="page">Previsioni meteo modellistiche</li>

				</ol>
			</nav>
		</div>
	</div>
</div>

<div class="container page__body">
	<div class="row">
		<div class="col-12 page__content" id="page-content">

			<p>
				Previsioni di precipitazione, copertura nuvolosa, velocità e
				direzione del vento in Emilia-Romagna e nel nord Italia, fino a 72 e
				con dettaglio ogni 3 ore, realizzate in modo completamente
				automatico utilizzando il modello meteorologico numerico ad area
				limitata <a
					href='http://www.arpa.emr.it/dettaglio_generale.asp?id=2584&amp;idlivello=32'>Cosmo-Lami</a>,
				realizzato in consorzio tra <a
					href="http://www.protezionecivile.it/" />
				<!--img src="/sim/img/logo_dpcn.png" alt="logo DPCN" /></a-->
				<a href="http://www.protezionecivile.it/">Dipartimento
					protezione civile nazionale</a>, <a
					href="http://www.aeronautica.difesa.it/">USAM Aeronautica
					Militare</a>, <a href="http://www.arpa.piemonte.it/ ">Arpa Piemonte</a>,
				Arpa Emilia-Romagna. <br /> Il tempo coordinato universale,
				conosciuto anche come tempo civile e abbreviato con la sigla UTC è
				il fuso orario di riferimento da cui sono calcolati tutti gli altri
				fusi orari del mondo. In Italia, quando è in vigore l'ora solare, si
				usa l'orario CET che è pari a UTC +1 ora, mentre quando è in vigore
				l'ora legale si usa l'orario CEST che è pari a UTC +2 ore.
			</p>

			<div class="col-12">
				<h3>Emissione <%=animBean.days().get(0)%></h3>
			</div>


		</div>

	</div>

	<div
		class="map-component map-component--data map-component--dato-osservato--<%=animType %>"
		id="map-component--dato-osservato--<%=animType %>" data-toggle="data-map"
		data-scenarios="<%=animType %>">
		
		<div class="map-component__panel">
		
			<div class="row flex-column-reverse flex-md-row map-toolbar" style="">
			
				<div class="col-12 col-md-6">
				
					<div class="map-toolbar__animation" >
					
						<div class="form-group map-animation-dropdown">
						
							<label for="animation__timespan--dato-osservato--<%=animType %>">
								Animazione </label>
							<div class="input-group" >
								<select id="animation__timespan--dato-osservato--<%=animType %>"
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
						id="#map-toolbar__timewheel-player--dato-osservato--<%=animType %>">
						
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
			id="map--animazione--<%=animType %>" tabindex="0">
			
			
			<div class="leaflet-control-container">
				<div class="leaflet-top leaflet-left">
					<div class="map-legend-control leaflet-control">
						<div class="d-flex">
							<div class="d-none d-md-flex d-print-flex flex-md-row">
								<div class="map-legend--rtdata-legend">
									<strong>Riflettivit&agrave;</strong>
									<div id="legenda" class="row" style="margin-left:0px;margin-right:0px"><div class="col s2 legendario truncate" style="background-color: #001A97; color: #ffffff">debole</div><div class="col s2 legendario truncate" style="background-color: #0067D9; color: #ffffff">moderata</div><div class="col s2 legendario truncate" style="background-color: #41B4FF; color: #000000">intensa</div><div class="col s2 legendario truncate" style="background-color: #FFC800; color: #000000">+1h</div><div class="col s2 legendario truncate" style="background-color: #FF7D00; color: #000000">+2h</div><div class="col s2 legendario truncate" style="background-color: #FF0000; color: #ffffff">+3h</div></div>
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
                                <li class="nav-item" data-if="legend" data-when="nowcasting" style="display: list-item;">
                                    <div id="legenda" class="row"><div class="col s2 legendario right-align"><i>Riflettività</i></div><div class="col s2 legendario truncate" style="background-color: #001A97; color: #ffffff">debole</div><div class="col s2 legendario truncate" style="background-color: #0067D9; color: #ffffff">moderata</div><div class="col s2 legendario truncate" style="background-color: #41B4FF; color: #000000">intensa</div><div class="col s2 legendario truncate" style="background-color: #FFC800; color: #000000">+1h</div><div class="col s2 legendario truncate" style="background-color: #FF7D00; color: #000000">+2h</div><div class="col s2 legendario truncate" style="background-color: #FF0000; color: #ffffff">+3h</div></div>
                                </li>
                                
                            </ul>
                        </div>

              
                         <div class="col-12 col-lg-5 mb-4">
                            <h6>Guide di utilità</h6>
                            <ul class="mb-md-2 nav map-legend__utility-guides flex-column">
                              
                            </ul>
                        </div>

                        
                       
                    
                </div>
            </div> <!-- / modal-body -->

        </div>
    </div>


	

</div>

</main>
