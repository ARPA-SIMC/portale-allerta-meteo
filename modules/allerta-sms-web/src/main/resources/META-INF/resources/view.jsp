<!-- DELETE JSP -->

<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="it.eng.sms.bean.SMSManager"%>
<%@ include file="./init.jsp" %>

<liferay-portlet:actionURL name="/allerta/sms/thread" var="commandThread">
</liferay-portlet:actionURL>

<script type="text/javascript">
  
  var info = <%= SMSManager.getInfo( PortalUtil.getHttpServletRequest(renderRequest))%>
  
  $(document).ready( function() {
	
	  $('#startStopThread').click(function(){
		  
		  console.log( 'startStopThread clicked', '<portlet:namespace/>' );
		  
		  
		  var url = '<%=commandThread%>&<portlet:namespace/>cmd=startStopThread';
		  
		  $('#<portlet:namespace/>sms-service').action = url;
		  $('#<portlet:namespace/>sms-service').submit();
		  
	  });
	  
	  $('#startStopSocket').click(function() {
		  
		  console.log( 'startStopSocket clicked', '<portlet:namespace/>' );
		  
		  var url = '<%=commandThread%>&<portlet:namespace/>cmd=startStopSocket';
		  
		  $('#<portlet:namespace/>sms-service').action = url;
		  $('#<portlet:namespace/>sms-service').submit();
		  
	  });
	  
 	  $('#startStopOtherThread').click(function(){
		  
		  var url = '<%=commandThread%>&<portlet:namespace/>cmd=startStopOtherThread';
		  
		  $('#<portlet:namespace/>sms-service').action = url;
		  $('#<portlet:namespace/>sms-service').submit();
		  
	  });
	  
	  $('#startStopOtherSocket').click(function(){
		  
		  var url = '<%=commandThread%>&<portlet:namespace/>cmd=startStopOtherSocket';
		  
		  $('#<portlet:namespace/>sms-service').action = url;
		  $('#<portlet:namespace/>sms-service').submit();
		  
	  });
  });

</script>

<aui:form name='sms-service'>

<div class="container">

	<div class="row text-center">
		<div class="col-md-12">
			<h2>Attenzione, la sequenza dei click non deve essere casuale;</h2>
		</div>
		<div class="col-md-12">
			<h3>Per accendere vanno avviati i thread e poi la vpn; Per
				spegnere prima va bloccato il loop e poi spento il thread!!</h3>
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
						<td>Host </td>
						<td><%=SMSManager.getIp() %> <%=renderRequest.getServerPort()%></td>
					</tr>
					
					<tr>
						<td>Socket</td>
						<td><%=SMSManager.isSocketOn() ? "Connesso" : "Disconnesso"%></td>
					</tr>
					
					<tr>
						<td>SMS inviati parziale*</td>
						<td><%= SMSManager.getNumeroSmsSpeditiFromLastStart()%></td>
					</tr>	
					
					<tr>
						<td>Thread:</td>
						<td><%= SMSManager.isShutdown() ? "Spento": "Acceso"%></td>
					</tr>		
					
					<tr>
						<td>Dimensione SmsBean:</td>
						<td><%= SMSManager.getSmsBeanSize()%></td>
					</tr>	
					
					<tr>
						<td>Dimensione trn:</td>
						<td><%= SMSManager.getTrnSize()%></td>
					</tr>							
				</table>
			</div>
			
			<div class="col-md-12">
				<div class="col-md-6">
			
					<button
						id="startStopThread"
						>
					
						<%= SMSManager.isShutdown() ? "Start thread" : "Stop thread" %>
						
					</button>
			
					<button
						id="startStopSocket"
						>
					
						<%= SMSManager.isSocketOn() ? "Stop Socket" : "Start Socket" %>
					</button>
					
				</div>
			</div>
			
			<div class="col-md-12">
				<%=SMSManager.getLog() %>
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
						<td>Host da interrogare</td>
						<td id='otherNode' >In attesa...</td>
					</tr>
					
					<tr>
						<td>Socket da interrogare</td>
						<td id='otherisConnected' >In attesa...</td>
					</tr>
					
					<tr>
						<td>SMS inviati parziale* da interrogare</td>
						<td id='otherSmsSpeditiParziale' >In attesa...</td>
					</tr>	
					
					<tr>
						<td>Thread da interrogare</td>
						<td id='otherShutdown' >In attesa...</td>
					</tr>		
					
					<tr>
						<td>Dimensione SmsBean da interrogare</td>
						<td id='otherSmsBeanSize' >In attesa...</td>
					</tr>	
					
					<tr>
						<td>Dimensione trn da interrogare</td>
						<td id='otherTrnSize' >In attesa...</td>
					</tr>										
				</table>
			</div>
			
			<div class="col-md-12">
				<div class="col-md-6">
			
					<button
						id="startStopOtherThread"
						>
						
						<%= SMSManager.isShutdownOther( PortalUtil.getHttpServletRequest(renderRequest)) ? "Start thread" : "Stop thread" %>
						
					</button>
			
					<button
						id="startStopOtherSocket"
						>
					
						<%= SMSManager.isSocketOnOther( PortalUtil.getHttpServletRequest(renderRequest)) ? "Stop Socket" : "Start Socket" %>
					</button>
				</div>
			</div>
			
			<div class="col-md-12">
				<%=SMSManager.getLogOther( PortalUtil.getHttpServletRequest(renderRequest)) %>
			</div>
		
		
		</div>
	
	</div>
	
	<div class="row">
		<div class="col-md-3">SMS generati e non inviati (0) | <%=SMSManager.getSmsInStato(0L) %></div>
		<div class="col-md-3">SMS generati e pronti all'invio (1) | <%=SMSManager.getSmsInStato(1L) %></div>
		<div class="col-md-3">SMS in fase di invio e già acquisiti da un thread (2) <%=SMSManager.getSmsInStato(2L) %></div>
	</div>
	
	<div class="row">
		<div class="col-md-6">Attenzione!! Questo pulsante resetta l'invio dei messaggi</div>
		<div class="col-md-3">
		
		<%if( SMSManager.isShutdown()) { %>
			<button 
				id="reset"
				>
				
				Metti in stato 1
			</button>
		<%} %>
			<!--  commandButton action="{sms.resetSMSFaseTwo()}"
				rendered="{sms.isShutdown()}" value="Metti in stato 1" -->
		</div>
	</div>
	
	
</div>
</aui:form>