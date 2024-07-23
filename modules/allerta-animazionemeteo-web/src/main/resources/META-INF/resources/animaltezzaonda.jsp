<%@ include file="./init.jsp"%>
<%@page import="it.eng.allerta.utils.AllertaTracker"%>
<%@page import="it.eng.allerta.configuration.DocumentazioneConfiguration"%>
<%
DocumentazioneConfiguration doc = AllertaTracker.getDocumentazioneConfiguration();

%>
<%

	String graficoUrl = (String)renderRequest.getAttribute("graficoUrl");
%>

<script>
	var graficoUrl = '<%=graficoUrl%>';
</script>

<main class="page main page--previsioni" id="main-content">

<section id="map-section--dato-osservato--radar"
	class="container map-section map-section--full-width">

	<div class="map-section__body">
		<div
			class="map-component map-component--data map-component--dato-osservato--altezzaonda"
			id="map-component--dato-osservato--altezzaonda" data-toggle="data-map"
			data-scenarios="altezzaonda">

			<div class="map-component__panel">

				<div class="row flex-column-reverse flex-md-row map-toolbar">

					<div class="col-12 col-md-6">

						<div class="map-toolbar__datetime">

							<div class="form-group">

								<label for="datetimepicker--dato-osservato--altezzaonda__field">Giorno
									di riferimento </label>
								<div class="input-group date"
									id="datetimepicker--dato-osservato--altezzaonda"
									data-toggle="datetimepicker">

									<input type="text"
										id="datetimepicker--dato-osservato--altezzaonda__field"
										class="form-control datetimepicker-input" /> <a
										class="input-group-append datepickerbutton"
										href="#datetimepicker--dato-osservato--altezzaonda">

										<div class="input-group-text">
											<span class="icon i-calendar" aria-hidden="true"></span> <span
												class="sr-only">Scegli data e ora</span>
										</div>
									</a>
								</div>
							</div>
						</div>
					</div>
					<div class="col-12 col-md-6">
						<div class="map-toolbar__timewheel-player"
							id="map-toolbar__timewheel-player--dato-osservato--altezzaonda">
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
			</div>
			<div class="u-map-section__map-side map-component__map"
				id="map--dato-osservato--altezzaonda">
				
				<p class="u-loading-msg">Sto caricando la mappa...</p>

				<div class="leaflet-control-container">
					<div class="leaflet-top leaflet-left">
						<div class="map-legend-control leaflet-control">
							<div class="d-flex">
								<div class="d-none d-md-flex d-print-flex flex-md-row">
									<div class="map-legend--rtdata-legend">
										<strong>Altezza onda significativa (m)</strong>
									
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="leaflet-top leaflet-right">
						<div class="leaflet-control-search leaflet-control"
							style="display: flex;">
							<label class="search-input" for="searchtext9"
								autocomplete="new-password" style="display: none;"></label><input
								class="search-input" type="text" size="9"
								autocomplete="new-password" autocapitalize="off"
								placeholder="Search..." id="searchtext9" style="display: none;">
							<ul class="search-tooltip" style="display: none;"></ul>
							<a class="search-cancel" href="#" title="Cancel"
								style="display: none;"><span></span></a><a
								class="search-button" href="#" title="Search..."></a>
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
								role="button" aria-label="Zoom out">-</a>
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


	<h4 class="sr-only">Guide e supporto</h4>
	<!-- Guida Mappa Previsioni -->
	<div class="modal  fade modal--map-guide modal--map-guide--rtdata"
		id="modal--guida-mappa-dato-osservato" tabindex="-1" role="dialog"
		aria-labelledby="modal-guida-mappa-osservato-title" aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modal-guida-mappa-osservato-title">Guida
						alla mappa</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-lead">
					I livelli di criticità di ogni fenomeno si basano su soglie e
					valutazioni differenti.<br /> Questa è una breve guida alla
					lettura della mappa.
				</div>
				<div class="modal-body">
					<div class="row flex-lg-column">

						<div class="col-12 col-lg-7 mb-4" data-if="legend"
							data-when="rtdata">
							<h6>Legenda dati osservati mostrati sulla mappa</h6>
							<ul class="mb-md-2 nav map-legend__rtdata-guides flex-column">
								<li class="nav-item" data-if="legend" data-when="radar">
									<div class="nav-span d-flex flex-column mb-3">
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
								</li>
								<li class="nav-item" data-if="legend" data-when="vento">
									<div class="nav-span d-flex flex-column mb-3">
										<strong>Vento (m/s)</strong>
										<picture> <img
											src="/o/allerta-theme/img/legend/rt_D_vento.png"
											alt="Legenda per Vento (m/s)" /> </picture>
									</div>
								</li>
								<li class="nav-item" data-if="legend" data-when="idrometrico">
									<div class="nav-span d-flex flex-column mb-3">
										<strong>Livello Idrometrico</strong>
										<div class="legend-image">
											<span class="legend-measure-el"> <span
												class="legend-measure-el__color legend-measure-el__color--green"></span>
												<span class="legend-measure-el__label">Inf. soglia 1</span>
											</span> <span class="legend-measure-el"> <span
												class="legend-measure-el__color legend-measure-el__color--yellow"></span>
												<span class="legend-measure-el__label">Sup. soglia 1</span>
											</span> <span class="legend-measure-el"> <span
												class="legend-measure-el__color legend-measure-el__color--orange"></span>
												<span class="legend-measure-el__label">Sup. soglia 2</span>
											</span> <span class="legend-measure-el"> <span
												class="legend-measure-el__color legend-measure-el__color--red"></span>
												<span class="legend-measure-el__label">Sup. soglia 3</span>
											</span>
										</div>
									</div>
								</li>
								<li class="nav-item" data-if="legend" data-when="precipitazioni">
									<div class="nav-span d-flex flex-column mb-3">
										<strong>Precipitazioni (mm/ora)</strong>
										<picture> <img
											src="/o/allerta-theme/img/legend/rt_P_piogge.png"
											alt="Legenda per Precipitazioni (mm/ora)" /> </picture>
									</div>
								</li>
								<li class="nav-item" data-if="legend" data-when="altezzaonda">
									<div class="nav-span d-flex flex-column mb-3">
										<strong>Altezza onda significativa (m)</strong>
									</div>
								</li>
								<li class="nav-item" data-if="legend" data-when="umidita">
									<div class="nav-span d-flex flex-column mb-3">
										<strong>Umidità (%)</strong>
										<picture> <img
											src="/o/allerta-theme/img/legend/rt_U_umidita.png"
											alt="Legenda per Umidità (%)" /> </picture>
									</div>
								</li>
								<li class="nav-item" data-if="legend" data-when="temperature">
									<div class="nav-span d-flex flex-column mb-3">
										<strong>Temperature (C°)</strong>
										<picture> <img
											src="/o/allerta-theme/img/legend/rt_T_temperature.png"
											alt="Legenda per Temperature (C°)" /> </picture>
									</div>
								</li>
							</ul>
						</div>

						<div class="col-12 col-lg-5 mb-4">
							<h6>Guide di utilit&agrave;</h6>
							<ul class="mb-md-2 nav map-legend__utility-guides flex-column">
								<li class="nav-item"><a class="nav-link" href="/documents/20181/1138904/Guida_mappa_altezza_onda.pdf"
									target="_blank"><span class="icon i-file-pdf-o"></span>Guida
										alla lettura della mappa</a></li>
							</ul>
						</div>



					</div>
				</div>
				<!-- / modal-body -->

			</div>
		</div>
	</div>
	<!-- / Guida Mappa Previsioni -->
	

</main>
