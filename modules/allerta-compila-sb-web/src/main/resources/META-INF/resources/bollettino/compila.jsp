<%@page import="it.eng.allerter.allerta.SelectItem"%>
<%@page import="it.eng.allerter.allerta.BacinoManager"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="it.eng.allerta.utils.AllertaKeys"%>
<%@page import="it.eng.allerter.allerta.BollettinoBean"%>
<%@ include file="../init.jsp" %>

<%
BollettinoBean bollettinoBean = (BollettinoBean) portletSession.getAttribute(AllertaKeys.RequestBollettinoBean);
//renderRequest.getAttribute(AllertaKeys.RequestBollettinoBean);


%>

 
 <style>
 .icon-monospaced, .icon-monospaced[class^="icon-"], .icon-monospaced[class*=" icon-"] {
 	display:none !important;
 }



 </style>
	
<c:set value="<%=bollettinoBean%>" var="bollettinoBean" scope="request"></c:set>


<portlet:resourceURL var="generateNumeroURL" >
	<portlet:param name="op" value="genera-numero"/>
</portlet:resourceURL>

<portlet:resourceURL var="generateOraURL" >
	<portlet:param name="op" value="genera-ora"/>
</portlet:resourceURL>

<portlet:actionURL var="salvaURL" name="/allertaer/monitoraggio/salva">
	<portlet:param name="redirect" value=""/>		
	<portlet:param name="bollettinoId" value="${bollettinoBean.bollettino.bollettinoId}"/>	
</portlet:actionURL>

<portlet:actionURL var="salvaInviaURL" name="/allertaer/monitoraggio/salva-invia">
	<portlet:param name="redirect" value=""/>	
	<portlet:param name="bollettinoId" value="${bollettinoBean.bollettino.bollettinoId}"/>	
</portlet:actionURL>

<portlet:actionURL var="ricaricaURL" name="/allertaer/monitoraggio/ricarica">
	<portlet:param name="redirect" value=""/>	
	<portlet:param name="bollettinoId" value="${bollettinoBean.bollettino.bollettinoId}"/>	
