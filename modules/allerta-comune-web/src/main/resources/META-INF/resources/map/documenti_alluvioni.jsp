<%@page import="it.eng.allerter.allerta.FolderToView"%>
<%@page import="it.eng.allerter.allerta.DocumentModelBean"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="../init.jsp"%>

<%

String sitename = ParamUtil.getString(request, "siteName");
DocumentModelBean docBean = new DocumentModelBean( themeDisplay);
List<FolderToView> documents = docBean.getFileForAlluvioni( sitename);

%>

<a 	class="nav-link " 
	href="#pericolosita-alluvioni__sub"  
	data-toggle="collapse"
	role="button" 
	aria-expanded="false"
	aria-controls="pericolosita-alluvioni__sub"> 
	
	<span class="icon i-plus-square-o" title="Espandi/richiudi"></span> 
	<span class="nav-vertical__item-label">
		Pericolosit&agrave; alluvioni
	</span>
</a>

<ul class="list-unstyled collapse" id="pericolosita-alluvioni__sub">
	<% for( FolderToView file : documents) { %>
		<li class="nav-item">
			<a class="nav-link " href="<%=file.getUrl()%>" data-toggle="pdf-viewer"> 
				<span class="icon i-file-pdf-o" title="File PDF"></span> 
				<span class="nav-vertical__item-label"><%=file.getTitle() %></span>
			</a>
		</li>
	<%} %>
</ul>