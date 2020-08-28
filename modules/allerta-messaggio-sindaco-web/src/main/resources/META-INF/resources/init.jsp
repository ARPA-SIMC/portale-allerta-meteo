<%@page import="it.eng.allerta.messaggio.sindaco.config.MessaggioSindacoConfiguration"%>
<%@page import="it.eng.allerta.messaggio.sindaco.bean.MessaggioBean"%>
<%@page import="it.eng.allerta.utils.AllertaTracker"%>
<%@page import="it.eng.allerter.allerta.utils.MessaggioService"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %><%@
taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
MessaggioService msgService = AllertaTracker.getService(MessaggioService.class);

MessaggioSindacoConfiguration sindacoConfiguration = 
	(MessaggioSindacoConfiguration) request.getAttribute(MessaggioSindacoConfiguration.class.getName());

%>