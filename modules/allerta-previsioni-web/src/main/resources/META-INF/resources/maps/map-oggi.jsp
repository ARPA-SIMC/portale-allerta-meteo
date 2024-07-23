
<%@ include file="../init.jsp"%>
<%
	
	MapModelBean mapModelBean = (MapModelBean) renderRequest.getAttribute("MapModelBean");

	boolean qualcosa =  mapModelBean.getAllertaOggiTitolo() != null || mapModelBean.getValangheOggiTitolo() != null;
	boolean tutto =  mapModelBean.getAllertaOggiTitolo() != null && mapModelBean.getValangheOggiTitolo() != null;

	String spiegazione = tutto?"Previsioni emesse con ":(qualcosa?"Previsione emessa con ":null);

	String tipoAllerta, tipoValanghe;
	
	tipoAllerta = mapModelBean.getAllertaOggiTipo();
	if ("Allerta".equals(tipoAllerta)) tipoAllerta = "Allerta meteo";
	if ("Bollettino".equals(tipoAllerta)) tipoAllerta = "Bollettino meteo";
	tipoValanghe = mapModelBean.getValangheOggiTipo();
	if ("AllertaValanghe".equals(tipoValanghe)) tipoValanghe = "Allerta valanghe";
	if ("BollettinoValanghe".equals(tipoValanghe)) tipoValanghe = "Bollettino valanghe";
%>
	
		<div 
			class="tab-pane active show " 
			role="tabpanel" 
			aria-labelledby="tab--oggi" 
			id="tab--oggi">
			
			

<% if( spiegazione!=null) { %>
				<div class="map-section__emitted" style="">
					<small>
						<%=spiegazione %>
						<% if( mapModelBean.getAllertaOggiTitolo()!=null) { %>
						<a href="<%=mapModelBean.getAllertaOggiLink()%>">
							<span class="icon i-warning-o" title="Meteo"></span>
							<%=tipoAllerta %>
						</a>
						<% } %>
						<% if (tutto) { %> , 
						<% } %>
						<% if( mapModelBean.getValangheOggiTitolo()!=null) { %>
						<a href="<%=mapModelBean.getValangheOggiLink()%>">
							<span class="icon i-warning-o" title="Valanghe"></span>
							<%=tipoValanghe %>
						</a>
						<% } %>
					</small>
				</div>
<%} %>



				<div
					class="map-component map-component--forecast map-component--oggi"
					<%=mapModelBean.getSiteName().equals("")?"":"style=\"height:auto\"" %>
					id="map-component--oggi" 
					data-toggle="forecast-map"
					data-context="oggi" 
					data-versione="2"
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