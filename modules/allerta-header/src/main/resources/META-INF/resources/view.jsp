<%@ include file="./init.jsp"%>


<ul class="navbar-nav flex-row align-items-center header__personal-nav">
	
	<jsp:include page="search.jsp"></jsp:include>
	
	<c:choose>
		<c:when test="<%=themeDisplay.isSignedIn()%>">
			<jsp:include page="logged.jsp"></jsp:include>
		</c:when>
		<c:otherwise>
			<jsp:include page="not-logged.jsp"></jsp:include>
		</c:otherwise>
	</c:choose>

</ul>