</portlet:actionURL>

	
<main class="page main" id="main-content">

	<div class="container page__body" >

		<aui:form method="post" name="fmCompila">
			
			<input type="hidden" name="<portlet:namespace/>bollettinoId" value="${bollettinoBean.bollettinoId}">
			
			
			<c:if test="${bollettinoBean.url != null }">
				
				<div class="row">
					<div class="col-9">
						<!-- Card -->
						<div class="card card--standard ">
		        			<div class="card-header">
		           				<div class="card__thumbnail">
		               				<span class="icon i-info" title="Icona di card di informazione"></span>
		          				</div>
		           				<div class="card__category">Visualizza Bollettino</div>
		        			</div>
		        			<div class="card-body">
		               			<p class="card-text">
		                   			<a href='${bollettinoBean.bollettino.link}'
										class="btn btn-primary" target="_blank">Visualizza PDF</a>
		               			</p>
		        			</div>
						</div>
						<!-- /  Card -->
							
					</div>
						
				</div>
			
			</c:if>
			
			<div class="row">
			
				<div class="col-12">
			
				<c:if test="<%=SessionErrors.contains(request, Exception.class) %>">
			 		<div class="alert alert-danger" role="alert">
		    			<span class="icon i-error"></span> 
		    			<span><%= SessionErrors.get(request, Exception.class)%></span>
		  			</div>
				</c:if>		
				
				<liferay-ui:success key="saved" message="Salvataggio riuscito" />
			
				</div>
			
			</div>
			
			<div class="row">
			
				<div class="col-4">
				
					<div class="row">
						<h2 class="h2">Informazioni generali</h2>
					</div>
					
					<div class="row">
						<label class="control-label"> Stato monitoraggio</label>
						<span>${bollettinoBean.stato }</span>
					
					</div>
					
					<div class="row" style=" display: table;">
						<div class="col-8" style=" float: none;display: table-cell;vertical-align: bottom;">
							<label class="control-label"> Numero</label>
							<input type="text" id="numero" name="<portlet:namespace/>numero" value="${bollettinoBean.numero}" class="form-control">
						</div>
						<div class="col-4" style=" float: none;display: table-cell;vertical-align: bottom;">
							<label class="control-label"> </label>
							<button 
								type="button" 
								onclick="<portlet:namespace/>getBollettinoData('<%=generateNumeroURL.toString()%>', -1)"
								class="btn btn-primary">Genera
							</button>
						</div>
					
					</div>
					
					<br/><br/>
					
					<div class="row">
					
						 <div class='col-sm-8'>
							<label class="control-label" for="date-picker--1"> Inizio
								Validit&agrave;</label>
								
							<div class='input-group date' id="datetimepicker1">
			                    <input 
									type="text" 
									class="form-control" 
									name="<portlet:namespace/>dataInizio"
									value="${bollettinoBean.dataInizioString}" 
									placeholder="gg/mm/aaaa" />
			                    <span class="input-group-addon">
			                        <i class="far fa-calendar-minus"></i>
			                    </span>
			                </div>
			                
			                <script type="text/javascript">
					            $(function () {
					                $('#datetimepicker1').datetimepicker({
					                	
					                	<%if( bollettinoBean.getBollettinoId() <=0) {%>
					                		useCurrent: false,
					                	 	date: moment().add('h', 1).startOf('hour').toDate(),
					                	 <%}%>
					                	 icons: {
					                		 time: "far fa-clock",
					                         date: "far fa-calendar-minus",
					                         up: "fa fa-arrow-up",
					                         down: "fa fa-arrow-down"
					                     }
					                });
					            });
					        </script>
				
						</div>
					</div>
					
					<br/>
					
					<div class="row">
					
						<div class='col-sm-8'>
							<label class="control-label" for="date-picker--2"> Fine
							Validit&agrave;</label>
			
							<div class='input-group date' id="datetimepicker2">
								<input 
									type="text" 
									class="form-control" 
									name="<portlet:namespace/>dataFine"
									value="${bollettinoBean.dataFineString}" 
									placeholder="gg/mm/aaaa"/>		
								 <span class="input-group-addon">
			                        <i class="far fa-calendar-minus"></i>
			                    </span>			
							</div>
							
							   <script type="text/javascript">
					            $(function () {
					                $('#datetimepicker2').datetimepicker({
					                	<%if( bollettinoBean.getBollettinoId() <=0) {%>
					                		useCurrent: false,
					                	 	date: moment().add('h', 7).startOf('hour').toDate(),
					                	 <%}%>
					                	 icons: {
					                		 time: "far fa-clock",
					                         date: "far fa-calendar-minus",
					                         up: "fa fa-arrow-up",
					                         down: "fa fa-arrow-down"
					                     }
					                });
					            });
					        </script>
						</div>
					</div>
				
				</div>
				
				<div class="col-8">
					<div class="row">
						<h2 class="h2">Previsione meteorologica per le prossime ore</h2>
					</div>
				
					
					<div class="row">
					
						<div class="col-6">
							<div id="contenitore" >
							</div>
						</div>
						
						<div class="col-6">
						
							<table id="mappa" style="margin-left:20px">
								<tr>
									<td>
										<div class="daicone draggable drag-drop base type1" />
									</td>
									<td>Pioggia trascurabile (&lt;2mm/6h)</td>
								</tr>
								<tr>
									<td>
										<div class="daicone draggable drag-drop base type2"/>
									</td>
									<td>Pioggia debole (5-10mm/6h)</td>
								</tr>
								<tr>
									<td>
										<div class="daicone draggable drag-drop base type3" />
									</td>
									<td>Pioggia moderata (10-30mm/6h)</td>
								</tr>
								<tr>
									<td>
										<div class="daicone draggable drag-drop base type4" />
									</td>
									<td>Pioggia elevata (&gt;30mm/6h)</td>
								</tr>
								<tr>
									<td>
										<div class="daicone draggable drag-drop base type5" />
									</td>
									<td>Pioggia mista a neve</td>
								</tr>
								<tr>
									<td>
										<div class="daicone draggable drag-drop base type6" />
									</td>
									<td>Neve</td>
								</tr>
							</table>
						</div>
						
						
					</div>
					
					<div class="row">
						<label class="control-label" >Note</label>
						<input type="hidden" id="testoMeteo" name="<portlet:namespace/>testoMeteo" value="${bollettinoBean.stringaMeteo}" class="form-control">
						<textarea name="<portlet:namespace/>noteMeteo" style="height: 100px" class="form-control">${bollettinoBean.noteMeteo}</textarea>
					</div>
					
				</div>
				
			</div>
			
		
			<div class="row">	
				<div class="col-12" style="text-align: center">
					<img src="${bollettinoBean.getDataImage()}" />
				</div>
			</div>	
		
			<div class="row">
			
				<div class="col-12">
				
					<h2 class="h2">Monitoraggio</h2>
					
						<input
							type="hidden"
							id="bacini_selected"
							name="<portlet:namespace/>bacini_selected"
							/>
				
					<c:forEach var="bacino" items="${bollettinoBean.bacini}">
					
						<div class="rf-cp rf-tgp bacini">
							<div onclick="toggleVis('${bacino.bac.id}');"
								class="rf-cp-hdr rf-cp-hdr-exp">
								<table class="rf-cp-gr">
									<tbody>
										<tr>
											<td class="rf-cp-ico"><div
													class="rf-cp-ico-colps rf-ico-chevron-up rf-ico-t-hdr"></div>
												<div class="rf-cp-ico-exp rf-ico-chevron-down rf-ico-t-hdr"></div></td>
											<td class="rf-cp-lbl"><div class="rf-cp-lbl-exp">BACINO
													${bacino.bac.nome}</div>
												<div class="rf-cp-lbl-colps">BACINO ${bacino.bac.nome}</div></td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="rf-cp-b" style="display: block">
		
								<input type="hidden" name="stazioneId[]" value="${stazione.stazione.id }">

								<table class="table table-hover table_${bacino.bac.id} ${bacino.selezionato ? 'visibile':'nascosto'} rf-dt">
									<thead class="rf-dt-thd">
										<tr class="rf-dt-hdr rf-dt-hdr-fst">
											<th class="rf-dt-hdr-c" rowspan="2" colspan="2">Stazione idrometrica</th>
											<th class="rf-dt-hdr-c" colspan="3" >Livello osservato</th>
											<th class="rf-dt-hdr-c" colspan="4">Colmo osservato/previsto</th>
											<th class="rf-dt-hdr-c" colspan="3" >Soglie riferimento</th>
										</tr>
										<tr class="rf-dt-hdr">
											<th class="rf-dt-hdr-c">Tendenza</th>
											<th class="rf-dt-hdr-c"></th>
											<th class="rf-dt-hdr-c"></th>
											<th class="rf-dt-hdr-c">Livello</th>
											<th class="rf-dt-hdr-c">Giorno</th>
											<th class="rf-dt-hdr-c">Ora</th>
											<th class="rf-dt-hdr-c">Osservato</th>
											<th class="rf-dt-hdr-c">1</th>
											<th class="rf-dt-hdr-c">2</th>
											<th class="rf-dt-hdr-c">3</th>
										</tr>
		
									</thead>
									<c:forEach var="stazione" items="${bacino.stazioni}">
									<tbody>
										<tr>
											<td>
												<c:set var="sid" value="${fn:replace(fn:replace(stazione.stazione.id, '/', ''), ',', '')}"/>
											
												<input 
													type="checkbox" ${stazione.selezionata ? 'checked' : ''}
													id= "${sid}"
													onchange="<portlet:namespace/>selection('${sid}')"
													name="<portlet:namespace/>stazionesel_${stazione.stazione.id }"
													class="stazionecbx">
							
												<input
													type="hidden"
													id="bacino${sid}"
													value="${bacino.bac.id}"
													/>
											</td>
											<td>
												${stazione.stazione.name}
											</td>
											<td>
												<select 
														name="<portlet:namespace/>tendenza_${stazione.stazione.id}" 
														class="form-control" 
														style="max-width:65px"
														${not stazione.selezionata ? 'readonly' : ''}>
													<option value="+" ${stazione.tendenza=='+'?'selected':''} >&#x25B2;</option>
													<option value="=" ${stazione.tendenza=='='?'selected':''}>=</option>
													<option value="-" ${stazione.tendenza=='-'?'selected':''}>&#x25BC;</option>
													<option value="?" ${stazione.tendenza=='?'?'selected':''}>?</option>
												</select>
												
											</td>
											<td style="text-align:center;">
												<input
													type="hidden"
													name="<portlet:namespace/>oraLivelloOsservato_${stazione.stazione.id}"
													value="${stazione.oraUltimoLivello}"
													/>
												${stazione.oraUltimoLivello}
											</td>									
											<td style="text-align:center;">
												<input
													type="hidden"
													name="<portlet:namespace/>ultimoLivello_${stazione.stazione.id}"
													value="${stazione.ultimoLivello}"
													/>
												${stazione.ultimoLivello}
											</td>
											<!-- 
											<td>
											
												<input
													type="text" 
													value="${bacino.ore}" 
													id="ore_${stazione.stazione.id}"
													name= "<portlet:namespace/>ore_${stazione.stazione.id}"
													class="form-control corto"  />
													
												 
												<button 
													type="button" 
													onclick="<portlet:namespace/>getBollettinoData('<%=generateOraURL.toString()%>', ${bacino.bac.id})"
													class="btn btn-primary">Genera
												</button>
												
											</td>
											-->
											
											<td style="text-align:center;">
												<!--  ${not stazione.selezionata ? 'readonly' : ''} -->
												<input type="text" 
													id="livelloprevisto_${sid}" 
													name="<portlet:namespace/>livelloprevisto_${stazione.stazione.id}" 
													value="${stazione.livelloPrevisto}" 
													class="corto"
													style="padding:.375rem !important; max-width:6em" 
													maxlength="10"
													${not stazione.selezionata ? 'readonly' : ''}>
											</td>
											<td style="text-align:center;">
												<input 
													type="text" 
													id="giornoprevisto_${sid}" 
													name="<portlet:namespace/>giornoprevisto_${stazione.stazione.id}" 
													value="${stazione.giornoPrevisto}" 
													class="corto"
													style="padding:.375rem !important; max-width:6em" 
													maxlength="10"
													${not stazione.selezionata ? 'readonly' : ''}>
											</td>
											<td style="text-align:center;">
											<!-- ${not stazione.selezionata ? 'readonly' : ''} -->
												<input 
													type="text" 
													id="oraprevista_${sid}" 
													name="<portlet:namespace/>oraprevista_${stazione.stazione.id}" 
													value="${stazione.oraPrevista}" 
													class="corto"
													style="padding:.375rem !important; max-width:6em" 
													maxlength="10"
													${not stazione.selezionata ? 'readonly' : ''}>
											</td>
											<td style="text-align:center;">
												<input 
													type="checkbox" ${stazione.osservato ? 'checked' : ''}
													id= "osserv_${sid}"
													name="<portlet:namespace/>osserv_${stazione.stazione.id }"
													${not stazione.selezionata ? 'readonly' : ''}>
											</td>
											<td style="text-align:center;">${stazione.stazioneVariabile.soglia1}</td>
											<td style="text-align:center;">${stazione.stazioneVariabile.soglia2}</td>
											<td style="text-align:center;">${stazione.stazioneVariabile.soglia3}</td>
										</tr>
									</tbody>
									</c:forEach>
									<tfoot>
										<tr>
											<td colspan="13">
												<div class="form-group">
													<label class="label-control">Note</label>
														<textarea 
															style="height: 100px" 
															class="form-control" 
															name="<portlet:namespace/>note_${bacino.bac.id}">${bacino.note}</textarea>
												</div>
											</td>
										</tr>
									</tfoot>
		
								</table>
								
								
							</div>
						</div>
						<br />
		
					</c:forEach>
				
				</div>
		
				
			</div>
			
			<div class="row">
			
				<div class="col-12">
					<label class="control-label" for="date-picker--2">Approvatore Arpae</label>
		
					<select id="elencoApprovatori" name="<portlet:namespace/>elencoApprovatori">
					<%for(SelectItem item : bollettinoBean.getListaApprovatoriArpae(themeDisplay)) {%>
						<option value="<%=item.getKey() %>"> <%=item.getValue() %> </option>
					<%} %>
					</select>
				</div>
				
				<%if( bollettinoBean.isMostraSalva()) { %>
				<div class="col-4">
					<button 
						type="button" 
						onclick="<portlet:namespace/>submitBollettinoForm('<%=salvaURL.toString()%>')"
						class="btn btn-primary">Salva monitoraggio
					</button>
				</div>
				<%} %>
				
				<%if( bollettinoBean.isMostraSalva()) { %>
				<div class="col-4">
					<button 
						type="button" 
						onclick="<portlet:namespace/>submitBollettinoForm('<%=ricaricaURL.toString()%>')"
						class="btn btn-primary">Ricarica dati osservati
					</button>
				</div>
				<%} %>
				
				<%if( bollettinoBean.isMostraInviaApprovazione()) { %>
				<div class="col-4">
					<button 
						type="button" 
						onclick="<portlet:namespace/>submitBollettinoForm('<%=salvaInviaURL.toString()%>')"
						class="btn btn-primary">Salva e invia per approvazione
					</button>	
				</div>
				<%} %>
				<!-- 
				<div class="col-4">
					<button 
						type="button" 
						onclick="<portlet:namespace/>submitBollettinoForm('<%=salvaURL.toString()%>')"
						class="btn btn-primary">Ricarica livelli osservati
					</button>	
				</div>
				 -->
				
			</div>
		</aui:form>
		
		
	</div>
