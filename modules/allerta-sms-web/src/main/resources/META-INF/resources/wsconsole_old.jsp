<%@page import="it.eng.allerta.messages.services.scheduler.SmsSchedulerContextUtility"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="it.eng.sms.bean.SMSManager"%>
<%@ include file="./init.jsp" %>

<liferay-portlet:actionURL name="/allerta/sms/service/thread" var="commandThread">
</liferay-portlet:actionURL>

<script type="text/javascript">

var infoWS = <%= SmsSchedulerContextUtility.getInfo( PortalUtil.getHttpServletRequest(renderRequest))%>;

$(document).ready( function() {
	
	$('#otherJVM').html(infoWS[0].nameJWS);
	$('#smsInviati').html(infoWS[0].smsInviati);
	$('#executerTerminated').html(infoWS[0].isTerminated);
	$('#executerShutdown').html(infoWS[0].isShutdown);
	$('#startOrStopOtherWS').text( JSON.parse(infoWS[0].isShutdown) ? "Avvia" : "Spwegni");
	

	$('#startStopThread').click(function(){
		  
		  console.log( 'startStopThread clicked');
		  
		  
		  var url = '<%=commandThread%>&<portlet:namespace/>cmd=startOrStopOtherWS';
		  
		  $('#<portlet:namespace/>sms-service').action = url;
		  $('#<portlet:namespace/>sms-service').submit();
		  
	});
	  
	$('#wsInvio').click(function(){
		  
		console.log( 'wsInvio clicked');
		
		
		var url = '<%=commandThread%>&<portlet:namespace/>cmd=enableDisable';
		
		$('#<portlet:namespace/>sms-service').action = url;
		$('#<portlet:namespace/>sms-service').submit();
		  
	});
	  
  	$('#startStopWS').click(function(){
		  
		console.log( 'startStopWS clicked');
		
		
		var url = '<%=commandThread%>&<portlet:namespace/>cmd=startStopWS';
		
		$('#<portlet:namespace/>sms-service').action = url;
		$('#<portlet:namespace/>sms-service').submit();
		  
	});
  	
  	$('#startOrStopOtherWS').click(function(){
		  
		console.log( 'startOrStopOtherWS clicked');
		
		
		var url = '<%=commandThread%>&<portlet:namespace/>cmd=startOrStopOtherWS';
		
		$('#<portlet:namespace/>sms-service').action = url;
		$('#<portlet:namespace/>sms-service').submit();
		  
	}); 	
 	  
  	$('#interruptThread').click(function(){
		  
		console.log( 'interruptThread clicked');
		
		
		var url = '<%=commandThread%>&<portlet:namespace/>cmd=interruptThread';
		
		$('#<portlet:namespace/>sms-service').action = url;
		$('#<portlet:namespace/>sms-service').submit();
		  
	}); 	
  	
  	$('#enableOther').click(function(){
		  
		console.log( 'enableOther clicked');
		
		
		var url = '<%=commandThread%>&<portlet:namespace/>cmd=enableOther';
		
		$('#<portlet:namespace/>sms-service').action = url;
		$('#<portlet:namespace/>sms-service').submit();
		  
	}); 	
  	
	$('#reset').click(function(){
		  
		console.log( 'reset clicked');
		
		
		var url = '<%=commandThread%>&<portlet:namespace/>cmd=reset';
		
		$('#<portlet:namespace/>sms-service').action = url;
		$('#<portlet:namespace/>sms-service').submit();
		  
	}); 	
  	
  	
});

</script>

<aui:form name='sms-service'>

