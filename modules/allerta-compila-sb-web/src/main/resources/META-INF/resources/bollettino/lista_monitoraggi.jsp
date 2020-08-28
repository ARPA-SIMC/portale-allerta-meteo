<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="it.eng.allerter.allerta.ListaBollettiniEntry"%>
<%@page import="it.eng.bollettino.service.BollettinoLocalServiceUtil"%>
<%@page import="it.eng.bollettino.model.Bollettino"%>
<%@page import="java.util.List"%>
<%@page import="it.eng.allerter.allerta.BollettinoBean"%>
<%@ include file="../init.jsp" %>

<%
	
	//List<Bollettino> bollettiniEntry = BollettinoLocalServiceUtil.getListaBollettiniMonitoraggio();
	
List<Bollettino> bollettiniEntry = (List<Bollettino>) renderRequest.getAttribute("bollettiniEntry");
HashMap<String, String> tasks = (HashMap<String, String>) renderRequest.getAttribute("bollettiniTasks");
int canApprove = (Integer) renderRequest.getAttribute("canApprove");
int canModify = (Integer) renderRequest.getAttribute("canModify");
List<Bollettino> filteredList = new ArrayList<Bollettino>();
for (int k=0; k<bollettiniEntry.size(); k++) {
	if (bollettiniEntry.get(k).getNumero()!=null && !"".equals(bollettiniEntry.get(k).getNumero()))
		filteredList.add(bollettiniEntry.get(k));
}
bollettiniEntry = filteredList;
%>
<style>
.portlet-icon-back {
	display:none;
}

</style>


<portlet:renderURL var="compilaUrl" windowState="<%=LiferayWindowState.MAXIMIZED.toString() %>">
	<portlet:param name="mvcRenderCommandName" value="/allertaer/monitoraggio/compila"/>	
</portlet:renderURL>

<div class="row">
	<div class="col-12">
		<h2>Strumenti di area riservata</h2>
		<div class="row">
			<div class="col-4">
				<a href="<%=compilaUrl %>"
					class="btn btn-primary"><i class="icon i-pencil"></i>Compila monitoraggio</a>
				</div>
		</div>
		

	</div>

	<div class="table-responsive-md">
		<table class="table table-striped" id="table-12345">
			<caption> <h2>Documenti di monitoraggio in lavorazione</h2></caption>
			<thead>
				<tr>
					<th scope="col"><abbr title="Int.1"> Documenti in lavorazione </abbr></th>
					<th scope="col"><abbr title="Int.2"> Compilato Da</abbr></th>
					<th scope="col"><abbr title="Int.3"> Stato </abbr></th>
					<th scope="col"><abbr title="Int.5"> Ultima modifica
							(passo Workflow)</abbr></th>
				</tr>
			</thead>
			<tbody>
				<%
					for (Bollettino b : bollettiniEntry) {
						ListaBollettiniEntry entry = new ListaBollettiniEntry(b); 
				%>
				<tr>
					<td>
						<a href="<%=entry.getAllerta().getLink() %>" target="_blank">
							Monitoraggio <%=entry.getAllerta().getNumero() %>
						</a>
					</td>
					<td><%=entry.getCompilatore().getFullName()%></td>
					<td><%=entry.getStato()%></td>
					<td><%=dateTimeFormat.format(entry.getUltimaData())%></td>
					<td>
						<liferay-util:include page="/bollettino/monitoraggio_azioni.jsp" servletContext="<%=getServletContext() %>">
							<liferay-util:param name="bollettinoStato"
								 value="<%=String.valueOf(entry.getAllerta().getStato()) %>"></liferay-util:param>
							<liferay-util:param name="bollettinoId"
								 value="<%=String.valueOf(entry.getAllerta().getBollettinoId()) %>"></liferay-util:param>
							<liferay-util:param name="taskId"
								 value="<%=tasks.get( String.valueOf(b.getBollettinoId())) %>"></liferay-util:param>
							<liferay-util:param name="canApprove"
								 value="<%=""+canApprove %>" />
								<liferay-util:param name="canModify"
								 value="<%=""+canModify %>" />
						</liferay-util:include>
						
					</td>
					
				</tr>
				<%
					}
				%>

			</tbody>
		</table>
	</div>