<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="it.eng.allerta.utils.AllertaKeys"%>
<%@page import="it.eng.allerter.allerta.AllertaValangheBean"%>
<%@ include file="../init.jsp"%>

<%
long allertaValangheId = ParamUtil.getLong(request, "allertaValangheId");
boolean descrizioneFenomeni = ParamUtil.getBoolean(request,"descrizioneFenomeni");
boolean sintesi = ParamUtil.getBoolean(request,"sintesi");
AllertaValangheBean allBean = new AllertaValangheBean(allertaValangheId, request);
%>

<portlet:resourceURL var="allertaValangheFieldsDefaultstURL">
</portlet:resourceURL>

<portlet:actionURL var="generateNumeroURL" name="/allertaer/allerta_valanghe/rigenera">
	<portlet:param name="cmd" value="numero"/>
</portlet:actionURL>

<portlet:actionURL var="generateTitoloURL" name="/allertaer/allerta_valanghe/rigenera">
	<portlet:param name="cmd" value="titolo"/>
</portlet:actionURL>

<portlet:actionURL var="salvaSintesiURL" name="/allertaer/allerta_valanghe/salva-sintesi">
		<portlet:param name="redirect" value="<%=themeDisplay.getURLCurrent() %>"/>		
	</portlet:actionURL>

<portlet:actionURL var="salvaDescrizioneFenomeniURL" name="/allertaer/allerta_valanghe/salva-descrizioneFenomeni">
	<portlet:param name="redirect" value="<%=themeDisplay.getURLCurrent() %>"/>		
</portlet:actionURL>

<portlet:actionURL var="salvaURL" name="/allertaer/allerta_valanghe/salva">
	<portlet:param name="redirect" value="<%=themeDisplay.getURLCurrent() %>"/>		
</portlet:actionURL>

<portlet:actionURL var="salvaInviaURL" name="/allertaer/allerta_valanghe/salva-invia">
	<portlet:param name="redirect" value=""/>		
</portlet:actionURL>

<portlet:actionURL var="eliminaURL" name="/allertaer/allerta_valanghe/elimina">
	<portlet:param name="redirect" value=""/>		
</portlet:actionURL>

<c:set value="<%=allBean%>" var="allBean" scope="request"></c:set>

