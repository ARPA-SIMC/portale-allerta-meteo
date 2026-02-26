<%@page import="it.eng.allerter.allerta.FolderToView"%>
<%@page import="it.eng.allerter.allerta.DocumentModelBean"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ include file="../init.jsp"%>


<%

String sitename = ParamUtil.getString(request, "siteName");
DocumentModelBean docBean = new DocumentModelBean( themeDisplay);
List<FolderToView> documents = docBean.getTavoleDocuments(sitename);

%>


<a 	class="nav-link " 
	href="#tavole__sub"  
	data-toggle="collapse"
	role="button" 
	aria-expanded="false"
	aria-controls="rischio-alluvioni__sub"> 
	
	<span class="icon i-plus-square-o" title="<liferay-ui:message key="allertacomuneweb.d4" />"></span> 
	<span class="nav-vertical__item-label">
		<liferay-ui:message key="allertacomuneweb.d2" />
	</span>
</a>

<ul class="list-unstyled collapse" id="tavole__sub">
	<% for( FolderToView file : documents) { %>
		<li class="nav-item">
			<a class="nav-link " href="<%=file.getUrl()%>" data-toggle="pdf-viewer"> 
				<span class="icon i-file-pdf-o" title="<liferay-ui:message key="allertacomuneweb.d5" />"></span> 
				<span class="nav-vertical__item-label"><%=file.getTitle() %></span>
			</a>
		</li>
	<%} %>
</ul>