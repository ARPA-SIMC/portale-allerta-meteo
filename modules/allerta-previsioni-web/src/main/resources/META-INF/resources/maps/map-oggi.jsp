
<%@ include file="../init.jsp"%>
<%
	
	MapModelBean mapModelBean = (MapModelBean) renderRequest.getAttribute("MapModelBean");

%>
	
		<div 
			class="tab-pane active show " 
			role="tabpanel" 
			aria-labelledby="tab--oggi" 
			id="tab--oggi">

<% if( mapModelBean.getAllertaOggiTitolo() != null) { %>
				<div class="map-section__emitted" style="">
					<small>
						Previsione emessa con 
						<a href="<%=mapModelBean.getAllertaOggiLink()%>">
							<span class="icon i-warning-o" title="Allerta"></span>
							<%=mapModelBean.getAllertaOggiTitolo() %>
						</a>
					</small>
				</div>
<%} %>


				<div
					class="map-component map-component--forecast map-component--oggi"
					id="map-component--oggi" 
					data-toggle="forecast-map"
					data-context="oggi" 
					data-comune="<%=mapModelBean.getSiteName() %>">

					<div class="map-component__panel">
						<%if( mapModelBean.getSiteName().equals("")) { %>
							<jsp:include page="map-home-panel.jsp"></jsp:include>	
						<%} else { %>
							<jsp:include page="map-comune-panel.jsp"></jsp:include>
						<%} %>
					</div>
					<div
						class="andcop u-map-section__map-side map-component__map"
						id="map--oggi" tabindex="0">
						<p class="u-loading-msg">
							Sto caricando la mappa di <span class="u-label">Oggi</span> <small>Previsione</small>
							...
						</p>
						
					</div>
				</div>
			
		   </div>