<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="it.eng.allerter.allerta.ListaBollettiniEntry"%>
<%@page import="it.eng.bollettino.service.BollettinoLocalServiceUtil"%>
<%@page import="it.eng.bollettino.model.Bollettino"%>
<%@page import="java.util.List"%>
<%@page import="it.eng.allerter.allerta.BollettinoBean"%>
<%@ include file="../init.jsp"%>

<%
List<Bollettino> bollettiniEntry = BollettinoLocalServiceUtil.getListaBollettiniMonitoraggio();

%>


<portlet:renderURL var="compilaUrl"  windowState="maximized">
	<portlet:param name="mvcRenderCommandName" value="/allertaer/monitoraggio/compila"/>	
</portlet:renderURL>

<div class="row">
	<div class="col-12">
		<h2>Strumenti di area riservata - maximized</h2>
		<div class="row">
			<div class="col-4">
				<a href="<%=compilaUrl %>"
					class="btn btn-primary"><i class="icon i-pencil"></i>Compila bollettino di monitoraggio</a>
				</div>
		</div>
			
	</div>

	<div class="table-responsive-md">
		<table class="table table-striped" id="table-12345">
			<caption> <h2>Allerte e bollettini in lavorazione</h2></caption>
			<thead>
				<tr>
					<th scope="col"><abbr title="Int.1"> Titolo </abbr></th>
					<th scope="col"><abbr title="Int.2"> Compilato Da</abbr></th>
					<th scope="col"><abbr title="Int.3"> Stato </abbr></th>
					<th scope="col"><abbr title="Int.5"> Ultima modifica
							(passo Workflow)</abbr></th>
					<th scope="col"><abbr title="Int.4"> Azioni</abbr></th>
				</tr>
			</thead>
			<tbody>
				<%
					for (Bollettino b : bollettiniEntry) {
						ListaBollettiniEntry entry = new ListaBollettiniEntry(b); 
				%>
				<tr>
					<td>
						<a href="<%=entry.getAllerta().getLink() %>">
							<%=entry.getAllerta().getNumero() %>
						</a>
					</td>
					<td><%=entry.getCompilatore().getFullName()%></td>
					<td><%=entry.getStato()%></td>
					<td><%=dateTimeFormat.format(entry.getUltimaData())%></td>
					<td>
						<%-- <liferay-util:include page="/allerta/allerta_azioni.jsp" servletContext="<%=getServletContext() %>">
							<liferay-util:param name="allertaId"
								 value="<%=String.valueOf(entry.getAllerta().getAllertaId()) %>"></liferay-util:param>
						</liferay-util:include> --%>
						
					</td>
				</tr>
				<%
					}
				%>

			</tbody>
		</table>
	</div>
	
</div>