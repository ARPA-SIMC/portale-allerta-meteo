<%@page import="it.eng.sms.search.DettaglioHelper"%>
<%@page import="it.eng.sms.search.DettaglioDisplayTerm"%>
<%@page import="it.eng.sms.search.DettaglioSearchContainer"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ include file="./init.jsp" %>


<%
String backTo = (String)renderRequest.getAttribute("backTo");

PortletURL portletURL = renderResponse.createRenderURL();
String portletURLString = portletURL.toString();

DettaglioSearchContainer dettaglioSearchContainer = new DettaglioSearchContainer( renderRequest, portletURL);
DettaglioDisplayTerm dettaglioDisplayTerm = (DettaglioDisplayTerm)dettaglioSearchContainer.getDisplayTerms();

%>

<style>
	
	.green {
		background-color:green !important;
		color: white;
		vertical-align: middle !important;
		text-align: center !important;
	}
	
	.red {
		background-color:red !important;
		color: white;
		vertical-align: middle !important;
		text-align: center !important;
	}
	
	.colonnaNascosta {
		display: none
	}
	
	.fineGruppo td {
		border-top: 2px solid currentColor !important;
	}
	
	td, th { padding: 5px !important; font-size: 90% !important}
	
	.tooltip2 {
    	position: relative;
    	display: inline-block;
    	border-bottom: 1px dotted black;
	}
	
	.tooltip2 .tooltiptext {
	    visibility: hidden;
	    width: 240px;
	    background-color: #555;
	    color: #fff;
	    text-align: center;
	    border-radius: 6px;
	    padding: 5px 0;
	    position: absolute;
	    z-index: 1;
	    bottom: 125%;
	    left: 50%;
	    margin-left: -120px;
	    opacity: 0;
	    transition: opacity 0.3s;
	}
	
	.tooltip2:hover .tooltiptext {
	    visibility: visible;
	    opacity: 1;
	}
	
	table.table-bordered tr td {
		position: initial;
	}
</style>

<div class="container">

	<aui:form action="<%=portletURLString %>" method="post" name="smsService">
	
		<div class="row">
			<div class="col-md-4">
				<aui:input 
					type="text"
					name="filtro" 
				/>
				
				<aui:input 
					name="id"
					value="<%=dettaglioDisplayTerm.getId()%>"
					type="hidden"
				/> 
				
				<aui:input 
					name="evt"
					value="<%=dettaglioDisplayTerm.getEvento()%>"
					type="hidden"
				/> 
			</div>
			
			<div class="col-md-4">
				
				<aui:input 
					name="failed"
					type="checkbox"
					style="margin-top: 35px;"
					label=" Solo destinatari senza messaggi consegnati"
				/> 
			</div>
			
			
		
			<div class="col-md-2" style='text-align: center;margin-top: 25px;'>
				<aui:button
					value="Aggiorna"
					name="aggiorna" />
			</div>
			
			<div class="col-md-2" style='text-align: center;margin-top: 25px;'>
				<aui:button
					value="Torna alla lista"
					name="backTo" />
			</div>
		
		</div>
	
	</aui:form>		
	
		<div class="row" style="margin-top:50px;">
			<div class="col-md-12">
				<h2>Lista SMS</h2>
			</div>
		</div>
	
	
		<div class="row">
		
			<div class="col-md-12">
				<a href='javascript:exportAsExcel();'>Scarica in formato Excel</a>
			</div>
		
			<div class="col-md-12">
			
				<liferay-ui:search-container 
						
						searchContainer="<%= dettaglioSearchContainer %>" 
						total="<%=DettaglioHelper.getDettagliCount(dettaglioDisplayTerm) %>"  >
					
					<liferay-ui:search-container-results 
						results="<%= DettaglioHelper.getDettagli(dettaglioDisplayTerm, dettaglioSearchContainer.getStart(), dettaglioSearchContainer.getEnd()) %>" 
				        />
				        
					  <liferay-ui:search-container-row className="it.eng.sms.bean.DettaglioBean" modelVar="dettaglio" >
					  
					  	<%
					  		String styleCellContatto = dettaglio.getSuccessoContatto().equals("SI") ? "green" : "red";
					  		String styleCellDestinatario = dettaglio.getSuccessoDestinatario().equals("SI") ? "green" : "red";
					  	%>
					 	<liferay-ui:search-container-column-text  property="idDestinatario" cssClass="colonnaNascosta" name="ID Destinatario" />
						<liferay-ui:search-container-column-text property="destinatario" name="Destinatario" />
						<liferay-ui:search-container-column-text property="numero" name="Numero"/>
						<liferay-ui:search-container-column-text property="stato" name="Stato"/>
						<liferay-ui:search-container-column-text property="testo" name="Testo"/>
						<liferay-ui:search-container-column-text property="dataGenerazione" name="Data ora Generazione" />
						<liferay-ui:search-container-column-text property="dataSpedizione" name="Data ora Spedito al Gestore" />
						<liferay-ui:search-container-column-text property="dataRicevuta" name="Data ora arrivo Ricevuta" />
						<liferay-ui:search-container-column-text property="successoContatto" cssClass="<%=styleCellContatto %>" name="Successo per singolo Contatto" />
						<liferay-ui:search-container-column-text property="successoDestinatario" cssClass="<%=styleCellDestinatario %>" name="Successo per Destinatario" />
						
					</liferay-ui:search-container-row>
				
					<liferay-ui:search-iterator  paginate="<%= false %>"  />
					
				</liferay-ui:search-container>
		
			
			</div>
		</div>
		
	</div>	
	
	<liferay-portlet:resourceURL var="smsExport">
	</liferay-portlet:resourceURL>
	
