<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="../init.jsp" %>

<%

long id = ParamUtil.getLong(request, "id");

long statoId = ParamUtil.getLong(request, "stato");

%>
xxx
	
<liferay-ui:icon-menu
	direction="left-side"
	icon="<%= StringPool.BLANK %>"
	markupView="lexicon"
	message="<%= StringPool.BLANK %>"
	showWhenSingleIcon="<%= true %>">
	
	
	<c:choose>
  		<c:when test="<%= statoId==0 %>">
	  		<portlet:renderURL var="compilaUrl">
				<portlet:param name="mvcRenderCommandName" value="/allertaer/verifica/compila"/>
				<portlet:param name="allertaId" value="<%=String.valueOf(id) %>"/>	
			</portlet:renderURL>
			
			<portlet:actionURL var="deleteUrl" name="/allertaer/verifica/delete">
				<portlet:param name="allertaId" value="<%=String.valueOf(id) %>"/>
			</portlet:actionURL>
		
			<liferay-ui:icon message="Modifica" url="<%= compilaUrl.toString() %>"/>
		
			
				
  		</c:when>
  		
  	
  		<c:otherwise>
  		  	<portlet:renderURL var="compilaUrl">
				<portlet:param name="mvcRenderCommandName" value="/allertaer/verifica/compila"/>
				<portlet:param name="allertaId" value="<%=String.valueOf(id) %>"/>	
			</portlet:renderURL>

		
			<liferay-ui:icon message="Consulta" url="<%= compilaUrl.toString() %>"/>
		
  		</c:otherwise>
  	</c:choose>

	
</liferay-ui:icon-menu>