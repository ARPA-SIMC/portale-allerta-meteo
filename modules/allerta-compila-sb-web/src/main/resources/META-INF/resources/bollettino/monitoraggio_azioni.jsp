<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="it.eng.allerter.allerta.BollettinoBean"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="../init.jsp" %>

<%
long bollettinoId = ParamUtil.getLong(request, "bollettinoId");
long taskId = ParamUtil.getLong(request, "taskId");
long statoId = ParamUtil.getLong(request, "bollettinoStato");
int canModify = ParamUtil.getInteger(request,"canModify");
int canApprove = ParamUtil.getInteger(request,"canApprove");
%>


<liferay-ui:icon-menu
	direction="left-side"
	icon="<%= StringPool.BLANK %>"
	markupView="lexicon"
	message="<%= StringPool.BLANK %>"
	showWhenSingleIcon="<%= true %>">
	
	
	<portlet:actionURL var="approveUrl" name="/allertaer/monitoraggio/workflow">
		<portlet:param name="cmd" value="approve"/>	
		<portlet:param name="bollettinoId" value="<%=String.valueOf(bollettinoId) %>"/>	
		<portlet:param name="taskId" value="<%=String.valueOf(taskId) %>"/>	
	</portlet:actionURL>

	<portlet:actionURL var="rejectUrl" name="/allertaer/monitoraggio/workflow">
		<portlet:param name="cmd" value="reject"/>	
		<portlet:param name="bollettinoId" value="<%=String.valueOf(bollettinoId) %>"/>	
		<portlet:param name="taskId" value="<%=String.valueOf(taskId) %>"/>	
	</portlet:actionURL>

 	<portlet:renderURL var="compilaUrl" windowState="<%=LiferayWindowState.MAXIMIZED.toString() %>">
		<portlet:param name="mvcRenderCommandName" value="/allertaer/monitoraggio/compila"/>
		<portlet:param name="bollettinoId" value="<%=String.valueOf(bollettinoId) %>"/>	
	</portlet:renderURL>
	
	<portlet:actionURL var="deleteUrl" name="/allertaer/monitoraggio/delete">
		<portlet:param name="bollettinoId" value="<%=String.valueOf(bollettinoId) %>"/>
	</portlet:actionURL>
		
	<c:if test="<%= statoId != 1 && canModify == 1 %>">
		<liferay-ui:icon message="Modifica" url="<%= compilaUrl.toString() %>"/>
		<liferay-ui:icon message="Elimina" url="<%= deleteUrl.toString() %>"/>
	</c:if>
	
	<c:if test="<%= statoId == 1 && canApprove == 1 %>">
		<liferay-ui:icon message="Approva" url="<%= approveUrl.toString() %>"/>
		<liferay-ui:icon message="Rifiuta" url="<%= rejectUrl.toString() %>"/>
	</c:if>
	
</liferay-ui:icon-menu>