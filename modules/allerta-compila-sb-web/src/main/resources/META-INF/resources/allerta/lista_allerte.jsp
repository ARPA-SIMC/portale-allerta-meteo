<%@page import="java.util.HashMap"%>
<%@page import="it.eng.allerter.service.AllertaLocalServiceUtil"%>
<%@page import="it.eng.allerter.model.Allerta"%>
<%@page import="it.eng.allerta.utils.AllertaKeys"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="it.eng.allerter.allerta.ListaAllerteEntry"%>
<%@page import="java.util.List"%>
<%@page import="it.eng.allerter.allerta.AllertaBean"%>
<%@ include file="../init.jsp"%>


<%
	AllertaBean allertaBean = new AllertaBean(request);

	List<Allerta> allerteEntry = (List<Allerta>)renderRequest.getAttribute("allerteEntry");
			//AllertaLocalServiceUtil.getListaAllerte();
	
	HashMap<String, String> tasks = (HashMap<String, String>) renderRequest.getAttribute("allerteTasks");
%>
<portlet:renderURL var="compilaUrl">
	<portlet:param name="mvcRenderCommandName" value="/allertaer/allerta/compila"/>	
</portlet:renderURL>

<div class="row">
	<div class="col-12">
		<h2>Strumenti di area riservata</h2>
		<div class="row">
			<div class="col-4">
				<a href="<%=compilaUrl %>"
					class="btn btn-primary"><i class="icon i-pencil"></i>Compila allerta o bollettino</a>
				</div>
		</div>
			
	</div>

	<div class="table-responsive-md">
		<table class="table table-striped" id="table-12345">
			<caption> <h2>Allerte e bollettini in lavorazione</h2></caption>
			<thead>
				<tr>
					<th scope="col"><abbr title="Titolo"> Titolo </abbr></th>
					<th scope="col"><abbr title="Compilatore"> Compilato da</abbr></th>
					<th scope="col"><abbr title="Stato"> Stato </abbr></th>
					<th scope="col"><abbr title="Modificato"> Ultima modifica
							(passo workflow)</abbr></th>
					<th scope="col"><abbr title="Azioni"> Azioni</abbr></th>
				</tr>
			</thead>
			<tbody>
				<%
					for (Allerta a : allerteEntry) {
						ListaAllerteEntry entry = new ListaAllerteEntry(a); 
				%>
				<tr>
					<td>
						<a href="<%=entry.getAllerta().getLink() %>">
							<%=entry.getAllerta().getTitolo() %>
						</a>
					</td>
					<td><%=entry.getCompilatore().getFullName()%></td>
					<td><%=entry.getStato()%></td>
					<td><%=dateTimeFormat.format(entry.getUltimaData())%></td>
					<td>
						<liferay-util:include page="/allerta/allerta_azioni.jsp" servletContext="<%=getServletContext() %>">
							<liferay-util:param name="allertaStato"
								 value="<%=String.valueOf(entry.getAllerta().getStato()) %>"></liferay-util:param>
							<liferay-util:param name="allertaId"
								 value="<%=String.valueOf(entry.getAllerta().getAllertaId()) %>"></liferay-util:param>
							<liferay-util:param name="taskId"
								 value="<%=tasks.get( String.valueOf(a.getAllertaId())) %>"></liferay-util:param>
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