
<%@page import="com.liferay.portal.kernel.model.Role"%>
<%@page import="java.util.Iterator"%>
<%@ include file="../init.jsp"%>
<%
	
MapModelBean mapModelBean = (MapModelBean) renderRequest.getAttribute("MapModelBean");

boolean isCompilatore_monitoraggio = false;
boolean isAdministrator = false;
String name;

String compilatore_monitoraggio_k = "COMPILATORE_MONITORAGGIO";
String administrator_k = "Administrator";

Iterator<Role> roles = user.getRoles().iterator();
Role actual = null;

while (roles.hasNext()) {
	actual = roles.next();
	name = actual.getName();
	
	if (name.equalsIgnoreCase(administrator_k))
		isAdministrator = true;
	
	if (name.equalsIgnoreCase(compilatore_monitoraggio_k))
		isCompilatore_monitoraggio = true;
	
}
%>	

		<div class="tab-pane" role="tabpanel"
				aria-labelledby="tab--monitoraggio" id="tab--monitoraggio">

				<div class="map-section__emitted map-section__emitted-top" style="text-align:center">
					<small>Dati aggiornati in tempo reale per il monitoraggio della piogge e delle piene dei fiumi in corso</small>
				</div>

				<div
					class="map-component map-component--monitoring map-component--monitoraggio"
					id="map-component--monitoraggio" data-toggle="monitoring-map"
					data-scenarios="radar|idrometrico|precipitazioni|cumulata-6h|cumulata-48h">

					<div class="map-component__panel">

						<ul
							class="nav nav-pills flex-lg-column map-component__panel__filters"
							id="map-component__panel__filters--monitoraggio">
							<li class="nav-item"><a class="nav-link"
								href="#map--monitoraggio" data-trigger="rtdata-filter"
								data-filter="radar"> Radar </a></li>
							<li class="nav-item"><a class="nav-link"
								href="#map--monitoraggio" data-trigger="rtdata-filter"
								data-filter="idrometrico"> Liv. idrometrico </a></li>
							<li class="nav-item"><a class="nav-link"
								href="#map--monitoraggio" data-trigger="rtdata-filter"
								data-filter="precipitazioni"> Precipitazioni </a></li>
							<li class="nav-item"><a class="nav-link"
								href="#map--monitoraggio" data-trigger="rtdata-filter"
								data-filter="cumulata-6h"> Pioggia cumulata 6h</a></li>
							<li class="nav-item"><a class="nav-link"
								href="#map--monitoraggio" data-trigger="rtdata-filter"
								data-filter="cumulata-48h"> Pioggia cumulata 48h</a></li>
						</ul>

						<c:if test="<%=isAdministrator || isCompilatore_monitoraggio%>">
							<div class="map-component__panel__tools">
								<!-- Comandi di gestione visibili solo all'operatore -->
								<h3>Strumenti operatore</h3>
								<div class="btn-group-vertical">
									<a href="/gestione-monitoraggio" class="btn btn-secondary">
										<span class="icon i-cogs" aria-hidden="true"></span> 
										Gestione monitoraggio
									</a> 
									<a href="/preferenze-monitoraggio" class="btn btn-secondary">
										<span class="icon i-edit" aria-hidden="true"></span> 
										Preferenze monitoraggio
									</a>
								</div>
								<!-- / Comandi di gestione visibili solo all'operatore -->
							</div>
						</c:if>
						
					</div>
					<div class="u-map-section__map-side map-component__map"
						id="map--monitoraggio">
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
				
				<div class="map-section__emitted map-section__emitted-bottom" style="text-align:center">
					<small>Dati aggiornati in tempo reale per il monitoraggio della piogge e delle piene dei fiumi in corso</small>
				</div>
			</div>
			
			
			
			<script>
			jQuery('[aria-controls=tab--monitoraggio]').click(function(){
				console.log('clicked');
				setTimeout(function (){
					jQuery('[data-filter=radar]').click();
				}, 1200);
				
			});
			
			</script>