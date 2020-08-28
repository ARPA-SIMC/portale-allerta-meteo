<%@page import="it.eng.allerter.allerta.AllarmeBean"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@ include file="../init.jsp" %>

<%
AllarmeBean allarme = (AllarmeBean) request.getAttribute("allarme");
%>

<c:set value="<%=allarme%>" var="allarme" scope="request"></c:set>

<portlet:actionURL var="salvaURL" name="/allertaer/regola/salva">
	<portlet:param name="redirect" value=""/>		
</portlet:actionURL>

<portlet:resourceURL var="eliminaCondizione" >
	<portlet:param name="op" value="elimina-condizione"/>
</portlet:resourceURL>

<portlet:renderURL var="listaURL">
	<portlet:param name="redirect" value=""/>		
</portlet:renderURL>

<main class="page main" id="main-content">

	<div class="container page__body" >
	
		<div class="col-12">
	
			<c:if test="<%=SessionErrors.contains(request, Exception.class) %>">
		 		<div class="alert alert-danger" role="alert">
	    			<span class="icon i-error"></span> 
	    			<span><%= SessionErrors.get(request, Exception.class)%></span>
	  			</div>
			</c:if>	
		</div>
		
		
		<div>
		
			<aui:form method="post" name="fmAllarme" action="<%=salvaURL.toString()%>">
			
				<input
					type="hidden"
					name="<portlet:namespace/>idRegola"
					value="${allarme.regolaCorrente.id }" />
			
				<div class="col-12">
					<div class="form-group">
		    			<label for="nome">Nome</label>
		    			<input 
		    				type="text" 
		    				class="form-control" 
		    				id="nome"
		    				name="<portlet:namespace/>nome"
		    				value="${allarme.nome}"
		    				aria-describedby="nomeHelp" 
		    				placeholder="Nome regola"/>
		    			<small id="nomeHelp" class="form-text text-muted">Nome regola</small>
	  				</div>
	  				
	  				<div class="form-group">
		    			<label for="nome">Descrizione</label>
		    			<input 
		    				type="text" 
		    				class="form-control" 
		    				id="descrizione"
		    				value="${allarme.descrizione}"
		    				name="<portlet:namespace/>descrizione"
		    				placeholder="Descrizione Regola" />
	  				</div>
					
					<div class="form-group">
		    			<label for="nome">Espressione</label>
		    			<input 
		    				type="text" 
		    				class="form-control" 
		    				id="espressione"
		    				value="${allarme.espressione}"
		    				name="<portlet:namespace/>espressione"
		    				aria-describedby="espressioneHelp" 
		    				placeholder="Espressione" />
		    			<small id="espressioneHelp" class="form-text text-muted">Espressione (and, or, not, parentesi)</small>
	  				</div>
	  				
	  				<div class="form-group">
					    <label for="colore">Colore</label>
					    <select class="form-control" id="colore" name="<portlet:namespace/>colore">
					      <option value="1">Giallo</option>
					      <option value="2">Arancione</option>
					      <option value="3">Rosso</option>
					    </select>
					</div>
	
					<div class="form-check">
					  <input 
					  	class="form-check-input" 
					  	type="checkbox" 
					  	value="${allarme.attiva}"
					  	name="<portlet:namespace/>attiva" 
					  	id="attiva" />
					  <label class="form-check-label" for="attiva">
					    Attiva
					  </label>
					</div>  	
					
					<br/><br/>
				</div>
				
				<div class="col-12">
					<h2>Condizioni</h2>
					
					<input
						type="hidden"
						id="rules"
						name="<portlet:namespace/>rules" />
						
					<script>
						var dati_sensori = [];
						var dati_staz = [];
						var dati_soglia = [];
						var index = 0;
					</script>
					
					<table>
					
						<thead>
							<tr>
								<th>Identificatore</th>
								<th>Tipo sensore</th>
								<th>Stazione</th>
								<th>Soglia</th>
								<th>Elimina</th>
							</tr>
						</thead>
						
						<tbody id='conditions'>
						
							<c:forEach var="condizione" items="${allarme.condizioni}" varStatus="loop">
						
							<tr id="tr_${loop.index}">
								<td>
									<input 
					    				type="text" 
					    				class="form-control" 
					    				id="lettera_${loop.index}"
					    				value="${condizione.lettera }"
					    				name="<portlet:namespace/>lettera_${loop.index}"
					    				placeholder="Espressione" />
								</td>
								<td>
								    <select 
								    	class="form-control" 
								    	id="sensore_${loop.index}" 
								    	name="<portlet:namespace/>sensore_${loop.index}">
								    </select>
								</td>
								<td>
								    <select 
								    	class="form-control" 
								    	id="staz_${loop.index}" 
								    	name="<portlet:namespace/>staz_${loop.index}">
								    </select>
								</td>
								<td>
								    <select 
								    	class="form-control" 
								    	id="soglia_${loop.index}" 
								    	name="<portlet:namespace/>soglia_${loop.index}">
								    	
								    	<option value="1">1</option>
								    	<option value="2">2</option>
								    	<option value="3">3</option>
								    	
								    </select>
								</td>
								
								<td>
									<c:choose>
										<c:when test = "${loop.index == 0}">
											Sensore primario
										</c:when>
										<c:otherwise>
								            <button 
								            	type="button" 
								            	onclick="javascript:removeCondition(${condizione.condizione.idRegola }, ${loop.index})" 
								            	class="btn btn-primary">Elimina
								            	</button>
								        </c:otherwise>
									</c:choose>
									
								</td>
							</tr>
							
							<script>
								dati_sensori[${loop.index}] = "${condizione.variabile}" ;
								dati_staz[${loop.index}] = "${condizione.stazione}" ;
								dati_soglia[${loop.index}] = "${condizione.soglia}" ;
								
								index = ${loop.index};
							</script>
					
							</c:forEach>
						
						</tbody>
					</table>
					<br/><br/>
					${allarme.stringaComuni}
					<br/><br/>
				</div>
				
				
				<div class="col-12">
					<button
						type="button"
						onclick='javascript:addCondition();'
						class="btn btn-primary">
						Aggiungi Condizione
					</button>
					<br/><br/>
				</div>	
				
				<div class="col-12">
				
					<div class="form-group">
		    			<label for="rubrica">Nome del sensore primario in rubrica</label>
		    			<input 
		    				type="text" 
		    				class="form-control" 
		    				id="rubrica"
		    				value="${allarme.nomeRubrica }"
		    				name="<portlet:namespace/>rubrica"/>
	  				</div>
	  				
	  				<div class="form-group idro">
		    			<label for="fiume">Nome del fiume del sensore primario in rubrica</label>
		    			<input 
		    				type="text" 
		    				class="form-control" 
		    				id="fiume"
		    				value="${allarme.fiume }"
		    				name="<portlet:namespace/>fiume"/>
	  				</div>
	  				
	  				<div class="form-group idro">
		    			<label for="parti">Parti del fiume del sensore primario in rubrica</label>
		    			<input 
		    				type="text" 
		    				class="form-control" 
		    				id="parti"
		    				value="${allarme.partiFiume }"
		    				name="<portlet:namespace/>parti"
		    				aria-describedby="partiHelp" />
		    			<small id="partiHelp" class="form-text text-muted">solo fiumi divisi</small>
	  				</div>
	  				
	  				<br/><br/>
				
				</div>
				
				<div class="col-12">
					<button
						type="button"
						onclick="javascript:submitForm();"
						class="btn btn-primary">
						Salva
					</button>
			
					<button
						type="button"
						onclick="javascript:location.href='<%=listaURL.toString() %>'"
						class="btn btn-primary">
						Torna alla lista
					</button>
				</div>
				
				</aui:form>
				
			</div>
		
			<script>
			
				var sensori = [];
				var deleteConditionTemplate = '<button type="button" onclick="javascript:removeCondition(-1, 0)" class="btn btn-primary">Elimina</button>';
				
				<c:forEach var="variabili" items="${allarme.variabili}">
			
					sensori['${variabili.value}'] = '${variabili.key}';
			
					var stazioni_${variabili.value} = [];
			
					console.log('${variabili.value}');
			
					<c:forEach var="stazioni" items="${allarme.stazioniVariabili[variabili.value]}">
					stazioni_${variabili.value}['${stazioni.key}'] = "${stazioni.value}";
					</c:forEach>
		
				</c:forEach>
				
				function sensoreChange( idx) {
					
					var optionSelected = $("option:selected", $("#sensore_" + idx));
					
					var ss = optionSelected.text();
					console.log(ss);
					
					if( idx == 0)
						if( ss == 'Idrometri')
							$('.idro').show();
						else
							$('.idro').hide();
					
					var stazioni = eval('stazioni_' + ss);
					
					$('#staz_' + idx).empty();
					
					for( var s in stazioni)
						$("#staz_" + idx).append(new Option(stazioni[s], s));
				}
				
				function removeCondition(idRegola, idx) {
					
					if( idRegola > 0 ) {
						var opUrl = '<%=eliminaCondizione.toString()%>';
						opUrl += '&<portlet:namespace/>idRegola=' + idRegola + '&<portlet:namespace/>condizione=' + idx ;
			 			
						$.ajax({
					        type : "POST",
					        url : opUrl,
					    	success: function(result) {
					    		 $('#tr_' + idx).remove();
					    	}
						});
					} else
						$('#tr_' + idx).remove();
				}
				
				function addCondition() {
					
					var replacement = '_'+ (++index);
					console.log(replacement);
					var newRow = $('#tr_0').html().replace(/_0/g, replacement);
					
					newRow = newRow.replace(/Sensore primario/g, deleteConditionTemplate.replace(/0/, index) );
					
					$('#conditions').append("<tr id='tr_" + index + "'>" + newRow + "</tr>");
					
					$("#sensore_" + index).val($("#sensore_0").val() );
					
					$("#sensore_" + index).change(function(e) {
						sensoreChange(index);
					});
					
				}
				
				function submitForm() {
					
					$('#conditions > tr').each(function() {
						
						var trId = $(this).attr('id');
						console.log(trId);
						
						var trIndex = trId.substring( trId.indexOf('_') + 1);
						
						$('#rules').val( $('#rules').val() + trIndex + ',');
					});
					
					$('#rules').val( $('#rules').val().substring(0, $('#rules').val().length -1) );
					
					console.log( $('#rules').val());
					
					$('#<portlet:namespace/>fmAllarme').submit();
				}
			
				$( document ).ready(function() {
					
					$('#colore').val('${allarme.colore}');
					if( '${allarme.regolaCorrente.attivo}' == 'true') {
						$('#attiva').attr('checked', 'checked');
						$('#attiva').val="true";
					}
					
					$('#attiva').change(function() {
						
				        if(this.checked) {
				            $(this).val("true");
				        } else 
				        	$(this).val("false");
				    });
					
					for( i = 0; i <= index; i++) {
						
						for( var s in sensori)
							$("#sensore_" + i).append(new Option(s, sensori[s]));
						
						$("#sensore_" + i).val( dati_sensori[i]);
						
						var optionSelected = $("option:selected", $("#sensore_" + i));
						
						var ss = optionSelected.text();
						
						var stazioni = eval('stazioni_' + ss);
						
						for( var s in stazioni)
							$("#staz_" + i).append(new Option(stazioni[s], s));
						
						$("#staz_" + i).val( dati_staz[i]);
						$("#soglia_" + i).val( dati_soglia[i]);
						
						$("#sensore_" + i).change(function(e) {
							
							var sid = $(this).attr('id');
							sid = sid.substring( sid.indexOf('_') + 1);
							sensoreChange(sid);
						});
					}
					
					var optionSelected = $("option:selected", $("#sensore_0"));
					
					if( optionSelected.text() == 'Idrometri') {
						$('.idro').show();
					} else
						$('.idro').hide();
					
					
				});
			
			</script>
		
	</div>
	
</main>