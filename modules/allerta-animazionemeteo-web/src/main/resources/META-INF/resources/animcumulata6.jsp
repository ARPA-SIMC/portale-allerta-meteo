<%@ include file="./init.jsp"%>


<main class="page main page--single-dato" id="main-content">

<div class="page__head">

	<div class="container d-flex">

		<div class="row w-100 justify-content-between">
			<div class="col-10 col-lg-10">
				<h1>Pioggia cumulata 6h</h1>
				<p class="lead">Precipitazione cumulata nelle 6 ore precedenti
					alla data e ora indicata, registrata dalla rete pluviometrica e
					spazializzata sul territorio regionale.</p>
			</div>


			<div class="d-flex page-tools" role="group"
				aria-label="Azioni sulla pagina">
				<button type="button" class="btn btn-transparent page-tools__item"
					title="" data-toggle="share-popover"
					data-original-title="Condividi sui social media">
					<span class="icon i-share-alt" title="Icona di condivisione"></span>
					<span class="sr-only">Condividi</span>
				</button>

				<div class="page-tools__share-popover-content">
					<div
						class="d-flex flex-row flex-lg-column addthis_inline_share_toolbox d-print-flex"
						data-url="http://www.allerta.nuovoportale.it/styleguide/prototype/pages/single-dato.php?c=cumulata-48h"
						data-title="[FIXME: NOME DELLA PAGINA]"
						data-description="[FIXME: DESC DELLA PAGINA]" style="clear: both;">

						<div id="atstbx"
							class="at-resp-share-element at-style-responsive addthis-smartlayers addthis-animated at4-show"
							aria-labelledby="at-0661d795-f3fe-4668-839a-7328f9b0e0ab"
							role="region">
							<span id="at-0661d795-f3fe-4668-839a-7328f9b0e0ab"
								class="at4-visually-hidden">AddThis Sharing Buttons</span>
							<div class="at-share-btn-elements">
								<a role="button" tabindex="1"
									class="at-icon-wrapper at-share-btn at-svc-facebook share-component__item">
									<span class="icon i-facebook" title="Condividi su Facebook"></span>
								</a><a role="button" tabindex="1"
									class="at-icon-wrapper at-share-btn at-svc-twitter share-component__item">
									<span class="icon i-twitter" title="Condividi su Twitter"></span>
								</a><a role="button" tabindex="1"
									class="at-icon-wrapper at-share-btn at-svc-whatsapp share-component__item">
									<span class="icon i-whatsapp" title="Condividi via WhatsApp"></span>
								</a>
							</div>
						</div>
					</div>
					<!-- Go to www.addthis.com/dashboard to customize your tools -->
					<script type="text/javascript"
						src="//s7.addthis.com/js/300/addthis_widget.js#pubid=ra-5cf4d7ff9c8211b9"></script>
				</div>

			</div>
		
		</div>
	</div>
</div>

<div class="breadcrumb-container">
	<div class="container d-flex">
		<nav class="row" aria-label="Hai percorso">
			<ol class="breadcrumb">

				<li class="breadcrumb-item"><a href="./home.php">Home</a></li>
				<li class="breadcrumb-item"><a href="#">Previsioni e dati</a></li>

				<li class="breadcrumb-item active" aria-current="page">Pioggia
					cumulata 6h</li>

			</ol>
		</nav>
	</div>
</div>


