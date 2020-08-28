
<%@ include file="../init.jsp"%>
<%
	
	MapModelBean mapModelBean = (MapModelBean) renderRequest.getAttribute("MapModelBean");

%>	

		<div class="tab-pane" role="tabpanel"
				aria-labelledby="tab--backoffice-monitoring" id="tab--backoffice-monitoring">

				<div class="map-section__emitted" style="">
				</div>

				<div
					class="map-component map-component--forecast map-component--backoffice-monitoring"
					id="map-component--backoffice-monitoring" data-toggle="backoffice-monitoring-map"
					data-context="monitoraggio">

					<div class="map-component__panel"></div>
					
					<div class="u-map-section__map-side map-component__map"
						id="map--backoffice-monitoring">
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