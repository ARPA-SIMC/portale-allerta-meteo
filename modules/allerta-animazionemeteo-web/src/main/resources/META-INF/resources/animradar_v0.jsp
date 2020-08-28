<%@page import="it.eng.allerta.animazione.bean.RadarBean"%>
<%@ include file="./init.jsp"%>

<%
	RadarBean radarBean = (RadarBean) renderRequest.getAttribute("RadarBean");
%>

<script src="<%=request.getContextPath()%>/js/ol.js?v=0.1"></script>

<script type="text/javascript">

	var elenco_img = <%=radarBean.getAllImagesJSON()%>
		
	var bounds = [<%=radarBean.getBounds()%>];
	
	var image_layer;
	var map;
	var view;
	var osmLayer;
	
	$(document).ready(function() {
		
	
		MapDataServer.init();

		var mapComponents = [];

		// Init Data Map (eg. Previsioni e dati » Livello Idrometrico)
		$('[data-toggle=data-map]').each(function() {
			
			var mapComponent = $(this);
			// Init the map if not yet done
			//if( ! mapComponent.attr("data-initialized") ){

			// Get the data to display
			var rtdata = mapComponent.attr("data-scenarios").split("|"); // Note: this should be one element, but we let the code generic

			// create the controller
			/*
			var map = new DataMap({
				dataScenarios : rtdata, // key of data, Note: this should be one element, but we let the code generic
				center : TERRITORY.REGION_LAT_LNG,
				territory : TERRITORY,
				container : mapComponent,
				mapContainer : $(".map-component__map", mapComponent),
				refreshTool : false,
				searchTool : true,
				key : rtdata[0],
				renderScenarioOnLoad : true
			});

			//}

			// now I'm initialized
			mapComponent.attr("data-initialized", true);

			// Resize handler
			$(window).resize(function() {
				var i = 0, I = mapComponents.length;
				for (; i < I; ++i)
					mapComponents[i].refresh();

			});*/
		});
		
		osmLayer = new ol.layer.Tile({
			source : new ol.source.OSM()
		});
		// Create latitude and longitude and convert them to default projection
		var birmingham = ol.proj.transform([ 10.8529, 44.7005 ],
				'EPSG:4326', 'EPSG:3857');
		// Create a View, set it center and zoom level
		view = new ol.View({
			center : birmingham,
			zoom : 7
		});
		// Instanciate a Map, set the object target to the map DOM id
		map = new ol.Map({
			target : 'map'
		});

		image_layer = new ol.layer.Image({
			opacity:0.75,
			source: new ol.source.ImageStatic({
					url: 'data:image/png;base64,<%=radarBean.getLastImages()%>',
							imageSize : [ 549, 303 ],
							imageExtent : ol.extent
									.applyTransform(
											[<%=radarBean.getBounds()%>],
											ol.proj
													.getTransform(
															"EPSG:4326",
															"EPSG:3857")),
							projection : map.getView()
									.getProjection()
						})
			});

			// Add the created layer to the Map
			map.addLayer(osmLayer);
			map.addLayer(image_layer);
			// Set the view for the map
			map.setView(view);

			var OpenLayerLegendControl = function(opt_options) {

				var options = opt_options || {};

				// happens after added to map
				var container = document.createElement('div');
				container.className = 'legend';
				$(container)
						.html(
								$('.legend-templates .legend-dati-e-previsioni__radar'));

				ol.control.Control.call(this, {
					element : container,
					target : options.target
				});

			};
			ol.inherits(OpenLayerLegendControl, ol.control.Control);

	});
</script>

<script src="<%=request.getContextPath()%>/js/arpa_radar.js?v=0.1g"></script>

<main class="page main page--previsioni" id="main-content">

<div class="container page__body">

	<div class="row">

		<div class="col-12 page__content" id="page-content">

			<div
				class="map-component map-component--data map-component--dato-osservato--radar"
				id="map-component--dato-osservato--radar">

				<div class="map-component__panel">
				
					<div class="row flex-column-reverse flex-md-row map-toolbar">
						<div id="map" style="width: 100%; height: 480px"></div>
					</div>
				

					<div class="row flex-column-reverse flex-md-row map-toolbar">

						<div class="col-12 col-md-6">

							<div class="map-toolbar__animation">

								<div class="form-group map-animation-dropdown">

									<label for="animation__timespan--dato-osservato--idrometrico">
										Animazione </label>

									<div class="input-group">

										<select id="selectRadar"
											class="form-control map-animation__timespan">

										</select>

										<div class="input-group-append">

											<div class="btn btn-primary map-animation__toggle">

												<a href="#" class="map-animation__toggle__play"> <i
													class="fa fa-play"></i>
												</a> <a href="#" class="map-animation__toggle__stop"> <i
													class="fa fa-stop"></i>
												</a>
											</div>
										</div>

									</div>

								</div>
							</div>
						</div>

						<div class="col-12 col-md-6">

							<div class="map-toolbar__timewheel-player"
								id="#map-toolbar__timewheel-player--dato-osservato--idrometrico">


								<div class="swiper-container" data-toggle="timewheel">
									<div class="swiper-wrapper">
										<!-- Qui vengono messe le slide via JS in base ai dati ricevuti dal server --->
									</div>
								</div>

								<div class="swiper-button-prev" aria-disabled="false"
									tabindex="0" role="button" aria-label="Previous slide"></div>

								<div class="swiper-button-next" aria-disabled="false"
									tabindex="0" role="button" aria-label="Next slide"></div>

							</div>
						</div>
					</div>

				</div>
				<div
					class="u-map-section__map-side map-component__map leaflet-container leaflet-touch leaflet-fade-anim leaflet-grab leaflet-touch-drag"
					id="map--dato-osservato--radar" tabindex="0">


					<p class="u-loading-msg">Sto caricando la mappa di</p>
					<div class="map-tab-head--monitoring">
						<span class="icon i-warning-triangle-o"></span>
						<div>
							<span class="u-label">Monitoraggio</span> <small>Eventi
								in corso</small>
						</div>
					</div>
					...
					<p></p>

				</div>
			</div>

		</div>
	</div>

</div>


</main>