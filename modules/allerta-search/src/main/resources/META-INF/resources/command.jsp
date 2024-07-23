<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="allerta.search.portlet.CommandContext"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<portlet:defineObjects />

<portlet:actionURL var="commandURL" name="/allertaer/search/command">
</portlet:actionURL>

<%
	String input = (String) portletSession.getAttribute("inputText");
	String output = (String) portletSession.getAttribute("outputText");
	if (input==null) input = "";
	if (output==null) output = "";
%>
<aui:form method="post" name="fmEsegui">
<div class="row">
			
				<div class="col-12">
			
				<c:if test="<%=SessionErrors.contains(request, Exception.class) %>">
			 		<div class="alert alert-danger" role="alert">
		    			<span class="icon i-error"></span> 
		    			<span><%= SessionErrors.get(request, Exception.class)%></span>
		  			</div>
				</c:if>		
				
				<liferay-ui:success key="saved" message="Comando riuscito" />
			
				</div>
			
			</div>

<div class="row">
	<div class="col col-10">
		<input name="inputText" id="inputText" type="text" value="<%=input %>" class="form-control" />
	</div>
	<div class="col col-2">
		<button type="button" onclick="submitFormX('<%=commandURL.toString()%>'); return false;" 
					class="btn btn-primary" style="margin: auto;" value="">Invia</button>
	</div>
</div>
<div class="row">
	<div class="col col-12">
		<p><%=output %></p>
	</div>
</div>
</aui:form>

<script type="text/javascript">

function submitFormX(actionUrl) {
	
	(function($) {

	document.forms.<portlet:namespace/>fmEsegui.action = actionUrl;
	
	document.forms.<portlet:namespace/>fmEsegui.submit();
	
	})(jQuery);	 
}

</script>