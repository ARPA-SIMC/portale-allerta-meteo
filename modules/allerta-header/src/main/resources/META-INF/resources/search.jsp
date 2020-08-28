<%@page import="it.eng.allerta.utils.AllertaTracker"%>
<%@page import="it.eng.allerta.utils.AllertaUtilsInterface" %>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.model.Group"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@ include file="./init.jsp"%>

<%
List<Group> favorities = new ArrayList();
try {
	AllertaUtilsInterface utils = AllertaTracker.getService(AllertaUtilsInterface.class);

	favorities = new ArrayList<Group>();
	if (themeDisplay.isSignedIn()) {
		favorities = utils.getUserFavorities(user);
	}
} catch (Exception e) {
	%><div><%=e.toString()%></div><%
}
%>
<portlet:resourceURL var="citiesURL">
	<portlet:param name="<%=Constants.CMD%>" value="get_comuni_emilia" />
</portlet:resourceURL>

<div style="display:none">
	<a href="#" data-trigger="api-url" data-value="${citiesURL }" 
		data-namespace="<portlet:namespace/>"></a>
</div>

<li class="nav-item"><a data-toggle="search" href="#search-menu"
	title="Mostra / nascondi lo strumento di ricerca dei comuni"
	class="d-block d-lg-none d-print-none"> <span
		class="icon i-search-comune" title="Cerca un comune"></span> <span
		class="sr-only">Cerca un comune</span>
</a>

	<div class="d-lg-block d-print-block search-menu" id="search-menu">

		<div class="search-menu__head">
			<div class="d-flex justify-content-between d-lg-none d-print-none">
				<label for="search-menu-box">Cosa succede nel tuo comune?</label> <a
					href="#search-menu" data-toggle="search" class="d-lg-none"><span
					class="icon i-times" title="Chiudi il box di ricerca"></span></a>
			</div>

			<div class="d-flex flex-row">
				<input type="text" id="search-menu-box" class="form-control"
					value="" placeholder="Cosa succede nel tuo comune?"
					aria-describedby="search-menu-box-message" autocomplete="off"
					data-trigger="search" data-results="#search-menu__results"
					data-islogged="1">
				<button class="btn btn-transparent">
					<span class="icon i-search-comune" title="Cerca comune"></span>
				</button>
			</div>
		</div>

		<!-- messaggio (screen reader only-->
		<small class="sr-only" id="search-menu-box-message" role="alert">Digita
			le iniziali del comune che vuoi cercare</small>

		<div id="search-menu__results" class="search-menu__results">
			<div class="search-menu__results__list"></div>
			<c:if test="<%=favorities.size() > 0 %>">
			
			<div class="search-menu__results__fav">
				<h4>I tuoi luoghi preferiti</h4>
				<c:forEach items="<%=favorities %>" var="g">
				<a class="search-menu__results__item" href="${g.getDisplayURL(themeDisplay) }"
					title="Vai a ${g.getName(locale) }">
					<div class="icon i-map-marker" aria-hidden="true"></div>
					<div>${g.getName(locale) }</div>
					<div class="icon i-heart u-favourite-icon" title="Luogo preferito"></div>
				</a> 
				</c:forEach>
			</div>
			
			</c:if>
		</div>
	</div></li>


