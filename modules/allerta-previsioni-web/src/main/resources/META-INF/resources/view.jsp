
<%@ include file="./init.jsp"%>

<%@page import="it.eng.allerta.utils.AllertaTracker"%>
<%@page import="it.eng.allerta.configuration.DocumentazioneConfiguration"%>
<%
DocumentazioneConfiguration doc = AllertaTracker.getDocumentazioneConfiguration();
	
	MapModelBean mapModelBean = (MapModelBean) renderRequest.getAttribute("MapModelBean");

	String graficoUrl = (String)renderRequest.getAttribute("graficoUrl");
	
%>

<script>
	var graficoUrl = '<%=graficoUrl%>';
	
	(function($){

	    $(document).ready(function () {
	    	
	    	COMUNE = "";
	    	<%if( ! mapModelBean.getSiteName().equals("")) { %>//Comune
		    	TERRITORY.REGION_LAT_LNG = [<%=mapModelBean.getLat_()%>, <%=mapModelBean.getLong_()%>];
		    	COMUNE='<%=mapModelBean.getSiteName()%>';
	    	<%}%>
	    });
	    
	})(jQuery);
	
	
	console.log('<%=mapModelBean.getHomePage()%>','<%=mapModelBean.getArea()%>','<%=mapModelBean.getSiteName()%>',  '<%=mapModelBean.getLat_()%>', '<%=mapModelBean.getLong_()%>');
</script>


<section id="map-section--home" class=" map-section">
	<h2 class="sr-only">Sezione con previsioni di oggi, domani ed
		eventuale monitoraggio degli eventi in corso</h2>
	<div class="container-fluid c-xl-container">

		<jsp:include page="maps/template-dati-osservati.jsp?v=0.1"></jsp:include>

		<div class="u-map-section__map-side map-section__navs">
		
		  <div class="d-flex d-print-block map-section__navs-wrap">
		
			<ul class="nav nav-pills" role="tablist">
			
			<%if( mapModelBean.getHomePage()) { %>
		
				<li class="nav-item">
					<a class="nav-link active" href="#tab--oggi" data-toggle="tab" role="tab" aria-controls="tab--oggi" aria-selected="true"> 
						<span class="u-label">Oggi</span><small>Previsione</small>
					</a>
				</li>
				
				<li class="nav-item">
					<a class="nav-link " href="#tab--domani" data-toggle="tab" role="tab" aria-controls="tab--domani" aria-selected="false"> 
						<span class="u-label">Domani</span> <small>Previsione</small>
					</a>
				</li>
			<%} %>	
				<!-- Solo se il monitoraggio è attivo -->
				
				<%if( mapModelBean.isGestMonAttivo()) { %>
				<li class="nav-item ">
					<a class="nav-link" href="#tab--monitoraggio" data-toggle="tab" role="tab" aria-controls="tab--monitoraggio" aria-selected="false">
						<div class="map-tab-head--monitoring">
							<span class="icon i-warning-triangle-o"></span>
							<div>
								<span class="u-label">Monitoraggio</span> <small>Eventi
									in corso</small>
							</div>
						</div>
					</a>
				</li>
				<%} %>
				
				<%if( !mapModelBean.getHomePage() && mapModelBean.isGestMonAttivo() && mapModelBean.isOperatore()) { %>
				<li class="nav-item">
                    <a class="nav-link" href="#tab--backoffice-monitoring" data-toggle="tab" role="tab" aria-controls="tab--backoffice-monitoring" aria-selected="false">
                        <div class="map-tab-head--backoffice-monitoring">
                        	<div>
                        		<span class="u-label">Monitoraggio Privato</span>
                        	</div>
                        </div>
                    </a>
                </li>
				<%} %>
				<!-- / Solo se il monitoraggio è attivo -->
			</ul>
		  </div>
		
		</div>


		<div class="map-section__body tab-content">
		
			<%if( mapModelBean.getHomePage()) {
		
				  if( mapModelBean.isExistOggi() ) {%>
					<jsp:include page="maps/map-oggi.jsp"></jsp:include>
				<%} else {%>
					<div 
						class="tab-pane active show " 
						role="tabpanel" 
						aria-labelledby="tab--oggi" 
						id="tab--oggi">
						
						<br/><br/>
						<div class="map-section__emitted" style="">
						 <h4><strong>La mappa sar&agrave; disponibile all'emissione della prossima allerta o bollettino di vigilanza
						 meteo idrogeologica e idraulica</strong></h4>
						</div>
						
					</div>
				<%} %>
				
				<%if( mapModelBean.isExistDomani() || mapModelBean.getValangheDomaniLink()!=null ) {%>
					<jsp:include page="maps/map-domani.jsp"></jsp:include>
				<%} else {%>
				   <div 
						class="tab-pane" 
						role="tabpanel" 
						aria-labelledby="tab--domani" 
						id="tab--domani">
						
						<br/><br/>
						<div class="map-section__emitted" style="">
							<h4><strong>La mappa sar&agrave; disponibile all'emissione della prossima allerta o bollettino di vigilanza
						 meteo idrogeologica e idraulica</strong></h4>
						</div>
					</div>
				<%} 
			}%>
			

			<%if( mapModelBean.isGestMonAttivo()) { %>
				<jsp:include page="maps/map-monitoraggio.jsp"></jsp:include>
			<%} %>
			
			<%if( !mapModelBean.getHomePage() && mapModelBean.isGestMonAttivo() && mapModelBean.isOperatore()) { %>
				<jsp:include page="maps/map-monitoraggio-privato.jsp"></jsp:include>
			<%} %>

		</div>
	</div>


	<jsp:include page="maps/guida-previsioni.jsp"></jsp:include>

	<jsp:include page="maps/guida-monitoraggio.jsp"></jsp:include>
		
</section>
