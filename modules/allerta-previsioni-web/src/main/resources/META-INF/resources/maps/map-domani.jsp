
<%@ include file="../init.jsp"%>
<%
	
	MapModelBean mapModelBean = (MapModelBean) renderRequest.getAttribute("MapModelBean");

	
	boolean qualcosa =  mapModelBean.getAllertaDomaniTitolo() != null || mapModelBean.getValangheDomaniTitolo() != null;
	boolean tutto =  mapModelBean.getAllertaDomaniTitolo() != null && mapModelBean.getValangheDomaniTitolo() != null;
	
	String spiegazione = tutto?"Previsioni emesse con ":(qualcosa?"Previsione emessa con ":null);
	
	String tipoAllerta, tipoValanghe;
	
	tipoAllerta = mapModelBean.getAllertaDomaniTipo();
	if ("Allerta".equals(tipoAllerta)) tipoAllerta = "Allerta meteo";
	if ("Bollettino".equals(tipoAllerta)) tipoAllerta = "Bollettino meteo";
	tipoValanghe = mapModelBean.getValangheDomaniTipo();
	if ("AllertaValanghe".equals(tipoValanghe)) tipoValanghe = "Allerta valanghe";
	if ("BollettinoValanghe".equals(tipoValanghe)) tipoValanghe = "Bollettino valanghe";

%>			
			
<div 
	class="tab-pane" 
	role="tabpanel" 
	aria-labelledby="tab--domani<"
	id="tab--domani">


	<% if( spiegazione!=null) { %>
				<div class="map-section__emitted" style="">
					<small>
						<%=spiegazione %>
						<% if( mapModelBean.getAllertaDomaniTitolo()!=null) { %>
						<a href="<%=mapModelBean.getAllertaDomaniLink()%>">
							<span class="icon i-warning-o" title="Meteo"></span>
							<%=tipoAllerta %>
						</a>
						<% } %>
						<% if (tutto) { %> , 
						<% } %>
						<% if( mapModelBean.getValangheDomaniTitolo()!=null) { %>
						<a href="<%=mapModelBean.getValangheDomaniLink()%>">
							<span class="icon i-warning-o" title="Valanghe"></span>
							<%=tipoValanghe %>
						</a>
						<% } %>
					</small>
				</div>
<%} %>

	<div
		class="map-component map-component--forecast map-component--domani"
		id="map-component--domani" 
		data-toggle="forecast-map"
		data-context="domani"
		<%=mapModelBean.getSiteName().equals("")?"":"style=\"height:auto\"" %>
		data-versione="2"
		data-comune="<%=mapModelBean.getSiteName() %>">

		<div class="map-component__panel">
			<%if( mapModelBean.getSiteName().equals("")) { %>
				<jsp:include page="map-home-panel.jsp"></jsp:include>	
			<%} else { %>
				<jsp:include page="map-comune-panel.jsp"></jsp:include>
			<%} %>
		</div>
		<div class="u-map-section__map-side map-component__map"
			id="map--domani">
			<p class="u-loading-msg">
				Sto caricando la mappa di <span class="u-label">Domani</span> <small>Previsione</small>
				...
			</p>
		</div>
	</div>

</div>