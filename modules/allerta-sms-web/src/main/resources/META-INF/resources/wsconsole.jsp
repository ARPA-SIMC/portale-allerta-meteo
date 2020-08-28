<%@ include file="./init.jsp" %>

<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletMode"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="it.eng.sms.bean.AllertaServiceConsoleBean" %>

<liferay-portlet:actionURL var="doProcessActionURL" name="doProcessAction" />
	
<script type="text/javascript">
	
	function addCallback(element,command) {
		console.log('binding ' + element + ' to ' + command);
		
	  	$(element).click(function() {		
			var url = '${doProcessActionURL}&<portlet:namespace/>cmd='+command;
			console.log('url = '+url)
			console.log('form = #<portlet:namespace/>sms-service')
			
			$('#<portlet:namespace/>sms-service').action = url;
			window.location = url;			  
		}); 
	}
	
	$(document).ready(function() {
		console.log('doc ready');
		
		addCallback('#<portlet:namespace/>btnTryStartScheduler','tryStartScheduler');
		addCallback('#<portlet:namespace/>btnTryStopScheduler','tryShutdownScheduler');
		addCallback('#<portlet:namespace/>btnSendOrSimulateSMS','toggleSendOrSimulateSMS');
		addCallback('#<portlet:namespace/>btnActiveOrDeactiveVerify','toggleVerifyIfServerIsEnable');
	})	    
</script>

<liferay-ui:success key="success" message="Comando andato a buon fine" />
<liferay-ui:error key="error" message="Comando non andato a buon fine" />
	
<h2><span>Verifica o invia comandi allo scheduler di invio/verifica SMS</span></h2>

