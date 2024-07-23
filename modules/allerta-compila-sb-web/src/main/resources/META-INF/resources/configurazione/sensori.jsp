<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="it.eng.allerta.utils.AllertaKeys"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="it.eng.allerter.allerta.SensoreBean"%>
<%@ include file="../init.jsp" %>

<%
SensoreBean sensori = (SensoreBean) request.getAttribute("sensori");

long playoutId = PortalUtil.getPlidFromPortletId( themeDisplay.getScopeGroupId(), AllertaKeys.AllertaGraficoPortlet);
PortletURL pUrl =  PortletURLFactoryUtil.create(renderRequest, AllertaKeys.AllertaGraficoPortlet, playoutId, PortletRequest.RENDER_PHASE);
pUrl.setParameter("mvcRenderCommandName", new String[]{"/allerta/animazione/grafico"});

%>


<portlet:resourceURL var="salvaSoglia" >
	<portlet:param name="op" value="salva-soglia"/>
</portlet:resourceURL>


<portlet:resourceURL var="salvaStato" >
	<portlet:param name="op" value="salva-stato"/>
</portlet:resourceURL>


<portlet:actionURL var="tuoiComuni" name="/allertaer/sensori/tuoi-comuni">
		<portlet:param name="solotuoicomuni" value="<%=sensori.isSoloTuoiComuni()?"false":"true" %>"/>		
</portlet:actionURL>

<portlet:actionURL var="aggiornaSensori" name="/allertaer/sensori/carica">
</portlet:actionURL>

<c:if test="${sensori.canVedeTutto == false }">
<style>
 .dettagli {
 	display: none;
 }
 </style>
</c:if>

<c:set value="<%=sensori%>" var="regole" scope="request"></c:set>

	<style>
	 	#tabella-idrometri_filter {
	 		display:none;
	 	}
	 	
	 	#tabella-pluviometri_filter {
	 		display:none;
	 	}
	 	
	 	.paginate_button {
	 		margin-left: 5px;
	 		margin-right: 5px;
	 	}
	</style>

