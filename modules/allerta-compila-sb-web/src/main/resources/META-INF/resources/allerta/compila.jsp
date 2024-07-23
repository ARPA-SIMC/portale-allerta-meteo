<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="it.eng.allerta.utils.AllertaKeys"%>
<%@page import="it.eng.allerter.allerta.AllertaBean"%>
<%@ include file="../init.jsp"%>

<%
long allertaId = ParamUtil.getLong(request, "allertaId");
boolean sintesi = ParamUtil.getBoolean(request,"sintesi");

AllertaBean allBean = new AllertaBean(allertaId, request);

%>

	<portlet:resourceURL var="allertaFieldsDefaultstURL">
	</portlet:resourceURL>

	<portlet:actionURL var="generateNumeroURL" name="/allertaer/allerta/rigenera">
		<portlet:param name="cmd" value="numero"/>
	</portlet:actionURL>

	<portlet:actionURL var="generateTitoloURL" name="/allertaer/allerta/rigenera">
		<portlet:param name="cmd" value="titolo"/>
	</portlet:actionURL>

	<portlet:actionURL var="salvaSintesiURL" name="/allertaer/allerta/salva-sintesi">
		<portlet:param name="redirect" value="<%=themeDisplay.getURLCurrent() %>"/>		
	</portlet:actionURL>
	
	<portlet:actionURL var="salvaURL" name="/allertaer/allerta/salva">
		<portlet:param name="redirect" value="<%=themeDisplay.getURLCurrent() %>"/>		
	</portlet:actionURL>
	
	<portlet:actionURL var="salvaInviaURL" name="/allertaer/allerta/salva-invia">
		<portlet:param name="redirect" value=""/>		
	</portlet:actionURL>
	
	<portlet:actionURL var="eliminaURL" name="/allertaer/allerta/elimina">
		<portlet:param name="redirect" value=""/>		
	</portlet:actionURL>

<c:set value="<%=allBean%>" var="allBean" scope="request"></c:set>