<aui:form name="sms-service">
	<aui:fieldset-group markupView="lexicon">		
		<%-- Info miste sul Server --%>
		
		<aui:fieldset label="Server Info">
			<aui:row>						
				<aui:col width="50">
					<span>Nome della JVM che contiene l'istanza dello scheduler</span>								
				</aui:col>
				<aui:col width="50">
					<span><%=AllertaServiceConsoleBean.nameJVM()%></span>
				</aui:col>
			</aui:row>																	
			<aui:row>
				<aui:col width="50">
					<span>IP:Porta del nodo che contiene l'istanza dello scheduler </span>
				</aui:col>
				<aui:col width="50">
					<span><%=AllertaServiceConsoleBean.getCurrentSchedulerHostIPAndPort()%></span>
				</aui:col>
			</aui:row>
			<aui:row>
				<aui:col width="50">
					<span>IP:Porta del nodo corrente che ha risposto alla request web</span>
				</aui:col>
				<aui:col width="50">
					<span><%=AllertaServiceConsoleBean.getCurrentHostIpAndPort()%></span>
				</aui:col>
			</aui:row>
		</aui:fieldset>
		
		<%-- Info sullo stato degli Scheduler --%>
		
		<aui:fieldset label="Info Scheduler">				
			<aui:row>					
				<aui:col width="50">
					<span>Scheduler terminated</span>
				</aui:col>
				<aui:col width="50">
					<span><%=AllertaServiceConsoleBean.isSchedulerTerminated()%></span>
				</aui:col>
			</aui:row>					
			<aui:row>					
				<aui:col width="50">
					<span>Scheduler shutdown</span>
				</aui:col>
				<aui:col width="50">
					<span><%=AllertaServiceConsoleBean.isSchedulerShutdown()%></span>
				</aui:col>
			</aui:row>
			
			<aui:row>					
				<aui:col width="50">
					<span>Sub Schedulers terminated</span>
				</aui:col>
				<aui:col width="50">
					<span>Send <%=AllertaServiceConsoleBean.isSchedulerSendTerminated()%> - Receive <%=AllertaServiceConsoleBean.isSchedulerReceiveTerminated()%></span>
				</aui:col>
			</aui:row>					
			<aui:row>					
				<aui:col width="50">
					<span>Sub Schedulers shutdown</span>
				</aui:col>
				<aui:col width="50">
					<span>Send <%=AllertaServiceConsoleBean.isSchedulerSendShutdown()%> - Receive <%=AllertaServiceConsoleBean.isSchedulerReceiveShutdown()%></span>
				</aui:col>
			</aui:row>
		</aui:fieldset>
		
		<%-- Comandi vari --%>
		
		<aui:fieldset label="Comandi">
			<%-- Comandi per gli Scheduler --%>
			<aui:fieldset label="Scheduler">					
				<aui:row>
					<aui:col width="50">
						<span>Start/Stop scheduler di invio e verifica sms</span>
					</aui:col>
					<aui:col width="50">
						<% if (AllertaServiceConsoleBean.isSchedulerTerminated()) { %>
					        <aui:button id="btnTryStartScheduler" value="Start scheduler" />
					    <% } else { %>
					        <aui:button id="btnTryStopScheduler" value="Stop scheduler" />
					    <% } %>					
					</aui:col>
				</aui:row>
			</aui:fieldset>
			
			<%-- Comandi per gli SMS --%>
			<aui:fieldset label="Sms">						
				<aui:row>
					<aui:col width="50">
						<span>Abilita/Simula invio sms</span>
					</aui:col>
					<aui:col width="50">											
						<aui:button id="btnSendOrSimulateSMS" 
									value="<%=AllertaServiceConsoleBean.isSendSMS() ? "Simula invio sms" : "Abilita invio sms"%>" />
					</aui:col>
				</aui:row>					
				<aui:row>
					<aui:col width="50">
						<span>Abilita/Disabilita verifica del server di invio sms</span>
					</aui:col>
					<aui:col width="50">
						<aui:button id="btnActiveOrDeactiveVerify" value="<%=AllertaServiceConsoleBean.isServerVerifyEnable() ? "Disabilita verifica" : "Abilita verifica" %>" />
					</aui:col>							
				</aui:row>
			</aui:fieldset>					
		</aui:fieldset>

		<%-- Statistiche sugli stati degli SMS --%>
		
		<aui:fieldset label="Statistiche SMS">
			<aui:row>					
				<aui:col width="70">Sms inviati dall'ultimo avvio del application server</aui:col>
				<aui:col width="30"><%=AllertaServiceConsoleBean.getSmsInviati()%></aui:col>
			</aui:row>					
			<aui:row>
				<aui:col width="70">Messaggi generati dal sistema Allerte (stato 0) </aui:col>
				<aui:col width="30"><%=AllertaServiceConsoleBean.getSmsInStato(0L)%></aui:col>					
			</aui:row>
			<aui:row>
				<aui:col width="70">Messaggi generati e pronti all'invio al service Telecom (stato 1) </aui:col>
				<aui:col width="30"><%=AllertaServiceConsoleBean.getSmsInStato(1L)%></aui:col>
			</aui:row>
			<aui:row>
				<aui:col width="70">Messaggi presi in carico dai task di invio sms (stato 2) </aui:col>
				<aui:col width="30"><%=AllertaServiceConsoleBean.getSmsInStato(2L)%></aui:col>
			</aui:row>
			<aui:row>
				<aui:col width="70">Messaggi inviati con successo al service Telecom tramite i task di invio (stato 3) </aui:col>
				<aui:col width="30"><%=AllertaServiceConsoleBean.getSmsInStato(3L)%></aui:col>
			</aui:row>
			<aui:row>
				<aui:col width="70">Messaggi effettivamente inviati che sono stati verificati con certezza dal service Telecom (stato 4)</aui:col>
				<aui:col width="30"><%=AllertaServiceConsoleBean.getSmsInStato(4L)%></aui:col>
			</aui:row>
			<aui:row>
				<aui:col width="70">Messaggi non inviati al service Telecom tramite i task di invio a causa di status &lt;&gt; 200 oppure IOException (stato 5)</aui:col>
				<aui:col width="30"><%=AllertaServiceConsoleBean.getSmsInStato(5L)%></aui:col>
			</aui:row>
			<aui:row>
				<aui:col width="70">Messaggi presi in carico dai task di verifica invio sms tramite service Telecom (stato 6) </aui:col>
				<aui:col width="30"><%=AllertaServiceConsoleBean.getSmsInStato(6L)%></aui:col>
			</aui:row>
			<aui:row>
				<aui:col width="70">Messaggi per i quali interrompo (dopo 3 giorni) la verifica di effettivo invio sms oppure perchè non ricevuti (stato 7)</aui:col>
				<aui:col width="30"><%=AllertaServiceConsoleBean.getSmsInStato(7L)%></aui:col>
			</aui:row>
		</aui:fieldset> 
		
		<%-- Log dell'applciativo : ultime righe --%>
		
		<%--
		<aui:fieldset label="Log (ultime righe)">
			<aui:row>
				<div style="font-size:small">
					<%=AllertaServiceConsoleBean.getLog() %>
				</div>
			</aui:row>
		</aui:fieldset>
		--%>
	</aui:fieldset-group>
	
</aui:form>