<section id="map-section--dato-osservato--cumulata-6h"	class="container map-section map-section--full-width">


	<div class="map-section__body">

		<div
			class="map-component map-component--data map-component--dato-osservato--cumulata-6h"
			id="map-component--dato-osservato--cumulata-6h"
			data-toggle="data-map" data-scenarios="cumulata-6h">
			<div class="map-component__panel">
				<div class="row flex-column-reverse flex-md-row map-toolbar">
					<div class="col-12 col-md-6">
						<div class="map-toolbar__animation">
							<div class="form-group map-animation-dropdown">
								<label for="animation__timespan--dato-osservato--cumulata-6h">
									Animazione </label>
								<div class="input-group">
									<select id="animation__timespan--dato-osservato--cumulata-6h"
											class="form-control map-animation__timespan">
									</select>
									<div class="input-group-append">
										<a
											href="#map-toolbar__time-player--dato-osservato--cumulata-6h"
											title="Lancia/Ferma l'animazione"
											data-source="#animation__timespan--dato-osservato--cumulata-6h"
											data-toggle="animate-data"
											class="btn btn-primary map-animation__toggle"> <span
											class="icon i-play-rounded-corner map-animation__toggle__play"
											title="Lancia l'animazione"></span> <span
											class="icon i-stop map-animation__toggle__stop"
											title="Ferma l'animazione"></span>
										</a>
									</div>
								</div>

							</div>
						</div>
					</div>
					<div class="col-12 col-md-6">
						<div class="map-toolbar__timewheel-player"
							id="#map-toolbar__timewheel-player--dato-osservato--cumulata-6h">
							<div class="swiper-button-prev" tabindex="0" role="button"
								aria-label="Previous slide" aria-disabled="false"></div>
							<div
								class="swiper-container swiper-container-initialized swiper-container-horizontal"
								data-toggle="timewheel" style="cursor: grab;">
								<div class="swiper-wrapper"
									style="transition-duration: 0ms; transform: translate3d(-4752px, 0px, 0px);">
									
									<!-- Qui vengono messe le slide via JS in base ai dati ricevuti dal server --->
									
								</div>
								<span class="swiper-notification" aria-live="assertive"
									aria-atomic="true"></span>
							</div>
							<div class="swiper-button-next swiper-button-disabled"
								tabindex="0" role="button" aria-label="Next slide"
								aria-disabled="true"></div>
						</div>
					</div>
				</div>
			</div>
			<div
				class="u-map-section__map-side map-component__map leaflet-container leaflet-touch leaflet-fade-anim"
				id="map--dato-osservato--cumulata-6h" tabindex="0"
				style="display: none;">
				<div class="leaflet-pane leaflet-map-pane"
					style="transform: translate3d(-600px, -274px, 0px);">
					<div class="leaflet-pane leaflet-tile-pane"></div>
					<div class="leaflet-pane leaflet-shadow-pane"></div>
					<div class="leaflet-pane leaflet-overlay-pane"></div>
					<div class="leaflet-pane leaflet-marker-pane"></div>
					<div class="leaflet-pane leaflet-tooltip-pane"></div>
					<div class="leaflet-pane leaflet-popup-pane"></div>
					<div class="leaflet-proxy leaflet-zoom-animated"
						style="transform: translate3d(34670px, 23719px, 0px) scale(128);"></div>
				</div>
				<div class="leaflet-control-container">
					<div class="leaflet-top leaflet-left">
						<div class="map-legend-control leaflet-control"></div>
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
						<div class="map-legend-control leaflet-control"></div>
					</div>
					<div class="leaflet-bottom leaflet-right">
						<div class="leaflet-control-zoom leaflet-bar leaflet-control"
							style="display: none;">
							<a class="leaflet-control-zoom-in" href="#" title="Zoom in"
								role="button" aria-label="Zoom in">+</a><a
								class="leaflet-control-zoom-out" href="#" title="Zoom out"
								role="button" aria-label="Zoom out"></a>
						</div>
						<div class="leaflet-control-attribution leaflet-control">
							<a href="https://leafletjs.com"
								title="A JS library for interactive maps">Leaflet</a>
						</div>
					</div>
				</div>
			</div>
			
		</div>


	</div>


</section>

<div class="container">
	<div class="alert alert-info">
		<span class="icon i-info-circle"></span> <span>I dati
			pubblicati in questa pagina e nei grafici sono acquisizioni in tempo
			reale dalla <a
			href="https://www.arpae.it/dettaglio_generale.asp?id=229&amp;idlivello=32"
			target="_blank"
			title="Vai al dettaglio della rete idrometeorologica regionale">rete
				idrometeorologica regionale</a> e non sono ancora sottoposti a
			validazione. Hanno funzione informativa e Arpae Emilia-Romagna
			declina ogni responsabilità per l'uso improprio di tali dati.
		</span>
	</div>
</div>


</main>
