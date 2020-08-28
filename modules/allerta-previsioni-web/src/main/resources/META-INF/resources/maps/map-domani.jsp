
<%@ include file="../init.jsp"%>
<%
	
	MapModelBean mapModelBean = (MapModelBean) renderRequest.getAttribute("MapModelBean");

%>			
			
<div 
	class="tab-pane" 
	role="tabpanel" 
	aria-labelledby="tab--domani<"
	id="tab--domani">


	<div class="map-section__emitted" style="">
		<small>
			Previsione emessa con 
			<a href="<%=mapModelBean.getAllertaDomaniLink() %>">
				<span class="icon i-warning-o" title="Allerta"></span>
				<%=mapModelBean.getAllertaDomaniTitolo() %>
			</a>
		</small>
	</div>

	<div
		class="map-component map-component--forecast map-component--domani"
		id="map-component--domani" 
		data-toggle="forecast-map"
		data-context="domani"
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