<aui:form method="post" name="fmCompila" id="fmCompila">
	
	<input type="hidden" name="allertaId" value="${allBean.allertaId}">
	<input type="hidden" id="generaField" name="generaField" value="">
	
	<script type="text/javascript">
		function <portlet:namespace/>getAllertaDefaults(field, serviceUrl){
			
			$('#generaField').val(field);
			
			serviceUrl += "&allerta=" + isAllerta();
			
			console.log(serviceUrl);
		
			$.ajax({
			      url: serviceUrl,
			      method: 'POST',
			      data: $('#<portlet:namespace/>fmCompila').serialize(),
			      dataType: 'text',
			    }).then(function (resp) {
			   
			    	if( field == 'titolo')
			    		$('#titolo').val(resp);
			    	else if( field == 'numero')
			    		$('#numero').val(resp);
			    	
			      	if (resp.hasError) {
			      		console.log('error');
			      	} else {
			        	console.log('success');
			      	}
			      	
			    }).fail(function (resp) {
			      	console.log('fail');
			});
			
		}
	</script>	
					
	<div class="row w-100 justify-content-between">
        <h1 class="col-12 col-lg-8">Compila Allerta</h1>
	</div>
                    
	<c:if test="${allBean.url != null }">
		
		<div class="row">
			<div class="col">
				<!-- Card -->
				<div class="card card--standard ">
        			<div class="card-header">
           				<div class="card__thumbnail">
               				<span class="icon i-info" title="Icona di card di informazione"></span>
          				</div>
           				<div class="card__category">
           					Visualizza 
           					<c:choose>
	           					<c:when test="${allBean.allertaCorrente.tipoAllerta}">
	           						Allerta
	           					</c:when>
	           					<c:otherwise>
						            Bollettino
						         </c:otherwise>
           					</c:choose>
           				</div>
        			</div>
        			
        			<div class="card-body">
              			<p class="card-text">
                  			<a href='${allBean.allertaCorrente.link}'
							class="btn btn-primary" target="_blank">Visualizza PDF</a>
              			</p>
	       			</div>
        			
				<!-- /  Card -->
					
			</div>
				
		</div>
	
	</c:if>
	<div class="row">
	
		<div class="col">
	
		<c:if test="<%=SessionErrors.contains(request, Exception.class) %>">
	 		<div class="alert alert-danger" role="alert">
    			<span class="icon i-error"></span> 
    			<span><%= SessionErrors.get(request, Exception.class)%></span>
  			</div>
		</c:if>		
		
		<liferay-ui:success key="saved" message="Salvataggio riuscito" />
	
		</div>
	
	</div>
	
	
	
	<div class="panel panel--foreground panel--reserved-tools">
	
    	<div class="row panel__body">
    	
    		<div class="col form-group">

				<label class="control-label" for="datetimepicker1"> Inizio
					Validit&agrave;</label>
	
	<!-- 
				<div class="input-group input-group--date-picker">
					<input type="text" class="datepicker" name="dataInizio"
						value="${allBean.dataInizioString}" placeholder="gg/mm/aaaa">
					</div>
				</div>
	 -->			
				<div class='input-group date input-group--date-picker' id="datetimepicker1">
		            <input <%=sintesi?"disabled":"" %>
						type="text" 
						class="form-control" 
						name="dataInizio"
						value="${allBean.dataInizioString}" 
						placeholder="gg/mm/aaaa" />
	                <span class="input-group-addon">
	                   <i class="far fa-calendar-minus"></i>
	                </span>
	             </div>
				                
	  
	             <script type="text/javascript">
		            $(function () {
		                $('#datetimepicker1').datetimepicker({
		                	<%if( allertaId <=0) {%>
		                	useCurrent: false,
		                	date: moment().add('d', 1).startOf('day').toDate(),
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

			<div class="col form-group">
				<label class="control-label" for="datetimepicker2"> Fine
					Validit&agrave;</label>
	
	<!-- 
					<div class="input-group input-group--date-picker">
					<input type="text" class="datepicker" name="dataFine"
						value="${allBean.dataFineString}" placeholder="gg/mm/aaaa">					
					</div>
	 -->
							
				<div class='input-group date input-group--date-picker' id="datetimepicker2">
					<input <%=sintesi?"disabled":"" %>
						type="text" 
						class="form-control" 
						name="dataFine"
						value="${allBean.dataFineString}" 
						placeholder="gg/mm/aaaa"/>		
					 <span class="input-group-addon">
	                    <i class="far fa-calendar-minus"></i>
	                 </span>			
				</div>
				
			    <script type="text/javascript">
		            $(function () {
		                $('#datetimepicker2').datetimepicker({
		                	
		                	<%if( allertaId <=0) {%>
		                	useCurrent: false,
		                	date: moment().add('d', 2).hours(0).minutes(0).seconds(0).toDate(),
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


	<div class="row">
	
		

	</div>

	<div class="row">
		<div class="col-6 ">
			<h2 class="h2">Criticità idraulica, idrogeologica, temporali</h2>
			<jsp:include page="/allerta/component/svg.jsp"></jsp:include>
		</div>
		<div class="col-6 ">
			<h2 class="h2">Criticità meteo e marino-costiera</h2>
			<jsp:include page="/allerta/component/svg2.jsp"></jsp:include>
		</div>
	</div>



	<div class="row">
		<div class="col-12">
			<div class="rf-cp-b" style="display: block">
				<table class="table-responsive-md">
					<thead class="rf-dt-thd">
						<tr class="rf-dt-shdr">
							<th scope="col"></th>
							<th scope="col"></th>
							<th class="rf-dt-shdr-c" <% if (!sintesi) { %>onclick="toggleColonna(1);"<% } %> scope="col">${allBean.eventi[0]}</th>
							<th class="rf-dt-shdr-c" <% if (!sintesi) { %>onclick="toggleColonna(2);"<% } %> scope="col">${allBean.eventi[1]}</th>
							<th class="rf-dt-shdr-c bordodestro" <% if (!sintesi) { %>onclick="toggleColonna(3);"<% } %>
								scope="col">${allBean.eventi[2]}</th>
							<th class="rf-dt-shdr-c" <% if (!sintesi) { %>onclick="toggleColonna(4);"<% } %> scope="col">${allBean.eventi[3]}</th>
							<th class="rf-dt-shdr-c" <% if (!sintesi) { %>onclick="toggleColonna(5);"<% } %> scope="col">${allBean.eventi[4]}</th>
							<th class="rf-dt-shdr-c" <% if (!sintesi) { %>onclick="toggleColonna(6);"<% } %> scope="col">${allBean.eventi[5]}</th>
							<th class="rf-dt-shdr-c bordodestro" <% if (!sintesi) { %>onclick="toggleColonna(7);"<% } %>
								scope="col">${allBean.eventi[6]}</th>
							<th class="rf-dt-shdr-c" <% if (!sintesi) { %>onclick="toggleColonna(8);"<% } %> scope="col">${allBean.eventi[7]}</th>
							<th class="rf-dt-shdr-c" <% if (!sintesi) { %>onclick="toggleColonna(9);"<% } %> scope="col">${allBean.eventi[8]}</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${allBean.griglia}" var="riga">

							<tr class="rf-dt-r rf-dt-fst-r">
								<td rowspan="2" class="rf-dt-shdr-c">${riga.nomeRiga}</td>
								<td rowspan="${riga.rowspan}" class="rf-dt-shdr-c">
									${riga.rowspan eq '1' ? '1' : ''}</td>
								<c:forEach items="${riga.celle}" var="cella">
									<td 
									
									<% if (!sintesi) { %>onclick="toggleAllerta(${cella.riga},${cella.colonna},1);"<% } %>
										id="cella${cella.riga}-${cella.colonna}-1"
										rowspan="${cella.rowspan}" class="rf-dt-c ${cella.style1}">

										<input type="hidden" value="${cella.valori[0].valore}"
										id="input${cella.riga}-${cella.colonna}-1"
										name="input${cella.riga}-${cella.colonna}-1"> <span
										id="testo${cella.riga}-${cella.colonna}-1">${cella.stringaColore1}</span>
									</td>
								</c:forEach>
							</tr>
							<tr>
								<c:if test="${riga.divisa}">
									<td class="rf-dt-shdr-c">2</td>
								</c:if>

								<c:forEach items="${riga.celle}" var="cella">
									<c:if test="${cella.rowspan eq '1'}">

										<td <% if (!sintesi) { %>onclick="toggleAllerta(${cella.riga},${cella.colonna},2);"<% } %>
											id="cella${cella.riga}-${cella.colonna}-2"
											rowspan="${cella.rowspan}" class="rf-dt-c ${cella.style2}">

											<input type="hidden" value="${cella.valori[1].valore}"
											name="input${cella.riga}-${cella.colonna}-2"> <span
											id="testo${cella.riga}-${cella.colonna}-2">${cella.stringaColore2}</span>
										</td>

									</c:if>
								</c:forEach>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>


	<div class="row">
	
		<div class="col-6 form-group">
			<label class="control-label">Numero</label>
			<input <%=sintesi?"disabled":"" %> id="numero" type="text" name="numero" value="${allBean.numero}" class="form-control">
			<c:if test="<%=!sintesi %>">
			<button type="button" onclick="<portlet:namespace/>getAllertaDefaults('numero', '<%=allertaFieldsDefaultstURL.toString()%>')"
				class="btn btn-primary">Genera</button>
			</c:if>
		</div>

		<div class="col-6 form-group">
		
			<label class="control-label">Titolo</label>
			<input <%=sintesi?"disabled":"" %> id="titolo" type="text" name="titolo" value="${allBean.titolo}" class="form-control">
			<c:if test="<%=!sintesi %>">
			<button 
				type="button"  
				onclick="<portlet:namespace/>getAllertaDefaults('titolo','<%=allertaFieldsDefaultstURL.toString()%>')"
				class="btn btn-primary">Genera</button>
			</c:if>
		</div>
	</div>
	
		
	<div class="row">
		<div class="col-6 form-group">
			<label class="control-label">Sintesi</label>
			<textarea name="sintesi" style="height: 100px" class="form-control">${allBean.sintesi}</textarea>
		</div>
		
		<div class="col-6 form-group">
			<label class="control-label">Descrizione dei fenomeni</label>
			<textarea <%=sintesi?"readonly":"" %> name=descrizioneMeteo style="height: 100px" class="form-control">${allBean.descrizioneMeteo}</textarea>
		</div>
		
	</div>
	
	<div class="row">
		<div class="col-6 form-group">
			<label class="control-label">Tendenza nelle successive 48 ore</label>
			<select name="tendenza" class="form-control" <%=sintesi?"disabled":"" %>>
				<option value="1" ${allBean.tendenza == '1' ? 'selected' : ''}>Intensificazione</option>
				<option value="2" ${allBean.tendenza == '2' ? 'selected' : ''}>Stazionariet&agrave;</option>
				<option value="3" ${allBean.tendenza == '3' ? 'selected' : ''}>Attenuazione</option>
				<option value="4" ${allBean.tendenza == '4' ? 'selected' : ''}>In esaurimento</option>
			</select>
			
		</div>
	</div>
	
	<div class="row">
		<div class="col-6 form-group">
			<label class="control-label">Note</label>
			<textarea <%=sintesi?"readonly":"" %> name="note" style="height: 100px" class="form-control">${allBean.note}</textarea>
		</div>
		
		<div class="col-6 form-group">
			<label class="control-label">Riferimenti e contatti</label>
			<textarea <%=sintesi?"readonly":"" %> name=riferimenti style="height: 100px" class="form-control">${allBean.riferimenti}</textarea>
		</div>
		
	</div>
	
	<div class="row">
		<div class="col-6 form-group">
			<label class="control-label">Approvatore Arpae</label>
			<select name="approvatoreArpae" class="form-control" <%=sintesi?"disabled":"" %>>
				<option></option>
			<%
			for(User approvatore : allBean.getListaApprovatoriArpae()) {
				long approvatoreId = approvatore.getUserId();
			%>
			<option value="<%=approvatoreId%>" 
			<%=String.valueOf(approvatoreId).equals(allBean.getApprovatoreArpae()) ? "selected" : ""%>>
			<%=approvatore.getFullName() %></option>
			<%
			}
			%>
			</select>
		</div>
		
		<div class="col-6 form-group">
			<label class="control-label">Approvatore Protezione Civile</label>
			<select name="approvatorePc" class="form-control" <%=sintesi?"disabled":"" %>>
				<option></option>
			<%
			for(User approvatore : allBean.getListaApprovatoriPc()) {
				long approvatoreId = approvatore.getUserId();
			%>
			<option value="<%=approvatoreId%>"
			<%=String.valueOf(approvatoreId).equals(allBean.getApprovatorePc()) ? "selected" : ""%>>
			<%=approvatore.getFullName() %></option>
			<%
			}
			%>
			</select>
		</div>
	</div>
	
	
	<c:if test="${allBean.url != null }">
		
		<div class="row">
			<div class="col-9">
				<!-- Card -->
				<div class="card card--standard ">
        			<div class="card-header">
           				<div class="card__thumbnail">
               				<span class="icon i-info" title="Icona di card di informazione"></span>
          				</div>
           				<div class="card__category">
           					Visualizza 
           					<c:choose>
	           					<c:when test="${allBean.allertaCorrente.tipoAllerta}">
	           						Allerta
	           					</c:when>
	           					<c:otherwise>
						            Bollettino
						         </c:otherwise>
           					</c:choose>
           				</div>
        			</div>
        			<div class="card-body">
               			<p class="card-text">
                   			<a href="${allBean.allertaCorrente.link}" class="btn btn-primary" target="_blank">Visualizza PDF</a>
               			</p>
        			</div>
				</div>
				<!-- /  Card -->
					
			</div>
				
		</div>
	
	</c:if>
	
<script type="text/javascript">
	function <portlet:namespace/>submitAllertaForm(actionUrl) {
		document.forms.<portlet:namespace/>fmCompila.action = actionUrl;
		document.forms.<portlet:namespace/>fmCompila.submit();
	          
	}
	
</script>
	
	<aui:button-row>
	
		<c:if test="<%=sintesi %>">
			<button type="button" onclick="<portlet:namespace/>submitAllertaForm('<%=salvaSintesiURL.toString()%>')"
				class="btn btn-primary">Salva sintesi</button>
		</c:if>
		
		<c:if test="<%=!sintesi %>">
		<c:if test="${allBean.mostraSalva }">
			<button type="button" onclick="<portlet:namespace/>submitAllertaForm('<%=salvaURL.toString()%>')"
				class="btn btn-primary">Salva</button>
			
		</c:if>
		
		<c:if test="${allBean.mostraInviaApprovazione }">
			<button type="button" onclick="<portlet:namespace/>submitAllertaForm('<%=salvaInviaURL.toString()%>')"
				class="btn btn-primary">Salva e invia per approvazione</button>
			
		</c:if>
		
		<c:if test="${allBean.mostraInviaApprovazione }">
			<button type="button" onclick="<portlet:namespace/>submitAllertaForm('<%=eliminaURL.toString()%>')"
				class="btn btn-secondary">Elimina</button>
			
		</c:if>
		</c:if>

	</aui:button-row>
	
</aui:form>