</main>	
<script type="text/javascript">

(function($) {
	   
	
		var approvatoreId = '<%=bollettinoBean.getApprovatoreArpae()%>';
		
		if( approvatoreId != '') {
			
			$('#elencoApprovatori').val(approvatoreId);
		}
		
	
})(jQuery);	
			
		

	function <portlet:namespace/>selection(stzId) {
		
		(function($) {
		
		if( $('#' + stzId).is(":checked")) {
			
			$('#livelloprevisto_' + stzId).removeAttr('readonly');
			$('#giornoprevisto_' + stzId).removeAttr('readonly');
			$('#oraprevista_' + stzId).removeAttr('readonly');
			
		} else {
			
			$('#livelloprevisto_' + stzId).attr('readonly', true);
			$('#giornoprevisto_' + stzId).attr('readonly', true);
			$('#oraprevista_' + stzId).attr('readonly', true);
			
		}
		
		})(jQuery);	
		
	}

	function <portlet:namespace/>getBollettinoData(resourceUrl, oraId) {
		
		(function($) {
		
		$.ajax({
	        type : "POST",
	        url : resourceUrl,
	    	success: function(result) {
	    		if( oraId == -1)
	    			$('#numero').val(result);
	    		else
	    			$('#ora_' + oraId).val(result);
	    		
	    		console.log('Dati: ' + result);
	    		
	     	},
	        async : false
		});
		
		})(jQuery);	 
	}
	function <portlet:namespace/>submitBollettinoForm(actionUrl) {
		
		(function($) {
		$('.stazionecbx:checkbox:checked').each(function(stazione) {
			
			var sid = $(this).attr('id');	
			
			console.log('stazione : ', sid);
			
			var bid = $('#bacino' + sid).val();
			
			console.log('bacino : ', bid);
			
			if( $('#bacini_selected').val().indexOf('_' + bid) < 0 )
				$('#bacini_selected').val( $('#bacini_selected').val() + '_' + bid );
			
		});
		
		console.log('alls : ', $('#bacini_selected').val());
	
		document.forms.<portlet:namespace/>fmCompila.action = actionUrl;
		
		document.forms.<portlet:namespace/>fmCompila.submit();
		
		})(jQuery);	 
	}
	
	
	function toggleVis(x) {

		(function($) {
		var table = $(".table_"+x); // document.getElementsByTagName("table");
		var i;

		var elems = table.get();
		
		for (i in elems) {
			//if ((' ' + elems[i].className + ' ').indexOf(' ' + x + ' ') > -1) {

				if (elems[i].className.indexOf("visibile") > -1)
					elems[i].className = elems[i].className.replace(
							"visibile", "nascosto");
				else
					elems[i].className = elems[i].className.replace(
							"nascosto", "visibile");
				//return;
			//}
		} 
		})(jQuery);	 
	}
	

</script>