<script>

function groupTable($rows, startIndex, total) {
	
	if (total === 0) {
		return;
	}
	
	var start = 0;
	var startVal = $($($rows[0]).find('td')[0]).text().trim();
	for (var k=0; k<$rows.length; k++) {
		
		var cellaTesto = $($rows[k]).find('td')[4];
		var testoSms = $(cellaTesto).text().trim();
		var inner = "<span class='tooltip2'>Tooltip <span class='tooltiptext'>"+testoSms+"</span></span>";
		$(cellaTesto).empty();
		$(cellaTesto).append(inner);
		
		if (k==0) continue
		var c1 = $($rows[k]).find('td')[0];
		if ($(c1).text().trim()==startVal) {
			$(c1).addClass('deleted');
			$($($rows[k]).find('td')[9]).addClass('deleted');
			if (k<$rows.length-1) continue;
		}
		$($rows[k]).addClass('fineGruppo')
		var rowsp = k - start;
		if (rowsp>1) {
			$($($rows[start]).find('td')[0]).attr('rowspan',rowsp)
			$($($rows[start]).find('td')[9]).attr('rowspan',rowsp)
		}
		start = k;
		startVal = $(c1).text().trim()
	}
	
	return
	
	var i , currentIndex = startIndex, count=1, lst=[];
	var tds = $rows.find('td:eq('+ currentIndex +')');
	var ctrl = $(tds[0]);
	var tds2 = $rows.find('td:eq('+ 9 +')');
	
	lst.push($rows[0]);
	for (i=1;i<=tds.length;i++) {
		
		if (ctrl.text() ==  $(tds[i]).text()) {
			
			count++;
			$(tds[i]).addClass('deleted');
			lst.push($rows[i]);
			
		} else {
			if (count>1) {
				ctrl.attr('rowspan',count);
				groupTable($(lst),startIndex+1,total-1)
			}
			
			count=1;
			lst = [];
			ctrl = $(tds[i]);
			lst.push($rows[i]);
		}
	}
}


function exportAsExcel() {
	
	var url = '<%=smsExport%>';
	//url += '&<portlet:namespace />filtro=' + $('#<portlet:namespace />filtro').val();
	//url += '&<portlet:namespace />failed=' + $('#<portlet:namespace />failed').val();
	//url += '&<portlet:namespace />id=' + $('#<portlet:namespace />id').val();
	
	 $('#<portlet:namespace/>smsService')[0].action = url;
	 $('#<portlet:namespace/>smsService')[0].submit();
}

$(document).ready( function(){
	
	$('#<portlet:namespace/>aggiorna').click(function() {
		
		var url = '<%=portletURLString%>';
		 
		$('#<portlet:namespace/>smsService')[0].action = url;
		$('#<portlet:namespace/>smsService')[0].submit();
	});
	
	
	$('#<portlet:namespace/>backTo').click( function(){
		
		location.href="/web/guest/sms2";
	});
	
	
	$($('table.table-bordered thead tr').find('th')[0]).addClass('colonnaNascosta')
	groupTable($('table.table-bordered tr:has(td)'), 0, 1);
	$('table .deleted').remove();
	
});



</script>	