<main class="page main" id="main-content">

	<div class="container page__body" >

		<aui:form method="post" name="fmSensori">
		
			<div class="row">
				<div class="col form-group">
					<button
						type="button" 
						
						class="btn btn-primary" 
						onclick="window.open('/o/report/sc/sensori');"
						
						>Scarica Excel sensori-Comuni</button>
					<button
						type="button" 
						
						class="btn btn-primary" 
						onclick="window.open('/o/report/sc/comuni');"
						
						>Scarica Excel Comuni-sensori</button> 
					</div>
					
					<c:if test="${sensori.canModifica }">
					<div class="col form-group">
					<button
						type="button" 
						
						class="btn btn-primary" id="aggiornaManuale2" 
						name="aggiornaManuale2"
						onclick="<portlet:namespace/>aggiornaSens();"
						
						>Aggiornamento manuale sensori</button>
					</div>
				</c:if>
			</div>
		
			<div class="row">
			
				<div class="col-12">
			
					<c:if test="<%=SessionErrors.contains(request, Exception.class) %>">
				 		<div class="alert alert-danger" role="alert">
			    			<span class="icon i-error"></span> 
			    			<span><%= SessionErrors.get(request, Exception.class)%></span>
			  			</div>
					</c:if>	
					
					<% if (sensori.isCanModifica()) {
						if (sensori.userRicarica!=0 && sensori.userRicarica==themeDisplay.getUserId()) {
						
						%><div><%=sensori.esitoRicarica %></div>
					<% 
						sensori.userRicarica = 0;
						sensori.esitoRicarica = "";
						}} %>
				</div>
				
				<c:if test="${regole.comuniInteresse != null }">
					<div class="col form-group">
					<button
						type="button" 
						
						class="btn btn-primary" id="solotuoicomuni" 
						name="solotuoicomuni"
						onclick="<portlet:namespace/>aggiornaTuoiComuni($('#solotuoicomuni')[0].checked);"
						
						><%=sensori.isSoloTuoiComuni()?"Mostra tutti i sensori":"Mostra solo sensori dei tuoi Comuni" %></button>
					</div>
				</c:if>
				
				<div class="col-12">
				    <ul class="nav nav-tabs" role="tablist">
				        <li class="nav-item" role="presentation">
				            <a class="nav-link active" href="#idro-tab" aria-controls="idro-tab" role="tab" data-toggle="tab">
				            Idrometri
				            </a>
				        </li>
				        <li class="nav-item" role="presentation">
				            <a class="nav-link " href="#pluvio-tab" aria-controls="pluvio-tab" role="tab" data-toggle="tab">
				            Pluviometri
				            </a>
				        </li>
			
				    </ul> <!-- /.nav-tabs -->
				</div>

					
				<div class="col-12">
				
				 	<div class="tab-content">
				 	
        				<div role="tabpanel" class="tab-pane active" id="idro-tab">
			
							<h2 class="h2">Idrometri</h2>
							
							<input type="search" class="form-control input-sm" id="cercaIdrometri" placeholder="Cerca" style="display:none">
							<br/><br/>
							
							<table id='tabella-idrometri' class="table table-hover">
								<thead>
									<tr>
										<th>Nome sensore</th>
										<th>Bacino</th>
										<th >Fiume</th>
										<th >Comuni associati</th>
										<c:if test="${sensori.canVede }">
										<th >Soglia 1</th>
										<th >Soglia 2</th>
										<th >Soglia 3</th>
										<th class="dettagli" >Soglia spike</th>
										</c:if>
										<th >Riceve Dati</th>
										<th >Notifica Attiva</th>
										<th >Vai al Grafico</th>
									</tr>
		
								</thead>
								
								<tbody>
								
								<c:forEach var="regola" items="${sensori.idro}">
								
									<c:set var="sid" value="${fn:replace(fn:replace(regola.idStazione, '/', ''), ',', '')}"/>
									<c:set var="vid" value="${fn:replace(fn:replace(regola.idVariabile, '/', ''), ',', '')}"/>										
									
									<tr>
										<td> ${regola.name}</td>
										<td> ${regola.basin}</td>
										<td> ${regola.subbasin}</td>
										<td> ${regola.comuni}</td>
										<c:if test="${sensori.canVede }">
										<td>
											<c:if test="${regola.soglia1 ne 0.0 }">${regola.soglia1}</c:if>
										</td>
										<td>
											<c:if test="${regola.soglia2 ne 0.0 }">${regola.soglia2}</c:if>
										</td>
										<td>
											<c:if test="${regola.soglia3 ne 0.0 }">${regola.soglia3}</c:if>
										</td>
										<td class="dettagli">
											<input 
												style="width:4em""
												type="text"
												id="soglia_${sid}_${vid}"
												value="${regola.sogliaSpike }"
												/>
											<c:if test="${sensori.canModifica }">
											<button 
												type="button" 
												onclick="<portlet:namespace/>salvaSoglia('${regola.idStazione}', '${regola.idVariabile}', 'soglia_${sid}_${vid}')"
												class="btn btn-primary">Salva
											</button>
											</c:if>
										</td>
										</c:if>
										<td style='${regola.style}'>
											<c:choose>
											    <c:when test="${regola.attivo}">
											       SI
											    </c:when>    
											    <c:otherwise>
											        NO
											    </c:otherwise>
											</c:choose>
										</td>
										
												
										<td style='${regola.style3}' id='td_soglia_${sid}_${vid}'>
											<span id="testo_${sid}_${vid}">
											<c:choose>
											    <c:when test="${regola.funzionante}">
											       SI
											    </c:when>    
											    <c:otherwise>
											        NO
											    </c:otherwise>
											</c:choose>
											</span>
											<c:if test="${sensori.canModifica }">
												<input type='hidden' id='stato_${sid}_${vid}' value='${regola.funzionante}' />
												<button 
													type="button" 
													id="vstato_${sid}_${vid}"
													onclick="<portlet:namespace/>salvaStato('${sid}_${vid}', '${regola.idStazione}', '${regola.idVariabile}', 'idrometro')"
													class="btn btn-primary">${regola.testoAttiva }
												</button>
											</c:if>
										</td>
										<td>
											<a href="javascript:openGraph('<%=pUrl.toString() %>${regola.url }')">Vai</a>
										</td>
									</tr>
								
								</c:forEach>
								</tbody>
								
							</table>
						</div>
				
				
					
					
				 	
        				<div role="tabpanel" class="tab-pane" id="pluvio-tab">	
			
							<h2 class="h2">Pluviometri</h2>
							
							<input type="search" class="form-control input-sm" id="cercaPluviometri" placeholder="Cerca" style="display:none">
							<br/><br/>
							
							<table style="width:100%" id='tabella-pluviometri' class="table table-hover">
								<thead>
									<tr>
										<th>Nome sensore</th>
										<th>Bacino</th>
										<th >Sottobacino</th>
										<th >Comuni associati</th>
										<c:if test="${sensori.canVede }">
										<th >Soglia 1h</th>
										<th >Soglia 3h</th>
										<th class="dettagli">Soglia 12h</th>
										</c:if>
										<th >Riceve Dati</th>
										<th >Notifica Attiva</th>
										<th >Vai al Grafico</th>
									</tr>
		
								</thead>
								
								<tbody>
								
								<c:forEach var="regola" items="${sensori.pluvio}">
								
									<c:set var="sid" value="${fn:replace(fn:replace(regola.idStazione, '/', ''), ',', '')}"/>
									<c:set var="vid" value="${fn:replace(fn:replace(regola.idVariabile, '/', ''), ',', '')}"/>
											
									<tr>
										<td> ${regola.name}</td>
										<td> ${regola.basin}</td>
										<td> ${regola.subbasin}</td>
										<td> ${regola.comuni}</td>
										<c:if test="${sensori.canVede }">
										<td>
											<c:if test="${regola.soglia1 ne 0.0 }">${regola.soglia1}</c:if>
										</td>
										<td>
											<c:if test="${regola.soglia2 ne 0.0 }">${regola.soglia2}</c:if>
										</td>
										<td class="dettagli">
											<c:if test="${regola.soglia3 ne 0.0 }">${regola.soglia3}</c:if>
										</td>
										</c:if>
										<td style='${regola.style}'>
											<c:choose>
											    <c:when test="${regola.attivo}">
											       SI
											    </c:when>    
											    <c:otherwise>
											        NO
											    </c:otherwise>
											</c:choose>
										</td>
											
										<td style='${regola.style3}' id='td_soglia_${sid}_${vid}'>
											<span id="testo_${sid}_${vid}">
											<c:choose>
											    <c:when test="${regola.funzionante}">
											       SI
											    </c:when>    
											    <c:otherwise>
											        NO
											    </c:otherwise>
											</c:choose>
											</span>
											<c:if test="${sensori.canModifica }">
												<input type='hidden' id='stato_${sid}_${vid}' value='${regola.funzionante}' />
												<button 
													type="button" 
													id="vstato_${sid}_${vid}"
													onclick="<portlet:namespace/>salvaStato('${sid}_${vid}', '${regola.idStazione}', '${regola.idVariabile}')"
													class="btn btn-primary">${regola.testoAttiva }
												</button>
											</c:if>
										</td>
										<td>
											<a href="javascript:openGraph('<%=pUrl.toString() %>${regola.url }')">Vai</a>
										</td>
									</tr>
								
								</c:forEach>
								</tbody>
								
							</table>
					
						</div>
						
					</div>
					
				</div>
				
			</div>
					
					<div class="col form-group">
					<button
						type="button" 
						
						class="btn btn-primary" 
						onclick="window.open('/o/report/sc/sensori');"
						
						>Scarica Excel sensori-Comuni</button>
					<button
						type="button" 
						
						class="btn btn-primary" 
						onclick="window.open('/o/report/sc/comuni');"
						
						>Scarica Excel Comuni-sensori</button> 
					</div>
					
					<c:if test="${sensori.canModifica }">
					<div class="col form-group">
					<button
						type="button" 
						
						class="btn btn-primary" id="aggiornaManuale" 
						name="aggiornaManuale"
						onclick="<portlet:namespace/>aggiornaSens();"
						
						>Aggiornamento manuale sensori</button>
					</div>
				</c:if>
					
			<script>
			
				ita = {
					    "sEmptyTable":     "Nessun dato presente nella tabella",
					    "sInfo":           "Vista da _START_ a _END_ di _TOTAL_ elementi",
					    "sInfoEmpty":      "Vista da 0 a 0 di 0 elementi",
					    "sInfoFiltered":   "(filtrati da _MAX_ elementi totali)",
					    "sInfoPostFix":    "",
					    "sInfoThousands":  ".",
					    "sLengthMenu":     "Visualizza _MENU_ elementi",
					    "sLoadingRecords": "Caricamento...",
					    "sProcessing":     "Elaborazione...",
					    "sSearch":         "Cerca:",
					    "sZeroRecords":    "La ricerca non ha portato alcun risultato.",
					    "oPaginate": {
					        "sFirst":      "Inizio",
					        "sPrevious":   "Precedente",
					        "sNext":       "Successivo",
					        "sLast":       "Fine"
					    },
					    "oAria": {
					        "sSortAscending":  ": attiva per ordinare la colonna in ordine crescente",
					        "sSortDescending": ": attiva per ordinare la colonna in ordine decrescente"
					    }
					}
			
				function openGraph(popUpUrl) {
					
					var width = 980;
			        var height = 700;
			        var left = parseInt((screen.availWidth/2) - (width/2))
			        var top = parseInt((screen.availHeight/2) - (height/2))
			    
			        var windowsFeatures = "width="+width+",height="+height+",status,resizable,left="+left+",top="+top+",screenX="+left+",screenY="+top+",scrollbars=yes";

			        window.open( popUpUrl, 'graph', windowsFeatures);
				}
			
				function <portlet:namespace/>salvaSoglia(idStazione, idVariabile, refInput, type) {
					
					var opUrl = '<%=salvaSoglia.toString()%>';
					opUrl += '&<portlet:namespace/>idStazione=' + idStazione;
					opUrl += '&<portlet:namespace/>idVariabile=' + idVariabile;
					opUrl += '&<portlet:namespace/>type=' + type;
					opUrl += '&<portlet:namespace/>soglia=' + jQuery('#' + refInput).val();
					
					jQuery.ajax({
				        type : "POST",
				        url : opUrl,
				    	success: function(result) {
				    		
				    		//jQuery("#successMsg" ).fadeIn( 300 ).delay( 1500 ).fadeOut( 400 );
				    		//console.log('Dati: ' + result);
				    		alert('Soglia salvata');
				    		
				     	},
				     	error: function() {
				     		alert('Errore di salvataggio');
				     	},
				        async : false
					});
					
				}
				
				function <portlet:namespace/>aggiornaTuoiComuni(solotuoicomuni) {
					
					var opUrl = '<%=tuoiComuni.toString()%>';
					//opUrl += '&<portlet:namespace/>solotuoicomuni=' + solotuoicomuni;
					
					document.forms.<portlet:namespace/>fmSensori.action = opUrl;
					document.forms.<portlet:namespace/>fmSensori.submit();
					
				}
				
				function <portlet:namespace/>aggiornaSens() {
					
					var opUrl = '<%=aggiornaSensori.toString()%>';
					//opUrl += '&<portlet:namespace/>solotuoicomuni=' + solotuoicomuni;
					
					document.forms.<portlet:namespace/>fmSensori.action = opUrl;
					document.forms.<portlet:namespace/>fmSensori.submit();
					
				}
				
				function <portlet:namespace/>salvaStato(id, idStazione, idVariabile, stato) {
					
					var opUrl = '<%=salvaStato.toString()%>';
					
					opUrl += '&<portlet:namespace/>idStazione=' + idStazione;
					opUrl += '&<portlet:namespace/>idVariabile=' + idVariabile;
					opUrl += '&<portlet:namespace/>attivo=' + jQuery('#stato_' + id).val();
					
					jQuery.ajax({
				        type : "POST",
				        url : opUrl,
				        dataType: "json",
				    	success: function(result) {
				    		
				    		jQuery('#td_soglia_' + id).attr('style', result.style);
				    		jQuery('#vstato_' + id).html(result.testo);
				    		jQuery('#testo_' + id).html(result.label);
				    		jQuery('#stato_' + id).val(result.stato);
				    	}
				       
					});
					
				}
				
				jQuery( document ).ready(function() {
					
					var tableIdro = jQuery('#tabella-idrometri').DataTable({
						'language':ita,
						"scrollX": true,
		                "order": [[ 0, "asc" ]],
		                'columnDefs': [ {
		                	<c:if test="${sensori.canVede }">
		                	'targets': [3,7,10], // column index (start from 0)
							</c:if>
		                	<c:if test="${not sensori.canVede }">
		                	'targets': [3,6], // column index (start from 0)
							</c:if>
		                    'orderable': false, // set orderable false for selected columns
		                 }
		                	  
		                 ]
		            });
					
					var tablePluvio = jQuery('#tabella-pluviometri').DataTable({
						'language':ita,
						"scrollX": true,
		                "order": [[ 1, "desc" ]],
		                'columnDefs': [ {
		                	<c:if test="${sensori.canVede }">
		                	'targets': [3,9], // column index (start from 0)
							</c:if>
		                	<c:if test="${not sensori.canVede }">
		                	'targets': [3,6], // column index (start from 0)
							</c:if>
		                    'orderable': false, // set orderable false for selected columns
		                 }
		                	  
		                 ]
		            });
				 
					jQuery( '#cercaIdrometri', this ).on( 'keyup', function () {
						 tableIdro.search( this.value ).draw();
		            });
					
					jQuery( '#cercaPluviometri', this ).on( 'keyup', function () {
						tablePluvio.search( this.value ).draw();
		            });
					
					jQuery('#cercaIdrometri').show();
					jQuery('#cercaPluviometri').show();
					
					$('a[data-toggle="tab"]').on('shown.bs.tab', function(e){
						   $($.fn.dataTable.tables(true)).DataTable()
						      .columns.adjust();
						});
				
				});
			</script>
		
		</aui:form>
	</div>
</main>