<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="it.eng.allerter.allerta.AllertaBean"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="../init.jsp" %>

<%

long allertaId = ParamUtil.getLong(request, "allertaId");
AllertaBean allertaBean = new AllertaBean(allertaId, request);
long taskId = ParamUtil.getLong(request, "taskId");
long statoId = ParamUtil.getLong(request, "allertaStato");

%>

	<portlet:actionURL var="approveUrl" name="/allertaer/allerta/workflow">
		<portlet:param name="cmd" value="approve"/>	
		<portlet:param name="allertaId" value="<%=String.valueOf(allertaId) %>"/>	
		<portlet:param name="taskId" value="<%=String.valueOf(taskId) %>"/>	
	</portlet:actionURL>

	<portlet:actionURL var="rejectUrl" name="/allertaer/allerta/workflow">
		<portlet:param name="cmd" value="reject"/>	
		<portlet:param name="allertaId" value="<%=String.valueOf(allertaId) %>"/>	
		<portlet:param name="taskId" value="<%=String.valueOf(taskId) %>"/>	
	</portlet:actionURL>
	
<liferay-ui:icon-menu
	direction="left-side"
	icon="<%= StringPool.BLANK %>"
	markupView="lexicon"
	message="<%= StringPool.BLANK %>"
	showWhenSingleIcon="<%= true %>">
	
	
	<c:choose>
  		<c:when test="<%= allertaBean.getMostraSalva()%>">
	  		<portlet:renderURL var="compilaUrl">
				<portlet:param name="mvcRenderCommandName" value="/allertaer/allerta/compila"/>
				<portlet:param name="allertaId" value="<%=String.valueOf(allertaId) %>"/>	
			</portlet:renderURL>
			
			<portlet:actionURL var="deleteUrl" name="/allertaer/allerta/delete">
				<portlet:param name="allertaId" value="<%=String.valueOf(allertaId) %>"/>
			</portlet:actionURL>
		
			<liferay-ui:icon message="Modifica" url="<%= compilaUrl.toString() %>"/>
		
			<liferay-ui:icon message="Cancella" url="<%= deleteUrl.toString() %>"/>
				
  		</c:when>
  		
  	
  		<c:otherwise>
  		
  		</c:otherwise>
  	</c:choose>
	
	<c:if test="<%= taskId != -1%>">
		<liferay-ui:icon message="Approva" url="<%= approveUrl.toString() %>"/>
		<liferay-ui:icon message="Rifiuta" url="<%= rejectUrl.toString() %>"/>
	</c:if>
	
</liferay-ui:icon-menu>