<div class="container">

	<div class="row">
		<div class="col-12">
			<h2>Pannello di controllo invio sms tramite Web Services</h2>
		</div>
	</div>

	<div class="row">
	
		<div class="col-md-6">
		
			<div class="col-md-12">
	
				<table>
					<tr>
						<td>Nodo che sta rispondendo</td>
						<td><%=SMSManager.nameJVM() %></td>
					</tr>
					
					<tr>
						<td>Abilita/Disabilita Web Server Invio</td>
						<td>
							<button
								id='wsInvio'>
								
								<%=SmsSchedulerContextUtility.isSendSMS() ? "Imposta a false" : "Imposta a true"%>
							
							</button>
						</td>
					</tr>
					
					<tr>
						<td>Sms inviati dall'ultimo avvio</td>
						<td><%= SmsSchedulerContextUtility.getSmsInviati() %></td>
					</tr>
					
					<tr>
						<td>Executor terminated</td>
						<td>
							<%= SmsSchedulerContextUtility.isSchedulerTerminated() %>
							-
							<%= SmsSchedulerContextUtility.isSchedulerTerminatedOther() %>
						</td>
					</tr>	
					<tr>
						<td>Executor shutdown:</td>
						<td>
							<%= SmsSchedulerContextUtility.isSchedulerShutdown() %>
							-
							<%= SmsSchedulerContextUtility.isSchedulerShutdownOther() %>
						</td>
					</tr>	
					
					<tr>
						<td>Start/Shutdown executor</td>
						<td>
							<button
								id="startStopWS">
							
								<%= SmsManagerWebServices.getPoolWeb().isShutdown() ? "Avvia" : "Spegni" %>
							</button>
							
							<button
								id="interruptThread">
								Interrompi thread receive
							</button>
						</td>
					</tr>		
					
				</table>
				
			</div>
			
			<div class="col-md-12">
				<%=SmsManagerWebServices.getLog() %>
			</div>
		
		</div>
		
		<div class="col-md-6">
		
			<div class="col-md-12">
		
				<table>
					<tr>
						<td>Nodo da interrogare</td>
						<td id='otherJVM' >In attesa...</td>
					</tr>
					
					<tr>
						<td>Abilita/Disabilita Web Server Invio</td>
						<td>
							<button
								id='enableOther'>
								<%= SmsManagerWebServices.isEnableOther(PortalUtil.getHttpServletRequest(renderRequest)) ? "Imposta a false" : "Imposta a true" %>
							</button>
						</td>
					</tr>
					
					<tr>
						<td>Sms inviati dall'ultimo avvio</td>
						<td id='smsInviati' >In attesa...</td>
					</tr>
					
					<tr>
						<td>Executor terminated:</td>
						<td id='executerTerminated' >In attesa...</td>
					</tr>	
					
					<tr>
						<td>Executor shutdown</td>
						<td id='executerShutdown' >In attesa...</td>
					</tr>		
					
					<tr>
						<td>Start/Shutdown executor</td>
						<td>
							<button
								id='startOrStopOtherWS'>
								 in attesa...
							</button>
						</td>
					</tr>	
												
				</table>
			</div>	
			
			<div class="col-md-12">
				<%=SmsManagerWebServices.getLogOther(PortalUtil.getHttpServletRequest(renderRequest)) %>
			</div>	
		
		</div>
		
		<div class="row">
			<div class="col-md-3">
				SMS generati e non inviati (0) | 
				<%=SmsManagerWebServices.getSmsInStato(0L) %>
			</div>
			<div class="col-md-3">
				SMS generati e pronti all'invio (1) | 
				<%=SmsManagerWebServices.getSmsInStato(1L) %>
			</div>
			<div class="col-md-3">
				SMS in fase di invio e già acquisiti da un thread (2) 
				<%=SmsManagerWebServices.getSmsInStato(2L) %>
			</div>
		</div>
	
		<div class="row">
			<div class="col-md-6">Attenzione!! Questo pulsante resetta la ricezione notifiche</div>
			<div class="col-md-3">
			
				<button 
					id="reset"
					>
					
					Metti in stato 3
				</button>
				<!--  commandButton action="{sms.resetSMSFaseTwo()}"
					rendered="{sms.isShutdown()}" value="Metti in stato 1" -->
			</div>
		</div>
		
		
	</div>
		
</div>
</aui:form>