<%@page import="it.eng.allerter.allerta.AllarmeBean"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@ include file="../init.jsp" %>

<%
AllarmeBean allarmi = (AllarmeBean) request.getAttribute("allarmi");
%>

<c:set value="<%=allarmi%>" var="allarmi" scope="request"></c:set>

<portlet:resourceURL var="salvaStato" >
	<portlet:param name="op" value="salva-stato"/>
</portlet:resourceURL>

<portlet:actionURL var="salvaURL" name="/allertaer/regola/salva">
	<portlet:param name="redirect" value=""/>		
</portlet:actionURL>

<portlet:actionURL var="eliminaURL" name="/allertaer/regola/elimina">
	<portlet:param name="redirect" value=""/>		
</portlet:actionURL>

<portlet:renderURL var="modificaURL">
	 <portlet:param name="mvcRenderCommandName" value="/allertaer/regola/modifica" />
</portlet:renderURL>

<portlet:renderURL var="listaURL">
	<portlet:param name="redirect" value=""/>		
</portlet:renderURL>

<style>

.container {
    max-width: 1570px;
}

.tabella-regole_length {
	display: none;
}

#tabella-regole_filter {
	display: none;
}

.paginate_button {
	margin-left: 5px;
	margin-right: 5px;
}
</style>

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
		
		
		<div class="col-12" id="lista_regole">
		
			
		
			<h2 class="h2">Lista regole di superamento</h2>
			<br/>
			<input type="search" class="form-control input-sm" id="cercaRegola" placeholder="Cerca" style="display:none">
			<br/><br/>
			
			<button
				type="button"
				onclick='javascript:nuovaRegola();'
				class="btn btn-primary">
				Nuova Regola
			</button>
			
			<button
						type="button" 
						
						class="btn btn-primary" 
						onclick="window.open('/o/report/regole');"
						
						>Scarica Excel regole</button>
			
			<br/>
			<br/>
			
			<table id="tabella-regole" class="table table-hover" style="font-size:13px">
				<thead>
					<tr>
						<th>Nome regola</th>
						<th>Descrizione</th>
						<th >Regola attiva</th>
						<th >Tipo</th>
						<th >Sensore primario</th>
						<th >Altri sensori</th>
						<th >Comuni</th>
						<th >Fiume</th>
						<th >Tratti di fiume</th>
						<th >Problemi</th>
						<c:if test="${allarmi.canModifica }">
						<th >Modifica</th>
						<th >Elimina</th>
						
						</c:if>
					</tr>
	
				</thead>
				
				<tbody>
				
				<c:forEach var="regola" items="${allarmi.filtrate}">
					
					<tr>
						<td>${regola.nome}</td>
						<td>${regola.descrizione}</td>
						<td style='${regola.style}'  id='td_regola_${regola.idRegola}'>
							<span id="testo_${regola.idRegola}">
							<c:choose>
							    <c:when test="${regola.attivo}">
							       SI
							    </c:when>    
							    <c:otherwise>
							        NO
							    </c:otherwise>
							</c:choose>
							</span>
							<c:if test="${allarmi.canDisattiva }">
								<input type='hidden' id='stato_${regola.idRegola}' value='${regola.attivo}' />
								<button 
									type="button" 
									id="bstato_${regola.idRegola}"
									onclick="<portlet:namespace/>salvaStato('${regola.idRegola}')"
									class="btn btn-primary">${regola.testoAttiva }
								</button>
							</c:if>
						</td>
						<td>${regola.tipo}</td>
						<td>${regola.sensorePrimario}</td>
						<td>${regola.altriSensori}</td>
						<td>${regola.comuni}</td>
						<td>${regola.fiume}</td>
						<td>${regola.tratti}</td>
						
						<td>
							<c:choose>
							    <c:when test="${regola.problemi}">
							       <span style="font-size:xx-large">&#9888;</span>
							    </c:when>    
							    <c:otherwise>
							      
							    </c:otherwise>
							</c:choose>
						</td>
						
						<c:if test="${allarmi.canModifica }">
						<td>
							<button 
								type="button" 
								onclick="modifica('${regola.idRegola}')"
								class="btn btn-primary">Modifica
							</button>
						</td>
						<td>
							<button 
								type="button" 
								onclick="elimina('${regola.idRegola}')"
								class="btn btn-primary">Elimina
							</button>
						</td>
						
						
						
						</c:if>
						
					</tr>
				
				</c:forEach>
				</tbody>
				
				
			</table>
			
			<br/>
			<button
				type="button"
				onclick='javascript:nuovaRegola();'
				class="btn btn-primary">
				Nuova Regola
			</button>
			
			<button
						type="button" 
						
						class="btn btn-primary" 
						onclick="window.open('/o/report/regole');"
						
						>Scarica Excel regole</button>
		
		</div>
		
		<div id="nuova_regola" style="display:none">
		
			<aui:form method="post" name="fmAllarme" action="<%=salvaURL.toString()%>">
			
				<div class="col-12">
					<div class="form-group">
		    			<label for="nome">Nome</label>
		    			<input 
		    				type="text" 
		    				class="form-control" 
		    				id="nome"
		    				name="<portlet:namespace/>nome"
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
		    				name="<portlet:namespace/>descrizione"
		    				placeholder="Descrizione Regola" />
	  				</div>
					
					<div class="form-group">
		    			<label for="nome">Espressione</label>
		    			<input 
		    				type="text" 
		    				class="form-control" 
		    				id="espressione"
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
					  	name="<portlet:namespace/>attiva" 
					  	value="<%=true %>"
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
					
					<table>
					
						<thead>
							<tr>
								<th>Identificatore</th>
								<th>Tipo sensore</th>
								<th>Stazione</th>
								<th>Problemi</th>
								<th>Elimina</th>
							</tr>
						</thead>
						
						<tbody id='conditions'>
						
							<tr id="tr_0">
								<td>
									<input 
					    				type="text" 
					    				class="form-control" 
					    				id="lettera_0"
					    				value="X"
					    				name="<portlet:namespace/>lettera_0"
					    				placeholder="Espressione" />
								</td>
								<td>
								    <select 
								    	class="form-control" 
								    	id="sensore_0" 
								    	name="<portlet:namespace/>sensore_0">
								    </select>
								</td>
								<td>
								    <select 
								    	class="form-control" 
								    	id="staz_0" 
								    	name="<portlet:namespace/>staz_0">
								    </select>
								</td>
								<td>
								    <select 
								    	class="form-control" 
								    	id="soglia_0" 
								    	name="<portlet:namespace/>soglia_0">
								    	
								    	<option value="1">1</option>
								    	<option value="2">2</option>
								    	<option value="3">3</option>
								    	
								    </select>
								</td>
								
								<td>
									Sensore primario
								</td>
							</tr>
						
						</tbody>
					</table>
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
		    				name="<portlet:namespace/>rubrica"/>
	  				</div>
	  				
	  				<div class="form-group idro">
		    			<label for="fiume">Nome del fiume del sensore primario in rubrica</label>
		    			<input 
		    				type="text" 
		    				class="form-control" 
		    				id="fiume"
		    				name="<portlet:namespace/>fiume"/>
	  				</div>
	  				
	  				<div class="form-group idro">
		    			<label for="parti">Parti del fiume del sensore primario in rubrica</label>
		    			<input 
		    				type="text" 
		    				class="form-control" 
		    				id="parti"
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
			
	</div>
		
	<script>
	
	
		var index = 0;
		var sensori = [];
		
		var deleteConditionTemplate = '<button type="button" onclick="javascript:removeCondition(0)" class="btn btn-primary">Elimina</button>';
		
		<c:forEach var="variabili" items="${allarmi.variabili}">
		
			sensori['${variabili.value}'] = '${variabili.key}';
			
			var stazioni_${variabili.value} = [];
			
			console.log('${variabili.value}');
			
			<c:forEach var="stazioni" items="${allarmi.stazioniVariabili[variabili.value]}">
			stazioni_${variabili.value}['${stazioni.key}'] = "${stazioni.value}";
			</c:forEach>
		
		</c:forEach>
		
		function submitForm() {
			
			jQuery('#conditions > tr').each(function() {
				
				var trId = jQuery(this).attr('id');
				console.log(trId);
				
				var trIndex = trId.substring( trId.indexOf('_') + 1);
				
				jQuery('#rules').val( jQuery('#rules').val() + trIndex + ',');
			});
			
			jQuery('#rules').val( jQuery('#rules').val().substring(0, jQuery('#rules').val().length -1) );
			
			console.log( jQuery('#rules').val());
			
			jQuery('#<portlet:namespace/>fmAllarme').submit();
		}
		
		function sensoreChange( idx) {
			
			var optionSelected = jQuery("option:selected", jQuery("#sensore_" + idx));
			
			var ss = optionSelected.text();
			console.log(ss);
			
			if( idx == 0)
				if( ss == 'Idrometri')
					jQuery('.idro').show();
				else
					jQuery('.idro').hide();
			
			var stazioni = eval('stazioni_' + ss);
			
			jQuery('#staz_' + idx).empty();
			
			for( var s in stazioni)
				jQuery("#staz_" + idx).append(new Option(stazioni[s], s));
		}
		
		
		jQuery( document ).ready(function() {
			
			for( var s in sensori)
				jQuery("#sensore_0").append(new Option(s, sensori[s]));
			
			jQuery("#sensore_0").change(function(e) {
				sensoreChange(0);
			});
			
			jQuery("#sensore_0").val(jQuery("#sensore_0 option:first").val());
			
			sensoreChange(0);
			
			var ita = {
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
			
			 var table = jQuery('#tabella-regole').DataTable({
				 'language':ita,
				"scrollX": true,
				 "order": [[ 0, "asc" ]],
	                'columnDefs': [ {
	                    'targets': [6,10,11], // column index (start from 0)
	                    'orderable': false, // set orderable false for selected columns
	                 }]
	            });
			 
			 jQuery( '#cercaRegola', this ).on( 'keyup', function () {
                   table.search( this.value ).draw();
              } );
			 
			 jQuery('#cercaRegola').show();
		});
		
		function addCondition() {
			
			var replacement = '_'+ (++index);
			console.log(replacement);
			var newRow = jQuery('#tr_0').html().replace(/_0/g, replacement);
			
			newRow = newRow.replace(/Sensore primario/g, deleteConditionTemplate.replace(/0/, index) );
			
			jQuery('#conditions').append("<tr id='tr_" + index + "'>" + newRow + "</tr>");
			
			jQuery("#sensore_" + index).val(jQuery("#sensore_0").val() );
			
			jQuery("#sensore_" + index).change(function(e) {
				sensoreChange(index);
			});
			
		}
		
		function removeCondition(idx) {
			
			jQuery('#tr_' + idx).remove();
		}
	
		function nuovaRegola() {
			
			jQuery('#lista_regole').hide();
			jQuery('#nuova_regola').show();
		}
		
		function elimina(idRegola) {
		
			var url = '<%=eliminaURL.toString()%>';
			url += '&<portlet:namespace/>regola=' + idRegola;
			
			jQuery('#<portlet:namespace/>fmAllarme').attr('action', url);
			jQuery('#<portlet:namespace/>fmAllarme').submit();
		}
		
		function modifica( idRegola) {
			
			var url = '<%=modificaURL.toString()%>';
			url += '&<portlet:namespace/>regola=' + idRegola;
			
			jQuery('#<portlet:namespace/>fmAllarme').attr('action', url);
			jQuery('#<portlet:namespace/>fmAllarme').submit();
		}
		
		function <portlet:namespace/>salvaStato(idRegola) {
			
			var opUrl = '<%=salvaStato.toString()%>';
			opUrl += '&<portlet:namespace/>regola=' + idRegola;
 			
			jQuery.ajax({
		        type : "POST",
		        url : opUrl,
		        dataType: "json",
		    	success: function(result) {
		    		
		    		jQuery('#td_regola_' + idRegola).attr('style', result.style);
		    		jQuery('#bstato_' + idRegola).html(result.testo);
		    		jQuery('#testo_' + idRegola).html(result.label);
		    	
		    	}
		       
			});
			
		}
	
	</script>
	
</main>