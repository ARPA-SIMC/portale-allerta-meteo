<%@page import="java.util.HashMap"%>
<%@page import="it.eng.allerter.service.AllertaValangheLocalServiceUtil"%>
<%@page import="it.eng.allerter.model.AllertaValanghe"%>
<%@page import="it.eng.allerta.utils.AllertaKeys"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="it.eng.allerter.allerta.ListaAllerteValangheEntry"%>
<%@page import="java.util.List"%>
<%@page import="it.eng.allerter.allerta.AllertaValangheBean"%>
<%@ include file="../init.jsp"%>

<%
	AllertaValangheBean allertaValangheBean = new AllertaValangheBean(request);
	List<AllertaValanghe> allerteValangheEntry = (List<AllertaValanghe>) renderRequest.getAttribute("allerteValangheEntry");
	//AllertaLocalServiceUtil.getListaAllerte();	
	HashMap<String, String> tasks = (HashMap<String, String>) renderRequest.getAttribute("allerteValangheTasks");
%>

<style>
.am .page .page__head .lead {
    color: white;
    margin-bottom: 1rem;
    font-size: 1rem;
}
</style>

<portlet:renderURL var="compilaUrl">
	<portlet:param name="mvcRenderCommandName" value="/allertaer/allerta_valanghe/compila"/>	
</portlet:renderURL>

<portlet:actionURL var="webserviceUrl" name="/allertaer/allerta_valanghe/webservice"/>	
<portlet:actionURL var="webserviceUrl2" name="/allertaer/allerta_valanghe/webservice2"/>

<liferay-ui:error key="erroreSalvataggio" message="errore-salvataggio" />
<liferay-ui:error key="nonAggiornato" message="non-aggiornato" />
<liferay-ui:error key="erroreAccesso" message="errore-accesso" />
<liferay-ui:error key="incompleto" message="incompleto" />

<div class="row">
	<div class="col-12">
		<h2>Strumenti di area riservata</h2>
		<div class="row">
			<div class="col-4">
				<a href="<%=compilaUrl %>"
					class="btn btn-primary"><i class="icon i-pencil"></i>Compila allerta o bollettino valanghe</a>
			</div>
			<div class="col-4">
				<a href="<%=webserviceUrl %>"
					class="btn btn-primary"><i class="icon i-download"></i>Genera documento valanghe da Meteomont</a>
			</div>
			<div class="col-4">
				<a href="<%=webserviceUrl2 %>"
					class="btn btn-primary"><i class="icon i-download"></i>Genera documento valanghe (2 giorni)</a>
			</div>
		</div>
			
	</div>

	<div class="table-responsive-md">
		<table class="table table-striped" id="table-12345">
			<caption> <h2>Allerte e bollettini valanghe in lavorazione</h2></caption>
			<thead>
				<tr>
					<th scope="col"><abbr title="Titolo"> Titolo </abbr></th>
					<th scope="col"><abbr title="Compilatore"> Compilato da</abbr></th>
					<th scope="col"><abbr title="Stato"> Stato </abbr></th>
					<th scope="col"><abbr title="Modificato"> Ultima modifica (passo workflow)</abbr></th>
					<th scope="col"><abbr title="Azioni"> Azioni</abbr></th>
				</tr>
			</thead>
			<tbody>
				<%
				for (AllertaValanghe a : allerteValangheEntry) {
					ListaAllerteValangheEntry entry = new ListaAllerteValangheEntry(a); 
				%>
				<tr>
					<td>
						<a href="<%=entry.getAllertaValanghe().getLink() %>">
							<%=entry.getAllertaValanghe().getTitolo() %>
						</a>
					</td>
					<td><%=entry.getCompilatore().getFullName()%></td>
					<td><%=entry.getStato()%></td>
					<td><%=dateTimeFormat.format(entry.getUltimaData())%></td>
					<td>
						<liferay-util:include page="/allerta_valanghe/allerta_azioni.jsp" servletContext="<%=getServletContext() %>">
							<liferay-util:param name="allertaValangheStato"
								 value="<%=String.valueOf(entry.getAllertaValanghe().getStato()) %>"></liferay-util:param>
							<liferay-util:param name="allertaValangheId"
								 value="<%=String.valueOf(entry.getAllertaValanghe().getAllertaValangheId()) %>"></liferay-util:param>
							<liferay-util:param name="taskId"
								 value="<%=tasks.get( String.valueOf(a.getAllertaValangheId())) %>"></liferay-util:param>
						</liferay-util:include>						
					</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
	
</div>