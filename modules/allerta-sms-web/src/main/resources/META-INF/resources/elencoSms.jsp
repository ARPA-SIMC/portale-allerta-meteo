<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.eng.sms.search.EmailHelper"%>
<%@page import="it.eng.sms.search.EmailSearchContainer"%>
<%@page import="it.eng.sms.search.SMSHelper"%>
<%@page import="it.eng.sms.search.SMSDisplayTerms"%>
<%@page import="it.eng.sms.search.SMSSearchContainer"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="it.eng.allerter.allerta.SMSBean"%>
<%@ include file="./init.jsp" %>

<%
	SMSBean smsBean = new SMSBean();

	PortletURL portletURL = renderResponse.createRenderURL();
	String portletURLString = portletURL.toString();
	
	SMSSearchContainer smsSearchContainer = new SMSSearchContainer(renderRequest, portletURL);
	SMSDisplayTerms displayTerms = (SMSDisplayTerms)smsSearchContainer.getDisplayTerms();
	
	EmailSearchContainer emailSearchContainer = new EmailSearchContainer( renderRequest, portletURL);
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
%>

<style>
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
	
	.lfr-search-container {
		overflow:unset;
	}
</style>

<div class="container">



<aui:form action="<%= portletURLString %>" method="post" name="smsService">

		<div class="row">
			<div class="col-md-3">
				<aui:input 
					name="tipo" 
				/>
				
			</div>
			<div class="col-md-3">
				<aui:input 
					name="sottotipo" 
				/>
			</div>
			
			<div class="col-md-3">
				<aui:input 
					name="nome" 
				/>
			</div>
			
			<div class="col-md-3">
				<aui:input 
					name="numero" 
				/>
			</div>
			
			<div class="col-md-3">
		
				<aui:select name="stato">
					<aui:option value="-1">Tutti</aui:option>
					<aui:option value="1">Generati (non ancora inviati al gestore)</aui:option>
					<aui:option value="2">Inviati al gestore (in attesa di conferma)</aui:option>
					<aui:option value="3">Invio completato, in attesa di ricevuta</aui:option>
					<aui:option value="4">Invio completato, ricevuta arrivata</aui:option>
					<aui:option value="5">Invio fallito</aui:option>
					
				</aui:select>
			</div>
		
			<div class="col-md-3">
				<label class="control-label" for="datetimepicker1">Data invio da:</label>
				
				<div class='input-group date' id="datetimepicker1">
	                   <aui:input 
							type="text" 
							class="form-control" 
							name="dataInvioDa"
							label=""
							placeholder="gg/mm/aaaa" />
	                   <span class="input-group-addon">
	                       <i class="far fa-calendar-minus"></i>
	                   </span>
	               </div>
	               
	               <script type="text/javascript">
		            $(function () {
		                $('#datetimepicker1').datetimepicker({
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
			
			<div class="col-md-3">
				<label class="control-label" for="datetimepicker2">Data invio a:</label>
				
				<div class='input-group date' id="datetimepicker2">
	                   <aui:input 
							type="text" 
							class="form-control" 
							name="dataInvioA"
							label=""
							placeholder="gg/mm/aaaa" />
	                   <span class="input-group-addon">
	                       <i class="far fa-calendar-minus"></i>
	                   </span>
	               </div>
	               
	               <script type="text/javascript">
		            $(function () {
		                $('#datetimepicker2').datetimepicker({
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
		
			<div class="col-md-3" style='text-align: center;margin-top: 25px;'>
				<button
					id='aggiorna'>
					Aggiorna
				</button>
			</div>
		
	</div>
	
</aui:form>
	
	<div class="row" style="margin-top:50px;">
		<div class="col-md-12">
			<h2>SMS</h2>
		</div>
	</div>
	
	
	<div class="row">
	
		<div class="col-md-12">
			<a href='javascript:exportAsExcel();'>Scarica in formato Excel</a>
		</div>
	
		<div class="col-md-12 sms-results" >
	
			<liferay-ui:search-container 
					delta="15"
					searchContainer="<%= smsSearchContainer %>" 
					total="<%=SMSHelper.getTotalSMSCount(displayTerms) %>"  >
				
				<liferay-ui:search-container-results 
					results="<%= SMSHelper.getSMS(displayTerms,smsSearchContainer.getStart(), smsSearchContainer.getEnd()) %>" 
			        />
			        
				 <liferay-ui:search-container-row className="it.eng.allerter.model.SMS" modelVar="sms" >
				 
					 <%
				         String ack = sms.getDataAck() != null ? sdf.format(sms.getDataAck()) : "";
				         String ricevuta = sms.getDataRicevuta() != null ? sdf.format(sms.getDataRicevuta()) : "";
				         String successo = "";
				         switch( (int)sms.getStato()) {
				         
				         	case 4:
				         		successo = "S";
				         		break;
				         		
				         	case 5:
				         		successo = "N";
				         		break;
				         	
				         	case -1001 :
				         		successo = "S (dup)";
				         		break;
				         		
				         	case -1002 :
				         		successo = "N (dup)";
				         		break;
				         		
				         }
			         %>
				 
					<liferay-ui:search-container-column-text property="tipo" name="Tipo" />
					<liferay-ui:search-container-column-text property="sottotipo" name="Sotto tipo"/>
					<liferay-ui:search-container-column-text property="nomeDestinatario" name="A"/>
					<liferay-ui:search-container-column-text property="numero" name="Numero"/>
					<liferay-ui:search-container-column-text property="testo" name="Testo"/>
					<liferay-ui:search-container-column-text value="<%= sdf.format(sms.getDataInvio())%>" name="Generato"/>
					<liferay-ui:search-container-column-text value="<%= ack %>" name="Spedito al Gestore"/>
					<liferay-ui:search-container-column-text value="<%= ricevuta %>" name="Ricevuta del Getore"/>
					<liferay-ui:search-container-column-text value="<%= successo %>" name="Successo"/>
				</liferay-ui:search-container-row>
			
				<liferay-ui:search-iterator  paginate="<%= true %>"  />
				
			</liferay-ui:search-container>
		</div>
	</div>
	
	<div class="row" style="margin-top:50px;">
		<div class="col-md-12">
			<h2>Email</h2>
		</div>
	</div>
	
	<div class="row">
	
		<div class="col-md-12">
			<a href='javascript:exportEmailAsExcel();'>Scarica in formato Excel</a>
		</div>
	
		<div class="col-md-12 email-results">
	
			<liferay-ui:search-container 
				
					delta="15"
					searchContainer="<%= emailSearchContainer %>" 
					total="<%=EmailHelper.getTotalEmailCount(displayTerms) %>"  >
				
				<liferay-ui:search-container-results 
					results="<%= EmailHelper.getEmail(displayTerms, emailSearchContainer.getStart(), emailSearchContainer.getEnd()) %>" 
			        />
			       
			        
				 <liferay-ui:search-container-row className="it.eng.allerter.model.Email" modelVar="email" >
					<liferay-ui:search-container-column-text property="tipo" name="Tipo" />
					<liferay-ui:search-container-column-text property="sottotipo" name="Sotto Tipo" />
					<liferay-ui:search-container-column-text property="nomeDestinatario" name="A"/>
					<liferay-ui:search-container-column-text property="indirizzo" name="Email"/>
					<liferay-ui:search-container-column-text value="<%= sdf.format(email.getDataInvio())%>" name="Generato" />
					<liferay-ui:search-container-column-text property="testo" name="Testo"/>
					<liferay-ui:search-container-column-text property="oggetto" name="Oggetto"/>
					
				</liferay-ui:search-container-row>
			
				<liferay-ui:search-iterator  paginate="<%= true %>"  />
				
			</liferay-ui:search-container>
		</div>
	</div>
	
	<div class="row" style="display:none;">
	
		<div class="col-md-3"> 
			Da
			<input
				type="text" 
				class="form-control" 
				name="<portlet:namespace/>invioDa"
				/>
		</div>
		
		<div class="col-md-3"> 
			A
			<input
				type="text" 
				class="form-control" 
				name="<portlet:namespace/>invioA"
				/>
		</div>
		
		<div class="col-md-6"> 
			Testo
			<input
				type="text" 
				class="form-control" 
				name="<portlet:namespace/>testo"
				/>
		</div>
	</div>
	
	
	<div class="row" style="margin-top:20px;display:none;">
		
		<div class="col-md-2"> 
			
		</div>
		
		<div class="col-md-8"> 
			<button 
				id="invioSms">
				
				Invia SMS
			</button>
			
			<button 
				id="shutdown">
				
				Shutdown
			</button>
			
			<button 
				id="svuotaCoda">
				
				Svuota coda
			</button>
		</div>
		
		<div class="col-md-2"> 
		
		
		</div>
	</div>

<liferay-portlet:actionURL name="/allerta/sms/service/invia" var="commandSMS">
</liferay-portlet:actionURL>

<liferay-portlet:resourceURL var="smsExport">
</liferay-portlet:resourceURL>

<script>

function exportAsExcel() {
	
	var url = '<%=smsExport%>';
	url += '&<portlet:namespace />tipo=' + $('#<portlet:namespace />tipo').val();
	url += '&<portlet:namespace />sottotipo=' + $('#<portlet:namespace />sottotipo').val();
	url += '&<portlet:namespace />nome=' + $('#<portlet:namespace />nome').val();
	url += '&<portlet:namespace />numero=' + $('#<portlet:namespace />numero').val();
	url += '&<portlet:namespace />stato=' + $('#<portlet:namespace />stato').val();
	url += '&<portlet:namespace />dataInvioDa=' + $('#<portlet:namespace />dataInvioDa').val();
	url += '&<portlet:namespace />dataInvioA=' + $('#<portlet:namespace />dataInvioA').val();
	url += '&<portlet:namespace />source=sms';
	
	console.log( 'exportAsExcel clicked', url);
	
	 $('#<portlet:namespace/>smsService')[0].action = url;
	 $('#<portlet:namespace/>smsService')[0].submit();
}

function exportEmailAsExcel(){
	
	var url = '<%=smsExport%>';
	url += '&<portlet:namespace />tipo=' + $('#<portlet:namespace />tipo').val();
	url += '&<portlet:namespace />sottotipo=' + $('#<portlet:namespace />sottotipo').val();
	url += '&<portlet:namespace />nome=' + $('#<portlet:namespace />nome').val();
	url += '&<portlet:namespace />numero=' + $('#<portlet:namespace />numero').val();
	url += '&<portlet:namespace />stato=' + $('#<portlet:namespace />stato').val();
	url += '&<portlet:namespace />dataInvioDa=' + $('#<portlet:namespace />dataInvioDa').val();
	url += '&<portlet:namespace />dataInvioA=' + $('#<portlet:namespace />dataInvioA').val();
	url += '&<portlet:namespace />source=email';
	
	 $('#<portlet:namespace/>smsService')[0].action = url;
	 $('#<portlet:namespace/>smsService')[0].submit();
}

</script>

<script>

function groupTable($rows) {
	
	var start = 0;
	var startVal = $($($rows[0]).find('td')[0]).text().trim();
	for (var k=0; k<$rows.length; k++) {
		
		var cellaTesto = $($rows[k]).find('td')[4];
		var testoSms = $(cellaTesto).text().trim();
		var inner = "<span class='tooltip2'>Tooltip <span class='tooltiptext'>"+testoSms+"</span></span>";
		$(cellaTesto).empty();
		$(cellaTesto).append(inner);
		
	}
	
}

function groupTableEmail($rows) {
	
	var start = 0;
	var startVal = $($($rows[0]).find('td')[0]).text().trim();
	for (var k=0; k<$rows.length; k++) {
		
		var cellaTesto = $($rows[k]).find('td')[5];
		var testoSms = $(cellaTesto).text().trim();
		var inner = "<span class='tooltip2'>Tooltip <span class='tooltiptext'>"+testoSms+"</span></span>";
		$(cellaTesto).empty();
		$(cellaTesto).append(inner);
		
	}
	
}
	
	$(document).ready( function(){
		
		$('#aggiorna').click(function() {
			
			 var url = '<%=portletURLString%>';
			 
			 console.log( 'aggiorna clicked', url);
			  
			  $('#<portlet:namespace/>smsService')[0].action = url;
			  $('#<portlet:namespace/>smsService')[0].submit();
		});
				
		$('#invioSms').click(function(){
			  
			  console.log( 'invioSms clicked');
			  
			  var url = '<%=commandSMS%>&<portlet:namespace/>cmd=invioSms';

			  console.log( 'prima', $('#<portlet:namespace/>smsService')[0].action);
			  
			  
			  $('#<portlet:namespace/>smsService')[0].action = url;
			  
			  console.log('dopo',  $('#<portlet:namespace/>smsService')[0].action);
			  $('#<portlet:namespace/>smsService')[0].submit();
			  
		});
		
		$('#shutdown').click(function(){
			  
			  console.log( 'shutdown clicked');
			  
			  
			  var url = '<%=commandSMS%>&<portlet:namespace/>cmd=shutdown';
			  
			  $('#<portlet:namespace/>smsService')[0].action = url;
			  $('#<portlet:namespace/>smsService')[0].submit();
			  
		});
		
		$('#svuotaCoda').click(function(){
			  
			  console.log( 'svuotaCoda clicked');
			  
			  
			  var url = '<%=commandSMS%>&<portlet:namespace/>cmd=svuotaCoda';
			  
			  $('#<portlet:namespace/>smsService')[0].action = url;
			  $('#<portlet:namespace/>smsService')[0].submit();
			  
		});
		
		groupTable($('.sms-results table.table-bordered tr:has(td)'));
		groupTableEmail($('.email-results table.table-bordered tr:has(td)'));
		
	});
</script>

