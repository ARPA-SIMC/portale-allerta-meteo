<%@page import="allerta.search.objects.searchables.SearchFactory"%>
<%@page import="allerta.search.objects.Searchable"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%@ page import="allerta.search.portlet.SearchPortletConfig" %>


<%
	SearchPortletConfig cf = 
		portletDisplay.getPortletInstanceConfiguration(SearchPortletConfig.class);

	Searchable searchable = SearchFactory.getSearchable(cf.oggetto());
%>