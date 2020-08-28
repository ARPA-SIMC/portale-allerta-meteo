<%@ include file="./init.jsp" %>

<h3 class="mt-2 mb-3"><span class="icon i-cartografia" aria-hidden="true"></span> Cartografia</h3>
<nav role="navigation" class="nav-vertical ">
    <ul class="nav flex-column">

			<li class="nav-item">
				
				<liferay-util:include page="/map/documenti_frane.jsp" servletContext="<%=getServletContext() %>">
					<liferay-util:param name="siteName"
						 value="<%=themeDisplay.getSiteGroup().getName()%>"></liferay-util:param>
				</liferay-util:include>
			</li>
			
			<li class="nav-item">
				<liferay-util:include page="/map/documenti_alluvioni.jsp" servletContext="<%=getServletContext() %>">
					<liferay-util:param name="siteName"
						 value="<%=themeDisplay.getSiteGroup().getName()%>"></liferay-util:param>
				</liferay-util:include>
			</li>
           
            <li class="nav-item">
				<liferay-util:include page="/map/documenti_rischio_alluvioni.jsp" servletContext="<%=getServletContext() %>">
					<liferay-util:param name="siteName"
						 value="<%=themeDisplay.getSiteGroup().getName()%>"></liferay-util:param>
				</liferay-util:include>
			</li>
        
    </ul>

</nav>
