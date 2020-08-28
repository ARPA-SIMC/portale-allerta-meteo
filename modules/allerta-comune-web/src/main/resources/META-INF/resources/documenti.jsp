<%@ include file="./init.jsp" %>


<h3 class="mt-2 mb-3"><span class="icon i-doc-comune" aria-hidden="true"></span> Documenti del comune</h3>
<nav role="navigation" class="nav-vertical ">
	<ul class="nav flex-column">


		<li class="nav-item">
				
			<liferay-util:include page="/docs/tavole.jsp" servletContext="<%=getServletContext() %>">
				<liferay-util:param name="siteName"
					 value="<%=themeDisplay.getSiteGroup().getName()%>"></liferay-util:param>
			</liferay-util:include>
		</li>
			
		<li class="nav-item">
				
			<liferay-util:include page="/docs/piano_pc.jsp" servletContext="<%=getServletContext() %>">
				<liferay-util:param name="siteName"
					 value="<%=themeDisplay.getSiteGroup().getName()%>"></liferay-util:param>
			</liferay-util:include>
		</li>
	</ul>

</nav>