<aui:form method="post" name="fmCompila" id="fmCompila">	
	<input type="hidden" name="allertaValangheId" value="${allBean.allertaValangheId}">
	<input type="hidden" id="generaField" name="generaField" value="">
	
	<script type="text/javascript">
		function <portlet:namespace/>getAllertaValangheDefaults(field, serviceUrl) {			
			$('#generaField').val(field);
			
			serviceUrl += "&allerta=" + isAllertaValanghe();
		
			$.ajax({
		      url: serviceUrl,
		      method: 'POST',
		      data: $('#<portlet:namespace/>fmCompila').serialize(),
		      dataType: 'text',
		    }).then(function (resp) {		   
		    	if( field == 'titolo') {
		    		var dat = $('input[name ="dataInizio"]')[0].value.split(' ')
		    		var dat2 = dat[0].replace('/','-').replace('/','-')
		    		resp = resp.replace('HH:mm',dat[1])
		    		resp = resp.replace('DD/MM/YYYY',dat2)
		    		$('#titolo').val(resp);
		    	}
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
					
	<div class="row w-100 justify-content-between" style="min-width:1000px">
        <h1 class="col-12 col-lg-8">Compila Allerta Valanghe</h1>
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
	           					<c:when test="${allBean.allertaValangheCorrente.tipoAllerta}">
	           						Allerta valanghe
	           					</c:when>
	           					<c:otherwise>
						            Bollettino valanghe
						         </c:otherwise>
           					</c:choose>
           				</div>
        			</div>
        			
        			<div class="card-body">
              			<p class="card-text">
                  			<a href='${allBean.allertaValangheCorrente.link}'
							   class="btn btn-primary" target="_blank">Visualizza PDF</a>
              			</p>
	       			</div>        			
				<!-- /  Card -->					
				</div>				
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
	
	<% if (!allBean.isDueGiorni()) { %>
		<style>
		.soloSeDueGiorni {
			display: none
		}
		</style>
	<% } %>
	
	
	<div class="panel panel--foreground panel--reserved-tools">	
    	<div class="row panel__body">    	
    		<div class="col form-group">
				<label class="control-label" for="datetimepicker1"> Inizio Validit&agrave;</label>
		
				<div class='input-group date input-group--date-picker' id="datetimepicker1">
		            <input type="text" <%=sintesi?"disabled":"" %>
		            	   class="form-control"	name="dataInizio" value="${allBean.dataInizioString}" 
						   placeholder="gg/mm/aaaa" />
	                <span class="input-group-addon">
	                   <i class="far fa-calendar-minus"></i>
	                </span>
	             </div>				                
	  
	             <script type="text/javascript">
		            $(function () {
		                $('#datetimepicker1').datetimepicker({
		                	<%if( allertaValangheId <=0) {%>
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
				<label class="control-label" for="datetimepicker2"> Fine Validit&agrave;</label>
							
				<div class='input-group date input-group--date-picker' id="datetimepicker2">
					<input type="text" <%=sintesi?"disabled":"" %>
						   class="form-control"	name="dataFine"	value="${allBean.dataFineString}" 
						   placeholder="gg/mm/aaaa"/>		
					 <span class="input-group-addon">
	                    <i class="far fa-calendar-minus"></i>
	                 </span>			
				</div>
				
			    <script type="text/javascript">
		            $(function () {
		                $('#datetimepicker2').datetimepicker({
		                	
		                	<%if( allertaValangheId <=0) {%>
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
			
			<div class="col form-group">
				<label class="control-label" for="duegriglie">Due griglie</label>
				<input <%=sintesi?"disabled":""  %>
					type="checkbox" <%=allBean.isDueGiorni()?"checked":"" %>
					style="width:32px;-webkit-appearance:checkbox"
					class="form-control" id="duegriglie" 
					name="duegriglie"
					onclick="aggiornaIntestazioni($('#duegriglie')[0].checked);$('.soloSeDueGiorni').each(function(i, obj) { obj.style.display = $('#duegriglie')[0].checked?'flex':'none';});"
					
					/>
			</div>	
    	</div>
	</div>

	<div class="row soloSeDueGiorni">
	</div>
	<div class="row soloSeDueGiorni">
		<h4 style="margin-left:auto;margin-right:auto" id="intest2">Situazione dalle 12:00 di oggi</h4>	
		
	</div>

	<div class="row soloSeDueGiorni">
		<div class="col-12 ">
			<jsp:include page="/allerta_valanghe/component/svgOggi.jsp"></jsp:include>
		</div>
	</div>

	<div class="row soloSeDueGiorni">
		<div class="col-12">
			<div class="rf-cp-b" style="display: block">
				<table class="table-responsive-md">
					<thead class="rf-dt-thd">
						<tr class="rf-dt-shdr">
							<th scope="col"></th>
							<th class="rf-dt-shdr-c" onclick="toggleValangheColonnaOggi(1);" scope="col">${allBean.eventi[0]}</th>
						</tr>
					</thead>
					
					<tbody>
						<c:forEach items="${allBean.grigliaOggi}" var="riga">
							<tr class="rf-dt-r rf-dt-fst-r">	
								<td class="rf-dt-shdr-c">${riga.nomeRiga}</td>							
								<c:forEach items="${riga.celle}" var="cella">
									<td id="cellaOggi${cella.riga}-${cella.colonna}-1" class="rf-dt-c ${cella.style1}"
										<% if (!sintesi) { %>onclick="toggleAllertaValangheOggi(${cella.riga},${cella.colonna},1);"<% } %> >										
										<input type="hidden" id="inputOggi${cella.riga}-${cella.colonna}-1"	name="inputOggi${cella.riga}-${cella.colonna}-1"										   
											   value="${cella.valori[0].valore}"> 
										<span id="testoOggi${cella.riga}-${cella.colonna}-1">${cella.stringaColore1}</span>
									</td>
								</c:forEach>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
	<div class="row">
	</div>
	<div class="row soloSeDueGiorni">
		<h4 style="margin-left:auto;margin-right:auto" id="intest">Situazione dalle 00:00 di domani</h4>	
	</div>

	<div class="row">
		<div class="col-12 ">
			<jsp:include page="/allerta_valanghe/component/svg.jsp"></jsp:include>
		</div>
	</div>

	<div class="row">
		<div class="col-12">
			<div class="rf-cp-b" style="display: block">
				<table class="table-responsive-md">
					<thead class="rf-dt-thd">
						<tr class="rf-dt-shdr">
							<th scope="col"></th>
							<th class="rf-dt-shdr-c" onclick="toggleValangheColonna(1);" scope="col">${allBean.eventi[0]}</th>
						</tr>
					</thead>
					
					<tbody>
						<c:forEach items="${allBean.griglia}" var="riga">
							<tr class="rf-dt-r rf-dt-fst-r">	
								<td class="rf-dt-shdr-c">${riga.nomeRiga}</td>							
								<c:forEach items="${riga.celle}" var="cella">
									<td id="cella${cella.riga}-${cella.colonna}-1" class="rf-dt-c ${cella.style1}"
										<% if (!sintesi) { %>onclick="toggleAllertaValanghe(${cella.riga},${cella.colonna},1);"<% } %> >										
										<input type="hidden" id="input${cella.riga}-${cella.colonna}-1"	name="input${cella.riga}-${cella.colonna}-1"										   
											   value="${cella.valori[0].valore}"> 
										<span id="testo${cella.riga}-${cella.colonna}-1">${cella.stringaColore1}</span>
									</td>
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
			<button type="button" onclick="<portlet:namespace/>getAllertaValangheDefaults('numero', '<%=allertaValangheFieldsDefaultstURL.toString()%>')"
				class="btn btn-primary">Genera</button>
			</c:if>
		</div>

		<div class="col-6 form-group">
		
			<label class="control-label">Titolo</label>
			<input <%=sintesi?"disabled":"" %> id="titolo" type="text" name="titolo" value="${allBean.titolo}" class="form-control">
			<c:if test="<%=!sintesi %>">
			<button 
				type="button"  
				onclick="<portlet:namespace/>getAllertaValangheDefaults('titolo','<%=allertaValangheFieldsDefaultstURL.toString()%>')"
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
			<textarea <%=sintesi?"disabled":"" %> name=descrizioneFenomeni style="height: 100px" class="form-control">${allBean.descrizioneFenomeni}</textarea>
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
	           					<c:when test="${allBean.allertaValangheCorrente.tipoAllerta}">
	           						Allerta valanghe
	           					</c:when>
	           					<c:otherwise>
						            Bollettino valanghe
						         </c:otherwise>
           					</c:choose>
           				</div>
        			</div>
        			<div class="card-body">
               			<p class="card-text">
                   			<a href="${allBean.allertaValangheCorrente.link}" class="btn btn-primary" target="_blank">Visualizza PDF</a>
               			</p>
        			</div>
				</div>
				<!-- /  Card -->					
			</div>				
		</div>	
	</c:if>
	
<script type="text/javascript">
	function <portlet:namespace/>submitAllertaValangheForm(actionUrl) {
		document.forms.<portlet:namespace/>fmCompila.action = actionUrl;
		document.forms.<portlet:namespace/>fmCompila.submit();	          
	}	
</script>
	
<aui:button-row>	
	<c:if test="<%=sintesi %>">
			<button type="button" onclick="<portlet:namespace/>submitAllertaValangheForm('<%=salvaSintesiURL.toString()%>')"
				class="btn btn-primary">Salva sintesi</button>
	</c:if>
	
	<c:if test="<%=!sintesi %>">
		<c:if test="${allBean.mostraSalva }">
		<button type="button" onclick="<portlet:namespace/>submitAllertaValangheForm('<%=salvaURL.toString()%>')"
			    class="btn btn-primary">Salva</button>				
		</c:if>
		
		<c:if test="${allBean.mostraInviaApprovazione }">
		<button type="button" onclick="<portlet:namespace/>submitAllertaValangheForm('<%=salvaInviaURL.toString()%>')"
			    class="btn btn-primary">Salva e invia per approvazione</button>				
		</c:if>
		
		<c:if test="${allBean.mostraInviaApprovazione }">
		<button type="button" onclick="<portlet:namespace/>submitAllertaValangheForm('<%=eliminaURL.toString()%>')"
			class="btn btn-secondary">Elimina</button>				
		</c:if>
	</c:if>
</aui:button-row>
	
</aui:form>



