<%@page import="it.eng.allerter.allerta.UserBean"%>
<%@page import="it.eng.allerter.allerta.LoginBean"%>
<%@page import="java.util.List"%>

<%@ include file="./init.jsp"%>

<%
	LoginBean lbean = new LoginBean(themeDisplay);
	UserBean ubean = lbean.getComuneSindaco();
	
	List<String[]> eventiInCorso = lbean.getEventiInCorso(ubean.getArea());
	
	String statoAllerta = lbean.getLivelloAllertamento(ubean.getArea());
	
	String statoAllertaStyle = "alert-sign--null";
	String statoAllertaTitle = "";
	
	switch( statoAllerta) {
	
		case "verde":
			statoAllertaStyle = "alert-sign--green";
			statoAllertaTitle = "Assenza di fenomeni significativi prevedibili";
			break;

		case "arancione" :
			statoAllertaStyle = "alert-sign--orange";
			statoAllertaTitle = "Fenomeni diffusi";
			break;
			
		case "rosso" :
			statoAllertaStyle = "alert-sign--red";
			statoAllertaTitle = "Fenomeni ingenti ed estesi";
			break;
			
		case "giallo" :
			statoAllertaStyle = "alert-sign--yellow";
			statoAllertaTitle = "Fenomeni localizzati";
			break;	
		
	}
%>


	<div class="panel panel--foreground panel--reserved-tools" style="background:#fff !important">
		<h2 class="panel__heading">Strumenti riservati</h2>
		<div class="row panel__body">
			<div class="col-12 py-3">
				<div class="pb-2 u-strong">
					Il tuo comune - <a href="<%=ubean.getUrl()%>"> <%=ubean.getName()%>
					</a> - &egrave; a livello di allerta:
					<div class="alert-sign-inline-block-wrapper">
						<div data-toggle="tooltip" title=""
							class="alert-sign <%=statoAllertaStyle %>"
							data-original-title="<%=statoAllertaTitle%>">
							<div></div>
							<div></div>
							<div></div>
							<div></div>
						</div>
						<%=statoAllerta%>
					</div>
					.
				</div>
				
				<%if(eventiInCorso.size() > 0) { %>
					<br/>
					
					<%for( String[] evento : eventiInCorso) { %>
					<div 
						data-original-title="Criticità per <%=evento[0] %>"
						data-toggle="tooltip" title=""
						class="phenomenon-sign <%=evento[0] + "-" + evento[1]%>">
						<span class="alert-sign #<%=evento[1]%>"><i></i><i></i><i></i><i></i></span>
						<div>
							<i class="phenomenon-sign__icon icon__#<%=evento[0]%>"></i> 
							<span><%=evento[0] %></span>
						</div>
					</div>
					<%} %>
					<br/>
				
				<%} %>
				<p>Segui il tuo piano di protezione civile e attiva le procedure
					opportune.</p>
			</div>
			<div class="col-12">
				<h3 class="panel__heading">Strumenti operativi per il tuo
					comune</h3>
		
				<div class="row">
					<div class="col-12 col-lg-6 mt-3 mb-2" style="display: block !important;">
						<h4>Mappe di rischio</h4>
						
						<nav role="navigation" class="nav-vertical ">
						
							<ul class="nav flex-column">
		
								<li class="nav-item">
									
									<liferay-util:include page="/map/documenti_frane.jsp" servletContext="<%=getServletContext() %>">
										<liferay-util:param name="siteName"
											 value="<%=ubean.getName()%>"></liferay-util:param>
									</liferay-util:include>
								</li>
								
								<li class="nav-item">
									<liferay-util:include page="/map/documenti_alluvioni.jsp" servletContext="<%=getServletContext() %>">
										<liferay-util:param name="siteName"
											 value="<%=ubean.getName()%>"></liferay-util:param>
									</liferay-util:include>
								</li>
								
								
								<li class="nav-item">
									<liferay-util:include page="/map/documenti_rischio_alluvioni.jsp" servletContext="<%=getServletContext() %>">
										<liferay-util:param name="siteName"
											 value="<%=ubean.getName()%>"></liferay-util:param>
									</liferay-util:include>
								</li>
								
							</ul>
		
						</nav>
		
					</div>
			
					<div class="col-12 col-lg-6 mt-3 mb-2" style="display: block !important;">
						<h4>Strumenti riservati a te</h4>
						<nav role="navigation" class="nav-vertical ">
							<ul class="nav flex-column">
		
		
								<li class="nav-item">
									<a class="nav-link" href="messaggio del sindaco" data-toggle="modal"> <span
										class="icon i-envelope" title="Icona messaggio"></span> <span
										class="nav-vertical__item-label">Invia un messaggio</span>
								</a></li>
								<li class="nav-item">
									<a class="nav-link" href="<%=ubean.getUrl()%>/aggiornamenti-del-comune"> 
										<span class="icon i-message" title="Icona notizia"></span> 
										<span class="nav-vertical__item-label">
											Pubblica una notizia dal tuo comune
										</span>
									</a>
								</li>
								<li class="nav-item">
									<a class="nav-link " href="<%=ubean.getUrl()%>/piano-di-protezione-civile"> 
										<span class="icon i-gear" title="Icona ingranaggio"></span> 
										<span class="nav-vertical__item-label">
											Piano di protezione civile
										</span>
								</a></li>
		
		
							</ul>
		
						</nav>
		
					</div>
		
			</div>
		</div>



		<div class="row panel__footer"></div>
	</div>


	<div class="modal modal-send-message" tabindex="-1" role="dialog"
		id="modal-send-message">
		<div class="modal-dialog modal-xxl" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Invia un messaggio</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Chiudi">
						<span class="icon i-close"
							title="Icona del bottone che chiude la finestra modale"></span>
					</button>
				</div>
				<div class="modal-body">
					<div class="wizard">

						<div class="wizard-bar">

							<div class="wizard-bar__summary">Passo di</div>

							<ul class="nav flex-row" role="tablist">

								<li role="presentation" class="nav-item active current"
									data-target="#step-body-1"><span class="nav-span"
									data-id="#step-1"> <span class="circle">1</span> <span
										class="step-label">Prepara il contenuto</span>
								</span></li>
								<li role="presentation" class="nav-item  "
									data-target="#step-body-2"><span class="nav-span"
									data-id="#step-2"> <span class="circle">2</span> <span
										class="step-label">Scegli il canale</span>
								</span></li>
								<li role="presentation" class="nav-item  "
									data-target="#step-body-3"><span class="nav-span"
									data-id="#step-3"> <span class="circle">3</span> <span
										class="step-label">Conferma ed invia</span>
								</span></li>
								<li role="presentation" class="nav-item  "
									data-target="#step-body-4"><span class="nav-span"
									data-id="#step-4"> <span class="circle">4</span> <span
										class="step-label">Fine</span>
								</span></li>

							</ul>
						</div>
						<div class="wizard-body">

							<div class="wizard__step active" id="step-body-1">
								<h2>Prepara il contenuto</h2>
								<p class="lead"></p>

								Contenuto passo 1
							</div>

							<div class="wizard__step " id="step-body-2">
								<h2>Scegli il canale</h2>
								<p class="lead"></p>

								Contenuto passo 2
							</div>

							<div class="wizard__step " id="step-body-3">
								<h2>Conferma ed invia</h2>
								<p class="lead"></p>

								Contenuto passo 3
							</div>

							<div class="wizard__step " id="step-body-4">
								<h2>Fine</h2>
								<p class="lead"></p>

								Contenuto passo 4
							</div>

						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
</div>