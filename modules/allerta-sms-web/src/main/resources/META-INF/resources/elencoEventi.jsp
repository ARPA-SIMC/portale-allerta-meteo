<%@page import="com.liferay.portal.kernel.model.Role"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="it.eng.allerta.utils.AllertaKeys"%>
<%@page import="it.eng.sms.search.EventiHelper"%>
<%@page import="it.eng.sms.search.EventiDisplayTerms"%>
<%@page import="it.eng.sms.search.EventiSearchContainer"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ include file="./init.jsp" %>

<%

PortletURL portletURL = renderResponse.createRenderURL();
String portletURLString = portletURL.toString();

EventiSearchContainer eventiSearchContainer = new EventiSearchContainer(renderRequest, portletURL);
EventiDisplayTerms displayTerms = (EventiDisplayTerms)eventiSearchContainer.getDisplayTerms();

long dettaglioPlid = PortalUtil.getPlidFromPortletId( themeDisplay.getScopeGroupId(), AllertaKeys.AllertaDettagliEventiPortlet);
%>

<style>
	td, th { padding: 5px !important; font-size: 90% !important}
	
	<% 
	
	  boolean nascondi = false;
	  List<Role> roles = RoleLocalServiceUtil.getUserRoles(themeDisplay.getUserId());
	  if (roles!=null) {
		  for (Role r : roles)
			  if (r!=null && r.getRoleId()==2059543)
				  nascondi=true;
	  }
	  
	  if (nascondi) {
		  %> .nascondi { display:none; } <%
	  }
	  
	%>
</style>

<div class="container">

	<aui:form action="<%= portletURLString %>" method="post" name="smsService">

	
		<div class="row">
			<div class="col-md-3">
				<aui:input 
					name="filtro" 
				/>
				
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
				<h2>Eventi</h2>
			</div>
		</div>
	
	
		<div class="row">
		
			<div class="col-md-12">
			
				
		
				<liferay-ui:search-container 
						searchContainer="<%= eventiSearchContainer %>" 
						total="<%=EventiHelper.getEventiCount(displayTerms) %>"  >
					
					<liferay-ui:search-container-results 
						results="<%= EventiHelper.getEventi(displayTerms,eventiSearchContainer.getStart(), eventiSearchContainer.getEnd()) %>" 
				        />
				        
					  <liferay-ui:search-container-row className="it.eng.sms.bean.EventiBean" modelVar="evt" >
					  
						<liferay-ui:search-container-column-text property="evento" name="Evento" />
						<liferay-ui:search-container-column-text property="tipoEvento" name="Tipo Evento"/>
						<liferay-ui:search-container-column-text property="dataGenerazione" name="Data Generazione"/>
						<liferay-ui:search-container-column-text property="smsGenerati" name="SMS Generati"/>
						<liferay-ui:search-container-column-text property="smsSpediti" name="SMS Spediti" />
						<liferay-ui:search-container-column-text property="smsConsegnati" name="SMS Consegnati" />
						<liferay-ui:search-container-column-text property="percSuccesso" name="Perc Successo" />
						<liferay-ui:search-container-column-text property="ultimoAggiornamento" name="Ultimo Aggiornamento" />
						<liferay-ui:search-container-column-text>
							<a class="nascondi" href='javascript:goToDetails("<%= evt.getId()%>", "<%=evt.getTipoEvento()%>")'>Vai</a>
						</liferay-ui:search-container-column-text>
						
						
					</liferay-ui:search-container-row>
				
					<liferay-ui:search-iterator  paginate="<%= true %>"  />
					
				</liferay-ui:search-container>
			</div>
		</div>
		
	</div>	

	
 <script type="text/javascript">
 	
 function goToDetails( id, evt) {
	 
	 var backTo = '<%=themeDisplay.getURLCurrent() %>';
	 
	 var ref = '/dettaglio-evento-sms?id=' + id;
	 ref += '&evt=' + evt;
	 ref += '&backTo=' + backTo;
	 
	 location.href = ref;
 }
 
 </script>