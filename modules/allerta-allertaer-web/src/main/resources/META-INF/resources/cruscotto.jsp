<%@page import="it.eng.allertaer.cruscotto.search.CruscottoHelper"%>
<%@page import="it.eng.allertaer.cruscotto.search.CruscottoDisplayTerms"%>
<%@page import="it.eng.allertaer.cruscotto.search.CruscottoSearchContainer"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="javax.portlet.PortletURL"%>

<%@ include file="./init.jsp" %>

<portlet:actionURL name="forzaScaricamentoStazioni" var="forzaScaricamentoUrl">
</portlet:actionURL>

<portlet:actionURL name="forzaScaricamentoDati" var="forzaScaricamentoDatiUrl">
</portlet:actionURL>

<%

PortletURL portletURL = renderResponse.createRenderURL();
String portletURLString = portletURL.toString();

SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

CruscottoSearchContainer cruscottoSearchContainer = new CruscottoSearchContainer(renderRequest, portletURL);
CruscottoDisplayTerms displayTerms = (CruscottoDisplayTerms)cruscottoSearchContainer.getDisplayTerms();



%>

<div class="container">

<h4>Lista eventi di sistema</h4>


<div class="col-md-3" style='text-align: center;margin-top: 25px;'>
        			<aui:form action="<%= portletURLString %>" method="post" name="refresh">
					<button
						id='refresh_eventi'>
						Refresh
					</button>
					</aui:form>
			</div>


	<liferay-ui:search-container 
					delta="10" 
					deltaParam="10"
					deltaConfigurable="true"
					searchContainer="<%= cruscottoSearchContainer %>" 
					total="<%=(int)CruscottoHelper.getCountLogInterni(displayTerms) %>"  >
				
				<liferay-ui:search-container-results 
					results="<%= CruscottoHelper.getLogInterni(displayTerms,cruscottoSearchContainer.getStart(), cruscottoSearchContainer.getEnd()) %>" 
			        />
			        
				 <liferay-ui:search-container-row className="it.eng.allerter.model.LogInterno" modelVar="msg" >
				 
					 <%
				        Boolean errore =  null != msg.getEccezione();
					 	
			         %>
				 	<liferay-ui:search-container-column-text value="<%= sdf.format(msg.getTimestamp())%>" name="Timestamp"/>
					<liferay-ui:search-container-column-text property="cosa" name="Tipologia" />
					<liferay-ui:search-container-column-text property="dettaglio" name="Dettaglio" />
					<liferay-ui:search-container-column-text property="risultato" name="Risultato"/>
					<liferay-ui:search-container-column-text property="utente" name="Utente"/>
					<liferay-ui:search-container-column-text property="eccezione" name="Errore"/>
				</liferay-ui:search-container-row>
			
				<liferay-ui:search-iterator  paginate="<%= true %>"  />
				
			</liferay-ui:search-container>
			
			<br/>
			
			<h4>Cruscotto di sistema</h4>
			
			<liferay-ui:tabs names="rt_data" refresh="false" tabsValues="rt_data">
    			<liferay-ui:section>
        			<div class="col-md-3" style='text-align: center;margin-top: 25px;'>
        			<aui:form action="<%= forzaScaricamentoUrl %>" method="post" name="rt_forza">
					<button
						id='aggiorna_rt'>
						Forza scaricamento stazioni
					</button>
					</aui:form>
					<aui:form action="<%= forzaScaricamentoDatiUrl %>" method="post" name="rt_forza_dati">
					<button
						id='aggiorna_dati_osservati'>
						Forza scaricamento dati osservati
					</button>
					</aui:form>
			</div>
    			</liferay-ui:section>
			</liferay-ui:tabs>
			
			<br/>
			
</div>